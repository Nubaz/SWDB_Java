package characters;

import enums.JediSithRank;
import enums.StarWarsEra;
import enums.ForceUserType;
import misc.BadRankExp;
import sys.jdbc.UpdateDB;
import sys.logs.Log;
import weapons.Lightsaber;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediSith extends ForceUser {
    private ForceUserType type;
    private JediSithRank rank;
    private Lightsaber lightsaber;
    private final UpdateDB udb = UpdateDB.getInstance();

    //basic constructors
    public JediSith() {
    }

    public JediSith(String name, String planet, Integer year, StarWarsEra era, Integer yrs_practice, boolean permadeath,
                    ForceUserType type, JediSithRank rank) throws BadRankExp {
        super(name, planet, year, era, yrs_practice, permadeath);
        this.type = type;
        this.rank = rank;
        verifyRank();

        calculateBounty2();
    }

    //verify rank
    private void verifyRank() throws BadRankExp {
        Pattern p;
        Matcher m;

        if(type == ForceUserType.Jedi){
            p = Pattern.compile("^[S]");
            m = p.matcher(rank.name());
            if(m.find())
                throw new BadRankExp("Jedi types can't have Sith ranks");
        }
        else {
            p = Pattern.compile("^[J]");
            m = p.matcher(rank.name());
            if(m.find())
                throw new BadRankExp("Sith types can't have Jedi ranks");
        }
    }

    //bounty calculator
    protected void calculateBounty2() {
        this.bounty *= type.factor;
        this.bounty *= rank.factor;
    }

    @Override
    public void showBountyCalculation() throws IOException {
        Log l = Log.getInstance();

        l.log("Showing bounty calculation for " + this.getClass() + ":" + this.getName());
        System.out.println("Bounty calculation:\n" +
                "Years of practice: " + yrs_practice + "\n" +
                "Type factor: " + type.name() + ", " + type.factor + "\n" +
                "Rank factor: " + rank.name + ", " + rank.factor + "\n" +
                "Credits: " + credits + "\n" +
                "Bounty = " + yrs_practice + " * " + type.factor + " * " + rank.factor + " * " +
                credits + " = " + String.format("%,.2f",bounty));
    }

    //getters and setters
    public ForceUserType getType() {
        return type;
    }

    public void setType(ForceUserType type) throws IOException {
        Log l = Log.getInstance();

        l.log("Updating jedi/sith " + this.getName() + " from " +
                this.getType() + " to " + type.name());
        udb.update("jedisith","JSType",
                "\"" + type + "\"",this.getName());
        this.type = type;
    }

    public JediSithRank getRank() {
        return rank;
    }

    public void setRank(JediSithRank rank) throws IOException {
        Log l = Log.getInstance();

        l.log("Updating jedi/sith " + this.getName() + " from " +
                this.getRank().name + " to " + rank.name);
        udb.update("jedisith","JSRank",
                "\"" + rank + "\"",this.getName());
        this.rank = rank;
        calculateBounty();
    }

    public Lightsaber getLightsaber() {
        return lightsaber;
    }

    public void setLightsaber(Lightsaber lightsaber) {
        this.lightsaber = lightsaber;
    }

    @Override
    public String toString() {
        if(lightsaber == null)
            return super.toString() + "\n" +
                    "Type: " + type + "\n" +
                    "Rank: " + rank.name + "\n" +
                    "Bounty: " + String.format("%,.2f",bounty) + " credits" + "\n";
        else
            return super.toString() + "\n" +
                    "Type: " + type + "\n" +
                    "Rank: " + rank.name + "\n" +
                    lightsaber + "\n" +
                    "Bounty: " + String.format("%,.2f",bounty) + " credits" + "\n";
    }
}

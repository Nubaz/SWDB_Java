package characters;

import enums.JediSithRank;
import enums.StarWarsEra;
import enums.ForceUserType;
import misc.BadRankExp;
import weapons.Lightsaber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediSith extends ForceUser {
    private ForceUserType type;
    private JediSithRank rank;
    private Lightsaber lightsaber;

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

    public JediSith(String name, String planet, Integer year, StarWarsEra era, Integer yrs_practice, boolean permadeath,
                    ForceUserType type, JediSithRank rank, Lightsaber lightsaber) throws BadRankExp {
        super(name, planet, year, era, yrs_practice, permadeath);
        this.type = type;
        this.rank = rank;
        verifyRank();
        this.lightsaber = lightsaber;

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
    public void showBountyCalculation() {
        System.out.println("Bounty calculation:\n" +
                "Years of practice: " + yrs_practice + "\n" +
                "Type factor: " + type.name() + ", " + type.factor + "\n" +
                "Rank factor: " + rank.name + ", " + rank.factor + "\n" +
                "Credits: " + credits + "\n" +
                "Bounty = " + yrs_practice + " * " + type.factor + " * " + rank.factor + " * " +
                credits + " = " + bounty);
    }

    //getters and setters
    public ForceUserType getType() {
        return type;
    }

    public void setType(ForceUserType type) {
        this.type = type;
    }

    public JediSithRank getRank() {
        return rank;
    }

    public void setRank(JediSithRank rank) {
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
                    "Bounty: " + bounty + " credits" + "\n";
        else
            return super.toString() + "\n" +
                    "Type: " + type + "\n" +
                    "Rank: " + rank.name + "\n" +
                    lightsaber + "\n" +
                    "Bounty: " + bounty + " credits" + "\n";
    }
}

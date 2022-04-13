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
                    ForceUserType type, JediSithRank rank, Lightsaber lightsaber) throws BadRankExp {
        super(name, planet, year, era, yrs_practice, permadeath);
        this.type = type;
        this.rank = rank;
        verifyRank();
        this.lightsaber = lightsaber;

        calculateBounty();
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
//    @Override
//    protected void calculateBounty() {
//        this.bounty = (double) (yrs_practice * credits);
//        this.bounty += this.bounty * type.factor;
//        this.bounty += this.bounty * rank.factor;
//    }

    //getters and setters
    public Object getRank() {
        return rank;
    }

    public void setRank(JediSithRank rank) {
        this.rank = rank;
    }

    public String getLightsaber() {
        return lightsaber.toString();
    }

    public void setLightsaber(Lightsaber lightsaber) {
        this.lightsaber = lightsaber;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Type: " + type + "\n" +
                "Rank: " + rank.name + "\n" +
                lightsaber + "\n" +
                "Bounty: " + bounty + " credits";
    }
}

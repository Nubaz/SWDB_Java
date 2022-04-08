package characters;

import enums.StarWarsEra;
import enums.ForceUserType;
import weapons.Lightsaber;

public class JediSith extends ForceUser {
    private ForceUserType type;
    private String rank;
    private Lightsaber lightsaber;

    //basic constructors
    public JediSith() {
    }

    public JediSith(String name, String planet, Integer year, StarWarsEra era, Integer yrs_practice, boolean permadeath,
                    ForceUserType type, String rank) {
        super(name, planet, year, era, yrs_practice, permadeath);
        this.type = type;
        this.rank = rank;
    }

    public JediSith(String name, String planet, Integer year, StarWarsEra era, Integer yrs_practice, boolean permadeath,
                    ForceUserType type, String rank, Lightsaber lightsaber) {
        super(name, planet, year, era, yrs_practice, permadeath);
        this.type = type;
        this.rank = rank;
        this.lightsaber = lightsaber;
    }

    //getters and setters
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
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
                "Rank: " + rank + "\n" + lightsaber;
    }
}

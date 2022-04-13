package characters;

import enums.StarWarsEra;

public class ForceUser extends Character {
    protected Integer yrs_practice;
    protected boolean permadeath;

    //basic constructors
    public ForceUser() {
    }

    public ForceUser(String name, String planet, Integer year, StarWarsEra era, Integer yrs_practice, boolean permadeath) {
        super(name, planet, year, era);
        occupation = "Force User";

        this.yrs_practice = yrs_practice;
        this.permadeath = permadeath;

        calculateBounty();
    }

    //bounty calculator
    @Override
    protected void calculateBounty() {
        this.bounty = (double) (yrs_practice * credits);
    }

    //getters and setters
    public void setYrs_practice(Integer yrs_practice) {
        this.yrs_practice = yrs_practice;
    }

    public Integer getYrs_practice() {
        return yrs_practice;
    }

    public boolean isPermadeath() {
        return permadeath;
    }

    public void setPermadeath(boolean permadeath) {
        this.permadeath = permadeath;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Years of practice: " + yrs_practice + "\n" +
                "Can live after death: " + permadeath;
    }
}

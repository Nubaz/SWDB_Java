package characters;

import enums.StarWarsEra;
import sys.logs.Log;

import java.io.IOException;

public class ForceUser extends Character {
    protected Integer yrs_practice;
    protected boolean permadeath;

    //basic constructors
    public ForceUser() {
        occupation = "Force User";
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
    @Override
    public void showBountyCalculation() throws IOException {
        Log l = Log.getInstance();

        l.log("Showing bounty calculation for " + this.getClass() + ":" + this.getName());
        System.out.println("Bounty calculation:\n" +
                "Years of practice: " + yrs_practice + "\n" +
                "Credits: " + credits + "\n" +
                "Bounty = " + yrs_practice + " * " + credits + " = " + String.format("%,.2f",bounty));
    }

    //getters and setters
    public void setYrs_practice(Integer yrs_practice) {
        this.yrs_practice = yrs_practice;
        calculateBounty();
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
                "Can live in the Force after death: " + !permadeath + "\n";
    }
}

package characters;

import enums.StarWarsEra;
import sys.logs.Log;
import weapons.Blaster;

import java.io.IOException;

public class BountyHunter extends Character {
    private Integer contracts_done;
    private Integer min_credits_contract;
    private Blaster weapon;

    //basic constructors
    public BountyHunter() {
        occupation = "Bounty Hunter";
    }

    public BountyHunter(String name, String planet, Integer year, StarWarsEra era, Integer contracts_done, Integer min_credits_contract) {
        super(name, planet, year, era);
        occupation = "Bounty Hunter";
        this.contracts_done = contracts_done;
        this.min_credits_contract = min_credits_contract;

        calculateBounty();
    }

    //bounty calculator
    @Override
    protected void calculateBounty() {
        this.bounty = (double) contracts_done * credits;
    }
    @Override
    public void showBountyCalculation() throws IOException {
        Log.log("Showing bounty calculation for " + this.getClass() + ":" + this.getName());
        System.out.println("Bounty calculation:\n" +
                "Contracts done: " + contracts_done + "\n" +
                "Bounty = " + contracts_done + " * " + credits + " = " + String.format("%,.2f",bounty));
    };

    //getters and setters
    public Integer getContracts_done() {
        return contracts_done;
    }

    public void setContracts_done(Integer contracts_done) {
        this.contracts_done = contracts_done;
    }

    public Integer getMin_credits_contract() {
        return min_credits_contract;
    }

    public void setMin_credits_contract(Integer min_credits_contract) {
        this.min_credits_contract = min_credits_contract;
    }

    public Blaster getWeapon() {
        return weapon;
    }

    public void setWeapon(Blaster weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        if(weapon == null)
            return super.toString() + "\n" +
                    "Contracts fulfilled: " + contracts_done + "\n" +
                    "Minimum credits per target: " + min_credits_contract + "\n" +
                    "Bounty: " + String.format("%,.2f",bounty) + " credits" + "\n";
        else
            return super.toString() + "\n" +
                    "Contracts fulfilled: " + contracts_done + "\n" +
                    "Minimum credits per target: " + min_credits_contract + "\n" +
                    weapon + "\n" +
                    "Bounty: " + String.format("%,.2f",bounty) + " credits" + "\n";
    }
}

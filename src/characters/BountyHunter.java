package characters;

import enums.StarWarsEra;
import weapons.Blaster;

public class BountyHunter extends Character {
    private Integer contracts;
    private Integer min_credits;
    private Blaster weapon;

    //basic constructors
    public BountyHunter() {
    }

    public BountyHunter(String name, String planet, Integer year, StarWarsEra era, Integer contracts,
                        Integer min_credits_per_target) {
        super(name, planet, year, era);
        occupation = "Bounty Hunter";

        this.contracts = contracts;
        this.min_credits = min_credits_per_target;
    }

    public BountyHunter(String name, String planet, Integer year, StarWarsEra era, Integer contracts, Integer min_credits,
                        String bname, String type, Integer shots, Double cooldown) {
        super(name, planet, year, era);
        this.contracts = contracts;
        this.min_credits = min_credits;
        weapon = new Blaster(bname,type,shots,cooldown);
    }

    //getters and setters
    public Integer getContracts() {
        return contracts;
    }

    public void setContracts(Integer contracts) {
        this.contracts = contracts;
    }

    public Integer getMin_credits() {
        return min_credits;
    }

    public void setMin_credits(Integer min_credits) {
        this.min_credits = min_credits;
    }

    public String getWeapon() {
        return weapon.toString();
    }

    public void setWeapon(Blaster weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Contracts fulfilled: " + contracts + "\n" +
                "Minimum credits per target: " + min_credits + "\n" + weapon;
    }
}

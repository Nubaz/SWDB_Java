package characters;

import enums.StarWarsEra;
import weapons.Blaster;

public class Smuggler extends Character {
    private Integer shipments_nr;
    private Integer parsecs_travelled;
    private Blaster weapon;

    //basic constructors
    public Smuggler() {
        occupation = "Smuggler";
    }

    public Smuggler(String name, String planet, Integer year, StarWarsEra era, Integer shipments_nr, Integer parsecs_travelled) {
        super(name, planet, year, era);
        occupation = "Smuggler";
        this.shipments_nr = shipments_nr;
        this.parsecs_travelled = parsecs_travelled;

        calculateBounty();
    }

    public Smuggler(String name, String planet, Integer year, StarWarsEra era, Integer shipments_nr,
                    Integer parsecs_travelled, Blaster weapon) {
        super(name, planet, year, era);
        occupation = "Smuggler";
        this.shipments_nr = shipments_nr;
        this.parsecs_travelled = parsecs_travelled;
        this.weapon = weapon;

        calculateBounty();
    }

    //bounty calculator
    @Override
    protected void calculateBounty() {
        this.bounty = (double) shipments_nr * 0.5 * parsecs_travelled * credits;
    }
    @Override
    public void showBountyCalculation() {
        System.out.println(
                "Bounty calculation:\n" +
                "Shipments delivered: " + shipments_nr + "\n" +
                "Parsecs travelled: " + parsecs_travelled + "\n" +
                "Bounty = " + shipments_nr + " * 0.5 * " + parsecs_travelled + " * " + credits + " = " + bounty
        );
    }

    //getters and setters
    public Integer getShipments_nr() {
        return shipments_nr;
    }

    public void setShipments_nr(Integer shipments_nr) {
        this.shipments_nr = shipments_nr;
        calculateBounty();
    }

    public Integer getParsecs_travelled() {
        return parsecs_travelled;
    }

    public void setParsecs_travelled(Integer parsecs_travelled) {
        this.parsecs_travelled = parsecs_travelled;
        calculateBounty();
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
                    "Shipments delivered: " + shipments_nr + "\n" +
                    "Parsecs travelled: " + parsecs_travelled + "\n" +
                    "Bounty: " + bounty + " credits" + "\n";
        else
            return super.toString() + "\n" +
                    "Shipments delivered: " + shipments_nr + "\n" +
                    "Parsecs travelled: " + parsecs_travelled + "\n" +
                    weapon + "\n" +
                    "Bounty: " + bounty + " credits" + "\n";
    }
}

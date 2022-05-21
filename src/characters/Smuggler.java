package characters;

import enums.StarWarsEra;
import sys.jdbc.UpdateDB;
import sys.logs.Log;
import weapons.Blaster;

import java.io.IOException;

public class Smuggler extends Character {
    private Integer shipments_nr;
    private Integer parsecs_travelled;
    private Blaster weapon;
    private final UpdateDB udb = UpdateDB.getInstance();

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

    //bounty calculator
    @Override
    protected void calculateBounty() {
        this.bounty = (double) shipments_nr * 0.5 * parsecs_travelled * credits;
    }
    @Override
    public void showBountyCalculation() throws IOException {
        Log l = Log.getInstance();

        l.log("Showing bounty calculation for " + this.getClass() + ":" + this.getName());
        System.out.println(
                "Bounty calculation:\n" +
                "Shipments delivered: " + shipments_nr + "\n" +
                "Parsecs travelled: " + parsecs_travelled + "\n" +
                "Bounty = " + shipments_nr + " * 0.5 * " + parsecs_travelled + " * " + credits + " = " + String.format("%,.2f",bounty)
        );
    }

    //getters and setters
    public Integer getShipments_nr() {
        return shipments_nr;
    }

    public void setShipments_nr(Integer shipments_nr) throws IOException {
        Log l = Log.getInstance();

        l.log("Updating smuggler " + this.getName() + " from " +
                this.getShipments_nr() + " shipments delivered to " +
                shipments_nr + " shipments delivered");
        udb.update("smuggler","Shipments_nr",shipments_nr.toString(),this.getName());
        this.shipments_nr = shipments_nr;
        calculateBounty();
    }

    public Integer getParsecs_travelled() {
        return parsecs_travelled;
    }

    public void setParsecs_travelled(Integer parsecs_travelled) throws IOException {
        Log l = Log.getInstance();

        l.log("Updating smuggler " + this.getName() + " from " +
                this.getParsecs_travelled() + " parsecs travelled to " +
                parsecs_travelled + " parsecs travelled");
        udb.update("smuggler","Parsecs_travelled",parsecs_travelled.toString(),this.getName());
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
                    "Bounty: " + String.format("%,.2f",bounty) + " credits" + "\n";
        else
            return super.toString() + "\n" +
                    "Shipments delivered: " + shipments_nr + "\n" +
                    "Parsecs travelled: " + parsecs_travelled + "\n" +
                    weapon + "\n" +
                    "Bounty: " + String.format("%,.2f",bounty) + " credits" + "\n";
    }
}

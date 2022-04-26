package characters;
import enums.StarWarsEra;
import misc.SWDate;

public abstract class Character {
    protected String name;
    protected String planet;
    protected SWDate born = new SWDate();

    protected String occupation;
    protected Double bounty;

    //fixed nr of credits for bounty calculation
    protected final Integer credits = 2500;

    //basic constructors
    public Character() {
    }

    public Character(String name, String planet, Integer year, StarWarsEra era) {
        this.name = name;
        this.planet = planet;
        born.setYear(year);
        born.setEra(era);
    }

    //bounty calculator
    protected abstract void calculateBounty();
    public abstract void showBountyCalculation();

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public SWDate getBorn() {
        return born;
    }

    public void setBorn(SWDate born) {
        this.born = born;
    }

    public Integer getCredits() {
        return credits;
    }

    public Double getBounty() {
        return bounty;
    }

    public String getOccupation() {
        return occupation;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Planet: " + planet + "\n" +
                "Date of birth: " + born.toString() + "\n" +
                "Occupation: " + occupation;
    }
}

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

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Planet: " + planet + "\n" +
                "Date of birth: " + born.toString() + "\n" +
                "Occupation: " + occupation;
    }
}

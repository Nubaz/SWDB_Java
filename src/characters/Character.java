package characters;
import enums.StarWarsEra;
import misc.SWDate;

public abstract class Character {
    protected String name;
    protected String planet;
    protected SWDate born = new SWDate();
    protected String occupation;

    public Character() {
    }

    public Character(String name, String planet, Integer year, StarWarsEra era) {
        this.name = name;
        this.planet = planet;
        born.setYear(year);
        born.setEra(era);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Planet: " + planet + "\n" +
                "Date of birth: " + born.toString() + "\n" +
                "Occupation: " + occupation;
    }
}

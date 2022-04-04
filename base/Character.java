package base;
import misc.Exp;
import misc.SWDate;

public class Character {
    protected String name;
    protected String planet;
    protected SWDate born = new SWDate();

    public Character() {
    }

    public Character(String name, String planet, Integer year, String era) throws Exp {
        this.name = name;
        this.planet = planet;
        born.setYear(year);
        born.setEra(era);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Planet: " + planet + "\n" +
                "Date of birth: " + born.toString();
    }
}

package enums;

public enum JediSithRank {
    JYoungling(0.1,"Jedi Youngling"), JPadawan(0.25,"Jedi Padawan"),
    JKnight(0.5, "Jedi Knight"), JMaster(1, "Jedi Master"),
    JCouncilor(2, "Jedi Councilor"), JGrandMaster(3,"Jedi Grand Master"),
    SLord(1,"Sith Lord"), SDarth(2,"Darth"), SEmperor(3,"Emperor");

    public final Double factor;
    public final String name;

    JediSithRank(double factor, String name) {
        this.factor = factor;
        this.name = name;
    }
}

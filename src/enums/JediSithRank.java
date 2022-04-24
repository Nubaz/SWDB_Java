package enums;

public enum JediSithRank {
    JYoungling(1.1,"Jedi Youngling"), JPadawan(1.25,"Jedi Padawan"),
    JKnight(1.5, "Jedi Knight"), JMaster(2, "Jedi Master"),
    JCouncilor(3, "Jedi Councilor"), JGrandMaster(4,"Jedi Grand Master"),
    SLord(2,"Sith Lord"), SDarth(3,"Darth"), SEmperor(4,"Emperor");

    public final Double factor;
    public final String name;

    JediSithRank(double factor, String name) {
        this.factor = factor;
        this.name = name;
    }
}

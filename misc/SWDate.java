package misc;

import java.util.Locale;

public class SWDate {
    private Integer year;
    private String era;

    public SWDate() {
    }

    public SWDate(Integer year, String era) throws Exp {
        if(year < 0)
            throw new Exp("Invalid year!");
        else
            this.year = year;
        if(era.toLowerCase(Locale.ROOT).equals("aby") || era.toLowerCase(Locale.ROOT).equals("bby"))
            this.era = era.toUpperCase(Locale.ROOT);
        else
            throw new Exp("Invalid era for year!");
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) throws Exp {
        if(year < 0)
            throw new Exp("Invalid year!");
        else
            this.year = year;
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) throws Exp {
        if(era.toLowerCase(Locale.ROOT).equals("aby") || era.toLowerCase(Locale.ROOT).equals("bby"))
            this.era = era.toUpperCase(Locale.ROOT);
        else
            throw new Exp("Invalid era for year!");
    }

    @Override
    public String toString() {
        return year + " " + era;
    }
}

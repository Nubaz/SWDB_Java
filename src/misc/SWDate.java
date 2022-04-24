package misc;

import enums.StarWarsEra;

import java.util.Locale;

public class SWDate {
    private Integer year;
    private StarWarsEra era;

    //basic constructors
    public SWDate() {
    }

    public SWDate(Integer year, StarWarsEra era) {
        this.year = year;
        this.era = era;
    }

    //getters and setters
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public StarWarsEra getEra() {
        return era;
    }

    public void setEra(StarWarsEra era) {
        this.era = era;
    }

    @Override
    public String toString() {
        return year + " " + era;
    }
}

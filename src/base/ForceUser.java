package base;

import misc.Exp;

public class ForceUser extends Character {
    private Integer yrs_practice;
    private boolean permadeath;

    public ForceUser(String name, String planet, Integer year, String era) throws Exp {
        super(name, planet, year, era);
    }

    public ForceUser(String name, String planet, Integer year, String era, Integer yrs_practice, boolean permadeath) throws Exp {
        super(name, planet, year, era);
        if(yrs_practice < 0)
            throw new Exp("Invalid years of practice!");
        else
            this.yrs_practice = yrs_practice;
        this.permadeath = permadeath;
    }

    public Integer getYrs_practice() {
        return yrs_practice;
    }

    public void setYrs_practice(Integer yrs_practice) throws Exp {
        if(yrs_practice < 0)
            throw new Exp("Invalid years of practice!");
        else
            this.yrs_practice = yrs_practice;
    }

    public boolean isPermadeath() {
        return permadeath;
    }

    public void setPermadeath(boolean permadeath) {
        this.permadeath = permadeath;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Years of practice: " + yrs_practice + "\n" +
                "Can live in the Force: " + permadeath;
    }
}

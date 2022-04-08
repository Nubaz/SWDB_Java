package sys;

import characters.*;
import enums.ForceUserType;
import enums.StarWarsEra;
import weapons.*;

public class Main {
    public static void main(String[] args) {
        Blaster bb = new Blaster("name","type",20, 23.244);
        Lightsaber ll = new Lightsaber("red","dual","hilt");

        ForceUser f = new JediSith("Anakin Skywlaker","Totooine",20, StarWarsEra.BBY,23,
                true, ForceUserType.Jedi,"knight", ll);
        System.out.println(f);
    }
}

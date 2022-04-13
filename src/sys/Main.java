package sys;

import characters.*;
import enums.ForceUserType;
import enums.JediSithRank;
import enums.StarWarsEra;
import misc.BadRankExp;
import weapons.*;

public class Main {
    public static void main(String[] args) {
        try {
            Lightsaber ll = new Lightsaber("red","dual","hilt");

            ForceUser f = new JediSith("Anakin Skywlaker","Totooine",20, StarWarsEra.BBY,23,
                    true, ForceUserType.Sith, JediSithRank.SDarth, ll);
            System.out.println(f);
        } catch (BadRankExp e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

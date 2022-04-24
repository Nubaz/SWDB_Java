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
            Blaster bb = new Blaster("blastrname","rifle",30,23.22);

            ForceUser f = new JediSith("Anakin Skywlaker","Totooine",20, StarWarsEra.BBY,23,
                    true, ForceUserType.Jedi, JediSithRank.JGrandMaster, ll);
            System.out.println(f + "\n");

            BountyHunter b = new BountyHunter("Boba Fett", "Kamino", 34, StarWarsEra.BBY, 200,
                    50000,bb);
            System.out.println(b);
        } catch (BadRankExp e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

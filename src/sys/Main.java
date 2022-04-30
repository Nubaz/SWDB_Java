package sys;

import characters.*;
import enums.ForceUserType;
import enums.JediSithRank;
import enums.StarWarsEra;
import misc.BadRankExp;
import sys.serv.BountyHunterService;
import sys.serv.JediSithService;
import weapons.*;

public class Main {
    public static void main(String[] args) throws BadRankExp {
        //testing
        JediSithService s = new JediSithService();
        JediSith j1 = new JediSith("name","planet",23,StarWarsEra.BBY,23,true,ForceUserType.Jedi,JediSithRank.JGrandMaster);
        JediSith j2 = new JediSith("name2","planet2",23,StarWarsEra.BBY,23,true,ForceUserType.Jedi,JediSithRank.JGrandMaster);
        JediSith j3 = new JediSith("name3","planet3",23,StarWarsEra.BBY,23,true,ForceUserType.Jedi,JediSithRank.JGrandMaster);
        JediSith s1 = new JediSith("name12","planet23",23,StarWarsEra.BBY,23,true,ForceUserType.Sith,JediSithRank.SDarth);
        JediSith s2 = new JediSith("name23","planet32",23,StarWarsEra.BBY,23,true,ForceUserType.Sith,JediSithRank.SEmperor);

        Lightsaber l = new Lightsaber("red","dual","hilt");
        Lightsaber l1 = new Lightsaber("green","standard","hilt3");
        Lightsaber l2 = new Lightsaber("blue","twin","hilt2");
        Lightsaber l3 = new Lightsaber("blue","twin","hilt2");

        s.addJS(j1);
        s.addJS(j2);
        s.addJS(j3);
        s.addJS(s1);
        s.addJS(s2);

        s.addLightsaber(l1,2);
        s.addLightsaber(l1,3);
        s.addLightsaber(l2,3);
        s.replaceOwner(l3, j3);

        //s.listSith();
        s.listMap();
    }
}

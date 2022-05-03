package sys;

import characters.BountyHunter;
import characters.ForceUser;
import characters.JediSith;
import characters.Smuggler;
import enums.*;
import misc.BadRankExp;
import weapons.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read {
    private static final Read rw_csv = null;

    private Read() {
    }

    public static Read getInstance() {
        return rw_csv;
    }

    private static void blasters(Service s) throws FileNotFoundException {
        File f = new File("src/sys/data/blasters.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(";");
        while(sc.hasNext()) {
            s.bserv.addB(new Blaster(
                    sc.next(),
                    sc.next(),
                    sc.nextInt(),
                    sc.nextDouble()));
        }
        sc.close();
    }
    private static void lightsabers(Service s) throws FileNotFoundException {
        File f = new File("src/sys/data/lightsabers.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(";");
        while(sc.hasNext()) {
            s.lserv.addL(new Lightsaber(
                    sc.next(),
                    sc.next(),
                    sc.next()));
        }
        sc.close();
    }


    private static void bhunters(Service s) throws FileNotFoundException {
        File f = new File("src/sys/data/bhunters.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(";");
        while(sc.hasNext()) {
            s.bhserv.addBH(new BountyHunter(
                    sc.next(),
                    sc.next(),
                    sc.nextInt(),
                    StarWarsEra.valueOf(sc.next()),
                    sc.nextInt(),
                    sc.nextInt()));
        }
        sc.close();
    }
    private static void forceusers(Service s) throws FileNotFoundException {
        File f = new File("src/sys/data/forceusers.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(";");
        while(sc.hasNext()) {
            s.fuserv.addFU(new ForceUser(
                    sc.next(),
                    sc.next(),
                    sc.nextInt(),
                    StarWarsEra.valueOf(sc.next()),
                    sc.nextInt(),
                    sc.nextBoolean()
            ));
        }
        sc.close();
    }
    private static void jedisiths(Service s) throws FileNotFoundException, BadRankExp {
        File f = new File("src/sys/data/jedisiths.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(";");
        while(sc.hasNext()) {
            s.jsserv.addJS(new JediSith(
                    sc.next(),
                    sc.next(),
                    sc.nextInt(),
                    StarWarsEra.valueOf(sc.next()),
                    sc.nextInt(),
                    sc.nextBoolean(),
                    ForceUserType.valueOf(sc.next()),
                    JediSithRank.valueOf(sc.next())
            ));
        }
        sc.close();
    }
    private static void smugglers(Service s) throws FileNotFoundException {
        File f = new File("src/sys/data/smugglers.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(";");
        while(sc.hasNext()) {
            s.sserv.addS(new Smuggler(
                    sc.next(),
                    sc.next(),
                    sc.nextInt(),
                    StarWarsEra.valueOf(sc.next()),
                    sc.nextInt(),
                    sc.nextInt()
            ));
        }
        sc.close();
    }

    protected static void loadFiles(Service s) throws FileNotFoundException, BadRankExp {
        blasters(s);
        lightsabers(s);

        bhunters(s);
        forceusers(s);
        jedisiths(s);
        smugglers(s);
    }
}
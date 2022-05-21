package sys.csv;

import characters.BountyHunter;
import characters.ForceUser;
import characters.JediSith;
import characters.Smuggler;
import enums.*;
import misc.BadRankExp;
import sys.Service;
import sys.logs.Log;
import weapons.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadCsv {
    private static ReadCsv rcsv = null;

    private ReadCsv() {
    }

    public static ReadCsv getInstance() {
        if(rcsv == null)
            rcsv = new ReadCsv();
        return rcsv;
    }

    private void blasters(Service s) throws IOException {
        File f = new File("src/sys/data/blasters.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(";");
        while(sc.hasNext()) {
            s.bserv.addB(new Blaster(
                    sc.next().strip(),
                    sc.next(),
                    sc.nextInt(),
                    sc.nextDouble()), true);
        }
        sc.close();
    }
    private void lightsabers(Service s) throws IOException {
        File f = new File("src/sys/data/lightsabers.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(",");
        while(sc.hasNext()) {
            s.lserv.addL(new Lightsaber(
                    sc.next().strip(),
                    sc.next(),
                    sc.next()), true);
        }
        sc.close();
    }


    private void bhunters(Service s) throws IOException {
        File f = new File("src/sys/data/bhunters.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(",");
        while(sc.hasNext()) {
            s.bhserv.addBH(new BountyHunter(
                    sc.next().strip(),
                    sc.next(),
                    sc.nextInt(),
                    StarWarsEra.valueOf(sc.next()),
                    sc.nextInt(),
                    sc.nextInt()), true);
        }
        sc.close();
    }
    private void forceusers(Service s) throws IOException {
        File f = new File("src/sys/data/forceusers.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(",");
        while(sc.hasNext()) {
            s.fuserv.addFU(new ForceUser(
                    sc.next().strip(),
                    sc.next(),
                    sc.nextInt(),
                    StarWarsEra.valueOf(sc.next()),
                    sc.nextInt(),
                    sc.nextBoolean()
            ), true);
        }
        sc.close();
    }
    private void jedisiths(Service s) throws IOException, BadRankExp {
        File f = new File("src/sys/data/jedisiths.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(",");
        while(sc.hasNext()) {
            s.jsserv.addJS(new JediSith(
                    sc.next().strip(),
                    sc.next(),
                    sc.nextInt(),
                    StarWarsEra.valueOf(sc.next()),
                    sc.nextInt(),
                    sc.nextBoolean(),
                    ForceUserType.valueOf(sc.next()),
                    JediSithRank.valueOf(sc.next())
            ), true);
        }
        sc.close();
    }
    private void smugglers(Service s) throws IOException {
        File f = new File("src/sys/data/smugglers.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(",");
        while(sc.hasNext()) {
            s.sserv.addS(new Smuggler(
                    sc.next().strip(),
                    sc.next(),
                    sc.nextInt(),
                    StarWarsEra.valueOf(sc.next()),
                    sc.nextInt(),
                    sc.nextInt()
            ), true);
        }
        sc.close();
    }

    public void loadFiles(Service s) throws IOException, BadRankExp {
        Log l = Log.getInstance();

        l.log("Loading objects from .csv files...");
        blasters(s);
        lightsabers(s);

        bhunters(s);
        forceusers(s);
        jedisiths(s);
        smugglers(s);
        l.log("Done loading!");
    }
}
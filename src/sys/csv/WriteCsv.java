package sys.csv;

import characters.BountyHunter;
import characters.ForceUser;
import characters.JediSith;
import characters.Smuggler;
import weapons.Blaster;
import weapons.Lightsaber;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCsv {
    private static WriteCsv wcsv = null;

    static File f = null;
    static FileWriter fw = null;
    static BufferedWriter bw = null;

    public WriteCsv() {
    }

    public static WriteCsv getInstance() {
        if(wcsv == null)
            wcsv = new WriteCsv();
        return wcsv;
    }

    void openFile(String path) {
        f = new File(path);
        try {
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        bw = new BufferedWriter(fw);
    }

    public void blaster(Blaster b) {
        try {
            openFile("src/sys/data/blasters.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(b.getName() +
                    ";" + b.getType() +
                    ";" + b.getShots() +
                    ";" + b.getCooldown().toString().replace(".",",") + ";");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void lightsaber(Lightsaber l) {
        try {
            openFile("src/sys/data/lightsabers.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(l.getColor() +
                    "," + l.getType() +
                    "," + l.getHilt() + ",");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void bhunter(BountyHunter bh) {
        try {
            openFile("src/sys/data/bhunters.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(bh.getName() +
                    "," + bh.getPlanet() +
                    "," + bh.getBorn().getYear() +
                    "," + bh.getBorn().getEra() +
                    "," + bh.getContracts_done() +
                    "," + bh.getMin_credits_contract() + ",");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void forceuser(ForceUser fu) {
        try {
            openFile("src/sys/data/forceusers.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(fu.getName() +
                    "," + fu.getPlanet() +
                    "," + fu.getBorn().getYear() +
                    "," + fu.getBorn().getEra() +
                    "," + fu.getYrs_practice() +
                    "," + fu.isPermadeath() + ",");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void jedisith(JediSith js) {
        try {
            openFile("src/sys/data/jedisiths.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(js.getName() +
                    "," + js.getPlanet() +
                    "," + js.getBorn().getYear() +
                    "," + js.getBorn().getEra() +
                    "," + js.getYrs_practice() +
                    "," + js.isPermadeath() +
                    "," + js.getType() +
                    "," + js.getRank() + ",");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void smuggler(Smuggler s) {
        try {
            openFile("src/sys/data/smugglers.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(s.getName() +
                    "," + s.getPlanet() +
                    "," + s.getBorn().getYear() +
                    "," + s.getBorn().getEra() +
                    "," + s.getShipments_nr() +
                    "," + s.getParsecs_travelled() + ",");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

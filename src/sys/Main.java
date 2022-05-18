package sys;

import characters.BountyHunter;
import characters.ForceUser;
import characters.JediSith;
import characters.Smuggler;
import enums.ForceUserType;
import enums.JediSithRank;
import enums.StarWarsEra;
import misc.BadRankExp;
import sys.csv.ReadCsv;
import sys.jdbc.DBConn;
import sys.jdbc.ReadDB;
import sys.logs.Log;
import weapons.Blaster;
import weapons.Lightsaber;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, BadRankExp {
        //testing
        Log.clearLog();
        Log.log("System startup");

        Service service = new Service();

        DBConn dbcon = DBConn.getInstance();
        ReadDB rdb = ReadDB.getInstance();
        ReadCsv rcsv = ReadCsv.getInstance();

        boolean flag = true;
        try {
            dbcon.startConn();

            rdb.loadObjects(service);
        } catch (ClassNotFoundException | SQLException e) {
            Log.log("Can't access database; switching to .csv files");
            flag = false;
            rcsv.loadFiles(service);
        }

//        service.bserv.addB(new Blaster("name","type",32,23.23), false);
//        service.bserv.listB();
//        service.lserv.addL(new Lightsaber("color", "type", "hilt"), false);
//        service.lserv.listL();
//        service.bhserv.addBH(new BountyHunter("name","planet",32,
//                StarWarsEra.BBY,32,333), false);
//        service.bhserv.listBH();
//        service.fuserv.addFU(new ForceUser("name","planet",33,
//                StarWarsEra.BBY,25,true), false);
//        service.fuserv.listFU();
//        service.jsserv.addJS(new JediSith("name", "planet", 123, StarWarsEra.BBY,
//                123,false, ForceUserType.Sith, JediSithRank.SEmperor), false);
//        service.jsserv.listJS();
//        service.sserv.addS(new Smuggler("name","planet",123, StarWarsEra.BBY, 123, 123), false);
//        service.sserv.listS();

//        service.jsserv.addLightsaber(service.lserv.getL(0),0);
//        service.jsserv.listJS();
//        service.jsserv.getJS(0).showBountyCalculation();

        if(flag) dbcon.closeConn();

        Log.log("System shutdown");
        Log.getBw().close();
    }
}

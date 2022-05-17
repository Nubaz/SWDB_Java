package sys;

import misc.BadRankExp;
import sys.csv.ReadCsv;
import sys.jdbc.DBConn;
import sys.jdbc.ReadDB;
import sys.logs.Log;

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

            Log.log("Loading objects from MySQL database...");
            rdb.loadObjects(service);
        } catch (ClassNotFoundException | SQLException e) {
            Log.log("Can't access database; switching to .csv files");
            flag = false;
            rcsv.loadFiles(service);
        }

        service.jsserv.addLightsaber(service.lserv.getL(0),0);
        service.jsserv.listJS();
        service.jsserv.getJS(0).showBountyCalculation();

//        service.jsserv.addJS(new JediSith("name", "planet", 123, StarWarsEra.BBY,
//                123,false, ForceUserType.Sith, JediSithRank.SEmperor), false);
//        service.jsserv.listJS();
//        service.sserv.addS(new Smuggler("name","planet",123, StarWarsEra.BBY, 123, 123), false);
//        service.sserv.listS();

        if(flag) DBConn.closeConn();

        Log.log("System shutdown");
        Log.getBw().close();
    }
}

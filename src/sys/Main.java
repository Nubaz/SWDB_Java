package sys;

import misc.BadRankExp;
import sys.logs.Log;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, BadRankExp {
        //testing
        Log.clearLog();
        Log.log("System startup");

        Service service = new Service();

        boolean flag = true;
        try {
            Connection conn = null;
            conn = JDBC.getConn();

            Log.log("Loading objects from MySQL database...");
            JDBC.loadObjects(service);
        } catch (ClassNotFoundException | SQLException e) {
            Log.log("Can't access database; switching to .csv files");
            flag = false;
            Read.loadFiles(service);
        }

        service.jsserv.addLightsaber(service.lserv.getL(0),0);
        service.jsserv.listJS();
        service.jsserv.getJS(0).showBountyCalculation();

        if(flag) JDBC.closeConn();

        Log.log("System shutdown");
        Log.getBw().close();
    }
}

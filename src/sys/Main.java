package sys;

import misc.BadRankExp;
import sys.logs.Log;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, BadRankExp {
        //testing
        Log.clearLog();
        Log.log("System startup");

        Service service = new Service();
        Read.loadFiles(service);

        service.jsserv.addLightsaber(service.lserv.getL(0),0);
        service.jsserv.listJS();
        service.jsserv.getJS(0).showBountyCalculation();

        Log.log("System shutdown");
        Log.getBw().close();
    }
}

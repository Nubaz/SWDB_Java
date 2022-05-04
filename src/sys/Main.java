package sys;

import misc.BadRankExp;
import sys.logs.Log;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, BadRankExp {
        //testing
        Log.log("System startup");

        Service service = new Service();
        Read.loadFiles(service);
        service.jsserv.listJS();

        Log.log("System shutdown");
        Log.getBw().close();
    }
}

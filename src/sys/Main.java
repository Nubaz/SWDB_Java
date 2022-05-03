package sys;

import misc.BadRankExp;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, BadRankExp {
        //testing
        Service service = new Service();
        Read.loadFiles(service);
//        service.jsserv.listJS();
    }
}

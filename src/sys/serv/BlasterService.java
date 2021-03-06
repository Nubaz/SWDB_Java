package sys.serv;

import sys.csv.WriteCsv;
import sys.jdbc.WriteDB;
import sys.logs.Log;
import weapons.Blaster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class BlasterService {
    ArrayList<Blaster> v = new ArrayList<>();
    WriteCsv wcsv = WriteCsv.getInstance();
    WriteDB wdb = WriteDB.getInstance();
    Log l;

    //create
    public void addB(Blaster b, boolean read) throws IOException {
        l = Log.getInstance();

        l.log("Adding blaster: " + b.getName());
        if(!read) {
            wdb.blaster(b);
            wcsv.blaster(b);
        }
        v.add(b);
    }

    //read
    public Blaster getB(int i) {
        return v.get(i);
    }

    public void listB() throws IOException {
        l = Log.getInstance();

        l.log("Listing blasters");
        v.forEach(System.out::println);
    }

    //delete
    public void removeB_index(int i) throws IOException {
        l = Log.getInstance();

        l.log("Removing blaster " + i);
        v.remove(i);
    }
    public void removeB_name(String name) throws IOException {
        l = Log.getInstance();

        l.log("Removing blaster " + name);
        Predicate<Blaster> filter = (Blaster b) -> (b.getName().equalsIgnoreCase(name));
        v.removeIf(filter);
    }
}

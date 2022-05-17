package sys.serv;

import sys.csv.WriteCsv;
import sys.logs.Log;
import weapons.Lightsaber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class LightsaberService {
    ArrayList<Lightsaber> v = new ArrayList<>();
    WriteCsv wcsv = WriteCsv.getInstance();

    //create
    public void addL(Lightsaber l, boolean read) throws IOException {
        Log.log("Adding lightsaber: " + l.getHilt() + "-" + l.getColor() + "-" + l.getType());
        if(!read)
            wcsv.lightsaber(l);
        v.add(l);
    }

    //read
    public Lightsaber getL(int i) {
        return v.get(i);
    }

    public void listL() throws IOException {
        Log.log("Listing lightsabers");
        v.forEach(System.out::println);
    }

    //delete
    public void removeL_index(int i) throws IOException {
        Log.log("Removing lightsaber " + i);
        v.remove(i);
    }
    public void removeL_color(String color) throws IOException {
        Log.log("Removing " + color + " lightsabers");
        Predicate<Lightsaber> filter = (Lightsaber l) -> (l.getColor().equalsIgnoreCase(color));
        v.removeIf(filter);
    }
    public void removeL_hilt(String hilt) throws IOException {
        Log.log("Removing " + hilt + " lightsabers");
        Predicate<Lightsaber> filter = (Lightsaber l) -> (l.getHilt().equalsIgnoreCase(hilt));
        v.removeIf(filter);
    }
    public void removeL_type(String type) throws IOException {
        Log.log("Removing " + type + " lightsabers");
        Predicate<Lightsaber> filter = (Lightsaber l) -> (l.getType().equalsIgnoreCase(type));
        v.removeIf(filter);
    }

}

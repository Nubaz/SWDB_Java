package sys.serv;

import weapons.Lightsaber;

import java.util.ArrayList;
import java.util.function.Predicate;

public class LightsaberService {
    ArrayList<Lightsaber> v = new ArrayList<>();

    //create
    public void addL(Lightsaber l) {
        v.add(l);
    }

    //read
    public void listL() {
        v.forEach(System.out::println);
    }

    //delete
    public void removeL_index(int i) {
        v.remove(i);
    }
    public void removeL_color(String color) {
        Predicate<Lightsaber> filter = (Lightsaber l) -> (l.getColor().equalsIgnoreCase(color));
        v.removeIf(filter);
    }
    public void removeL_hilt(String hilt) {
        Predicate<Lightsaber> filter = (Lightsaber l) -> (l.getHilt().equalsIgnoreCase(hilt));
        v.removeIf(filter);
    }
    public void removeL_type(String type) {
        Predicate<Lightsaber> filter = (Lightsaber l) -> (l.getType().equalsIgnoreCase(type));
        v.removeIf(filter);
    }

}

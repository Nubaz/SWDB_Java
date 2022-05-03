package sys.serv;

import weapons.Blaster;

import java.util.ArrayList;
import java.util.function.Predicate;

public class BlasterService {
    ArrayList<Blaster> v = new ArrayList<>();

    //create
    public void addB(Blaster b) {
        v.add(b);
    }

    //read
    public void listB() {
        v.forEach(System.out::println);
    }

    //delete
    public void removeB_index(int i) {
        v.remove(i);
    }
    public void removeB_name(String name) {
        Predicate<Blaster> filter = (Blaster b) -> (b.getName().equalsIgnoreCase(name));
        v.removeIf(filter);
    }
}

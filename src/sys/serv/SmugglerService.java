package sys.serv;

import characters.Character;
import characters.Smuggler;
import enums.StarWarsEra;
import sys.csv.WriteCsv;
import sys.logs.Log;
import weapons.Blaster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Predicate;

public class SmugglerService {
    ArrayList<Smuggler> v = new ArrayList<>();
    HashMap<Blaster, Smuggler> map = new HashMap<>();
    WriteCsv wcsv = WriteCsv.getInstance();

    //create
    public void addS(Smuggler s, boolean read) throws IOException {
        Log.log("Adding smuggler: " + s.getName());
        if(!read) {
            wcsv.smuggler(s);
        }
        v.add(s);
    }

    //read
    public Smuggler getS(int i) {
        return v.get(i);
    }

    public void listS() throws IOException {
        Log.log("Listing smugglers");
        v.forEach(System.out::println);
    }
    public void listS_name() throws IOException {
        Log.log("Listing smugglers by name");
        v.stream()
                .sorted((p1,p2) -> p1.getName().compareToIgnoreCase(p2.getName()))
                .forEach(System.out::println);
    }
    public void listS_planet() throws IOException {
        Log.log("Listing smugglers by planet");
        v.stream()
                .sorted((p1,p2) -> p1.getPlanet().compareToIgnoreCase(p2.getPlanet()))
                .forEach(System.out::println);
    }
    public void listS_born() throws IOException {
        Log.log("Listing smugglers by date of birth");
        v.stream()
                .sorted((p1,p2) -> {
                    //same era, return year
                    if(p1.getBorn().getEra().name().equals(p2.getBorn().getEra().name()))
                        //BBY, greater means older
                        if(p1.getBorn().getEra().name().equals(StarWarsEra.BBY.toString()))
                            return p1.getBorn().getYear().compareTo(p2.getBorn().getYear());
                        //ABY, greater means younger
                        else
                            return p1.getBorn().getYear().compareTo(p2.getBorn().getYear());
                    //different era
                    else
                        if(p1.getBorn().getEra().equals(StarWarsEra.BBY) && p2.getBorn().getEra().equals(StarWarsEra.ABY))
                            return -1;
                        else
                            return 1;
                })
                .forEach(System.out::println);
    }
    public void listS_bounty() throws IOException {
        Log.log("Listing smugglers by bounty");
        v.stream()
                .sorted(Comparator.comparing(Character::getBounty))
                .forEach(System.out::println);
    }
    public void listS_shipments_nr() throws IOException {
        Log.log("Listing smugglers by nr. of shipments");
        v.stream()
                .sorted(Comparator.comparing(Smuggler::getShipments_nr))
                .forEach(System.out::println);
    }
    public void listS_parsecs() throws IOException {
        Log.log("Listing smugglers by parsecs travelled");
        v.stream()
                .sorted(Comparator.comparing(Smuggler::getParsecs_travelled))
                .forEach(System.out::println);
    }

    public void listMap() throws IOException {
        Log.log("Listing smugglers - blasters binding");
        map.forEach((b, s) -> System.out.println(
                s.getName() + "\n" +
                        "Blaster: " + b.getName() + ", " + b.getType() + ", " + b.getShots() + ", " + b.getCooldown()
        ));
    }

    //update
    public void addBlaster(int i, Blaster b) throws IOException {
        Log.log("Adding blaster " + b.getName() + " to smuggler " + i);
        if(map.containsKey(b)) {
            System.out.println("Can't add: blaster already attached to someone");
        }
        else {
            v.get(i).setWeapon(b);
            map.put(b, v.get(i));
        }
    }
    public void replaceOwner(Blaster b, Smuggler s) throws IOException {
        Log.log("Changing owner of blaster " + b.getName() + " to " + s.getName());
        if(!map.containsKey(b))
            System.out.println("Can't replace: blaster isn't mapped to a smuggler");
        else
            map.replace(b, s);
    }

    //delete
    public void removeS_index(int i) throws IOException {
        Log.log("Removing smuggler " + i);
        v.remove(i);
    }
    public void removeS_name(String name) throws IOException {
        Log.log("Removing smuggler " + name);
        Predicate<Smuggler> filter = (Smuggler b) -> (b.getName().equalsIgnoreCase(name));
        v.removeIf(filter);
    }
    public void removeS_planet(String planet) throws IOException {
        Log.log("Removing smugglers born on " + planet);
        Predicate<Smuggler> filter = (Smuggler b) -> (b.getPlanet().equalsIgnoreCase(planet));
        v.removeIf(filter);
    }
    public void removeS_era(StarWarsEra era) throws IOException {
        Log.log("Removing smugglers born " + era);
        Predicate<Smuggler> filter = (Smuggler b) -> (b.getBorn().getEra().equals(era));
        v.removeIf(filter);
    }
}

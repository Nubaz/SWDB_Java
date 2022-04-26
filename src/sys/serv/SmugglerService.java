package sys.serv;

import characters.Character;
import characters.Smuggler;
import enums.StarWarsEra;
import weapons.Blaster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class SmugglerService {
    ArrayList<Smuggler> v = new ArrayList<>();

    //create
    public void addS(Smuggler s) {
        v.add(s);
    }

    //read
    public void listS() {
        v.forEach(System.out::println);
    }
    public void listS_name() {
        v.stream()
                .sorted((p1,p2) -> p1.getName().compareToIgnoreCase(p2.getName()))
                .forEach(System.out::println);
    }
    public void listS_planet() {
        v.stream()
                .sorted((p1,p2) -> p1.getPlanet().compareToIgnoreCase(p2.getPlanet()))
                .forEach(System.out::println);
    }
    public void listS_born() {
        v.stream()
                .sorted((p1,p2) -> {
                    //same era, return year
                    if(p1.getBorn().getEra().name().equals(p2.getBorn().getEra().name()))
                        //BBY, greater means older
                        if(p1.getBorn().getEra().name().equals(StarWarsEra.BBY))
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
    public void listS_bounty() {
        v.stream()
                .sorted(Comparator.comparing(Character::getBounty))
                .forEach(System.out::println);
    }
    public void listS_shipments_nr() {
        v.stream()
                .sorted(Comparator.comparing(Smuggler::getShipments_nr))
                .forEach(System.out::println);
    }
    public void listS_parsecs() {
        v.stream()
                .sorted(Comparator.comparing(Smuggler::getParsecs_travelled))
                .forEach(System.out::println);
    }

    //update
    public void addBlaster(int i, Blaster b) {
        v.get(i).setWeapon(b);
    }

    //delete
    public void removeS_index(int i) {
        v.remove(i);
    }
    public void removeS_name(String name) {
        Predicate<Smuggler> filter = (Smuggler b) -> (b.getName().equalsIgnoreCase(name));
        v.removeIf(filter);
    }
    public void removeS_planet(String planet) {
        Predicate<Smuggler> filter = (Smuggler b) -> (b.getPlanet().equalsIgnoreCase(planet));
        v.removeIf(filter);
    }
    public void removeS_era(StarWarsEra era) {
        Predicate<Smuggler> filter = (Smuggler b) -> (b.getBorn().getEra().equals(era));
        v.removeIf(filter);
    }
}

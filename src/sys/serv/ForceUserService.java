package sys.serv;

import characters.Character;
import characters.ForceUser;
import enums.StarWarsEra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class ForceUserService {
    ArrayList<ForceUser> v = new ArrayList<>();

    //create
    public void addFU(ForceUser f) {
        v.add(f);
    }

    //read
    public void listFU() {
        v.forEach(System.out::println);
    }
    public void listFU_name() {
        v.stream()
                .sorted((p1,p2) -> p1.getName().compareToIgnoreCase(p2.getName()))
                .forEach(System.out::println);
    }
    public void listFU_planet() {
        v.stream()
                .sorted((p1,p2) -> p1.getPlanet().compareToIgnoreCase(p2.getPlanet()))
                .forEach(System.out::println);
    }
    public void listFU_born() {
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
    public void listFU_bounty() {
        v.stream()
                .sorted(Comparator.comparing(Character::getBounty))
                .forEach(System.out::println);
    }
    public void listFU_yrs_practice() {
        v.stream()
                .sorted(Comparator.comparing(ForceUser::getYrs_practice))
                .forEach(System.out::println);
    }

    //delete
    public void removeFU_index(int i) {
        v.remove(i);
    }
    public void removeFU_name(String name) {
        Predicate<ForceUser> filter = (ForceUser b) -> (b.getName().equalsIgnoreCase(name));
        v.removeIf(filter);
    }
    public void removeFU_planet(String planet) {
        Predicate<ForceUser> filter = (ForceUser b) -> (b.getPlanet().equalsIgnoreCase(planet));
        v.removeIf(filter);
    }
    public void removeFU_era(StarWarsEra era) {
        Predicate<ForceUser> filter = (ForceUser b) -> (b.getBorn().getEra().equals(era));
        v.removeIf(filter);
    }
}

package sys.serv;

import characters.Character;
import characters.ForceUser;
import characters.JediSith;
import enums.StarWarsEra;
import weapons.Lightsaber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Predicate;

public class JediSithService {
    ArrayList<JediSith> v = new ArrayList<>();
    HashMap<Lightsaber, JediSith> map = new HashMap<>();

    //create
    public void addJS(JediSith js) {
        v.add(js);
    }

    //read
    public void listJS() {
        v.forEach(System.out::println);
    }
    public void listJS_name() {
        v.stream()
                .sorted((p1,p2) -> p1.getName().compareToIgnoreCase(p2.getName()))
                .forEach(System.out::println);
    }
    public void listJS_planet() {
        v.stream()
                .sorted((p1,p2) -> p1.getPlanet().compareToIgnoreCase(p2.getPlanet()))
                .forEach(System.out::println);
    }
    public void listJS_born() {
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
    public void listJS_bounty() {
        v.stream()
                .sorted(Comparator.comparing(Character::getBounty))
                .forEach(System.out::println);
    }
    public void listJS_yrs_practice() {
        v.stream()
                .sorted(Comparator.comparing(ForceUser::getYrs_practice))
                .forEach(System.out::println);
    }
    public void listJedi() {
        Predicate<JediSith> filter = (JediSith js) -> (js.getType().name().equals("Jedi"));
        v.stream()
                .filter(filter)
                .forEach(System.out::println);
    }
    public void listSith() {
        Predicate<JediSith> filter = (JediSith js) -> (js.getType().name().equals("Sith"));
        v.stream()
                .filter(filter)
                .forEach(System.out::println);
    }

    public void listMap() {
        map.forEach((l, js) -> System.out.println(
                js.getType() + ": " + js.getRank() + ", " + js.getName() + "\n" +
                "Lightsaber: " + l.getType() + ", " + l.getHilt() + ", " + l.getColor()
        ));
    }

    //update
    public void addLightsaber(Lightsaber l, int i) {
        if(map.containsKey(l)) {
            System.out.println("Can't add: lightsaber already attached to someone");
        }
        else {
            v.get(i).setLightsaber(l);
            map.put(l, v.get(i));
        }
    }
    public void replaceOwner(Lightsaber l, JediSith js) {
        if(!map.containsKey(l))
            System.out.println("Can't replace: lightsaber isn't mapped to a jedi/sith");
        else
            map.replace(l, js);
    }

    //delete
    public void removeJS_index(int i) {
        v.remove(i);
    }
    public void removeJS_name(String name) {
        Predicate<JediSith> filter = (JediSith js) -> (js.getName().equalsIgnoreCase(name));
        v.removeIf(filter);
    }
    public void removeJS_planet(String planet) {
        Predicate<JediSith> filter = (JediSith js) -> (js.getPlanet().equalsIgnoreCase(planet));
        v.removeIf(filter);
    }
    public void removeJS_era(StarWarsEra era) {
        Predicate<JediSith> filter = (JediSith js) -> (js.getBorn().getEra().equals(era));
        v.removeIf(filter);
    }
}

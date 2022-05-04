package sys.serv;

import characters.BountyHunter;
import characters.Character;
import enums.StarWarsEra;
import sys.logs.Log;
import weapons.Blaster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Predicate;

public class BountyHunterService {
    ArrayList<BountyHunter> v = new ArrayList<>();
    HashMap<Blaster, BountyHunter> map = new HashMap<>();

    //create
    public void addBH(BountyHunter b) throws IOException {
        Log.log("Adding bounty hunter: " + b.getName());
        v.add(b);
    }

    //read
    public void listBH() throws IOException {
        Log.log("Listing bounty hunters");
        v.forEach(System.out::println);
    }
    public void listBH_name() throws IOException {
        Log.log("Listing bounty hunters by name");
        v.stream()
                .sorted((p1,p2) -> p1.getName().compareToIgnoreCase(p2.getName()))
                .forEach(System.out::println);
    }
    public void listBH_planet() throws IOException {
        Log.log("Listing bounty hunters by planet");
        v.stream()
                .sorted((p1,p2) -> p1.getPlanet().compareToIgnoreCase(p2.getPlanet()))
                .forEach(System.out::println);
    }
    public void listBH_born() throws IOException {
        Log.log("Listing bounty hunters by date of birth");
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
    public void listBH_bounty() throws IOException {
        Log.log("Listing bounty hunters by bounty");
        v.stream()
                .sorted(Comparator.comparing(Character::getBounty))
                .forEach(System.out::println);
    }
    public void listBH_contracts() throws IOException {
        Log.log("Listing bounty hunters by contracts");
        v.stream()
                .sorted(Comparator.comparing(BountyHunter::getContracts_done))
                .forEach(System.out::println);
    }
    public void listBH_mincredits() throws IOException {
        Log.log("Listing bounty hunters by min credits per contract");
        v.stream()
                .sorted(Comparator.comparing(BountyHunter::getMin_credits_contract))
                .forEach(System.out::println);
    }

    public void listMap() throws IOException {
        Log.log("Listing bounty hunters - blasters binding");
        map.forEach((b, bh) -> System.out.println(
                bh.getName() + "\n" +
                "Blaster: " + b.getName() + ", " + b.getType() + ", " + b.getShots() + ", " + b.getCooldown()
        ));
    }

    //update
    public void addBlaster(int i, Blaster b) throws IOException {
        Log.log("Adding blaster " + b.getName() + " to pos " + i);
        if(map.containsKey(b)) {
            System.out.println("Can't add: blaster already attached to someone");
        }
        else {
            v.get(i).setWeapon(b);
            map.put(b, v.get(i));
        }
    }
    public void replaceOwner(Blaster b, BountyHunter bh) throws IOException {
        Log.log("Changing owner of blaster " + b.getName() + " to " + bh.getName());
        if(!map.containsKey(b))
            System.out.println("Can't replace: blaster isn't mapped to a bounty hunter");
        else
            map.replace(b, bh);
    }

    //delete
    public void removeBH_index(int i) throws IOException {
        Log.log("Removing bounty hunter " + i);
        v.remove(i);
    }
    public void removeBH_name(String name) throws IOException {
        Log.log("Removing bounty hunter " + name);
        Predicate<BountyHunter> filter = (BountyHunter b) -> (b.getName().equalsIgnoreCase(name));
        v.removeIf(filter);
    }
    public void removeBH_planet(String planet) throws IOException {
        Log.log("Removing bounty hunter born on " + planet);
        Predicate<BountyHunter> filter = (BountyHunter b) -> (b.getPlanet().equalsIgnoreCase(planet));
        v.removeIf(filter);
    }
    public void removeBH_era(StarWarsEra era) throws IOException {
        Log.log("Removing bounty hunter born " + era);
        Predicate<BountyHunter> filter = (BountyHunter b) -> (b.getBorn().getEra().equals(era));
        v.removeIf(filter);
    }
}

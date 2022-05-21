package sys.serv;

import characters.Character;
import characters.ForceUser;
import enums.StarWarsEra;
import sys.csv.WriteCsv;
import sys.jdbc.DeleteDB;
import sys.jdbc.WriteDB;
import sys.logs.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class ForceUserService {
    ArrayList<ForceUser> v = new ArrayList<>();
    WriteCsv wcsv = WriteCsv.getInstance();
    WriteDB wdb = WriteDB.getInstance();
    DeleteDB ddb = DeleteDB.getInstance();
    Log l;

    //create
    public void addFU(ForceUser f, boolean read) throws IOException {
        l = Log.getInstance();

        l.log("Adding force user: " + f.getName());
        if(!read) {
            wdb.forceuser(f);
            wcsv.forceuser(f);
        }
        v.add(f);
    }

    //read
    public ForceUser getFU(int i) {
        return v.get(i);
    }

    public void listFU() throws IOException {
        l = Log.getInstance();

        l.log("Listing force users");
        v.forEach(System.out::println);
    }
    public void listFU_name() throws IOException {
        l = Log.getInstance();

        l.log("Listing force users by name");
        v.stream()
                .sorted((p1,p2) -> p1.getName().compareToIgnoreCase(p2.getName()))
                .forEach(System.out::println);
    }
    public void listFU_planet() throws IOException {
        l = Log.getInstance();

        l.log("Listing force users by planet");
        v.stream()
                .sorted((p1,p2) -> p1.getPlanet().compareToIgnoreCase(p2.getPlanet()))
                .forEach(System.out::println);
    }
    public void listFU_born() throws IOException {
        l = Log.getInstance();

        l.log("Listing force users by date of birth");
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
    public void listFU_bounty() throws IOException {
        l = Log.getInstance();

        l.log("Listing force users by bounty");
        v.stream()
                .sorted(Comparator.comparing(Character::getBounty))
                .forEach(System.out::println);
    }
    public void listFU_yrs_practice() throws IOException {
        l = Log.getInstance();

        l.log("Listing force users by years of practice");
        v.stream()
                .sorted(Comparator.comparing(ForceUser::getYrs_practice))
                .forEach(System.out::println);
    }

    //delete
    public void removeFU_index(int i) throws IOException {
        l = Log.getInstance();
        l.log("Removing force user " + i);

        ddb.delete("forceuser",v.get(i).getName());
        v.remove(i);
    }
    public void removeFU_name(String name) throws IOException {
        l = Log.getInstance();

        l.log("Removing force user " + name);
        Predicate<ForceUser> filter = (ForceUser b) -> (b.getName().equalsIgnoreCase(name));
        v.removeIf(filter);
    }
    public void removeFU_planet(String planet) throws IOException {
        l = Log.getInstance();

        l.log("Removing force user " + planet);
        Predicate<ForceUser> filter = (ForceUser b) -> (b.getPlanet().equalsIgnoreCase(planet));
        v.removeIf(filter);
    }
    public void removeFU_era(StarWarsEra era) throws IOException {
        l = Log.getInstance();

        l.log("Removing force user born" + era);
        Predicate<ForceUser> filter = (ForceUser b) -> (b.getBorn().getEra().equals(era));
        v.removeIf(filter);
    }
}

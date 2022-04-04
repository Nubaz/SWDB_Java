import misc.Exp;
import base.ForceUser;

public class Main {
    public static void main(String[] args) {
        try {
            ForceUser f = new ForceUser("name","planet",12,"ABY", 18, true);
            System.out.println(f.toString());
        } catch (Exp e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

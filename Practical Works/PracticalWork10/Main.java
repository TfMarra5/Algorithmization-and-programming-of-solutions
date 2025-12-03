import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 3, 2, 5, 3, 4, 1, 4);
        Set<Integer> unique = new HashSet<>(nums);

        System.out.println("nums: " + nums);
        System.out.println("unique: " + unique);
        System.out.println("");

        System.out.println("phonebook:");
        HashMap<String, String> book = new HashMap<>();

        book.put("911", "police");
        book.put("76213", "mom");
        book.put("17239", "bob");

        String name;

        name = book.get("76213");
        System.out.println("76213 -> " + (name == null ? "not found" : name));

        name = book.get("910");
        System.out.println("910 -> " + (name == null ? "not found" : name));

        book.remove("911");
        name = book.get("911");
        System.out.println("911 -> " + (name == null ? "not found" : name));

        book.put("76213", "dad");
        System.out.println("76213 -> " + book.get("76213"));

        System.out.println("");
        System.out.println("objects as keys:");

        HashMap<PersonKey, String> owners = new HashMap<>();

        PersonKey lv = new PersonKey("LV123", "LV");
        PersonKey ee = new PersonKey("EE555", "EE");

        owners.put(lv, "Thomas");
        owners.put(ee, "Uhanovs");

        PersonKey look = new PersonKey("LV123", "LV");
        System.out.println("LV123 LV -> " + owners.get(look));
    }
}

import java.util.HashMap;
import java.util.Map;

public class ObjectsAsKeys {

    public static void main(String[] args) {
        Map<PersonKey, String> people = new HashMap<>();

        PersonKey lvKey = new PersonKey("LV12345", "LV");
        PersonKey eeKey = new PersonKey("EE55555", "EE");

        people.put(lvKey, "Thomas");
        people.put(eeKey, "Uhanovs");

        PersonKey lookup = new PersonKey("LV12345", "LV");

        String name = people.get(lookup);
        System.out.println(name);
    }
}

final class PersonKey {
    private final String doc;
    private final String country;

    public PersonKey(String doc, String country) {
        this.doc = doc;
        this.country = country;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof PersonKey)) return false;
        PersonKey that = (PersonKey) other;
        return doc.equals(that.doc) && country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return 31 * doc.hashCode() + country.hashCode();
    }

    @Override
    public String toString() {
        return doc + " " + country;
    }
}

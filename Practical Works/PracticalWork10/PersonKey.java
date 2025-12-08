public final class PersonKey {
    private final String doc;
    private final String country;

    public PersonKey(String doc, String country) {
        this.doc = doc;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonKey)) return false;

        PersonKey other = (PersonKey) o;
        return doc.equals(other.doc) && country.equals(other.country);
    }

    @Override
    public int hashCode() {
        int h = doc.hashCode();
        h = h * 37 + country.hashCode(); 
        return h;
    }

    @Override
    public String toString() {
        return doc + " - " + country;
    }
}

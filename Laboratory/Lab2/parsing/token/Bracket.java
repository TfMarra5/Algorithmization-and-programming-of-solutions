package parsing.token;

public class Bracket extends Token {

    public Bracket(String str) {
        super(str);
    }

    public boolean isOpen() {
        return "({[".contains(str);
    }

    public boolean isClosed() {
        return ")}]".contains(str);
    }

    public boolean matches(Bracket other) {
        if (other == null) return false;

        String a = this.str;
        String b = other.str;

        return (a.equals("(") && b.equals(")")) ||
               (a.equals(")") && b.equals("(")) ||
               (a.equals("{") && b.equals("}")) ||
               (a.equals("}") && b.equals("{")) ||
               (a.equals("[") && b.equals("]")) ||
               (a.equals("]") && b.equals("["));
    }

    @Override
    public String toString() {
        return String.format("Bracket(%s)", str);
    }
}

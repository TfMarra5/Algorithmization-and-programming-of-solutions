package parsing.token;

public abstract class Token {

    protected String str;

    protected Token(String str) {
        this.str = str;
    }
    
    public abstract String toString();

    public String getString() {
        return str;
    }

}

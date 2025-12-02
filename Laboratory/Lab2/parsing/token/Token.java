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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Token other = (Token) obj;
        return java.util.Objects.equals(str, other.str);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(str);
    }
}
package parsing;

import java.util.List;

import parsing.token.*;
import parsing.token.Bracket;

public class Parser {

    public static String syntaxTree(List<Token> tokens) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;

        for (Token t : tokens) {
            Bracket b = toBracket(t);
            if (b != null && b.isClosed()) {
                depth = Math.max(0, depth - 1);
            }

            for (int i = 0; i < depth; i++) {
                sb.append("  ");
            }

            sb.append(t.getString()).append(System.lineSeparator());
            if (b != null && b.isOpen()) {
                depth++;
            }
        }

        return sb.toString();
    }

    private static Bracket toBracket(Token t) {
        if (t instanceof Bracket) {
            return (Bracket) t;
        }
        if (t instanceof Symbol) {
            String s = t.getString();
            if ("(){}[]".contains(s)) {
                return new Bracket(s);
            }
        }
        return null;
    }

}
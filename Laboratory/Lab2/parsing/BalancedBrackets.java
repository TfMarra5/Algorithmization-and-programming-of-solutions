package parsing;

import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;

import parsing.token.*;
import parsing.token.Bracket;

public class BalancedBrackets {

    public static boolean areBracketsBalanced(List<Token> tokens) {
        Deque<Bracket> stack = new ArrayDeque<>();

        for (Token t : tokens) {
            Bracket b = toBracket(t);
            if (b == null) continue; // ignora tokens que não são brackets

            if (b.isOpen()) {
                stack.push(b);
            } else if (b.isClosed()) {
                if (stack.isEmpty()) {
                    return false;
                }
                Bracket top = stack.pop();
                if (!top.matches(b)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // helper para converter Token -> Bracket
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

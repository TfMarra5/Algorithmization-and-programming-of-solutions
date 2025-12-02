package parsing.tokenizer;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import parsing.token.*;

public class JavaTokenizer extends Tokenizer {
    
    // alguns keywords de Java (não precisa ser lista completa)
    private static List<String> keywords = Arrays.asList(
        "for",
        "while",
        "if",
        "switch",
        "do",
        "public",
        "private",
        "class",
        "static",
        "void",
        "int",
        "double",
        "boolean",
        "true",
        "false",
        "new",
        "return"
    );

    @Override
    public List<Token> tokenize(String text) {
        if (text == null) {
            return Collections.emptyList();
        }

        // 1) remover comentários de linha (// até o fim da linha)
        StringBuilder noComments = new StringBuilder();
        String[] lines = text.split("\\R"); 
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            int idx = line.indexOf("//");
            if (idx >= 0) {
                line = line.substring(0, idx);
            }
            noComments.append(line);
            if (i < lines.length - 1) {
                noComments.append('\n');
            }
        }

        // 2) tokenizar e marcar keywords
        List<Token> tokens = makeTokens(noComments.toString());
        tokens = makeKeywords(tokens);

        List<Token> withBrackets = new ArrayList<>();
        for (Token t : tokens) {
            if (t instanceof Symbol) {
                String s = t.getString();
                if ("(){}[]".contains(s)) {
                    withBrackets.add(new Bracket(s));
                    continue;
                }
            }
            withBrackets.add(t);
        }
        tokens = withBrackets; 

        // 3) remover tokens invisíveis (whitespace, quebras de linha)
        List<Token> cleaned = new ArrayList<>();
        for (Token t : tokens) {
            if (t instanceof LineToken) {
                continue;
            }
            String s = t.getString();
            if (s == null || s.trim().isEmpty()) { 
                continue;
            }
            cleaned.add(t);
        }

        return cleaned;
    }

    @Override
    public List<String> keywords() {
        return JavaTokenizer.keywords;
    }

}
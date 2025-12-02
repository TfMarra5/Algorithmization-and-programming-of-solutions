package parsing.tokenizer;

import java.util.ArrayList;
import java.util.List;

import parsing.token.Keyword;
import parsing.token.LineToken;
import parsing.token.Symbol;
import parsing.token.Token;
import parsing.token.Word;

public abstract class Tokenizer {

    // cada tokenizer concreto (ex.: JavaTokenizer) deve implementar isso
    public abstract List<Token> tokenize(String text);

    // cada tokenizer concreto deve fornecer a lista de keywords
    public abstract List<String> keywords();

    // ----------------- HELPERS -----------------

    // quebra o texto em tokens básicos: Word, Symbol, LineToken
    protected List<Token> makeTokens(String text) {
        List<Token> tokens = new ArrayList<>();
        if (text == null || text.isEmpty()) return tokens;

        StringBuilder current = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // quebras de linha viram LineToken
            if (c == '\n' || c == '\r') {
                if (current.length() > 0) {
                    addWordOrSymbol(tokens, current.toString());
                    current.setLength(0);
                }
                tokens.add(new LineToken("\\n"));
                continue;
            }

            // espaços normais só separam tokens
            if (Character.isWhitespace(c)) {
                if (current.length() > 0) {
                    addWordOrSymbol(tokens, current.toString());
                    current.setLength(0);
                }
                continue;
            }

            // símbolos (parênteses, chaves, operadores, etc.)
            if (isSymbolChar(c)) {
                if (current.length() > 0) {
                    addWordOrSymbol(tokens, current.toString());
                    current.setLength(0);
                }
                tokens.add(new Symbol(String.valueOf(c)));
            } else {
                // parte de uma palavra/identificador
                current.append(c);
            }
        }

        if (current.length() > 0) {
            addWordOrSymbol(tokens, current.toString());
        }

        return tokens;
    }

    // decide se o caractere é um símbolo “isolado”
    private boolean isSymbolChar(char c) {
        return "(){}[];,+-*/%<>=!&|^?:,.".indexOf(c) >= 0; 
    }

    // transforma uma string em Word ou Symbol
    private void addWordOrSymbol(List<Token> list, String s) {
        boolean isWord = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                isWord = false;
                break;
            }
        }
        if (isWord) {
            list.add(new Word(s));
        } else {
            list.add(new Symbol(s));
        }
    }

    // converte Words que são keywords em Keyword
    protected List<Token> makeKeywords(List<Token> tokens) {
        List<Token> result = new ArrayList<>();
        List<String> kws = keywords();

        for (Token t : tokens) {
            if (t instanceof Word && kws.contains(t.getString())) {
                result.add(new Keyword(t.getString()));
            } else {
                result.add(t);
            }
        }

        return result;
    }
}

package messages;

public class CaesarEncoder extends Encoder {

    private final int shift;

    public CaesarEncoder(int shift) {
        // normaliza para 0..25
        this.shift = ((shift % 26) + 26) % 26;
    }

    private char shiftChar(char ch, int delta) {
        if (!Character.isLetter(ch)) return ch;

        boolean upper = Character.isUpperCase(ch);
        char base;
        if (upper) {
            base = 'A';
        } else {
            base = 'a';
        }
        int pos = ch - base;           // 0..25
        int newPos = (pos + delta + 26) % 26;
        return (char) (base + newPos);
    }

    @Override
    public String encode(String message) {
        if (message == null) return null;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            sb.append(shiftChar(ch, shift));
        }
        return sb.toString();
    }

    @Override
    public String decode(String message) {
        if (message == null) return null;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            sb.append(shiftChar(ch, -shift));
        }
        return sb.toString();
    }
}

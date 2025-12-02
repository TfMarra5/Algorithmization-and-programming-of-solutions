package messages;

public class SubstitutionEncoder extends Encoder {

    private final String key;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public SubstitutionEncoder(String key) {
        this.key = key.toLowerCase();
    }

    @Override
    public String encode(String message) {
        if (message == null) return null;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                boolean isUpper = Character.isUpperCase(ch);
                char lower = Character.toLowerCase(ch);

                int index = ALPHABET.indexOf(lower);
                if (index >= 0) {
                    char encodedChar = key.charAt(index);
                    result.append(isUpper ? Character.toUpperCase(encodedChar) : encodedChar);
                } else {
                    result.append(ch);
                }
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    @Override
    public String decode(String message) {
        if (message == null) return null;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                boolean isUpper = Character.isUpperCase(ch);
                char lower = Character.toLowerCase(ch);

                int index = key.indexOf(lower);
                if (index >= 0) {
                    char decodedChar = ALPHABET.charAt(index);
                    result.append(isUpper ? Character.toUpperCase(decodedChar) : decodedChar);
                } else {
                    result.append(ch);
                }
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}

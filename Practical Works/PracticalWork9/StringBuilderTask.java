public class StringBuilderTask {

    public static int countWordsSplit(String text) {
        if (text == null) return 0;
        String trimmed = text.trim();
        if (trimmed.isEmpty()) return 0;
        return trimmed.split("\\s+").length;
    }

    public static int countWordsScan(String text) {
        if (text == null || text.isEmpty()) return 0;

        int words = 0;
        boolean insideWord = false;

        for (int position = 0; position < text.length(); position++) {
            char letter = text.charAt(position);

            if (Character.isWhitespace(letter)) {
                insideWord = false;
            } else {
                if (!insideWord) {
                    words++;
                    insideWord = true;
                }
            }
        }

        return words;
    }

    public static String toPascalCase(String text) {
        if (text == null || text.isEmpty()) return text;

        StringBuilder result = new StringBuilder();
        boolean startOfWord = true;

        for (int position = 0; position < text.length(); position++) {
            char letter = text.charAt(position);

            if (Character.isLetter(letter)) {
                if (startOfWord) {
                    result.append(Character.toUpperCase(letter));
                    startOfWord = false;
                } else {
                    result.append(Character.toLowerCase(letter));
                }
            } else {
                result.append(letter);
                if (Character.isWhitespace(letter)) startOfWord = true;
            }
        }

        return result.toString();
    }

    public static String removeDuplicateChars(String text) {
        if (text == null || text.isEmpty()) return text;

        StringBuilder sb = new StringBuilder(text);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            for (int j = i + 1; j < sb.length(); j++) {
                if (sb.charAt(j) == c) {
                    sb.deleteCharAt(j);
                    j--;
                }
            }
        }
        return sb.toString();
    }

}

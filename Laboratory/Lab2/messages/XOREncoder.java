package messages;

public class XOREncoder extends Encoder {

    private final String key;

    public XOREncoder(String key) {
        this.key = key;
    }

    private String xorWithKey(String message) {
        if (message == null) return null;

        StringBuilder sb = new StringBuilder();
        int keyLen = key.length();

        for (int i = 0; i < message.length(); i++) {
            char mc = message.charAt(i);
            char kc = key.charAt(i % keyLen);
            char ec = (char) (mc ^ kc);
            sb.append(ec);
        }
        return sb.toString();
    }

    @Override
    public String encode(String message) {
        return xorWithKey(message);
    }

    @Override
    public String decode(String message) {
        // XOR é reversível, encode == decode
        return xorWithKey(message);
    }
}

package compression;

public class NucleotideCompressor {

    // Task 1 – Compression
    public static byte[] compress(String nucleotides) {
        if (nucleotides == null) {
            return new byte[] { 0 };
        }

        int length = nucleotides.length();

        int dataBytes = (length + 3) / 4; 
        
        byte[] res = new byte[1 + dataBytes];
        res[0] = (byte) length;

        int byteIndex = 1;

        int bitPos = 6; 
        byte current = 0;

        for (int i = 0; i < length; i++) {
            char c = nucleotides.charAt(i);
            int val;
            switch (c) {
                case 'A': val = 0b00; break;
                case 'C': val = 0b01; break;
                case 'G': val = 0b10; break;
                case 'T': val = 0b11; break;
                default:  val = 0b00; break;
            }

            current |= (byte) (val << bitPos);
            if (bitPos == 0) {
                res[byteIndex++] = current;
                current = 0;
                bitPos = 6;
            } else {
                bitPos -= 2;
            }
        }
        if (byteIndex < res.length) { 
            res[byteIndex] = current;
        }

        return res;
    }

    // Task 2 - decompress
    public static String decompress(byte[] nucleotides) {
        if (nucleotides == null || nucleotides.length == 0) {
            return "";
        }

        int length = nucleotides[0] & 0xFF;
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int byteIndex = 1 + (i / 4);
            int shift = 6 - 2 * (i % 4);

            int bits = (nucleotides[byteIndex] >> shift) & 0b11;

            char c;
            switch (bits) {
                case 0b00: c = 'A'; break;
                case 0b01: c = 'C'; break;
                case 0b10: c = 'G'; break;
                case 0b11: c = 'T'; break;
                default:   c = 'A'; break;
            }

            sb.append(c);
        }

        return sb.toString();
    }

    // helper para imprimir bits (usado no Main)
    public static String toBits(byte b) {
        String binaryString = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');

        return binaryString + " ";
    }
}
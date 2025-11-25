package compression;

public class NucleotideCompressor {

    public static byte[] compress(String nucleotides) {
        // TODO: Complete this method for Block 3 Task 1
        byte[] res = new byte[1];
        return res;
    }

    public static String decompress(byte[] nucleotides) {
        // TODO: Complete this method for Block 3 Task 2
        return "";
    }
    
    public static void compressExample() {
        // In this example we have a byte where the two
        // most-significant bits represent the nucleotide T (11).
        // The rest of the bits are not used for now (zeros).
        byte data = (byte) 0b11000000; // can replace with hexadecimal: (byte) 0xC0
		System.out.println("initial data:");
		System.out.println(toBits(data));
		
		// We want to encode a nucleotide C (01),
		// so our data will look like this: 11010000
		
		// create a nucleotide C (code 1);
		byte n = 1;
		System.out.println("\nnucleotide C:");
		System.out.println(toBits(n));
		
		// shift the nucleotide 4 positions to the left
		byte res = (byte) (n << 4);
		System.out.println("\nresult after left shift:");
		System.out.println(toBits(res));
		
		// apply bitwise OR to combine the nucleotide with the data
		res = (byte) (data | res);
		System.out.println("\nresult after bitwise OR:");
		System.out.println(toBits(res));
		
		// the result shows the compressed nucleotide
		System.out.printf("\nresult: %d\n", res);
    }
    
    public static void decompressExample() {
        // In this example, we have a byte that has nucleotides:
        // T (11), C (01), A (00) and G (10) encoded in it.
        byte data = (byte) 0b11010010; // can replace with hexadecimal: (byte) 0xD2
		System.out.println("initial data:");
		System.out.println(toBits(data));
		
        // We want to decompress the nucleotide C (01).

		// shift the nucleotide 4 positions to the right
		byte res = (byte) (data >> 4);
		System.out.println("\nresult after right shift:");
		System.out.println(toBits(res));
		
		// create a mask
		byte mask = 0b00000011; // 3
		
		// apply bitwise AND to get rid of the first 6 bits
		res = (byte) (res & mask);
		System.out.println("\nresult after bitwise AND:");
		System.out.println(toBits(res));
		
		// the result is 1, therefore the nucleotide is C
		System.out.printf("\nresult: %d\n", res);
    }

    public static String toBits(byte n) {
        StringBuilder sb = new StringBuilder();

        int mask = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int a = (byte) (n & mask);
            if (a > 0 || a == Byte.MIN_VALUE) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            mask >>>= 1;
            if ((i + 1) % 8 == 0) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

}

public class BitTask {

    public static int countOnes(int number) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((number & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static boolean isOne(int number, int index) {
        return (number & (1 << index)) != 0;
    }

    public static int reverseBit(int number, int index) {
        return number ^ (1 << index);
    }
}

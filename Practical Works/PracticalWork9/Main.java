public class Main {
    public static void main(String[] args) {
        String text = "hello my name is thomas";

        System.out.println(StringBuilderTask.countWordsSplit(text));
        System.out.println(StringBuilderTask.countWordsScan(text));
        System.out.println(StringBuilderTask.toPascalCase(text));
        System.out.println(StringBuilderTask.removeDuplicateChars(text));

        int number = 29;

        System.out.println(BitTask.countOnes(number));
        System.out.println(BitTask.isOne(number, 3));
        System.out.println(BitTask.reverseBit(number, 3));
    }
}

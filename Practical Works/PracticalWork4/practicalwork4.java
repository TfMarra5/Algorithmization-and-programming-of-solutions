import java.util.Scanner;

public class practicalwork4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Practical Work 4 ===");
            System.out.println("1) Input Correctness");
            System.out.println("2) Fibonacci Sequence");
            System.out.println("3) Sum / Average / Min / Max (stop with 0)");
            System.out.println("4) Guessing Game (1..100)");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            }
            else {
                choice = -1;
            }

            sc.nextLine();

            if (choice == 1) {
                inputCorrectness(sc);
            }
            else if (choice == 2) {
                fibonacciSequence(sc);
            }
            else if (choice == 3) {
                sumAverageMinMax(sc);
            }
            else if (choice == 4) {
                guessingGame(sc);
            }
            else if (choice == 0) {
                System.out.println("Exiting.");
                break;
            }
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    // Task 1 
    private static void inputCorrectness(Scanner sc) {
        final int lowNum = 10;
        final int highNum = 20;

        while (true) {
            System.out.print("Enter an integer [" + lowNum + "," + highNum + "]: ");
            if (sc.hasNextInt()) {
                int x = sc.nextInt();
                sc.nextLine();
                if (x >= lowNum && x <= highNum) {
                    System.out.println("OK: " + x + " is inside the interval.");
                    return;
                }
                else {
                    System.out.println("Out of range. Try again.");
                }
            }
            else {
                System.out.println("Not an integer. Try again.");
                sc.nextLine();
            }
        }
    }

    // Task 2
    private static void fibonacciSequence(Scanner sc) {
        System.out.print("How many Fibonacci numbers (N)? ");
        int N;
        if (sc.hasNextInt()) {
            N = sc.nextInt();
        }
        else {
            N = 0;
        }
        sc.nextLine();

        if (N <= 0) {
            System.out.println("Nothing to print.");
            return;
        }
        long a = 0, b = 1;
        for (int i = 1; i <= N; i++) {
            System.out.print(a);
            if (i < N) System.out.print(" ");
            long next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    // Taskk 3
    private static void sumAverageMinMax(Scanner sc) {
        long sum = 0;
        int count = 0;
        Integer min = null, max = null;

        System.out.println("Enter integers (0 to finish):");
        while (true) {
            if (!sc.hasNextInt()) {
                System.out.println("Invalid. Try again.");
                sc.nextLine();
                continue;
            }
            int x = sc.nextInt();
            if (x == 0) {
                sc.nextLine();
                break;
            }
            sum += x;
            count++;
            if (min == null || x < min) min = x;
            if (max == null || x > max) max = x;
        }

        if (count == 0) {
            System.out.println("No numbers entered.");
        }
        else {
            double avg = (double) sum / count;
            System.out.println("Sum = " + sum);
            System.out.println("Average = " + avg);
            System.out.println("Min = " + min);
            System.out.println("Max = " + max);
        }
    }

    // Task 4
    private static void guessingGame(Scanner sc) {
        final int SECRET = 73;
        while (true) {
            System.out.print("Guess (1..100): ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid. Try again.");
                sc.nextLine();
                continue;
            }
            int g = sc.nextInt();
            sc.nextLine();

            if (g == SECRET) {
                System.out.println("Correct!");
                return;
            }
            else if (g < SECRET) {
                System.out.println("Higher.");
            }
            else {
                System.out.println("Lower.");
            }
        }
    }
}

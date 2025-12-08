import java.util.Scanner;
public class OneDArrays {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter length of your array A: ");
    int lengthA = sc.nextInt();
    int[] a = new int[lengthA];
    for (int i = 0; i < a.length; i++) {
      System.out.print("Enter element " + (i + 1) + ": ");
      a[i] = sc.nextInt();
    }
    System.out.print("Enter length of your array B: ");
    int lengthB = sc.nextInt();
    int[] b = new int[lengthB];
    for (int i = 0; i < b.length; i++) {
      System.out.print("Enter element " + (i + 1) + ": ");
      b[i] = sc.nextInt();
    }
    int[] c = new int [a.length + b.length];
    for (int i = 0; i < a.length; i++){
      c[i] = a[i];
    }
    for (int i = 0; i < b.length; i++){
      c[a.length + i] = b[i];
    }
    for (int num : c) {
      System.out.print(num + " ");
    }
    sc.close();
  }
}

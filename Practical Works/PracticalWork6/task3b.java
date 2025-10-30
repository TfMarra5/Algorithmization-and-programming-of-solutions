/*
3.2. Right Shift
  1. Input array length.
  2. Input array elements.
  3. Input number n.
  4. Shift all the elements of the array n positions to the right.
 */
import java.util.*;
public class task3b {
    static void rightShift(int[] arr, int n) {
        int len = arr.length;
        if (n < 0) n = 0;
        for (int i = len - 1; i >= n; i--) {
            arr[i] = arr[i - n];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("arr length: ");
        int len = sc.nextInt();
        int[] arr = new int[len];
        System.out.println("arr numbers : ");
        for (int i = 0; i < len; i++) arr[i] = sc.nextInt();
        System.out.println("Shifted index: ");
        int n = sc.nextInt();
        rightShift(arr, n);
        System.out.print("arr = { ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]);
            if (i < len - 1) System.out.print(" ");
        }
        System.out.println(" }");
        sc.close();
    }
}
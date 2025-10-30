/* 
3.1. Left Shift
    1. Input array length.
    2. Input array elements.
    3. Input number n.
    4. Shift all the elements of the array n positions to the left. 
*/

import java.util.*;
public class task3a {
    static void leftShift(int[] arr, int n) {
        int len = arr.length;
        if (n < 0) n = 0;
        for (int i = 0; i < len - n; i++) {
            arr[i] = arr[i + n];
        }
        for (int i = len - n; i < len; i++) {
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
        leftShift(arr, n);
        System.out.print("arr = { ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]);
            if (i < len - 1) System.out.print(" ");
        }
        System.out.println(" }");
        sc.close();
    }
}
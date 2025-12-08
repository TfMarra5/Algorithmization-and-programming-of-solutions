/*
  1. Input array length.
  2. Input array elements.
  3. Create a static method swap that has 3 parameters 
  and swaps 2 elements of the array with the given indices:
    - int[] arr
    - int i
    - int j
  4. Use swap method to reverse the array.
 */

import java.util.Scanner;
public class task2 {
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("arr length: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("arr elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0, right = n - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
        System.out.print("arr = { ");
        for (int i : arr) {
          System.out.print(i + " ");
        }
        System.out.print(" }");
        sc.close();
    }
}

/*
"Implement any 2 sorting algorithms that were not discussed during the lecture 
(Bubble sort, Selection sort, Insertion sort)."

Class powerpoint was used as reference material.

   * I tried to do 3 sorting algorithms just to be sure.
    
   
*/
public class task1 {
    static int[] bubbleSort(int[] arr) {
       for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
      }
    static int[] selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;           
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr1 = {42, -3, 17, 0, 17, 9};
        int[] arr2 = {100, 7, 7, -20, 55, 1, 0};
        int [] bArr = bubbleSort(arr1);
        int[] sArr = selectionSort(arr2);
        System.out.println("Bubble Sorted Array: ");
        for (int v : bArr) {
            System.out.print(v + " ");
        }
        System.out.println("\nSelection Sorted Array: ");
        for (int v : sArr) {
            System.out.print(v + " ");
        }
    }
}

/*Task 4 – Manhattan distance
  1. Input number n.
  2. Input n points each having x and y.
  3. Calculate and output Manhattan Distance between each 2 point
*/
import java.util.*;

public class task4 {
    static int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n: ");
        int len = sc.nextInt();
        int[][] points = new int[len][2];
        for (int i = 0; i < points.length; i++) {
            System.out.printf("point %d%n", i);
            System.out.print("x: ");
            points[i][0] = sc.nextInt();
            System.out.print("y: ");
            points[i][1] = sc.nextInt();
        }
          for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int d = manhattan(points[i][0], points[i][1], points[j][0], points[j][1]);
                System.out.printf("Manhattan Distance between point %d and point %d is: %d%n", i, j, d);
            }
        }
        sc.close();
    }
}
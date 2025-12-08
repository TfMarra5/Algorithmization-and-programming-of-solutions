public class triangles {
  public static void main(String[] args) {
    int n = 10;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int sum = i + j;
        int v = 0;
        if (sum <= n - 1) {
            v = sum;
        }
        System.out.printf("%2d ", v);
      }
      System.out.println();
    }
  }
}

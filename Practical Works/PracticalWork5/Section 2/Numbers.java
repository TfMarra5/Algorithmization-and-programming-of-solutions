public class Numbers {
  public static void main(String[] args) {
    int n = 10;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int v = j * n + (n - 1 - i);
        System.out.printf("%3d ", v);
      }
      System.out.println();
    }
  }
}

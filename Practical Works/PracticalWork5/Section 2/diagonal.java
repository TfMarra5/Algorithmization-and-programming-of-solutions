public class diagonal {
  public static void main(String[] args) {
    int N = 10;
    int WIDTH = 3;

    int[][] A = new int[N][N];
    int v = 0;

    for (int i = 0; i < N; i++) {
      int j0 = N - 1 - i;
      for (int k = 0; k < WIDTH; k++) {
        int j = j0 - k;
        if (j >= 0) A[i][j] = ++v;
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.printf("%2d ", A[i][j]);
      }
      System.out.println();
    }
  }
}

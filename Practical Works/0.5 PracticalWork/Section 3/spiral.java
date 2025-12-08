public class spiral {
  public static void main(String[] args) {
    int N = 10;
    int[][] A = new int[N][N];

    int top = 0, bottom = N - 1, left = 0, right = N - 1;
    int v = 0;

  while (top <= bottom && left <= right) {
      for (int j = left; j <= right; j++) {
          A[top][j] = v;
          v++;
      }
      top++;

      for (int i = top; i <= bottom; i++) {
          A[i][right] = v;
          v++;
      }
      right--;


      if (top <= bottom) {
          for (int j = right; j >= left; j--) {
              A[bottom][j] = v;
              v++;
          }
          bottom--;
      }

      if (left <= right) {
          for (int i = bottom; i >= top; i--) {
              A[i][left] = v;
              v++;
          }
          left++;
      }
  }


    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) System.out.printf("%2d ", A[i][j]);
      System.out.println();
    }
  }
}

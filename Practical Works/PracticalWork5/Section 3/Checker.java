public class Checker {
  public static void main(String[] args) {
    int N = 10;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int v;
        if (((i + j) % 2) == 0) v = 1;
        else v = 0;

        System.out.printf("%2d ", v);
      }
      System.out.println();
    }
  }
  }

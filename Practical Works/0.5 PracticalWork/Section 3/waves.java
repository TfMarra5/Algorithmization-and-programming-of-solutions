public class waves {
  public static void main(String[] args) {
    int N = 10;
    int period = 6;
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int k = (i + j) % period;
        int v;
        if (k <= 3) v = k;
        else v = period - k;
        System.out.printf("%2d ", v);
      }
      System.out.println();
    }
  }
}

public class Snake {
    public static void main(String[] args) {
        int n = 10;

        for (int i = 0; i < n; i++) {
            int base = (n - 1 - i) * n;

            for (int j = 0; j < n; j++) {
              int v;
              if ((i & 1) == 0) {
                  v = base + j;
              } 
              else {
                  v = base + (n - 1 - j);
              }
                System.out.printf("%-3d ", v);
            }
            System.out.println();
        }
      }
    }
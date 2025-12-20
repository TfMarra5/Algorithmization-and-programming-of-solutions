import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Maze_Generator {

    private static Random rnd = new Random();
    private static int WALL = 1;
    private static int PATH = 0;

    public static int[][] generate(int h, int w) {

        if (h % 2 == 0) {
            h = h + 1;
        }
        if (w % 2 == 0) {
            w = w + 1;
        }

        int[][] m = new int[h][w];

        int y = 0;
        while (y < h) {
            int x = 0;
            while (x < w) {
                m[y][x] = WALL;
                x++;
            }
            y++;
        }

        int startX = 1 + 2 * rnd.nextInt((w - 1) / 2);
        int startY = 1 + 2 * rnd.nextInt((h - 1) / 2);

        Deque<Point> st = new LinkedList<Point>();
        st.addLast(new Point(startX, startY));
        m[startY][startX] = PATH;

        int[] dx = new int[] {0, 2, 0, -2};
        int[] dy = new int[] {-2, 0, 2, 0};

        while (st.isEmpty() == false) {
            Point cur = st.peekLast();

            int[] options = new int[4];
            int optCount = 0;

            int i = 0;
            while (i < 4) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                boolean inside = true;
                if (nx <= 0) inside = false;
                if (nx >= w - 1) inside = false;
                if (ny <= 0) inside = false;
                if (ny >= h - 1) inside = false;

                if (inside == true) {
                    if (m[ny][nx] == WALL) {
                        options[optCount] = i;
                        optCount = optCount + 1;
                    }
                }

                i++;
            }

            if (optCount > 0) {
                int pick = rnd.nextInt(optCount);
                int dir = options[pick];

                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                int midX = cur.x + dx[dir] / 2;
                int midY = cur.y + dy[dir] / 2;

                m[midY][midX] = PATH;
                m[ny][nx] = PATH;

                st.addLast(new Point(nx, ny));
            } else {
                st.pollLast();
            }
        }

        m[0][0] = PATH;
        m[0][1] = PATH;
        m[1][0] = PATH;
        m[1][1] = PATH;

        m[h - 1][w - 1] = PATH;
        m[h - 1][w - 2] = PATH;
        m[h - 2][w - 1] = PATH;
        m[h - 2][w - 2] = PATH;

        return m;
    }

    public static void main(String[] args) {

        int[][] gen = generate(21, 21);

        try {
            Maze_File_Handler.saveMaze(gen, "Mazes/generated_maze.txt");
            System.out.println("Generated maze saved.");
        } catch (IOException e) {
            System.out.println("Could not save generated maze.");
        }
    }
}

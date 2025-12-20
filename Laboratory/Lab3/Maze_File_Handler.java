import java.io.*;
import java.util.Deque;
import java.util.Iterator;

public class Maze_File_Handler {

    public static int[][] loadMaze(String filename) throws IOException {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));

            int[][] rows = new int[64][];
            int count = 0;

            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }

                line = line.trim();
                if (line.length() == 0) {
                    continue;
                }

                String s = "";
                int i = 0;
                while (i < line.length()) {
                    char c = line.charAt(i);
                    if (c != ' ' && c != '\t' && c != '\r') {
                        s = s + c;
                    }
                    i++;
                }

                if (s.length() == 0) {
                    continue;
                }

                int[] row = new int[s.length()];
                int j = 0;
                while (j < s.length()) {
                    char ch = s.charAt(j);
                    if (ch == '0') {
                        row[j] = 0;
                    } else if (ch == '1') {
                        row[j] = 1;
                    } else {
                        row[j] = 0;
                    }
                    j++;
                }

                if (count >= rows.length) {
                    int[][] tmp = new int[rows.length * 2][];
                    int k = 0;
                    while (k < rows.length) {
                        tmp[k] = rows[k];
                        k++;
                    }
                    rows = tmp;
                }

                rows[count] = row;
                count++;
            }

            if (count == 0) {
                return new int[0][0];
            }

            int[][] maze = new int[count][];
            int r = 0;
            while (r < count) {
                maze[r] = rows[r];
                r++;
            }

            return maze;

        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public static void saveSolvedMaze(int[][] maze, Deque<Point> path, String filename) throws IOException {

        char[][] solved = new char[maze.length][maze[0].length];

        int i = 0;
        while (i < maze.length) {
            int j = 0;
            while (j < maze[0].length) {
                if (maze[i][j] == 1) {
                    solved[i][j] = '1';
                } else {
                    solved[i][j] = '0';
                }
                j++;
            }
            i++;
        }

        if (path != null) {
            Iterator<Point> it = path.iterator();
            while (it.hasNext()) {
                Point p = it.next();
                if (p != null) {
                    if (p.y >= 0 && p.y < solved.length) {
                        if (p.x >= 0 && p.x < solved[0].length) {
                            if (solved[p.y][p.x] == '0') {
                                solved[p.y][p.x] = '+';
                            }
                        }
                    }
                }
            }
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename));

            int a = 0;
            while (a < solved.length) {
                int b = 0;
                while (b < solved[a].length) {
                    bw.write(solved[a][b]);
                    b++;
                }
                bw.newLine();
                a++;
            }

        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    public static void saveMaze(int[][] maze, String filename) throws IOException {

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename));

            int i = 0;
            while (i < maze.length) {
                int j = 0;
                while (j < maze[i].length) {
                    bw.write(String.valueOf(maze[i][j]));
                    j++;
                }
                bw.newLine();
                i++;
            }

        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }
}

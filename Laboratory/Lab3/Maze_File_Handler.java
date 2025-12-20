import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

public class Maze_File_Handler {

    public static int[][] loadMaze(String filename) throws IOException {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filename));

            ArrayList<int[]> list = new ArrayList<int[]>();
            int expectedW = -1;

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

                ArrayList<Integer> tmp = new ArrayList<Integer>();

                int i = 0;
                while (i < line.length()) {
                    char c = line.charAt(i);

                    if (c == '0') {
                        tmp.add(Integer.valueOf(0));
                    } else if (c == '1') {
                        tmp.add(Integer.valueOf(1));
                    } else if (c == ' ' || c == '\t' || c == '\r') {
                    } else {
                        throw new IOException("Invalid char in maze file: '" + c + "'");
                    }

                    i++;
                }

                if (tmp.size() == 0) {
                    continue;
                }

                if (expectedW == -1) {
                    expectedW = tmp.size();
                } else {
                    if (tmp.size() != expectedW) {
                        throw new IOException("Maze is not rectangular. Expected width " + expectedW + " but got " + tmp.size());
                    }
                }

                int[] row = new int[tmp.size()];
                int j = 0;
                while (j < tmp.size()) {
                    row[j] = tmp.get(j).intValue();
                    j++;
                }

                list.add(row);
            }

            if (list.size() == 0) {
                return new int[0][0];
            }

            int[][] maze = new int[list.size()][expectedW];

            int y = 0;
            while (y < list.size()) {
                maze[y] = list.get(y);
                y++;
            }

            return maze;

        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    private static void ensureParentDir(String filename) throws IOException {
        File f = new File(filename);
        File p = f.getParentFile();

        if (p != null) {
            if (p.exists() == false) {
                boolean ok = p.mkdirs();
                if (ok == false) {
                    throw new IOException("Could not create directory: " + p.getPath());
                }
            }
        }
    }

    public static void saveSolvedMaze(int[][] maze, Deque<Point> path, String filename) throws IOException {

        ensureParentDir(filename);

        char[][] out = new char[maze.length][maze[0].length];

        int y = 0;
        while (y < maze.length) {
            int x = 0;
            while (x < maze[0].length) {
                if (maze[y][x] == 1) {
                    out[y][x] = '1';
                } else {
                    out[y][x] = '0';
                }
                x++;
            }
            y++;
        }

        if (path != null) {
            Iterator<Point> it = path.iterator();
            while (it.hasNext()) {
                Point p = it.next();

                if (p != null) {
                    if (p.y >= 0 && p.y < out.length) {
                        if (p.x >= 0 && p.x < out[0].length) {
                            if (out[p.y][p.x] == '0') {
                                out[p.y][p.x] = '+';
                            }
                        }
                    }
                }
            }
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename));

            int i = 0;
            while (i < out.length) {
                int j = 0;
                while (j < out[i].length) {
                    bw.write(out[i][j]);
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

    public static void saveMaze(int[][] maze, String filename) throws IOException {

        ensureParentDir(filename);

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename));

            int y = 0;
            while (y < maze.length) {
                int x = 0;
                while (x < maze[y].length) {
                    bw.write(String.valueOf(maze[y][x]));
                    x++;
                }
                bw.newLine();
                y++;
            }

        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }
}

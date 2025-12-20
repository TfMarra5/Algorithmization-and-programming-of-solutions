import java.util.*;

public class Maze_Solution {

    private int[][] maze;
    private int rows;
    private int cols;

    private Point start;
    private Point end;

    public Maze_Solution(int[][] maze, Point start, Point end) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;

        this.start = start;
        this.end = end;
    }

    public static Deque<Point> solveMaze(int[][] maze, Point start, Point end) {
        Maze_Solution ms = new Maze_Solution(maze, start, end);
        // bfs for shortest path
        return ms.solveBFS();
    }

    // simple check
    private boolean okCell(int x, int y) {
        if (x < 0) {
            return false;
        }
        if (y < 0) {
            return false;
        }
        if (x >= cols) {
            return false;
        }
        if (y >= rows) {
            return false;
        }
        if (maze[y][x] != 0) {
            return false;
        }
        return true;
    }

    public Deque<Point> solveDFS() {
        Deque<Point> st = new LinkedList<Point>();
        HashSet<Point> vis = new HashSet<Point>();
        HashMap<Point, Point> parent = new HashMap<Point, Point>();

        st.addLast(start);
        vis.add(start);
        parent.put(start, null);

        while (st.isEmpty() == false) {
            Point cur = st.pollLast();

            if (cur.equals(end)) {
                return buildPath(parent, cur);
            }

            // neighbors (top, right, bottom, left)
            int[] dx = new int[] {0, 1, 0, -1};
            int[] dy = new int[] {-1, 0, 1, 0};

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (okCell(nx, ny)) {
                    Point np = new Point(nx, ny);

                    if (vis.contains(np) == false) {
                        vis.add(np);
                        parent.put(np, cur);
                        st.addLast(np);
                    }
                }
            }
        }

        return null;
    }

    public Deque<Point> solveBFS() {
        Deque<Point> q = new LinkedList<Point>();
        HashMap<Point, Point> parent = new HashMap<Point, Point>();
        HashSet<Point> vis = new HashSet<Point>();

        q.addLast(start);
        vis.add(start);
        parent.put(start, null);

        while (q.isEmpty() == false) {
            Point cur = q.pollFirst();

            if (cur.equals(end)) {
                return buildPath(parent, cur);
            }

            // neighbors (top, right, bottom, left)
            int[] dx = new int[] {0, 1, 0, -1};
            int[] dy = new int[] {-1, 0, 1, 0};

            int i = 0;
            while (i < 4) {
                int nx;
                int ny;
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];
                i = i + 1;

                if (okCell(nx, ny)) {
                    Point np = new Point(nx, ny);

                    if (vis.contains(np) == false) {
                        vis.add(np);
                        parent.put(np, cur);
                        q.addLast(np);
                    }
                }
            }
        }

        return null;
    }

    private Deque<Point> buildPath(HashMap<Point, Point> parent, Point last) {
        if (parent.containsKey(last) == false) {
            return null;
        }

        Deque<Point> path = new LinkedList<Point>();
        Point cur = last;

        while (cur != null) {
            path.addFirst(cur);
            cur = parent.get(cur);
        }

        return path;
    }
}

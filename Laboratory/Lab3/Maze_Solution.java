import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Maze_Solution {

    private final int[][] maze;
    private final int rows;
    private final int cols;
    private final Point start;
    private final Point end;

    public Maze_Solution(int[][] maze, Point start, Point end) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
        this.start = start;
        this.end = end;
    }

    private boolean ok(int x, int y) {
        if (x < 0) return false;
        if (y < 0) return false;
        if (x >= cols) return false;
        if (y >= rows) return false;
        if (maze[y][x] != 0) return false;
        return true;
    }

    public Deque<Point> solveDFS() {

        Deque<Point> stack = new LinkedList<Point>();
        Set<Point> visited = new HashSet<Point>();

        stack.addLast(start);
        visited.add(start);

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        while (stack.isEmpty() == false) {

            Point cur = stack.pollLast();

            if (cur.equals(end)) {
                stack.addLast(cur);
                return stack;
            }

            boolean moved = false;
            int i = 0;

            while (i < 4) {

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (ok(nx, ny)) {
                    Point np = new Point(nx, ny);

                    if (visited.contains(np) == false) {
                        stack.addLast(cur);
                        visited.add(np);
                        stack.addLast(np);
                        moved = true;
                        break;
                    }
                }

                i++;
            }

            if (moved == false) {
            }
        }

        return null;
    }

    public Deque<Point> solveBFS() {

        Deque<Point> queue = new LinkedList<Point>();
        Map<Point, Point> visited = new HashMap<Point, Point>();

        queue.addLast(start);
        visited.put(start, null);

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        while (queue.isEmpty() == false) {

            Point cur = queue.pollFirst();

            if (cur.equals(end)) {
                return buildPath(visited, cur);
            }

            int i = 0;
            while (i < 4) {

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (ok(nx, ny)) {
                    Point np = new Point(nx, ny);

                    if (visited.containsKey(np) == false) {
                        visited.put(np, cur);
                        queue.addLast(np);
                    }
                }

                i++;
            }
        }

        return null;
    }

    private Deque<Point> buildPath(Map<Point, Point> visited, Point last) {

        Deque<Point> path = new LinkedList<Point>();

        Point cur = last;
        while (cur != null) {
            path.addFirst(cur);
            cur = visited.get(cur);
        }

        return path;
    }
}

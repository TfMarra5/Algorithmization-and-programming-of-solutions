import java.io.File;
import java.io.IOException;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {

        File dir = new File("Mazes");
        if (dir.exists() == false) {
            dir.mkdirs();
        }

        String inputFilename = "Mazes/maze1.txt";
        int[][] maze;

        try {
            maze = Maze_File_Handler.loadMaze(inputFilename);
        } catch (IOException e) {
            System.out.println("Error reading: " + inputFilename);
            System.out.println(e.getMessage());
            return;
        }

        if (maze == null) {
            System.out.println("Maze is null.");
            return;
        }
        if (maze.length == 0) {
            System.out.println("Maze is empty.");
            return;
        }
        if (maze[0].length == 0) {
            System.out.println("Maze has no columns.");
            return;
        }

        int rows = maze.length;
        int cols = maze[0].length;

        Point start = new Point(0, 0);
        Point end = new Point(cols - 1, rows - 1);

        Maze_Solution solver = new Maze_Solution(maze, start, end);

        Deque<Point> bfs = solver.solveBFS();
        if (bfs != null) {
            try {
                Maze_File_Handler.saveSolvedMaze(maze, bfs, "Mazes/solved_bfs_maze1.txt");
                System.out.println("BFS solved. Saved: Mazes/solved_bfs_maze1.txt");
            } catch (IOException e) {
                System.out.println("Could not save BFS solution.");
            }
        } else {
            System.out.println("BFS: no path.");
        }

        Deque<Point> dfs = solver.solveDFS();
        if (dfs != null) {
            try {
                Maze_File_Handler.saveSolvedMaze(maze, dfs, "Mazes/solved_dfs_maze1.txt");
                System.out.println("DFS solved. Saved: Mazes/solved_dfs_maze1.txt");
            } catch (IOException e) {
                System.out.println("Could not save DFS solution.");
            }
        } else {
            System.out.println("DFS: no path.");
        }

        int[][] gen = Maze_Generator.generate(21, 21);

        try {
            Maze_File_Handler.saveMaze(gen, "Mazes/generated_maze.txt");
            System.out.println("Generated maze saved: Mazes/generated_maze.txt");
        } catch (IOException e) {
            System.out.println("Could not save generated maze.");
        }

        Point gs = new Point(0, 0);
        Point ge = new Point(gen[0].length - 1, gen.length - 1);

        Maze_Solution genSolver = new Maze_Solution(gen, gs, ge);

        Deque<Point> genBfs = genSolver.solveBFS();
        if (genBfs != null) {
            try {
                Maze_File_Handler.saveSolvedMaze(gen, genBfs, "Mazes/solved_generated_bfs.txt");
                System.out.println("Generated maze solved (BFS). Saved: Mazes/solved_generated_bfs.txt");
            } catch (IOException e) {
                System.out.println("Could not save generated maze solution.");
            }
        } else {
            System.out.println("Generated maze: no path.");
        }

        Deque<Point> genDfs = genSolver.solveDFS();
        if (genDfs != null) {
            try {
                Maze_File_Handler.saveSolvedMaze(gen, genDfs, "Mazes/solved_generated_dfs.txt");
                System.out.println("Generated maze solved (DFS). Saved: Mazes/solved_generated_dfs.txt");
            } catch (IOException e) {
                System.out.println("Could not save generated maze DFS solution.");
            }
        } else {
            System.out.println("Generated maze (DFS): no path.");
        }
    }
}

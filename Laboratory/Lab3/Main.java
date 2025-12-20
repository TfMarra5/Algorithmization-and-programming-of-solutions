import java.io.IOException;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {

        String inputFilename = "Mazes/maze1.txt";
        String outputFilename = "solved_maze1.txt";

        int[][] maze = null;

        try {
            maze = Maze_File_Handler.loadMaze(inputFilename);
        } catch (IOException e) {
            System.out.println("I/O Error: Check if the file exists: " + inputFilename);
            return;
        }

        if (maze == null) {
            System.out.println("Error: maze is null.");
            return;
        }

        if (maze.length == 0) {
            System.out.println("Error: Loaded maze is empty.");
            return;
        }

        if (maze[0] == null) {
            System.out.println("Error: First row is null.");
            return;
        }

        if (maze[0].length == 0) {
            System.out.println("Error: Loaded maze has no columns.");
            return;
        }

        int rows = maze.length;
        int cols = maze[0].length;

        System.out.println("Maze " + inputFilename + " loaded (" + rows + "x" + cols + ").");

        Point start = new Point(0, 0);
        Point end = new Point(cols - 1, rows - 1);

        Deque<Point> path = null;

        try {
            path = Maze_Solution.solveMaze(maze, start, end);
        } catch (Exception e) {
            System.out.println("Error while solving: " + e.getMessage());
            return;
        }

        if (path == null) {
            System.out.println("No path found for " + inputFilename + ".");
            return;
        }

        try {
            Maze_File_Handler.saveSolvedMaze(maze, path, outputFilename);
            System.out.println("Saved to " + outputFilename);
        } catch (IOException e) {
            System.out.println("Could not save file: " + outputFilename);
        }
    }
}

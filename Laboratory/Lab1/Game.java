import java.util.Random;

public class Game {

    public static final Random rand = new Random();

    private static boolean running = true;
    public static boolean isRunning() { return running; }
    public static void stop() { running = false; }

    private static int eaten = 0;
    private static int reverseCount = 1;
    private static int removeCount = 2;

    public static int getEaten() { return eaten; }
    public static int getReverseCount() { return reverseCount; }
    public static int getRemoveCount() { return removeCount; }

    public static void decreaseReverseCount() { if (reverseCount > 0) reverseCount--; }
    public static void decreaseRemoveCount() { if (removeCount > 0) removeCount--; }
    public static void increaseEaten() { eaten++; }

    public static boolean rollChance(double probability) { return rand.nextDouble() <= probability; }

    public static Point getNextPoint(Point head, String dir) {
        if (dir.equals("w"))      return new Point(head.getX() - 1, head.getY());
        else if (dir.equals("a")) return new Point(head.getX(), head.getY() - 1);
        else if (dir.equals("s")) return new Point(head.getX() + 1, head.getY());
        else if (dir.equals("d")) return new Point(head.getX(), head.getY() + 1);
        else                      return null;
    }

    // Task 10
    public static String mirrorDir(String dir) {
        if (dir.equals("w")) return "s";
        if (dir.equals("s")) return "w";
        if (dir.equals("a")) return "d";
        if (dir.equals("d")) return "a";
        return dir;
    }

    public static void drawSnakeOnBoard() {
        char[][] cells = Board.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] == Board.SNAKE_BODY_CHAR || Character.isDigit(cells[i][j])) {
                    cells[i][j] = 0;
                }
            }
        }
        Snake.drawAllSnakes(cells);
    }

    public static void drawFrogOnBoard(Point frog) {
        if (frog != null) {
            char[][] cells = Board.getCells();
            cells[frog.getX()][frog.getY()] = Board.FROG_CHAR;
        }
    }

    public static void drawFrogsOnBoard() {
        char[][] cells = Board.getCells();
        for (int i = 0; i < cells.length; i++)
            for (int j = 0; j < cells[i].length; j++)
                if (cells[i][j] == Board.FROG_CHAR) cells[i][j] = 0;
        Point[] positions = Frogs.getPositions();
        for (Point p : positions) drawFrogOnBoard(p);
    }
}


public class Frogs {

    public static final int FROG_COUNT = 3;

    private static Point[] positions = initializeFrogs();

    public static Point[] getPositions() {
        return positions;
    }

    public static void replaceFrog(Point frog) {
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] != null && positions[i].equals(frog)) {
                positions[i] = Board.getRandomEmptyPoint();
                break;
            }
        }
        Game.drawFrogsOnBoard();
    }

    private static Point[] initializeFrogs() {
        Point[] positions = new Point[FROG_COUNT];
        for (int i = 0; i < FROG_COUNT; i++) {
            Point frog = Board.getRandomEmptyPoint();
            positions[i] = frog;
            Game.drawFrogOnBoard(frog);
        }
        return positions;
    }

}

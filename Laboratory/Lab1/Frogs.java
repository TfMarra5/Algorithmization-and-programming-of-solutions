public class Frogs {

    public static final int FROG_COUNT = 3;

    private static Point[] positions = initializeFrogs();

    public static Point[] getPositions() { return positions; }

    public static void replaceFrog(Point frogCell) {
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] != null && positions[i].equals(frogCell)) {
                positions[i] = Board.getRandomEmptyPoint();
                break;
            }
        }
        Game.drawFrogsOnBoard();
    }

    public static boolean isFrogAt(Point p) {
        for (Point q : positions) if (q != null && q.equals(p)) return true;
        return false;
    }

    // Task 8
    public static void wander() {
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] == null) continue;
            if (!Game.rollChance(0.4)) continue;
            int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
            for (int s = 0; s < 4; s++) {
                int r = Game.rand.nextInt(4);
                int[] tmp = dirs[s]; dirs[s] = dirs[r]; dirs[r] = tmp;
            }
            for (int[] d : dirs) {
                Point np = positions[i].add(d[0], d[1]);
                if (Board.isOutside(np)) continue;
                if (Board.isBlock(np)) continue;
                if (Board.isSnake(np)) continue;
                if (isFrogAt(np)) continue;
                positions[i] = np;
                break;
            }
        }
        Game.drawFrogsOnBoard();
    }

    private static Point[] initializeFrogs() {
        Point[] pos = new Point[FROG_COUNT];
        for (int i = 0; i < FROG_COUNT; i++) {
            Point frog = Board.getRandomEmptyPoint();
            pos[i] = frog;
            Game.drawFrogOnBoard(frog);
        }
        return pos;
    }
}

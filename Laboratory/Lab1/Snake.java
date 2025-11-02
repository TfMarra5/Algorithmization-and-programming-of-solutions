import java.util.Arrays;

public class Snake {

    public static final double GROWTH_FACTOR = 1.5;

    private static Point[] body = {
        new Point(0, 4), new Point(0, 3), new Point(0, 2), new Point(0, 1), new Point(0, 0)
    };
    private static int length = body.length;

    private static Point[] bodyMirror = {
        new Point(9, 5), new Point(9, 6), new Point(9, 7), new Point(9, 8), new Point(9, 9)
    };
    private static int lengthMirror = bodyMirror.length;

    private static boolean digitsSkin = false;

    public static Point[] getBody() { return body; }
    public static int getLength() { return length; }
    public static Point head() {
    if (length > 0) {
        return body[0];
    } else {
        return null;
    }
}

    public static void drawAllSnakes(char[][] cells) {
        drawSnake(cells, body, length);
        drawSnake(cells, bodyMirror, lengthMirror);
    }

    private static void drawSnake(char[][] cells, Point[] b, int len) {
        for (int i = 0; i < len; i++) {
            Point p = b[i];
            if (i == 0) {
                cells[p.getX()][p.getY()] = Board.SNAKE_HEAD_CHAR;
            } else if (!digitsSkin) {
                cells[p.getX()][p.getY()] = Board.SNAKE_BODY_CHAR;
            } else {
                char c = Character.forDigit((i - 1) % 9 + 1, 10);
                cells[p.getX()][p.getY()] = c;
            }
        }
    }

    public static void move(String dir) {
        if (!Game.isRunning()) return;

        Point next = Game.getNextPoint(body[0], dir);
        Point nextM = Game.getNextPoint(bodyMirror[0], Game.mirrorDir(dir));

        boolean nextOK = (next != null) && (canEnter(next));
        boolean nextMOK = (nextM != null) && (canEnter(nextM));

        if (!nextOK && !nextMOK) {
            if (lostNow()) {
                Game.drawSnakeOnBoard();
                System.out.println("you lost!");
                Game.stop();
            }
            return;
        }
        if (nextOK) handleCellEffect(true, next);
        if (nextMOK) handleCellEffect(false, nextM);

        if (!Game.isRunning()) return;

        if (nextOK) shiftForward(body, true, next);
        if (nextMOK) shiftForward(bodyMirror, false, nextM);

        Frogs.wander();

        Game.drawSnakeOnBoard();
    }

    private static boolean canEnter(Point p) {
        if (Board.isOutside(p)) return false;
        if (Board.isSnake(p)) return false;
        if (Board.isBlock(p)) return Game.getRemoveCount() > 0;
        return true;
    }

    private static boolean lostNow() {
        Point h = body[0];
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] d : dirs) {
            Point p = h.add(d[0], d[1]);
            if (Board.isOutside(p)) continue;
            if (Board.isSnake(p)) continue;
            if (Board.isBlock(p)) {
                if (Game.getRemoveCount() > 0) return false;
                continue;
            }
            if (!Board.isOutside(p)) return false;
        }
        return Game.getReverseCount() == 0;
    }

    private static void shiftForward(Point[] b, boolean original, Point next) {
        int len;
            if (original) {
             len = length;
             } else {
    len = lengthMirror;
        }
              for (int i = len - 1; i >= 1; i--) b[i] = b[i - 1];
        b[0] = next;
    }

    private static void growSnake(boolean original) {
        if (original) {
            if (length == body.length) body = Arrays.copyOf(body, (int)(body.length * GROWTH_FACTOR));
            length++;
        } else {
            if (lengthMirror == bodyMirror.length) bodyMirror = Arrays.copyOf(bodyMirror, (int)(bodyMirror.length * GROWTH_FACTOR));
            lengthMirror++;
        }
    }

    private static void handleCellEffect(boolean original, Point nextPoint) {
        if (Board.isBlock(nextPoint)) {
            if (Game.getRemoveCount() > 0) {
                Board.getCells()[nextPoint.getX()][nextPoint.getY()] = 0;
                Game.decreaseRemoveCount();
            } else {
                return;
            }
        }

        if (Board.isFood(nextPoint)) {
            if (Game.rollChance(0.1)) {
                Frogs.replaceFrog(nextPoint);
                System.out.println("frog escaped");
            } else {
                Frogs.replaceFrog(nextPoint);
                growSnake(original);
                Game.increaseEaten();

                if (Game.getEaten() % 10 == 0) {
                    Point where = Board.getRandomEmptyPoint();
                    if (where != null) Board.getCells()[where.getX()][where.getY()] = Board.BLOCK_CHAR;
                }

                if (length + lengthMirror >= Board.maxSnakeLength()) {
                    if (original) {
                       shiftForward(body, original, nextPoint);
                      } else {
                      shiftForward(bodyMirror, original, nextPoint);
                  }
                    Game.drawSnakeOnBoard();
                    System.out.println("you won!");
                    Game.stop();
                }
            }
        }
    }

    public static void reverseBoth() {
        if (Game.getReverseCount() <= 0) return;

        reverseOne(body, length);
        reverseOne(bodyMirror, lengthMirror);

        Game.decreaseReverseCount();
        Game.drawSnakeOnBoard();
    }

    private static void reverseOne(Point[] b, int len) {
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            Point tmp = b[i]; b[i] = b[j]; b[j] = tmp;
        }
    }

    public static void toggleSkin() {
        digitsSkin = !digitsSkin;
        Game.drawSnakeOnBoard();
    }
}

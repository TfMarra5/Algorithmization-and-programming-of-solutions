import java.util.Arrays;

public class Snake {

    public static final double GROWTH_FACTOR = 1.5;

    private static Point[] body = { 
        new Point(0, 4), 
        new Point(0, 3), 
        new Point(0, 2), 
        new Point(0, 1), 
        new Point(0, 0) 
    };

    private static int length = body.length;

    public static Point[] getBody() {
        return body;
    }

    public static int getLength() {
        return length;
    }

    public static void move(String dir) {
        Point nextPoint = Game.getNextPoint(body[0], dir);
        if (nextPoint != null && Board.canMoveTo(nextPoint)) {
            handleFood(nextPoint);
            for (int i = length - 1; i >= 1; i--) {
                body[i] = body[i - 1];
            }
            body[0] = nextPoint;
            Game.drawSnakeOnBoard();
        }
    }

    private static void growSnake() {
        if (length == body.length) {
            body = Arrays.copyOf(body, (int) (body.length * GROWTH_FACTOR));
        }
        length++;
    }

    private static void handleFood(Point nextPoint) {
        if (Board.isFood(nextPoint)) {
            Frogs.replaceFrog(nextPoint);
            growSnake();
            Game.increaseEaten();
        }
    }

}

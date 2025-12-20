public class Point {

    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Point == false) {
            return false;
        }

        Point p = (Point) o;
        if (p.x == x && p.y == y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int r = 17;
        r = r * 31 + x;
        r = r * 31 + y;
        return r;
    }
}

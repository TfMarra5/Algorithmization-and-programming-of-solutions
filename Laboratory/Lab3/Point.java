public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Point)) {
            return false;
        }

        Point p = (Point) o;
        if (p.x == this.x && p.y == this.y) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int r = 17;
        r = r * 31 + x;
        r = r * 31 + y;
        return r;
    }

    @Override
    public String toString() {
        String s = "(" + x + ", " + y + ")";
        return s;
    }
}

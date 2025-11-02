public class Point {

    private int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }

    public void set(int nx, int ny) {
        this.x = nx; this.y = ny;
    }

    public Point add(int dx, int dy) { return new Point(x + dx, y + dy); }
    
    public int distance(Point p) {
        return Math.max(Math.abs(this.x - p.x), Math.abs(this.y - p.y));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) return false;
        Point p = (Point) obj;
        return this.x == p.x && this.y == p.y;
    }

    @Override
    public int hashCode() { return this.x ^ this.y; }

    @Override
    public String toString() { return String.format("(%d, %d)", this.x, this.y); }

    @Override
    public Point clone() { return new Point(this.x, this.y); }
}

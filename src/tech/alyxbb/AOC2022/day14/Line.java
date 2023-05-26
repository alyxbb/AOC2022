package tech.alyxbb.AOC2022.day14;

public class Line {
    public static int lowestPoint = 0;
    Point a;
    Point b;

    public Line(Point a, Point b) {
        if (a.getX() == b.getX() || a.getY() == b.getY()) {
            this.a = a;
            this.b = b;
            if (a.getY()>lowestPoint){
                lowestPoint=a.getY();
            }
            if (b.getY()>lowestPoint){
                lowestPoint=b.getY();
            }
        } else {
            throw new RuntimeException("non aligned points");
        }

    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public boolean isHori() {
        if (a.getY() == b.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCollision(Point pt) {
        if (isHori()) {
            if (pt.getY() == a.getY()) {
                int maxPt = Integer.max(a.getX(), b.getX());
                int minPt = Integer.min(a.getX(), b.getX());
                if (minPt <= pt.getX() && pt.getX() <= maxPt) {
                    return true;

                }
            }
        } else {
            if (pt.getX() == a.getX()) {
                int maxPt = Integer.max(a.getY(), b.getY());
                int minPt = Integer.min(a.getY(), b.getY());
                if (minPt <= pt.getY() && pt.getY() <= maxPt) {
                    return true;
                }

            }

        }
        return false;
    }
}

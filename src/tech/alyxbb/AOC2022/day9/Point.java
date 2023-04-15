package tech.alyxbb.AOC2022.day9;

import java.util.ArrayList;

public class Point {
    private int x;
    private int y;

    @Override
    public int hashCode() {
        return (x + " " + y + "").hashCode();
    }

    public boolean equals(final Object point) {
        Point pt = (Point) point;
        return (this.x == pt.x) && (this.y == pt.y);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int[] points) {
        this(points[0], points[1]);
    }

    public Point(ArrayList<Integer> points) {
        this(points.get(0), points.get(1));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getPoints() {
        return new int[]{x, y};
    }

    public void setPoints(int[] points) {
        this.x = points[0];
        this.y = points[1];
    }
}

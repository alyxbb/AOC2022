package tech.alyxbb.AOC2022.day9;

public class Head extends Point {
    public Head(final int x, final int y) {
        super(x, y);
    }

    public void moveL() {
        setX(getX() - 1);
    }

    public void moveR() {
        setX(getX() + 1);
    }

    public void moveD() {
        setY(getY() - 1);
    }

    public void moveU() {
        setY(getY() + 1);
    }
}

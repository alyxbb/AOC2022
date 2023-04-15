package tech.alyxbb.AOC2022.day9;

import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.Math.abs;

public class Tail extends Point {

    private HashSet<Point> visited = new HashSet<>();

    public Tail(int x, int y) {
        super(x, y);
        visited.add(new Point(this.getPoints()));

    }

    public Tail(int[] points) {
        super(points);
    }

    public Tail(ArrayList<Integer> points) {
        super(points);
        
    }

    public int getPointCount() {
        return visited.size();
    }

    public void chase(int[] target) {
        int xDiff = target[0] - this.getX();
        int yDiff = target[1] - this.getY();
        boolean touching = abs(xDiff) <= 1 && abs(yDiff) <= 1;
        if (!touching) {
            switch (xDiff) {
                case 2:
                case 1:
                    setX(getX() + 1);
                    break;
                case -2:
                case -1:
                    setX(getX() - 1);
                    break;
            }
            switch (yDiff) {
                case 2:
                case 1:
                    setY(getY() + 1);
                    break;
                case -2:
                case -1:
                    setY(getY() - 1);
            }
            visited.add(new Point(this.getPoints()));
        }

    }
}

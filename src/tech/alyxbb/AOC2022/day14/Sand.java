package tech.alyxbb.AOC2022.day14;

import java.util.ArrayList;

public class Sand extends Point {
    public static ArrayList<Line> lineList = new ArrayList<>();

    public Sand() {
        super(500, 0);
    }

    public boolean settle() {
        while (getY() < Line.lowestPoint) {
            if (testPoint(getX(), getY() + 1)) {
                setY(getY() + 1);
            } else if (testPoint(getX() - 1, getY() + 1)) {
                setY(getY() + 1);
                setX(getX() - 1);
            } else if (testPoint(getX() + 1, getY() + 1)) {
                setY(getY() + 1);
                setX(getX() + 1);
            } else{
                lineList.add(new Line(getX(),getY(),getX(),getY()));
                return true;
            }
        }
        return false;
    }

    public boolean testPoint(int x, int y) {
        Point provisionalPoint = new Point(x, y);
        for (Line line : lineList
        ) {
            if (line.checkCollision(provisionalPoint)) {
                return false;
            }
        }
        return true;
    }
}

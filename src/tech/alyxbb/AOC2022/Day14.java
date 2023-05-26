package tech.alyxbb.AOC2022;

import tech.alyxbb.AOC2022.abc.IntDay;
import tech.alyxbb.AOC2022.day14.Line;
import tech.alyxbb.AOC2022.day14.Point;
import tech.alyxbb.AOC2022.day14.Sand;

import java.util.ArrayList;
import java.util.Arrays;

public class Day14 extends IntDay {

    public Day14(final String inp) {
        super(inp);
    }

    public Integer part1() {
        final String[] lines = this.input.split("\n");
        final ArrayList<ArrayList<ArrayList<Integer>>> shapeList = new ArrayList<>();
        for (final String line : lines) {
            final String[] points = line.split(" -> ");
            final ArrayList<ArrayList<Integer>> coordListList = new ArrayList<>();
            for (final String point : points) {
                final String[] coords = point.split(",");
                final ArrayList<Integer> coordList = new ArrayList<>();
                for (final String coord : coords) {
                    coordList.add(Integer.parseInt(coord));
                }
                coordListList.add(coordList);
            }
            shapeList.add(coordListList);
        }
        final ArrayList<Line> lineList = new ArrayList<>();

        for (final ArrayList<ArrayList<Integer>> shape : shapeList) {
            for (int i = 1; i < shape.size(); i++) {
                final ArrayList<Integer> p1 = shape.get(i - 1);
                final ArrayList<Integer> p2 = shape.get(i);
                lineList.add(new Line(p1.get(0), p1.get(1), p2.get(0), p2.get(1)));
            }
        }
        Sand.lineList = lineList;
        int i = 0;
        while (true) {
            final Sand sand = new Sand();
            if (!sand.settle()) {
                break;
            }
            i++;
        }
        return i;
    }

    public Integer part2() {
        final String[] lines = this.input.split("\n");
        final ArrayList<ArrayList<ArrayList<Integer>>> shapeList = new ArrayList<>();
        for (final String line : lines) {
            final String[] points = line.split(" -> ");
            final ArrayList<ArrayList<Integer>> coordListList = new ArrayList<>();
            for (final String point : points) {
                final String[] coords = point.split(",");
                final ArrayList<Integer> coordList = new ArrayList<>();
                for (final String coord : coords) {
                    coordList.add(Integer.parseInt(coord));
                }
                coordListList.add(coordList);
            }
            shapeList.add(coordListList);
        }
        int lowestPoint = 0;

        for (final ArrayList<ArrayList<Integer>> shape : shapeList) {
            for (final ArrayList<Integer> point : shape) {
                if (point.get(1) > lowestPoint) {
                    lowestPoint = point.get(1);
                }
            }
        }

        final boolean[][] area = new boolean[lowestPoint + 3][1000];
        for (final ArrayList<ArrayList<Integer>> shape : shapeList) {
            for (int i = 1; i < shape.size(); i++) {
                final ArrayList<Integer> p1 = shape.get(i - 1);
                final ArrayList<Integer> p2 = shape.get(i);
                if (p1.get(0).equals(p2.get(0))) { // vertical line
                    final int miny = Math.min(p1.get(1), p2.get(1));
                    final int maxy = Math.max(p1.get(1), p2.get(1));
                    for (int j = miny; j <= maxy; j++) {
                        area[j][p1.get(0)] = true;
                    }
                } else {
                    final int minx = Math.min(p1.get(0), p2.get(0));
                    final int maxx = Math.max(p1.get(0), p2.get(0));
                    for (int j = minx; j <= maxx; j++) {
                        area[p1.get(1)][j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < area[area.length - 1].length; i++) {
            area[area.length - 1][i] = true;
        }
        int count = 0;
        while (true) {
            count++;
            int curr_x = 500;
            int curr_y = 0;
            while (true) {
                if (!area[curr_y + 1][curr_x]) {
                    curr_y++;
                } else if (!area[curr_y + 1][curr_x - 1]) {
                    curr_x--;
                    curr_y++;
                } else if (!area[curr_y + 1][curr_x + 1]) {
                    curr_x++;
                    curr_y++;
                } else {
                    area[curr_y][curr_x] = true;
                    break;
                }
            }
            if (area[0][500]) {
                break;
            }

        }

        return count;
    }
}

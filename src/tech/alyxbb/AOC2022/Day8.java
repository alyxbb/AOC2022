package tech.alyxbb.AOC2022;

import tech.alyxbb.AOC2022.abc.IntDay;

import java.util.Arrays;

public class Day8 extends IntDay {
    public Day8(String inp) {
        super(inp);
    }

    public Integer part1() {
        int[][] heights = Arrays.stream(input.split("\n"))
                .map(row -> row
                        .chars()
                        .mapToObj(c -> Character.toString((char) c))
                        .map(elem -> Integer.parseInt(elem))
                        .mapToInt(Integer::intValue)
                        .toArray()
                )
                .toArray(int[][]::new);
        boolean[][] ltr = new boolean[heights.length][heights[0].length];
        boolean[][] rtl = new boolean[heights.length][heights[0].length];
        boolean[][] utd = new boolean[heights.length][heights[0].length];
        boolean[][] dtu = new boolean[heights.length][heights[0].length];


        for (int rowIndex = 0; rowIndex < heights.length; rowIndex++) {
            int maxheight = -1;
            for (int colIndex = 0; colIndex < heights[rowIndex].length; colIndex++) {
                int valtotest = heights[rowIndex][colIndex];
                if (valtotest > maxheight) {
                    maxheight = valtotest;
                    ltr[rowIndex][colIndex] = false;
                } else {
                    ltr[rowIndex][colIndex] = true;
                }
            }
        }
        for (int rowIndex = 0; rowIndex < heights.length; rowIndex++) {
            int maxheight = -1;
            for (int colIndex = heights[rowIndex].length - 1; colIndex >= 0; colIndex--) {
                int valtotest = heights[rowIndex][colIndex];
                if (valtotest > maxheight) {
                    maxheight = valtotest;
                    rtl[rowIndex][colIndex] = false;
                } else {
                    rtl[rowIndex][colIndex] = true;
                }
            }
        }
        for (int colIndex = 0; colIndex < heights[0].length; colIndex++) {
            int maxheight = -1;
            for (int rowIndex = 0; rowIndex < heights.length; rowIndex++) {
                int valtotest = heights[rowIndex][colIndex];
                if (valtotest > maxheight) {
                    maxheight = valtotest;
                    utd[rowIndex][colIndex] = false;
                } else {
                    utd[rowIndex][colIndex] = true;
                }
            }
        }
        for (int colIndex = 0; colIndex < heights[0].length; colIndex++) {
            int maxheight = -1;
            for (int rowIndex = heights.length - 1; rowIndex >= 0; rowIndex--) {
                int valtotest = heights[rowIndex][colIndex];
                if (valtotest > maxheight) {
                    maxheight = valtotest;
                    dtu[rowIndex][colIndex] = false;
                } else {
                    dtu[rowIndex][colIndex] = true;
                }
            }
        }
        Boolean[][] hidden = new Boolean[heights.length][heights[0].length];
        for (int rowIndex = 0; rowIndex < hidden.length; rowIndex++) {
            for (int colIndex = 0; colIndex < hidden[rowIndex].length; colIndex++) {
                hidden[rowIndex][colIndex] = utd[rowIndex][colIndex]
                        && dtu[rowIndex][colIndex]
                        && ltr[rowIndex][colIndex]
                        && rtl[rowIndex][colIndex];
            }
        }
        int visible = Arrays.stream(hidden)
                .map(row -> (int) Arrays.stream(row)
                        .filter(visibility -> visibility)
                        .count())
                .reduce(0, (a, b) -> a + b);
        int total = heights.length * heights[0].length;

        return total - visible;
    }

    public Integer part2() {
        int[][] heights = Arrays.stream(input.split("\n"))
                .map(row -> row
                        .chars()
                        .mapToObj(c -> Character.toString((char) c))
                        .map(elem -> Integer.parseInt(elem))
                        .mapToInt(Integer::intValue)
                        .toArray()
                )
                .toArray(int[][]::new);
        int[][] scores = new int[heights.length][heights[0].length];
        for (int rowIndex = 0; rowIndex < heights.length; rowIndex++) {
            for (int colIndex = 0; colIndex < heights[rowIndex].length; colIndex++) {
                //there is a bug where trees on the edge get a score of zero, however trees on the edge are unlikely to 
                // have the max score
                int value = heights[rowIndex][colIndex];
                int[] dists = new int[4];
                for (int testcolIndex = colIndex + 1; testcolIndex < heights[rowIndex].length; testcolIndex++) {
                    dists[0]++;
                    if (heights[rowIndex][testcolIndex] >= value) {
                        break;
                    }
                }
                for (int testRowIndex = rowIndex + 1; testRowIndex < heights.length; testRowIndex++) {
                    dists[1]++;
                    if (heights[testRowIndex][colIndex] >= value) {
                        break;
                    }
                }
                for (int testcolIndex = colIndex - 1; testcolIndex >= 0; testcolIndex--) {
                    dists[2]++;
                    if (heights[rowIndex][testcolIndex] >= value) {
                        break;
                    }
                }
                for (int testRowIndex = rowIndex - 1; testRowIndex >= 0; testRowIndex--) {
                    dists[3]++;
                    if (heights[testRowIndex][colIndex] >= value) {
                        break;
                    }
                }
                int score =Arrays.stream(dists).reduce(1, (a, b) -> a * b);
                scores[rowIndex][colIndex]=score;

            }
        }
        int maxscore = Arrays.stream(scores)
                .map(row -> Arrays.stream(row)
                        .max()
                        .getAsInt())
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
        return maxscore;
    }
}

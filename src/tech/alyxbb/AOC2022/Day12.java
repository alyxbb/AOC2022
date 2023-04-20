package tech.alyxbb.AOC2022;

import tech.alyxbb.AOC2022.abc.IntDay;

import java.util.ArrayList;
import java.util.Arrays;

public class Day12 extends IntDay {

    public Day12(final String inp) {
        super(inp);
    }

    public Integer part1() {
        int[][] elems = Arrays.stream(this.input.split("\n"))
                .map(
                        row -> row.chars()
                                .map(
                                        item -> {
                                            if (97 <= item) {
                                                return item - 97;
                                            } else if (item == 'S') {
                                                return -1;
                                            } else {
                                                return 26;
                                            }
                                        }
                                )
                                .toArray()
                )
                .toArray(int[][]::new);

        int startRow = -1;
        int startCol = -1;
        int endRow = -1;
        int endCol = -1;

        int[][] dists = new int[elems.length][elems[0].length];
        boolean[][] visited = new boolean[elems.length][elems[0].length];

        for (int i = 0; i < elems.length; i++) {
            for (int j = 0; j < elems[i].length; j++) {
                if (elems[i][j] == -1) {
                    startRow = i;
                    startCol = j;
                } else if (elems[i][j] == 26) {
                    endRow = i;
                    endCol = j;
                }
            }
        }
        int currRow = startRow;
        int currCol = startCol;

        visited[currRow][currCol] = true;

        do {
            int currDist = dists[currRow][currCol];

            int[][] toCheck = {
                    {currRow, currCol - 1},
                    {currRow, currCol + 1},
                    {currRow - 1, currCol},
                    {currRow + 1, currCol}
            };

            for (int[] coords : toCheck) {
                boolean inGrid = coords[0] >= 0 && coords[1] >= 0 && coords[0] < elems.length && coords[1] < elems[0].length;

                if (inGrid) {
                    boolean notVisited = !visited[coords[0]][coords[1]];
                    boolean not2Bigger = elems[coords[0]][coords[1]] <= elems[currRow][currCol] + 1;

                    if (notVisited && not2Bigger) {
                        int nextDist = currDist + 1;
                        if (dists[coords[0]][coords[1]] == 0 || nextDist < dists[coords[0]][coords[1]]) {
                            dists[coords[0]][coords[1]] = nextDist;
                        }
                    }
                }

            }
            //find next node and visit it
            int minDist = Integer.MAX_VALUE;
            int minRow = -1;
            int minCol = -1;
            for (int i = 0; i < dists.length; i++) {
                for (int j = 0; j < dists[i].length; j++) {
                    if (dists[i][j] != 0 && dists[i][j] < minDist && !visited[i][j]) {
                        minDist = dists[i][j];
                        minRow = i;
                        minCol = j;
                    }
                }
            }
            currRow = minRow;
            currCol = minCol;
            visited[currRow][currCol] = true;

        } while (!visited[endRow][endCol]);

        return dists[endRow][endCol];
    }

    public Integer part2() {
        // this takes about 2 min to run but it works. im sure there are better algorithms
        int[][] elems = Arrays.stream(this.input.split("\n"))
                .map(
                        row -> row.chars()
                                .map(
                                        item -> {
                                            if (97 <= item) {
                                                return item - 97;
                                            } else if (item == 'S') {
                                                return -1;
                                            } else {
                                                return 26;
                                            }
                                        }
                                )
                                .toArray()
                )
                .toArray(int[][]::new);


        int endRow = -1;
        int endCol = -1;


        ArrayList<int[]> potentailStarts = new ArrayList<>();
        int bestestDist = Integer.MAX_VALUE;


        for (int i = 0; i < elems.length; i++) {
            for (int j = 0; j < elems[i].length; j++) {
                if (elems[i][j] == -1 || elems[i][j] == 0) {
                    potentailStarts.add(new int[]{i, j});
                } else if (elems[i][j] == 26) {
                    endRow = i;
                    endCol = j;
                }
            }
        }

        for (int[] potentialStart : potentailStarts) {
            int[][] dists = new int[elems.length][elems[0].length];
            boolean[][] visited = new boolean[elems.length][elems[0].length];
            
            int startRow = potentialStart[0];
            int startCol = potentialStart[1];

            int currRow = startRow;
            int currCol = startCol;
            visited[currRow][currCol] = true;

            do {
                int currDist = dists[currRow][currCol];

                int[][] toCheck = {
                        {currRow, currCol - 1},
                        {currRow, currCol + 1},
                        {currRow - 1, currCol},
                        {currRow + 1, currCol}
                };

                for (int[] coords : toCheck) {
                    boolean inGrid = coords[0] >= 0 && coords[1] >= 0 && coords[0] < elems.length && coords[1] < elems[0].length;

                    if (inGrid) {
                        boolean notVisited = !visited[coords[0]][coords[1]];
                        boolean not2Bigger = elems[coords[0]][coords[1]] <= elems[currRow][currCol] + 1;

                        if (notVisited && not2Bigger) {
                            int nextDist = currDist + 1;
                            if (dists[coords[0]][coords[1]] == 0 || nextDist < dists[coords[0]][coords[1]]) {
                                dists[coords[0]][coords[1]] = nextDist;
                            }
                        }
                    }

                }
                //find next node and visit it
                int minDist = Integer.MAX_VALUE;
                int minRow = -1;
                int minCol = -1;
                for (int i = 0; i < dists.length; i++) {
                    for (int j = 0; j < dists[i].length; j++) {
                        if (dists[i][j] != 0 && dists[i][j] < minDist && !visited[i][j]) {
                            minDist = dists[i][j];
                            minRow = i;
                            minCol = j;
                        }
                    }
                }
                if (minRow == -1){
                    break;
                }
                currRow = minRow;
                currCol = minCol;
                visited[currRow][currCol] = true;

            } while (!visited[endRow][endCol]);
            if (dists[endRow][endCol] < bestestDist&& dists[endRow][endCol] != 0) {
                bestestDist = dists[endRow][endCol];
            }
        }
        return bestestDist;
    }
}

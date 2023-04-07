package tech.alyxbb.AOC2022;

public class Day1 extends Day {

    public Day1(String inp) {
        super(inp);
    }

    public int part1() {
        String[] foods = this.input.split("\n");
        int max = 0;
        int tot = 0;
        for (String food : foods) {
            if (food.equals("")) {
                if (tot >= max) {
                    max = tot;
                }
                tot = 0;
            } else {
                tot += Integer.parseInt(food);
            }
        }
        return max;
    }

    public int part2() {
        String[] foods = this.input.split("\n");
        int[] max = {0, 0, 0};
        int tot = 0;
        for (String food : foods) {
            if (food.equals("")) {
                if (tot >= max[0]) {
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = tot;
                } else if (tot >= max[1]) {
                    max[2] = max[1];
                    max[1] = tot;
                } else if (tot >= max[2]) {
                    max[2] = tot;
                }
                tot = 0;
            } else {
                tot += Integer.parseInt(food);
            }
        }
        return max[0] + max[1] + max[2];
    }

}

package tech.alyxbb.AOC2022;

public class Day2 extends IntDay {


    public Day2(String inp) {
        super(inp);
    }

    Integer part1() {
        String[] matches = input.split("\n");
        int score = 0;
        for (String match : matches) {
            String[] players = match.split(" ");
            int p1 = 0;
            int p2 = 0;
            switch (players[0]) {
                case "A" -> p1 = -1;
                case "B" -> p1 = 0;
                case "C" -> p1 = 1;
            }
            switch (players[1]) {
                case "X" -> p2 = -1;
                case "Y" -> p2 = 0;
                case "Z" -> p2 = 1;
            }
            score += p2 + 2;
            if (p1 == p2) {
                score += 3;
            } else {
                int result = p1 - p2;
                if (2 == result || -1 == result) {
                    score += 6;
                }
            }
        }
        return score;
    }

    Integer part2() {

        String[] matches = input.split("\n");
        int score = 0;
        for (String match : matches) {
            String[] players = match.split(" ");
            int result = 0;
            switch (players[1]) {
                case "X" -> result = -1;
                case "Y" -> result = 0;
                case "Z" -> result = 1;
            }
            score += 3 * (result + 1);
            switch (match) {//there is probably a better way to do this, but I couldnt find one
                case "A X", "C Y", "B Z" -> score += 3;
                case "B X", "A Y", "C Z" -> score += 1;
                case "C X", "B Y", "A Z" -> score += 2;
            }
        }
        return score;
    }
}

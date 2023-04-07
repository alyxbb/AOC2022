package tech.alyxbb.AOC2022;

public class Day3 extends IntDay {

    public Day3(String inp) {
        super(inp);
    }

    Integer part1() {
        String[] rucksacks = input.split("\n");
        int tot = 0;
        for (String rucksack : rucksacks) {
            String[] rucksackParts = {rucksack.substring(0, rucksack.length() / 2), rucksack.substring(rucksack.length() / 2)};
            char duplicate = findMatching(rucksackParts);
            tot += getPriority(duplicate);

        }
        return tot;
    }

    private static int getPriority(char duplicate) {
        int priority;
        if (duplicate >= 97) {
            priority = duplicate - 96;
        } else {
            priority = duplicate - 38;
        }
        return priority;
    }

    private static char findMatching(String[] rucksackParts) {
        for (char c : rucksackParts[0].toCharArray()) {
            for (char d : rucksackParts[1].toCharArray()) {
                if (c == d) {
                    return c;
                }
            }
        }
        throw new RuntimeException("Invalid input");
    }

    Integer part2() {
        String[] rucksacks = input.split("\n");
        int tot = 0;
        for (int rucksack = 0; rucksack < rucksacks.length; rucksack += 3) {

            char duplicate = findMatchingThree(rucksacks[rucksack], rucksacks[rucksack + 1], rucksacks[rucksack + 2]);
            tot += getPriority(duplicate);

        }
        return tot;
    }

    private char findMatchingThree(String rucksack1, String rucksack2, String rucksack3) {
        for (char c : rucksack1.toCharArray()) {
            for (char d : rucksack2.toCharArray()) {
                for (char e : rucksack3.toCharArray()) {
                    if (c == d && c == e) {
                        return c;
                    }
                }

            }
        }
        throw new RuntimeException("Invalid input");

    }

}

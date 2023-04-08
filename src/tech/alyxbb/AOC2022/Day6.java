package tech.alyxbb.AOC2022;

import java.util.*;

public class Day6 extends IntDay {
    public Day6(String inp) {
        super(inp);
    }

    Integer part1() {
        String device = input;

        Character[] letters = device.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        for (int i = 3; i < letters.length; i++) {
            Character[] subArr = Arrays.copyOfRange(letters, i - 3, i + 1);
            Set<Character> set = new HashSet<>(Arrays.asList(subArr));
            if (4 == set.size()) {
                return i + 1;
            }
        }
        throw new RuntimeException("Invalid input");
    }


    Integer part2() {
        String device = input;

        Character[] letters = device.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        for (int i = 13; i < letters.length; i++) {
            Character[] subArr = Arrays.copyOfRange(letters, i - 13, i + 1);
            Set<Character> set = new HashSet<>(Arrays.asList(subArr));
            if (14 == set.size()) {
                return i + 1;
            }
        }
        throw new RuntimeException("Invalid input");
    }
}

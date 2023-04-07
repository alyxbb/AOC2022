package tech.alyxbb.AOC2022;

public abstract class Day {
    String input;

    public Day(String inp) {
        input = inp;
    }

    abstract Object part1();

    abstract Object part2();
}

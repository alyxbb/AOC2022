package tech.alyxbb.AOC2022;

public abstract class Day {
    String input;

    public Day(String inp) {
        input = inp;
    }

    abstract int part1();

    abstract int part2();
}

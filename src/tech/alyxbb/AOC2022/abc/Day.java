package tech.alyxbb.AOC2022.abc;

public abstract class Day {
    public final String input;

    public Day(String inp) {
        input = inp;
    }

    public abstract Object part1();

    public abstract Object part2();
}

package tech.alyxbb.AOC2022.abc;

public abstract class Day {
    public String input;

    public Day(String inp) {
        input = inp;
    }

    public abstract Object part1();

    public abstract Object part2();
}

package tech.alyxbb.AOC2022;

import tech.alyxbb.AOC2022.day10.PC;
import tech.alyxbb.AOC2022.day10.Register;

import static java.lang.Math.abs;

public class Day10 extends NullDay {
    int signalStrengths = 0;

    public Day10(String inp) {
        super(inp);
    }

    @Override
    public Integer part1() {

        String[] instructions = input.split("\n");
        Register xReg = new Register();
        Register pc = new PC();


        for (String instruction : instructions) {
            String[] instParts = instruction.split(" ");
            switch (instParts[0]) {
                case "noop":
                    incPC(pc, xReg);
                    break;
                case "addx":

                    incPC(2, pc, xReg);
                    xReg.increment(Integer.parseInt(instParts[1]));
            }
        }
        System.out.println(signalStrengths);
        return null;
    }

    private void incPC(Register pc, Register xReg) {
        pc.increment();
        if ((pc.getValue() - 20) % 40 == 0) {
            signalStrengths += pc.getValue() * xReg.getValue();
        }
    }

    private void incPC(int amount, Register pc, Register xReg) {
        for (int i = 0; i < amount; i++) {
            incPC(pc, xReg);
        }
    }

    private void p2incPC(Register pc, Register xReg) {
        if (abs((pc.getValue() % 40) - xReg.getValue()) <= 1) {
            signalStrengths += pc.getValue() * xReg.getValue();
            screen[pc.getValue()] = true;
        }
        pc.increment();

    }

    private void p2incPC(int amount, Register pc, Register xReg) {
        for (int i = 0; i < amount; i++) {
            p2incPC(pc, xReg);
        }
    }

    boolean[] screen;

    @Override
    Object part2() {
        screen = new boolean[240];
        String[] instructions = input.split("\n");
        Register xReg = new Register();
        Register pc = new PC();

        for (String instruction : instructions) {
            String[] instParts = instruction.split(" ");
            switch (instParts[0]) {
                case "noop":
                    p2incPC(pc, xReg);
                    break;
                case "addx":

                    p2incPC(2, pc, xReg);
                    xReg.increment(Integer.parseInt(instParts[1]));
            }
        }
        for (int i = 0; i < screen.length; i++) {
            if (i % 40 == 0) {
                System.out.println();
            }
            if (screen[i]) {
                System.out.print("#");
            } else {
                System.out.print(".");
            }


        }
        System.out.println();
        return null;
    }
}

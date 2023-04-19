package tech.alyxbb.AOC2022;

import tech.alyxbb.AOC2022.abc.LongDay;
import tech.alyxbb.AOC2022.day11.Monkey;
import tech.alyxbb.AOC2022.day11.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static tech.alyxbb.AOC2022.day11.Operation.*;

public class Day11 extends LongDay {
    public Day11(String inp) {
        super(inp);
    }

    public Long part1() {
        ArrayList<Monkey> monkeys = new ArrayList<>(Collections.nCopies(100, null));

        String[] monkeysInput = input.split("\n\n");
        for (String monkeyText : monkeysInput) {
            String[] monkeylines = monkeyText.split("\n");
            int num = 0;
            long[] startingItems = new long[0];
            Operation operation = null;
            int operationAmount = 0;
            int test = 0;
            Monkey trueMonkey = null;
            Monkey falseMonkey = null;

            String numPart = monkeylines[0].split(" ")[1];
            num = Integer.parseInt(numPart.substring(0, numPart.length() - 1));
            for (String line : monkeylines) {
                String[] parts = line.split(": ");
                switch (parts[0]) {
                    case "  Starting items":
                        startingItems = Arrays.stream(parts[1].split(", "))
                                .mapToLong(val -> Long.parseLong(val))
                                .toArray();
                        break;
                    case "  Operation":
                        String[] opParts = parts[1].split(" ");
                        if (parts[1].equals("new = old * old")) {
                            operation = SQUARED;
                        } else {
                            operationAmount = Integer.parseInt(opParts[4]);
                            switch (opParts[3]) {
                                case "+":
                                    operation = ADD;
                                    break;
                                case "*":
                                    operation = MULTIPLY;
                                    break;
                                default:
                                    throw new RuntimeException("invalid input");
                            }
                        }
                        break;
                    case "  Test":
                        test = Integer.parseInt(parts[1].split(" ")[2]);
                        break;
                    case "    If true":
                        int trueMonkeyNo = Integer.parseInt(parts[1].split(" ")[3]);
                        if (monkeys.size() <= trueMonkeyNo || monkeys.get(trueMonkeyNo) == null) {
                            trueMonkey = new Monkey();
                            monkeys.set(trueMonkeyNo, trueMonkey);
                        } else {
                            trueMonkey = monkeys.get(trueMonkeyNo);

                        }
                        break;
                    case "    If false":
                        int falseMonkeyNo = Integer.parseInt(parts[1].split(" ")[3]);
                        if (monkeys.size() <= falseMonkeyNo || monkeys.get(falseMonkeyNo) == null) {
                            falseMonkey = new Monkey();
                            monkeys.set(falseMonkeyNo, falseMonkey);
                        } else {
                            falseMonkey = monkeys.get(falseMonkeyNo);
                        }
                        break;
                }
            }

            if (monkeys.size() <= num || monkeys.get(num) == null) {
                Monkey monkey = new Monkey(startingItems, operation, operationAmount, test, trueMonkey, falseMonkey);
                monkeys.set(num, monkey);
            } else {
                Monkey monkey = monkeys.get(num);
                monkey.setItems(startingItems);
                monkey.setOperation(operation);
                monkey.setOperationAmount(operationAmount);
                monkey.setTest(test);
                monkey.setTrueMonkey(trueMonkey);
                monkey.setFalseMonkey(falseMonkey);
            }

        }
        for (int i = 0; i < 20; i++) {
            for (Monkey monk : monkeys) {
                if (monk != null) {
                    monk.inspectAll();
                }
            }
        }
        ArrayList<Long> inspections = new ArrayList<>();
        for (Monkey monk : monkeys) {
            if (monk != null) {
                inspections.add(monk.getInspections());
            }
        }
        return inspections
                .stream()
                .sorted()
                .skip(inspections.size() - 2)
                .reduce(1L, (a, b) -> a * b);

    }

    public final Long part2() {
        ArrayList<Monkey> monkeys = new ArrayList<>(Collections.nCopies(100, null));
        long modamount = 1;
        String[] monkeysInput = input.split("\n\n");
        for (String monkeyText : monkeysInput) {
            String[] monkeylines = monkeyText.split("\n");
            int num = 0;
            long[] startingItems = new long[0];
            Operation operation = null;
            int operationAmount = 0;
            int test = 0;
            Monkey trueMonkey = null;
            Monkey falseMonkey = null;

            String numPart = monkeylines[0].split(" ")[1];
            num = Integer.parseInt(numPart.substring(0, numPart.length() - 1));
            for (String line : monkeylines) {
                String[] parts = line.split(": ");
                switch (parts[0]) {
                    case "  Starting items":
                        startingItems = Arrays.stream(parts[1].split(", "))
                                .mapToLong(val -> Long.parseLong(val))
                                .toArray();
                        break;
                    case "  Operation":
                        String[] opParts = parts[1].split(" ");
                        if (parts[1].equals("new = old * old")) {
                            operation = SQUARED;
                        } else {
                            operationAmount = Integer.parseInt(opParts[4]);
                            switch (opParts[3]) {
                                case "+":
                                    operation = ADD;
                                    break;
                                case "*":
                                    operation = MULTIPLY;
                                    break;
                                default:
                                    throw new RuntimeException("invalid input");
                            }
                        }
                        break;
                    case "  Test":
                        test = Integer.parseInt(parts[1].split(" ")[2]);
                        modamount*=test;
                        break;
                    case "    If true":
                        int trueMonkeyNo = Integer.parseInt(parts[1].split(" ")[3]);
                        if (monkeys.size() <= trueMonkeyNo || monkeys.get(trueMonkeyNo) == null) {
                            trueMonkey = new Monkey(true);
                            monkeys.set(trueMonkeyNo, trueMonkey);
                        } else {
                            trueMonkey = monkeys.get(trueMonkeyNo);

                        }
                        break;
                    case "    If false":
                        int falseMonkeyNo = Integer.parseInt(parts[1].split(" ")[3]);
                        if (monkeys.size() <= falseMonkeyNo || monkeys.get(falseMonkeyNo) == null) {
                            falseMonkey = new Monkey(true);
                            monkeys.set(falseMonkeyNo, falseMonkey);
                        } else {
                            falseMonkey = monkeys.get(falseMonkeyNo);
                        }
                        break;
                }
            }

            if (monkeys.size() <= num || monkeys.get(num) == null) {
                Monkey monkey = new Monkey(startingItems, operation, operationAmount, test, trueMonkey, falseMonkey, true);
                monkeys.set(num, monkey);
            } else {
                Monkey monkey = monkeys.get(num);
                monkey.setItems(startingItems);
                monkey.setOperation(operation);
                monkey.setOperationAmount(operationAmount);
                monkey.setTest(test);
                monkey.setTrueMonkey(trueMonkey);
                monkey.setFalseMonkey(falseMonkey);
            }

        }
        Monkey.modAmount=modamount;
        for (int i = 0; i < 10_000; i++) {
            for (Monkey monk : monkeys) {
                if (monk != null) {
                    monk.inspectAll();
                }
            }
        }
        ArrayList<Long> inspections = new ArrayList<>();
        for (Monkey monk : monkeys) {
            if (monk != null) {
                inspections.add(monk.getInspections());
            }
        }
        return inspections
                .stream()
                .sorted()
                .skip(inspections.size() - 2)
                .reduce(1L, (a, b) -> a * b);
    }
}

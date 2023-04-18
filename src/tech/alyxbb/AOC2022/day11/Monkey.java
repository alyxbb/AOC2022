package tech.alyxbb.AOC2022.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Monkey {
    public static long modAmount = 0;

    boolean isPart2 = false;
    private ArrayList<Long> items;

    private Operation operation;
    private int operationAmount;

    private int test;

    private Monkey trueMonkey;
    private Monkey falseMonkey;

    public long getInspections() {
        return this.inspections;
    }

    private long inspections = 0;

    public long[] getItems() {
        return this.items.stream().mapToLong(obj -> (long) obj).toArray();
    }

    public void setItems(final long[] items) {
        this.items = new ArrayList<>(Arrays.stream(items).mapToObj(obj -> Long.valueOf(obj)).collect(Collectors.toList()));
    }

    public void addItem(final long item) {
        this.items.add(item);
    }

    public Operation getOperation() {
        return this.operation;
    }

    public void setOperation(final Operation operation) {
        this.operation = operation;
    }

    public int getOperationAmount() {
        return this.operationAmount;
    }

    public void setOperationAmount(final int operationAmount) {
        this.operationAmount = operationAmount;
    }

    public int getTest() {
        return this.test;
    }

    public void setTest(final int test) {
        this.test = test;
    }

    public Monkey getTrueMonkey() {
        return this.trueMonkey;
    }

    public void setTrueMonkey(final Monkey trueMonkey) {
        this.trueMonkey = trueMonkey;
    }

    public Monkey getFalseMonkey() {
        return this.falseMonkey;
    }

    public void setFalseMonkey(final Monkey falseMonkey) {
        this.falseMonkey = falseMonkey;
    }


    public Monkey(final long[] items, final Operation operation, final int operationAmount, final int test, final Monkey trueMonkey, final Monkey falseMonkey) {
        this.setItems(items);
        this.operation = operation;
        this.operationAmount = operationAmount;
        this.test = test;
        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;
    }

    public Monkey(final long[] items, final Operation operation, final int operationAmount, final int test, final Monkey trueMonkey, final Monkey falseMonkey, boolean isPart2) {
        this.setItems(items);
        this.operation = operation;
        this.operationAmount = operationAmount;
        this.test = test;
        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;
        this.isPart2 = isPart2;
    }


    public void inspectAll() {
        while (items.size() > 0) {
            inspect(items.get(0));
            items.remove(0);
        }
    }

    public void inspect(long num) {
        inspections++;
        switch (operation) {
            case ADD -> num += operationAmount;
            case MULTIPLY -> num *= operationAmount;
            case SQUARED -> num *= num;
        }
        if (!isPart2) {
            num /= 3;
        } else{
            num = num % modAmount;
        }

        if (num % test == 0) {
            trueMonkey.addItem(num);
        } else {
            falseMonkey.addItem(num);
        }
    }

    public Monkey() {
    }

    public Monkey(boolean isPart2) {
        this.isPart2 = isPart2;
    }
}

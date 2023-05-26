package tech.alyxbb.AOC2022;

import tech.alyxbb.AOC2022.abc.IntDay;
import tech.alyxbb.AOC2022.day9.Head;
import tech.alyxbb.AOC2022.day9.Tail;

public class Day9 extends IntDay {
    public Day9(String inp) {
        super(inp);
    }

    public Integer part1() {
        String[] moves = input.split("\n");
        Head head = new Head(0, 0);
        Tail tail = new Tail(0, 0);

        for (String move : moves) {
            String[] parts = move.split(" ");
            int amount = Integer.parseInt(parts[1]);
            for (int i = 0; i < amount; i++) {
                switch (parts[0]) {
                    case "L" -> head.moveL();
                    case "R" -> head.moveR();
                    case "U" -> head.moveU();
                    case "D" -> head.moveD();
                }
                tail.chase(head.getPoints());
            }

        }
        return tail.getPointCount();
    }

    public Integer part2() {
        String[] moves = input.split("\n");
        Head head = new Head(0, 0);
        Tail[] tails = {
                new Tail(0, 0),
                new Tail(0, 0),
                new Tail(0, 0),
                new Tail(0, 0),
                new Tail(0, 0),
                new Tail(0, 0),
                new Tail(0, 0),
                new Tail(0, 0),
                new Tail(0, 0),
        };

        for (String move : moves) {
            String[] parts = move.split(" ");
            int amount = Integer.parseInt(parts[1]);
            for (int i = 0; i < amount; i++) {
                switch (parts[0]) {
                    case "L" -> head.moveL();
                    case "R" -> head.moveR();
                    case "U" -> head.moveU();
                    case "D" -> head.moveD();
                }
                tails[0].chase(head.getPoints());
                for (int j = 1; j < tails.length; j++) {
                    tails[j].chase(tails[j - 1].getPoints());
                }
            }

        }
        return tails[tails.length - 1].getPointCount();
    }
}

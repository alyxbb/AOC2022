package tech.alyxbb.AOC2022;

import tech.alyxbb.AOC2022.abc.StringDay;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Day5 extends StringDay {
    public Day5(String inp) {
        super(inp);
    }

    public String part1() {
        String[] parts = input.split("\n\n");
        String[] startingSetup = parts[0].split("\n");
        String[] swaps = parts[1].split("\n");
        int numPiles = startingSetup[startingSetup.length - 1].substring(1).split(" {3}").length;
        Stack<Character>[] piles = new Stack[numPiles];
        for (int i = 0; i < piles.length; i++) {
            piles[i] = new Stack<>();
        }
        List<String> startingSetupList = Arrays.asList(Arrays.copyOfRange(startingSetup, 0, startingSetup.length - 1));
        Collections.reverse(startingSetupList);
        for (String pile : startingSetupList) {
            for (int i = 0; i < numPiles; i++) {
                char letter = pile.toCharArray()[i * 4 + 1];
                if (letter != ' ') {
                    piles[i].push(letter);

                }
            }
        }
        for (String swap : swaps) {
            String[] swapArr = swap.split(" ");
            int times = Integer.parseInt(swapArr[1]);
            int from = Integer.parseInt(swapArr[3])-1;
            int to = Integer.parseInt(swapArr[5])-1;
            for (int i = 0; i < times; i++) {
                piles[to].push(piles[from].pop());
            }

        }
        StringBuilder tops = new StringBuilder();
        for (Stack<Character> stack : piles) {
            tops.append(stack.pop());
        }
        return tops.toString();
    }

    public String part2() {
        String[] parts = input.split("\n\n");
        String[] startingSetup = parts[0].split("\n");
        String[] swaps = parts[1].split("\n");
        int numPiles = startingSetup[startingSetup.length - 1].substring(1).split(" {3}").length;
        Stack<Character>[] piles = new Stack[numPiles];
        for (int i = 0; i < piles.length; i++) {
            piles[i] = new Stack<>();
        }
        List<String> startingSetupList = Arrays.asList(Arrays.copyOfRange(startingSetup, 0, startingSetup.length - 1));
        Collections.reverse(startingSetupList);
        for (String pile : startingSetupList) {
            for (int i = 0; i < numPiles; i++) {
                char letter = pile.toCharArray()[i * 4 + 1];
                if (letter != ' ') {
                    piles[i].push(letter);

                }
            }
        }
        for (String swap : swaps) {
            String[] swapArr = swap.split(" ");
            int times = Integer.parseInt(swapArr[1]);
            int from = Integer.parseInt(swapArr[3])-1;
            int to = Integer.parseInt(swapArr[5])-1;
            Stack <Character> tempStack = new Stack<>();
            for (int i = 0; i < times; i++) {//yes there probably is a better way to do this, this was the quickest way to do it having already written the solution to part 1.
                tempStack.push(piles[from].pop());
            }
            while (!tempStack.empty()){
                piles[to].push(tempStack.pop());
            }

        }
        StringBuilder tops = new StringBuilder();
        for (Stack<Character> stack : piles) {
            tops.append(stack.pop());
        }
        return tops.toString();
    }
}

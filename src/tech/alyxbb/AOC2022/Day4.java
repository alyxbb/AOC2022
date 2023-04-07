package tech.alyxbb.AOC2022;

import java.util.Arrays;

public class Day4 extends IntDay {
    public Day4(String inp) {
        super(inp);
    }

    Integer part1() {
        String[] elfPairs = input.split("\n");
        int count = 0;
        for (String elfPair : elfPairs) {
            String[] pairArr = elfPair.split(",");
            int[] firstElf = Arrays.stream(pairArr[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] secondElf = Arrays.stream(pairArr[1].split("-")).mapToInt(Integer::parseInt).toArray();
            if (firstElf[0] <= secondElf[0] && secondElf[1] <= firstElf[1]) {
                count++;
            } else if (secondElf[0] <= firstElf[0] && firstElf[1] <= secondElf[1]) {
                count++;
            }

        }
        return count;
    }

    Integer part2() {
        String[] elfPairs = input.split("\n");
        int count = 0;
        for (String elfPair : elfPairs) {
            String[] pairArr = elfPair.split(",");
            int[] firstElf = Arrays.stream(pairArr[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] secondElf = Arrays.stream(pairArr[1].split("-")).mapToInt(Integer::parseInt).toArray();
            if (firstElf[0] <= secondElf[0] && secondElf[0] <= firstElf[1]) {
                count++;
            } else if (firstElf[0] <= secondElf[1] && secondElf[1] <= firstElf[1]) {
                count++;
            } else if (secondElf[0] <= firstElf[0] && firstElf[0] <= secondElf[1]){
                count++;
            } else if (secondElf[0] <= firstElf[1] && firstElf[1] <= secondElf[1]){
                count++;
            }

        }
        return count;
    }
}

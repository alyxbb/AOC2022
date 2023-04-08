package tech.alyxbb.AOC2022;

import tech.alyxbb.AOC2022.day7.Dir;
import tech.alyxbb.AOC2022.day7.File;

import java.util.ArrayList;
import java.util.Collections;

public class Day7 extends IntDay {
    public Day7(String inp) {
        super(inp);
    }

    Integer part1() {
        Dir root = genFs();
        return root.getSizeTotIfSmall();
    }

    private Dir genFs() {
        String[] lines = input.split("\n");

        Dir root = new Dir("/", null);
        Dir currentDir = root;
        for (String line : lines) {
            String[] lineArr = line.split(" ");
            switch (lineArr[0]) {
                case "$":
                    if (lineArr[1].equals("cd")) {
                        switch (lineArr[2]) {
                            case "/":
                                currentDir = root;
                                break;
                            case "..":
                                currentDir = currentDir.getParent();
                                break;
                            default:
                                for (Dir dir : currentDir.getChildDir()) {
                                    if (dir.getName().equals(lineArr[2])) {
                                        currentDir = dir;
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                    break;
                case "dir":
                    currentDir.addDir(new Dir(lineArr[1], currentDir));
                    break;
                default:
                    currentDir.addFile(new File(lineArr[1], Integer.parseInt(lineArr[0])));
                    break;
            }

        }
        return root;
    }

    Integer part2() {
        Dir root = genFs();
        int sizeUsed = root.getSize();
        int sizeavail = 70000000 - sizeUsed;
        int sizeNeeded = 30000000 - sizeavail;
        ArrayList<Dir> allDirs = root.getAllDirs();
        Collections.sort(allDirs);
        for (Dir dir : allDirs) {
            if (dir.getSize() >= sizeNeeded) {
                return dir.getSize();
            }
        }
        throw new RuntimeException("Invalid input");
    }
}

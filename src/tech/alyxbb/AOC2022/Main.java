package tech.alyxbb.AOC2022;

import tech.alyxbb.AOC2022.abc.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static String loadFile(String name) {
        File file = new File("problems/" + name + ".txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
            sb.append("\n");
        }
        scanner.close();
        return sb.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        int dayNo = getDayNo();

        String puzzleInput = loadFile(Integer.toString(dayNo));
        Day day = (Day) Class.forName("tech.alyxbb.AOC2022.Day" + dayNo).getConstructor(String.class).newInstance(puzzleInput);

        System.out.println("Part 1 answer: " + day.part1());
        System.out.println("Part 2 answer: " + day.part2());
    }

    private static int getDayNo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Day Number:");
        System.out.print("> ");
        return scanner.nextInt();
    }
}

package tech.alyxbb.AOC2022;

import tech.alyxbb.AOC2022.abc.IntDay;
import tech.alyxbb.AOC2022.day13.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class Day13 extends IntDay {
    public Day13(String inp) {
        super(inp);
    }

    public Integer part1() {
        String[][] pairs = Arrays.stream(input.split("\n\n"))
                .map(pair -> pair.split("\n")).toArray(String[][]::new);
        int tot = 0;
        int i = 1;
        for (String[] pair : pairs) {
            Node leftNode = deserialize(pair[0]);
            Node rightNode = deserialize(pair[1]);
            if (Node.compare(leftNode, rightNode)) {
                tot += i;
            }
            i++;
        }
        return tot;
    }


    private Node deserialize(String text) {
        ArrayList<Node> elems = new ArrayList<>();
        char[] text_array = text.toCharArray();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text_array[i] == '[') {
                elems.add(deserialize(text.substring(i + 1, getSameDepthBracketPos(i, text_array))));
                i = getSameDepthBracketPos(i, text_array);

            } else if (text_array[i] == ',') {
                if (buffer.length() != 0) {
                    elems.add(new Node(Integer.parseInt(buffer.toString())));
                    buffer = new StringBuilder();
                }
            } else {
                buffer.append(text_array[i]);
            }
        }
        if (buffer.length() != 0) {
            elems.add(new Node(Integer.parseInt(buffer.toString())));

        }

        // if (elems.size() == 1) {
        //return elems.get(0);
        //} else {
        return new Node(elems);
        //}
    }

    private int getSameDepthBracketPos(int i, char[] text) {
        int depth = 0;
        for (i++; i < text.length; i++) {
            if (text[i] == ']') {
                if (depth == 0) {
                    return i;
                } else {
                    depth--;
                }
            } else if (text[i] == '[') {
                depth++;
            }
        }
        throw new RuntimeException("Invalid input");
    }

    public Integer part2() {
        String[] nodes = Arrays.stream(input.split("\n"))
                .filter(elem -> !elem.equals(""))
                .toArray(String[]::new);
        ArrayList<Node> nodeList = new ArrayList<>();

        for (String nodeStr : nodes) {
            nodeList.add(deserialize(nodeStr));
        }
        Node dividerA = deserialize("[[2]]");
        Node dividerB = deserialize("[[6]]");
        nodeList.add(dividerA);
        nodeList.add(dividerB);
        System.out.println(nodeList.get(0).compareTo(nodeList.get(1)));
        nodeList.sort(null);
        int aIndex = nodeList.indexOf(dividerA) + 1;
        int bIndex = nodeList.indexOf(dividerB) + 1;
        return aIndex * bIndex;
    }
}

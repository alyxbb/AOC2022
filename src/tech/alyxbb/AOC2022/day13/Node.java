package tech.alyxbb.AOC2022.day13;

import java.util.ArrayList;

public class Node implements Comparable<Node> {
    private ArrayList<Node> children;
    private Integer value = null;

    public static Boolean compare(Node left, Node right) {
        ArrayList<Node> leftChildren = left.getChildren();
        ArrayList<Node> rightChildren = right.getChildren();
        for (int i = 0; i < Integer.min(leftChildren.size(), rightChildren.size()); i++) {
            Node currLChild = leftChildren.get(i);
            Node currRChild = rightChildren.get(i);
            if (currLChild.hasValue() && currRChild.hasValue()) {
                if (currLChild.getValue() != currRChild.getValue()) {
                    return currLChild.getValue() < currRChild.getValue();
                }
                continue;
            } else if (currLChild.hasValue()) {
                ArrayList<Node> tmp = new ArrayList<>();
                tmp.add(currLChild);
                currLChild = new Node(tmp);
            } else if (currRChild.hasValue()) {
                ArrayList<Node> tmp = new ArrayList<>();
                tmp.add(currRChild);
                currRChild = new Node(tmp);
            }
            Boolean comp = compare(currLChild, currRChild);
            if (comp != null) {
                return comp;
            }
        }
        if (leftChildren.size() != rightChildren.size()) {
            return leftChildren.size() < rightChildren.size();

        }
        return null;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public Boolean hasValue() {
        return value != null;
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(ArrayList<Node> children) {
        this.children = children;
    }

    public int size() {
        return children.size();
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        if (value == null) {
            StringBuilder childStr = new StringBuilder();
            for (Node child : children) {
                childStr.append(child).append(",");
            }
            try {
                childStr = new StringBuilder(childStr.substring(0, childStr.length() - 1));
            } catch (StringIndexOutOfBoundsException e) {
                childStr = new StringBuilder();
            }

            return "[" + childStr + "]";
        } else {
            return value.toString();
        }
    }


    public int compareTo(Node o) {
        boolean res = compare(this, o);
        if (res) {
            return -1;
        } else {
            return 1;
        }
    }
}

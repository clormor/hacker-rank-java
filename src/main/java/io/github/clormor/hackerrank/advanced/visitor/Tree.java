package io.github.clormor.hackerrank.advanced.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);

    public static Tree solve(int n, String[] args) {
        Map<Integer, Integer> idsToDepth = new HashMap<>(n);
        Map<Integer, Integer> idsToValue = new HashMap<>(n);
        Map<Integer, Color> idsToColour = new HashMap<>(n);
        Map<Integer, Integer> edges = new HashMap<>(n);
        Map<Integer, Tree> trees = new HashMap<>();

        idsToDepth.put(0, 0);
        String[] values = args[0].split(" ");
        for (int i = 0; i < n; i++) {
            idsToValue.put(i, Integer.parseInt(values[i]));
        }

        String[] colours = args[1].split(" ");
        for (int i = 0; i < n; i++) {
            idsToColour.put(i, (colours[i].equals("0")) ? Color.RED : Color.GREEN);
        }

        int maxDepth = 0;
        for (int i = 2; i <= n; i++) {
            String[] edge = args[i].split(" ");
            int parent = Integer.parseInt(edge[0]) - 1;
            int child = Integer.parseInt(edge[1]) - 1;

            int parentDepth = idsToDepth.get(parent);
            maxDepth = Math.max(maxDepth, parentDepth + 1);
            idsToDepth.put(child, parentDepth + 1);
            edges.put(child, parent);
        }

        for (int i = 0; i < n; i++) {
            Tree t;

            // calculate depth - determine if node or leaf
            int depth = idsToDepth.get(i);
            if (idsToDepth.get(i) == maxDepth) {
                t = new TreeLeaf(idsToValue.get(i), idsToColour.get(i), depth);
            } else {
                t = new TreeNode(idsToValue.get(i), idsToColour.get(i), depth);
            }

            // find edges, add this tree to its parent
            int parent = edges.getOrDefault(i, -1);
            if (parent != -1) {
                TreeNode parentNode = (TreeNode) trees.get(parent);
                parentNode.addChild(t);
            }

            trees.put(i, t);
        }

        return trees.get(0);
    }
}

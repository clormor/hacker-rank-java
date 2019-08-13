package io.github.clormor.hackerrank.advanced.visitor;

import java.util.HashMap;
import java.util.Map;

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

    private static Map<Integer, Integer> mapValues(int n, String valuesLine) {
        Map<Integer, Integer> values = new HashMap<>(n);
        String[] valuesString = valuesLine.split(" ");
        for (int i = 0; i < n; i++) {
            values.put(i, Integer.parseInt(valuesString[i]));
        }
        return values;
    }

    private static Map<Integer, Color> mapColours(int n, String coloursLine) {
        Map<Integer, Color> colours = new HashMap<>(n);
        String[] coloursString = coloursLine.split(" ");
        for (int i = 0; i < n; i++) {
            colours.put(i, (coloursString[i].equals("0")) ? Color.RED : Color.GREEN);
        }
        return colours;
    }

    private static Tree createTrees(
            int n,
            int maxDepth,
            Map<Integer, Integer> values,
            Map<Integer, Color> colours,
            Map<Integer, Integer> depths,
            Map<Integer, Integer> edges) {

        Map<Integer, Tree> trees = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            Tree t;

            // calculate depth - determine if node or leaf
            int depth = depths.get(i);
            if (depths.get(i) == maxDepth) {
                t = new TreeLeaf(values.get(i), colours.get(i), depth);
            } else {
                t = new TreeNode(values.get(i), colours.get(i), depth);
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

    public static Tree solve(int n, String[] args) {
        // map the values and colours in helper methods
        Map<Integer, Integer> values = mapValues(n, args[0]);
        Map<Integer, Color> colours = mapColours(n, args[1]);

        // keep track of max depth - determines if a tree is node or leaf
        int maxDepth = 0;
        Map<Integer, Integer> depths = new HashMap<>(n);
        Map<Integer, Integer> edges = new HashMap<>(n);
        // Determine the depth of each node, and its edges
        depths.put(0, 0);
        for (int i = 2; i <= n; i++) {
            String[] edgeString = args[i].split(" ");
            int parent = Integer.parseInt(edgeString[0]) - 1;
            int child = Integer.parseInt(edgeString[1]) - 1;

            int parentDepth = depths.get(parent);
            maxDepth = Math.max(maxDepth, parentDepth + 1);
            depths.put(child, parentDepth + 1);
            edges.put(child, parent);
        }

        // Instantiate the trees, return the root
        return createTrees(n, maxDepth, values, colours, depths, edges);
    }
}

package io.github.clormor.hackerrank.advanced.visitor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TreeParser {

    Map<Integer, Integer> values;
    Map<Integer, Color> colours;
    Map<Integer, Integer> depths;
    Map<Integer, Integer> edges;

    public Tree solve(int n, String[] args) {
        // map the values and colours in helper methods
        mapValues(n, args[0]);
        mapColours(n, args[1]);

        // keep track of max depth - determines if a tree is node or leaf
        int maxDepth = mapDepthsAndEdges(n, Arrays.copyOfRange(args, 2, n + 1));

        // Instantiate the trees, return the root
        return createTrees(n, maxDepth);
    }

    private void mapValues(int n, String valuesLine) {
        values = new HashMap<>(n);
        String[] valuesString = valuesLine.split(" ");
        for (int i = 0; i < n; i++) {
            values.put(i, Integer.parseInt(valuesString[i]));
        }
    }

    private void mapColours(int n, String coloursLine) {
        colours = new HashMap<>(n);
        String[] coloursString = coloursLine.split(" ");
        for (int i = 0; i < n; i++) {
            colours.put(i, (coloursString[i].equals("0")) ? Color.RED : Color.GREEN);
        }
    }

    private int mapDepthsAndEdges(int n, String[] edgeLines) {
        int maxDepth = 0;
        depths = new HashMap<>(n);
        edges = new HashMap<>(n);

        // Determine the depth of each node, and its edges
        depths.put(0, 0);
        for (int i = 0; i < n - 1; i++) {
            String[] edgeString = edgeLines[i].split(" ");
            int parent = Integer.parseInt(edgeString[0]) - 1;
            int child = Integer.parseInt(edgeString[1]) - 1;

            int parentDepth = depths.get(parent);
            maxDepth = Math.max(maxDepth, parentDepth + 1);
            depths.put(child, parentDepth + 1);
            edges.put(child, parent);
        }

        return maxDepth;
    }

    private Tree createTrees(int n, int maxDepth) {

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
}

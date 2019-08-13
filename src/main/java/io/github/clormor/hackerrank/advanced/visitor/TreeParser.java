package io.github.clormor.hackerrank.advanced.visitor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TreeParser {

    Map<Integer, Integer> values;
    Map<Integer, Color> colours;
    Map<Integer, Integer> depths;
    Map<Integer, Set<Integer>> edgesTo;
    Map<Integer, Tree> trees;

    public Tree solve(int n, String[] args) {
        // map the values and colours in helper methods
        mapValues(n, args[0]);
        mapColours(n, args[1]);

        // keep track of max depth - determines if a tree is node or leaf
        mapDepthsAndEdges(n, Arrays.copyOfRange(args, 2, n + 1));

        // create the tree objects
        createTrees(n);

        // create the edges
        createEdges(n);

        // return the tree root
        return trees.get(0);
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

    private void mapDepthsAndEdges(int n, String[] edgeLines) {
        depths = new HashMap<>(n);
        edgesTo = new HashMap<>(n);

        // Determine the depth of each node, and its edges
        depths.put(0, 0);
        for (int i = 0; i < n - 1; i++) {
            String[] edgeString = edgeLines[i].split(" ");
            int parent = Integer.parseInt(edgeString[0]) - 1;
            int child = Integer.parseInt(edgeString[1]) - 1;

            int parentDepth = depths.get(parent);
            depths.put(child, parentDepth + 1);
            Set<Integer> children = edgesTo.get(parent);
            if (children == null) {
                children = new HashSet<>();
            }
            children.add(child);
            edgesTo.put(parent, children);
        }
    }

    private void createTrees(int n) {
        trees = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            // determine if node or leaf
            Set<Integer> children = edgesTo.get(i);
            if (children == null) {
                trees.put(i, new TreeLeaf(values.get(i), colours.get(i), depths.get(i)));
            } else {
                trees.put(i, new TreeNode(values.get(i), colours.get(i), depths.get(i)));
            }
        }
    }

    private void createEdges(int n) {
        for (int i = 0; i < n; i++) {
            Set<Integer> children = edgesTo.get(i);
            if (children != null) {
                TreeNode parent = (TreeNode) trees.get(i);
                for (int child : children) {
                    parent.addChild(trees.get(child));
                }
            }
        }
    }
}

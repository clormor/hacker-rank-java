package io.github.clormor.hackerrank.advanced.visitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TreeParser {

    int[] values;
    Color[] colours;
    Map<Integer, Set<Integer>> allEdges;

    public Tree solve(int n, String[] args) {
        // map the values and colours in helper methods
        mapValues(n, args[0]);
        mapColours(n, args[1]);

        // parse the edge lines into numbers we can search for
        mapAllEdges(args);

        // handle 1-node tree as special case
        if (n == 1) {
            return new TreeLeaf(values[0], colours[0], 0);
        }

        // recursively search the tree to create nodes from the root
        TreeNode root = new TreeNode(values[0], colours[0], 0);
        processNode(root, 1);

        return root;
    }

    private void processNode(TreeNode parent, int parentId) {
        for (Integer childId : allEdges.get(parentId)) {
            allEdges.get(childId).remove(parentId);
            Tree child;
            Set<Integer> grandChildren = allEdges.get(childId);
            if (grandChildren != null && grandChildren.size() == 0) {
                child = new TreeLeaf(values[childId - 1], colours[childId - 1], parent.getDepth() + 1);
            } else {
                child = new TreeNode(values[childId - 1], colours[childId - 1], parent.getDepth() + 1);
            }
            parent.addChild(child);
            if (child instanceof TreeNode) {
                processNode((TreeNode) child, childId);
            }
        }
    }

    private void mapAllEdges(String[] edgeLines) {
        allEdges = new HashMap<>();
        for (int i = 2; i < edgeLines.length; i++) {
            String[] edge = edgeLines[i].split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);

            Set<Integer> as = allEdges.get(a);
            if (as == null) {
                as = new HashSet<>();
                allEdges.put(a, as);
            }
            as.add(b);

            Set<Integer> bs = allEdges.get(b);
            if (bs == null) {
                bs = new HashSet<>();
                allEdges.put(b, bs);
            }
            bs.add(a);
        }
    }

    private void mapValues(int n, String valuesLine) {
        values = new int[n];
        String[] valuesString = valuesLine.split(" ");
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(valuesString[i]);
        }
    }

    private void mapColours(int n, String coloursLine) {
        colours = new Color[n];
        String[] coloursString = coloursLine.split(" ");
        for (int i = 0; i < n; i++) {
            colours[i] = (coloursString[i].equals("0")) ? Color.RED : Color.GREEN;
        }
    }
}

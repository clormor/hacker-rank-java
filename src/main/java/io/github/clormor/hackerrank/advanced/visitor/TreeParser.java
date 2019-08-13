package io.github.clormor.hackerrank.advanced.visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeParser {

    Map<Integer, Integer> values;
    Map<Integer, Color> colours;
    Map<Integer, Set<Integer>> allEdges;

    public Tree solve(int n, String[] args) {
        // map the values and colours in helper methods
        mapValues(n, args[0]);
        mapColours(n, args[1]);

        // parse the edge lines into numbers we can search for
        mapAllEdges(Arrays.copyOfRange(args, 2, n + 1));

        // begin depth-first search - find children of the root
        List<Integer> edges = findNodeEdges(0);

        // handle 1-node tree as special case
        if (edges.size() == 0) {
            return new TreeLeaf(values.get(0), colours.get(0), 0);
        }

        // recursively search the tree to create nodes from the root
        TreeNode root = new TreeNode(values.get(0), colours.get(0), 0);
        for (int child : edges) {
            processNode(child, 1, root);
        }

        return root;
    }

    private void processNode(Integer node, int depth, TreeNode parent) {
        List<Integer> edges = findNodeEdges(node);
        if (edges.size() == 0) {
            parent.addChild(new TreeLeaf(values.get(node), colours.get(node), depth));
        } else {
            TreeNode currentNode = new TreeNode(values.get(node), colours.get(node), depth);
            parent.addChild(currentNode);
            for (int child : edges) {
                processNode(child, depth + 1, currentNode);
            }
        }
    }

    private List<Integer> findNodeEdges(int node) {
        List<Integer> result = new ArrayList<>();
        List<Integer> keysToRemove = new ArrayList<>();
        for (Integer key : allEdges.keySet()) {
            Set<Integer> edge = allEdges.get(key);
            if (edge.contains(node)) {
                edge.remove(node);
                result.add((Integer) edge.toArray()[0]);
                keysToRemove.add(key);
            }
        }
        for (Integer key : keysToRemove) {
            allEdges.remove(key);
        }
        return result;
    }

    private void mapAllEdges(String[] edgeLines) {
        allEdges = new HashMap<>();
        for (int i = 0; i < edgeLines.length; i++) {
            Set<Integer> nodes = new HashSet<>();
            String[] edge = edgeLines[i].split(" ");
            nodes.add(Integer.parseInt(edge[0]) - 1);
            nodes.add(Integer.parseInt(edge[1]) - 1);
            allEdges.put(i, nodes);
        }
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
}

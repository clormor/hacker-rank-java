package io.github.clormor.hackerrank.advanced.visitor;

public class FancyVisitor extends TreeVis {

    int greenLeafSum = 0;
    int evenDepthNodeSum = 0;

    public int getResult() {
        return Math.abs(greenLeafSum - evenDepthNodeSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthNodeSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.GREEN)) {
            greenLeafSum += leaf.getValue();
        }
    }
}

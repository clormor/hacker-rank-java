package io.github.clormor.hackerrank.advanced.visitor;

public class SumInLeavesVisitor extends TreeVis {

    int result = 0;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void visitNode(TreeNode node) {
        // Only sum leaves, do nothing here.
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

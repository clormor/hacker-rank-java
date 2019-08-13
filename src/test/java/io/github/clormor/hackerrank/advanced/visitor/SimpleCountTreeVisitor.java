package io.github.clormor.hackerrank.advanced.visitor;

/**
 * For testing - Sums all node values to check we've visited the ones we expected to.
 */
public class SimpleCountTreeVisitor extends TreeVis {
    int result = 0;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void visitNode(TreeNode node) {
        result += node.getValue();
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

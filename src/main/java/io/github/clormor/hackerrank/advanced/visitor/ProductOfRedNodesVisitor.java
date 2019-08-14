package io.github.clormor.hackerrank.advanced.visitor;

public class ProductOfRedNodesVisitor extends TreeVis {

    long result = 1;
    static final int MOD = (int) Math.pow(10, 9) + 7;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        processIfRed(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        processIfRed(leaf);
    }

    private void processIfRed(Tree t) {
        if (t.getColor().equals(Color.RED)) {
            result = (result * t.getValue()) % MOD;
        }
    }
}

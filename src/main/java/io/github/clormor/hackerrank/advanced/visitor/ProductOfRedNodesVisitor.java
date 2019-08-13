package io.github.clormor.hackerrank.advanced.visitor;

import java.math.BigInteger;

public class ProductOfRedNodesVisitor extends TreeVis {

    BigInteger result = new BigInteger("1");
    static final BigInteger BIG_INT_MOD = new BigInteger(Integer.toString((int) Math.pow(10, 9) + 7));

    public int getResult() {
        return result.mod(BIG_INT_MOD).intValue();
    }

    public void visitNode(TreeNode node) {
        processIfRed(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        processIfRed(leaf);
    }

    private void processIfRed(Tree t) {
        if (t.getColor().equals(Color.RED)) {
            result = result.multiply(new BigInteger(Integer.toString(t.getValue())));
        }
    }
}

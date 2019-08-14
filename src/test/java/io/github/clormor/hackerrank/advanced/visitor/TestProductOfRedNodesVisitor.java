package io.github.clormor.hackerrank.advanced.visitor;

import static io.github.clormor.hackerrank.advanced.visitor.VisitorTestConstants.VALUE_1;
import static io.github.clormor.hackerrank.advanced.visitor.VisitorTestConstants.VALUE_2;
import static io.github.clormor.hackerrank.advanced.visitor.VisitorTestConstants.depth_3_tree;
import static io.github.clormor.hackerrank.advanced.visitor.VisitorTestConstants.hacker_rank_tree;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestProductOfRedNodesVisitor {
    ProductOfRedNodesVisitor p;

    @Before
    public void setup() {
        p = new ProductOfRedNodesVisitor();
    }

    @Test
    public void one_node_test() {
        VisitorTestConstants.getSimpleGreenTree().accept(p);
        assertEquals(1, p.getResult());

        VisitorTestConstants.getSimpleRedTree().accept(p);
        assertEquals(VALUE_1, p.getResult());
    }

    @Test
    public void depth_one_test() {
        VisitorTestConstants.getTreeOfDepth1().accept(p);
        assertEquals(VALUE_1, p.getResult());
    }

    @Test
    public void very_red_test() {
        VisitorTestConstants.getRedTree().accept(p);
        assertEquals((VALUE_1 * VALUE_2 * VALUE_2), p.getResult());
    }

    @Test
    public void bigger_test() {
        depth_3_tree.accept(p);
        assertEquals(1680, p.getResult());
    }

    @Test
    public void hacker_rank_test() {
        hacker_rank_tree.accept(p);
        assertEquals(40, p.getResult());
    }
}

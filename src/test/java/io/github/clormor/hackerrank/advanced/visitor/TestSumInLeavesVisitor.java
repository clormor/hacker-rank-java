package io.github.clormor.hackerrank.advanced.visitor;

import static io.github.clormor.hackerrank.advanced.visitor.VisitorTestConstants.VALUE_1;
import static io.github.clormor.hackerrank.advanced.visitor.VisitorTestConstants.depth_3_tree;
import static io.github.clormor.hackerrank.advanced.visitor.VisitorTestConstants.hacker_rank_tree;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestSumInLeavesVisitor {

    SumInLeavesVisitor s;

    @Before
    public void setup() {
        s = new SumInLeavesVisitor();
    }

    @Test
    public void one_node_test() {
        VisitorTestConstants.getSimpleGreenTree().accept(s);
        assertEquals(VALUE_1, s.getResult());
    }

    @Test
    public void depth_one_test() {
        VisitorTestConstants.getTreeOfDepth1().accept(s);
        assertEquals(VALUE_1 + VALUE_1, s.getResult());
    }

    @Test
    public void bigger_test() {
        depth_3_tree.accept(s);
        assertEquals(39, s.getResult());
    }

    @Test
    public void hacker_rank_test() {
        hacker_rank_tree.accept(s);
        assertEquals(24, s.getResult());
    }
}

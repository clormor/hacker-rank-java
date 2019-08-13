package io.github.clormor.hackerrank.advanced.visitor;

import static io.github.clormor.hackerrank.advanced.visitor.VisitorTestConstants.VALUE_1;
import static io.github.clormor.hackerrank.advanced.visitor.VisitorTestConstants.VALUE_3;
import static io.github.clormor.hackerrank.advanced.visitor.VisitorTestConstants.depth_3_tree;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestFancyVisitor {

    FancyVisitor f;

    @Before
    public void setup() {
        f = new FancyVisitor();
    }

    @Test
    public void one_green_node_test() {
        VisitorTestConstants.getSimpleGreenTree().accept(f);
        assertEquals(VALUE_1, f.getResult());
    }

    @Test
    public void one_red_node_test() {
        VisitorTestConstants.getSimpleRedTree().accept(f);
        assertEquals(0, f.getResult());
    }

    @Test
    public void depth_one_test() {
        VisitorTestConstants.getTreeOfDepth1().accept(f);
        assertEquals(VALUE_1, f.getResult());
    }

    @Test
    public void very_red_test() {
        VisitorTestConstants.getRedTree().accept(f);
        assertEquals(0, f.getResult());
    }

    @Test
    public void depth_two_test() {
        VisitorTestConstants.getTreeOfDepth2().accept(f);
        assertEquals(Math.abs(VALUE_1 - VALUE_3), f.getResult());
    }

    @Test
    public void bigger_test() {
        depth_3_tree.accept(f);
        assertEquals(12, f.getResult());
    }
}

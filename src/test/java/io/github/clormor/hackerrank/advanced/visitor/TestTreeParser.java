package io.github.clormor.hackerrank.advanced.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestTreeParser {

    SimpleCountTreeVisitor v;
    TreeParser t;

    @Before
    public void setup() {
        t = new TreeParser();
        v = new SimpleCountTreeVisitor();
    }

    @Test
    public void depth_1_solve_test() {
        String[] input = {"4 6 7", "0 1 1", "1 2", "1 3"};
        Tree result = t.solve(input.length - 1, input);
        checkTree(4, Color.RED, 0, result);
        result.accept(v);
        assertEquals(17,v.getResult());
    }

    @Test
    public void there_can_be_more_than_two_trees_at_each_level() {
        String[] input = {"4 6 7 1 2 3", "0 1 1 1 0 0", "1 2", "1 3", "1 4", "1 5", "1 6"};
        Tree result = t.solve(input.length - 1, input);
        result.accept(v);
        assertEquals(23,v.getResult());
    }

    @Test
    public void simple_depth_2_solve_test() {
        String[] input = {"4 6 7", "0 1 1", "1 2", "2 3"};
        Tree result = t.solve(input.length - 1, input);
        result.accept(v);
        assertEquals(17,v.getResult());
    }

    @Test
    public void harder_depth_2_solve_test() {
        String[] input = {
                "1 2 3 4 5 6 7 8 9",
                "0 1 1 1 0 0 0 0 1",
                "1 2", "1 3", "2 4", "2 5", "2 6", "3 7", "3 8", "3 9"};
        Tree result = t.solve(input.length - 1, input);
        result.accept(v);
        assertEquals(45,v.getResult());
    }

    @Test
    public void because_obviously_the_edges_are_undirected() {
        String[] input = {
                "1 2 3 4 5 6 7 8 9",
                "0 1 1 1 0 0 0 0 1",
                "1 2", "1 3", "4 2", "4 5", "2 6", "2 7", "3 8", "3 9"};
        Tree result = t.solve(input.length - 1, input);
        result.accept(v);
        // all nodes should appear in this tree
        assertEquals(45,v.getResult());
    }

    private void checkTree(int expectedValue, Color expectedColour, int expectedDepth, Tree t) {
        assertEquals(expectedDepth, t.getDepth());
        assertEquals(expectedValue, t.getValue());
        assertEquals(expectedColour, t.getColor());
    }
}

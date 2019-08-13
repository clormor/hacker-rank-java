package io.github.clormor.hackerrank.advanced.visitor;

public class VisitorTestConstants {

    static final int VALUE_1 = 10;
    static final int VALUE_2 = 23;
    static final int VALUE_3 = 57;

    private static final Tree VALUE_1_GREEN_LEAF = new TreeLeaf(VALUE_1, Color.GREEN, 0);
    private static final Tree VALUE_1_RED_LEAF = new TreeLeaf(VALUE_1, Color.RED, 0);
    private static final Tree VALUE_2_RED_LEAF = new TreeLeaf(VALUE_2, Color.RED, 0);

    private static final TreeNode VALUE_2_GREEN_DEPTH_1 = new TreeNode(VALUE_2, Color.GREEN, 1);
    private static final TreeNode VALUE_2_RED_DEPTH_1 = new TreeNode(VALUE_2, Color.RED, 1);

    private static final TreeNode VALUE_2_RED_DEPTH_2 = new TreeNode(VALUE_3, Color.RED, 2);

    static final Tree depth_3_tree = new TreeParser().solve(9, new String[]{
            "1 2 3 4 5 6 7 8 9",
            "0 1 1 1 0 0 0 0 1",
            "1 2", "1 3", "2 4", "2 5", "2 6", "3 7", "3 8", "3 9"});

    static final Tree hacker_rank_tree = new TreeParser().solve(5, new String[]{
            "4 7 2 5 12",
            "0 1 0 0 1",
            "1 2",
            "1 3",
            "3 4",
            "3 5"
    });

    static {
        VALUE_2_GREEN_DEPTH_1.addChild(VALUE_1_GREEN_LEAF);
        VALUE_2_GREEN_DEPTH_1.addChild(VALUE_1_RED_LEAF);

        VALUE_2_RED_DEPTH_1.addChild(VALUE_1_RED_LEAF);
        VALUE_2_RED_DEPTH_1.addChild(VALUE_2_RED_LEAF);

        VALUE_2_RED_DEPTH_2.addChild(VALUE_2_GREEN_DEPTH_1);
        VALUE_2_RED_DEPTH_2.addChild(VALUE_2_RED_DEPTH_1);
    }

    static final Tree getSimpleGreenTree() {
        return VALUE_1_GREEN_LEAF;
    }

    static final Tree getSimpleRedTree() {
        return VALUE_1_RED_LEAF;
    }

    static final Tree getTreeOfDepth1() {
        return VALUE_2_GREEN_DEPTH_1;
    }

    static final Tree getRedTree() {
        return VALUE_2_RED_DEPTH_1;
    }

    public static Tree getTreeOfDepth2() {
        return VALUE_2_RED_DEPTH_2;
    }
}

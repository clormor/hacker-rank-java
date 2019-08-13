package io.github.clormor.hackerrank.ai;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import static io.github.clormor.hackerrank.ai.BotSavesPrincess.bot_char;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.down_move;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.left_move;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.matrix_char;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.peach_char;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.right_move;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.up_move;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TestBotSavesPrincess {

    BotSavesPrincess b;

    static char[][] game_1 = {
            {matrix_char, matrix_char, matrix_char},
            {matrix_char, bot_char, matrix_char},
            {peach_char, matrix_char, matrix_char},
    };

    static char[][] game_2 = {
            {matrix_char, matrix_char, matrix_char, peach_char},
            {matrix_char, matrix_char, matrix_char, matrix_char},
            {matrix_char, matrix_char, matrix_char, matrix_char},
            {matrix_char, bot_char, matrix_char, matrix_char},
    };

    static char[][] no_princess_matrix = {
            {matrix_char, matrix_char, matrix_char},
            {matrix_char, bot_char, matrix_char},
            {matrix_char, matrix_char, matrix_char},
    };

    static char[][] no_bot_matrix = {
            {matrix_char, matrix_char, peach_char},
            {matrix_char, matrix_char, matrix_char},
            {matrix_char, matrix_char, matrix_char},
    };

    @Before
    public void init() {
        b = new BotSavesPrincess();
    }

    @Test
    public void test_next_move() {
        String expected = new StringBuilder()
                .append(down_move)
                .toString();

        runNextMoveTest(game_1,expected);
    }

    @Test
    public void test_game_1() {
        String expected = new StringBuilder()
                .append(down_move)
                .append(System.lineSeparator())
                .append(left_move)
                .append(System.lineSeparator())
                .toString();

        runFindTest(game_1,expected);
    }

    @Test
    public void test_game_2() {
        String expected = new StringBuilder()
                .append(up_move)
                .append(System.lineSeparator())
                .append(up_move)
                .append(System.lineSeparator())
                .append(up_move)
                .append(System.lineSeparator())
                .append(right_move)
                .append(System.lineSeparator())
                .append(right_move)
                .append(System.lineSeparator())
                .toString();

        runFindTest(game_2,expected);
    }

    @Test (expected = RuntimeException.class)
    public void missing_peach_throws_runtime_exception() {
        b.displayPathToPrincess(no_princess_matrix.length, no_princess_matrix);
    }

    @Test (expected = RuntimeException.class)
    public void missing_bot_throws_runtime_exception() {
        b.displayPathToPrincess(no_bot_matrix.length, no_bot_matrix);
    }

    @Test
    public void test_position_equality() {
        List<BotSavesPrincess.Position> ps = Lists.newArrayList(
                new BotSavesPrincess.Position(0,1),
                new BotSavesPrincess.Position(1,0),
                new BotSavesPrincess.Position(1,2),
                new BotSavesPrincess.Position(1,0),
                new BotSavesPrincess.Position(5,5),
                new BotSavesPrincess.Position(6,5),
                new BotSavesPrincess.Position(6,4),
                new BotSavesPrincess.Position(6,4),
                new BotSavesPrincess.Position(0,1)
                );

        Set<BotSavesPrincess.Position> uniques = Sets.newHashSet();
        for (BotSavesPrincess.Position p : ps) {
            int equalCount = 0;
            for (BotSavesPrincess.Position compare : ps) {
                if (p.equals(compare)) {
                    equalCount++;
                    assertEquals(p.hashCode(), compare.hashCode());
                }
            }
            // should always be at least equal to itself!
            assertTrue(equalCount > 0);

            // add each position to the set
            uniques.add(p);
        }

        // make sure the number of unique positions is correct
        assertEquals(6, uniques.size());

        assertNotEquals(ps.get(0), new Object());
    }

    private void runNextMoveTest(char[][] matrix, String expected) {
        BotSavesPrincess.Position peach = b.locateTarget(matrix.length, matrix, peach_char);
        BotSavesPrincess.Position bot = b.locateTarget(matrix.length, matrix, bot_char);
        String result = b.move(bot, peach).lastMove;
        assertEquals(expected, result);
    }

    private void runFindTest(char[][] matrix, String expected) {
        String result = b.displayPathToPrincess(matrix.length, matrix);
        assertEquals(expected, result);
    }
}

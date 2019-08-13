package io.github.clormor.hackerrank.ai;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static io.github.clormor.hackerrank.ai.BotSavesPrincess.BOT_CHAR;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.DOWN_MOVE;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.LEFT_MOVE;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.MATRIX_CHAR;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.PEACH_CHAR;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.RIGHT_MOVE;
import static io.github.clormor.hackerrank.ai.BotSavesPrincess.UP_MOVE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TestBotSavesPrincess {

    BotSavesPrincess b;

    static char[][] game_1 = {
            {MATRIX_CHAR, MATRIX_CHAR, MATRIX_CHAR},
            {MATRIX_CHAR, BOT_CHAR, MATRIX_CHAR},
            {PEACH_CHAR, MATRIX_CHAR, MATRIX_CHAR},
    };

    static char[][] game_2 = {
            {MATRIX_CHAR, MATRIX_CHAR, MATRIX_CHAR, PEACH_CHAR},
            {MATRIX_CHAR, MATRIX_CHAR, MATRIX_CHAR, MATRIX_CHAR},
            {MATRIX_CHAR, MATRIX_CHAR, MATRIX_CHAR, MATRIX_CHAR},
            {MATRIX_CHAR, BOT_CHAR, MATRIX_CHAR, MATRIX_CHAR},
    };

    static char[][] no_princess_matrix = {
            {MATRIX_CHAR, MATRIX_CHAR, MATRIX_CHAR},
            {MATRIX_CHAR, BOT_CHAR, MATRIX_CHAR},
            {MATRIX_CHAR, MATRIX_CHAR, MATRIX_CHAR},
    };

    static char[][] no_bot_matrix = {
            {MATRIX_CHAR, MATRIX_CHAR, PEACH_CHAR},
            {MATRIX_CHAR, MATRIX_CHAR, MATRIX_CHAR},
            {MATRIX_CHAR, MATRIX_CHAR, MATRIX_CHAR},
    };

    @Before
    public void init() {
        b = new BotSavesPrincess();
    }

    @Test
    public void test_next_move() {
        String expected = new StringBuilder()
                .append(DOWN_MOVE)
                .toString();

        runNextMoveTest(game_1,expected);
    }

    @Test
    public void test_game_1() {
        String expected = new StringBuilder()
                .append(DOWN_MOVE)
                .append(System.lineSeparator())
                .append(LEFT_MOVE)
                .append(System.lineSeparator())
                .toString();

        runFindTest(game_1,expected);
    }

    @Test
    public void test_game_2() {
        String expected = new StringBuilder()
                .append(UP_MOVE)
                .append(System.lineSeparator())
                .append(UP_MOVE)
                .append(System.lineSeparator())
                .append(UP_MOVE)
                .append(System.lineSeparator())
                .append(RIGHT_MOVE)
                .append(System.lineSeparator())
                .append(RIGHT_MOVE)
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
        BotSavesPrincess.Position peach = b.locateTarget(matrix.length, matrix, PEACH_CHAR);
        BotSavesPrincess.Position bot = b.locateTarget(matrix.length, matrix, BOT_CHAR);
        String result = b.move(bot, peach).lastMove;
        assertEquals(expected, result);
    }

    private void runFindTest(char[][] matrix, String expected) {
        String result = b.displayPathToPrincess(matrix.length, matrix);
        assertEquals(expected, result);
    }
}

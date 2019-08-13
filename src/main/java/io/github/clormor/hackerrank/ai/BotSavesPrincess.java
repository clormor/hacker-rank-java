package io.github.clormor.hackerrank.ai;

import com.google.common.annotations.VisibleForTesting;

public class BotSavesPrincess {

    static final char BOT_CHAR = 'm';
    static final char MATRIX_CHAR = '-';
    static final char PEACH_CHAR = 'p';

    static final String UP_MOVE = "UP";
    static final String RIGHT_MOVE = "RIGHT";
    static final String DOWN_MOVE = "DOWN";
    static final String LEFT_MOVE = "LEFT";

    public String displayPathToPrincess(int n, char[][] matrix) {
        StringBuilder result = new StringBuilder();
        Position peach = locateTarget(n, matrix, PEACH_CHAR);
        Position bot = locateTarget(n, matrix, BOT_CHAR);
        while (!bot.equals(peach)) {
            Move lastMove = move(bot, peach);
            bot = lastMove.newPosition;
            result.append(lastMove.lastMove).append(System.lineSeparator());
        }
        return result.toString();
    }

    @VisibleForTesting
    Position locateTarget(int n, char[][] matrix, char target) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (matrix[y][x] == target) {
                    return new Position(x, y);
                }
            }
        }
        throw new RuntimeException("Target (" + target + ") is missing!");
    }

    public Move move(Position bot, Position peach) {
        String move = null;

        // do the up/down moves first
        if (bot.y > peach.y) {
            move = UP_MOVE;
            bot.y--;
        } else if (bot.y < peach.y) {
            move = DOWN_MOVE;
            bot.y++;
        } else if (bot.x > peach.x) {
            move = LEFT_MOVE;
            bot.x--;
        } else {
            move = RIGHT_MOVE;
            bot.x++;
        }

        return new Move(bot, move);
    }

    static class Position {
        int x;
        int y;

        Position(int _x, int _y) {
            x = _x;
            y = _y;
        }

        public boolean equals(Object o) {
            if (o instanceof Position) {
                Position p = (Position) o;
                return ((p.x == x) && (p.y == y));
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return x * y;
        }
    }

    static class Move {
        Position newPosition;
        String lastMove;

        Move(Position p, String m) {
            newPosition = p;
            lastMove = m;
        }
    }
}

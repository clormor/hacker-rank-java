package io.github.clormor.hackerrank.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DequeExample {

    public int maxUnique(int m, Integer[] input) {
        // populate the initial queue
        Deque<Integer> dq = new ArrayDeque<Integer>(m);
        // populate dictionary of numbers to occurrences
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            dq.add(input[i]);
            occurrences.put(input[i], occurrences.getOrDefault(input[i], 0) + 1);
        }

        // history of max size
        int result = occurrences.keySet().size();
        // rolling window - count unique integers each loop
        for (int i = m; i < input.length; i++) {
            int last = dq.removeFirst();
            occurrences.put(last, occurrences.get(last) - 1);
            if (occurrences.get(last) == 0) occurrences.remove(last);

            int next = input[i];
            dq.addLast(next);
            occurrences.put(next, occurrences.getOrDefault(next, 0) + 1);
            result = Math.max(result, occurrences.keySet().size());
        }

        return result;
    }
}

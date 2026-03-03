package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        return Arrays.stream(queries)
            .map(it -> areConnected(n, threshold, Set.of(it[0]), it[1]))
            .toList();
    }

    private boolean areConnected(int n, int threshold, Set<Integer> soFar, int y) {
        var newConnections = IntStream.range(1, n + 1)
            .boxed()
            .filter(it -> areDirectlyConnected(n, threshold, soFar, it))
            .collect(Collectors.toSet());
        if (newConnections.contains(y)) {
            return true;
        }
        var newSoFar = Stream.concat(
            soFar.stream(),
            newConnections.stream()
        ).collect(Collectors.toSet());
        if (newSoFar.size() == soFar.size()) {
            return false;
        }
        return areConnected(n, threshold, newSoFar, y);
    }

    private boolean areDirectlyConnected(int n, int threshold, Collection<Integer> x, int y) {
        return IntStream.range(threshold + 1, n + 1)
            .anyMatch(z -> x.stream().anyMatch(it -> it % z == 0 && y % z == 0));
    }
}

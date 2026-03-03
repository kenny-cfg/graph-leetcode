package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void firstTestCase() {
        var expected = List.of(false, false, true);

        var actual = solution.areConnected(6, 2, new int[][]{new int[]{1, 4}, new int[]{2, 5}, new int[]{3, 6}});

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void complicatedTestCase() {
        var expected = List.of(true, true, true);

        var actual = solution.areConnected(9, 1,
            new int[][]{
                new int[]{6, 8}, new int[]{6, 9},
                new int[]{8, 9}
        });

        assertThat(actual).isEqualTo(expected);
    }
}
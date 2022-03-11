package miscellaneous;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EightQueensProblemTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3, 5})
        // should NOT have solutions
    void negativeEightQueensProblemSolutionForFirstTen(int number) {
        EightQueensProblem.doesHaveEightQueensProblemSolution(number);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 7, 8, 9, 10})
        // should have solutions
    void eightQueensProblemSolutionForFirstTen(int number) {
        assertTrue(EightQueensProblem.doesHaveEightQueensProblemSolution(number));
    }


    @Test
    void solution() {
    }

    @Test
    void isSafe() {
    }

    @Test
    void solveNQueens() {
    }
}
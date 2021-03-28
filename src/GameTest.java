import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private static Stream<Arguments> GameCasesProvider() {
        return Stream.of(
                Arguments.of(Game.STR_ROCK, Game.STR_ROCK, Game.RESULT_DRAW),
                Arguments.of(Game.STR_ROCK, Game.STR_PAPER, Game.RESULT_P2_WIN),
                Arguments.of(Game.STR_ROCK, Game.STR_SCISSORS, Game.RESULT_P1_WIN),

                Arguments.of(Game.STR_PAPER, Game.STR_ROCK, Game.RESULT_P1_WIN),
                Arguments.of(Game.STR_PAPER, Game.STR_PAPER, Game.RESULT_DRAW),
                Arguments.of(Game.STR_PAPER, Game.STR_SCISSORS, Game.RESULT_P2_WIN),

                Arguments.of(Game.STR_SCISSORS, Game.STR_ROCK, Game.RESULT_P2_WIN),
                Arguments.of(Game.STR_SCISSORS, Game.STR_PAPER, Game.RESULT_P1_WIN),
                Arguments.of(Game.STR_SCISSORS, Game.STR_SCISSORS, Game.RESULT_DRAW),

                Arguments.of("HELLO", "WORLD", -1)
        );
    }

    private static Stream<Arguments> InvalidInputStringProvider() {
        return Stream.of(
                Arguments.of("HELLO_WORLD"),
                Arguments.of("null"),
                Arguments.of("123"),
                Arguments.of("64.7777")
        );
    }

    private static Stream<Arguments> ValidInputStringProvider() {
        return Stream.of(
                Arguments.of(Game.STR_ROCK),
                Arguments.of(Game.STR_PAPER),
                Arguments.of(Game.STR_SCISSORS)
        );
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("ValidInputStringProvider")
    void inputValidator_ValidCases(String input_str) {
        Game target = new Game();

        assertTrue(target.InputValidator(input_str));
    }

    @ParameterizedTest
    @MethodSource("InvalidInputStringProvider")
    void inputValidator_InValidCases(String input_str) {
        Game target = new Game();
        String invalid_message = "Input String Invalid PEKO";

        Exception e = assertThrows(IllegalArgumentException.class, () -> target.InputValidator(input_str));

        assertEquals(invalid_message, e.getMessage());
    }

    @ParameterizedTest
    @MethodSource("GameCasesProvider")
    void whosWinner_AllCases(String p1, String p2, int res) {
        Game target = new Game();
        assertEquals(res, target.WhosWinner(p1, p2));
    }
}
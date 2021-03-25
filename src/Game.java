import java.util.Set;

public class Game {
    static final String STR_ROCK = "rock";
    static final String STR_PAPER = "paper";
    static final String STR_SCISSORS = "scissors";
    static final String RESULT_DRAW = "0";
    static final String RESULT_P1_WIN = "1";
    static final String RESULT_P2_WIN = "2";

    static final Set<String> valid_choice_set = Set.of(STR_ROCK, STR_PAPER, STR_SCISSORS);

    static final String[][] ResultTable = {
            {STR_ROCK, STR_ROCK, RESULT_DRAW},
            {STR_ROCK, STR_SCISSORS, RESULT_P1_WIN},
            {STR_ROCK, STR_PAPER, RESULT_P2_WIN},

            {STR_PAPER, STR_PAPER, RESULT_DRAW},
            {STR_PAPER, STR_ROCK, RESULT_P1_WIN},
            {STR_PAPER, STR_SCISSORS, RESULT_P2_WIN},

            {STR_SCISSORS, STR_SCISSORS, RESULT_DRAW},
            {STR_SCISSORS, STR_PAPER, RESULT_P1_WIN},
            {STR_SCISSORS, STR_ROCK, RESULT_P2_WIN}
    };

    public void InputValidator(String player_choice) throws IllegalArgumentException {
        if (!valid_choice_set.contains(player_choice)) {
            throw new IllegalArgumentException("Input String Invalid PEKO");
        }
    }

    public int WhosWinner(String choice_player1, String choice_player2) throws IllegalArgumentException {
        int result = -1; // 0 is draw, 1 is player1 win, 2 is player2 win.

        for (int i = 0; i < 9; ++i) {
            if (choice_player1.equals(ResultTable[i][0]) && choice_player2.equals(ResultTable[i][1])) {
                result = i % 3;
                return result;
            }
        }

        return result;
    }
}

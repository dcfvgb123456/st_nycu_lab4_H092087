import java.util.Set;

public class Game {
    static final String STR_ROCK = "rock";
    static final String STR_PAPER = "paper";
    static final String STR_SCISSORS = "scissors";
    static final int RESULT_DRAW = 0;
    static final int RESULT_P1_WIN = 1;
    static final int RESULT_P2_WIN = 2;

    static private class game_result {
        String P1_Choice;
        String P2_Choice;
        int result;

        game_result(String p1, String p2, int res)
        {
            P1_Choice = p1;
            P2_Choice = p2;
            result = res;
        }
    }

    static final Set<String> valid_choice_set = Set.of(STR_ROCK, STR_PAPER, STR_SCISSORS);

    static final game_result[] ResultTable = {
            new game_result(STR_ROCK, STR_ROCK, RESULT_DRAW),
            new game_result(STR_ROCK, STR_SCISSORS, RESULT_P1_WIN),
            new game_result(STR_ROCK, STR_PAPER, RESULT_P2_WIN),

            new game_result(STR_PAPER, STR_PAPER, RESULT_DRAW),
            new game_result(STR_PAPER, STR_ROCK, RESULT_P1_WIN),
            new game_result(STR_PAPER, STR_SCISSORS, RESULT_P2_WIN),

            new game_result(STR_SCISSORS, STR_SCISSORS, RESULT_DRAW),
            new game_result(STR_SCISSORS, STR_PAPER, RESULT_P1_WIN),
            new game_result(STR_SCISSORS, STR_ROCK, RESULT_P2_WIN)
    };

    public boolean InputValidator(String player_choice) throws IllegalArgumentException {
        if (!valid_choice_set.contains(player_choice)) {
            throw new IllegalArgumentException("Input String Invalid PEKO");
        }

        return true;
    }

    public int WhosWinner(String choice_player1, String choice_player2) throws IllegalArgumentException {
        int result = -1; // 0 is draw, 1 is player1 win, 2 is player2 win.

        for (int i = 0; i < 9; ++i) {
            if (choice_player1.equals(ResultTable[i].P1_Choice) && choice_player2.equals(ResultTable[i].P2_Choice)) {
                return ResultTable[i].result;
            }
        }

        return result;
    }
}

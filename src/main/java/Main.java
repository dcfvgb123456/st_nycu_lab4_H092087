import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner my_scanner = new Scanner(System.in);
        Game judge = new Game();
        String choice_player1, choice_player2;
        int result;

        System.out.println("-----Rock Paper Scissors GAME------");
        System.out.println("Enter Player 1 choice (rock, paper or scissors):");
        choice_player1 = my_scanner.next();
        try {
            judge.InputValidator(choice_player1);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        System.out.println("Enter Player 2 choice (rock, paper or scissors):");
        choice_player2 = my_scanner.next();
        try {
            judge.InputValidator(choice_player2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        result = judge.WhosWinner(choice_player1, choice_player2);

        switch (result)
        {
            case 0:
                System.out.println("Draw!");
                break;
            case 1:
                System.out.println("Player 1 win!");
                break;
            case 2:
                System.out.println("Player 2 win!");
                break;
            default:
                throw new IllegalArgumentException("Not Acceptable Result Number!");
        }
    }
}

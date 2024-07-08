import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
            System.out.print("row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("column (0-2): ");
            int column = scanner.nextInt();

            if (board.isCellEmpty(row, column)) {
                board.place(row, column, currentPlayer.getMarker());
                if (board.hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    break;
                }
                if (board.isFull()) {
                    board.print();
                    System.out.println("The game is a tie!");
                    break;
                }
                switchCurrentPlayer();
            } else {
                System.out.println("Cell is not empty! Try again.");
            }
        }
        scanner.close();
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            TicTacToe game = new TicTacToe();
            game.start();
            System.out.print("Do you want to play again? (yes/no): ");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }
}
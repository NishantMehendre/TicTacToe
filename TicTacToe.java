import java.io.*;
import java.util.*;

public class TicTacToe {
    public void createGame() {
        String pos[] = new String[9];
        int n = 1;
        for (int i = 0; i < 9; i++) {
            pos[i] = "" + n;
            n++;
        }
        boolean gameOver = false;
        String play = "";
        Scanner sc = new Scanner(System.in);
        Scanner first = new Scanner(System.in);
        boolean validPlayer1 = true;
        String player1 = "";
        // Continues to receive input from player until valid input is received
        while (validPlayer1 == true) {
            System.out.println("Who will play first (enter \"x\" or \"o\")");
            player1 = first.nextLine();
            if ((player1.equals("x")) || player1.equals("o"))
                validPlayer1 = false;
            else
                System.out.println("Enter valid input");
        }
        boolean victory = false;
        int turn = 0;
        // Continues the game until it ends in draw or a player wins
        while (gameOver == false) {
            if (player1.equals("x")) {
                if (turn % 2 == 0)
                    play = "x";
                else
                    play = "o";
            } else {
                if (turn % 2 == 0)
                    play = "o";
                else
                    play = "x";
            }
            System.out.println("  " + pos[0] + "  " + "|" + "  " + pos[1] + "  " + "|" + "  " + pos[2] + "  ");
            System.out.println("_____" + "|" + "_____" + "|" + "_____");
            System.out.println("  " + pos[3] + "  " + "|" + "  " + pos[4] + "  " + "|" + "  " + pos[5] + "  ");
            System.out.println("_____" + "|" + "_____" + "|" + "_____");
            System.out.println("  " + pos[6] + "  " + "|" + "  " + pos[7] + "  " + "|" + "  " + pos[8] + "  ");
            System.out.println("     " + "|" + "     " + "|" + "     ");
            if ((pos[0].equals(pos[1]) && pos[0].equals(pos[2])) || (pos[0].equals(pos[3]) && pos[0].equals(pos[6]))
                    || (pos[0].equals(pos[4]) && pos[0].equals(pos[8]))) {
                System.out.println("Congratulations \"" + pos[0] + "\" has won the game!");
                victory = true;
                break;
            }
            if (pos[1].equals(pos[4]) && pos[1].equals(pos[7])) {
                System.out.println("Congratulations \"" + pos[1] + "\" has won the game!");
                victory = true;
                break;
            }
            if ((pos[2].equals(pos[5]) && pos[2].equals(pos[8])) || (pos[2].equals(pos[4]) && pos[2].equals(pos[6]))) {
                System.out.println("Congratulations \"" + pos[2] + "\" has won the game!");
                victory = true;
                break;
            }
            if (pos[3].equals(pos[4]) && pos[3].equals(pos[5])) {
                System.out.println("Congratulations \"" + pos[3] + "\" has won the game!");
                break;
            }
            if (pos[6].equals(pos[7]) && pos[6].equals(pos[8])) {
                System.out.println("Congratulations \"" + pos[6] + "\" has won the game!");
                victory = true;
                break;
            }
            int count = 0;
            // Checks if vacant position is available
            for (int h = 0; h < pos.length; h++) {
                if ((pos[h].equals("x") || pos[h].equals("o") == true))
                    count++;
                //Ends the game when vacant position is not available
                if (count == 9) {
                    //If vacant position is not available checks if a player has won
                    if (victory == false)
                        System.out.println("It's a draw.");
                    gameOver = true;
                }
            }
            String s = "";
            boolean validInput = false;
            int count1 = 0;
            // Continues to receive input from players until a valid input is entered
            while (validInput == false) {
                if (count1 > 0) {
                    System.out.println("Enter valid position(between 1 and 9 included)");
                }
                if (count < 9) {
                    System.out.println("Enter position " + "(" + play + ")");
                } else
                    break;
                s = sc.nextLine();
                for (int o = 1; o < 10; o++) {
                    String check1 = "" + o;
                    if (s.equals(check1))
                        validInput = true;
                }
                count1++;
            }
            for (int j = 0; j < pos.length; j++) {
                String check = "" + (j + 1);
                if (check.equals(s)) {
                    // Checks if the position entered by user is vacant
                    if ((pos[j].equals("x") || pos[j].equals("o")) == true) {
                        System.out.println("This position is not vacant. Please select another position");
                        turn--;
                    } else
                        pos[j] = play;
                }
            }
            turn++;
        }
    }
}

class Driver {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.createGame();
    }
}
package tech.adelemphii.adventofcode.challenges;

import tech.adelemphii.adventofcode.enums.Outcome;
import tech.adelemphii.adventofcode.enums.Shape;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RockPaperScissors {

    private static final String player1Name = "player1";
    private static final String player2Name = "player2";

    public static String getPlayer1Name() {
        return player1Name;
    }

    public static String getPlayer2Name() {
        return player2Name;
    }

    public void print(File file) {
        Map<String, Integer> players = new FileReader(file).readFile();
        if(players == null) {
            System.out.println("Invalid format. Use \"A Y\".");
            return;
        }

        int player1Score = players.get(player1Name);
        int player2Score = players.get(player2Name);

        if(player1Score > player2Score) {
            System.out.println("Player 1 wins! Score: " + player1Score);
        } else {
            System.out.println("Player 2 wins! Score: " + player2Score);
        }
        System.out.println("Total Scores:");
        System.out.println("  " + player1Name + " - " + player1Score);
        System.out.println("  " + player2Name + " - " + player2Score);
    }

    // such me-tier code
    private record FileReader(File file) {
        public Map<String, Integer> readFile() {
            Map<String, Integer> points = new HashMap<>();

            try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] args = line.split(" ");
                    if(args[0] == null || args[1] == null) {
                        return null;
                    }
                    char p1Char = args[0].charAt(0);
                    char p2Char = args[1].charAt(0);

                    Shape p1Input = Shape.getShapeFromChar(p1Char);
                    Shape p2Input = Shape.getShapeFromChar(p2Char);
                    if(p1Input == null || p2Input == null) {
                        return null;
                    }

                    int player1Total = points.getOrDefault(getPlayer1Name(), 0)
                            + p1Input.getPoints();
                    int player2Total = points.getOrDefault(getPlayer2Name(), 0)
                            + p2Input.getPoints();

                    if(p1Input.canBeat() == p2Input) {
                        player1Total += Outcome.WIN.getScore();
                    } else if(p1Input == p2Input) {
                        player1Total += Outcome.DRAW.getScore();
                        player2Total += Outcome.DRAW.getScore();
                    } else {
                        player2Total += Outcome.WIN.getScore();
                    }

                    points.put(getPlayer1Name(), player1Total);
                    points.put(getPlayer2Name(), player2Total);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return points;
        }
    }
}

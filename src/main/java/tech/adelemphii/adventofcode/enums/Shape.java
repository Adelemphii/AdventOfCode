package tech.adelemphii.adventofcode.enums;

public enum Shape {

    ROCK('A', 'X', 1),
    PAPER('B', 'Y', 2),
    SCISSORS('C', 'Z', 3);

    private final char p1Answer;
    private final char p2Answer;
    private final int points;

    Shape(char p1Answer, char p2Answer, int points) {
        this.p1Answer = p1Answer;
        this.p2Answer = p2Answer;
        this.points = points;
    }

    public static Shape getShapeFromChar(char c) {
        for(Shape shape : values()) {
            if(c == shape.p1Answer || c == shape.p2Answer) {
                return shape;
            }
        }
        return null;
    }

    public Shape canBeat() {
        return switch(this) {
            case ROCK -> SCISSORS;
            case PAPER -> ROCK;
            case SCISSORS -> PAPER;
        };
    }

    public char getP1Answer() {
        return p1Answer;
    }

    public char getP2Answer() {
        return p2Answer;
    }

    public int getPoints() {
        return points;
    }
}

package tech.adelemphii.adventofcode.enums;

public enum Outcome {

    WIN(6),
    LOSS(0),
    DRAW(3);

    private final int score;

    Outcome(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

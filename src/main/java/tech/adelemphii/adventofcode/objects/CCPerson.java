package tech.adelemphii.adventofcode.objects;

public class CCPerson {

    private final long calories;
    private final int id;

    public CCPerson(long calories, int id) {
        this.calories = calories;
        this.id = id;
    }

    public long getCalories() {
        return calories;
    }

    public int getId() {
        return id;
    }
}

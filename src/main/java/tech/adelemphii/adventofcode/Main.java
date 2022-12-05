package tech.adelemphii.adventofcode;

import tech.adelemphii.adventofcode.challenges.CalorieCounter;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File calorieInput = new File(System.getProperty("user.dir") + "/input/calorie_counter.txt");
        new CalorieCounter(calorieInput).print();
    }
}
package tech.adelemphii.adventofcode;

import tech.adelemphii.adventofcode.challenges.CalorieCounter;
import tech.adelemphii.adventofcode.challenges.RockPaperScissors;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        //File calorieInput = new File(System.getProperty("user.dir") + "/input/calorie_counter.txt");
        //new CalorieCounter(calorieInput).print();

        File rpcInput = new File(System.getProperty("user.dir") + "/input/rpc.txt");
        new RockPaperScissors().print(rpcInput);
    }
}
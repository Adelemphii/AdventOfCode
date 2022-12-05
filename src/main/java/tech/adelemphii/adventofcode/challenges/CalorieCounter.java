package tech.adelemphii.adventofcode.challenges;

import tech.adelemphii.adventofcode.objects.CCPerson;
import tech.adelemphii.adventofcode.utility.InputReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class CalorieCounter {

    private final Map<Integer, CCPerson> people;

    public CalorieCounter(File file) {
        people = new FileReader(file).readFile();
    }

    public void print() {
        List<CCPerson> collection = new ArrayList<>(people.values().stream()
                .sorted(Comparator.comparing(CCPerson::getCalories))
                .toList());
        Collections.reverse(collection);
        collection.forEach(person -> System.out.println(person.getId() + " - " + person.getCalories()));

        System.out.println("Top 3:");
        int j = 0;
        int total = 0;
        for(CCPerson person : collection) {
            if(j == 3) {
                break;
            }
            total += person.getCalories();

            System.out.println(person.getId() + " - " + person.getCalories());
            j++;
        }
        System.out.println("Total: " + total);
    }

    // such me-tier code
    private record FileReader(File file) {
        public Map<Integer, CCPerson> readFile() {
            Map<Integer, CCPerson> people = new HashMap<>();

            try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
                int id = 0;
                String line;
                Set<Long> calories = new HashSet<>();
                while ((line = reader.readLine()) != null) {
                    Long calorie = InputReader.parseLong(line);
                    if(calorie == -1) {
                        people.put(id, new CCPerson(calculateTotal(calories), id));
                        calories.clear();
                        id++;
                        continue;
                    }
                    calories.add(calorie);
                }
                if(!calories.isEmpty()) {
                    people.put(id, new CCPerson(calculateTotal(calories), id));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return people;
        }

        private long calculateTotal(Set<Long> calories) {
            long total = 0;
            for(long j : calories) {
                total += j;
            }
            return total;
        }
    }
}

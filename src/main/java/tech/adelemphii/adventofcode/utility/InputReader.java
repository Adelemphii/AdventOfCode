package tech.adelemphii.adventofcode.utility;

public class InputReader {

    public static Long parseLong(String string) {
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }
}

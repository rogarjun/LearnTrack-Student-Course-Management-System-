package Util;

public class InputValidator {

    public static boolean isValidId(int id) {
        return id > 0;
    }

    public static boolean isValidMenuChoice(int choice, int min, int max) {
        return choice >= min && choice <= max;
    }

    public static boolean isValidName(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email != null
                && !email.trim().isEmpty()
                && email.contains("@")
                && email.contains(".");
    }

    public static boolean isValidBatch(String batch) {
        return batch != null && !batch.trim().isEmpty();
    }

    public static boolean isValidCourseName(String courseName) {
        return courseName != null && !courseName.trim().isEmpty();
    }

    public static boolean isValidDescription(String description) {
        return description != null && !description.trim().isEmpty();
    }

    public static boolean isValidDurationInWeeks(int durationInWeeks) {
        return durationInWeeks > 0;
    }

    public static boolean isValidStatus(String status) {
        return status != null &&
                (status.equalsIgnoreCase("ACTIVE")
                        || status.equalsIgnoreCase("COMPLETED")
                        || status.equalsIgnoreCase("CANCELLED"));
    }

    public static boolean isValidBooleanInput(String input) {
        return input != null &&
                (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false"));
    }
}
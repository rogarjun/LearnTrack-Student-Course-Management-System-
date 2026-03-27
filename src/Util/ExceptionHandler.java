package Util;

public class ExceptionHandler {

    public static void handleException(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }
}
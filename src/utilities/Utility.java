package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by sys1095 on 8/12/17.
 */
public class Utility {

    public static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner input = new Scanner(System.in);

    public static enum dataType {
        String, Number
    }

    public static enum processState {
        stop, STOP, q, quit, Q, Quit, QUIT,SHOW, show, hint
    }

    public static enum conditionConstants {
        NON_ZERO, LESS_ZERO, POSITIVE
    }

//    public static boolean isNullOrEmpty(Object obj) {
//        return obj == null || Objects.equals(obj, "") || Objects.equals(obj, " ");
//    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || Objects.equals(string, "") || Objects.equals(string, " ");
    }

    public static String getStringFromConsole() {
        return input.nextLine();
    }

    public static int getNumberFromConsole() {
        return input.nextInt();
    }

    public static String getInputFromConsole() {
        String userInput = "";
        try {
            userInput = keyboardInput.readLine().trim();
        } catch (Exception e) {
            System.out.println(e + " getInputFromConsole@Utility");
        }
        return userInput;
    }

    public static boolean isInteger(String string) {
        boolean isInt = true;
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            isInt = false;
        }
        return isInt;
    }

    public static String takeInputFromKeyBoard() {
        Scanner input = new Scanner(System.in);
        String s = "";
        s = input.nextLine();
        return s.trim();
    }

    public static String getRawInput() {
        return input.nextLine();
    }
}

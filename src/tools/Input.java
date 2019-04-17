package tools;

import java.util.Scanner;

public class Input {
    public static String getInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static String[] formatLoginInput() {
        return getInput().split(":");
    }
}

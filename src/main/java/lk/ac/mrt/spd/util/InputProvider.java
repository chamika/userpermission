package lk.ac.mrt.spd.util;

import java.util.Scanner;

/**
 * Created by chamika on 2/11/17.
 */
public class InputProvider {

    public static Scanner SCANNER;

    public static Scanner getSCANNER() {
        if (SCANNER == null) {
            SCANNER = new Scanner(System.in);
        }
        return SCANNER;
    }
}

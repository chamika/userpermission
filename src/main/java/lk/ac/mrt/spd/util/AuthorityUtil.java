package lk.ac.mrt.spd.util;

import lk.ac.mrt.spd.model.User;

import java.util.Scanner;

/**
 * Created by chamika on 2/11/17.
 */
public class AuthorityUtil {

    public static boolean escalateLevel(User user, int level) {
        if (user.getMaxLevel() < level) {
            System.out.println("Failed. Trying to escalate above the user permission.");
        }

        if (user.getCurrentLevel() >= level) {
            return true;
        }

        boolean exitAuthentication = true;
        do {
            Scanner scanner = InputProvider.getSCANNER();
            System.out.println("Enter User " + user.getUsername() + " password: ");
            String input = scanner.nextLine();

            if (user.getPassword().equals(input)) {
                System.out.println("User " + user.getUsername() + " authenticated");
                exitAuthentication = true;
            } else {
                System.out.println("Authentication failed. Invalid password");
                System.out.println("Do you need to retry (y for YES)");
                String answer = scanner.nextLine();
                if ("y".equals(answer.toLowerCase())) {
                    exitAuthentication = false;
                } else {
                    return false;
                }
            }
        } while (!exitAuthentication);

        user.setCurrentLevel(level);
        return true;
    }
}

package lk.ac.mrt.spd.model;

import lk.ac.mrt.spd.exception.NotPermittedException;

/**
 * Created by chamika on 2/11/17.
 */
public class Task {
    private String name;
    private int minUserLevel;

    public Task(String name, int minUserLevel) {
        this.name = name;
        this.minUserLevel = minUserLevel;
    }

    public boolean execute(User user) throws NotPermittedException {

        if (this.minUserLevel > user.getCurrentLevel()) {
            throw new NotPermittedException("Not permitted to execute " + this.minUserLevel
                    + " task with " + user.getCurrentLevel() + " user level");
        }

        System.out.println("Task : " + name + " executed successfully by " + user.getUsername() + " under level: " + user.getCurrentLevel());

        return true;
    }

    public String getName() {
        return name;
    }

    public int getMinUserLevel() {
        return minUserLevel;
    }
}

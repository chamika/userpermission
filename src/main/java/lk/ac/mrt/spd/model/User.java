package lk.ac.mrt.spd.model;

/**
 * Created by chamika on 2/11/17.
 */
public class User {

    private String username;
    private String password;
    private int maxLevel;
    private int currentLevel;

    public User(String username, String password, int maxLevel) {
        this.username = username;
        this.password = password;
        this.maxLevel = maxLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        if (this.currentLevel == currentLevel) {
            return;
        }
        if (this.currentLevel < currentLevel) {
            System.out.println("User " + getUsername() + " level is escalated from " + this.currentLevel + " to " + currentLevel);
        } else {
            System.out.println("User " + getUsername() + " level is de-escalated from " + this.currentLevel + " to " + currentLevel);
        }
        this.currentLevel = currentLevel;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

}

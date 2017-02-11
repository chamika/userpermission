package lk.ac.mrt.spd.util;

import lk.ac.mrt.spd.exception.NotPermittedException;
import lk.ac.mrt.spd.model.Program;
import lk.ac.mrt.spd.model.Task;
import lk.ac.mrt.spd.model.User;

/**
 * Created by chamika on 2/11/17.
 */
public class TaskExecutor {

    public static boolean executeTask(Task task, User user) {

        //check if user meet task min level
        if (task.getMinUserLevel() > user.getMaxLevel()) {
            System.out.println("User " + user.getUsername() + " does not fulfill user level");
            return false;
        }

        //check and ask for authentication if user's current level is not permitted but possible to escalate
        if (task.getMinUserLevel() > user.getCurrentLevel() && task.getMinUserLevel() <= user.getMaxLevel()) {
            System.out.println("User " + user.getUsername() + " need to escalate permission level to execute task "
                    + task.getName());
            AuthorityUtil.escalateLevel(user, task.getMinUserLevel());
        }

        int initialLevel = user.getCurrentLevel();

        // de-escalate
        user.setCurrentLevel(task.getMinUserLevel());
        try {
            task.execute(user);
        } catch (NotPermittedException e) {
            e.printStackTrace();
            return false;
        }
        user.setCurrentLevel(initialLevel);

        System.out.println("Finished executing task " + task.getName());
        return true;
    }

    public static void executeProgram(Program program, User user) {
        System.out.println("Program " + program.getName() + " started executing with user: " + user.getUsername());
        int maxTasksLevel = 0;
        for (Task task : program.getTasks()) {
            if (maxTasksLevel < task.getMinUserLevel()) {
                maxTasksLevel = task.getMinUserLevel();
            }
        }

        AuthorityUtil.escalateLevel(user, maxTasksLevel);


        for (Task task : program.getTasks()) {
            System.out.println("----------");
            boolean status = executeTask(task, user);
            if (!status) {
                System.out.println("Task " + task.getName() + " failed to execute. Program will be terminated");
                break;
            }
        }
        System.out.println("Program " + program.getName() + " finished executing with user: " + user.getUsername());
    }


}

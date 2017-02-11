package lk.ac.mrt.spd;


import lk.ac.mrt.spd.model.Program;
import lk.ac.mrt.spd.model.Task;
import lk.ac.mrt.spd.model.User;
import lk.ac.mrt.spd.util.TaskExecutor;

public class App
{
    public static void main( String[] args )
    {
        Program program = new Program("Find and replace text");

        program.addTask(new Task("list files", 2));

        // operations in file 1
        program.addTask(new Task("select file 1", 2));
        program.addTask(new Task("open file 1", 3));
        program.addTask(new Task("find text in file 1", 3));
        program.addTask(new Task("replace text in file 1", 5));
        program.addTask(new Task("close file 1", 3));

        // operations in file 2
        program.addTask(new Task("select file 2", 2));
        program.addTask(new Task("open file 2", 7));
        program.addTask(new Task("find text in file 2", 7));
        program.addTask(new Task("replace text in file 2", 8));
        program.addTask(new Task("close file 2", 7));


        User user1 = new User("user1", "pw1234", 10);
        TaskExecutor.executeProgram(program, user1);
    }
}

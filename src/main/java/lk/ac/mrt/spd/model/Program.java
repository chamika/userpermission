package lk.ac.mrt.spd.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamika on 2/11/17.
 */
public class Program {
    private String name;
    private List<Task> tasks;

    public Program(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<Task>();
        }
        return tasks;
    }

    public void addTask(Task task) {
        getTasks().add(task);
    }

    public String getName() {
        return name;
    }
}

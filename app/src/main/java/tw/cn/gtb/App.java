package tw.cn.gtb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class App {
    static final String TASK_FILE = System.getProperty("user.home") + File.separator + ".todo" + File.separator + "tasks";

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        List<Task> tasks = readAllTasks();
        return formattedTasks(tasks);
    }

    private List<String> formattedTasks(List<Task> tasks) {
        List<String> res = new ArrayList<>();
        res.add("#To be done");
        res.addAll(getConditionalTask(tasks, false));
        res.add("#Completed");
        res.addAll(getConditionalTask(tasks, true));
        return res;
    }

    private Collection<String> getConditionalTask(List<Task> tasks, boolean completed) {
        List<String> res = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted() == completed) {
                String s = task.getId() + " " + task.getName();
                res.add(s);
            }
        }
        if (res.isEmpty()) res.add("Empty");
        return res;
    }

    private static List<Task> readAllTasks() {
        List<Task> tasks = new ArrayList<>();
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(TASK_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < lines.size(); i++) {
            String[] fields = lines.get(i).split(" ", 2);
            boolean completed = fields[0].equals("√");
            tasks.add(new Task(i + 1, fields[1], completed));
        }
        return tasks;
    }
}

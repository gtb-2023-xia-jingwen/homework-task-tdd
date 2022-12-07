package tw.cn.gtb;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class App {
    static final TaskRespository taskRespository = new TaskRespository();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        List<String> fileLines = taskRespository.readFileLines();
        List<Task> tasks = taskRespository.LoadTasks(fileLines);
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
}

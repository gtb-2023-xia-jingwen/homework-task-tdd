package tw.cn.gtb;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    static final TaskRespository taskRespository = new TaskRespository();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        List<String> fileLines = taskRespository.readFileLines();
        List<Task> tasks = taskRespository.LoadTasks(fileLines);
        return getFormattedTasks(tasks);
    }

    private List<String> getFormattedTasks(List<Task> tasks) {
        List<String> res = new ArrayList<>();
        res.add("#To be done");
        res.addAll(getConditionalFormattedTasks(tasks, false));
        res.add("#Completed");
        res.addAll(getConditionalFormattedTasks(tasks, true));
        return res;
    }

    private List<String> getConditionalFormattedTasks(List<Task> tasks, boolean isCompleted) {
        List<String> res = tasks.stream().
                filter(task -> task.isCompleted() == isCompleted)
                .map(Task::format)
                .collect(Collectors.toList());
        if (res.isEmpty()) res.add("Empty");
        return res;
    }
}

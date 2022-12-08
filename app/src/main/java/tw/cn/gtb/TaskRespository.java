package tw.cn.gtb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskRespository {
    static final String TASK_FILE = System.getProperty("user.home") + File.separator + ".todo" + File.separator + "tasks";

    public List<Task> LoadTasks(List<String> lines) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String[] fields = lines.get(i).split(" ", 2);
            boolean completed = fields[0].equals("v");
            tasks.add(TaskFactory.createTask(i + 1, fields[1], completed));
        }
        return tasks;
    }

    public List<String> readFileLines() {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(TASK_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    List<String> getConditionalFormattedTasks(List<Task> tasks, boolean isCompleted) {
        List<String> res = tasks.stream().
                filter(task -> task.isCompleted() == isCompleted)
                .map(Task::format)
                .collect(Collectors.toList());
        if (res.isEmpty()) res.add("Empty");
        return res;
    }
}

package tw.cn.gtb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskRespository {
    private final TaskMarshaller taskMarshaller = new TaskMarshaller();

    public List<Task> loadTasks(List<String> lines) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(taskMarshaller.unmarshal(i, lines.get(i)));
        }
        return tasks;
    }

    public List<String> readFileLines() {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(Constant.TASK_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    private List<String> getConditionalFormattedTasks(List<Task> tasks, boolean isCompleted) {
        List<String> res = tasks.stream().
                filter(task -> task.isCompleted() == isCompleted && !task.isDeleted())
                .map(Task::format)
                .collect(Collectors.toList());
        if (res.isEmpty()) res.add("Empty");
        return res;
    }

    public List<String> getFormattedToBeDoneTasks(List<Task> tasks) {
        return getConditionalFormattedTasks(tasks, false);
    }

    public List<String> getFormattedCompletedTasks(List<Task> tasks) {
        return getConditionalFormattedTasks(tasks, true);
    }

    public void create(Task task) {
        try (var bw =
                     Files.newBufferedWriter(Path.of(Constant.TASK_FILE), new StandardOpenOption[]{StandardOpenOption.APPEND})){
            bw.write(taskMarshaller.marshal(task));
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

package tw.cn.gtb;

import java.util.ArrayList;
import java.util.List;

public class ListCommand {
    static final TaskRespository taskRespository = new TaskRespository();

    public List<String> run() {
        List<String> fileLines = taskRespository.readFileLines();
        List<Task> tasks = taskRespository.LoadTasks(fileLines);
        return getFormattedTasks(tasks);
    }

    private List<String> getFormattedTasks(List<Task> tasks) {
        List<String> res = new ArrayList<>();
        res.add("#To be done");
        res.addAll(taskRespository.getConditionalFormattedTasks(tasks, false));
        res.add("#Completed");
        res.addAll(taskRespository.getConditionalFormattedTasks(tasks, true));
        return res;
    }
}

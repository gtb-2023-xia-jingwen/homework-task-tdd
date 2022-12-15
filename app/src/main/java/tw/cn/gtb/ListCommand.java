package tw.cn.gtb;

import java.util.ArrayList;
import java.util.List;

public class ListCommand {
    static final TaskRespository taskRespository = new TaskRespository();

    public List<String> run() {
        List<Task> tasks = taskRespository.loadTasks();
        return getFormattedTasks(tasks);
    }

    private List<String> getFormattedTasks(List<Task> tasks) {
        List<String> res = new ArrayList<>();
        res.add("#To be done");
        res.addAll(taskRespository.getFormattedToBeDoneTasks(tasks));
        res.add("#Completed");
        res.addAll(taskRespository.getFormattedCompletedTasks(tasks));
        return res;
    }
}

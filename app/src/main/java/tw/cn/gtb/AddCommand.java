package tw.cn.gtb;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class AddCommand {
    private TaskRespository taskRespository = new TaskRespository();
    private final String[] args;

    public AddCommand(String... args) {
        this.args = args;
    }

    public AddCommand(TaskRespository taskRespository, String... args) {
        this.taskRespository = taskRespository;
        this.args = args;
    }

    public List<String> execute() {
        String taskName = Stream.of(args).skip(1).collect(Collectors.joining(" "));
        var task = TaskFactory.createTask(0, taskName, false);
        return taskRespository.create(task);
    }
}

package tw.cn.gtb;

import lombok.Getter;

import java.util.List;

@Getter
public class AddCommand {
    private final TaskRespository taskRespository;
    private final String[] args;

    public AddCommand(String... args) {
        this.taskRespository = new TaskRespository();
        this.args = args;
    }

    public AddCommand(TaskRespository taskRespository, String... args) {
        this.taskRespository = taskRespository;
        this.args = args;
    }

    public List<String> execute() {
        String taskName = String.join(" ", args);
        var task = TaskMarshaller.unmarshal(0, taskName, false, false);
        taskRespository.create(task);
        return List.of();
    }
}

package tw.cn.gtb;

import lombok.Getter;

import java.util.List;

@Getter
public class AddCommand extends Command{
    private final TaskMarshaller taskMarshaller = new TaskMarshaller();
    private final String[] args;

    public AddCommand(TaskRespository taskRespository, String... args) {
        super(taskRespository);
        this.args = args;
    }

    public List<String> execute() {
        String taskName = String.join(" ", args);
        var task = new Task(0, taskName, false, false);
        taskRespository.create(task);
        return List.of();
    }
}

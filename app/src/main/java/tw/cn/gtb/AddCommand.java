package tw.cn.gtb;

import lombok.Getter;

import java.util.List;

@Getter
public class AddCommand {
    static final TaskRespository taskRespository = new TaskRespository();

    private final String[] args;

    public AddCommand(String[] args) {
        this.args = args;
    }

    public List<String> execute() {
        var task = new Task(0, getArgs()[1], false);
        return taskRespository.create(task);
    }
}

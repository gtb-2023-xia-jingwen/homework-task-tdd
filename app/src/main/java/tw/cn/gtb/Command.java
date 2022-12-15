package tw.cn.gtb;

import java.util.List;

public abstract class Command {
    protected final TaskRespository taskRespository;

    public Command(TaskRespository taskRespository) {
        this.taskRespository = taskRespository;
    }

    public abstract List<String> execute();
}

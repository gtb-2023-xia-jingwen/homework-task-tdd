package tw.cn.gtb;

import java.util.List;

public class UnknownCommand extends Command {
    private final String cmdName;

    public UnknownCommand(TaskRespository taskRespository, String cmdName) {
        super(taskRespository);
        this.cmdName = cmdName;
    }

    @Override
    public List<String> execute() {
        return List.of("Unknown command: " + cmdName);
    }
}

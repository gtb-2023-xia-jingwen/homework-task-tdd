package tw.cn.gtb;

import java.util.List;
import java.util.stream.Stream;

public class RemoveCommand {

    private final TaskRespository taskRespository;
    private final String[] param;

    public RemoveCommand(TaskRespository taskRespository, String... params) {
        this.taskRespository = taskRespository;
        this.param = params;
    }
    
    public List<String> execute() {
        List<Integer> ids = parseIds();
        for (int id : ids) {
            taskRespository.removeTaskById(id);
        }
        return List.of();
    }

    private List<Integer> parseIds() {
        Stream.of(param)
                .map(Integer::parseInt)
                .forEach(taskRespository::removeTaskById);
        return List.of();
    }
}

package tw.cn.gtb;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveCommand extends Command{

    private final String[] param;

    public RemoveCommand(TaskRespository taskRespository, String... params) {
        super(taskRespository);
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
        List<Integer> ids = Stream.of(param)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        taskRespository
                .loadTasks()
                .stream().filter(task -> !task.isDeleted())
                .filter(task -> ids.contains(task.getId()))
                .forEach(task -> taskRespository.removeTaskById(task.getId()));
        return List.of();
    }
}

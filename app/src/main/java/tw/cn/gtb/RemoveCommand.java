package tw.cn.gtb;

import java.util.ArrayList;
import java.util.List;

public class RemoveCommand {

    private final TaskRespository taskRespository;
    private final String[] param;

    public RemoveCommand(TaskRespository taskRespository, String[] params) {
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
        List<Integer> ids = new ArrayList<>();
        for (String id : param) {
            ids.add(Integer.parseInt(id));
        }
        return ids;
    }
}

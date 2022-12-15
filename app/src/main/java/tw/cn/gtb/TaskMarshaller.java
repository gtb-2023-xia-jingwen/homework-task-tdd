package tw.cn.gtb;

public class TaskMarshaller {
    public Task unmarshal(int id, String name, boolean completed, boolean isDeleted) {
        return new Task(id, name, completed, isDeleted);
    }

    public String marshal(Task task) {
        String completedSign = task.isCompleted() ? "v " : "+ ";
        String deletedSign = task.isDeleted() ? "x ": "+ ";
        return completedSign + deletedSign + task.getName();
    }
}

package tw.cn.gtb;

public class TaskMarshaller {
    public Task unmarshal(int id, String line) {
        String[] fields = line.split(" ", 3);
        boolean isCompleted = fields[0].equals("v");
        boolean isDeleted = fields[1].equals("x");
        return new Task(id, fields[2], isCompleted, isDeleted);
    }

    public String marshal(Task task) {
        String completedSign = task.isCompleted() ? "v " : "+ ";
        String deletedSign = task.isDeleted() ? "x ": "+ ";
        return completedSign + deletedSign + task.getName();
    }
}

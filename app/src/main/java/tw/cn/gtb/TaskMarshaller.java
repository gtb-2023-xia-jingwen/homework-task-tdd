package tw.cn.gtb;

public class TaskMarshaller {
    public static Task unmarshal(int id, String name, boolean completed, boolean isDeleted) {
        return new Task(id, name, completed, isDeleted);
    }

    public static String marshal(Task task) {
        return "+ " + "+ " + task.getName();
    }
}

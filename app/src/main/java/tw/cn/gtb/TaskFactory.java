package tw.cn.gtb;

public class TaskFactory {
    public static Task createTask(int id, String name, boolean completed) {
        return new Task(id, name, completed);
    }
}

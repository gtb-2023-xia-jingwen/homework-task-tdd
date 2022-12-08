package tw.cn.gtb;

import lombok.Getter;

@Getter
public class Task {
    private final int id;
    private final String name;
    private final boolean completed;

    public Task(int id, String name, boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

    public String format() {
        return id + " " + name;
    }
}

package tw.cn.gtb;

import lombok.Getter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && completed == task.completed && Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, completed);
    }

    @Override
    public String toString() {
        return id + " " + completed + " " + name;
    }
}

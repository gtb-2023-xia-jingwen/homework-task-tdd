package tw.cn.gtb;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Task {
    private final int id;
    private final String name;
    private boolean completed;
    private boolean deleted;

    public Task(int id, String name, boolean isCompleted, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.completed = isCompleted;
        this.deleted = isDeleted;
    }

    public String format() {
        return id + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && completed == task.completed
                && deleted == task.deleted && Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, completed, deleted);
    }

    @Override
    public String toString() {
        return id + " " + completed + " " + name;
    }
}

package tw.cn.gtb;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Task {
    private final int id;
    private final String name;
    private boolean isCompleted;
    private boolean isDeleted;

    public Task(int id, String name, boolean completed, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.isCompleted = completed;
        this.isDeleted = isDeleted;
    }

    public String format() {
        return id + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && isCompleted == task.isCompleted
                && isDeleted == task.isDeleted && Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isCompleted, isDeleted);
    }

    @Override
    public String toString() {
        return id + " " + isCompleted + " " + name;
    }
}

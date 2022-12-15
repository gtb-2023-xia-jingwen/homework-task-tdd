package tw.cn.gtb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RemoveCommandTest {

    private TaskRespository taskRespository;

    @BeforeEach
    void setUp() {
        taskRespository = mock(TaskRespository.class);
    }

    @Test
    public void should_remove_multiple_task() {
        var cmd = new RemoveCommand(taskRespository, "1", "3");
        when(taskRespository.loadTasks()).thenReturn(
                List.of(
                        new Task(1, "Task 01", false, false),
                        new Task(2, "Task 02", false, false),
                        new Task(3, "Task 03", false, false)
                )
        );
        cmd.execute();
        verify(taskRespository).removeTaskById(1);
        verify(taskRespository).removeTaskById(3);
    }

    @Test
    public void should_only_remove_existing_tasks() {
        var cmd = new RemoveCommand(taskRespository, "1", "3", "404");
        when(taskRespository.loadTasks()).thenReturn(
                List.of(
                        new Task(1, "Task 01", false, false),
                        new Task(2, "Task 02", false, false),
                        new Task(3, "Task 03", false, false)
                )
        );
        cmd.execute();
        verify(taskRespository).removeTaskById(1);
        verify(taskRespository).removeTaskById(3);
        verify(taskRespository, never()).removeTaskById(404);
    }
}

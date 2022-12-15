package tw.cn.gtb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RemoveCommandTest {

    private TaskRespository taskRespository;

    @BeforeEach
    void setUp() {
        taskRespository = mock(TaskRespository.class);
    }

    @Test
    public void should_remove_multiple_task() {
        var cmd = new RemoveCommand(taskRespository, "1", "3");
        cmd.execute();
        verify(taskRespository).removeTaskById(1);
        verify(taskRespository).removeTaskById(3);
    }
}

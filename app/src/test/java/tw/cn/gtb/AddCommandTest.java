package tw.cn.gtb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddCommandTest {

    private TaskRespository taskRespository;

    @BeforeEach
    void setUp() {
        taskRespository = mock(TaskRespository.class);
    }

    @Test
    public void should_add_test_with_single_word() {
        var cmd = new AddCommand(taskRespository,  "rush");
        cmd.execute();
        verify(taskRespository).create(new Task(0, "rush", false, false));
    }

    @Test
    public void should_add_test_with_multiple_words() {
        var cmd = new AddCommand(taskRespository, "YES", "And You And I");
        cmd.execute();
        verify(taskRespository).create(new Task(0, "YES And You And I", false, false));
    }
}

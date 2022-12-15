package tw.cn.gtb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TaskMarshallerTest {

    private TaskMarshaller taskMarshaller;

    @BeforeEach
    public void init() {
        taskMarshaller = new TaskMarshaller();
    }

    @ParameterizedTest
    @MethodSource("lines_and_tasks")
    public void should_marshal_to_plain_text(String line, Task task) {
        Assertions.assertEquals(line, taskMarshaller.marshal(task));
    }

    public static Stream<Arguments> lines_and_tasks() {
        return Stream.of(
                Arguments.of("+ + rush", new Task(0, "rush", false, false)),
                Arguments.of("+ x rush", new Task(0, "rush", false, true)),
                Arguments.of("v + rush", new Task(0, "rush", true, false)),
                Arguments.of("v x rush", new Task(0, "rush", true, true)),
                Arguments.of("+ + yes and you and I", new Task(0, "yes and you and I", false, false))
        );
    }

    @ParameterizedTest
    @MethodSource("task_and_line")
    public void should_unmarshal_from_text(Task task, String line) {
        Assertions.assertEquals(task, taskMarshaller.unmarshal(0, line));
    }

    public static Stream<Arguments> task_and_line() {
        return Stream.of(
                Arguments.of(new Task(0, "rush", false, false)
                        , "+ + rush"),
                Arguments.of(new Task(0, "rush ", true, false)
                        , "v + rush "),
                Arguments.of(new Task(0, "rush ", true, true)
                        , "v x rush ")
        );
    }

}

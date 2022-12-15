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
        taskMarshaller =  new TaskMarshaller();
    }

    @ParameterizedTest
    @MethodSource("lines_and_tasks")
    public void should_marshal_to_plain_text(String line, Task task) {
        Assertions.assertEquals(line, taskMarshaller.marshal(task));
    }

    public static Stream<Arguments> lines_and_tasks() {
        return Stream.of(
                Arguments.of("+ + rush", new Task(0, "rush", false, false)),
                Arguments.of("+ + yes and you and I", new Task(0, "yes and you and I", false, false))
        );
    }

}

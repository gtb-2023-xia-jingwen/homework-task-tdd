package tw.cn.gtb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class AppTest {

    @BeforeEach
    void initData() {
        List<String> lines = List.of("v go to walk", "v count stars");
        writeDataToFile(lines);
    }

    private static void writeDataToFile(List<String> lines) {
        try (var bw = Files.newBufferedWriter(Path.of(Constant.TASK_FILE))
        ) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Nested
    class ListCommand {
        @Nested
        class ListTasksWhenExists {
            @Test
            void should_show_tasks_when_task_exists() {
                App app = new App();
                List<String> res = app.run();
                Assertions.assertEquals(List.of("#To be done", "Empty", "#Completed", "1 go to walk", "2 count stars"), res);
            }
        }
    }

    @Nested
    class AddCommand {
        @Nested
        class AddTaskGivenSingleName {
            @Test
            void should_add_task_with_single_word() {
                new App().run("add", "rush");
                List<String> res = new App().run();
                Assertions.assertEquals(List.of("#To be done", "3 rush", "#Completed", "1 go to walk", "2 count stars"), res);
            }
        }
    }
}

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

    private App app;

    @BeforeEach
    void initData() {
        List<String> lines = List.of("v + go to walk", "v + count stars");
        writeDataToFile(lines);
        app = new App();
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
                // Given
                // When
                List<String> res = app.run();
                // Then
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
                // Given
                // When
                app.run("add", "rush");
                // Then
                List<String> res = app.run();
                Assertions.assertEquals(List.of("#To be done", "3 rush", "#Completed", "1 go to walk", "2 count stars"), res);
            }
        }

        @Nested
        class AddTaskGivenMultipleName {
            @Test
            void should_add_task_with_multiple_words() {
                // Given
                // When
                app.run("add", "YES", "And You And I");
                // Then
                List<String> res = app.run();
                Assertions.assertEquals(List.of("#To be done", "3 YES And You And I", "#Completed", "1 go to walk", "2 count stars"), res);
            }
        }
    }

    @Nested
    class RemoveCommand {
        @Nested
        class RemoveTaskGivenSingleId {
            @Test
            void should_remove_task_with_single_id() {
                // When
                app.run("remove", "1");
                // Then
                List<String> res = app.run();
                Assertions.assertEquals(List.of("#To be done", "Empty", "#Completed", "2 count stars"), res);
            }

            @Test
            void should_remove_task_with_multiple_ids() {
                // When
                app.run("remove", "1", "2");
                // Then
                List<String> res = app.run();
                Assertions.assertEquals(List.of("#To be done", "Empty", "#Completed", "Empty"), res);
            }
        }
    }
}

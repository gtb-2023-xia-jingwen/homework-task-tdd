/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tw.cn.gtb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class AppTest {
    @Test
    void should_show_all_tasks() {
        App app = new App();
        List<String> res = app.run();
        Assertions.assertEquals(List.of("go to walk", "count stars"), res);
    }
}

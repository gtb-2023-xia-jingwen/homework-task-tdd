package tw.cn.gtb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class AppTest {
    @Test
    void should_show_all_tasks() {
        App app = new App();
        List<String> res = app.run();
        Assertions.assertEquals(List.of("#To be done", "Empty" , "#Completed", "1 go to walk", "2 count stars"), res);
    }
    @Test
    void should_add_task_with_single_word_as_name() {
        new App().run("add", "rush");
        List<String> res = new App().run();
        Assertions.assertEquals(List.of("#To be done", "3 rush" , "#Completed", "1 go to walk", "2 count stars"), res);
    }
}

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
}

package tw.cn.gtb;

import java.io.File;

public class Constant {
    public static final String USER_HOME = System.getProperty("user.home");
    public static final String TODO_ROOT = ".todo";
    static final String TASK_FILE = USER_HOME + File.separator + TODO_ROOT + File.separator + "tasks";
}

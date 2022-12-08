package tw.cn.gtb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run(String... args) {
        if ((args.length > 0) && args[0].equals("add")) {
            final String taskName = args[1];
            return execute(taskName);
        }
        return listCommand.run();
    }

    private static List<String> execute(String... taskName) {
        try (var bw =
                     Files.newBufferedWriter(Path.of(Constant.TASK_FILE), new StandardOpenOption[]{StandardOpenOption.APPEND});){
            bw.write("+ " + taskName[0]);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return List.of();
    }

}

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
            try {
                var bw =
                        Files.newBufferedWriter(Path.of(Constant.TASK_FILE), new StandardOpenOption[]{StandardOpenOption.APPEND});

                final String taskName = args[1];
                bw.write("+ " + taskName);
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        return listCommand.run();
    }

}

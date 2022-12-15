package tw.cn.gtb;

import java.util.Arrays;
import java.util.List;

public class App {

    private final ListCommand listCommand = new ListCommand();
    private final TaskRespository taskRespository = new TaskRespository();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run(String... args) {
        if (args.length <= 1) {
            return listCommand.run();
        }
        String cmd = args[0];
        String[] params = Arrays.copyOfRange(args, 1, args.length);
        if (cmd.equals("add")) {
            return new AddCommand(taskRespository, params).execute();
        }
        if (cmd.equals("remove")) {
            return new RemoveCommand(taskRespository, params).execute();
        }
        return List.of();
    }

}

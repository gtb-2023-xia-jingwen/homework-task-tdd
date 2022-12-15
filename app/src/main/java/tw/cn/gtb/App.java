package tw.cn.gtb;

import java.util.Arrays;
import java.util.List;

public class App {

    private final TaskRespository taskRespository = new TaskRespository();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run(String... args){
        if (args.length == 0) {
            throw  new UnsupportedOperationException();
        }
        String cmdName = args[0];
        String[] params = Arrays.copyOfRange(args, 1, args.length);
        Command cmd = CommandFactory.getCommand(cmdName, params, taskRespository);
        return cmd.execute();
    }
}

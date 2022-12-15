package tw.cn.gtb;

import java.util.Arrays;

public class CommandFactory {
    static Command getCommand(TaskRespository taskRespository, String... args) {
        String cmdName = args[0];
        String[] params = Arrays.copyOfRange(args, 1, args.length);
        Command cmd = new UnknownCommand(taskRespository, cmdName);
        if (cmdName.equals("add")) {
            cmd = new AddCommand(taskRespository, params);
        }
        if (cmdName.equals("remove")) {
            cmd = new RemoveCommand(taskRespository, params);
        }
        if (cmdName.equals("list")) {
            cmd = new ListCommand(taskRespository);
        }
        return cmd;
    }
}

package tw.cn.gtb;

public class CommandFactory {
    static Command getCommand(String cmdName, String[] params, TaskRespository taskRespository) {
        Command cmd = new ListCommand(taskRespository);
        if (cmdName.equals("add")) {
            cmd = new AddCommand(taskRespository, params);
        }
        if (cmdName.equals("remove")) {
            cmd = new RemoveCommand(taskRespository, params);
        }
        return cmd;
    }
}

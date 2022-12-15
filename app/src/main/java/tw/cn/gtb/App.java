package tw.cn.gtb;

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
        Command cmd = CommandFactory.getCommand(taskRespository, args);
        return cmd.execute();
    }
}

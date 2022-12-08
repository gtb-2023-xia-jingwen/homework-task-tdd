package tw.cn.gtb;

import java.util.List;

public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run(String... args) {
        if ((args.length > 0) && args[0].equals("add")) {
            return new AddCommand(args).execute();
        }
        return listCommand.run();
    }

}

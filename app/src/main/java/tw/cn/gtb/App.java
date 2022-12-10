package tw.cn.gtb;

import java.util.Arrays;
import java.util.List;

public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run(String... args) {
        if ((args.length > 0) && args[0].equals("add")) {
            String[] names = Arrays.copyOfRange(args, 1, args.length);
            return new AddCommand(names).execute();
        }
        return listCommand.run();
    }

}

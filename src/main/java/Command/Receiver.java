package Command;

import java.util.ArrayList;
import java.util.List;

public class Receiver {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);

    }

    public void runCommand() {
        commands.forEach(command -> command.execute());
    }

}

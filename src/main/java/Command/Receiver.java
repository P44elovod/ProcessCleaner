package Command;

import java.util.ArrayList;
import java.util.List;

public class Receiver {
    List<Command> commands = new ArrayList<>();

 public void addCommand(Command command) {
        commands.add(command);

    }

  public   void runCommand() {
        commands.stream()
                .forEach(command -> command.execute());
    }

}


import Command.Command;
import Command.ProcessDestroyCommand;
import Command.ProcessPanelCommand;

import java.util.List;

public class Main  {

    public static void main(String[] args) {
        List.of(new ProcessPanelCommand(), new ProcessDestroyCommand()).forEach(Command::execute);
    }


}

import command.Command;
import command.ProcessDestroyCommand;
import command.ProcessPanelCommand;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List.of(new ProcessPanelCommand(), new ProcessDestroyCommand()).forEach(Command::execute);
    }


}

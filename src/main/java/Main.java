import Command.ProcessDestroyCommand;
import Command.ProcessPanelCommand;
import Command.Receiver;

public class Main {

    public static void main(String[] args){
        Receiver receiver = new Receiver();
        receiver.addCommand(new ProcessPanelCommand());
        receiver.addCommand(new ProcessDestroyCommand());
        receiver.runCommand();
    }

}

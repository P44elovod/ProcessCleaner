package Command;

import java.util.List;

public class ProcessDestroyCommand implements Command {

    public static void processDestroy(List<String> pidList) {

        pidList.stream().map(i -> Long.parseLong(i))
                .map(i -> ProcessHandle.of(i)
                        .map(ph -> ph.destroy()));


    }

    @Override
    public void execute() {
        processDestroy(OperatingConsoleCommand.consoleRead());
    }


}

package command;

import java.util.Comparator;


public class ProcessPanelCommand implements Command {


    private Long cpuDuration(ProcessHandle ph) {
        return ph
                .info()
                .totalCpuDuration()
                .get()
                .toMillis();
    }

    private String dumpCommand(ProcessHandle ph) {
        return ph.info()
                .command()
                .orElse("");
    }

    public void execute() {
        ProcessHandle.allProcesses()
                .filter(ph -> ph.info().command().isPresent())
                .sorted(Comparator.comparing(this::cpuDuration)
                        .reversed()
                )
                .limit(10)
                .forEach(ph -> System.out.printf("%d %s [%sms]%n", ph.pid(), dumpCommand(ph), cpuDuration(ph))
                );
    }


}
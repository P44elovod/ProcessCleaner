package Command;

import java.util.Comparator;


public class ProcessPanelCommand {


    public static void main(String[] args) {
        ProcessHandle.allProcesses()
                .filter(ph -> ph.info().command().isPresent())
                .limit(10)
                .sorted(Comparator.comparing(ProcessPanelCommand::cpuDuration)
                        .reversed()
                )
                .forEach(ph -> System.out.printf("%d %s [%sms]%n", ph.pid(), dumpCommand(ph), cpuDuration(ph))
                );
    }

 private static Long cpuDuration(ProcessHandle ph) {
        return ph
                .info()
                .totalCpuDuration()
                .get()
                .toMillis();
    }

    private static String dumpCommand(ProcessHandle ph){
        return ph.info()
                .command()
                .orElse("");
    }








}
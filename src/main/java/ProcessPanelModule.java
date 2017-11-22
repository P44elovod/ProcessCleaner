import java.util.Comparator;


public class ProcessPanelModule {


    public static void main(String[] args) {
        ProcessHandle.allProcesses()
                .filter(ph -> ph.info().command().isPresent())
                .limit(10)
                .sorted(Comparator.comparing(ProcessPanelModule::cpuDuration)
                        .reversed()
                )
                .forEach(ph -> {
                            System.out.printf("%d ", ph.pid());
                            System.out.printf("%s ", dumpCommand(ph));
                            System.out.printf("[%sms]", cpuDuration(ph));
                            System.out.println();
                        }
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
import java.time.Duration;
import java.util.Comparator;


public class ProcessReader {


    public static void main(String[] args) {
        ProcessHandle.allProcesses()
                .filter(ph -> ph.info().command().isPresent())
                .limit(10)
                .sorted(Comparator.comparing(ProcessReader::cpuDuration)
                        .reversed()
                )
                .forEach(ph -> {
                            System.out.printf("%d ", ph.pid());
                            System.out.printf("%s ", ph.info().command().orElse(""));
                            System.out.printf("[%sms]",
                                    ph.info().totalCpuDuration()
                                            .get().toMillis());
                            System.out.println();
                        }
                );
    }

    static Long cpuDuration(ProcessHandle ph) {
        return ph
                .info()
                .totalCpuDuration()
                .get()
                .toMillis();
    }


}

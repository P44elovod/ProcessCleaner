import java.time.Duration;
import java.util.Comparator;


public class ProcessReader {


    public static void main(String[] args) {
        ProcessHandle.allProcesses()
                .filter(ph -> ph.info().command().isPresent())
                .limit(10)
                .sorted(Comparator.comparing(ph -> ph
                        .info()
                        .totalCpuDuration()
                        .get()
                        .toMillis())



                )
                .forEach(ph -> {
                            System.out.printf("%d ", ph.pid());
                            System.out.printf("%s ", ph.info().command().orElse(""));

                            System.out.printf("[%sms]",
                                    ph.info().totalCpuDuration()
                                            .orElse(Duration.ofMillis(0)).toMillis());
                            System.out.println();
                        }
                );
    }



}

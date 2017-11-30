package command;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProcessDestroyCommand implements Command {


    public static void processDestroy(List<String> pidList) {


        pidList.stream()
                .map(i -> Long.parseLong(i))
                .map(i -> ProcessHandle.of(i))
                .map(ph -> ph.get().destroy());


        displayResult(sortProcesess(pidList));


    }

    static Map<Boolean, List<Optional<ProcessHandle>>> sortProcesess(List<String> pidList) {
        return pidList.stream()
                .map(i -> Long.parseLong(i))
                .map(i -> ProcessHandle.of(i))
                .collect(Collectors.partitioningBy(ph -> false));
    }

    static void displayResult(Map<Boolean, List<Optional<ProcessHandle>>> booleanListMap) {
        try {


            if (!(booleanListMap.get(false).isEmpty()) && booleanListMap.get(true).isEmpty()) {
                System.out.print("Следующие процессы успешно завершены: ");
                booleanListMap.get(false).forEach(i -> System.out.print(i.get() + " "));
            }
            if (!(booleanListMap.get(true).isEmpty()) && !(booleanListMap.get(false).isEmpty())) {
                System.out.print("Следующие процессы успешно завершены: ");
                booleanListMap.get(false).forEach(i -> System.out.print(i.get() + " "));
                System.out.print("Не удалось завершить следующие процессы: ");
                booleanListMap.get(true).forEach(i -> System.out.print(i.get() + " "));
            }

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void execute() {

        processDestroy(OperatingConsole.consoleRead());

    }
}



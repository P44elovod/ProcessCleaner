package Command;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class OperatingConsoleCommand {


    public static List consoleRead() {

        Scanner scanner = new Scanner(System.in);

        return pidToDestroy(scanner.nextLine());


    }


    private static List<String> pidToDestroy(String listFromConsole) {

        return Arrays.stream(listFromConsole.split(",")).collect(Collectors.toList());


    }


}

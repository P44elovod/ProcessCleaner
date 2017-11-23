package Command;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Getter
public class OperatingConsoleCommand {




    public static List consoleRead() {

        Scanner scanner = new Scanner(System.in);

        return pidToDestroy(scanner.nextLine());


    }


    private static List pidToDestroy(String listFromConsole) {

        return Arrays.stream(listFromConsole.split(",")).collect(Collectors.toList());


    }


}
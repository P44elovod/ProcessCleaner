package Command;

import java.util.List;

public class ProcessDestroyCommand {


    public static void processDestroy(List<String> pidList) {

        pidList.stream().map(i -> ProcessHandle.of(Long.parseLong(i))
                .map(ph -> ph.destroy()));


    }


}
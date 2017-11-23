import java.util.List;

public class ProcessDestroyModule {


    public static void processDestroy(List<String> pidList) {

        pidList.stream().map(i -> ProcessHandle.of(Long.parseLong(i))
                .map(ph -> ph.destroy()));


    }


}

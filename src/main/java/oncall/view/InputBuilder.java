package oncall.view;

import java.util.Arrays;
import java.util.List;

public class InputBuilder {

    public static List<String> buildWorkerList(String input) {
        String[] inputs = input.split("\\s*,\\s*");
        return Arrays.asList(inputs);
    }
}

import java.util.Arrays;
import java.util.Objects;

public class InputParser {
    public String statement;
    private final String input;

    public InputParser(String input, String command){
        this.input = input;
        parseInput(command);
    }

    private String[] removeFromArr(String[] arr, int index) {
        String[] newArr = new String[arr.length];

        int newArrI = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i != index) {
                newArr[newArrI] = arr[i];
                newArrI++;
            }
        }

        return Arrays.stream(newArr).filter(Objects::nonNull).toArray(String[]::new);
    }

    private void parseInput(String command) {
        String[] inputArr = input.split(" ");
        if(inputArr[0].equals(command)) {
            String[] inputWithoutCommand = removeFromArr(inputArr, 0);
            this.statement = String.join(" ", inputWithoutCommand);
        }
    }

    public String getStatement() {
        return statement;
    }
}

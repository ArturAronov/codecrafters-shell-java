import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        while(true) {
            System.out.print("$ ");
            Input input = new Input();
            String userInput = input.getInput();

            switch(userInput) {
                case "exit 0" -> System.exit(0);
                case String s when s.startsWith("echo") -> {
                    InputParser inputParser = new InputParser(s, "echo");
                    String statement = inputParser.getStatement();
                    if(statement == null) {
                        System.out.println(input.getInput() + ": command not found");
                    } else {
                        System.out.println(inputParser.getStatement());
                    }
                }
                default -> System.out.println(input.getInput() + ": command not found");
            }
        }
    }
}

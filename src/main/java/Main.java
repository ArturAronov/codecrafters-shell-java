import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] commands = {"echo", "exit", "type"};

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            if (input.equals("exit 0")) {
                System.exit(0);
            }

            String[] inputArr = input.split(" ", 2);
            String command = inputArr[0];;
            switch (command) {
                case "exit 0" -> {
                    System.exit(0);
                }
                case "echo" -> {
                    System.out.println(inputArr[1]);
                }
                case "type" -> {
                    PathWalker pathWalker = new PathWalker();
                    String availablePath = pathWalker.getAvailablePath(inputArr[1]);

                    if(Arrays.stream(commands).anyMatch(inputArr[1]::equals)) {
                        System.out.println(inputArr[1] + " is a shell builtin");
                    } else if(availablePath != null) {
                        System.out.println(inputArr[1] + " is " + availablePath);
                    } else {
                        System.out.println(inputArr[1] + ": not found");
                    }
                }
                default -> {
                    PathWalker pathWalker = new PathWalker();
                    String path = pathWalker.getAvailablePath(command);
                    if(path == null) {
                        System.out.println(command + ": command not found");
                    } else {
                        String fullPath = path + input.substring(command.length());
                        Process p = Runtime.getRuntime().exec(fullPath.split(" "));
                        p.getInputStream().transferTo(System.out);
                    }
                }
            }
        }
    }
}

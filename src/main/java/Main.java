import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            if (input.equals("exit 0")) {
                System.exit(0);
            }

            String[] commands = input.split(" ", 2);
            switch (commands[0]) {
                case "exit 0" -> {
                    System.exit(0);
                }
                case "echo" -> {
                    System.out.println(commands[1]);
                }
                default -> {
                    System.out.println(commands[0] + ": command not found");
                }
            }
        }
    }
}

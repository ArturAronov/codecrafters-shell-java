import java.util.Scanner;

public class Input {
    public String input;

    public Input() {
        Scanner scanner = new Scanner(System.in);
        this.input = scanner.nextLine();
    }

    public String getInput() {
        return input;
    }
}

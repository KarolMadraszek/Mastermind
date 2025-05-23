package junit4;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader{
    private Scanner scanner =new Scanner(System.in);

    public String readLine() {
        return scanner.nextLine();
    }
}

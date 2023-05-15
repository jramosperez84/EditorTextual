import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        Tasks tasks = new Tasks();

        int option = 0;

        Menu.printMenu();
        option = scanner.nextInt();
        try {
            controller.menuController(option);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        scanner.close();

    }
}

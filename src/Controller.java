import java.io.File;
import java.util.Scanner;

public class Controller {

    private final int MAKE_FILE = 1;
    private final int EDIT_FILE = 2;
    private final int DELETE_FILE = 3;
    private final int MAKE_FOLDER = 4;
    private final int DELETE_FOLDER = 5;
    private final int EXIT_PROGRAM = 0;

    private Tasks tasks;
    private Scanner scanner;
    private String url, text;

    public Controller() {

        scanner = new Scanner(System.in);
        tasks = new Tasks();

    }

    public void menuController(int option) throws Exception {

        switch (option) {
            case MAKE_FILE -> {
                Menu.makeFileMenu();
                Menu.fileUrl();
                url = scanner.nextLine();
                url = "./".concat(url);
                Menu.fileText();
                text = scanner.nextLine();
                tasks.writeFile(url, text);
                returnMain();
            }
            case EDIT_FILE -> {
                boolean type = false;
                String typeText;
                Menu.editFileMenu();
                Menu.fileUrl();
                url = scanner.nextLine();
                url = "./".concat(url);
                Menu.fileText();
                text = scanner.nextLine();
                Menu.overrideText();
                typeText = scanner.next();
                type = overrideMethod(typeText);
                tasks.editFile(url, text, type);
                returnMain();
            }
            case DELETE_FILE -> {
                Menu.deleteFileMenu();
                Menu.fileUrl();
                url = scanner.nextLine();
                url = "./".concat(url);
                if (tasks.deleteFile(url)) {
                    Menu.successfulOperation();
                    returnMain();
                } else {
                    Menu.failedOperation();
                    returnMain();
                }
            }
            case MAKE_FOLDER -> {
                Menu.makeDirectoryMenu();
                Menu.fileUrl();
                url = scanner.nextLine();
                url = "./".concat(url);
                if (tasks.makeDirectory(url)) {
                    Menu.successfulOperation();
                    returnMain();
                } else {
                    Menu.failedOperation();
                    returnMain();
                }
            }
            case DELETE_FOLDER -> {
                Menu.deleteDirectoryMenu();
                Menu.fileUrl();
                url = scanner.nextLine();
                url = "./".concat(url);
                File directory = new File(url);
                if (tasks.deleteDirectory(directory)) {
                    Menu.successfulOperation();
                    returnMain();
                } else {
                    Menu.failedOperation();
                    returnMain();
                }
            }
            case EXIT_PROGRAM -> System.exit(0);
            default -> Menu.wrongOption();
        }
    }

    private boolean overrideMethod(String typeText) {

        if(typeText.equalsIgnoreCase("A"))
            return true;
        else return !typeText.equalsIgnoreCase("S");

    }

    private void returnMain() throws Exception {

        App.main(new String[]{});

    }

}

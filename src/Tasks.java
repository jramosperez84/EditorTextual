import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Tasks {

    private File file;
    private FileWriter fileWriter;
    private PrintWriter printWriter;

    public void writeFile(String url, String text ) {

        try {
            fileWriter = new FileWriter(url, false);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(text);

            closeFiles();

        } catch (IOException e) {
            System.err.println("Error de E/S: ".concat(e.getMessage()));
        }

    }

    public void editFile(String url, String text, boolean type) {

        try {
            fileWriter = new FileWriter(url, type);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(text);

            closeFiles();

        } catch (IOException e) {
            System.err.println("Error de E/S: ".concat(e.getMessage()));
        }

    }

    public boolean deleteFile(String url) {

        initializeFile(url);
        return file.delete();

    }

    public boolean makeDirectory(String url) {

        initializeFile(url);
        if(!file.exists()) {
            Menu.successfulOperation();
            return file.mkdirs();
        } else {
            Menu.routeExists();
            return false;
        }
    }

    public boolean deleteDirectory(File file) {

        if(file.isDirectory()) {
            File[] content = file.listFiles();
            if (content != null) {
                for (File i : content) {
                    deleteDirectory(i);
                }
            }
        }

        return file.delete();
    }

    private void closeFiles() throws IOException {

        printWriter.close();
        fileWriter.close();

    }

    private void initializeFile(String url) {

        file = new File(url);

    }

}

public class Menu {

    public static void printMenu() {

        System.out.println("*********************************");
        System.out.println("EDITOR DE TEXTO");
        System.out.println("*********************************");

        System.out.println("Seleccione una opción");
        System.out.println("1) Crear un fichero");
        System.out.println("2) Editar un fichero");
        System.out.println("3) Borrar un fichero");
        System.out.println("4) Crear una carpeta");
        System.out.println("5) Borrar una carpeta");
        System.out.println("0) Salir");

        System.out.print("Opción: ");

    }

    public static void makeFileMenu() {

        System.out.println("--------------------------------------------");
        System.out.println("Creación de un nuevo fichero");
        System.out.println("--------------------------------------------");
        System.out.println("Sintaxis para la creación: texto.txt");
        System.out.println("Si conoce el directorio introdúzcalo: directorio/texto.txt");

    }

    public static void editFileMenu() {

        System.out.println("--------------------------------------------");
        System.out.println("Edición de fichero");
        System.out.println("--------------------------------------------");
        System.out.println("Sintaxis para la edición: texto.txt");
        System.out.println("Si conoce el directorio introdúzcalo: directorio/texto.txt");

    }

    public static void deleteFileMenu() {

        System.out.println("--------------------------------------------");
        System.out.println("Eliminar fichero");
        System.out.println("--------------------------------------------");
        System.out.println("Sintaxis para eliminar: texto.txt");
        System.out.println("Si conoce el directorio introdúzcalo: directorio/texto.txt");

    }

    public static void makeDirectoryMenu() {

        System.out.println("--------------------------------------------");
        System.out.println("Creación de una nuevo carpeta");
        System.out.println("--------------------------------------------");
        System.out.println("Sintaxis para la creación: directorio");

    }

    public static void deleteDirectoryMenu() {

        System.out.println("--------------------------------------------");
        System.out.println("Eliminar carpeta");
        System.out.println("--------------------------------------------");
        System.out.println("Sintaxis para la creación: directorio");

    }


    public static void overrideText() {

        System.out.println("¿Deseas sobreescribir(S) el archivo o añadir lineas(A)?");
        System.out.println("- S para sobreescribir ...");
        System.out.println("- A para añadir ...");

    }

    public static void fileUrl() {

        System.out.print("Introduce la url: ");

    }

    public static void fileText() {

        System.out.print("Introduce el texto: ");

    }

    public static void wrongOption() {

        System.out.println("--------------------------------------------");
        System.out.println("Opción errónea");
        System.out.println("--------------------------------------------");

    }

    public static void successfulOperation() {

        System.out.println("--------------------------------------------");
        System.out.println("Operación realizada con éxito.");
        System.out.println("--------------------------------------------");

    }

    public static void failedOperation() {

        System.out.println("--------------------------------------------");
        System.out.println("La operación ha fallado.");
        System.out.println("--------------------------------------------");

    }

    public static void routeExists() {

        System.out.println("***************************************************");
        System.out.println("** ATENCIÓN, la ruta especificada ya existe. ***");
        System.out.println("***************************************************");

    }
}

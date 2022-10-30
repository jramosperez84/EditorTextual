import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Start {

	public static void escribirFichero (String url, String texto, boolean tipo) {
			
		FileWriter fw = null;
		PrintWriter pw = null;
			
		try {
				
			fw = new FileWriter(url, tipo);
			pw = new PrintWriter(fw);
			pw.println(texto);
				
			fw.close();
				
		} catch (IOException e) {
				
			e.printStackTrace();
				
		}
			
	}
	
//	public static void editarFichero (String url, String texto) {
//		
//		FileWriter fw = null;
//		PrintWriter pw = null;
//			
//		try {
//				
//			fw = new FileWriter(url);
//			pw = new PrintWriter(fw);
//			pw.println(texto);
//				
//			fw.close();
//				
//		} catch (IOException e) {
//				
//			e.printStackTrace();
//				
//		}
//			
//	}
	
	public static void borrarFichero (String url) {
		
		File f = null;
		
		f = new File(url);
		f.delete();
		
		System.out.println("Archivo borrado");

	}
	
	public static void crearDirectorio (String url) {
		
		File f = new File(url);
        if (!f.exists()) {
            if (f.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
	}
	
	public static void borrarDirectorio (String url) {
		
		File f = null;
		
		f = new File(url);
		f.delete();
		
		System.out.println("Directorio borrado");

	}
	
	public static void imprimirMenu() 
	{
		System.out.println("");
		System.out.println("*********************************"); 
		System.out.println("EDITOR DE TEXTO");  
		System.out.println("*********************************");
		System.out.println("");
		System.out.println("Seleccione una opción:");
		System.out.println("1) Crear un fichero");
		System.out.println("2) Editar un fichero");
		System.out.println("3) Borrar un fichero");
		System.out.println("4) Crear una carpeta");
		System.out.println("5) Borrar una carpeta");
		System.out.println("0) Salir");
		System.out.println("");
		System.out.print("Opción: ");
	}

	public static void main(String[] args) {
		
		Scanner entradaDatos = new Scanner (System.in);
		boolean salir = false;
		int opcion = 0;
		
		do {
			
			imprimirMenu();
			
			opcion = entradaDatos.nextInt();
			
			if (opcion>5 || opcion<0) {
				System.out.print("\n");
				System.out.println("--------------------------------------------");
				System.out.println("Opción errónea");
				System.out.println("--------------------------------------------");
				System.out.print("\n");
			} else {
				switch (opcion) {
				case 1:
					
					String urlCrear = "";
					String textoCrear = "";
					boolean tipoA = false;
					
					System.out.println("--------------------------------------------");
					System.out.println("Creación de un nuevo fichero");
					System.out.println("--------------------------------------------");
					System.out.println("");
					System.out.println("Sintaxis para la creación: ./texto.txt");
					System.out.println("Si conoce el directorio introduzcalo: ./directorio/texto.txt");
					System.out.println("");
					System.out.print("Introduzca el nombre del fichero a crear: ");
					
					urlCrear = entradaDatos.next();
					
					System.out.print("Introduzca su texto: ");
					entradaDatos.nextLine();
					textoCrear = entradaDatos.nextLine();
					
					escribirFichero (urlCrear, textoCrear, tipoA);
					System.out.println("");
					System.out.println("Fichero creado con exito.");
					
				break;
				case 2:
					String urlEditar = "";
					String textoEditar = "";
					boolean tipoB = true;
					
					System.out.println("--------------------------------------------");
					System.out.println("Edición de fichero");
					System.out.println("--------------------------------------------");
					System.out.println("");
					System.out.println("Sintaxis para la edición: ./texto.txt");
					System.out.println("Si conoce el directorio introduzcalo: ./directorio/texto.txt");
					System.out.println("");
					System.out.print("Introduzca el nombre del fichero a editar: ");
					
					urlEditar = entradaDatos.next();
					
					System.out.print("Introduzca su texto: ");
					entradaDatos.nextLine();
					textoEditar = entradaDatos.nextLine();
	
					escribirFichero (urlEditar, textoEditar, tipoB );
					System.out.println("");
					System.out.println("Fichero editado con exito.");
				break;
				case 3:
					//borrarFichero (String url)
				break;
				case 4:
					//crearDirectorio (String url)
				break;
				case 5:
					//borrarDirectorio (String url)
				break;				
				case 0:	
					System.out.print("\n");
					System.out.println("--------------------------------------------");
					System.out.println("El programa ha finalizado");
					System.out.println("--------------------------------------------");
					salir = true;
				}
			}
		}
		
		while (!salir);
		
	}
}
		
		
		

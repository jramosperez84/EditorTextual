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
	
	public static void borrar (String url) {
		
		File f = null;
		
		f = new File(url);
		f.delete();

	}
	
	public static void crearDirectorio (String url) {
		
		File f = null;
		
		f = new File(url);
        if (!f.exists()) {
            if (f.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
	}
	
	public static void borrarDirectorio (File url) {
		
		if (url.isDirectory())
        {
            File[] contents = url.listFiles();
            for (int j = 0; j < contents.length; j++) {
				File i = contents[j];
				borrarDirectorio(i);
			}
        }
        url.delete();
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
					String seleccion = "";
					String a = "a";
					String b = "b";
					String urlCrear = "";
					String textoCrear = "";
					File f1 = null;
					boolean tipoA = false;
					
					f1 = new File (urlCrear);
					
					//boolean existe = f1.exists();
					
					System.out.println("--------------------------------------------");
					System.out.println("Creación de un nuevo fichero");
					System.out.println("--------------------------------------------");
					System.out.println("");
					System.out.println("Sintaxis para la creación/edición: ./texto.txt");
					System.out.println("Si conoce el directorio introduzcalo: ./directorio/texto.txt");
					System.out.println("");
					
					System.out.print("Introduzca el nombre del fichero a crear: ");
					
					urlCrear = entradaDatos.next();
					
					if (f1.exists()) {
						
						System.out.print("Introduzca su texto: ");
						entradaDatos.nextLine();
						textoCrear = entradaDatos.nextLine();
						
						escribirFichero (urlCrear, textoCrear, tipoA);
						System.out.println("");
						System.out.println("Fichero creado con exito.");
						
					} else {
						
						System.out.println("ATENCIÓN, el fichero seleccionado ya existe.");
						
						do {
							System.out.println("¿Que desea hacer, sobrescribir o crear otro fichero?");
							System.out.println("");
							System.out.println("A) Sobrescribir");
							System.out.println("B) Crear nuevo fichero");
							System.out.println("");
							System.out.println("Opcion: ");
							
							seleccion = entradaDatos.next();
							
							if (seleccion.equalsIgnoreCase(a)) {

								System.out.print("Introduzca su texto: ");
								entradaDatos.nextLine();
								textoCrear = entradaDatos.nextLine();
								
								escribirFichero (urlCrear, textoCrear, tipoA);
								System.out.println("");
								System.out.println("Fichero modificado con exito.");
							
							} else if (seleccion.equalsIgnoreCase(b)) {
								
								System.out.print("Introduzca el nombre del fichero a crear: ");
								
								urlCrear = entradaDatos.next();
								
								System.out.print("Introduzca su texto: ");
								entradaDatos.nextLine();
								textoCrear = entradaDatos.nextLine();
								
								escribirFichero (urlCrear, textoCrear, tipoA);
								System.out.println("");
								System.out.println("Fichero creado con exito.");
							}
							
						} while(seleccion.equalsIgnoreCase(a));
					}
					
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
					File f3 = null;
					String urlFichero = "";
					
					System.out.println("--------------------------------------------");
					System.out.println("Borrado de ficheros");
					System.out.println("--------------------------------------------");
					System.out.println("");
					System.out.println("Sintaxis para el borrado: ./texto.txt");
					System.out.println("Si conoce el directorio introduzcalo: ./directorio/texto.txt");
					System.out.println("");
					System.out.print("Introduzca el nombre del fichero a borrar: ");
					
					
					urlFichero = entradaDatos.next();
					f3 = new File (urlFichero);
					
					
					if (!f3.exists()) 
					{	
						System.out.println("");
						System.out.println("El fichero elegido no existe.");
					} else {
						borrar (urlFichero);					
						System.out.println("");
						System.out.println("Fichero borrado con exito.");
					}
				break;
				case 4:
					String urlDir = "";
					
					System.out.println("--------------------------------------------");
					System.out.println("Creación de una nuevo carpeta");
					System.out.println("--------------------------------------------");
					System.out.println("");
					System.out.println("Sintaxis para la creación: ./directorio");
					System.out.println("");
					System.out.print("Introduzca el nombre de la carpeta a crear: ");
					
					urlDir = entradaDatos.next();
					crearDirectorio (urlDir);
				break;
				case 5:
					File f5 = null;
					String dirBorrar = "";
					
					System.out.println("--------------------------------------------");
					System.out.println("Borrado de carpetas");
					System.out.println("--------------------------------------------");
					System.out.println("");
					System.out.println("Sintaxis para el borrado: ./directorio");
					System.out.println("");
					System.out.print("Introduzca el nombre de la carpeta a borrar: ");
					
					dirBorrar = entradaDatos.next();
					f5 = new File (dirBorrar);
					
					if (!f5.exists()) 
					{	
						System.out.println("");
						System.out.println("La carpeta elegida no existe.");
					} else {
						borrarDirectorio (f5);					
						System.out.println("");
						System.out.println("La carpeta se ha borrado con exito.");
					}
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
		entradaDatos.close();
	}
}
		
		
		

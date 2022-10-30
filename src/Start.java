import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Start {

	// Función para escribir ficheros.
	public static void escribirFichero (String url, String texto, boolean tipo) {
		
		FileWriter fw = null;
		PrintWriter pw = null;
			
		try {	
			fw = new FileWriter(url, tipo);
			pw = new PrintWriter(fw);
			pw.println(texto);
				
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Función para borrar ficheros.
	public static void borrarFichero(String url) {
	
		File f = null;
		f = new File(url);
		f.delete();
	}
	
	// Función para crear carpetas.
	public static void crearDirectorio (String url) {
		
		File f = null;
		f = new File(url);
		f.mkdirs();
	}
	
	// Función para borrar carpetas.
	public static void borrarDirectorio (File url) {
		
		/*
		 * Al darme cuenta de que si la carpeta contenia archivos,
		 * esta no se borraba, tuve que buscar solución. 
		 * Quizá podría usar algún método o clase que facilite mas
		 * la labor, pero al no conocer todas, trate a File como array
		 * para para leer cada fichero y lograr borrarlo todo.
		 */   
		
		if (url.isDirectory()) // Detecta si url es directorio. 
        {
            File[] contenido = url.listFiles(); 
            // File.listFiles() retorna una lista de ficheros y directorios de un objeto.
            // Por lo tanto hay que guardarlo como File [] variable.
            
            for (int j = 0; j < contenido.length; j++) { 
            	// Mientras j sea menor que contenido j++
            	// En cada pasada se almacena en i el archivo contenido[j]
            	// Posteriormente borrarDirectorio[i] borra el archivo en esa posición.
            	File i = contenido[j]; 
				borrarDirectorio(i);
			}
        }
		// Una vez se ha vaciado el contenido se ejecuta url.delete para eliminar el directorio.
        url.delete();
	}
	
	// Función para imprimir el menú.
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
	
	// Función principal
	public static void main(String[] args) {
		
		Scanner entradaDatos = new Scanner (System.in);
		boolean salir = false;
		int opcion = 0;
		
		do {
			
			imprimirMenu(); // Imprime menú.
			
			opcion = entradaDatos.nextInt(); // Elegimos opción.
			
			if (opcion>5 || opcion<0) { // Comprueba que la opción es correcta.
				System.out.print("\n");
				System.out.println("--------------------------------------------");
				System.out.println("Opción errónea");
				System.out.println("--------------------------------------------");
				System.out.print("\n");
			} else {
				switch (opcion) {
				// Crear fichero
				case 1:
					String seleccion = "";
					String a = "si";
					String b = "no";
					String urlCrear = "";
					String textoCrear = "";
					boolean tipoA = false; // Sobrescribe nuestro fichero.
					
					System.out.println("--------------------------------------------");
					System.out.println("Creación de un nuevo fichero");
					System.out.println("--------------------------------------------");
					System.out.println("");
					System.out.println("Sintaxis para la creación/edición: ./texto.txt");
					System.out.println("Si conoce el directorio introduzcalo: ./directorio/texto.txt");
					System.out.println("");
					
					System.out.print("Introduzca el nombre del fichero a crear: ");
					
					urlCrear = entradaDatos.next();
					File f1 = new File (urlCrear);
					
					// Si el fichero no existe se creará.
					if (!f1.exists()) {
						
						System.out.print("Introduzca su texto: ");
						entradaDatos.nextLine();
						textoCrear = entradaDatos.nextLine();
						
						escribirFichero (urlCrear, textoCrear, tipoA);
						System.out.println("");
						System.out.println("Fichero creado con exito.");
						
					} else {
						/*
						 * De lo contrario avisará que el fichero existe y entrará en bucle
						 * a menos que elijamos la opción correcta.
						 */
						System.out.println("");
						System.out.println("***************************************************");
						System.out.println("** ATENCIÓN, el fichero seleccionado ya existe. ***");
						System.out.println("***************************************************");
						System.out.println("");
						do {
							System.out.println("¿Desea sobrescribir el fichero?");
							System.out.println("");
							System.out.println("--------------------------------------------");
							System.out.println("Responda, si o no.");
							System.out.println("--------------------------------------------");
							System.out.println("");
							System.out.print("Opcion: ");
							
							
							seleccion = entradaDatos.next();
							
							// a con equalsIgnoreCase sera la opción si, sobrescribe el fichero.
							if (seleccion.equalsIgnoreCase(a)) {
								
								System.out.println("");
								System.out.print("Introduzca su texto: ");
								entradaDatos.nextLine(); // nueva entrada de datos para poder capturar texto
								textoCrear = entradaDatos.nextLine();
								
								escribirFichero (urlCrear, textoCrear, tipoA);
								System.out.println("");
								System.out.println("Fichero modificado con exito.");
								break; // Una vez modificado el fichero debemos salir con break.
							
							// b con equalsIgnoreCase será la opción no y pedirá nuevamente el fichero a crear.
							} else if (seleccion.equalsIgnoreCase(b)) {
								
								System.out.println("");
								System.out.print("Introduzca el nombre del fichero a crear: ");
								
								urlCrear = entradaDatos.next();
								
								/*
								 * Detecté que si seleccionaba nuevamente un fichero existente
								 * el programa seguia su curso, para evitar esto cree un nuevo if
								 * que vuelve a comprobar si el fichero existe.
								 * Si se da este caso el programa nos expulsará al menú.
								 * De lo contrario seguirá su curso.
								 */
								if (f1.exists()) {
									System.out.println("");
									System.out.println("***************************************************");
									System.out.println("** ATENCIÓN, el fichero seleccionado ya existe. ***");
									System.out.println("***************************************************");
									System.out.println("");
									System.out.println("El programa volverá al menú.");
									System.out.println("");
									break; // break para salir al menú.
								// En el caso de que introduzcamos un nombre de archivo que no exista,
								// el programa sigue su curso normal.
								} else {
									System.out.print("Introduzca su texto: ");
									entradaDatos.nextLine(); // nueva entrada de datos para poder capturar texto
									textoCrear = entradaDatos.nextLine();
									
									escribirFichero (urlCrear, textoCrear, tipoA);
									System.out.println("");
									System.out.println("Fichero creado con exito.");
									break; // break si el programa concluyo con exito para salir del bucle.
								}
								
							}
							
						} while(seleccion.equalsIgnoreCase(a)); // mientras selección sea SI nos mantenemos en el bucle
					}
					
				break;
				case 2:
					// Editar fichero
					String urlEditar = "";
					String textoEditar = "";
					boolean tipoB = true; // boolean tipo append
					
					System.out.println("--------------------------------------------");
					System.out.println("Edición de fichero");
					System.out.println("--------------------------------------------");
					System.out.println("");
					System.out.println("Sintaxis para la edición: ./texto.txt");
					System.out.println("Si conoce el directorio introduzcalo: ./directorio/texto.txt");
					System.out.println("");
					System.out.print("Introduzca el nombre del fichero a editar: ");
					
					urlEditar = entradaDatos.next();
					File f2 = new File (urlEditar);
					
					// comprobamos si el fichero NO existe
					if (!f2.exists()) {
						System.out.println("");
						System.out.println("***************************************************");
						System.out.println("** ATENCIÓN, el fichero seleccionado no existe. ***");
						System.out.println("***************************************************");
						System.out.println("");
					} else {
						System.out.print("Introduzca su texto: ");
						entradaDatos.nextLine(); // nueva entrada de datos para poder capturar texto
						textoEditar = entradaDatos.nextLine();
		
						escribirFichero (urlEditar, textoEditar, tipoB );
						System.out.println("");
						System.out.println("Fichero editado con exito.");
					}
				break;
				case 3:
					// Borrar ficheros
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
					File f3 = new File (urlFichero);
					
					// Comprobamos si el fichero NO existe.
					if (!f3.exists()) 
					{	
						System.out.println("");
						System.out.println("***************************************************");
						System.out.println("** ATENCIÓN, el fichero seleccionado no existe. ***");
						System.out.println("***************************************************");
						System.out.println("");
					} else {
						borrarFichero (urlFichero);					
						System.out.println("");
						System.out.println("--------------------------------------------");
						System.out.println("Fichero borrado con exito.");
						System.out.println("--------------------------------------------");
					}
				break;
				case 4:
					// Creación de carpetas
					String urlDir = "";
					
					System.out.println("--------------------------------------------");
					System.out.println("Creación de una nuevo carpeta");
					System.out.println("--------------------------------------------");
					System.out.println("");
					System.out.println("Sintaxis para la creación: ./directorio");
					System.out.println("");
					System.out.print("Introduzca el nombre de la carpeta a crear: ");
					
					urlDir = entradaDatos.next();
					File f4 = new File (urlDir);
					
					// Comprobamos si la carpeta existe.
					if (f4.exists()) 
					{	
						System.out.println("");
						System.out.println("***************************************************");
						System.out.println("** ATENCIÓN, la carpeta seleccionado ya existe. ***");
						System.out.println("***************************************************");
						System.out.println("");
					} else {
						crearDirectorio (urlDir);					
						System.out.println("");
						System.out.println("--------------------------------------------");
						System.out.println("Carpeta creada con exito.");
						System.out.println("--------------------------------------------");
					}
				break;
				case 5:
					// Borrar carpetas
					String dirBorrar = "";
					
					System.out.println("--------------------------------------------");
					System.out.println("Borrado de carpetas");
					System.out.println("--------------------------------------------");
					System.out.println("");
					System.out.println("Sintaxis para el borrado: ./directorio");
					System.out.println("");
					System.out.print("Introduzca el nombre de la carpeta a borrar: ");
					
					dirBorrar = entradaDatos.next();
					File f5 = new File (dirBorrar);
					
					// Comprobamos si la carpeta seleccionada NO existe
					if (!f5.exists()) 
					{	
						System.out.println("");
						System.out.println("***************************************************");
						System.out.println("** ATENCIÓN, la carpeta seleccionado no existe. ***");
						System.out.println("***************************************************");
						System.out.println("");
					} else {
						borrarDirectorio (f5);					
						System.out.println("");
						System.out.println("--------------------------------------------");
						System.out.println("La carpeta se ha borrado con exito.");
						System.out.println("--------------------------------------------");
					}
				break;
				case 0:
					// Salida de nuestro programa.
					System.out.print("\n");
					System.out.println("--------------------------------------------");
					System.out.println("El programa ha finalizado");
					System.out.println("--------------------------------------------");
					salir = true;
				}
			}
		}
		
		while (!salir);
		entradaDatos.close(); // Cerramos Scanner.
	}
}
		
		
		

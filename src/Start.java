import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Start {
	
	public static void CrearFichero () {
		
		File f = new File ("mi_fichero.txt"); 
		FileWriter fw = null; 
		PrintWriter pw = null;		
		
		
		
		if (f.exists()) 
		{
			try {
					
				fw = new FileWriter(f,true); // Añadiendo true como parametro, println fw no nos machaca el texto ya escrito. 
				pw = new PrintWriter(fw);
				
				pw.println("Añadiendo una segunda linea");
				
				pw.close();
				fw.close();
				
				
				
				System.out.println("Fichero creado correctamente");
				
			} catch (IOException e) {   	
				
				e.printStackTrace();
			}
		} 
		else 
		{
			
		}
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
					System.out.println("Caso 1");
				break;
				case 2:
					System.out.println("Caso 2");
				break;
				case 3:
					System.out.println("Caso 3");
				break;
				case 4:
					System.out.println("Caso 4");
				break;
				case 5:
					System.out.println("Caso 5");
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
		
		
		

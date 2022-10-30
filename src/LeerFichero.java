import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Start {
	
	/*
	 * Función para leer el archivo pepeNotas.txt, esta función devolvera un float o bien las notas o 
	 * en su defecto un error que esta formateado como float para devolver -1.0, el cual podremos recoger
	 * en la función principal para imprimir un error en pantalla.
	 *  
	 */
	
	public static float LeerArchivo (String url) 
	{												
		// Declaración de variables a utilizar.
		
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		String lineas = "";
		String notasTexto = "";
		int division = 0;
		int i = 0;
		float nota = 0.0f;
		float sumaNotas = 0.0f;
		float notas = 0.0f;
		float error = -1.0f;
		
		/*
		 * Iniciamos la variable f pasandole el parametro de la función, 
		 * recibira la url del archivo en formato String.
		 */
		
		f = new File(url); // 
		
		/*
		 * Para que el código resulte un poco mas limpio he metido todo 
		 * en un solo try catch.
		 */
		
		try {
			/*
			 * Inicializamos las variables fr y br, en el caso de fr le pasamos f
			 * al cual le habiamos pasado a su vez como parametro url fr se encargará
			 * de leer el contenido en f. A su vez pasamos la lectura que hace fr como
			 * parametro a br, este se encargará de ir almacenando en buffer cada linea 
			 * para poder ir mostrandola por pantalla.
			 */ 
			 
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			/* 
			 * Para poder leer del buffer lo almacenaremos en lineas, si lo que contiene lineas
			 * almacena texto nos devolvera ese texto, de lo contrario devolvera un null, por lo tanto
			 * lineas = br.reaLine() y el while se ejecuta mientras que lineas sea distinto de null.
			 */ 

			
			while ((lineas = br.readLine()) != null) { 
				division = lineas.indexOf(" "); // Division nos devolvera la posicion en la que se encuentra el espacio.
				
				/*
				 * En notasTexto almacenaremos lineas.substring(), todo aquello que este despues de la posicion
				 * que pasemos como parametro, en este caso hemos obtenido una posición con indexOf, la almacenamos como
				 * division y sera lo que pasemos como parametro a substring lineas.substring(division).
				 */
				
				notasTexto = lineas.substring(division);				
				nota = Float.parseFloat(notasTexto); // Parseamos a float lo que nos devuelve notasTexto para poder operar
				
				/*
				 * En cada paso del while se habra leido una linea, y se habrá parseado a int
				 * por lo tanto declaramos sumaNotas y se irán sumando las notas linea a linea.
				 * Ademas ponemos i como incremento para ir almacenando la cantidad de notas que tiene el texto
				 * al final si se hay leido por ejemplo 12 notas i=12, con ello podremos hayar la media de la suma
				 * de todas las notas
				 * 
				 * Aclarar que si las notas con valores flotantesalmacenadas en el texto están almacenadas con comas 
				 * en lugar de con puntos el programa dará error.
				 */
				
				sumaNotas = sumaNotas + nota;
				i++;
			}
			
			br.close(); // Cerramos el Buffer
			fr.close(); // Cerramos FileReader
			
		} catch (IOException e) 
		{
			//e.printStackTrace();
			System.out.println("Oh oh, algo ha salido mal"); // Modificamos el mensaje de exepción para mostrar algo mas elegante.
		}
		
		/*
		 * En este paso es donde se trata la lectura para devolver float error o bien las notas de Pepe.
		 * Si en el paso de while i no encuentra ningún valor en nota no incrementará, 
		 * por lo tanto no se tomará en cuenta en este paso:
		 * 
		 * notasTexto = lineas.substring(division);
		 * 
		 * En este supuesto el if i == 0 mostrará error indicando que el archivo pepe esta vacio;
		 * De lo contrario nos devolverá la nota de Pepe.
		 * 
		 * return error; o return notas;
		 */
		
		if(i==0) { 
			
			return error;
			
		} else {
			
			notas = sumaNotas/i;
			
			return notas;								
		}
		
	}

	public static void main(String[] args) {
		
		/*
		 * Iniciamos un file para imprimir el nombre del fichero en caso de que el if de la función retorne error.
		 * La finalidad es pasar f.getName para devolver el nombre del archivo que se encuentra vacío.
		 */
		
		File f = new File ("notasPepe.txt"); 
		float notaFinal = 0.0f;
		
		notaFinal = LeerArchivo("./notasPepe.txt"); // Inicializamos la funcion pasandole el parametro url.
		
		if (notaFinal == -1.0) 
		{
			System.out.println("Error el archivo "+ f.getName() +" del alumno Pepe está vacío");
		} 
		else 
		{
			System.out.println(String.format("La nota final de Pepe: %.2f", notaFinal));
			// Nos devuelve la nota del alumno Pepe formateado en una sola linea usando el metodo String.format.
		}
		
	}
	
}
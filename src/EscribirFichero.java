import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirFichero {

	public static void EscribirFichero (String url, String texto, boolean tipo) {
		
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
	
	public static void main(String[] args) {
		
		
		EscribirFichero ("./ruta/directorio_nuevo/texto_prueba.txt", "Segunda entrada de texto", true);
		
	}

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
	
	public static String LeerArchivo (String url) {												
	
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		String lineas = "";
		String texto = "";
		
		f = new File(url);
		
		try {
			 
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			while ((lineas = br.readLine()) != null) { 
				
				texto = texto + lineas;
			}
			
			br.close(); 
			fr.close(); 
			
		} catch (IOException e) {
			e.printStackTrace();
			//System.out.println("Oh oh, algo ha salido mal");
			
		}
		
		return texto;								
	
	}
	
	public static void main(String[] args) {
		
		String contenido = "";
		contenido = LeerArchivo("./ruta/directorio_nuevo/texto_prueba.txt");
		System.out.println(contenido);
	}
	
}
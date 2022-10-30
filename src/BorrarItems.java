import java.io.File;

public class BorrarItems {
	
	
	public static void borrarFichero (String url) {
		
		File f = null;
		
		f = new File(url);
		
		f.delete();
		
		System.out.println("Archivo borrado");

	}
	
	public static void borrarDirectorio (String url) {
		
		File f = null;
		
		f = new File(url);
		
		f.delete();
		
		System.out.println("Directorio borrado");

	}

	public static void main(String[] args) {
		
		
		
	}

}

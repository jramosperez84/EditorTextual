import java.io.File;

public class CrearCarpeta {

	public static void CrearDirectorio (String url) {
		
		File f = new File(url);
        if (!f.exists()) {
            if (f.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
	}
	
	public static void main(String[] args) {
		
        
		
	}

}

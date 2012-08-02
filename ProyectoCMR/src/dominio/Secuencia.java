package dominio;

public class Secuencia {
	private static int secuenciaProspecto = 0;
	private static int secuenciaCliente = 0;
	private static String[] tablas = {"Prospecto","Cliente"};
	
	public Secuencia() {
		
	}
	
	// Retorna el numero secuencial siguiente
	public static String get(String p_tabla) {
		int indice = 0;
		String new_seq = "";
		for (String s : tablas) {
			if (s.equals(p_tabla))
				break;
			indice++;
		}
		//System.out.println(String.format("Secuencias - Prospecto:%d, Cliente:%d", secuenciaProspecto, secuenciaCliente));
		switch (indice) {
		case 0:
			new_seq = String.format("%1$05d", ++secuenciaProspecto);
			break;
		case 1:
			new_seq = String.format("%1$05d", ++secuenciaCliente);
			break;
		default:
			new_seq = "*****";
			break;
		}
		return new_seq;
	}
	
	public static void reset() {
		secuenciaProspecto = 0;
		secuenciaCliente = 0;
	}
	
}

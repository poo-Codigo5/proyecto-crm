package dominio;

public class Secuencia {
	private static int secuenciaProspecto = 0;
	private static int secuenciaCliente = 0;
	private static int secuenciaGrupoEstudio = 0;
	private static int secuenciaVenta = 0;
	private static int secuenciaCompra = 0;	
	private static String[] tablas = {"Prospecto","Cliente","GrupoEstudio","Venta","Compra"};
	
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
		case 2:
			new_seq = String.format("%1$05d", ++secuenciaGrupoEstudio);
			break;			
		case 3:
			new_seq = String.format("%1$05d", ++secuenciaVenta);
			break;			
		case 4:
			new_seq = String.format("%1$05d", ++secuenciaCompra);
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
		secuenciaVenta = 0;
		secuenciaCompra = 0;
		secuenciaGrupoEstudio = 0;
	}
	
}

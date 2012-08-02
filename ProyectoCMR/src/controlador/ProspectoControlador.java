package controlador;
import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dominio.Prospecto;
import dominio.Secuencia;

public class ProspectoControlador {
	private List<Prospecto> data;
	private String[] listOpciones = {"Agregar","Modificar","Eliminar","Buscar","Listar"};
	private String[] prospectoFormulario = {"Codigo","Nombres","Apellido Paterno","Apellido Materno","Correo electrónico","DNI","Teléfono","Fecha Contacto"};
	private String[] prospectoFiltroCol = {"codigo","nombres","apellidoPaterno","apellidoMaterno","eMail","DNI","telefono","fechaContacto"};
	private String[] prospectoFiltroVal = {null    ,null     ,null             ,null             ,null   ,null ,null      ,null};
	private String ultimoMensaje;
	
	public ProspectoControlador() {
		data = new ArrayList<Prospecto>();
	}
	// Agregar un nuevo Prospecto, autogenerar el código
	public String agregar(String p_nombres, String p_apellidoPaterno, String p_apellidoMaterno,
			String p_eMail, String p_DNI, String p_telefono, String p_fechaContacto) {
		// Validar que cliente registre estos datos como mínimo
		if (p_nombres == null ||
			p_apellidoPaterno == null ||
			p_apellidoMaterno == null ||
			p_eMail == null) {
				// si no cumple, retornar * que significa error
				return "*****";
		}
		// Validar si son cadenas en blanco
		if (p_nombres.isEmpty() ||
				p_apellidoPaterno.isEmpty() ||
				p_apellidoMaterno.isEmpty() ||
				p_eMail.isEmpty()) {
			// si no cumple, retornar * que significa error
			return "*****";
		}
		// Registrar datos de cliente
		Prospecto p = new Prospecto();
		String seq_codigo = null;
		seq_codigo = Secuencia.get("Prospecto");
		p.setCodigo(seq_codigo);
		p.setNombres(p_nombres);
		p.setApellidoPaterno(p_apellidoPaterno);
		p.setApellidoMaterno(p_apellidoMaterno);
		p.setEMail(p_eMail);
		p.setDNI(p_DNI);
		p.setTelefono(p_telefono);
		p.setFechaContacto(p_fechaContacto);
		
		// Añadir a lista de clientes
		data.add(p);
//		System.out.println(p);
//		System.out.println("Clientes:"+data.size());
		
		// Retornar código autogenerado
		return seq_codigo;
	}
	
	public boolean buscar(String p_campo, String p_valor) {
		//System.out.println("p_campo:"+p_campo+", p_valor:"+p_valor+", comp:"+p_campo.compareTo("nombres"));
		if (p_campo.equals("nombres")) {
			for (Prospecto p : data) {
				//System.out.println("Nombres:"+p.getNombres());
				if (p.getNombres().equals(p_valor))
					return true;
			}
		}
		else if (p_campo.equals("apellidoPaterno")) {
			for (Prospecto p : data) {
				if (p.getApellidoPaterno().equals(p_valor))
					return true;
			}
		}
		else if (p_campo.equals("apellidoMaterno")) {
			for (Prospecto p : data) {
				if (p.getApellidoMaterno().equals(p_valor))
					return true;
			}
		}
		else if (p_campo.equals("eMail")) {
			for (Prospecto p : data) {
				if (p.getEMail().equals(p_valor))
					return true;
			}
		}
		else if (p_campo.equals("DNI")) {
			for (Prospecto p : data) {
				//System.out.println("DNI:"+p.getDNI());
				if (p.getDNI().equals(p_valor))
					return true;
			}
		}
		else if (p_campo.equals("telefono")) {
			for (Prospecto p : data) {
				if (p.getTelefono().equals(p_valor))
					return true;
			}
		}
		else if (p_campo.equals("fechaContacto")) {
			for (Prospecto p : data) {
				if (p.getFechaContacto().equals(p_valor))
					return true;
			}
		}
		return false;
	}
	
	// Eliminar el filtro
	public void resetFiltro() {
		for (int i=0; i<prospectoFiltroCol.length; i++) {
			prospectoFiltroVal[i] = null;
		}
	}
	
	// Definir los filtros para la busqueda
	public void setFiltro(String p_campo, String p_valor) {
		int i = 0;
		// Recorrer las columnas a filtrar
		for (String p : prospectoFiltroCol) {
			// Si se encuentra la columna del filtro
			if (p.equals(p_campo)) {
				// Asignar el valor a filtrar
				prospectoFiltroVal[i] = p_valor;
			}
			i++;
		}
	}
	
	// Listado de Prospectos filtrados segun filtros definidos
	public boolean listar() {
		boolean retorno = false;
		// Ordenar los datos por Fecha de Contacto
		Collections.sort(data, new ProspectoFechaContactoComparator());
		// Mostrar la cabecera del listado
		System.out.println(Prospecto.cabecera());
		// Leer todos los registros
		for (Prospecto p : data) {
			if (p.coincide(prospectoFiltroVal)) {
				System.out.println(p);
				retorno = true;
			}
		}
		if (!retorno)
			setUltimoMensaje("No se encontraron prospectos segun los criterios especificados");
		return retorno;
	}
	
	public void setUltimoMensaje(String p_ultimoMensaje) {
		this.ultimoMensaje = p_ultimoMensaje;
	}
	
	public void menu() {
	    String read_opcion = null;
	    int numero = 0;
	    Console console = System.console();
		do {
			System.out.println("Instituto Benedicto XVI");
			System.out.println("=======================");
			System.out.println("Menu de Prospectos\n");
			
			numero = 0;
			for (String opciones : listOpciones) {
				System.out.println(++numero + ". "+opciones);
			}
			System.out.println("0. Salir");
		    read_opcion = console.readLine("Ingrese su opcion : ");
		    numero = Integer.parseInt(read_opcion);
		    switch (numero) {
		    case 1:
		    	agregarFormulario();
		    	break;
		    case 5:
		    	listar();
		    	break;
		    case 0:
		    	break;
		    default:
		    	break;
		    }
		} while (numero != 0);
		
	}
	
	public void formulario() {
		int numero = 0;
		for (String formulario : prospectoFormulario) {
			System.out.println(++numero + ". "+formulario);
		}
		System.out.println("0. Salir");
	}
	
	public void agregarFormulario() {
		int numero = 0;
		String dato = null;
		Prospecto p = new Prospecto();
	    Console console = System.console();
		for (String formulario : prospectoFormulario) {
			dato = console.readLine(++numero + ". "+formulario+" : ");
			switch (numero) {
				case 1: 
					p.setCodigo(dato);
					break;
				case 2:
					p.setNombres(dato);
					break;
				case 3:
					p.setApellidoPaterno(dato);
					break;
				case 4:
					p.setApellidoMaterno(dato);
					break;
				case 5:
					p.setEMail(dato);
					break;
				case 6:
					p.setDNI(dato);
					break;
				case 7:
					p.setTelefono(dato);
					break;
				case 8:
					p.setFechaContacto(dato);
					break;
				default:
					break;
			}
		}
		data.add(p);
	}
	
	public boolean autorizado() {
		
		return true;
	}
	public String getUltimoMensaje() {
		return this.ultimoMensaje;
	}
}

class ProspectoFechaContactoComparator implements Comparator { 

public int compare(Object o1, Object o2) { 
        Prospecto p1 = (Prospecto) o1; 
        Prospecto p2 = (Prospecto)o2; 
        return p1.getFechaContacto(). 
                compareTo(p2.getFechaContacto()); 

    } 
} 
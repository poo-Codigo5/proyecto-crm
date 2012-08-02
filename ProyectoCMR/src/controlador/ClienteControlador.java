package controlador;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import dominio.Cliente;
<<<<<<< HEAD
import dominio.Secuencia;
=======
>>>>>>> 37513c4a697ade5aff24b41f31fba5462492e831

public class ClienteControlador {
	private List<Cliente> data;
	private String[] listOpciones = {"Agregar","Modificar","Eliminar","Buscar","Listar"};
	private String[] clienteFormulario = {"Codigo","Nombres","Apellido Paterno","Apellido Materno","Correo electrónico","DNI","Teléfono","Fecha Contacto"};
	
	public ClienteControlador() {
		data = new ArrayList<Cliente>();
	}
<<<<<<< HEAD
	// Agregar un nuevo Cliente, autogenerar el código
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
		Cliente p = new Cliente();
		String seq_codigo = null;
		seq_codigo = Secuencia.get("Cliente");
		p.setCodigo(seq_codigo);
=======
	public boolean agregar(String p_codigo, String p_nombres, String p_apellidoPaterno, String p_apellidoMaterno,
			String p_eMail, String p_DNI, String p_telefono, String p_fechaContacto) {
		Cliente p = new Cliente();
		p.setCodigo(p_codigo);
>>>>>>> 37513c4a697ade5aff24b41f31fba5462492e831
		p.setNombres(p_nombres);
		p.setApellidoPaterno(p_apellidoPaterno);
		p.setApellidoMaterno(p_apellidoMaterno);
		p.setEMail(p_eMail);
		p.setDNI(p_DNI);
		p.setTelefono(p_telefono);
		p.setFechaContacto(p_fechaContacto);
<<<<<<< HEAD
		
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
			for (Cliente p : data) {
				//System.out.println("Nombres:"+p.getNombres());
=======
		data.add(p);
		return true;
	}

	public boolean buscar(String p_campo, String p_valor) {
		if (p_campo.equals("nombres")) {
			for (Cliente p : data) {
>>>>>>> 37513c4a697ade5aff24b41f31fba5462492e831
				if (p.getNombres().equals(p_valor))
					return true;
			}
		}
<<<<<<< HEAD
		else if (p_campo.equals("DNI")) {
			for (Cliente p : data) {
				//System.out.println("DNI:"+p.getDNI());
				if (p.getDNI().equals(p_valor))
					return true;
			}
		}
		return false;
	}
	
=======
		return false;
	}
>>>>>>> 37513c4a697ade5aff24b41f31fba5462492e831
	public boolean listar() {
		System.out.println(Cliente.cabecera());
		for (Cliente p : data) {
			System.out.println(p);
		}
		return true;
	}
	
	public void menu() {
	    String read_opcion = null;
	    int numero = 0;
	    Console console = System.console();
		do {
			System.out.println("Instituto Benedicto XVI");
			System.out.println("=======================");
			System.out.println("Menu de Clientes\n");
			
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
		for (String formulario : clienteFormulario) {
			System.out.println(++numero + ". "+formulario);
		}
		System.out.println("0. Salir");
	}
	
	public void agregarFormulario() {
		int numero = 0;
		String dato = null;
		Cliente p = new Cliente();
	    Console console = System.console();
		for (String formulario : clienteFormulario) {
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
<<<<<<< HEAD
	
	public boolean autorizado() {
		
		return true;
	}
=======
>>>>>>> 37513c4a697ade5aff24b41f31fba5462492e831
}

package controlador;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import dominio.Usuario;

public class UsuarioControlador {
	private List<Usuario> data;
	private String[] listOpciones = {"Agregar","Modificar","Eliminar","Buscar","Listar"};
	private String[] usuarioFormulario = {"Codigo","Nombre","Clave"};

	public UsuarioControlador() {
		data = new ArrayList<Usuario>();
	}
	public boolean agregar(String p_codigo, String p_nombre, String p_clave) {
		Usuario p = new Usuario();
		p.setCodigo(p_codigo);
		p.setNombre(p_nombre);
		p.setPassword(p_clave);
		data.add(p);
		return true;
	}

<<<<<<< HEAD
	public boolean buscar(String p_campo, String p_valor) {
		if (p_campo.equals("nombre")) {
			for (Usuario p : data) {
				if (p.getNombre().equals(p_valor))
					return true;
			}
		}
		return false;
	}
	public boolean listar() {
		System.out.println(Usuario.cabecera());
		for (Usuario p : data) {
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
			System.out.println("Menu de Usuario\n");
			
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
		for (String formulario : usuarioFormulario) {
			System.out.println(++numero + ". "+formulario);
		}
		System.out.println("0. Salir");
	}
	
	public void agregarFormulario() {
		int numero = 0;
		String dato = null;
		Usuario p = new Usuario();
	    Console console = System.console();
		for (String formulario : usuarioFormulario) {
			dato = console.readLine(++numero + ". "+formulario+" : ");
			switch (numero) {
				case 1: 
					p.setCodigo(dato);
					break;
				case 2:
					p.setNombre(dato);
					break;
				case 3:
					p.setPassword(dato);
					break;
				default:
					break;
			}
		}
		data.add(p);
	}
	public static boolean login(String p_codigo, String p_clave) {
		// TODO Auto-generated method stub
		return true;
	}
}
=======
	public String Auntenticar(String usua,String contra){
		String result="";
		if ( usua.equalsIgnoreCase("wilmer") && contra.equalsIgnoreCase("w123")){
			result="BIENVENIDO AL SISTEMA BENEDICTO XVI";
		}else if( (usua=="wilmer"&& contra!="w123") ||  (usua!="wilmer"&& contra=="w123") ){
				result="USUARIO O CONTRASEÑA ES INCORRECT0";	
				}else if(usua.isEmpty() && contra.isEmpty()){
					result="USUARIO Y CONTRASEÑA NO PUEDEN ESTAR VACIOS";
		}
		return result;
	}
}
>>>>>>> 0247c2fc04f21232e665515488111e19b0921d8a

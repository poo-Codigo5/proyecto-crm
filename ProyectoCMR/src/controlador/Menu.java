<<<<<<< HEAD
package controlador;

import java.io.Console;

public class Menu {
	private String[] listMenu = {"Prospectos", "Clientes", "Usuarios"};
	public void show() {
		String read_opcion = null;
		int numero = 0;
	    Console console = System.console();
		do {
			System.out.println("Instituto Benedicto XVI");
			System.out.println("=======================");
			System.out.println("Gestion de Informacion\n");
			
			System.out.println("Menu principal");
			numero = 0;
			for (String menu : listMenu) {
				System.out.println(++numero + ". "+menu);
			}
			System.out.println("0. Salir");
		    read_opcion = console.readLine("Ingrese su opcion : ");
		    numero = Integer.parseInt(read_opcion);
		    switch (numero) {
		    case 1:
		    	ClienteControlador p = new ClienteControlador();
		    	p.menu();
		    	break;
		    case 2:
		    	break;
		    case 3:
		    	break;
		    default:
		    	break;
		    }
		    
		} while (!read_opcion.equals("0"));
	
	}
}
=======
package controlador;

import java.io.Console;

public class Menu {
	private String[] opciones = {"Prospectos", "Clientes", "Usuarios"};
	public void show() {
		int numero = 0;
		System.out.println("Instituto Benedicto XVI");
		System.out.println("=======================");
		System.out.println("Gestión de Información\n");
		
		System.out.println("Opciones : ");
		for (String opcion : opciones) {
			System.out.println(++numero + ". "+opcion);
		}
	    Console console = System.console();
	    String read_opcion = console.readLine("Ingrese su opcion : ");
	    System.out.println("opcion : "+read_opcion);
	}
}
>>>>>>> abe88b1566917ad6033bb248d21b8cdcef8e98f7

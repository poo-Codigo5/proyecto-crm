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
		    default:
		    	break;
		    }
		    
		} while (!read_opcion.equals("0"));
	
	}
}

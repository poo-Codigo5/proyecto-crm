package controlador;

import java.io.Console;

public class Menu {
	private String[] opciones = {"Prospectos", "Clientes", "Usuarios"};
	public void show() {
		int numero = 0;
		System.out.println("Instituto Benedicto XVI");
		System.out.println("=======================");
		System.out.println("Gestion de Informacion\n");
		
		System.out.println("Opciones : ");
		for (String opcion : opciones) {
			System.out.println(++numero + ". "+opcion);
		}
	    Console console = System.console();
	    String read_opcion = console.readLine("Ingrese su opcion : ");
	    System.out.println("opcion : "+read_opcion);
	}
}

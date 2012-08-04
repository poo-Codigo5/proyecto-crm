
package controlador;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Menu {
	private String[] listMenu = {"Prospectos", "Clientes", "Ventas", "Compras", "Grupos de Estudio", "Administración de Usuarios", "Administración de Roles"};
	public void show() {

        try
        {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));        	
		String read_opcion = "";
		int numero = 0;
		do {
			System.out.println("Instituto Benedicto XVI");
			System.out.println("=======================");
			System.out.println("Gestion de Información\n");
			
			System.out.println("Menu principal");
			numero = 0;
			for (String menu : listMenu) {
				System.out.println(++numero + ". "+menu);
			}
			System.out.println("0. Salir");
			System.out.println("Ingrese su opcion : ");
			read_opcion = in.readLine();
		    numero = Integer.parseInt(read_opcion);
		    switch (numero) {
		    case 1:
		    	// Instanciar la clase que controla los prospectos
		    	ProspectoControlador pc = new ProspectoControlador();
		    	
		    	// Cargar datos de prueba
		    	pc.loadTestData();
		    	
		    	// Mostrar el menu
		    	pc.menu();
		    	break;
		    case 2:
		    	ClienteControlador cc = new ClienteControlador();
		    	cc.menu();
		    	break;
		    case 3:
		    	break;
		    case 4:
		    	break;
		    case 5:
		    	GrupoEstudioControlador p1 = new GrupoEstudioControlador();
		    	p1.menu();
		    	break;
		    case 6:
		    	break;
		    case 7:
		    	break;
		    default:
		    	break;
		    }
		    
		} while (numero != 0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

	}
}

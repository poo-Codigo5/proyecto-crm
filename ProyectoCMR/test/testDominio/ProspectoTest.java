package testDominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.ClienteControlador;

public class ProspectoTest {
	private ClienteControlador clienteControlador = new ClienteControlador();
	
	@Before
	public void testInicializar() {
		boolean ok = false;
		System.out.println("Inicializar antes de pruebas");
		ok = clienteControlador.agregar("01", "Juan","Perez","Rojas","juanperez@hotmail.com","16201123","720-1222","01/01/2012");
		ok = clienteControlador.agregar("02", "Maria","Ocaña","Rios","mariaocana@hotmail.com","12345667","720-1222","05/07/2012");
		ok = clienteControlador.agregar("03", "Gabriel","Osorio","Iriarte","gabrielosorio@hotmail.com","87654321","720-1222","15/06/2012");
		ok = clienteControlador.agregar("04", "Raul","Quispe","Mendizabal","raulquispe@msn.com","87654321","720-1222","21/04/2012");
		ok = clienteControlador.agregar("05", "Miguel","Huaman","Flor","miguelhuaman@msn.com","12345667","720-1222","18/01/2012");
		ok = clienteControlador.agregar("06", "Karina","Pita","Branco","karinapita@gmail.com","16201123","720-1222","22/07/2012");
		ok = clienteControlador.agregar("07", "Olga","Julca","Zambrano","olgajulca@gmail.com","87654321","720-1222","28/05/2012");
		ok = clienteControlador.agregar("08", "Susana","Chavez","Garcia","susanachavez@yahoo.com","16201123","720-1222","09/03/2012");
		ok = clienteControlador.agregar("09", "Mariela","Ugarte","Velez","marielaugarte@yahoo.com","12345667","720-1222","24/11/2012");
	}
	
	@Test
	public void testAgregarProspecto() {
		assertTrue(clienteControlador.agregar("01", "Juan","Perez","Rojas","juanperez@hotmail.com","16201123","720-1222","01/01/2012"));
	}
	
	@Test
	public void testBuscarProspectoOk() {
		assertTrue(clienteControlador.buscar("nombres","Juan"));
	}
	
	@Test
	public void testBuscarProspectoFail() {
		assertFalse(clienteControlador.buscar("DNI","12345678"));
	}
	
	@Test
	public void testListarProspecto() {
		assertTrue(clienteControlador.listar());
	}
	
	@After
	public void testTerminar() {
		System.out.println("Terminar pruebas");
		System.out.println("Cambios de ultimo minuto");
	}
}

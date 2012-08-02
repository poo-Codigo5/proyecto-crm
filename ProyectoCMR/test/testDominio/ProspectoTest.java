package testDominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.ProspectoControlador;
import dominio.Secuencia;

public class ProspectoTest {
	private ProspectoControlador prospectoControlador = new ProspectoControlador();
	
	@Before
	public void testInicializar() {
		String codigo = null;
		System.out.println("Inicializar antes de pruebas");
		codigo = prospectoControlador.agregar("Juan","Perez","Rojas","juanperez@hotmail.com","16201123","720-1221","2012/01/01");
		codigo = prospectoControlador.agregar("Maria","Ocaña","Rios","mariaocana@hotmail.com","12345667","720-1222","2012/05/07");
		codigo = prospectoControlador.agregar("Gabriel","Osorio","Iriarte","gabrielosorio@hotmail.com","87654321","720-1223","2012/06/15");
		codigo = prospectoControlador.agregar("Raul","Quispe","Mendizabal","raulquispe@msn.com","87654321","720-1222","2012/04/21");
		codigo = prospectoControlador.agregar("Miguel","Huaman","Flor","miguelhuaman@msn.com","12345667","720-1224","2012/01/18");
		codigo = prospectoControlador.agregar("Karina","Pita","Branco","karinapita@gmail.com","16201123","720-1222","2012/07/22");
		codigo = prospectoControlador.agregar("Olga","Julca","Zambrano","olgajulca@gmail.com","87654321","720-1225","2012/05/28");
		codigo = prospectoControlador.agregar("Susana","Chavez","Garcia","susanachavez@yahoo.com","16201123","720-1222","2012/03/09");
		codigo = prospectoControlador.agregar("Mariela","Ugarte","Velez","marielaugarte@yahoo.com","12345667","720-1226","2012/11/24");
		System.out.println("Ultimo codigo generado de prospecto: "+codigo);
	}
	// Pruebas de Criterios de aceptacion para Prospectos
	
	// Criterio 1: Poder registrarlo usando los datos completos
	@Test
	public void testAgregarProspecto() {
		String codigo = null;
		assertEquals("00010", prospectoControlador.agregar("Juan","Perez","Rojas","juanperez@hotmail.com","16201123","720-1222","01/01/2012"));
	}
	
	// Criterio 2: Inaceptable el registro si no se tiene como minimo Nombre, Apellido Paterno, Apellido Materno y Correo
	@Test
	public void testAgregarProspectoFail() {
		String codigo = null;
		assertEquals("*****", prospectoControlador.agregar("Oscar","Valdes",null,"oscarvaldez@hotmail.com",null,null,null));
	}
	
	// Criterio 3: Buscar prospectos por cualquiera de los atributos del prospecto
	@Test
	public void testBuscarProspectoOk() {
		prospectoControlador.resetFiltro();
		prospectoControlador.setFiltro("nombres","Juan");
		assertEquals(true, prospectoControlador.listar());
	}
	
	@Test
	public void testBuscarProspectoFail() {
		prospectoControlador.resetFiltro();
		prospectoControlador.setFiltro("DNI","12345678");
		assertEquals(false, prospectoControlador.listar());
	}
	
	// Criterio 4: Ver el resultado de la busqueda ordenado por fecha de contacto
	@Test
	public void testListarProspecto() {
		prospectoControlador.resetFiltro();
		prospectoControlador.setFiltro("telefono","720-1222");
		assertEquals(true, prospectoControlador.listar());
	}
	
	@Test
	public void testListarProspectoFail() {
		prospectoControlador.resetFiltro();
		prospectoControlador.setFiltro("apellidoPaterno","Mendoza");
		assertEquals(false, prospectoControlador.listar());
	}
	
	// Criterio 5: Si no existen los prospectos se informará con un mensaje
	@Test
	public void testListarProspectoMensaje() {
		prospectoControlador.resetFiltro();
		prospectoControlador.setFiltro("apellidoPaterno","Mendoza");
		boolean ret = prospectoControlador.listar();
		assertEquals("No se encontraron prospectos segun los criterios especificados", prospectoControlador.getUltimoMensaje());
	}
	
	@After
	public void testTerminar() {
		System.out.println("Terminar pruebas");
		Secuencia.reset();
	}
}

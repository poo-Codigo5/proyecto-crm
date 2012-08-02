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
		codigo = prospectoControlador.agregar("Juan","Perez","Rojas","juanperez@hotmail.com","16201123","720-1221","01/01/2012");
		codigo = prospectoControlador.agregar("Maria","Ocaña","Rios","mariaocana@hotmail.com","12345667","720-1222","05/07/2012");
		codigo = prospectoControlador.agregar("Gabriel","Osorio","Iriarte","gabrielosorio@hotmail.com","87654321","720-1223","15/06/2012");
		codigo = prospectoControlador.agregar("Raul","Quispe","Mendizabal","raulquispe@msn.com","87654321","720-1222","21/04/2012");
		codigo = prospectoControlador.agregar("Miguel","Huaman","Flor","miguelhuaman@msn.com","12345667","720-1224","18/01/2012");
		codigo = prospectoControlador.agregar("Karina","Pita","Branco","karinapita@gmail.com","16201123","720-1222","22/07/2012");
		codigo = prospectoControlador.agregar("Olga","Julca","Zambrano","olgajulca@gmail.com","87654321","720-1225","28/05/2012");
		codigo = prospectoControlador.agregar("Susana","Chavez","Garcia","susanachavez@yahoo.com","16201123","720-1222","09/03/2012");
		codigo = prospectoControlador.agregar("Mariela","Ugarte","Velez","marielaugarte@yahoo.com","12345667","720-1226","24/11/2012");
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
		assertEquals(true, prospectoControlador.buscar("nombres","Juan"));
	}
	
	@Test
	public void testBuscarProspectoFail() {
		assertEquals(false, prospectoControlador.buscar("DNI","12345678"));
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
	
	@After
	public void testTerminar() {
		System.out.println("Terminar pruebas");
		Secuencia.reset();
	}
}

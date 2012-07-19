package testDominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controlador.ProspectoControlador;

public class ProspectoTest {
	ProspectoControlador prospectoControlador = new ProspectoControlador();
	
	@Test
	public void testAgregarProspecto() {
		assertTrue(prospectoControlador.agregar("Juan","Perez","Rojas","juanperez@hotmail.com","16201123","720-1222","01/01/2012"));
		assertTrue(prospectoControlador.buscar("nombres","Juan"));
		assertFalse(prospectoControlador.buscar("DNI","12345678"));
	}
}

package testDominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dominio.Prospecto;

public class ProspectoTest {
	Prospecto prospecto = new Prospecto();
	
	@Test
	public void testAgregarProspecto() {
		assertTrue(prospecto.agregar("Juan","Perez","Rojas","juanperez@hotmail.com","16201123","720-1222"));
		assertTrue(prospecto.buscar("nombre","Juan"));
		assertFalse(prospecto.buscar("DNI","12345678"));
	}
}

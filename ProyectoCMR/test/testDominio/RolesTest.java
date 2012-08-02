package testDominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.RolesControlador;

public class RolesTest {
	private RolesControlador rolesControlador = new RolesControlador();
		
	@Before
	public void testInicializar() {
		boolean ok = false;
		System.out.println("Inicializar antes de pruebas");
		ok = rolesControlador.agregar("01", "Administrador","A10B12C15");
		ok = rolesControlador.agregar("02", "Consulta","A01B13");
		ok = rolesControlador.agregar("03", "Ventas","A10B12C15");
		ok = rolesControlador.agregar("04", "Compras","A10B12C15");
		ok = rolesControlador.agregar("05", "Clientes","A10B12C15");
		
	}	
	
	@Test
	public void testAgregarRoles() {
	assertTrue(rolesControlador.agregar("01","Admin","XXXXXX"));

	}
	
	@Test
	public void testBuscarRolesOk() {
		assertTrue(rolesControlador.buscar("codigo","01"));
	}
	
	@Test
	public void testBuscarRolesFail() {
		assertFalse(rolesControlador.buscar("codigo","21"));
	}
	
	@Test
	public void testListarProspecto() {
		assertTrue(rolesControlador.listar());
	}
	
	@After
	public void testTerminar() {
		System.out.println("Terminar pruebas");
		System.out.println("Cambios de ultimo minuto");
	}

	
	
}

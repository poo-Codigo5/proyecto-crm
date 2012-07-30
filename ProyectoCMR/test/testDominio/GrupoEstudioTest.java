package testDominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controlador.GrupoEstudioControlador;

public class GrupoEstudioTest {
	private GrupoEstudioControlador grupoestudioControlador = new GrupoEstudioControlador();
	@Before
	public void testInicializar(){
		boolean ok = false;
		System.out.println("Inicializar antes de pruebas");
		ok = grupoestudioControlador.agregar("01", "Visual.NET","VB.NET","Academia Lima","VB.NET","2012-08-01","2012-10-30","0","Jose Diaz","syll001","Av.Alfonso Ugarte 123","B10","12°02 00 S","77°01 00 O");
		ok = grupoestudioControlador.agregar("02", "SQL 2010","SQL","Academia Lima","SQL","2012-08-01","2012-10-30","0","Raul Diaz","syll002","Av.Alfonso Ugarte 123","B20","12°02 00 S","77°01 00 O");
		ok = grupoestudioControlador.agregar("03", "Oracle 11","Oracle Administrator","Academia Lima","Oracle Administrator","2012-08-01","2012-10-30","0","Rommel Diaz","syll003","Av.Alfonso Ugarte 123","B30","12°02 00 S","77°01 00 O");
		ok = grupoestudioControlador.agregar("04", "Office 2010","Excel 2010 Avanzado","Academia Lima","Excel 2010","2012-08-01","2012-10-30","0","Pablo Diaz","syll004","Av.Alfonso Ugarte 123","B40","12°02 00 S","77°01 00 O");
		ok = grupoestudioControlador.agregar("05", "Office 2010","Word 2010 Avanzado","Academia Lima","Word 2010","2012-08-01","2012-10-30","0","Ernesto Diaz","syll005","Av.Alfonso Ugarte 123","B50","12°02 00 S","77°01 00 O");
		ok = grupoestudioControlador.agregar("06", "Office 2010","Powerpoint 2010 Avanzado","Academia Lima","Powerpoint 2010","2012-08-01","2012-10-30","0","Julio Diaz","syll006","Av.Alfonso Ugarte 123","B60","12°02 00 S","77°01 00 O");
		ok = grupoestudioControlador.agregar("07", "Office 2010","Outlook 2010 Avanzado","Academia Norte","Outlook 2010","2012-08-01","2012-10-30","0","Julio Diaz","syll006","Av.Alfonso Ugarte 123","B70","12°02 00 S","77°01 00 O");
	}
	
	@Test
	public void testAgregarGrupoEstudio() {
		assertTrue(grupoestudioControlador.agregar("08", "AUTOCAD 11","AUTOCAD","Academia Lima","AUTOCAD","2012-08-01","2012-10-30","0","Jose Diaz","syll001","Av.Alfonso Ugarte 123","B10","12°02 00 S","77°01 00 O"));
	}

	@Test
	public void testAgregarGrupoEstudioSinCodigo() {
		assertFalse(grupoestudioControlador.agregar("", "AUTOCAD 11","AUTOCAD","Academia Lima","AUTOCAD","2012-08-01","2012-10-30","0","Jose Diaz","syll001","Av.Alfonso Ugarte 123","B10","12°02 00 S","77°01 00 O"));
	}	
	@Test
	public void testAgregarGrupoEstudioSinNombre() {
		assertFalse(grupoestudioControlador.agregar("09", "","AUTOCAD","Academia Lima","AUTOCAD","2012-08-01","2012-10-30","0","Jose Diaz","syll001","Av.Alfonso Ugarte 123","B10","12°02 00 S","77°01 00 O"));
	}
	
	@Test
	public void testAgregarGrupoEstudioSinFechaInicio() {
		assertFalse(grupoestudioControlador.agregar("10", "AUTOCAD 11","AUTOCAD","Academia Lima","AUTOCAD","","2012-10-30","0","Jose Diaz","syll001","Av.Alfonso Ugarte 123","B10","12°02 00 S","77°01 00 O"));
	}
	
	@Test
	public void testAgregarGrupoEstudioSinFechaFin() {
		assertFalse(grupoestudioControlador.agregar("11", "AUTOCAD 11","AUTOCAD","Academia Lima","AUTOCAD","2012-08-01","","0","Jose Diaz","syll001","Av.Alfonso Ugarte 123","B10","12°02 00 S","77°01 00 O"));
	}
	
	@Test
	public void testAgregarGrupoEstudioSinFormatoFechaInicio() {
		assertFalse(grupoestudioControlador.agregar("11", "AUTOCAD 11","AUTOCAD","Academia Lima","AUTOCAD","01-15-201","2012-10-30","0","Jose Diaz","syll001","Av.Alfonso Ugarte 123","B10","12°02 00 S","77°01 00 O"));
	}

	@Test
	public void testAgregarGrupoEstudioSinFormatoFechaFin() {
		assertFalse(grupoestudioControlador.agregar("11", "AUTOCAD 11","AUTOCAD","Academia Lima","AUTOCAD","01-08-2012","2012-1-0","0","Jose Diaz","syll001","Av.Alfonso Ugarte 123","B10","12°02 00 S","77°01 00 O"));
	}

	@Test
	public void testAgregarGrupoEstudioConFechaInicioIgualFechaFin() {
		assertFalse(grupoestudioControlador.agregar("11", "AUTOCAD 11","AUTOCAD","Academia Lima","AUTOCAD","2012-08-01","2012-08-01","0","Jose Diaz","syll001","Av.Alfonso Ugarte 123","B10","12°02 00 S","77°01 00 O"));
	}	

	@Test
	public void testAgregarGrupoEstudioConFechaInicioMayorFechaFin() {
		assertFalse(grupoestudioControlador.agregar("11", "AUTOCAD 11","AUTOCAD","Academia Lima","AUTOCAD","2012-10-01","2012-08-01","0","Jose Diaz","syll001","Av.Alfonso Ugarte 123","B10","12°02 00 S","77°01 00 O"));
	}		
	
	@Test
	public void testBuscarGrupoEstudioOk() {
		assertTrue(grupoestudioControlador.buscar("nombre","Oracle 11"));
	}
	
	@Test
	public void testBuscarGrupoEstudioFail() {
		assertFalse(grupoestudioControlador.buscar("academia","Academia Norte"));
	}	

	@Test
	public void testListarGrupoEstudio() {
		assertTrue(grupoestudioControlador.listar());
		
	}
	
	
	
}

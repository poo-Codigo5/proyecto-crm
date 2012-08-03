package testDominio;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import controlador.AutenticarControlador;

public class AutenticarTest {

	List<String> usuarios;
	List<String> contrasenas;
	
	@Before
	public void inicio(){
		usuarios = new ArrayList<String>();
		usuarios.add("wilmer");
		usuarios.add("fernando");
		usuarios.add("kathy");
		
		contrasenas = new ArrayList<String>();
		contrasenas.add("w123");
		contrasenas.add("f456");
		contrasenas.add("k321");
	}
	
	@Test	
	public void datoscorrectos(){
		
		AutenticarControlador aunteti=new AutenticarControlador();
		    String resultado=aunteti.Auntenticar(usuarios.get(0),contrasenas.get(0));
			assertEquals("BIENVENIDO AL SISTEMA BENEDICTO XVI", resultado);
			System.out.println(resultado);
	}
	
	@Test	
	public void datosincorrectos(){
		
		AutenticarControlador aunteti=new AutenticarControlador();
		String resultado=aunteti.Auntenticar(usuarios.get(1),contrasenas.get(0));
		assertEquals("USUARIO O CONTRASEÑA ES INCORRECT0", resultado);
		System.out.println(resultado);
	}

	@Test
	public void datosvacios(){
		
		AutenticarControlador aunteti=new AutenticarControlador();
		String resultado=aunteti.Auntenticar("","");
		assertEquals("USUARIO Y CONTRASEÑA NO PUEDEN ESTAR VACIOS", resultado);
		System.out.println(resultado);
	}
	

}


package testDominio;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controlador.MaestroUsuario;

public class MaestroUsuarioTest
{

    List<String> codigo;
    List<String> dni;
    List<String> nombre;
    List<String> paterno;
    List<String> materno;
    List<String> email;
    List<String> creacion;
    List<String> cod_rol;
    List<String> password;
    List<String> estado;
	
    @Before
    public void inicio()
    {

    	codigo = new ArrayList<String>(); //OK
        codigo.add("101");
        codigo.add("102");
        codigo.add("103");
        codigo.add("104");
        codigo.add("105");
        
        dni = new ArrayList<String>(); //OK
        dni.add("46783465");
        dni.add("38412903");
        dni.add("04567342");
        dni.add("29346100");
        dni.add("52460232");
        
        nombre = new ArrayList<String>(); //OK
        nombre.add("Fernando");
        nombre.add("Maria");
        nombre.add("Miguel");
        nombre.add("Juan");
        nombre.add("Pedro");
        
        paterno = new ArrayList<String>(); //OK
        paterno.add("Garcia");
        paterno.add("Soto");
        paterno.add("Hinostroza");
        paterno.add("Dejo");
        paterno.add("Portales");
        
        materno = new ArrayList<String>(); //OK
        materno.add("Rojas");
        materno.add("Calle");
        materno.add("Rivas");
        materno.add("Neyra");
        materno.add("Burgos");
        
        email = new ArrayList<String>();
        email.add("fgarcia@uarm.edu.pe");
        email.add("msoto@uarm.edu.pe");
        email.add("mhinostroza@uarm.edu.pe");
        email.add("jdejo@uarm.edu.pe");
        email.add("pportales@uarm.edu.pe");
        
        creacion = new ArrayList<String>();
        creacion.add("21/07/12");
        creacion.add("21/07/12");
        creacion.add("21/07/12");
        creacion.add("21/07/12");
        creacion.add("21/07/12");
        
        cod_rol = new ArrayList<String>(); //OK
        cod_rol.add("345");
        cod_rol.add("756");
        cod_rol.add("406");
        cod_rol.add("254");
        cod_rol.add("125");
        
        password = new ArrayList<String>(); //OK
        password.add("101");
        password.add("102");
        password.add("103");
        password.add("104");
        password.add("105");
        
        estado = new ArrayList<String>(); //OK
        estado.add("Activo");
        estado.add("Inactivo");
        estado.add("Activo");
        estado.add("Inactivo");
        estado.add("Activo");
    }

    @Test
    public void estadoactivo()
    {
        MaestroUsuario maestrousuario = new MaestroUsuario();
        boolean resultado = maestrousuario.estadoactivo(1, (String)estado.get(0));
        assertEquals("Dato1:", Boolean.valueOf(true), Boolean.valueOf(resultado));
    }

    @Test
    public void estadoinactivo()
    {
        MaestroUsuario maestrousuario = new MaestroUsuario();
        boolean resultado = maestrousuario.estadoactivo(2, (String)estado.get(1));
        assertEquals("Dato2:", Boolean.valueOf(true), Boolean.valueOf(resultado));
    }

    @Test
    public void claves()
    {
        MaestroUsuario maestrousuario = new MaestroUsuario();
        boolean resultado = maestrousuario.numeros(1, (String)password.get(0));
        assertEquals("Dato3:", Boolean.valueOf(true), Boolean.valueOf(resultado));
    }

    @Test
    public void roles()
    {
        MaestroUsuario maestrousuario = new MaestroUsuario();
        boolean resultado = maestrousuario.numeros(2, (String)cod_rol.get(0));
        assertEquals("Dato4:", Boolean.valueOf(true), Boolean.valueOf(resultado));
    }


    @Test
    public void dni()
    {
        MaestroUsuario maestrousuario = new MaestroUsuario();
        boolean resultado = maestrousuario.numeros(4, (String)cod_rol.get(0));
        assertEquals("Dato5:", Boolean.valueOf(true), Boolean.valueOf(resultado));
    }

    @Test
    public void codigo()
    {
        MaestroUsuario maestrousuario = new MaestroUsuario();
        boolean resultado = maestrousuario.numeros(3, (String)cod_rol.get(0));
        assertEquals("Dato6:", Boolean.valueOf(true), Boolean.valueOf(resultado));
    }

    @Test
    public void materno()
    {
        MaestroUsuario maestrousuario = new MaestroUsuario();
        boolean resultado = maestrousuario.cadenas(materno.get(0));
        assertEquals("Dato7:", Boolean.valueOf(true), Boolean.valueOf(resultado));    
    }

    @Test
    public void paterno()
    {
        MaestroUsuario maestrousuario = new MaestroUsuario();
        boolean resultado = maestrousuario.cadenas(paterno.get(0));
        assertEquals("Dato8:", Boolean.valueOf(true), Boolean.valueOf(resultado));    
    }
    
    @Test
    public void nombre()
    {
        MaestroUsuario maestrousuario = new MaestroUsuario();
        boolean resultado = maestrousuario.cadenas(nombre.get(0));
        assertEquals("Dato9:", Boolean.valueOf(true), Boolean.valueOf(resultado));    
    }

    @Test
    public void email()
    {
        MaestroUsuario maestrousuario = new MaestroUsuario();
        boolean resultado = maestrousuario.correos(email.get(0));
        assertEquals("Dato9:", Boolean.valueOf(true), Boolean.valueOf(resultado));    
    }
    
}
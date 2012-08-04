package controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dominio.GrupoEstudio;
import dominio.Prospecto;
import dominio.Secuencia;

public class GrupoEstudioControlador {
	private List<GrupoEstudio> data;
	private String[] listOpciones = {"Agregar","Modificar","Eliminar","Buscar","Listar"};
	private String[] grupoFormulario = {"Codigo","Nombre","Descripción","Academia","Curso","Fecha de Inicio","Fecha de Fin","Estado","Instructor","Syllabus","Local","Aula","Latitud","Altitud"};

	
	public GrupoEstudioControlador() {
		data = new ArrayList<GrupoEstudio>();
		
	}

	public void loadTestData() {
		String codigo = null;

		// Datos de prueba
	
		codigo = agregar("Visual.NET","VB.NET","Academia Lima","VB.NET","2012-08-01","2012-10-30","0","Jose Diaz","syll001","Av.Alfonso Ugarte 123","B10","12°02 00 S","77°01 00 O");
		codigo = agregar("SQL 2010","SQL","Academia Lima","SQL","2012-08-01","2012-10-30","0","Raul Diaz","syll002","Av.Alfonso Ugarte 123","B20","12°02 00 S","77°01 00 O");
		codigo = agregar("Oracle 11","Oracle Administrator","Academia Lima","Oracle Administrator","2012-08-01","2012-10-30","0","Rommel Diaz","syll003","Av.Alfonso Ugarte 123","B30","12°02 00 S","77°01 00 O");
		codigo = agregar("Office 2010","Excel 2010 Avanzado","Academia Lima","Excel 2010","2012-08-01","2012-10-30","0","Pablo Diaz","syll004","Av.Alfonso Ugarte 123","B40","12°02 00 S","77°01 00 O");
		codigo = agregar("Office 2010","Word 2010 Avanzado","Academia Lima","Word 2010","2012-08-01","2012-10-30","0","Ernesto Diaz","syll005","Av.Alfonso Ugarte 123","B50","12°02 00 S","77°01 00 O");
		codigo = agregar("Office 2010","Powerpoint 2010 Avanzado","Academia Lima","Powerpoint 2010","2012-08-01","2012-10-30","0","Julio Diaz","syll006","Av.Alfonso Ugarte 123","B60","12°02 00 S","77°01 00 O");
		codigo = agregar("Office 2010","Outlook 2010 Avanzado","Academia Norte","Outlook 2010","2012-08-01","2012-10-30","0","Julio Diaz","syll006","Av.Alfonso Ugarte 123","B70","12°02 00 S","77°01 00 O");
		
	}
	
	
	public String agregar(String p_nombre, String p_descripcion,
			String p_academia, String p_curso, String p_fechainicio, String p_fechafin,
			String p_estado, String p_instructor, String p_syllabus, String p_local,
			String p_aula, String p_coordlatitud, String p_coordaltitud) {
		// Validar que cliente registre estos datos como mínimo
		if (p_nombre == null ||
			p_descripcion == null ||
			p_academia == null ||
			p_fechainicio == null) {
				// si no cumple, retornar * que significa error
				return "*****";
//				return false;
		}
		// Validar si son cadenas en blanco
		if (p_nombre.isEmpty() ||
				p_descripcion.isEmpty() ||
				p_academia.isEmpty() ||
				p_fechainicio.isEmpty()) {
			// si no cumple, retornar * que significa error
			return "*****";
//			return false;
		}


		String seq_codigo = null;		
		seq_codigo = Secuencia.get("GrupoEstudio");				
		boolean datosok = false;
		datosok = validarDatosGrupoEstudio(seq_codigo,p_nombre,p_fechainicio,p_fechafin);
		if (datosok == false){
//			return false;
			return "*****";			
		}

		GrupoEstudio p = new GrupoEstudio();

		System.out.println("Nombre:"+p_nombre);
//		p.setCodigo(p_codigo);
		p.setCodigo(seq_codigo);
		p.setNombre(p_nombre);
		p.setDescripcion(p_descripcion);
		p.setAcademia(p_academia);
		p.setCurso(p_curso);
		p.setFechainicio(p_fechainicio);
		p.setFechafin(p_fechafin);
		p.setEstado(p_estado);
		p.setInstructor(p_instructor);
		p.setSyllabus(p_syllabus);
		p.setLocal(p_local);
		p.setAula(p_aula);
		p.setCoordlatitud(p_coordlatitud);
		p.setCoordaltitud(p_coordaltitud);
		data.add(p);

//		return true; 
		// Retornar código autogenerado
		return seq_codigo;		
	}

	public boolean buscar(String p_campo, String p_valor) {
		if (p_campo.equals("nombre")) {
			for (GrupoEstudio p : data) {
				if (p.getNombre().equals(p_valor))
					return true;
			}
		}
		if (p_campo.equals("descripcion")) {
			for (GrupoEstudio p : data) {
				if (p.getDescripcion().equals(p_valor))
					return true;
			}
		}
		if (p_campo.equals("academia")) {
			for (GrupoEstudio p : data) {
				if (p.getAcademia().equals(p_valor))
					return true;
			}
		}
		if (p_campo.equals("curso")) {
			for (GrupoEstudio p : data) {
				if (p.getCurso().equals(p_valor))
					return true;
			}
		}
		if (p_campo.equals("fechainicio")) {
			for (GrupoEstudio p : data) {
				if (p.getFechainicio().equals(p_valor))
					return true;
			}
		}
		if (p_campo.equals("fechafin")) {
			for (GrupoEstudio p : data) {
				if (p.getFechafin().equals(p_valor))
					return true;
			}
		}
		if (p_campo.equals("estado")) {
			for (GrupoEstudio p : data) {
				if (p.getEstado().equals(p_valor))
					return true;
			}
		}
		
		
		return false;
		
	}

	public boolean listar() {
		System.out.println(GrupoEstudio.cabecera());
		for (GrupoEstudio p : data) {
			System.out.println(p);
		}
		
		return true;
	}
	
	public boolean validarDatosGrupoEstudio(String p_codigo, String p_nombre,String p_fechainicio, String p_fechafin){
		if (p_codigo == null || p_codigo.isEmpty()){
			System.out.println("Debe ingresar código de grupo de estudio");
			return false;
        }
		if (p_nombre == null || p_nombre.isEmpty()){
			System.out.println("Debe ingresar nombre de grupo de estudio");
			return false;
        }		
		if (p_fechainicio == null || p_fechainicio.isEmpty()){
			System.out.println("Debe ingresar fecha de inicio de grupo de estudio");
			return false;
        }		
		if (p_fechafin == null || p_fechafin.isEmpty()){
			System.out.println("Debe ingresar fecha de fin de grupo de estudio");
			return false;
        }		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //año-mes-dia
		if (p_fechainicio.trim().length() != dateFormat.toPattern().length()){
			System.out.println("Debe ingresar fecha de inicio en el formato AAAA-MM-DD");
			return false;  
		}
		if (p_fechafin.trim().length() != dateFormat.toPattern().length()){
			System.out.println("Debe ingresar fecha de fin en el formato AAAA-MM-DD");
			return false;  		
		}
		
		
		try {  
			dateFormat.parse(p_fechainicio.trim());
			dateFormat.parse(p_fechafin.trim());
			if (dateFormat.parse(p_fechainicio).compareTo(dateFormat.parse(p_fechafin)) >= 0 ) {
				System.out.println("Fecha de inicio debe ser menor que Fecha de fin");
				return false;  		
			}			
			}  
			catch (ParseException pe) {  
				System.out.println("Debe ingresar fecha en el formato AAAA-MM-DD");				
			return false;  
			}  
		return true;	
		
	}
	public void menu() {
        try
        {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String read_opcion = "";
	    int numero = 0;
		do {
			System.out.println("Instituto Benedicto XVI");
			System.out.println("=======================");
			System.out.println("Menu de Grupos de estudio\n");
			
			numero = 0;
			for (String opciones : listOpciones) {
				System.out.println(++numero + ". "+opciones);
			}
			System.out.println("0. Salir");
			System.out.println("Ingrese su opcion : ");
			read_opcion = in.readLine();
		    numero = Integer.parseInt(read_opcion);
		    numero = Integer.parseInt(read_opcion);
		    switch (numero) {
		    case 1:
		    	agregarFormulario();
		    	break;
		    case 2:
//		    	agregarFormulario();
		    	break;
		    	
		    case 5:
		    	listar();
		    	break;
		    case 0:
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
	public void formulario() {
		int numero = 0;
		for (String formulario : grupoFormulario) {
			System.out.println(++numero + ". "+formulario);
		}
		System.out.println("0. Salir");
	}
	
	public void agregarFormulario() {
        try
        {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int numero = 0;
		String dato = "";
		GrupoEstudio p = new GrupoEstudio();
		for (String formulario : grupoFormulario) {
			
			++numero;
			System.out.println("Ingrese " + numero + ". "+formulario+" : ");
			dato = in.readLine();
			switch (numero) {
				case 1: 
					p.setCodigo(dato);
					break;
				case 2:
					p.setNombre(dato);
					break;
				case 3:
					p.setDescripcion(dato);
					break;
				case 4:
					p.setAcademia(dato);
					break;
				case 5:
					p.setCurso(dato);
					break;
				case 6:
					p.setFechainicio(dato);
					break;
				case 7:
					p.setFechafin(dato);
					break;
				case 8:
					p.setEstado(dato);
					break;
				case 9:
					p.setInstructor(dato);
					break;
				case 10:
					p.setSyllabus(dato);
					break;
				case 11:
					p.setLocal(dato);
					break;
				case 12:
					p.setAula(dato);
					break;
				case 13:
					p.setCoordlatitud(dato);
					break;
				case 14:
					p.setCoordaltitud(dato);
					break;
				default:
					break;
			}
		}
		data.add(p);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

	}

}

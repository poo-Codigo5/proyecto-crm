package controlador;

//import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dominio.GrupoEstudio;
import dominio.Prospecto;

public class GrupoEstudioControlador {
	private List<GrupoEstudio> data;
	
	public GrupoEstudioControlador() {
		data = new ArrayList<GrupoEstudio>();
		
	}

	public boolean agregar(String p_codigo, String p_nombre, String p_descripcion,
			String p_academia, String p_curso, String p_fechainicio, String p_fechafin,
			String p_estado, String p_instructor, String p_syllabus, String p_local,
			String p_aula, String p_coordlatitud, String p_coordaltitud) {

		boolean datosok = false;
		datosok = validarDatosGrupoEstudio(p_codigo,p_nombre,p_fechainicio,p_fechafin);
		if (datosok == false){
			return false;
		}
		
		GrupoEstudio p = new GrupoEstudio();
		System.out.println("Nombre:"+p_nombre);
		p.setCodigo(p_codigo);
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

		return true; 
	}

	public boolean buscar(String p_campo, String p_valor) {
		if (p_campo.equals("nombre")) {
			for (GrupoEstudio p : data) {
				if (p.getNombre().equals(p_valor))
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

}

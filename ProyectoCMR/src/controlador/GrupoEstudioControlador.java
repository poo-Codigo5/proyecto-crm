package controlador;

//import java.util.ArrayList;
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

}

package controlador;
import java.util.ArrayList;
import java.util.List;

import dominio.Roles;

public class RolesControlador {
	
	private List<Roles> data;
	
	public RolesControlador() {
		data = new ArrayList<Roles>();
	}
	public boolean agregar(String p_codigo, String p_descripcion, String p_permisos) {
		Roles r = new Roles();
		System.out.println("Codigo:" + p_codigo);
		r.setCodigo(p_codigo);
		
		System.out.println("Descripción: " + r.getDescripcion());
		r.setDescripcion(p_descripcion);

		System.out.println("Permisos:" + p_permisos);
		r.setPermisos(p_permisos);

		data.add(r);
		return true;
	}

	public boolean buscar(String p_campo, String p_valor) {
		// TODO Auto-generated method stub
		if (p_campo.equals("codigo")) {
			for (Roles r : data) {
				if (r.getCodigo().equals(p_valor))
					return true;
			}
		}
		return false;
	}

	public boolean listar() {
		System.out.println(Roles.listado());
		for (Roles r : data) {
			System.out.println(r);
		}
		return true;
	}
}


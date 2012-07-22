package controlador;
import java.util.ArrayList;
import java.util.List;

import dominio.Prospecto;

public class ProspectoControlador {
	private List<Prospecto> data;
	
	public ProspectoControlador() {
		data = new ArrayList<Prospecto>();
	}
	public boolean agregar(String p_codigo, String p_nombres, String p_apellidoPaterno, String p_apellidoMaterno,
			String p_eMail, String p_DNI, String p_telefono, String p_fechaContacto) {
		Prospecto p = new Prospecto();
		System.out.println("Nombres:"+p_nombres);
		p.setCodigo(p_codigo);
		p.setNombres(p_nombres);
		System.out.println("Nombres:"+p.getNombres());
		p.setApellidoPaterno(p_apellidoPaterno);
		p.setApellidoMaterno(p_apellidoMaterno);
		p.setDNI(p_DNI);
		p.setEMail(p_eMail);
		p.setTelefono(p_telefono);
		p.setFechaContacto(p_fechaContacto);
		data.add(p);
		return true;
	}

	public boolean buscar(String p_campo, String p_valor) {
		if (p_campo.equals("nombres")) {
			for (Prospecto p : data) {
				if (p.getNombres().equals(p_valor))
					return true;
			}
		}
		return false;
	}
	public boolean listar() {
		System.out.println(Prospecto.cabecera());
		for (Prospecto p : data) {
			System.out.println(p);
		}
		return true;
	}
}

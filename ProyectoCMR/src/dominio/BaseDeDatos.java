package dominio;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
	public List<Cliente> clienteTab;
	public List<Prospecto> prospectoTab;
	public List<Usuario> usuarioTab;
	
	public BaseDeDatos() {
		clienteTab = new ArrayList<Cliente>();
		prospectoTab = new ArrayList<Prospecto>();
		usuarioTab = new ArrayList<Usuario>();
	}
	
	public void add(Cliente clienteRegistro) {
		clienteTab.add(clienteRegistro);
	}
	public void add(Prospecto prospectoRegistro) {
		prospectoTab.add(prospectoRegistro);
	}
	public void add(Usuario usuarioRegistro) {
		usuarioTab.add(usuarioRegistro);
	}
	public Prospecto get(String codigo) {
		Prospecto ret = null;
		for (Prospecto p : prospectoTab) {
			if (p.getDNI().compareTo(codigo) == 0) {
				ret = p;
				break;
			}
		}
		return ret;
	}
}

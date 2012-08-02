package dominio;

public class Roles {
	private String codigo;
	private String descripcion;
	private String permisos;

	public Roles(){
		this.codigo="";
		this.descripcion="";
		this.permisos="";
	}
	public void setCodigo(String p_codigo) {
		this.codigo = p_codigo;
	}
	
	public void setDescripcion(String p_descripcion) {
		this.descripcion = p_descripcion;
	}
	public void setPermisos(String p_permisos) {
		this.permisos = p_permisos;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	public String getDescripcion() {
		return this.descripcion;
	}

	public String getPermisos() {
		return this.permisos;
	}
	
	
	static public String listado() {
		String formato1 = "%1$-5s";
		String formato2 = "%1$-15s";
		String formato3 = "%1$-30s";

		return "| " + String.format(formato1, "Codigo")+
			   "| " + String.format(formato2, "Descripción")+
			   "| " + String.format(formato2, "Permisos")+
			   "|";
	}
	@Override
	public String toString() {
		String formato1 = "%1$-5s";
		String formato2 = "%1$-15s";
		String formato3 = "%1$-30s";

		return "| " + String.format(formato1, this.codigo)+
			   "| " + String.format(formato2, this.descripcion)+
			   "| " + String.format(formato2, this.permisos)+
			   "|";
	}	

}

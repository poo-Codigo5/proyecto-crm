package dominio;

public class Prospecto {
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String eMail;
	private String DNI;
	private String telefono;
	private String fechaContacto;
	
	public Prospecto() {
		this.nombres = "";
		this.apellidoPaterno = "";
		this.apellidoMaterno = "";
		this.eMail = "";
		this.DNI = "";
		this.telefono = "";
		this.fechaContacto = "";
	}
	public void setNombres(String p_nombres) {
		this.nombres = p_nombres;
	}
	public void setApellidoPaterno(String p_apellidoPaterno) {
		this.apellidoPaterno = p_apellidoPaterno;
	}
	public void setApellidoMaterno(String p_apellidoMaterno) {
		this.apellidoMaterno = p_apellidoMaterno;
	}
	public void setEMail(String p_eMail) {
		this.eMail = p_eMail;
	}
	public void setDNI(String p_DNI) {
		this.DNI = p_DNI;
	}
	public void setTelefono(String p_telefono) {
		this.telefono = p_telefono;
	}
	public void setFechaContacto(String p_fechaContacto) {
		this.fechaContacto = p_fechaContacto;
	}
	
	public String getNombres() {
		return this.nombres;
	}
	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}
	public String getEMail() {
		return this.eMail;
	}
	public String getDNI() {
		return this.DNI;
	}
	public String getTelefono() {
		return this.telefono;
	}
	public String getFechaContacto() {
		return this.fechaContacto;
	}
	
}

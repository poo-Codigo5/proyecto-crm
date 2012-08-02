package dominio;

public class Usuario {
       private String codigo;
       private String dni;
       private String nombre;
       private String paterno;
       private String materno;
       private String email;
       private String creacion;
       private String cod_rol;
       private String password;
       private String estado;
       
       public Usuario()
       {
           this.codigo=" ";
           this.dni=" ";
           this.nombre=" ";
           this.paterno=" ";
           this.materno=" ";
           this.email=" ";
           this.creacion=" ";
           this.cod_rol=" ";
           this.password=" ";
           this.estado=" ";
    	   
       }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreacion() {
		return creacion;
	}

	public void setCreacion(String creacion) {
		this.creacion = creacion;
	}

	public String getCod_rol() {
		return cod_rol;
	}

	public void setCod_rol(String cod_rol) {
		this.cod_rol = cod_rol;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	static public String cabecera() {
		String formato1 = "%1$-5s";
		String formato2 = "%1$-15s";
		String formato3 = "%1$-30s";
		String formato4 = "%1$-8s";

		return "| " + String.format(formato1, "Codigo")+
			   "| " + String.format(formato2, "Nombre")+
			   "| " + String.format(formato2, "Paterno")+
			   "| " + String.format(formato2, "Materno")+
			   "| " + String.format(formato4, "DNI")+			   
			   "| " + String.format(formato3, "Correo")+
			   "| " + String.format(formato4, "Fecha")+			   
			   "| " + String.format(formato1, "Rol")+
			   "| " + String.format(formato2, "Password")+
			   "| " + String.format(formato2, "Estado")+
			   "|";
	}
	
	@Override
	public String toString() {
		String formato1 = "%1$-5s";
		String formato2 = "%1$-15s";
		String formato3 = "%1$-30s";
		String formato4 = "%1$-8s";

		return "| " + String.format(formato1, this.codigo)+
			   "| " + String.format(formato2, this.nombre)+
			   "| " + String.format(formato2, this.paterno)+
			   "| " + String.format(formato2, this.materno)+
			   "| " + String.format(formato4, this.dni)+			   
			   "| " + String.format(formato3, this.email)+
			   "| " + String.format(formato4, this.creacion)+
			   "| " + String.format(formato1, this.cod_rol)+			   
			   "| " + String.format(formato2, this.password)+
			   "| " + String.format(formato4, this.estado)+
			   "|";
	}
	
}

package dominio;

public class GrupoEstudio {
	private String codigo;
	private String nombre;
	private String descripcion;
	private String academia;
	private String curso;
	private String fechainicio;
	private String fechafin;
	private String estado;
	private String instructor;
	private String syllabus;
	private String local;
	private String aula;
	private String coordlatitud;
	private String coordaltitud;
	
	
	public GrupoEstudio() {
		this.codigo="";
		this.nombre="";
		this.descripcion="";
		this.academia="";
		this.curso="";
		this.fechainicio="";
		this.fechafin="";
		this.estado="";
		this.instructor="";
		this.syllabus="";
		this.local="";
		this.aula="";
		this.coordlatitud="";
		this.coordaltitud="";
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getAcademia() {
		return academia;
	}


	public void setAcademia(String academia) {
		this.academia = academia;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public String getFechainicio() {
		return fechainicio;
	}


	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}


	public String getFechafin() {
		return fechafin;
	}


	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	public String getSyllabus() {
		return syllabus;
	}


	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public String getAula() {
		return aula;
	}


	public void setAula(String aula) {
		this.aula = aula;
	}


	public String getCoordlatitud() {
		return coordlatitud;
	}


	public void setCoordlatitud(String coordlatitud) {
		this.coordlatitud = coordlatitud;
	}


	public String getCoordaltitud() {
		return coordaltitud;
	}


	public void setCoordaltitud(String coordaltitud) {
		this.coordaltitud = coordaltitud;
	}


	public static String cabecera() {
		String formato1 = "%1$-5s";
		String formato2 = "%1$-15s";
		String formato3 = "%1$-30s";

		return "| " + String.format(formato1, "Codigo")+
			   "| " + String.format(formato2, "Nombre")+
			   "| " + String.format(formato3, "Descripcion")+
			   "| " + String.format(formato2, "Academia")+
			   "| " + String.format(formato3, "Curso")+
			   "| " + String.format(formato2, "Fecha inicio")+
			   "| " + String.format(formato2, "Fecha fin")+
			   "| " + String.format(formato2, "Estado")+
			   "| " + String.format(formato2, "Instructor")+
			   "| " + String.format(formato2, "Syllabus")+
			   "| " + String.format(formato2, "Local")+
			   "| " + String.format(formato2, "Aula")+
			   "| " + String.format(formato2, "Latitud")+
			   "| " + String.format(formato2, "Altitud")+
			   "|";

	}
	
	@Override
	public String toString() {
		String formato1 = "%1$-5s";
		String formato2 = "%1$-15s";
		String formato3 = "%1$-30s";

		return "| " + String.format(formato1, this.codigo)+
				   "| " + String.format(formato2, this.nombre)+
				   "| " + String.format(formato3, this.descripcion)+
				   "| " + String.format(formato2, this.academia)+
				   "| " + String.format(formato3, this.curso)+
				   "| " + String.format(formato2, this.fechainicio)+
				   "| " + String.format(formato2, this.fechafin)+
				   "| " + String.format(formato2, this.estado)+
				   "| " + String.format(formato2, this.instructor)+
				   "| " + String.format(formato2, this.syllabus)+
				   "| " + String.format(formato2, this.local)+
				   "| " + String.format(formato2, this.aula)+
				   "| " + String.format(formato2, this.coordlatitud)+
				   "| " + String.format(formato2, this.coordaltitud)+
				   "|";

	}

}

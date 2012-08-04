package controlador;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dominio.Prospecto;
import dominio.Secuencia;

public class ProspectoControlador {
	private List<Prospecto> data;
	private String[] listOpciones = {"Agregar","Modificar","Eliminar","Buscar","Listar"};
	private String[] prospectoFormulario = {"Codigo","Nombres","Apellido Paterno","Apellido Materno","Correo electrónico","DNI","Teléfono","Fecha Contacto"};
	private String[] prospectoFiltroCol = {"codigo","nombres","apellidoPaterno","apellidoMaterno","eMail","DNI","telefono","fechaContacto"};
	private String[] prospectoFiltroVal = {null    ,null     ,null             ,null             ,null   ,null ,null      ,null};
	private String ultimoMensaje;
	
	public ProspectoControlador() {
		data = new ArrayList<Prospecto>();
	}
	
	public void loadTestData() {
		String codigo = null;

		// Datos de prueba
		codigo = agregar("Juan","Perez","Rojas","juanperez@hotmail.com","16201123","720-1221","2012/01/01");
		codigo = agregar("Maria","Ocaña","Rios","mariaocana@hotmail.com","12345667","720-1222","2012/05/07");
		codigo = agregar("Gabriel","Osorio","Iriarte","gabrielosorio@hotmail.com","87654321","720-1223","2012/06/15");
		codigo = agregar("Raul","Quispe","Mendizabal","raulquispe@msn.com","87654321","720-1222","2012/04/21");
		codigo = agregar("Miguel","Huaman","Flor","miguelhuaman@msn.com","12345667","720-1224","2012/01/18");
		codigo = agregar("Karina","Pita","Branco","karinapita@gmail.com","16201123","720-1222","2012/07/22");
		codigo = agregar("Olga","Julca","Zambrano","olgajulca@gmail.com","87654321","720-1225","2012/05/28");
		codigo = agregar("Susana","Chavez","Garcia","susanachavez@yahoo.com","16201123","720-1222","2012/03/09");
		codigo = agregar("Mariela","Ugarte","Velez","marielaugarte@yahoo.com","12345667","720-1226","2012/11/24");
	}
	
	// Agregar un nuevo Prospecto, autogenerar el código
	public String agregar(String p_nombres, String p_apellidoPaterno, String p_apellidoMaterno,
			String p_eMail, String p_DNI, String p_telefono, String p_fechaContacto) {
		// Validar que cliente registre estos datos como mínimo
		if (p_nombres == null ||
			p_apellidoPaterno == null ||
			p_apellidoMaterno == null ||
			p_eMail == null) {
				// si no cumple, retornar * que significa error
				return "*****";
		}
		// Validar si son cadenas en blanco
		if (p_nombres.isEmpty() ||
				p_apellidoPaterno.isEmpty() ||
				p_apellidoMaterno.isEmpty() ||
				p_eMail.isEmpty()) {
			// si no cumple, retornar * que significa error
			return "*****";
		}
		// Registrar datos de cliente
		Prospecto p = new Prospecto();
		String seq_codigo = null;
		seq_codigo = Secuencia.get("Prospecto");
		p.setCodigo(seq_codigo);
		p.setNombres(p_nombres);
		p.setApellidoPaterno(p_apellidoPaterno);
		p.setApellidoMaterno(p_apellidoMaterno);
		p.setEMail(p_eMail);
		p.setDNI(p_DNI);
		p.setTelefono(p_telefono);
		p.setFechaContacto(p_fechaContacto);
		
		// Añadir a lista de clientes
		data.add(p);
//		System.out.println(p);
//		System.out.println("Clientes:"+data.size());
		
		// Retornar código autogenerado
		return seq_codigo;
	}
	
	// Eliminar el filtro
	public void resetFiltro() {
		for (int i=0; i<prospectoFiltroCol.length; i++) {
			prospectoFiltroVal[i] = null;
		}
	}
	
	// Definir los filtros para la busqueda
	public void setFiltro(String p_campo, String p_valor) {
		int i = 0;
		// Recorrer las columnas a filtrar
		for (String p : prospectoFiltroCol) {
			// Si se encuentra la columna del filtro
			if (p.equals(p_campo)) {
				// Asignar el valor a filtrar
				prospectoFiltroVal[i] = p_valor;
			}
			i++;
		}
	}
	
	// Listado de Prospectos filtrados segun filtros definidos
	public boolean listar() {
		int numero = 1;
		boolean retorno = false;
		
		// Ordenar los datos por Fecha de Contacto
		Collections.sort(data, new ProspectoFechaContactoComparator());
		
		// Mostrar la cabecera del listado
		System.out.println(String.format("%1$02d", numero) + ". "+Prospecto.cabecera());
		
		// Leer todos los registros
		for (Prospecto p : data) {
			if (p.coincide(prospectoFiltroVal)) {
				System.out.println(String.format("%1$02d", numero) + ". "+p);
				numero++;
				retorno = true;
			}
		}
		// Si no se muestra ningún registro, guardar un mensaje
		if (!retorno)
			setUltimoMensaje("No se encontraron prospectos segun los criterios especificados");
		return retorno;
	}
	
	public void setUltimoMensaje(String p_ultimoMensaje) {
		this.ultimoMensaje = p_ultimoMensaje;
	}
	
	// Mostrar menú del formulario
	public void menu() {
	    String read_opcion = null;
	    int numero = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));        	
		do {
			System.out.println("Instituto Benedicto XVI");
			System.out.println("=======================");
			System.out.println("Menu de Prospectos\n");
			
			numero = 0;
			for (String opciones : listOpciones) {
				System.out.println(++numero + ". "+opciones);
			}
			System.out.println("0. Salir");
			System.out.println("Ingrese su opcion : ");
			try {
				read_opcion = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    numero = Integer.parseInt(read_opcion);
		    switch (numero) {
		    case 1:
		    	agregarFormulario();
		    	break;
		    case 2:
		    	modificarFormulario();
		    	break;
		    case 3:
		    	eliminarFormulario();
		    	break;
		    case 4:
		    	buscarFormulario();
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
	
	// Buscar registros de acuerdo a un filtro asignado
	private void buscarFormulario() {
		int numero = 0;
		int codigo = 0;
		String dato = null;
		
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        // Limpiar los filtros existentes
		resetFiltro();
        // Mostrar los campos que se desea filtrar
		for (String formulario : prospectoFormulario) {
			// Ingresar el filtro
			System.out.print(numero + ". "+formulario+" : ");
			try {
				dato = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Si el campo se indica en blanco, se ignora el filtro
			if (dato != null && !dato.isEmpty()) {
				switch (numero) {
					case 0 :
						codigo = Integer.parseInt(dato);
						dato = String.format("%1$05d", codigo);
						break;
					default :
						break;
				}
				// Asignar el filtro a buscar
				setFiltro(prospectoFiltroCol[numero], dato);
			}
			numero ++;
		}
		// Mostrar datos filtrados
		listar();
	}
	
	// Desplegar formulario para eliminar un registro
	private void eliminarFormulario() {
		int index = 0;
		String dato = null;
		
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        // Mostrar los registros que se pueden eliminar
        resetFiltro();
		listar();
		System.out.println("0. Retornar");
		
		// Seleccionar registro a eliminar
		// Capturar opcion del usuario
		System.out.print("Eliminar registro # : ");
		try {
			dato = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    index = Integer.parseInt(dato);
		
	    // En caso el usuario desee regresar
	    if (index == 0)
	    	return;
	    
		// Eliminar registro
	    data.remove(index - 1);
	}
	
	// Desplegar formulario para modificar un registro
	private void modificarFormulario() {
		int numero = 0;
		int index = 0;
		String dato = null;
		String datoAnterior = null;
		Prospecto p = null;
		
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));        	
		
        // Mostrar los registros que se pueden modificar
        resetFiltro();
		listar();
		System.out.println("0. Retornar");
		
		// Capturar opcion del usuario
		System.out.print("Modificar registro # : ");
		try {
			dato = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    index = Integer.parseInt(dato);
	    
	    // En caso el usuario desee regresar
	    if (index == 0)
	    	return;
	    
	    // Ubicar el registro en el arreglo
		p = data.get(index - 1);
		
		numero = 0;
		// Barrer los elementos del formulario para modificarlos
		for (String formulario : prospectoFormulario) {
			switch (numero) {
				case 0: // Ignorar la modificación del código
					break;
				case 1:
					dato = p.getNombres();
					break;
				case 2:
					dato = p.getApellidoPaterno();
					break;
				case 3:
					dato = p.getApellidoMaterno();
					break;
				case 4:
					dato = p.getEMail();
					break;
				case 5:
					dato = p.getDNI();
					break;
				case 6:
					dato = p.getTelefono();
					break;
				case 7:
					dato = p.getFechaContacto();
					break;
				default:
					break;
			}
			// No se puede modificar el codigo
			if (numero > 0) {
				// Preservar el valor anterior
				datoAnterior = dato;
				// Solicitar el valor a modificar
				System.out.print(numero + ". "+formulario+"=["+dato+"] :");
				try {
					dato = in.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Si no ingresó ningún valor, se asume que preserva el anterior
				if (dato == null || dato.isEmpty()) {
					dato = datoAnterior;
				}
			}
			// De acuerdo al campo del formulario
			switch (numero) {
				case 0: // Ignorar la modificación del código
					break;
				case 1:
					p.setNombres(dato);
					break;
				case 2:
					p.setApellidoPaterno(dato);
					break;
				case 3:
					p.setApellidoMaterno(dato);
					break;
				case 4:
					p.setEMail(dato);
					break;
				case 5:
					p.setDNI(dato);
					break;
				case 6:
					p.setTelefono(dato);
					break;
				case 7:
					p.setFechaContacto(dato);
					break;
				default:
					break;
			}
			numero ++;
		}
		// Actualizar registro modificado
		data.set(index - 1, p);
	}
	
	// Mostrar formulario en blanco
	public void formulario() {
		int numero = 0;
		for (String formulario : prospectoFormulario) {
			System.out.println(++numero + ". "+formulario);
		}
		System.out.println("0. Salir");
	}
	
	// Mostrar formulario para agregar datos
	public void agregarFormulario() {
		int numero = 0;
		String dato = null;
		Prospecto p = new Prospecto();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        // Mostrar los campos a ingresar
		for (String formulario : prospectoFormulario) {
			// Ignorar el ingreso del código, se asignará automáticamente
			if (numero > 0) {
				System.out.print(numero + ". "+formulario+" : ");
				try {
					dato = in.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// Asignar los valores de acuerdo al campo ingresado
			switch (numero) {
				case 0: // Ignorar el codigo, se asignará automáticamente
					break;
				case 1:
					p.setNombres(dato);
					break;
				case 2:
					p.setApellidoPaterno(dato);
					break;
				case 3:
					p.setApellidoMaterno(dato);
					break;
				case 4:
					p.setEMail(dato);
					break;
				case 5:
					p.setDNI(dato);
					break;
				case 6:
					p.setTelefono(dato);
					break;
				case 7:
					p.setFechaContacto(dato);
					break;
				default:
					break;
			}
			numero ++;
		}
		// Todos los datos se han ingresado, asignar el código
		String seq_codigo = null;
		seq_codigo = Secuencia.get("Prospecto");
		p.setCodigo(seq_codigo);
		System.out.println("0. "+prospectoFormulario[0]+": "+seq_codigo);
		
		// Agregar registro
		data.add(p);
	}
	
	public boolean autorizado() {
		
		return true;
	}
	public String getUltimoMensaje() {
		return this.ultimoMensaje;
	}
}

class ProspectoFechaContactoComparator implements Comparator { 

public int compare(Object o1, Object o2) { 
        Prospecto p1 = (Prospecto) o1; 
        Prospecto p2 = (Prospecto)o2; 
        return p1.getFechaContacto(). 
                compareTo(p2.getFechaContacto()); 

    } 
} 
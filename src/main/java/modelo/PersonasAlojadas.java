package modelo;


/**
 * Este objeto se encarga de almacenar toda la informacion necesaria para registrar y logear a los clientes
 */
public class PersonasAlojadas extends Cliente{
	
	/**
	 * Constructor vacio del objeto PersonasAlojadas
	 */
	public PersonasAlojadas() {
		
	}
	
	public PersonasAlojadas(String dni, String nombre, String apellidos) {
		super(dni, nombre, apellidos);
	}
}
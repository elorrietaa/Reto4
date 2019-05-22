package modelo;

import java.sql.Date;

/**
 * Este objeto se encarga de almacenar toda la informacion de las
 * PersonasAlojadas
 */
public class PersonasAlojadas extends Cliente {

    /**
     * Constructor vacio del objeto PersonasAlojadas
     */
    public PersonasAlojadas() {

    }

    public PersonasAlojadas(String dni, String nombre, String apellidos, Date fechaNacimiento) {
	super(dni, nombre, apellidos);
    }
}
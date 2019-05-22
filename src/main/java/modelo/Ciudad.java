package modelo;

/**
 * 
 * @author IN1DM3B_09
 *
 */
public class Ciudad {
    private int codCiudad;
    private String nombreCiudad;

    /**
     * Constructor del objeto Ciudad vacio
     */
    public Ciudad() {

    }

    /**
     * Constructor del objeto Ciudad
     * 
     * @param codCiudad    codigo ciudad del objeto ciudad
     * @param nombreCiudad nombre de la ciudad
     */
    public Ciudad(int codCiudad, String nombreCiudad) {
	this.codCiudad = codCiudad;
	this.nombreCiudad = nombreCiudad;
    }

    /**
     * Getter del códigociudad = es un atributo del objeto Ciudad
     * 
     * @return codCiudad es un atributo del objeto Ciudad
     */
    public int getCodCiudad() {
	return codCiudad;
    }

    /**
     * Setter del códigoCiudad
     * 
     * @param codCiudad es un atributo del objeto Ciudad
     */
    public void setCodCiudad(int codCiudad) {
	this.codCiudad = codCiudad;
    }

    /**
     * Getter del nombreCiudad = es un atributo del objeto Ciudad
     * 
     * @return nombreCiudad es un atributo del objeto Ciudad
     */
    public String getNombreCiudad() {
	return nombreCiudad;
    }

    /**
     * Setter del nombreCiudad
     * 
     * @param nombreCiudad es un atributo del objeto Ciudad
     */
    public void setNombreCiudad(String nombreCiudad) {
	this.nombreCiudad = nombreCiudad;
    }

    /**
     * toString del nombre de la ciudad
     */
    public String toString() {
	return this.nombreCiudad;
    }

}

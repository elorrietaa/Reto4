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
     * @param codCiudad
     * @param nombreCiudad
     */
    public Ciudad(int codCiudad, String nombreCiudad) {
	this.codCiudad = codCiudad;
	this.nombreCiudad = nombreCiudad;
    }
    /**
     * Getter del códigociudad = es un atributo del objeto Ciudad 
     * @return codCiudad
     */
    public int getCodCiudad() {
        return codCiudad;
    }
    /**
     * Setter del códigoCiudad
     * @param codCiudad 
     */
    public void setCodCiudad(int codCiudad) {
        this.codCiudad = codCiudad;
    }
    /**
     * Getter del nombreCiudad = es un atributo del objeto Ciudad
     * @return nombreCiudad
     */
    public String getNombreCiudad() {
        return nombreCiudad;
    }
    /**
     * Setter del  nombreCiudad
     * @param nombreCiudad
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

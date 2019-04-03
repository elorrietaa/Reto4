package modelo;
/**
 * 
 * @author IN1DM3B_09
 *
 */
public class Ciudad {
    private int codCiudad;
    private String nombreCiudad;
    
    public Ciudad() {
	
    }
    /**
     * Constructor ciudades
     * @param codCiudad
     * @param nombreCiudad
     */
    public Ciudad(int codCiudad, String nombreCiudad) {
	this.codCiudad = codCiudad;
	this.nombreCiudad = nombreCiudad;
    }
    public int getCodCiudad() {
        return codCiudad;
    }
    public void setCodCiudad(int codCiudad) {
        this.codCiudad = codCiudad;
    }
    public String getNombreCiudad() {
        return nombreCiudad;
    }
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    
    
    
}

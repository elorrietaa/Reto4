package controlador;

/**
 * Clase Ciudad
 * Atributos: codCiudad, nombreCiudad
 * @author IN1DM3B_09
 *
 */
public class Ciudad {
    //atributos
    private int codCiudad;
    private String nombreCiudad;
   
    //constructor
     public Ciudad(int codCiudad, String nombreCiudad) {
	this.codCiudad = codCiudad;
	this.nombreCiudad = nombreCiudad;
    }

     //get y set
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

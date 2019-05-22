package modelo;

/**
 * Clase Habitacion = contiene información referente a la habitación
 * 
 * @author alba
 *
 */
public class Habitacion {
    protected int codHabitacion;
    protected String tipoHabitacion;
    protected float tamanio;

    /**
     * Constructor vacio:
     */
    public Habitacion() {

    }

    /**
     * Constructor clase Habitacion
     * 
     * @param codHabitacion  contiene el codigo de la habitacion seleccionada
     * @param tipoHabitacion contiene el tipo de habitacion
     * @param tamanio        contiene el tamanio de la habitacion
     */
    public Habitacion(int codHabitacion, String tipoHabitacion, float tamanio) {
	this.codHabitacion = codHabitacion;
	this.tipoHabitacion = tipoHabitacion;
	this.tamanio = tamanio;

    }

    // get y set
    public int getCodHabitacion() {
	return codHabitacion;
    }

    public void setCodHabitacion(int codHabitacion) {
	this.codHabitacion = codHabitacion;
    }

    public String getTipoHabitacion() {
	return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
	this.tipoHabitacion = tipoHabitacion;
    }

    public float getTamanio() {
	return tamanio;
    }

    public void setTamanio(float tamanio) {
	this.tamanio = tamanio;
    }

}

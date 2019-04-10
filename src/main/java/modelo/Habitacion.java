package modelo;
/**
 * Clase habitación, contiene informacion referente a la habitacion
 * @author alba
 *
 */
public class Habitacion {
	protected int codHabitacion;
	protected Alojamiento alojamiento;
	protected String tipoHabitacion;
	protected float tamanio;
	protected int numCamas;
	protected String estadoHabitacion;
	
	//constructor vacio 
	public Habitacion(){
		
	}
	/**
	 * Constructor clase habitación
	 * @param codHabitacion
	 * @param alojamiento
	 * @param tipoHabitacion
	 * @param tamanio
	 * @param numCamas
	 * @param estadoHabitacion
	 */
	public Habitacion(int codHabitacion, Alojamiento alojamiento, String tipoHabitacion, float tamanio, int numCamas,
			String estadoHabitacion) {
		this.codHabitacion = codHabitacion;
		this.alojamiento = alojamiento;
		this.tipoHabitacion = tipoHabitacion;
		this.tamanio = tamanio;
		this.numCamas = numCamas;
		this.estadoHabitacion = estadoHabitacion;
	}

	public int getCodHabitacion() {
		return codHabitacion;
	}

	public void setCodHabitacion(int codHabitacion) {
		this.codHabitacion = codHabitacion;
	}

	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
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

	public int getNumCamas() {
		return numCamas;
	}

	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	public String getEstadoHabitacion() {
		return estadoHabitacion;
	}

	public void setEstadoHabitacion(String estadoHabitacion) {
		this.estadoHabitacion = estadoHabitacion;
	}
	public String toString() {
    	return tipoHabitacion;
    }
}
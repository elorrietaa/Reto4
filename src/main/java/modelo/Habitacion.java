package modelo;

import java.util.ArrayList;

/**
 * Clase habitaci�n, contiene informacion referente a la habitacion
 * @author alba
 *
 */
public class Habitacion {
	protected int codHabitacion;
	
	
	protected String tipoHabitacion;
	protected float tamanio;
	protected int numCamas;
	protected ArrayList<Cama> listaCamas;
	
	/**
	 * Constructor vacio:
	 */
	public Habitacion(){
		
	}
	/**
	 * Constructor clase habitaci�n
	 * @param codHabitacion
	 * @param tipoHabitacion
	 * @param tamanio
	 * @param numCamas
	 * @param estadoHabitacion
	 */
	public Habitacion(int codHabitacion, String tipoHabitacion, float tamanio, int numCamas) {
		this.codHabitacion = codHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.tamanio = tamanio;
		this.numCamas = numCamas;
	}

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

	public int getNumCamas() {
		return numCamas;
	}

	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	public String toString() {
    	return tipoHabitacion;
    }
}
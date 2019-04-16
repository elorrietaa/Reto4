package modelo;

import java.util.ArrayList;

/**
 * Clase habitación, contiene informacion referente a la habitacion
 * @author alba
 *
 */
public class Habitacion {
	protected int codHabitacion;
	protected String tipoHabitacion;
	protected float tamanio;
	protected int numCamas;
	private int numTipCam [] = new int [3];
	protected String tiposCamaHab;
	protected ArrayList<Cama> listaCamas;
	
	/**
	 * Constructor vacio:
	 */
	public Habitacion(){
		
	}
	/**
	 * Constructor clase habitación
	 * @param codHabitacion
	 * @param tipoHabitacion
	 * @param tamanio
	 * @param numCamas
	 * @param numTipCam
	 * @param estadoHabitacion
	 */
	public Habitacion(int codHabitacion, String tipoHabitacion, float tamanio, int numCamas,int numTipCam [], String tiposCamaHab) {
		this.codHabitacion = codHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.tamanio = tamanio;
		this.numCamas = numCamas;
		this.numTipCam = numTipCam;
		this.tiposCamaHab = tiposCamaHab;
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
	public int[] getNumTipCam() {
		 return numTipCam;
	}

	public void setNumTipCam(int[] numTipCam) {
	   this.numTipCam = numTipCam;
	}
	
	public String getTiposCamaHab() {
		return tiposCamaHab;
	}
	public void setTiposCamaHab(String tiposCamaHab) {
		this.tiposCamaHab = tiposCamaHab;
	}
	
	public String toString() {
    	return tipoHabitacion;
    }
}
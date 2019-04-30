package modelo;

import java.util.ArrayList;

/**
 * Clase habitación, contiene informacion referente a la habitacion
 * @author alba
 *
 */
public class Dormitorio {
	protected int codHabitacion;
	protected String nombreHabitacion;
	protected String tipoHabitacion;
	protected float tamanio;
	protected int numCamas;
	protected float precioHabitacion;
	protected int ocupacion;
	private int numTipCam [] = new int [3];
	protected String tiposCamaHab;
	protected ArrayList<Cama> listaCamas;
	
	/**
	 * Constructor vacio:
	 */
	public Dormitorio(){
		
	}
	
	/**
	 * Clase habitación, contiene informacion referente a la habitacion
	 * @param codHabitacion
	 * @param nombreHabitacion
	 * @param tipoHabitacion
	 * @param tamanio
	 * @param numCamas
	 * @param ocupacion = contiene el número de personas que pueden ocupar la habitación.
	 * @param numTipCam
	 * @param precioHabitacion
	 * @param tiposCamaHab
	 */
	public Dormitorio(int codHabitacion, String nombreHabitacion, String tipoHabitacion, float tamanio, int numCamas, int ocupacion, int numTipCam [],float precioHabitacion, String tiposCamaHab) {
		this.codHabitacion = codHabitacion;
		this.nombreHabitacion = nombreHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.tamanio = tamanio;
		this.numCamas = numCamas;
		this.ocupacion = ocupacion;
		this.numTipCam = numTipCam;
		this.precioHabitacion = precioHabitacion;
		this.tiposCamaHab = tiposCamaHab;
	}

	
	public int getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(int ocupacion) {
		this.ocupacion = ocupacion;
	}
	public String getNombreHabitacion() {
		return nombreHabitacion;
	}
	public void setNombreHabitacion(String nombreHabitacion) {
		this.nombreHabitacion = nombreHabitacion;
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
	
	public float getPrecioHabitacion() {
		return precioHabitacion;
	}
	public void setPrecioHabitacion(float precioHabitacion) {
		this.precioHabitacion = precioHabitacion;
	}
	
	public String toString() {
    	return tipoHabitacion;
    }
}
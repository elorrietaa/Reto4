package modelo;

import java.util.ArrayList;

/**
 * Clase Dormitorio = contiene información del dormitorio. Exciende de la clase
 * Habitación
 * 
 * @author alba
 *
 */
public class Dormitorio extends Habitacion {
    protected String nombreHabitacion;
    protected int numCamas;
    protected float precioHabitacion;
    protected int ocupacion;
    private int numTipCam[] = new int[3];
    protected String tiposCamaHab;
    protected ArrayList<Cama> listaCamas;

    /**
     * Constructor vacio:
     */
    public Dormitorio() {

    }

    /**
     * Constructor1 Clase habitación, contiene informacion referente a la habitacion
     * para los dormitorio de las CASAS O APARTAMENTOS (no tiene nombreHabitacion y
     * precio)
     * 
     * @param codHabitacion
     * @param nombreHabitacion
     * @param tipoHabitacion
     * @param tamanio
     * @param numCamas
     * @param ocupacion        = contiene el número de personas que pueden ocupar la
     *                         habitación.
     * @param numTipCam
     * @param precioHabitacion
     * @param tiposCamaHab
     */
    public Dormitorio(int codHabitacion, String tipoHabitacion, float tamanio, int numCamas, int ocupacion,
	    int numTipCam[], String tiposCamaHab) {
	super(codHabitacion, tipoHabitacion, tamanio);
	this.numCamas = numCamas;
	this.ocupacion = ocupacion;
	this.numTipCam = numTipCam;
	this.tiposCamaHab = tiposCamaHab;

    }

    /**
     * Constructor2 Clase habitación, contiene informacion referente a la habitacion
     * (para los dormitorios del HOTEL, nombreHabitacion y precio)
     * 
     * @param codHabitacion
     * @param nombreHabitacion
     * @param tipoHabitacion
     * @param tamanio
     * @param numCamas
     * @param ocupacion        = contiene el número de personas que pueden ocupar la
     *                         habitación.
     * @param numTipCam
     * @param precioHabitacion
     * @param tiposCamaHab
     */
    public Dormitorio(int codHabitacion, String nombreHabitacion, String tipoHabitacion, float tamanio, int numCamas,
	    int ocupacion, int numTipCam[], float precioHabitacion, String tiposCamaHab) {
	super(codHabitacion, tipoHabitacion, tamanio);
	this.nombreHabitacion = nombreHabitacion;
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
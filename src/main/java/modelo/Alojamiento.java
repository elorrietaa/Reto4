package modelo;

import java.util.ArrayList;

/**
 * Clase Alojamiento
 * @author IN1DM3B_09
 *
 */
public class Alojamiento {
    protected int codAlojamiento;
    protected String nombre;
    protected ArrayList<Habitacion> listaHabitaciones;
    protected int numHabitaciones;
    protected String ubicacion;
    protected float precioAlojamiento;
  
  /**
  * Constructor del objeto Alojamiento vacio.
  */
   public Alojamiento() { 
	   
   }
   /**
    * Constructor del objeto Alojamiento: contiene la informaci�n referente al alojamiento. 
    * @param codAlojamiento = codigo alojamiento
    * @param nombre = nombre del alojamiento
    * @param numHabitaciones = n�mero de habitaciones que tiene el alojamiento
    * @param ubicacion = Ciudad en la que se encuentra el alojamiento
    * @param precioAlojamiento = precio del alojamiento
    */
    public Alojamiento(int codAlojamiento, String nombre, int numHabitaciones, String ubicacion, float precioAlojamiento) {
	this.codAlojamiento = codAlojamiento;
	this.nombre = nombre;
	this.numHabitaciones = numHabitaciones;
	this.ubicacion = ubicacion;
	this.precioAlojamiento = precioAlojamiento;
    }

    //get y set
    /**
     * Getter del c�digoAlojamiento = es un atributo de la clase Alojamiento
     * @return codAlojamiento
     */
    public int getCodAlojamiento() {
        return codAlojamiento;
    }
    /**
     * Setter del codAlojamiento
     * @param codAlojamiento
     */
    public void setCodAlojamiento(int codAlojamiento) {
        this.codAlojamiento = codAlojamiento;
    }
    /**
     * Getter del nombre de alojamiento = es un atributo del objeto Alojamiento
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Setter del nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Getter del n�mero de habitaciones  = es un atributo del objeto Alojamiento
     * @return numHabitaciones
     */
    public int getNumHabitaciones() {
        return numHabitaciones;
    }
    /**
     * Setter del n�mero de habitaciones
     * @param numHabitaciones
     */
    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }
    /**
     * Getter de la ubicaci�n = es un atributo de la clase Alojamiento , Despu�s sera el nombre de la ciudad en la que est� el alojamiento  
     * @return ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }
    /**
     * Setter de la ubicaci�n
     * @param ubicacion
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    /**
     * Getter del Precio Alojamiento = es un atributo del objeto Alojamiento
     * @return precioAlojamiento
     */
    public float getPrecioAlojamiento() {
        return precioAlojamiento;
    }
    /**
     * Setter del PrecioAlojamiento
     * @param precioAlojamiento
     */
    public void setPrecioAlojamiento(float precioAlojamiento) {
        this.precioAlojamiento = precioAlojamiento;
    }
    
    
    
}


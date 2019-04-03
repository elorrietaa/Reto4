package modelo;

/**
 * Clase Alojamiento
 * @author IN1DM3B_09
 *
 */
public class Alojamiento {
    protected int codAlojamiento;
    protected String nombre;
    protected int numHabitaciones;
    protected String ubicacion;
    protected float precioAlojamiento;
  
  /**
  * Constructor del objeto Alojamiento vacio.
  */
   public Alojamiento() {
	   
   }
   /**
    * Constructor del objeto Alojamiento: contiene la información referente al alojamiento. 
    * @param codAlojamiento = codigo alojamiento
    * @param nombre = nombre del alojamiento
    * @param numHabitaciones = número de habitaciones que tiene el alojamiento
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
    public int getCodAlojamiento() {
        return codAlojamiento;
    }

    public void setCodAlojamiento(int codAlojamiento) {
        this.codAlojamiento = codAlojamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getPrecioAlojamiento() {
        return precioAlojamiento;
    }

    public void setPrecioAlojamiento(float precioAlojamiento) {
        this.precioAlojamiento = precioAlojamiento;
    }
    
    
    
}

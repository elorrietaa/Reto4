package modelo;

import java.util.ArrayList;

/**
 * Clase Alojamiento
 * @author IN1DM3B_09
 *
 */
public abstract class Alojamiento {
    protected int codAlojamiento;
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected ArrayList<Habitacion> listaHabitaciones;
    protected ArrayList<Dormitorio> listaHabSeleccionadas; 
	protected int numHabitaciones;
	protected int numHabDisponibles;
    protected String ubicacion;
    protected float precioAlojamiento;
    protected int popularidad;
    protected String [] arrayNombreHabitaciones;
    protected int [] arrayNumHabitaciones;
   
  /**
  * Constructor del objeto Alojamiento vacio.
  */
   public Alojamiento() { 
	   
   }
   /**
    * Constructor del objeto Alojamiento: contiene la informaci�n referente al alojamiento. 
    * @param codAlojamiento = codigo alojamiento
    * @param nombre = nombre del alojamiento
    * @param direcion = direccion del alojamiento
    * @param telefono = telefono del alojamiento
    * @param numHabitaciones = n�mero de habitaciones que tiene el alojamiento
    * @param ubicacion = Ciudad en la que se encuentra el alojamiento
    * @param precioAlojamiento = precio del alojamiento
    * @param arrayNombreHabitaciones = contiene el nombre de los diferentes tipos de Habitaciones que hay
    * @param arrayNumHabitaciones = contiene el numero de habitaciones de cada tipo que hay en el alojamiento
    */
    public Alojamiento(int codAlojamiento, String nombre,String direccion, String telefono, int numHabitaciones, String ubicacion, float precioAlojamiento, int popularidad, String [] arrayNombreHabitaciones, int [] arrayNumHabitaciones ) {
	this.codAlojamiento = codAlojamiento;
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
	this.numHabitaciones = numHabitaciones;
	this.ubicacion = ubicacion;
	this.precioAlojamiento = precioAlojamiento;
	this.popularidad = popularidad;
	this.arrayNombreHabitaciones = arrayNombreHabitaciones;
	this.arrayNumHabitaciones = arrayNumHabitaciones;
    }
    
   /**
    * Constructor del objeto Alojamiento: contiene la informaci�n referente al alojamiento. con numHabDisponibles para hoteles
    * @param codAlojamiento = codigo alojamiento
    * @param nombre = nombre del alojamiento
    * @param direcion = direccion del alojamiento
    * @param telefono = telefono del alojamiento
    * @param numHabitaciones = n�mero de habitaciones que tiene el alojamiento
    * @param numHabDisponibles = n�mero de habitaciones disponibles que tiene el alojamiento
    * @param ubicacion = Ciudad en la que se encuentra el alojamiento
    * @param precioAlojamiento = precio del alojamiento
    * @param arrayNombreHabitaciones = contiene el nombre de los diferentes tipos de Habitaciones que hay
    * @param arrayNumHabitaciones = contiene el numero de habitaciones de cada tipo que hay en el alojamiento
    */
    public Alojamiento(int codAlojamiento, String nombre,String direccion, String telefono, int numHabitaciones,int numHabDisponibles, String ubicacion, float precioAlojamiento, int popularidad, String [] arrayNombreHabitaciones, int [] arrayNumHabitaciones) {
	this.codAlojamiento = codAlojamiento;
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
	this.numHabitaciones = numHabitaciones;
	this.numHabDisponibles = numHabDisponibles;
	this.ubicacion = ubicacion;
	this.precioAlojamiento = precioAlojamiento;
	this.popularidad = popularidad;
	this.arrayNombreHabitaciones = arrayNombreHabitaciones;
	this.arrayNumHabitaciones = arrayNumHabitaciones;
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
    
    
    
    public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
    
    
    
    public int getNumHabDisponibles() {
		return numHabDisponibles;
	}
	public void setNumHabDisponibles(int numHabDisponibles) {
		this.numHabDisponibles = numHabDisponibles;
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
    
    
	public int getPopularidad() {
		return popularidad;
	}
	public void setPopularidad(int popularidad) {
		this.popularidad = popularidad;
	}
	/**
     * Getter del arrayList listaHabitaciones
     * @return
     */
   
	public void setListaHabSeleccionadas(ArrayList<Dormitorio> listaHabSeleccionadas) {
		this.listaHabSeleccionadas = listaHabSeleccionadas;
	}
	public String[] getArrayNombreHabitaciones() {
		return arrayNombreHabitaciones;
	}
	public void setArrayNombreHabitaciones(String[] arrayNombreHabitaciones) {
		this.arrayNombreHabitaciones = arrayNombreHabitaciones;
	}
	public int[] getArrayNumHabitaciones() {
		return arrayNumHabitaciones;
	}
	public void setArrayNumHabitaciones(int[] arrayNumHabitaciones) {
		this.arrayNumHabitaciones = arrayNumHabitaciones;
	}
	
	
}


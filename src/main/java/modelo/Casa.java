package modelo;

public class Casa extends Alojamiento{
	protected int numBanos;
	protected float metrosCuadrados;
    /**
     * Constructor vacio del objeto Casa.
     */
    public Casa() {
    	
    }
    /**
     * constructor del objeto Casa
     * @param codAlojamiento =código de la Casa
     * @param nombre = nombre de la Casa
     * @param numHabitaciones = número de habitaciones de la Casa
     * @param ubicacion = ciudad en la que se encuentra la Casa
     * @param numBanos = número de baños de la Casa
     * @param metrosCuadrados = metrosCuadrados de la Casa
     *  
     */
    public Casa(int codAlojamiento, String nombre, String direccion, String telefono, int numHabitaciones, String ubicacion, float precioAlojamiento, int popularidad, int numBanos, float metrosCuadrados, String [] arrayNombreHabitaciones, int [] arrayNumHabitaciones ) {
	super(codAlojamiento, nombre,direccion, telefono, numHabitaciones, ubicacion, precioAlojamiento, popularidad, arrayNombreHabitaciones, arrayNumHabitaciones);
	this.numBanos = numBanos;
	this.metrosCuadrados = metrosCuadrados;
    }
    
  //get y set  
	public int getNumBanos() {
		return numBanos;
	}
	public void setNumBanos(int numBanos) {
		this.numBanos = numBanos;
	}
	public float getMetrosCuadrados() {
		return metrosCuadrados;
	}
	public void setMetrosCuadrados(float metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
    
    
}

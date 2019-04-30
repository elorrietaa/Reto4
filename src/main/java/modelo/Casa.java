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
     * @param codAlojamiento =c�digo de la Casa
     * @param nombre = nombre de la Casa
     * @param numHabitaciones = n�mero de habitaciones de la Casa
     * @param ubicacion = ciudad en la que se encuentra la Casa
     * @param numBanos = n�mero de ba�os de la Casa
     * @param metrosCuadrados = metrosCuadrados de la Casa
     *  
     */
    public Casa(int codAlojamiento, String nombre, int numHabitaciones, String ubicacion, float precioAlojamiento, int popularidad, int numBanos, float metrosCuadrados ) {
	super(codAlojamiento, nombre, numHabitaciones, ubicacion, precioAlojamiento, popularidad);
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

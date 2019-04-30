package modelo;

public class Apartamento extends Casa{
	protected int piso;
    /**
     * Constructor vacio del objeto Apartamento.
     */
    public Apartamento() {
    	
    }
    /**
     * constructor del objeto Apartamento
     * @param codAlojamiento =código del Apartamento
     * @param nombre = nombre del Apartamento
     * @param numHabitaciones = número de habitaciones del Apartamento
     * @param ubicacion = ciudad en la que se encuentra el Apartamento
     * @param numBanos = número de baños del Apartamento
     * @param metrosCuadrados = metrosCuadrados del Apartamento
     * @param piso = piso en la que se encuentra el Apartamento
     * 
     */
    public Apartamento(int codAlojamiento, String nombre, int numHabitaciones, String ubicacion, float precioAlojamiento, int popularidad, int numBanos, float metrosCuadrados, int piso) {
	super(codAlojamiento, nombre, numHabitaciones, ubicacion, precioAlojamiento,popularidad, numBanos, metrosCuadrados);
    this.piso = piso;
    } 
    
    //get y set 
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
    
    
}
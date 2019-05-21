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
     * @param codAlojamiento código del Apartamento
     * @param nombre nombre del Apartamento
     * @param numHabitaciones número de habitaciones del Apartamento
     * @param ubicacion ciudad en la que se encuentra el Apartamento
     * @param numBanos número de baños del Apartamento
     * @param metrosCuadrados metrosCuadrados del Apartamento
     * @param piso piso en la que se encuentra el Apartamento
     * 
     */
    public Apartamento(int codAlojamiento, String nombre,String direccion, String telefono, int numHabitaciones, String ubicacion, float precioAlojamiento, int popularidad, int numBanos, float metrosCuadrados, int piso, String [] arrayNombreHabitaciones, int [] arrayNumHabitaciones) {
	super(codAlojamiento, nombre,direccion, telefono, numHabitaciones, ubicacion, precioAlojamiento,popularidad, numBanos, metrosCuadrados, arrayNombreHabitaciones, arrayNumHabitaciones);
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
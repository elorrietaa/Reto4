package modelo;

public class Casa extends Alojamiento{
    /**
     * Constructor vacio del objeto Casa.
     */
    public Casa() {
    	
    }
    /**
     * constructor del objeto Casa
     * @param codAlojamiento =código del Casa
     * @param nombre = nombre del Casa
     * @param numHabitaciones = número de habitaciones del Casa
     * @param ubicacion = ciudad en la que se encuentra el Casa
     * 
     */
    public Casa(int codAlojamiento, String nombre, int numHabitaciones, String ubicacion, float precioAlojamiento) {
	super(codAlojamiento, nombre, numHabitaciones, ubicacion, precioAlojamiento);
    }
}

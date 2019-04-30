package modelo;

public class Casa extends Alojamiento{
    /**
     * Constructor vacio del objeto Hotel.
     */
    public Casa() {
    	
    }
    /**
     * constructor del objeto Hotel
     * @param codAlojamiento =código del hotel
     * @param nombre = nombre del hotel
     * @param numHabitaciones = número de habitaciones del hotel
     * @param ubicacion = ciudad en la que se encuentra el hotel
     * @param estrellas = número de estrellas que tiene el hotel
     */
    public Casa(int codAlojamiento, String nombre, int numHabitaciones, String ubicacion, float precioAlojamiento) {
	super(codAlojamiento, nombre, numHabitaciones, ubicacion, precioAlojamiento);
    }
}

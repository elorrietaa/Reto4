package modelo;

public class Apartamento extends Alojamiento{
    /**
     * Constructor vacio del objeto Hotel.
     */
    public Apartamento() {
    	
    }
    /**
     * constructor del objeto Apartamento
     * @param codAlojamiento =código del Apartamento
     * @param nombre = nombre del Apartamento
     * @param numHabitaciones = número de habitaciones del Apartamento
     * @param ubicacion = ciudad en la que se encuentra el Apartamento
     * 
     */
    public Apartamento(int codAlojamiento, String nombre, int numHabitaciones, String ubicacion, float precioAlojamiento) {
	super(codAlojamiento, nombre, numHabitaciones, ubicacion, precioAlojamiento);
    }
}
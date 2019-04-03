package modelo;
/**
 * Clase Hotel, hereda de Alojamiento todos los atributos de Alojamiento
 * @author alba
 *
 */
public class Hotel extends Alojamiento{
    protected int estrellas;
    /**
     * Constructor vacio del objeto Hotel.
     */
    public Hotel() {
    	
    }
    /**
     * constructor del objeto Hotel
     * @param codAlojamiento =c�digo del hotel
     * @param nombre = nombre del hotel
     * @param numHabitaciones = n�mero de habitaciones del hotel
     * @param ubicacion = ciudad en la que se encuentra el hotel
     * @param estrellas = n�mero de estrellas que tiene el hotel
     */
    public Hotel(int codAlojamiento, String nombre, int numHabitaciones, String ubicacion, int estrellas, float precioAlojamiento) {
	super(codAlojamiento, nombre, numHabitaciones, ubicacion, precioAlojamiento);
	this.estrellas=estrellas;
    }

    //get y set 
    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    
   
}

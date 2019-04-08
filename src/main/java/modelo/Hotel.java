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
     * @param codAlojamiento =código del hotel
     * @param nombre = nombre del hotel
     * @param numHabitaciones = número de habitaciones del hotel
     * @param ubicacion = ciudad en la que se encuentra el hotel
     * @param estrellas = número de estrellas que tiene el hotel
     */
    public Hotel(int codAlojamiento, String nombre, int numHabitaciones, String ubicacion, int estrellas, float precioAlojamiento) {
	super(codAlojamiento, nombre, numHabitaciones, ubicacion, precioAlojamiento);
	this.estrellas=estrellas;
    }

    //get y set 
    /**
     * Getter de Estrellas = es un atributo que tiene el objeto Hotel 
     * @return estrellas
     */
    public int getEstrellas() {
        return estrellas;
    }
    /**
     * Setter de Estrelas 
     * @param estrellas
     */
    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String toString() {
    	return nombre;
    }
   
}
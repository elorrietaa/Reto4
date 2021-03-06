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
     * @param codAlojamiento = c�digo del hotel
     * @param nombre = nombre del hotel
     * @param numHabitaciones = n�mero de habitaciones del hotel
     * @param ubicacion = ciudad en la que se encuentra el hotel
     * @param estrellas = n�mero de estrellas que tiene el hotel
     */
    public Hotel(int codAlojamiento, String nombre,String direccion, String telefono, int numHabitaciones, int numHabDisponibles, String ubicacion, int estrellas, float precioAlojamiento, int popularidad, String [] arrayNombreHabitaciones, int [] arrayNumHabitaciones) {
    	super(codAlojamiento, nombre, direccion, telefono, numHabitaciones, numHabDisponibles, ubicacion, precioAlojamiento, popularidad, arrayNombreHabitaciones, arrayNumHabitaciones);
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
    public String toStringDatosHotel() {
    	return "C�digo hotel: " + this.codAlojamiento + "Nombre: " + this.nombre ;
    }
   
}
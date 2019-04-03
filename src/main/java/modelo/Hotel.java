package modelo;

public class Hotel extends Alojamiento{
    /**
     * Clase Hotel, hereda de Alojamiento todos los atributos de Alojamiento
     */
    protected int estrellas;
 
    /**
     * constructor Hotel
     * @param codAlojamiento
     * @param nombre
     * @param numHabitaciones
     * @param ubicacion
     * @param estrellas
     */
    public Hotel(int codAlojamiento, String nombre, int numHabitaciones, String ubicacion, int estrellas) {
	super(codAlojamiento, nombre, numHabitaciones, ubicacion);
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

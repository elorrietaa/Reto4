package modelo;

/**
 * Clase Alojamiento
 * @author IN1DM3B_09
 *
 */
public class Alojamiento {
    protected int codAlojamiento;
    protected String nombre;
    protected int numHabitaciones;
    protected String ubicacion;
 
    /**
     * Constructor Alojamiento
     * @param codAlojamiento =código del alojamiento
     * @param nombre = nombre del alojamiento
     * @param numHabitaciones =número de Habitaciones
     * @param ubicacion =Ubicación (Ciudad)
     */
    public Alojamiento(int codAlojamiento, String nombre, int numHabitaciones, String ubicacion) {
	this.codAlojamiento = codAlojamiento;
	this.nombre = nombre;
	this.numHabitaciones = numHabitaciones;
	this.ubicacion = ubicacion;
    }

    //get y set
    public int getCodAlojamiento() {
        return codAlojamiento;
    }

    public void setCodAlojamiento(int codAlojamiento) {
        this.codAlojamiento = codAlojamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}

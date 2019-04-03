package modelo;

/**
 * Clase Reserva: contiene la información referente a la Reserva: codReserva, alojamiento, precioReserva
 * @author IN1DM3B_09
 *
 */
public class Reserva {
    private int codReserva;
    private Alojamiento alojamiento; 
    private float precioReserva;
    /**
     * Constructor vacio del objeto Reserva
     */
    public Reserva() {
    	
    }
    /**
     * Constructor del objeto Reserva
     * @param codReserva
     * @param alojamiento
     * @param precioReserva
     */
    public Reserva(int codReserva, Alojamiento alojamiento, float precioReserva) {
	this.codReserva=codReserva;
	this.alojamiento=alojamiento;
	this.precioReserva=precioReserva;
    }
    //get y set
    public int getCodReserva() {
	return codReserva;
    }
    public void setCodReserva(int codReserva) {
	this.codReserva = codReserva;
    }
    public Alojamiento getAlojamiento() {
	return alojamiento;
    }
    public void setAlojamiento(Alojamiento alojamiento) {
	this.alojamiento = alojamiento;
    }
    public float getPrecioReserva() {
	return precioReserva;
    }
    public void setPrecioReserva(float precioReserva) {
	this.precioReserva = precioReserva;
    } 
}



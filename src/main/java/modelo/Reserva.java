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
    /**
     *Getter del CodReserva = es un atributo del objeto Reserva
     *@return codReserva
     */
     
    public int getCodReserva() {
	return codReserva;
    }
    /**
     * @param codReserva
     * Setter del CodReserva 
     */
    public void setCodReserva(int codReserva) {
	this.codReserva = codReserva;
    }
    /**
     * Getter de Alojamiento = es un Obejeto de tipo Alojamiento y que es además un atributo del objeto Reserva
     * @return alojamiento
     */
    public Alojamiento getAlojamiento() {
	return alojamiento;
    }
    /**
     * Setter de alojamiento
     * @param alojamiento
     */
    public void setAlojamiento(Alojamiento alojamiento) {
	this.alojamiento = alojamiento;
    }
    /**
     * Getter del precioReserva = es un atributo del objeto Reserva y es el precio que tiene la Reserva 
     * @return precioReserva
     */
    public float getPrecioReserva() {
	return precioReserva;
    }
    /**
     * Setter del precioReserva
     * @param precioReserva
     */
    public void setPrecioReserva(float precioReserva) {
	this.precioReserva = precioReserva;
    } 
}




package modelo;

import java.sql.Date;

/**
 * Clase Reserva: contiene la información referente a la Reserva: codReserva, alojamiento, precioReserva
 * @author IN1DM3B_09
 *
 */
public class Reserva {
    private int codReserva;
    private Cliente cliente;
    private Alojamiento alojamiento; 
    private Dormitorio habitacion;
    private Date fechaIda;
    private Date fechaVuelta;
    private float precioReserva;
  //  private Date 
    
    /**
     * Constructor vacio del objeto Reserva
     */
    public Reserva() {
    	 
    }
    /**
     * Constructor del objeto Reserva para los HOTELES (con el atributo habitación)
     * @param codReserva
     * @param alojamiento
     * @param precioReserva
     */
    public Reserva(int codReserva, Cliente cliente, Alojamiento alojamiento, Dormitorio habitacion, Date fechaIda, Date fechaVuelta,  float precioReserva) {
	this.codReserva = codReserva;
	this.cliente = cliente;
	this.alojamiento =alojamiento;
	this.habitacion = habitacion;
	this.fechaIda = fechaIda;
	this.fechaVuelta = fechaVuelta;
	this.precioReserva = precioReserva;
    }
    
    /**
     * Constructor del objeto Reserva
     * @param codReserva
     * @param alojamiento
     * @param precioReserva
     */
    public Reserva(int codReserva, Cliente cliente, Alojamiento alojamiento, Date fechaIda, Date fechaVuelta,  float precioReserva) {
	this.codReserva = codReserva;
	this.cliente = cliente;
	this.alojamiento =alojamiento;
	this.fechaIda = fechaIda;
	this.fechaVuelta = fechaVuelta;
	this.precioReserva = precioReserva;
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
     * Getter de habitacion = es un Obejeto de tipo habitacion y que es además un atributo del objeto Reserva
     * @return alojamiento
     */
    public Dormitorio getHabitacion() {
		return habitacion;
	}
    /**
     * Setter de habitacion
     * @param alojamiento
     */
	public void setHabitacion(Dormitorio habitacion) {
		this.habitacion = habitacion;
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
	@Override
	public String toString() {
		return "Datos de la reserva: Código de Reserva:" + this.codReserva ;
	}
	public Cliente getCliente() {
	    return cliente;
	}
	public void setCliente(Cliente cliente) {
	    this.cliente = cliente;
	}
	public Date getFechaIda() {
	    return fechaIda;
	}
	public void setFechaIda(Date fechaIda) {
	    this.fechaIda = fechaIda;
	}
	public Date getFechaVuelta() {
	    return fechaVuelta;
	}
	public void setFechaVuelta(Date fechaVuelta) {
	    this.fechaVuelta = fechaVuelta;
	} 
    
    
}




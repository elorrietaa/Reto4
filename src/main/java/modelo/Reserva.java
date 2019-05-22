package modelo;

import java.sql.Date;

/**
 * Clase Reserva: contiene la información referente a la Reserva: codReserva,
 * alojamiento, precioReserva
 * 
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
    private Date fechaBases;
    private String horaBases;
    private String detallesTarifa;
    private String detallesFestivos;

    /**
     * Constructor vacio del objeto Reserva
     */
    public Reserva() {

    }

    /**
     * Constructor del objeto Reserva para los HOTELES (con el atributo habitación)
     * 
     * @param codReserva       Codigo identificador reserva
     * @param cliente          Objeto cliente que se utiliza para sacar los datos
     *                         del cliente
     * @param alojamiento      Objeto alojamiento que se utiliza para sacar los
     *                         datos del alojamiento
     * @param habitacion       Objeto habitacion que tiene los datos de las
     *                         habitacions del alojamiento
     * @param fechaIda         Fecha en la que se va a ingresar al alojamiento
     * @param fechaVuelta      Fecha de salida del alojamiento
     * @param precioReserva    Precio de la reserva
     * @param fechaBases       Fecha en la que se aceptaron las bases legales
     * @param horaBases        Hora en la se acepto las bases legales
     * @param detallesTarifa   Detalles de la tarifa aplicada
     * @param detallesFestivos Detalles de los dias festivos si los hay
     */
    public Reserva(int codReserva, Cliente cliente, Alojamiento alojamiento, Dormitorio habitacion, Date fechaIda,
	    Date fechaVuelta, float precioReserva, Date fechaBases, String horaBases, String detallesTarifa,
	    String detallesFestivos) {
	this.codReserva = codReserva;
	this.cliente = cliente;
	this.alojamiento = alojamiento;
	this.habitacion = habitacion;
	this.fechaIda = fechaIda;
	this.fechaVuelta = fechaVuelta;
	this.precioReserva = precioReserva;
	this.fechaBases = fechaBases;
	this.horaBases = horaBases;
	this.detallesTarifa = detallesTarifa;
	this.detallesFestivos = detallesFestivos;
    }

    /**
     * Constructor del objeto reserva
     * 
     * @param codReserva       Codigo identificador reserva
     * @param cliente          Objeto cliente que se utiliza para sacar los datos
     *                         del cliente
     * @param alojamiento      Objeto alojamiento que se utiliza para sacar los
     *                         datos del alojamiento
     * @param fechaIda         Fecha en la que se va a ingresar al alojamiento
     * @param fechaVuelta      Fecha de salida del alojamiento
     * @param precioReserva    Precio de la reserva
     * @param fechaBases       Fecha en la que se aceptaron las bases legales
     * @param horaBases        Hora en la se acepto las bases legales
     * @param detallesTarifa   Detalles de la tarifa aplicada
     * @param detallesFestivos Detalles de los dias festivos si los hay
     */
    public Reserva(int codReserva, Cliente cliente, Alojamiento alojamiento, Date fechaIda, Date fechaVuelta,
	    float precioReserva, Date fechaBases, String horaBases, String detallesTarifa, String detallesFestivos) {
	this.codReserva = codReserva;
	this.cliente = cliente;
	this.alojamiento = alojamiento;
	this.fechaIda = fechaIda;
	this.fechaVuelta = fechaVuelta;
	this.precioReserva = precioReserva;
	this.fechaBases = fechaBases;
	this.horaBases = horaBases;
	this.detallesTarifa = detallesTarifa;
	this.detallesFestivos = detallesFestivos;
    }

    // get y set
    /**
     * Getter del CodReserva es un atributo del objeto Reserva
     * 
     * @return Codigo de la reserva
     */
    public int getCodReserva() {
	return codReserva;
    }

    /**
     * Setter del CodReserva
     * 
     * @param codReserva Codigo identificador de la reserva
     */
    public void setCodReserva(int codReserva) {
	this.codReserva = codReserva;
    }

    /**
     * Getter de Alojamiento es un Obejeto de tipo Alojamiento y que es además un
     * atributo del objeto Reserva
     * 
     * @return alojamiento
     */
    public Alojamiento getAlojamiento() {
	return alojamiento;
    }

    /**
     * Setter de alojamiento
     * 
     * @param alojamiento Objeto alojamiento que se utiliza para sacar los datos del
     *                    alojamiento
     */
    public void setAlojamiento(Alojamiento alojamiento) {
	this.alojamiento = alojamiento;
    }

    /**
     * Getter de habitacion es un Obejeto de tipo habitacion y que es además un
     * atributo del objeto Reserva
     * 
     * @return habitacion
     */
    public Dormitorio getHabitacion() {
	return habitacion;
    }

    /**
     * Setter de habitacion
     * 
     * @param habitacion Objeto dormitorio con os datos de las habitaciones del
     *                   alojamiento
     */
    public void setHabitacion(Dormitorio habitacion) {
	this.habitacion = habitacion;
    }

    /**
     * Getter del precioReserva es un atributo del objeto Reserva y es el precio que
     * tiene la Reserva
     * 
     * @return precioReserva
     */
    public float getPrecioReserva() {
	return precioReserva;
    }

    /**
     * Setter del precioReserva
     * 
     * @param precioReserva Precio de la reserba
     */
    public void setPrecioReserva(float precioReserva) {
	this.precioReserva = precioReserva;
    }

    @Override
    public String toString() {
	return "Datos de la reserva: Código de Reserva:" + this.codReserva;
    }

    /**
     * Getter del objeto cliente
     * 
     * @return Retorna un objeto cliente
     */
    public Cliente getCliente() {
	return cliente;
    }

    /**
     * Setter del objeto cliente
     * 
     * @param cliente Objeto cliente que se utiliza para sacar los datos del cliente
     */
    public void setCliente(Cliente cliente) {
	this.cliente = cliente;
    }

    /**
     * Getter de la fecha de entrada
     * 
     * @return Retorna la fecha de entrada
     */
    public Date getFechaIda() {
	return fechaIda;
    }

    /**
     * Setter de la fecha de entrada
     * 
     * @param fechaIda Fecha en la que se va a ingresar al alojamiento
     */
    public void setFechaIda(Date fechaIda) {
	this.fechaIda = fechaIda;
    }

    /**
     * Getter de la fecha de salida
     * 
     * @return Retorna la fecha de salida
     */
    public Date getFechaVuelta() {
	return fechaVuelta;
    }

    /**
     * Setter de la fecha de salida
     * 
     * @param fechaVuelta Fecha de salida del alojamiento
     */
    public void setFechaVuelta(Date fechaVuelta) {
	this.fechaVuelta = fechaVuelta;
    }

    /**
     * Getter de la fecha en la que se aceptaron las bases legales
     * 
     * @return Retorna la fecha en las que se aceptaron las bases legales
     */
    public Date getFechaBases() {
	return fechaBases;
    }

    /**
     * Setter de la fecha en la se aceptaron las bases legales
     * 
     * @param fechaBases Fecha en la que se aceptaron las bases legales
     */
    public void setFechaBases(Date fechaBases) {
	this.fechaBases = fechaBases;
    }

    /**
     * Getter de la hora en la que se aceptaron las bases legales
     * 
     * @return Retorna la hora a la que se aceptaron las bases legales
     */
    public String getHoraBases() {
	return horaBases;
    }

    /**
     * Setter de la hora a la que se aceptaron las bases legales
     * 
     * @param horaBases Hora en la se acepto las bases legales
     */
    public void setHoraBases(String horaBases) {
	this.horaBases = horaBases;
    }

    /**
     * Getter de los detalles de la taria aplicada
     * 
     * @return Retorna los detalles de la tarifa
     */
    public String getDetallesTarifa() {
	return detallesTarifa;
    }

    /**
     * Setter de los detalles de la tarifa aplicada
     * 
     * @param detallesTarifa Detalles de la tarifa aplicada
     */
    public void setDetallesTarifa(String detallesTarifa) {
	this.detallesTarifa = detallesTarifa;
    }

    /**
     * Getter de los detalles de los festivos
     * 
     * @return Retorna los detalles de los festivos
     */
    public String getDetallesFestivos() {
	return detallesFestivos;
    }

    /**
     * Setter de los detalles de los festivos
     * 
     * @param detallesFestivos Detalles de los dias festivos si los hay
     */
    public void setDetallesFestivos(String detallesFestivos) {
	this.detallesFestivos = detallesFestivos;
    }
}
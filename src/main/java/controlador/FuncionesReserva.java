package controlador;

import modelo.PrincipalModelo;
import modelo.Reserva;

public class FuncionesReserva {
	
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	public float precioReserva;
	
	/**
	 * Constructor de la clase FuncionesPago
	 * 
	 * @param modelo Instancia de la clase modelo para poder utilizarlo
	 */
	public FuncionesReserva (PrincipalModelo modelo, PrincipalControlador controlador) {
		this.modelo = modelo;
		this.controlador = controlador;
	}
	
	/**
	 * Metodo para calcular el precio de la reserva
	 * 
	 * @param reserva Objeto con la informacion de la reserva
	 * 
	 * @return Retorna el precio de la reserva 
	 */
	public float calcularPrecioReserva() {
		//por ahora el precio de la reserva es solo el precio del alojamiento, en el futuro ser�n m�s c�lculos
		//float precioReserva = modelo.hotel.getPrecioAlojamiento();
		float precioReserva = 10000;
		System.out.println("El precio de la reserva calculado es: " + precioReserva);
		return precioReserva;
	}
	
	/**
	 * M�todo generarReserva = se rellena el objeto reserva con los datos seleccionados
	 */
	public void generarReserva() {
		//genera un c�digo de reserva en funci�n de las reservas que haya en la BBDD
		int codReserva = modelo.consultas.mostrarNumReservas() +1;
		System.out.println("c�digo de la resera: " + codReserva);
		//Calcula el precio de la reserva: MAL, NO LO CALCULA, NO COGE LOS M�TODOS DE LA CLASE FUNCIONESRESERVA
		//float precioReserva = controlador.funcionesReserva.calcularPrecioReserva();
		//System.out.println("Precio reserva calculado: " + precioReserva);
		//rellenamos el objeto reserva y se pasa la reserva al modelo //el precio Reserva es el precio calculado en el m�todo:
		modelo.reserva = new Reserva(codReserva, modelo.cliente , modelo.hotel, null, null, this.precioReserva);
	}
	
}

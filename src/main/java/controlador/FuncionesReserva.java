package controlador;

import modelo.PrincipalModelo;

public class FuncionesReserva {
	
	private PrincipalModelo modelo;
	public float precioReserva;
	
	/**
	 * Constructor de la clase FuncionesPago
	 * 
	 * @param modelo Instancia de la clase modelo para poder utilizarlo
	 */
	public FuncionesReserva (PrincipalModelo modelo) {
		this.modelo = modelo;
	} 
	
	/**
	 * Metodo para calcular el precio de la reserva
	 * 
	 * @param reserva Objeto con la informacion de la reserva
	 * 
	 * @return Retorna el precio de la reserva 
	 */
	public float calcularPrecioReserva() {
		//por ahora el precio de la reserva es solo el precio del alojamiento, en el futuro serán más cálculos
		//float precioReserva = modelo.hotel.getPrecioAlojamiento();
		float precioReserva = 10000;
		System.out.println("El precio de la reserva calculado es: " + precioReserva);
		return precioReserva;
	}
	
	
}

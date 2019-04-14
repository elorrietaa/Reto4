package controlador;

import modelo.PrincipalModelo;
import modelo.Reserva;
import vista.JframePrincipal;

public class FuncionesReserva {
	
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	public float precioReserva;
	
	/**
	 * Constructor de la clase FuncionesPago
	 * 
	 * @param modelo Instancia de la clase modelo para poder utilizarlo
	 */
	public FuncionesReserva (PrincipalModelo modelo,JframePrincipal vista, PrincipalControlador controlador) {
		this.modelo = modelo;
		this.controlador = controlador;
		this.vista = vista;
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
		float precioReserva = modelo.hotel.getPrecioAlojamiento();
		
		return precioReserva;
	}
	
	/**
	 * M�todo generarReserva = se rellena el objeto reserva con los datos seleccionados
	 */
	public void generarReserva() {
		//genera un c�digo de reserva en funci�n de las reservas que haya en la BBDD
		int codReserva = modelo.consultas.mostrarNumReservas() +1;
		System.out.println("c�digo de la resera: " + codReserva);
		//Calcula el precio de la reserva: 
		precioReserva = controlador.funcionesReserva.calcularPrecioReserva();
		System.out.println("Precio reserva calculado: " + precioReserva);
		//rellenamos el objeto reserva y se pasa la reserva al modelo //el precio Reserva es el precio calculado en el m�todo:
		modelo.reserva = new Reserva(codReserva, modelo.cliente , modelo.hotel, null, null, this.precioReserva);
	}
	

	/**
	 * M�todo mostrarDatosReserva = muestra los datos de la reserva. Los datos de la reserva son aquellos datos seleccionados por el usuario. 
	 */
	public void mostrarDatosReserva() {
		//muestra datos del alojamiento
	    	vista.detallesReserva.textPDatosAlo.setText((String) "Ciudad: " + modelo.ciudad.getNombreCiudad() + "\n" + "Hotel: " + modelo.hotel.getNombre()+"\n" + "N�mero de estrellas:" + modelo.hotel.getEstrellas());
	  //muestra  el precio de la reserva, ahora es el de 1 reserva, en el futuro ser� la suma de 1 o varias reservas.
	  	modelo.precioTotal = calcularPrecioReserva();
	  	vista.detallesReserva.tFPrecioReserva.setText(Float.toString(modelo.reserva.getPrecioReserva())+ " �");
	}
	
}

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
		//(1�) genera un c�digo de reserva en funci�n de las reservas que haya en la BBDD
		int codReservaProc = modelo.consultas.mostrarNumReservasConProcedimiento();
		System.out.println("num reservas con procedimientooooo" + codReservaProc);
		int codReserva = modelo.consultas.mostrarNumReservas() +1;
		
		System.out.println("c�digo de la reserva: " + codReserva);
		
		//(2�) Calcula el precio de la reserva: 
		precioReserva = controlador.funcionesReserva.calcularPrecioReserva();
		System.out.println("Precio reserva calculado: " + precioReserva);
		
		//(3�) rellenamos el objeto reserva y se pasa la reserva al modelo //el precio Reserva es el precio calculado en el m�todo:
		modelo.reserva = new Reserva(codReserva, modelo.cliente , modelo.hotel, modelo.habitacion, modelo.fechaIda, modelo.fechaVuelta, this.precioReserva);
	
		
	}
	  

	/**
	 * M�todo mostrarDatosReserva = muestra los datos de la reserva. Los datos de la reserva son aquellos datos seleccionados por el usuario. 
	 */
	public void mostrarDatosReserva() {
		//muestra datos del alojamiento
		vista.detallesReserva.textPDatosAlo.setText((String) "Ciudad: " + modelo.reserva.getAlojamiento().getUbicacion() + "\n" + "C�digo del hotel: "+ modelo.reserva.getAlojamiento().getCodAlojamiento() + "\n" + "Hotel: " +modelo.reserva.getAlojamiento().getNombre()+"\n" + "N�mero de estrellas:" + modelo.hotel.getEstrellas() );
		
		vista.detallesReserva.textPDetallesHabi.setText((String) "C�digo de la habitaci�n: " + modelo.habitacion.getCodHabitacion() + "\n" + "Tipo de habitaci�n: "+ modelo.habitacion.getTipoHabitacion() + "\n" + "N�mero de camas de la habitaci�n: "+ modelo.habitacion.getNumCamas() + "\n" + "Tipo de camas: "+ modelo.habitacion.getTiposCamaHab());
		
		//muestra el PRECIO TOTAL DE LA RESERVA: 
		//EN EL FUTURO SE CALCULAR� SUMANDO EL PRECIO DE TODAS LAS RESERVAS REALIZADAS
	  	vista.detallesReserva.tFPrecioReserva.setText(Float.toString(modelo.reserva.getPrecioReserva())+ " �");
	  	modelo.precioTotal=modelo.reserva.getPrecioReserva();
	}
	

	
}

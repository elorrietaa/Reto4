package controlador;

import java.util.ArrayList;

import modelo.Cama;
import modelo.Habitacion;
import modelo.PrincipalModelo;
import modelo.Reserva;
import vista.JframePrincipal;

public class FuncionesReserva {
	
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	public float precioHabitacion;
	public float precioReserva;
	private ArrayList<Habitacion> listaHabitaciones;
	private ArrayList<Cama> listaCamas;
	
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
	public float calcularPrecioReservaHotel( ArrayList<Habitacion> listaHabSeleccionadas) {
		float precioReserva=0;
		
		//(1�) el precio total de la reserva ser� la suma de los precios de las habitaciones seleccionadas
		for(int i=0; i<listaHabSeleccionadas.size();i++) {
			precioReserva = precioReserva + listaHabSeleccionadas.get(i).getPrecioHabitacion();
		}
		
		//(2�) Calcular el precio en funci�n del N�MERO DE NOCHES seleccionadas por el usuario.
		int numNoches = calcularNochesReservadas();
		
		precioReserva = precioReserva*numNoches;
		
		//metemos el precio total de la reserva en el modelo:
		modelo.precioTotal = precioReserva;
		System.out.println("EL PRECIO TOTAL DE LA RESERVA DE TODAS LAS HABS DEL HOTEL ES calcularPrecioReservaHotel "+modelo.precioTotal);
		return precioReserva;
	}
	
	public float calcularPrecioHabXNoches( ArrayList<Habitacion> listaHabSeleccionadas, int pos) {
		float precioHabXnoches=0;
		//(1�) Calcular el precio en funci�n del N�MERO DE NOCHES seleccionadas por el usuario.
		int numNoches = calcularNochesReservadas();
		
		//calcular el precio de la habitacion x noches.
		precioHabXnoches = listaHabSeleccionadas.get(pos).getPrecioHabitacion() * numNoches;
		
		
		return precioHabXnoches;
	}
	
	
	/**
	 * M�todo calcularNochesReservadas = calcula el n�mero de noches reservadas por el usuario.
	 */
	public int calcularNochesReservadas() {
		int numNoches=(int) ((modelo.fechaVuelta.getTime()-modelo.fechaIda.getTime())/86400000);
		
		//metemos el n�mero de noches en el modelo:
		modelo.numNoches = numNoches;
		System.out.println("Noches reservadas:  "+modelo.numNoches);
		
		//mostramos num de noches en la vista 
		vista.detallesReserva.textFieldNumNoches.setText(Integer.toString(modelo.numNoches));
		
		return numNoches;
	}
	
	

	/**
	 * M�todo mostrarDatosReserva = muestra los datos de la reserva. Los datos de la reserva son aquellos datos seleccionados por el usuario. 
	 */
	public void mostrarDatosReserva(ArrayList<Habitacion> listaHabSeleccionadas) {
		//muestra datos del alojamiento
		vista.detallesReserva.textPDatosAlo.setText((String) "Ciudad: " + modelo.reserva.getAlojamiento().getUbicacion() + "\n" + "C�digo del hotel: "+ modelo.reserva.getAlojamiento().getCodAlojamiento() + "\n" + "Hotel: " +modelo.reserva.getAlojamiento().getNombre()+"\n" + "N�mero de estrellas:" + modelo.hotel.getEstrellas() );
		
		//muestra el PRECIO TOTAL DE LA RESERVA: 
		calcularPrecioReservaHotel(listaHabSeleccionadas);
		
		//SE MUESTRA EL PRECIO TOTAL:
	  	vista.detallesReserva.tFPrecioReserva.setText((String.format("%.2f", modelo.precioTotal))+ " �");
	}
	
	/**
	 * M�todo insertarReservasHabitacionesSel = inserta en la base de datos las reservas de las habitaciones seleccionadas del hotel (inserta una reserva por cada habitaci�n de hotel seleccionada)
	 */
	public void insertarReservasHabitacionesSel() {
		
		for(int i=0; modelo.listaReservas.size()>i; i++) {
			modelo.consultas.insertarReserva(modelo.listaReservas, i, modelo.cliente.getDni(), modelo.fechaIda, modelo.fechaVuelta);
		}
	}
	
	/**
	 * M�todo generarFicherosReservasHabitacionesSel = genera un fichero por cada habitaci�n de hotel reservada.
	 */
	public void generarFicherosReservasHabitacionesSel() {
		//guarda los datos de la reserva en en un fichero, 1 reserva por cada habitaci�n. 
		for(int i=0; modelo.listaReservas.size()>i; i++) {
			modelo.funcionesReserva.imprimirReservaHabitacionesHotel(modelo, vista, i);
		}
	}
	
	

	
}

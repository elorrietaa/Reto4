package controlador;

import java.text.DecimalFormat;
import java.util.ArrayList;

import modelo.Cama;
import modelo.Dormitorio;
import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class FuncionesReserva {
	
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	public float precioHabitacion;
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
	public float calcularPrecioReservaHotel( ArrayList<Dormitorio> listaHabSeleccionadas) {
		float precioReserva=0;
		
		//(1º) el precio total de la reserva será la suma de los precios de las habitaciones seleccionadas
		for(int i=0; i<listaHabSeleccionadas.size();i++) {
			precioReserva = precioReserva + listaHabSeleccionadas.get(i).getPrecioHabitacion();
		}
		
		//(2º) calcular el precio en función del NÚMERO DE NOCHES seleccionadas por el usuario.
		int numNoches = calcularNochesReservadas();  
		
		precioReserva = precioReserva*numNoches;
		
		//(3º)Redondeamos a 2 decimales
		precioReserva = Math.round(precioReserva*100); //redondear a dos decimales
		precioReserva = precioReserva/100;//redondear a dos decimales
		
		//(4º) metemos el precio total de la reserva en el modelo:
		modelo.precioTotal = precioReserva;
		System.out.println("EL PRECIO TOTAL DE LA RESERVA DE TODAS LAS HABS DEL HOTEL ES calcularPrecioReservaHotel "+modelo.precioTotal);
		
		return precioReserva;
	}
	
	/** 
	 * Método calcularPrecioHabXNoches = calcula el precio de una habitación por el número de noches que se desea reservar
	 * @param listaHabSeleccionadas = se le pasa la lista con la shabitaciones seleccionadas
	 * @param pos = la posición que está recorriendo un for.
	 * @return
	 */
	public float calcularPrecioHabXNoches( ArrayList<Dormitorio> listaHabSeleccionadas, int pos) {
		float precioHabXnoches=0;
		 DecimalFormat f = new DecimalFormat("##.00");
		//(1º) Calcular el precio en función del NÚMERO DE NOCHES seleccionadas por el usuario.
		int numNoches = calcularNochesReservadas();
		
		//calcular el precio de la habitacion x noches.
		precioHabXnoches = listaHabSeleccionadas.get(pos).getPrecioHabitacion() * numNoches;
		
		precioHabXnoches = Math.round(precioHabXnoches*100); //redondear a dos decimales
		precioHabXnoches = precioHabXnoches/100;//redondear a dos decimales
		
		return precioHabXnoches;
	}
	
	
	/**
	 * Método calcularNochesReservadas = calcula el número de noches reservadas por el usuario.
	 */
	public int calcularNochesReservadas() { 
		int numNoches=(int) ((modelo.fechaVuelta.getTime()-modelo.fechaIda.getTime())/86400000);
		 
		//metemos el número de noches en el modelo:
		modelo.numNoches = numNoches;
		System.out.println("Noches reservadas:  "+modelo.numNoches);
		
		//mostramos num de noches en la vista 
		vista.detallesReserva.textFieldNumNoches.setText(Integer.toString(modelo.numNoches));
		
		return numNoches;
	}
	
	

	/**
	 * Método mostrarDatosReserva = muestra los datos de la reserva. Los datos de la reserva son aquellos datos seleccionados por el usuario. 
	 */
	public void mostrarDatosReserva(ArrayList<Dormitorio> listaHabSeleccionadas) {
		//muestra datos del alojamiento
		vista.detallesReserva.textPDatosAlo.setText((String) "Ciudad: " + modelo.reserva.getAlojamiento().getUbicacion() + "\n" + "Código del hotel: "+ modelo.reserva.getAlojamiento().getCodAlojamiento() + "\n" + "Hotel: " +modelo.reserva.getAlojamiento().getNombre()+"\n" + "Número de estrellas:" + modelo.hotel.getEstrellas() );
		
		//muestra el PRECIO TOTAL DE LA RESERVA: 
		calcularPrecioReservaHotel(listaHabSeleccionadas);
		
		//SE MUESTRA EL PRECIO TOTAL:
	  	vista.detallesReserva.tFPrecioReserva.setText((String.format("%.2f", modelo.precioTotal))+ " €");
	}
	
	/**
	 * Método insertarReservasHabitacionesSel = inserta en la base de datos las reservas de las habitaciones seleccionadas del hotel (inserta una reserva por cada habitación de hotel seleccionada)
	 */
	public void insertarReservasHabitacionesSel() {
		
		for(int i=0; modelo.listaReservas.size()>i; i++) {
			modelo.consultas.insertarReserva(modelo.listaReservas, i, modelo.cliente.getDni(), modelo.fechaIda, modelo.fechaVuelta);
		}
	}
	
	/**
	 * Método generarFicherosReservasHabitacionesSel = genera un fichero por cada habitación de hotel reservada.
	 */
	public void generarFicherosReservasHabitacionesSel() {
		//guarda los datos de la reserva en en un fichero, 1 reserva por cada habitación. 
		for(int i=0; modelo.listaReservas.size()>i; i++) {
			modelo.funcionesReserva.imprimirReservaHabitacionesHotel(modelo, vista, i);
		}
	}
	
	/**
	 * Método: mostrarTiposDeCamas = devuelve un String que contiene el número de camas de cada tipo que hay.
	 * @param listaCamas
	 * @return
	 */
	public String mostrarTiposDeCamas(ArrayList<Cama> listaCamas) {
		System.out.println("****TIPOS DE CAMAS DE LA HABITACIÓN SELECCIONADA***");
		String tiposCamaHab = "";
		int numTipCam [] = new int [3];
		
		for (int i=0; listaCamas.size()>i; i++) {
			if(listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("simple")) {
				numTipCam[0] = numTipCam[0] +1;
			}
			else if(listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("matrimonio")) {
				numTipCam[1] = numTipCam[1] + 1;
			}
			else if(listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("infantil")) {
				numTipCam[2] = numTipCam[2] + 1;
			}
			System.out.println(listaCamas.get(i).getTipoCama().toString());
		
		}
		//se rellena el String con los tipos de cama 
		tiposCamaHab = numTipCam[0] + " simple, " + numTipCam[1] + " matrimonio y " + numTipCam[2] + " infantil.";
		System.out.println(tiposCamaHab);
		
	
		
		return tiposCamaHab;
	}
	
	/*
	public String mostrarStringTiposCama(int [] numTipCam) {
		String tiposCamaHab = "";
		for (int i=0; numTipCam.length>i; i++) {
			tiposCamaHab = numTipCam[0] + " camas simples, " + numTipCam[1] + " camas de matrimonio y " + numTipCam[2] + " cunas o camas infantiles.";
		}
		System.out.println(tiposCamaHab);
		
		return tiposCamaHab;
	}
	*/
}

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
	 * Método mostrarTiposDeCamas = a partir del ArrayList<Cama> listaCamas genera un array numTipCam y un String TiposCamaHab.
	 * 
	 * @param listaCamas = contiene una lista con las camas que hay en la habitación
	 * numTipCam [] = es un array que contiene el número de camas de cada tipo que hay en la habitación.
	 * tiposCamaHab = string en el que se resumen los detalles de las camas de la habitación. 
	 * 
	 * Por último, se añaden el array numTipCam [] y el String tiposCamaHab al modelo.
	 */
	public int [] mostrarTiposDeCamas() {
		System.out.println("****TIPOS DE CAMAS DE LA HABITACIÓN SELECCIONADA***");

		listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(modelo.habitacion.getCodHabitacion());
		
		int numTipCam [] = new int [3];
		String tiposCamaHab = "";
		
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
		
		//String tiposCamaHab en el que se resumen los detalles de las camas de la habitación
		tiposCamaHab = " " + numTipCam[0] + " camas simples, "+ numTipCam[1] + " camas de matrimonio,  " + numTipCam[2] + " cuna o cama extra.";
		System.out.println(tiposCamaHab);
		
		//se añaden tiposCamaHab y numTipCam al objeto habitación del modelo
		modelo.habitacion.setTiposCamaHab(tiposCamaHab); 
		modelo.habitacion.setNumTipCam(numTipCam);
		
		return numTipCam;
	}
	

	/** (NO ESTA PUESTO AUN EN NINGUN SITIO, NO SE SI FUNCIONA)
	 * mostrarCamasDeLasHabitaciones = muestra los detalles de las camas de las habitaciones disponibles 
	 */
	 public void mostrarCamasDeLasHabitaciones() {
		System.out.println("****TIPOS DE CAMAS DE todas las habitaciones de la listahabitaciones***");
		
		for(int i=0; listaHabitaciones.size()>i; i++) {
			listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(modelo.habitacion.getCodHabitacion());
		}
		
	}
	
	
	
	/**
	 * Metodo para calcular el precio de la reserva
	 * 
	 * @param reserva Objeto con la informacion de la reserva
	 * 
	 * @return Retorna el precio de la reserva 
	 */
	public float calcularPrecioReserva(int [] numTipCam) {
		//(1º) El precio inicial de la reserva es el precio del alojamiento
		float precioAlojamiento = modelo.hotel.getPrecioAlojamiento();
		float precioReserva = precioAlojamiento;
		
		
		//(2º) Calcular el precio en función del TIPO DE CAMA DE LA HABITACIÓN: 
		precioReserva = calcularPrecioPorHabitacion(numTipCam, precioAlojamiento);
		
		//(3º) Calcular el precio en función del NÚMERO DE NOCHES seleccionadas por el usuario.
		int nochesReservadas = calcularNochesReservadas();
		
		precioReserva = precioReserva*nochesReservadas;
		
		
		
		return precioReserva;
	}
	
	public float  calcularPrecioPorHabitacion(int [] numTipCam, float precioAlojamiento) {
		//El precio inicial de la reserva es el precio del alojamiento
		float precioReserva = precioAlojamiento;
		
		//CALCULAR EL PRECIO EN FUNCIÓN DEL TIPO DE CAMA DE LA HABITACIÓN: 
				for(int i=0; numTipCam.length>i; i++) {
					if(numTipCam[0]!=0) {
						precioReserva= (float) (precioReserva + (precioAlojamiento*0.05*numTipCam[0])) ;
					}
					if(numTipCam[1]!=0) {
						precioReserva= (float) (precioReserva + (precioAlojamiento*0.1*numTipCam[1])) ;
					}
					if(numTipCam[2]!=0) {
						precioReserva= (float) (precioReserva + (precioAlojamiento*0.15*numTipCam[2])) ;
					}
				}
		
		return precioReserva;
	}
	
	/**
	 * Método calcularNochesReservadas = calcula el número de noches reservadas por el usuario.
	 */
	public int calcularNochesReservadas() {
		
		int nochesReservadas=(int) ((modelo.fechaVuelta.getTime()-modelo.fechaIda.getTime())/86400000);
		System.out.println("Noches reservadas:  "+nochesReservadas);
		return nochesReservadas;
	}
	
	/**
	 * Método generarReserva = se rellena el objeto reserva con los datos seleccionados
	 */
	public void generarReserva(int [] numTipCam) {
		//(1º) genera un código de reserva en función de las reservas que haya en la BBDD
		int codReservaProc = modelo.consultas.mostrarNumReservasConProcedimiento();
		System.out.println("num reservas con procedimientooooo" + codReservaProc);
		int codReserva = modelo.consultas.mostrarNumReservas() +1;
		
		System.out.println("código de la reserva: " + codReserva);
		
		//(2º) Calcula el precio de la reserva: 
		precioReserva = controlador.funcionesReserva.calcularPrecioReserva(numTipCam);
		System.out.println("Precio reserva calculado: " + precioReserva);
		
		//(3º) rellenamos el objeto reserva y se pasa la reserva al modelo //el precio Reserva es el precio calculado en el método:
		modelo.reserva = new Reserva(codReserva, modelo.cliente , modelo.hotel, modelo.habitacion, modelo.fechaIda, modelo.fechaVuelta, this.precioReserva);
	
		
	} 
	  

	/**
	 * Método mostrarDatosReserva = muestra los datos de la reserva. Los datos de la reserva son aquellos datos seleccionados por el usuario. 
	 */
	public void mostrarDatosReserva() {
		//muestra datos del alojamiento
		vista.detallesReserva.textPDatosAlo.setText((String) "Ciudad: " + modelo.reserva.getAlojamiento().getUbicacion() + "\n" + "Código del hotel: "+ modelo.reserva.getAlojamiento().getCodAlojamiento() + "\n" + "Hotel: " +modelo.reserva.getAlojamiento().getNombre()+"\n" + "Número de estrellas:" + modelo.hotel.getEstrellas() );
		
		vista.detallesReserva.textPDetallesHabi.setText((String) "Código de la habitación: " + modelo.habitacion.getCodHabitacion() + "\n" + "Tipo de habitación: "+ modelo.habitacion.getTipoHabitacion() + "\n" + "Número de camas de la habitación: "+ modelo.habitacion.getNumCamas() + "\n" + "Tipo de camas: "+ modelo.habitacion.getTiposCamaHab());
		
		//muestra el PRECIO TOTAL DE LA RESERVA: 
		//EN EL FUTURO SE CALCULARÁ SUMANDO EL PRECIO DE TODAS LAS RESERVAS REALIZADAS
	  	vista.detallesReserva.tFPrecioReserva.setText(Float.toString(modelo.reserva.getPrecioReserva())+ " €");
	  	modelo.precioTotal=modelo.reserva.getPrecioReserva();
	}
	

	
}

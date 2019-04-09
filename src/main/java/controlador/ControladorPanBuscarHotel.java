package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import bbdd.*;
import modelo.Ciudad;
import modelo.Consultas;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.PrincipalModelo;
import modelo.Reserva;
import vista.*;

/**
 * Clase: ControladorPanBuscarHotel: contiene los métodos utilizados en el Panel PanBuscarHotel.
 * @author IN1DM3B_09
 *
 */
public class ControladorPanBuscarHotel implements ActionListener{
	public JframePrincipal vista;
	public PrincipalModelo modelo;
	private ArrayList<Ciudad> listaCiudades;
	private ArrayList<Hotel> listaHoteles;
	private ArrayList<Habitacion> listaHabitaciones;
	private ArrayList<Object> listaDetallesReserva;
	Ciudad ciudad;
	Hotel hotel;
	Habitacion habitacion;
	Reserva reserva;
	Consultas consultas;
	float precioReserva=-1;
	
	/**
	 * Constructor del controlador del panel de bienvenida
	* @param vista Instancia de la vista, para poder utilizarla
	* @param modelo Instancia del modelo, para poder utilizarlo
	*/
	public ControladorPanBuscarHotel(JframePrincipal vista, PrincipalModelo modelo, Conexion conexion) {
		this.vista = vista;
		this.modelo = modelo;
		this.consultas = new Consultas(conexion);
    }
    /**
	 * Se crean los listeners del panel
	 */
    public void addListeners() {
    	vista.buscarHotel.cBCiudad.addActionListener(this);
    	vista.buscarHotel.buttonContinuar.addActionListener(this);
    	vista.buscarHotel.btnMostrarDetalles.addActionListener(this);
    	vista.buscarHotel.btnMostrarHabDisp.addActionListener(this);
    }
    /**
     * Método mostrarCiudad = muestra las ciudades que se han buscado en el método BuscarCiudad (en la BBDD)
     * @param listaCiudades
     */
    public void mostrarCiudad() {
		ArrayList<Ciudad> listaCiudades;
		listaCiudades = consultas.BuscarCiudad();
		for(int i=0; i<listaCiudades.size();i++) {
		    ciudad=listaCiudades.get(i);
		    vista.buscarHotel.cBCiudad.addItem(ciudad);
		}
    }
    
    /**
     * Método mostrarHoteles = muestra los hoteles que se han encontrado mediante el método BuscarHotelesPorCodigoCiudad en base al codCiudadSeleccionado por el usuario
     * @param codCiudadSeleccionada
     */
    public void mostrarHotelesEnElJList(int codCiudadSeleccionada) {
    	//borra todos los elementos del JList
    	vista.buscarHotel.modeloHotel.removeAllElements();
    	//llena el arrayList con la lista de Hoteles
    	listaHoteles = consultas.BuscarHotelPorCodigoCiudad(codCiudadSeleccionada);
    	//muestra en elJlist listHoteles la lista de hoteles de la ciudad seleccionada
	  	for(int i=0; i<listaHoteles.size();i++) {
	  		vista.buscarHotel.modeloHotel.addElement(listaHoteles.get(i));
			vista.buscarHotel.listHoteles.setModel(vista.buscarHotel.modeloHotel);
	  	}
    }
    
    /**
     * Método mostrarHabitacionesEnElJList = muestra las habitaciones que se han encontrado mediante el método: buscarHabitacionPorCodigoHotel pasando hotel, codHotelSeleccionado por parámetro. El codHotelSeleccionado dependerá del hotel seleccionado por el usuario
     * @param codHotelSeleccionado
     */
    public void mostrarHabitacionesEnElJList(int codHotelSeleccionado) {
    	//borra todos los elementos del JList
    	vista.buscarHotel.modeloHabitacion.removeAllElements();
    	//llena el arrayList con la lista de Hoteles
    	listaHabitaciones = consultas.buscarHabitacionPorCodigoHotel(hotel, codHotelSeleccionado);
    	//muestra en elJlist listHoteles la lista de hoteles de la ciudad seleccionada
	  	for(int i=0; i<listaHabitaciones.size();i++) {
	  		vista.buscarHotel.modeloHabitacion.addElement(listaHabitaciones.get(i));
	  		//prueba
	  		System.out.println("dff:" + listaHabitaciones.get(i));
			vista.buscarHotel.listHabitacion.setModel(vista.buscarHotel.modeloHabitacion);
	  	}
    }
  

    /**
     * Método: guardarDatosSeleccionados = guarda los datos seleccionados por el usuario en los objetos.
     */
	public void guardarDatosSeleccionadosCiudadYHotel() {
		//se guarda la ciudad seleccionada
		this.ciudad = (Ciudad) vista.buscarHotel.cBCiudad.getSelectedItem();
		//Pruebas
		System.out.println("***DATOS CIUDAD***:Ciudad:" + ciudad);
	    //se guarda el hotel seleccionado con la JLIST
	    this.hotel = (Hotel) vista.buscarHotel.listHoteles.getSelectedValue();
	    //Pruebas
	    System.out.println("***DATOS HOTEL***: Código del hotel:" + hotel.getCodAlojamiento());
	    System.out.println("Nombre hotel:" + hotel.getNombre());
	    System.out.println("Precio hotel:" + hotel.getPrecioAlojamiento());
	    System.out.println("Ubicación hotel:" + hotel.getUbicacion());
	    System.out.println("Número de estrellas:" + hotel.getEstrellas());
	    
	}
	
	/**
	 * Método generarReserva = se rellena el objeto reserva con los datos seleccionados
	 */
	public void generarReserva() {
		 this.hotel = (Hotel) vista.buscarHotel.listHoteles.getSelectedValue();
		int codReservaQueSeCogeriaDeBBDD = 50;
		int codReserva = codReservaQueSeCogeriaDeBBDD +1;
		
		//rellenamos el objeto reserva: ¡¡¡ EN EL FUTURO PRECIO
		this.reserva = new Reserva(codReserva, hotel, precioReserva);
	}
	
	/**
	 * Método mostrarDatosHotelSeleccionado = muestra en el textPaneDetHot los datos del hotel seleccionado por el usuario
	 */
	public void mostrarDatosHotelSeleccionado() {
		 this.hotel = (Hotel) vista.buscarHotel.listHoteles.getSelectedValue();
		vista.buscarHotel.textPaneDetHot.setText("Nombre hotel:" + hotel.getNombre()+ "\n" + "Precio hotel:" + hotel.getPrecioAlojamiento() + "€" + "\n" + "Ubicación hotel:" + hotel.getUbicacion()+ "\n" + "Número de estrellas:" + hotel.getEstrellas());
	    //pruebas
		System.out.println("***DATOS HOTEL***: Código del hotel:" + hotel.getCodAlojamiento());
	    System.out.println("Nombre hotel:" + hotel.getNombre());
	  
	}
	
	/**
	 * Método mostrarDatosReserva = muestra los datos de la reserva. Los datos de la reserva son aquellos datos seleccionados por el usuario. 
	 */
	public void mostrarDatosReserva() {
		
		//muestra datos del alojamiento
		this.modelo.precioTotal = this.hotel.getPrecioAlojamiento();
	    	vista.detallesReserva.textPDatosAlo.setText((String) "Ciudad: " + this.ciudad.getNombreCiudad() + "\n" + "Hotel: " + hotel.getNombre()+"\n" + "Número de estrellas:" + hotel.getEstrellas());
	  //muestra  el precio de la reserva
	  	this.modelo.precioTotal = this.hotel.getPrecioAlojamiento();
	  		vista.detallesReserva.tFPrecioReserva.setText(Float.toString(this.hotel.getPrecioAlojamiento())+ " €");
	}
	
	/**
	 * Método actualizarSiguientePanelDetalles = actualiza el Siguiente panel: PanDetallesReserva en el que se muestran los detalles de la reserva
	 */
	public void actualizarSiguientePanelDetalles() {
		//muestra en la siguiente pantalla el precio de la reserva
		mostrarDatosReserva();
		
	    //muestra el siguiente panel: PanelDetallesReserva
	    vista.detallesReserva.setVisible(true);
	    vista.buscarHotel.setVisible(false);
	}
	
    /**
	 * Accion de los distintos listeners
	 */
	public void actionPerformed(ActionEvent e) {
				
		Object sourceObject = e.getSource();
		
		if (sourceObject instanceof JButton) {
			
			String botonPulsado = ((JButton) sourceObject).getActionCommand();
		   
			// comprobamos que boton se ha pulsado y ejecutamos sus acciones
			switch (botonPulsado) {
			
			case "Mostrar detalles del hotel seleccionado:":
				
				this.hotel = (Hotel) vista.buscarHotel.listHoteles.getSelectedValue();
				if (hotel != null) {
					mostrarDatosHotelSeleccionado();
				}
				else {
					 JOptionPane.showMessageDialog(vista, "Por favor, seleccione el alojamiento del que desea ver más detalles. Gracias. ", null, 0);
				}
				break;
				
			case "Mostrar habitaciones disponibles del hotel seleccionado:":
				
				this.hotel = (Hotel) vista.buscarHotel.listHoteles.getSelectedValue();
				if (hotel != null) {
					//muestra las habitaciones en el JList
					int codHotelSeleccionado = hotel.getCodAlojamiento();
	//no muestra bien las habitaciones
	//			mostrarHabitacionesEnElJList(codHotelSeleccionado);	
				}
				else {
					 JOptionPane.showMessageDialog(vista, "Por favor, seleccione el alojamiento del que desea ver más detalles. Gracias. ", null, 0);
				}
				break;
				
			case "Continuar":	
				
				this.hotel = (Hotel) vista.buscarHotel.listHoteles.getSelectedValue();
				if (hotel != null) {
					//Cuando pulsa el boton continuar pasan las siguientes cosas: 
					// (1º) Calcula el precio de la reserva:
					//precioReserva = modelo.funcionesReserva.calcularPrecioReserva(hotel, reserva);
					
				    //(2º)pasa al panel Detalles Reserva los datos seleccionados en el panel SeleccionarAlojamiento
					guardarDatosSeleccionadosCiudadYHotel();
					
					//(3º)Generar reserva y guardarla en el objeto reserva
					generarReserva();
					
					//(4º)actualiza el siguiente panel:
					actualizarSiguientePanelDetalles();
				}
				
				else {
					 JOptionPane.showMessageDialog(vista, "Por favor, seleccione un alojamiento para continuar. Gracias. ", null, 0);
				}
				
				break;
			
			}
	
		} else if (sourceObject instanceof JComboBox) {
			// guarda la ciudad seleccionada
			Ciudad ciudad = (Ciudad) vista.buscarHotel.cBCiudad.getSelectedItem();
			if (ciudad != null) {
				int codCiudadSeleccionada = ciudad.getCodCiudad();
				//muestra los hoteles en el JList
				mostrarHotelesEnElJList(codCiudadSeleccionada);
			}
		}
		
	}
	
}

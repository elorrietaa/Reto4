package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;

import bbdd.*;
import modelo.Ciudad;
import modelo.Consultas;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.PrincipalModelo;
import modelo.Reserva;
import vista.*;

/**
 * Clase: ControladorPanBuscarHotel: contiene los m�todos utilizados en el Panel PanBuscarHotel.
 * @author IN1DM3B_09
 *
 */
public class ControladorPanBuscarHotel implements ActionListener, PropertyChangeListener {
	public JframePrincipal vista;
	public PrincipalModelo modelo; 
	public PrincipalControlador controlador;
	
	private ArrayList<Ciudad> listaCiudades;
	private ArrayList<Hotel> listaHoteles;
	private ArrayList<Habitacion> listaHabitaciones;
	private ArrayList<Object> listaDetallesReserva; 
	Ciudad ciudad;
	Hotel hotel;
	Habitacion habitacion;
	Reserva reserva;
	Consultas consultas;
	Date fechaIda;
	Date fechaVuelta;
	
	
	
	/**
	 * Constructor del controlador del panel de bienvenida
	* @param vista Instancia de la vista, para poder utilizarla
	* @param modelo Instancia del modelo, para poder utilizarlo
	*/
	public ControladorPanBuscarHotel(JframePrincipal vista, PrincipalModelo modelo, Conexion conexion, PrincipalControlador controlador) {
		this.vista = vista;
		this.modelo = modelo;
		this.consultas = new Consultas(conexion);
		this.controlador = controlador;
    }
    /**
	 * Se crean los listeners del panel
	 */
    public void addListeners() {
    	vista.buscarHotel.cBCiudad.addActionListener(this);
    	vista.buscarHotel.buttonContinuar.addActionListener(this);
    	vista.buscarHotel.btnMostrarDetalles.addActionListener(this);
    	vista.buscarHotel.fechaIda.addPropertyChangeListener(this);
    	vista.buscarHotel.fechaVuelta.addPropertyChangeListener(this);
    }
    /**
     * M�todo mostrarCiudad = muestra las ciudades que se han buscado en el m�todo BuscarCiudad (en la BBDD)
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
     * M�todo mostrarHoteles = muestra los hoteles que se han encontrado mediante el m�todo BuscarHotelesPorCodigoCiudad en base al codCiudadSeleccionado por el usuario
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
     * M�todo: guardarDatosSeleccionados = guarda los datos seleccionados por el usuario en los objetos.
     */
	public void guardarDatosSeleccionadosCiudad() {
		//se guarda la ciudad seleccionada
		this.ciudad = (Ciudad) vista.buscarHotel.cBCiudad.getSelectedItem();
		//Pruebas
		System.out.println("***DATOS CIUDAD***:Ciudad:" + ciudad);
	    
	}
	public void guardarDatosSeleccionadosHotel() {
		
	    //se guarda el hotel seleccionado con la JLIST
	    this.hotel = (Hotel) vista.buscarHotel.listHoteles.getSelectedValue();
	    
	    //le pasa el hotel al modelo
	    modelo.hotel = this.hotel;
	    //Pruebas
	    System.out.println("***DATOS HOTEL***: C�digo del hotel:" + hotel.getCodAlojamiento());
	    System.out.println("Nombre hotel:" + hotel.getNombre());
	    System.out.println("Precio hotel:" + hotel.getPrecioAlojamiento());
	    System.out.println("Ubicaci�n hotel:" + hotel.getUbicacion());
	    System.out.println("N�mero de estrellas:" + hotel.getEstrellas());
	    
	    //en el futuro aqui los datos de la habitacion, guardarlos y pasarlos a modelo
	}
	
	public void guardarDatosSeleccionadosFechas() {
		//se guarda la fecha seleecionada en el JCalendar:
		//this.fechaIda= (Date) vista.buscarHotel.fechaIda.getDate();
		
	}
	

	/**
	 * M�todo mostrarDatosHotelSeleccionado = muestra en el textPaneDetHot los datos del hotel seleccionado por el usuario
	 */
	public void mostrarDatosHotelSeleccionado() {
		 this.hotel = (Hotel) vista.buscarHotel.listHoteles.getSelectedValue();
		vista.buscarHotel.textPaneDetHot.setText("Nombre hotel:" + hotel.getNombre()+ "\n" + "Precio hotel:" + hotel.getPrecioAlojamiento() + "�" + "\n" + "Ubicaci�n hotel:" + hotel.getUbicacion()+ "\n" + "N�mero de estrellas:" + hotel.getEstrellas());
	    //pruebas
		System.out.println("***DATOS HOTEL***: C�digo del hotel:" + hotel.getCodAlojamiento());
	    System.out.println("Nombre hotel:" + hotel.getNombre());
	  
	}
	
	/**
     * M�todo mostrarHabitacionesEnElJList = muestra las habitaciones que se han encontrado mediante el m�todo: buscarHabitacionPorCodigoHotel pasando hotel, codHotelSeleccionado por par�metro. El codHotelSeleccionado depender� del hotel seleccionado por el usuario
     * @param codHotelSeleccionado
     */
    public void mostrarHabitacionesEnJList(int codHotelSeleccionado) {
    	//borra todos los elementos del JList de mostrarHabitacionesEnJList
    	vista.selHabitacion.modeloHabitacion.removeAllElements();
    	//llena el arrayList con la lista de Hoteles
    	listaHabitaciones = consultas.buscarHabitacionPorCodigoHotel(hotel, codHotelSeleccionado);
    	//muestra en elJlist listHoteles la lista de hoteles de la ciudad seleccionada
	  	for(int i=0; i<listaHabitaciones.size();i++) {
	  		vista.selHabitacion.modeloHabitacion.addElement(listaHabitaciones.get(i));
	  		//prueba
	  		System.out.println("dff:" + listaHabitaciones.get(i));
			vista.selHabitacion.listHabitacion.setModel(vista.selHabitacion.modeloHabitacion);
	  	}
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
					 JOptionPane.showMessageDialog(vista, "Por favor, seleccione el alojamiento del que desea ver m�s detalles. Gracias. ", null, 0);
				}
				break;
				
				
			case "Continuar":	
				
				this.hotel = (Hotel) vista.buscarHotel.listHoteles.getSelectedValue();
				if (hotel != null) {
					//Cuando pulsa el boton continuar pasan las siguientes cosas: 
					 
				    //(1�)guarda los datos seleecionados en el modelo
					guardarDatosSeleccionadosCiudad();
					guardarDatosSeleccionadosHotel();
					System.out.println(fechaIda);
					//guardarDatosSeleccionadosFechas();
					
					//muestra en el siguiente panel las habitaciones en funcion del hotel seleccionado por el usuario
					mostrarHabitacionesEnJList(hotel.getCodAlojamiento());
					//EN EL FUTURO: MOSTRAR HABITACIONES Y CAMAS EN JTABLE: M�TODO buscarCamaPorCodigoHabitacion EXISTE EN CONSULTAS
					
					//3� Actualiza el siguiente panel:
				    //muestra el siguiente panel: PanelSelHabitacion
				    vista.buscarHotel.setVisible(false);
				    vista.selHabitacion.setVisible(true);
				   
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
	/**
	 * Listener de la fecha
	 */
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		// guardamos el nombre del boton pulsado
		JCalendar botonPulsado = ((JCalendar) e.getSource());
		
		if (botonPulsado == vista.buscarHotel.fechaIda) {	
			fechaIda = new Date(vista.buscarHotel.fechaIda.getDate().getTime());
			//guardamos fechaIda seleccionada en el modelo
			System.out.println("La fecha idaaaa:" + fechaIda);
			//no va// modelo.reserva.setFechaIda(fechaIda);
			
	
		} else {	
			fechaVuelta = new Date(vista.buscarHotel.fechaVuelta.getDate().getTime());
		}		
	
	}

}

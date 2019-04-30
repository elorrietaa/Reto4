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
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import bbdd.*;
import modelo.Alojamiento;
import modelo.Cama;
import modelo.Ciudad;
import modelo.Consultas;
import modelo.Dormitorio;
import modelo.Hotel;
import modelo.PrincipalModelo;
import modelo.Reserva;
import modelo.TipoAlojamiento;
import vista.*;

/**
 * Clase: ControladorPanBuscarHotel: contiene los métodos utilizados en el Panel PanBuscarHotel.
 * @author IN1DM3B_09
 *
 */
public class ControladorPanBuscarHotel implements ActionListener, PropertyChangeListener {
	public JframePrincipal vista;
	public PrincipalModelo modelo; 
	public PrincipalControlador controlador;

	private ArrayList<Hotel> listaHoteles;
	public ArrayList<Dormitorio> listaDormitorios;

	
	Ciudad ciudad;
	TipoAlojamiento tiposAloj;
	Hotel hotel;
	Dormitorio habitacion;
	Reserva reserva;
	Consultas consultas;
	
	Date fechaIda;
	Date fechaVuelta;
	Date fechaActual = null;
	int numTipCam [] = new int [3];
	boolean continuar = false;
	int filaHotelsel = -1;
	
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
    	vista.buscarHotel.btnInicioSesion.addActionListener(this);
    	vista.buscarHotel.btnRegistro.addActionListener(this);
    	vista.buscarHotel.fechaIda.addPropertyChangeListener(this);
    	vista.buscarHotel.fechaVuelta.addPropertyChangeListener(this);
    }
    
    /**
     * Método: mostrarCiudad = muestra las ciudades que se han buscado en el método BuscarCiudad (en la BBDD)
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
     * Método: mostrarTiposAloj = muestra las ciudades que se han buscado en el método BuscarCiudad (en la BBDD)
     * @param listaCiudades
     */
    public void mostrarTiposAloj() { 
    	ArrayList<TipoAlojamiento> listaTiposAlojamiento;
    	listaTiposAlojamiento = consultas.BuscarTiposAlojamiento();
		for(int i=0; i<listaTiposAlojamiento.size();i++) {
		    tiposAloj=listaTiposAlojamiento.get(i);
		    vista.buscarHotel.cBTipoAloj.addItem(tiposAloj); 
		}
    }
    
    /**
     * Método: guardarDatosSeleccionados = guarda los datos seleccionados por el usuario en los objetos.
     */
	public void guardarDatosSeleccionadosCiudad() {
		//se guarda la ciudad seleccionada
		this.ciudad = (Ciudad) vista.buscarHotel.cBCiudad.getSelectedItem();
		//Pruebas
		System.out.println("***DATOS CIUDAD***:Ciudad:" + ciudad);
	    
	}
	
	/**
     * Método: guardarDatosSeleccionadosTipoAloj = guarda los datos seleccionados por el usuario en los objetos.
     */
	public void guardarDatosSeleccionadosTipoAloj() {
		//se guarda la ciudad seleccionada
		this.tiposAloj = (TipoAlojamiento) vista.buscarHotel.cBTipoAloj.getSelectedItem();
		//Pruebas
		System.out.println("***DATOS Tipo Alojamiento***:" + tiposAloj);
	    
	}
	
	/**
     * Método: mostrarHotelesEnJTable = muestra los hoteles que se han encontrado mediante el método BuscarHotelesPorCodigoCiudad en base al codCiudadSeleccionado por el usuario
     * @param codCiudadSeleccionada
     */
    public void mostrarHotelesEnJTable(int codCiudadSeleccionada) {
	  	// Mostrar los datos de las habitaciones en tabla de la siguiente pantalla: PanSelHabitacion
			DefaultTableModel tablaHotel = (DefaultTableModel) vista.buscarHotel.tab.getModel();
			
	  	//llena el arrayList con la lista de Hoteles
	   	listaHoteles = consultas.BuscarHotelPorCodigoCiudad(codCiudadSeleccionada);
		Object[] datos = new Object[2];
		tablaHotel.setRowCount(0);
		for(int i=0; i<listaHoteles.size();i++) {
			datos[0] = listaHoteles.get(i).getNombre();
			datos[1] = listaHoteles.get(i).getEstrellas();
			tablaHotel.addRow(datos);
		}
	  	
    }
	
	
	 /**
     * Método: guardarDatosSeleccionados = guarda los datos seleccionados por el usuario en los objetos.
     */
	public void guardarDatosSeleccionadosHotel() {
	    //se guarda en filaHotelsel la posición seleccionada en la tabla
	    int filaHotelsel = vista.buscarHotel.tab.getSelectedRow(); 	 
	    
	    //se guarda el hotel seleccionado en la tabla
	    this.hotel = (Hotel) listaHoteles.get(filaHotelsel);
	    
	    //le pasa el hotel al modelo
	    modelo.hotel = this.hotel;
	}
	

	/**
	 * Método: guardarDatosSeleccionadosFechas = guarda las fechas seleccionadas en el JCalendar en el modelo.
	 */
	public void guardarDatosSeleccionadosFechas() {
	    	if (fechaIda == null) {
	    	    fechaIda = consultas.mostrarFechaActual();
	    	}
	    	if (fechaVuelta == null) {
	    	    fechaVuelta = consultas.mostrarFechaActual();
	    	}
		//metemos las fechas en el modelo
		modelo.fechaIda = this.fechaIda;
		modelo.fechaVuelta = this.fechaVuelta;
		
		//pruebas:
		System.out.println("Fecha ida:" + fechaIda + "Fecha vuelta:" + fechaVuelta);
		
	}
	
	/**
	 * Método: mostrarDetallesHabs = se muestran los detalles de las habitaciones
	 * @param tabla Tabla que se rellena con la informacion de las habitaciones
	 */
	public void mostrarDetallesHabs() {
		// Mostrar los datos de las habitaciones en tabla de la siguiente pantalla: PanSelHabitacion
		DefaultTableModel tablaHabs = (DefaultTableModel) vista.selHabitacion.tab.getModel();
		
		Object[] datos = new Object[4];
		tablaHabs.setRowCount(0);
		for(int i=0; i<listaDormitorios.size();i++) {
			datos[0] = listaDormitorios.get(i).getCodHabitacion();
			datos[1] = listaDormitorios.get(i).getNumCamas();
			
			//Mostrar detalles de las camas de la habitación seleccionada: 
			ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(listaDormitorios.get(i).getCodHabitacion());
			String tiposCamaHab = controlador.funcionesReserva.mostrarTiposDeCamas(listaCamas);
			//se añaden tiposCamaHab y numTipCam al objeto habitación del modelo
			//modelo.habitacion.setTiposCamaHab(tiposCamaHab); 
			//modelo.habitacion.setNumTipCam(numTipCam);
			//listaHabitaciones.add(modelo.habitacion);
			
			
			datos[2] = tiposCamaHab;
			
			datos[3] = (String.format("%.2f", listaDormitorios.get(i).getPrecioHabitacion())  + "€");
			tablaHabs.addRow(datos);
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
				case "Continuar":	//Cuando pulsa el boton continuar pasan las siguientes cosas: 
					 //se guarda en filaHotelsel la posición seleccionada en la tabla
				    filaHotelsel = vista.buscarHotel.tab.getSelectedRow(); 	 
				    
					if (filaHotelsel != -1) {
	 
					    //(1º) Guarda los datos seleecionados en el modelo
						guardarDatosSeleccionadosCiudad();
						guardarDatosSeleccionadosTipoAloj();
						guardarDatosSeleccionadosHotel();
						guardarDatosSeleccionadosFechas(); //guarda los datos en el modelo, no en modelo.reserva
						
						//(2º) Control de fechas: no se pueden hacer reservas anteriores a now() , ni reservas de 0 noches
						continuar = controlador.funcionesValidaciones.validarFechaEntradaNoNow(fechaIda, fechaVuelta);
						
						//(3º) muestra en el siguiente panel las habitaciones en funcion del hotel seleccionado por el usuario
						listaDormitorios = consultas.buscarHabitacionDisponiblel(fechaIda, fechaVuelta, hotel.getCodAlojamiento());
						for(int i = 0; i < listaDormitorios.size(); i++) {
							System.out.println(listaDormitorios.get(i).getCodHabitacion());
						}
						
						//si no hay habitaciones disponibles, muestra un mensaje por pantalla: 
						if(listaDormitorios.size()==0) {
							JOptionPane.showMessageDialog(vista, "Lo sentimos, no existen habitaciones disponibles para ese alojamiento en las fechas elegidas. Por favor, realice otra selección. Gracias. ", null, 0);
							continuar = false;
						}
						
						//(4º)MOSTRAR HABITACIONES Y CAMAS EN JTABLE: MÉTODO buscarCamaPorCodigoHabitacion EXISTE EN CONSULTAS
						mostrarDetallesHabs();
						
					
						
						//(5º) Actualiza el siguiente panel, si se cumplen las validaciones.
						if(continuar) {
							vista.buscarHotel.setVisible(false);
							vista.selHabitacion.setVisible(true);
						}
					}
					else
						JOptionPane.showMessageDialog(vista, "Por favor, seleccione un alojamiento para continuar. Gracias. ", null, 0);
					break;
				
				case "Inicio Sesión":
					ControladorLogin.panelOrigen = vista.buscarHotel;
					vista.login.setVisible(true);
					vista.buscarHotel.setVisible(false);
					break;
				
				case "Registro":
					ControladorRegistro.panelOrigen = vista.buscarHotel;
					vista.registro.setVisible(true);
					vista.buscarHotel.setVisible(false);
					break;
			}
		} else if (sourceObject instanceof JComboBox) {
			// guarda la ciudad seleccionada
			Ciudad ciudad = (Ciudad) vista.buscarHotel.cBCiudad.getSelectedItem();
			if (ciudad != null) {
				int codCiudadSeleccionada = ciudad.getCodCiudad();
				
				//muestra los hoteles de la ciudad seleccionada en el JList
				mostrarHotelesEnJTable(codCiudadSeleccionada);
			
				
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
			
		} else {	
			fechaVuelta = new Date(vista.buscarHotel.fechaVuelta.getDate().getTime());
		}		
	
	}
	
	

}

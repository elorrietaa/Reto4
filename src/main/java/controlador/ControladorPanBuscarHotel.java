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
import modelo.Apartamento;
import modelo.Cama;
import modelo.Casa;
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

	private ArrayList<Alojamiento> listaAlojamientos;
	public ArrayList<Dormitorio> listaDormitorios;

	
	Ciudad ciudad;
	TipoAlojamiento tiposAloj;
	
	Alojamiento alojamiento;
	Hotel hotel;
	Casa casa;
	Apartamento apartamento;
	
	Dormitorio habitacion;
	Reserva reserva;
	Consultas consultas;
	
	Date fechaIda;
	Date fechaVuelta;
	Date fechaActual = null;
	int numTipCam [] = new int [3];
	boolean continuar = false;

	
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
     * Método: mostrarHotelesEnJTable = muestra los alojamientos que se han encontrado mediante el método buscarAlojamientoPorCodigoCiudad en base al codCiudadSeleccionado y codTipoAlojSeleccionado por el usuario
     * @param codCiudadSeleccionada
     */
    public void mostrarHotelesEnJTable(int codCiudadSeleccionada, int codTipoAlojSeleccionado) {
	  	
    	//***TABLA HOTELES es .tab
    	if(codTipoAlojSeleccionado == 10) {
	    	// Mostrar los datos del alojamiento en tabla tab
			DefaultTableModel tablaHotel = (DefaultTableModel) vista.buscarHotel.tab.getModel();
				
		  	//llena el arrayList con la lista de Hoteles
		   	listaAlojamientos = consultas.buscarAlojamientoPorCodigoCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado);
				   	
		   	Object[] datos = new Object[2];
			tablaHotel.setRowCount(0);
			for(int i=0; i<listaAlojamientos.size();i++) {
				
				datos[0] = listaAlojamientos.get(i).getNombre();
				datos[1] = ((Hotel) listaAlojamientos.get(i)).getEstrellas();
			
				tablaHotel.addRow(datos);
			}
    	}
    	
    	//***TABLA CASA O APARTAMENTO es .table
    	else if (codTipoAlojSeleccionado == 20 || codTipoAlojSeleccionado == 30) {
		// Mostrar los datos del alojamiento en tabla table
				DefaultTableModel tablaCasApart = (DefaultTableModel) vista.buscarHotel.table.getModel();
					
			  	//llena el arrayList con la lista de alojamiento
			   	listaAlojamientos = consultas.buscarAlojamientoPorCodigoCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado);
			   	
			   	Object[] datos1 = new Object[2];
			   	tablaCasApart.setRowCount(0);
				for(int i=0; i<listaAlojamientos.size();i++) {
					
					datos1[0] = listaAlojamientos.get(i).getNombre();
					datos1[1] = (listaAlojamientos.get(i)).getPrecioAlojamiento() + " €";
					
					tablaCasApart.addRow(datos1);
				}
    	}
    }
	
	
	 /**
     * Método: guardarDatosSeleccionados = guarda los datos seleccionados por el usuario en los objetos.
     */
	public void guardarDatosSeleccionadosAlojamiento() {
		int filaAlojSeleccionado; 
		
		//primero miramos que tipo de alojamiento ha seleccionado el usuario:
		TipoAlojamiento tiposAloj = (TipoAlojamiento) vista.buscarHotel.cBTipoAloj.getSelectedItem();
		int codTipoAlojSeleccionado = tiposAloj.getCodTipoAlojamiento();
		
		//SI SE SELECCIONA UN HOTEL:
		if(codTipoAlojSeleccionado == 10) {
			//se guarda en filaHotelsel la posición seleccionada en la tabla
			filaAlojSeleccionado = vista.buscarHotel.tab.getSelectedRow(); 	 
	    
			//se guarda el hotel seleccionado en la tabla
			this.hotel = (Hotel) listaAlojamientos.get(filaAlojSeleccionado);
	    
			//le pasa el hotel al modelo
			modelo.hotel = this.hotel;
			
			//prueba:
			System.out.println("Hotel seleccionado: " + modelo.hotel.getNombre());
		}
		
		
//???????????????
//guardar modelo.casa modelo.apartamento o modelo.alojamiento y ya esta?????????????
		//SI SE SELECCIONA UNA CASA:
		if(codTipoAlojSeleccionado == 20) {
			//se guarda en filaAlojSeleccionado la posición seleccionada en la tabla
			filaAlojSeleccionado = vista.buscarHotel.table.getSelectedRow(); 	 
	    
			//se guarda la casa seleccionado en la tabla
			this.casa = (Casa) listaAlojamientos.get(filaAlojSeleccionado);
	    
			//le pasa la casa al modelo
			modelo.casa = this.casa;
			
			//prueba:
			System.out.println("Casa seleccionado: " + modelo.casa.getNombre());
		}
		
		//SI SE SELECCIONA UN APARTAMENTO:
		if(codTipoAlojSeleccionado == 30) {
			//se guarda en filaAlojSeleccionado la posición seleccionada en la tabla
			filaAlojSeleccionado = vista.buscarHotel.table.getSelectedRow(); 	 
			    
			//se guarda el apartamento seleccionado en la tabla
			this.apartamento = (Apartamento) listaAlojamientos.get(filaAlojSeleccionado);
			    
			//le pasa el apartamento al modelo
			modelo.apartamento = this.apartamento;
			
			//prueba:
			System.out.println("Apartamento seleccionado: " + modelo.apartamento.getNombre());
		}
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
			
			//se calcula el numero de camas por codigo habitación:
			datos[1] = modelo.consultas.buscarNumCamasPorCodHab(listaDormitorios.get(i).getCodHabitacion());
			//datos[1] = listaDormitorios.get(i).getNumCamas();
			
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
					 
				    //(1º) Guarda los datos seleecionados en el modelo
					guardarDatosSeleccionadosCiudad();
					guardarDatosSeleccionadosTipoAloj();
					guardarDatosSeleccionadosFechas(); //guarda los datos en el modelo, no en modelo.reserva
					
					//(2º) Control de fechas: no se pueden hacer reservas anteriores a now() , ni reservas de 0 noches
					continuar = controlador.funcionesValidaciones.validarFechaEntradaNoNow(fechaIda, fechaVuelta);
				    
			//***SI SE SELECCIONA UN HOTEL:***
					////probamos que se haya seleccionado al menos una habitación un HOTEL:
					if (vista.buscarHotel.tab.getSelectedRowCount()!=0) {
	 
						//(3º) Guarda los datos seleecionados en el modelo
						guardarDatosSeleccionadosAlojamiento();
					
						//(4º) muestra en el siguiente panel las habitaciones en funcion del hotel seleccionado por el usuario
						listaDormitorios = consultas.buscarHabitacionDisponiblel(fechaIda, fechaVuelta, hotel.getCodAlojamiento());
						for(int i = 0; i < listaDormitorios.size(); i++) {
							System.out.println(listaDormitorios.get(i).getCodHabitacion());
						}
						
						//(4.1.) si no hay habitaciones disponibles, muestra un mensaje por pantalla: 
						if(listaDormitorios.size()==0) {
							JOptionPane.showMessageDialog(vista, "Lo sentimos, no existen habitaciones disponibles para ese alojamiento en las fechas elegidas. Por favor, realice otra selección. Gracias. ", null, 0);
							continuar = false;
						}
						
						//(5º)MOSTRAR HABITACIONES Y CAMAS EN JTABLE: MÉTODO buscarCamaPorCodigoHabitacion EXISTE EN CONSULTAS
						mostrarDetallesHabs();
						
						//(6º) Actualiza el siguiente panel, si se cumplen las validaciones.
						if(continuar) {
							vista.buscarHotel.setVisible(false);
							vista.selHabitacion.setVisible(true);
						}
					}
					
			//***Si ha seleccionado una CASA O APARTAMENTO:***
			/*		
					 
			    //probamos que se haya seleccionado al menos una casa o apartamento
				else if(vista.buscarHotel.table.getSelectedRowCount()!=0) {
				
					//(0º) se compueba la disponibilidad del alojamiento para las fechas seleccionadas.
					boolean disponible = modelo.consultas.buscarSiAlojDisponible();
					
					//sin acabar
						//Aviso al usuario si el alojamiento no esta disponible
						//if (disponible == false){
						//JOptionPane.showMessageDialog(vista, "Lo sentimos, ese alojamiento no está disponible en las fechas seleccionadas. Por favor, haga otra selección. Gracias. ", null, 0);
						//}
				
					//(1º)Se guardan los datos seleccionados en el modelo
					guardarDatosSeleccionadosTipoAloj();
					
					//(2º)Genera 1 reserva y la guarda en modelo.reserva
					controlador.funcionesReserva.guardarReservaAlojamiento();
					
					//(3º) se muestran en la siguiente pantalla los detalles de la reserva y el precio TOTAL de la reserva
					controlador.funcionesReserva.mostrarDatosReservaCasaApart();
					
					//(4º) se actualiza la información del siguiente panel: PanDetallesReservaCasaApart con la info del alojamiento seleccionado y el precio Total de la reserva
					actualizarPanDetallesReservaCasaAloj();
					
					//(5º) actualiza el siguiente panel: Desaparece Panel de Seleccionar habitacion  y aparece panel de detalles reserva
					vista.selHabitacion.setVisible(false);
					vista.detallesReservaCasaApart.setVisible(true);
			
				}
				else {//si no ha seleccionado al menos una habitación aparecerá un aviso
					 JOptionPane.showMessageDialog(vista, "Por favor, seleccione al menos una habitación para continuar. Gracias. ", null, 0);
				}
					
			*/	
					else {
						JOptionPane.showMessageDialog(vista, "Por favor, seleccione un alojamiento para continuar. Gracias. ", null, 0);
					}
						
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
				
				TipoAlojamiento tiposAloj = (TipoAlojamiento) vista.buscarHotel.cBTipoAloj.getSelectedItem();
				if (tiposAloj != null) {
				int codTipoAlojSeleccionado = tiposAloj.getCodTipoAlojamiento();
				//muestra los hoteles de la ciudad seleccionada en el JTable
				mostrarHotelesEnJTable(codCiudadSeleccionada, codTipoAlojSeleccionado);
				}
				
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
	
	
	
	/**
	  * Método: actualizarPanDetallesReserva = se actualiza la información de la reserva en el siguiente panel: PanDetallesReserva 
	  * Aparece en PanDetallesReserva la informaicón del hotel seleccionado, las habitaciones seleccionadas, el número de noches de la reserva y el precio Total de la reserva 
	  * 
	 */
/*	public void actualizarPanDetallesReservaCasaAloj() {
			
		DefaultTableModel tablaHabs = (DefaultTableModel) vista.detallesReservaCasaApart.tab.getModel();
			
		// Muestra los datos del Alojamiento seleccionado en un JTable
		mostrarDatosAlojamientoJTable();
			
		// EN EL FUTURO. Muestra los datos de la o las habitaciones que tiene el alojamiento seleccinado 
		//mostrarDetallesHabsSelec(tablaHabs);
			
	}
	
	/**
	  * Método: mostrarDatosAlojamientoJTable = muestra los detalles del alojamiento seleccionado por el usuario en la pantalla PandetallesReserva 
	  * 
	  */
/*	public void mostrarDatosAlojamientoJTable() {
	
	    DefaultTableModel tablaDetCasApart = (DefaultTableModel) vista.detallesReservaCasaApart.table.getModel();

//DUDA: alojamiento o casa o apartamento???
 				
		//llena la tabla con los datos del modelo.casa (la alojamiento seleccionada)
		Object[] datos1 = new Object[2];
		
		tablaHotel.setRowCount(0);
			datos1[0] = modelo.alojamiento.getNombre();
			datos1[1] = modelo.alojamiento.getPrecioAlojamiento();
			
			tablaDetCasApart.addRow(datos1);
	
	}
*/
}

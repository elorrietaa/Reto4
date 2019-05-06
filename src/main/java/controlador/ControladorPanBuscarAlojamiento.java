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
public class ControladorPanBuscarAlojamiento implements ActionListener, PropertyChangeListener {
	public JframePrincipal vista;
	public PrincipalModelo modelo; 
	public PrincipalControlador controlador;

	private ArrayList<Hotel> listaHoteles;
	private ArrayList<Casa> listaCasas;
	private ArrayList<Apartamento> listaApartamentos;
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
	boolean disponible = false;
	
	/**
	 * Constructor del controlador del panel de bienvenida
	* @param vista Instancia de la vista, para poder utilizarla
	* @param modelo Instancia del modelo, para poder utilizarlo
	*/
	public ControladorPanBuscarAlojamiento(JframePrincipal vista, PrincipalModelo modelo, Conexion conexion, PrincipalControlador controlador) {
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
    	vista.buscarHotel.cBTipoAloj.addActionListener(this);
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
		
		//se pasa el tipo de alojamiento seleccionado al modelo
		modelo.tiposAloj = this.tiposAloj;
		
		//Pruebas
		System.out.println("***DATOS Tipo Alojamiento***:" + tiposAloj + "***DATOS Tipo Alojamiento***:" + tiposAloj.getCodTipoAlojamiento());
	    
	}
	
	/**
     * Método: mostrarHotelesEnJTable = muestra los alojamientos que se han encontrado mediante el método buscarAlojamientoPorCodigoCiudad en base al codCiudadSeleccionado y codTipoAlojSeleccionado por el usuario
     * @param codCiudadSeleccionada 
     */
    public void mostrarAlojamientosEnJTable(int codCiudadSeleccionada, int codTipoAlojSeleccionado) {
	  	
    	//***TABLA HOTELES es .tab
    	if(codTipoAlojSeleccionado == 10) {
	    	// Mostrar los datos del alojamiento en tabla tab
			DefaultTableModel tablaHotel = (DefaultTableModel) vista.buscarHotel.tab.getModel();
				
		  	//llena el arrayList con la lista de Hoteles
		   	listaHoteles = consultas.buscarHotelPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado);
		   	
		   	vista.buscarHotel.panelHotel.setVisible(true);
		   	vista.buscarHotel.panelHotel.setEnabled(true);
		   	vista.buscarHotel.panelCasaApart.setVisible(false);
		   	vista.buscarHotel.panelCasaApart.setEnabled(false);
				   	
		   	Object[] datos = new Object[4];
			tablaHotel.setRowCount(0);
			for(int i=0; i<listaHoteles.size();i++) {
				
				datos[0] = listaHoteles.get(i).getNombre();
				
				datos[1] = consultas.buscarPrecioMinimoDeLaHabitacionDelHotel(listaHoteles.get(i).getCodAlojamiento()) + " € habitación/noche";
				
				datos[2] = ((Hotel) listaHoteles.get(i)).getEstrellas();
				datos[3] = "Dirección: " + listaHoteles.get(i).getDireccion();
				tablaHotel.addRow(datos);
			}
    	}
    	
    	//***TABLA CASA O APARTAMENTO es .table 
    	else if (codTipoAlojSeleccionado == 20) {
		// Mostrar los datos del alojamiento en tabla table
				DefaultTableModel tablaCasApart = (DefaultTableModel) vista.buscarHotel.table.getModel();
					
			  	//llena el arrayList con la lista de casas
				listaCasas = consultas.buscarCasaPorCodCiudad(codCiudadSeleccionada);
				
			   	vista.buscarHotel.panelHotel.setVisible(false);
			   	vista.buscarHotel.panelHotel.setEnabled(false);
			   	vista.buscarHotel.panelCasaApart.setVisible(true);
			   	vista.buscarHotel.panelCasaApart.setEnabled(true);
			   	
			   	Object[] datos1 = new Object[3];
			   	tablaCasApart.setRowCount(0);
				for(int i=0; i<listaCasas.size();i++) {
					
					datos1[0] = listaCasas.get(i).getNombre();
					datos1[1] = (listaCasas.get(i)).getPrecioAlojamiento() + " €/noche";
					datos1[2] = "Dirección: " +listaCasas.get(i).getDireccion();
					tablaCasApart.addRow(datos1);
				}
    	}
    	else if ( codTipoAlojSeleccionado == 30) {
    		// Mostrar los datos del alojamiento en tabla table
    				DefaultTableModel tablaCasApart = (DefaultTableModel) vista.buscarHotel.table.getModel();
    					
    			  	//llena el arrayList con la lista de casas
    				listaApartamentos = consultas.buscarApartamentoPorCodCiudad(codCiudadSeleccionada);
    				
    				vista.buscarHotel.panelHotel.setVisible(false);
    			   	vista.buscarHotel.panelHotel.setEnabled(false);
    			   	vista.buscarHotel.panelCasaApart.setVisible(true);
    			   	vista.buscarHotel.panelCasaApart.setEnabled(true);
    			   	
    			   	Object[] datos1 = new Object[3];
    			   	tablaCasApart.setRowCount(0);
    				for(int i=0; i<listaApartamentos.size();i++) {
    					
    					datos1[0] = listaApartamentos.get(i).getNombre();
    					datos1[1] = (listaApartamentos.get(i)).getPrecioAlojamiento() + " €/noche";
    					datos1[2] = "Dirección: " +listaApartamentos.get(i).getDireccion() + "   Piso: " + listaApartamentos.get(i).getPiso();
    					tablaCasApart.addRow(datos1);
    				}
        	}
    }
    /**
     * Método: mostrarDetallesHabs = se muestran los detalles de las habitaciones
     * @param tabla Tabla que se rellena con la informacion de las habitaciones
     */

    public void mostrarDetallesHabsCasa() {

          // Mostrar los datos de las habitaciones en tabla de la siguiente pantalla: PanSelHabitacion

          DefaultTableModel tablaHabs = (DefaultTableModel) vista.detallesReservaCasaApart.tab2.getModel();

          Object[] datos = new Object[3];
          tablaHabs.setRowCount(0);
          for(int i=0; i<listaDormitorios.size();i++) {

                 datos[0] = listaDormitorios.get(i).getNombreHabitacion();

                 //se calcula el numero de camas que tiene la habitación en función del codigo habitación:

                 datos[1] = modelo.consultas.buscarNumCamasPorCodHab(listaDormitorios.get(i).getCodHabitacion());

                 //Mostrar detalles de las camas de la habitación seleccionada:
                 ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(listaDormitorios.get(i).getCodHabitacion());
                 String tiposCamaHab = controlador.funcionesReserva.mostrarTiposDeCamas(listaCamas);

                 //se añaden tiposCamaHab y numTipCam al objeto habitación del modelo

                 //modelo.habitacion.setTiposCamaHab(tiposCamaHab);

                 //modelo.habitacion.setNumTipCam(numTipCam);

                 //listaHabitaciones.add(modelo.habitacion);

                 datos[2] = tiposCamaHab;
                 tablaHabs.addRow(datos);
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
			this.hotel = (Hotel) listaHoteles.get(filaAlojSeleccionado);
	    
			//le pasa el hotel al modelo
			modelo.hotel = this.hotel;
			modelo.casa = null;
			modelo.apartamento = null;
			
			//prueba:
			System.out.println("Hotel seleccionado: " + modelo.hotel.getNombre() + "estrellas" + modelo.hotel.getEstrellas());
		}
		
		
		//SI SE SELECCIONA UNA CASA:
		if(codTipoAlojSeleccionado == 20) {
			//se guarda en filaAlojSeleccionado la posición seleccionada en la tabla
			filaAlojSeleccionado = vista.buscarHotel.table.getSelectedRow(); 	
				
	    //se guarda la casa seleccionado en la tabla
			this.casa = (Casa) listaCasas.get(filaAlojSeleccionado);
	    
			//le pasa la casa al modelo
			modelo.casa = this.casa;
			modelo.hotel = null;
			modelo.apartamento = null;
			
			//prueba:
			System.out.println("Casa seleccionado: " + modelo.casa.getNombre() +"codigo aloj" + modelo.casa.getCodAlojamiento()+ "precio casa:" + modelo.casa.getPrecioAlojamiento());
		}
		
		//SI SE SELECCIONA UN APARTAMENTO:
		if(codTipoAlojSeleccionado == 30) {
			//se guarda en filaAlojSeleccionado la posición seleccionada en la tabla
			filaAlojSeleccionado = vista.buscarHotel.table.getSelectedRow(); 	 
			    
			//se guarda el apartamento seleccionado en la tabla
			this.apartamento = (Apartamento) listaApartamentos.get(filaAlojSeleccionado);
			    
			//le pasa el apartamento al modelo
			modelo.apartamento = this.apartamento;
			modelo.hotel = null;
			modelo.casa = null;
			
			//prueba:
			System.out.println("Apartamento seleccionado: " + modelo.apartamento.getNombre()+"codigo aloj" + modelo.apartamento.getCodAlojamiento()+ "piso" + modelo.apartamento.getPiso());
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
		
		Object[] datos = new Object[5];
		tablaHabs.setRowCount(0);
		for(int i=0; i<listaDormitorios.size();i++) {
			datos[0] = listaDormitorios.get(i).getCodHabitacion();
			datos[1] = listaDormitorios.get(i).getNombreHabitacion();
			//se calcula el numero de camas que tiene la habitación en función del codigo habitación:
			datos[2] = modelo.consultas.buscarNumCamasPorCodHab(listaDormitorios.get(i).getCodHabitacion());
			
			//Mostrar detalles de las camas de la habitación seleccionada: 
			ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(listaDormitorios.get(i).getCodHabitacion());
			String tiposCamaHab = controlador.funcionesReserva.mostrarTiposDeCamas(listaCamas);
			//se añaden tiposCamaHab y numTipCam al objeto habitación del modelo
			//modelo.habitacion.setTiposCamaHab(tiposCamaHab); 
			//modelo.habitacion.setNumTipCam(numTipCam);
			//listaHabitaciones.add(modelo.habitacion);
			
			datos[3] = tiposCamaHab;
			
			datos[4] = (String.format("%.2f", listaDormitorios.get(i).getPrecioHabitacion())  + "€");
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
					continuar = controlador.funcionesValidaciones.validarFechaEntradaYSalida(fechaIda, fechaVuelta);
				    
					//***SI SE SELECCIONA UN HOTEL:***
					if (tiposAloj.getCodTipoAlojamiento() == 10) {
						continuarHotel();
					}
						
					//***Si ha seleccionado una CASA O APARTAMENTO:***
					else if(tiposAloj.getCodTipoAlojamiento() == 20 || tiposAloj.getCodTipoAlojamiento() ==30) {
						continuarCasaApart();
								
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
			
		//JCOMBOBOX DE CIUDAD Y TIPO ALOJAMIENTO
		} else if (sourceObject instanceof JComboBox) {
			
			actualizarFiltradoJComboBox(); //se actualiza el JTable del PanBuscarHotel con los datos seleccionados por el usuario
			
		}
		
		
	}
	
	/**
	 * Método actualizarFiltradoJComboBox = actualiza la información del Jtable dependiendo de los valores escogidos por el usuario en losJComboBox
	 */
	private void actualizarFiltradoJComboBox() {
		// (1º) guarda la ciudad seleccionada
			Ciudad ciudad = (Ciudad) vista.buscarHotel.cBCiudad.getSelectedItem();
			if (ciudad != null) {
				int codCiudadSeleccionada = ciudad.getCodCiudad();
				
				//(2º) guarda el tipo de alojamiento seleccionado
				TipoAlojamiento tiposAloj = (TipoAlojamiento) vista.buscarHotel.cBTipoAloj.getSelectedItem();
				if (tiposAloj != null) {
					int codTipoAlojSeleccionado = tiposAloj.getCodTipoAlojamiento();
					
				//(3º) muestra los alojamientos de la ciudad y el tipoAloj seleccionados por el usuario en el JTable
				mostrarAlojamientosEnJTable(codCiudadSeleccionada, codTipoAlojSeleccionado);
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
	public void actualizarPanDetallesReservaCasaAloj() {
			
		DefaultTableModel tablaHabs = (DefaultTableModel) vista.detallesReservaCasaApart.table.getModel();
			
		// Muestra los datos del Alojamiento seleccionado en un JTable
		mostrarDatosAlojamientoJTable();
			
		// EN EL FUTURO. Muestra los datos de la o las habitaciones que tiene el alojamiento seleccinado 
		//mostrarDetallesHabsSelec(tablaHabs);
			
	}
	
	/**
	  * Método: mostrarDatosAlojamientoJTable = muestra los detalles del alojamiento seleccionado por el usuario en la pantalla PandetallesReserva 
	  * 
	  */
	public void mostrarDatosAlojamientoJTable() {
	
	    DefaultTableModel tablaDetCasApart = (DefaultTableModel) vista.detallesReservaCasaApart.table.getModel();

	  //hotel
 		if (tiposAloj.getCodTipoAlojamiento() == 10) {
 			//llena la tabla con los datos del modelo.casa (la alojamiento seleccionada)
			Object[] datos1 = new Object[3];
			
			tablaDetCasApart.setRowCount(0);
			datos1[0] = modelo.hotel.getNombre();
			datos1[1] = modelo.hotel.getPrecioAlojamiento() + " €/noche";
			datos1[2] =modelo.hotel.getDireccion() +  "   Estrellas: " +  modelo.hotel.getEstrellas();
			tablaDetCasApart.addRow(datos1);
			
		//	mostrarDetallesHabSelec(tablaDetCasApart);
			
 		}
	    //CASA
 		else if (tiposAloj.getCodTipoAlojamiento() == 20) {
 			//llena la tabla con los datos del modelo.casa (la alojamiento seleccionada)
			Object[] datos1 = new Object[3];
			
			tablaDetCasApart.setRowCount(0);
			datos1[0] = modelo.casa.getNombre();
			datos1[1] = modelo.casa.getPrecioAlojamiento() + " €/noche";
			datos1[2] =modelo.casa.getDireccion();
			tablaDetCasApart.addRow(datos1);
 		}
 		//APARTAMENTO
 		else if (tiposAloj.getCodTipoAlojamiento() == 30) {
 			//llena la tabla con los datos del modelo.casa (la alojamiento seleccionada)
 			Object[] datos1 = new Object[3];
 			
 			tablaDetCasApart.setRowCount(0);
 			datos1[0] = modelo.apartamento.getNombre();
 			datos1[1] = modelo.apartamento.getPrecioAlojamiento() + " €/noche";
 			datos1[2] =modelo.apartamento.getDireccion() + "   Piso: " +modelo.apartamento.getPiso();
 			tablaDetCasApart.addRow(datos1);
 		}
	
	}
	
	/**
	 * Método: mostrarDetallesHabsSelec = muestra los detalles de las habitaciones seleccionadas, es decir, muestra el contenido del arrayList listaHabSeleccionadas
	 * 
	 * @param tabla Tabla que se rellena con la informacion de la reserva
	 */
	public void mostrarDetallesHabSelec( DefaultTableModel tablaDetCasApart) {
		Object[] datos = new Object[5];
	
		tablaDetCasApart.setRowCount(0);
			datos[0] = modelo.habitacion.getCodHabitacion();
			datos[1] = modelo.habitacion.getNombreHabitacion();
			datos[2] = modelo.consultas.buscarNumCamasPorCodHab( modelo.habitacion.getCodHabitacion());
			//Mostrar detalles de las camas de la habitación seleccionada: 
			ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(modelo.habitacion.getCodHabitacion());
			String tiposCamaHab = controlador.funcionesReserva.mostrarTiposDeCamas(listaCamas);
			datos[3] = tiposCamaHab;
			datos[4] =  (String.format("%.2f", modelo.habitacion.getPrecioHabitacion()) + "€/1 noche");
		//	datos[5] =  (String.format("%.2f", modelo.reserva.getPrecioReserva() + "€ / "+ modelo.numNoches+" noches");
			tablaDetCasApart.addRow(datos);
		
	}

//*****************MÉTODOS DEL BOTON CONTINUAR:******************************
	
	/**
	 * Método continuarHotel = contiene los métodos a los que se llama cuando el usuario le da al botón continuar del panelBuscarHotel y ha seleccionado un Hotel.
	 */
	public void continuarHotel() {
		//(3º) Guarda los datos seleecionados en el modelo
		if(vista.buscarHotel.tab.getSelectedRow() != -1) {
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
				vista.detallesReservaCasaApart.panelHoteles.setVisible(true);
				vista.detallesReservaCasaApart.panelHoteles.setEnabled(true);
				vista.detallesReservaCasaApart.panelCasaApart.setVisible(false);
				vista.detallesReservaCasaApart.panelCasaApart.setEnabled(false);
			}
		}
		else
			JOptionPane.showMessageDialog(vista, "Por favor, seleccione un alojamiento para continuar. Gracias.", null, 0);
	}
	
	/**
	 * Método continuarCasaApart = contiene los métodos a los que se llama cuando el usuario le da al botón continuar del panelBuscarHotel y ha seleccionado una Casa o un Apartamento.
	 */
	public void continuarCasaApart() {

		//(0º)Se guardan los datos seleccionados en el modelo
		if(vista.buscarHotel.table.getSelectedRow() != -1) {
			guardarDatosSeleccionadosAlojamiento();
		
			//(1º) se compueba la disponibilidad del alojamiento para las fechas seleccionadas.
			validarCasaApartDisponible();
		
			//(0º)Se guardan los datos seleccionados en el modelo
			guardarDatosSeleccionadosAlojamiento();
		
			//(2º)Genera 1 reserva y la guarda en modelo.reserva
			//pasar por parámetro el tiposAloj para diferenciar entre casa y apartamento
			//no se si habria que hacer 1 para casa y 1 para apartamento		
			controlador.funcionesReserva.guardarReservaAlojamiento(tiposAloj);
			
			//(3º) se muestran en la siguiente pantalla los detalles de la reserva y el precio TOTAL de la reserva
			controlador.funcionesReserva.mostrarDatosReservaCasaApart(tiposAloj);
			
			//(4º) se actualiza la información del siguiente panel: PanDetallesReservaCasaApart con la info del alojamiento seleccionado y el precio Total de la reserva
			actualizarPanDetallesReservaCasaAloj();
			mostrarDetallesHabsCasa();
			
			//Aviso al usuario si el alojamiento no esta disponible
			if (disponible == false){
				JOptionPane.showMessageDialog(vista, "Lo sentimos, ese alojamiento no está disponible en las fechas seleccionadas. Por favor, haga otra selección. Gracias. ", null, 0);
			}
			//(5º) actualiza el siguiente panel: Desaparece Panel de buscarHotel  y aparece panel de detalles reservaCasaAloj
			//para que esto pase:
			//continuar == true --> fecha introducida por el usuario tiene que ser válida.
			//disponible != false -->alojamiento seleccionado tiene que estar disponible para las fechas seleccionadas.
			if(continuar && disponible != false) {
				vista.buscarHotel.setVisible(false);
				vista.detallesReservaCasaApart.setVisible(true);
				vista.detallesReservaCasaApart.panelHoteles.setVisible(false);
				vista.detallesReservaCasaApart.panelHoteles.setEnabled(false);
				vista.detallesReservaCasaApart.panelCasaApart.setVisible(true);
				vista.detallesReservaCasaApart.panelCasaApart.setEnabled(true);
			}
		}
		else {
			JOptionPane.showMessageDialog(vista, "Por favor, seleccione un alojamiento para continuar. Gracias. ", null, 0);
		}
	}
	
	/**
	 * Método validarCasaApartDisponible comprueba si la casa o el apartamento seleccionado está disponible para las fechas seleccionadas
	 */
	public void validarCasaApartDisponible() {
		//PARA CASAS:
		if (tiposAloj.getCodTipoAlojamiento() == 20) {
			disponible = modelo.consultas.buscarSiAlojDisponible(modelo.fechaIda, modelo.fechaVuelta, modelo.casa.getCodAlojamiento() );
			System.out.println("esta disponible" + disponible);
		}
		
		//PARA APARTAMENTOS:
		else if (tiposAloj.getCodTipoAlojamiento() == 30) {
			disponible = modelo.consultas.buscarSiAlojDisponible(modelo.fechaIda, modelo.fechaVuelta, modelo.apartamento.getCodAlojamiento() );
			System.out.println("esta disponible" + disponible);
		}
	}
	
}

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
import modelo.*;
import vista.*;

/**
 * Clase: ControladorPanBuscarHotel: contiene los m�todos utilizados en el Panel PanBuscarHotel.
 * @author IN1DM3B_09
 *
 */
public class ControladorPanBuscarAlojamiento implements ActionListener, PropertyChangeListener {
	public JframePrincipal vista;
	public PrincipalModelo modelo; 
	public PrincipalControlador controlador;

	public ArrayList<Hotel> listaHoteles;
	public ArrayList<Casa> listaCasas;
	public ArrayList<Apartamento> listaApartamentos;
	public ArrayList<Dormitorio> listaDormitorios;
	public ArrayList<Habitacion> listaHabitaciones;
	
	public int ocupacion=0;

	//variables para la seleccion realizada por el usuario
	String ordenarPor;
	String ascDesc;
	String stringFiltrosSelec;
	
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
	* @param consultas Insatancia de la calse consultas
	* @param controlador Instancia del controlador, para poder utilizarlo
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
    	vista.buscarAlojamiento.btnAplicarFiltros.addActionListener(this);
    	vista.buscarAlojamiento.btnCerrarSesion.addActionListener(this);
    	vista.buscarAlojamiento.btnCancelar.addActionListener(this);
    	vista.buscarAlojamiento.cBCiudad.addActionListener(this);
    	vista.buscarAlojamiento.cBTipoAloj.addActionListener(this);
    	vista.buscarAlojamiento.cbOrdenar.addActionListener(this);
    	vista.buscarAlojamiento.cBAscDesc.addActionListener(this);
    	vista.buscarAlojamiento.buttonContinuar.addActionListener(this);
    	vista.buscarAlojamiento.btnInicioSesion.addActionListener(this);
    	vista.buscarAlojamiento.btnRegistro.addActionListener(this);
    	vista.buscarAlojamiento.fechaIda.addPropertyChangeListener(this);
    	vista.buscarAlojamiento.fechaVuelta.addPropertyChangeListener(this);
    }
    
   
    /**
     * M�todo: mostrarCiudad = muestra las ciudades que se han buscado en el m�todo BuscarCiudad (en la BBDD)
     */
    public void mostrarCiudad() {
    	vista.buscarAlojamiento.cBCiudad.removeAllItems();
		ArrayList<Ciudad> listaCiudades;
		listaCiudades = consultas.BuscarCiudad();
		for(int i=0; i<listaCiudades.size();i++) {
		    ciudad=listaCiudades.get(i);
		    vista.buscarAlojamiento.cBCiudad.addItem(ciudad); 
		}
    }
    
    /**
     * M�todo: mostrarTiposAloj = muestra las ciudades que se han buscado en el m�todo BuscarCiudad (en la BBDD)
     */
    public void mostrarTiposAloj() { 
    	vista.buscarAlojamiento.cBTipoAloj.removeAllItems();
    	ArrayList<TipoAlojamiento> listaTiposAlojamiento;
    	listaTiposAlojamiento = consultas.BuscarTiposAlojamiento();
		for(int i=0; i<listaTiposAlojamiento.size();i++) {
		    tiposAloj=listaTiposAlojamiento.get(i);
		    vista.buscarAlojamiento.cBTipoAloj.addItem(tiposAloj); 
		}
    }
    
    /**
     * M�todo: mostrarOpcionesParaOrdenar = muestra las opciones en base a las que se puede ordenar la b�squeda 
     */
    public void mostrarOpcionesParaOrdenar() {
    	vista.buscarAlojamiento.cbOrdenar.removeAllItems();
		String [] arrayOpcionesOrdenar = {"Popularidad", "Precio", "Estrellas"};
		
		for(int i=0; i<arrayOpcionesOrdenar.length;i++) {
		    vista.buscarAlojamiento.cbOrdenar.addItem(arrayOpcionesOrdenar[i].toString()); 
		}
    }
    
    /**
     * M�todo: mostrarOpcionesParaOrdenar = muestra las ciudades que se han buscado en el m�todo BuscarCiudad (en la BBDD)
     */
    public void mostrarOpcionesAscDesc() {
    	vista.buscarAlojamiento.cBAscDesc.removeAllItems();
		String [] arrayOpcionesAscDesc = {"Descendente", "Ascendente"};
		
		for(int i=0; i<arrayOpcionesAscDesc.length;i++) {
		    vista.buscarAlojamiento.cBAscDesc.addItem(arrayOpcionesAscDesc[i].toString()); 
		}
    }
    
    /**
     * M�todo: guardarDatosSeleccionados = guarda los datos seleccionados por el usuario en los objetos.
     */
	public void guardarDatosSeleccionadosCiudad() {
		//se guarda la ciudad seleccionada
		this.ciudad = (Ciudad) vista.buscarAlojamiento.cBCiudad.getSelectedItem();
		modelo.ciudad=this.ciudad;
		//Pruebas
		System.out.println("***DATOS CIUDAD***:Ciudad:" + ciudad);
	    
	}
	
	/**
     * M�todo: guardarDatosSeleccionadosTipoAloj = guarda los datos seleccionados por el usuario en los objetos.
     */
	public void guardarDatosSeleccionadosTipoAloj() {
		//se guarda la ciudad seleccionada
		this.tiposAloj = (TipoAlojamiento) vista.buscarAlojamiento.cBTipoAloj.getSelectedItem();
		
		//se pasa el tipo de alojamiento seleccionado al modelo
		modelo.tiposAloj = this.tiposAloj;
		
		//Pruebas
		System.out.println("***DATOS Tipo Alojamiento***:" + tiposAloj + "***DATOS Tipo Alojamiento***:" + tiposAloj.getCodTipoAlojamiento());
	    
	}
	
	/**
	 * M�todo guardarDatosSeleccionadosOrdenarPor = guarda los datos seleccionados por el usuario en los objetos.
	 */
	private void guardarDatosSeleccionadosOrdenarPor() {
		//se guarda la ciudad seleccionada
		this.ordenarPor = (String) vista.buscarAlojamiento.cbOrdenar.getSelectedItem();
				
		//Pruebas
		System.out.println("***DATOS ordenarPor***:" + ordenarPor + "***DATOS ordenarPor***:" + ordenarPor.toString());
	}
	
	/**
	 * M�todo guardarDatosSeleccionadosAscDesc = guarda los datos seleccionados por el usuario en los objetos.
	 */
	private void guardarDatosSeleccionadosAscDesc() {
		//se guarda la ciudad seleccionada
		this.ascDesc = (String) vista.buscarAlojamiento.cBAscDesc.getSelectedItem();
						
		//se pasa el tipo de alojamiento seleccionado al modelo
		//modelo.ordenarPor = this.ordenarPor;
						
		//Pruebas
		System.out.println("***DATOS ordenarPor***:" + ascDesc + "***DATOS ordenarPor***:" + ascDesc.toString());
		
	}
	
	
	
	/**
     * M�todo: mostrarHotelesEnJTable muestra los alojamientos que se han encontrado mediante el m�todo buscarAlojamientoPorCodigoCiudad en base al codCiudadSeleccionado y codTipoAlojSeleccionado por el usuario
     * 
     * @param codCiudadSeleccionada se pasa el c�digo de la ciudad seleccionada por el usuario por par�metro
	 * @param codTipoAlojSeleccionado Se le pasa el c�digo del tipo de alojamiento seleccionado por el usuario por par�metro
	 * @param ordenarPor Criterio de busqueda indicado por el usuario
	 * @param ascDesc se le pasa la selecci�n del usuario (ascendente o descendente) que ser� c�mo desea ordenar la lista de alojamientos
     */
    public void mostrarAlojamientosEnJTable(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String ordenarPor, String ascDesc) {
	  	
    	//***TABLA HOTELES es .tab
    	if(codTipoAlojSeleccionado == 10) {
	    	// Mostrar los datos del alojamiento en tabla tab
			DefaultTableModel tablaHotel = (DefaultTableModel) vista.buscarAlojamiento.tab.getModel();
				
		  	//llena el arrayList con la lista de Hoteles ordnador por popularidad asce
			listaHoteles = controlador.funcionesOrdenar.ordenarListaHoteles(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
			
			//si no hay hoteles que cumplan con los filtros seleccionados, aparece mensaje en el panel:
			if(listaHoteles.size()==0) {
			    vista.buscarAlojamiento.lblLoSentimosNo.setVisible(true);
			}
			if(listaHoteles.size()>0) {
			    vista.buscarAlojamiento.lblLoSentimosNo.setVisible(false);
			}
			
		   	vista.buscarAlojamiento.panelHotel.setVisible(true);
		   	vista.buscarAlojamiento.panelHotel.setEnabled(true);
		   	vista.buscarAlojamiento.panelCasaApart.setVisible(false);
		   	vista.buscarAlojamiento.panelCasaApart.setEnabled(false);
				   	
		   	Object[] datos = new Object[4];
			tablaHotel.setRowCount(0);
			for(int i=0; i<listaHoteles.size();i++) {
				
				datos[0] = listaHoteles.get(i).getNombre();
				//esto mostraria el preico min de la habitacuion
				datos[1] = listaHoteles.get(i).getPrecioAlojamiento() + " � habitaci�n/noche";
				//datos[1] = listaHoteles.get(i).getCodAlojamiento() + " � habitaci�n/noche";
				datos[2] = ((Hotel) listaHoteles.get(i)).getEstrellas();
				datos[3] = "Direcci�n: " + listaHoteles.get(i).getDireccion();
				tablaHotel.addRow(datos);
			}	
    	}
    	
    	//***TABLA CASA O APARTAMENTO es .table 
    	else if (codTipoAlojSeleccionado == 20) {
		// Mostrar los datos del alojamiento en tabla table
				DefaultTableModel tablaCasApart = (DefaultTableModel) vista.buscarAlojamiento.table.getModel();
					
			  	//llena el arrayList con la lista de casas
				listaCasas = controlador.funcionesOrdenar.ordenarListaCasas(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
				
				//si no hay hoteles que cumplan con los filtros seleccionados, aparece mensaje en el panel:
				if(listaCasas.size()==0) {
				    vista.buscarAlojamiento.lblLoSentimosNo.setVisible(true);
				}
				if(listaCasas.size()>0) {
				    vista.buscarAlojamiento.lblLoSentimosNo.setVisible(false);
				}
				
			   	vista.buscarAlojamiento.panelHotel.setVisible(false);
			   	vista.buscarAlojamiento.panelHotel.setEnabled(false);
			   	vista.buscarAlojamiento.panelCasaApart.setVisible(true);
			   	vista.buscarAlojamiento.panelCasaApart.setEnabled(true);
			   	
			   	Object[] datos1 = new Object[3];
			   	tablaCasApart.setRowCount(0);
				for(int i=0; i<listaCasas.size();i++) {
					
					datos1[0] = listaCasas.get(i).getNombre();
					datos1[1] = (listaCasas.get(i)).getPrecioAlojamiento() + " �/noche";
					datos1[2] = "Direcci�n: " +listaCasas.get(i).getDireccion();
					tablaCasApart.addRow(datos1);
					
				System.out.println("DATOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOS POPULARIDAD casa" + listaCasas.get(i).getPopularidad());
				}
    	}
    	else if ( codTipoAlojSeleccionado == 30) {
    		// Mostrar los datos del alojamiento en tabla table
    				DefaultTableModel tablaCasApart = (DefaultTableModel) vista.buscarAlojamiento.table.getModel();
    					
    			  	//llena el arrayList con la lista de casas
    				listaApartamentos = controlador.funcionesOrdenar.ordenarListaApartamentos(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
    				//si no hay apartamentos que cumplan con los filtros seleccionados, aparece mensaje en el panel:
				if(listaApartamentos.size()==0) {
				    vista.buscarAlojamiento.lblLoSentimosNo.setVisible(true);
				}
				if(listaApartamentos.size()>0) {
				    vista.buscarAlojamiento.lblLoSentimosNo.setVisible(false);
				}
    				vista.buscarAlojamiento.panelHotel.setVisible(false);
    			   	vista.buscarAlojamiento.panelHotel.setEnabled(false);
    			   	vista.buscarAlojamiento.panelCasaApart.setVisible(true);
    			   	vista.buscarAlojamiento.panelCasaApart.setEnabled(true);
    			   	
    			   	Object[] datos1 = new Object[3];
    			   	tablaCasApart.setRowCount(0);
    				for(int i=0; i<listaApartamentos.size();i++) {
    					
    					datos1[0] = listaApartamentos.get(i).getNombre();
    					datos1[1] = (listaApartamentos.get(i)).getPrecioAlojamiento() + " �/noche";
    					datos1[2] = "Direcci�n: " +listaApartamentos.get(i).getDireccion() + "   Piso: " + listaApartamentos.get(i).getPiso();
    					tablaCasApart.addRow(datos1);
    					
    				System.out.println("DATOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOS POPULARIDAD apartamento" + listaApartamentos.get(i).getPopularidad());
    				}
        	}
    }
    /**
     * M�todo: mostrarDetallesHabs = se muestran los detalles de las habitaciones
     * 
     * Lo primero que hace es llamar de la base de datos y coge las habitaciones por codigo alojamiento y lo guarda en el arraylist listaHabitaciones
     * tabla Tabla que se rellena con la informacion de las habitaciones
     */
    public void mostrarDetallesHabsCasa() {


          // Mostrar los datos de las habitaciones en tabla de la siguiente pantalla: PanSelHabitacion
          DefaultTableModel tablaHabs = (DefaultTableModel) vista.detallesReservaCasaApart.tab2.getModel();

          Object[] datos = new Object[3];
          tablaHabs.setRowCount(0);
          if(modelo.casa != null)
        	  listaHabitaciones = consultas.buscarHabitacionDormitorioPorCodigoAlojamiento(casa, modelo.casa.getCodAlojamiento());
          else
        	  listaHabitaciones = consultas.buscarHabitacionDormitorioPorCodigoAlojamiento(apartamento, modelo.apartamento.getCodAlojamiento());
          for(int i=0; i<listaHabitaciones.size();i++) {
        	  
        	  datos[0] = listaHabitaciones.get(i).getTipoHabitacion();
        	  
        	  //se calcula el numero de camas que tiene la habitaci�n en funci�n del codigo habitaci�n:

        	  datos[1] = modelo.consultas.buscarNumCamasPorCodHab(listaHabitaciones.get(i).getCodHabitacion());

        	  //Mostrar detalles de las camas de la habitaci�n seleccionada:
        	  ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(listaHabitaciones.get(i).getCodHabitacion());
        	  String tiposCamaHab = controlador.funcionesReserva.mostrarTiposDeCamas(listaCamas);

        	//sacamos el dato de ocupacion
        	  ocupacion = ocupacion + controlador.funcionesReserva.mostrarOcupacionHab(listaCamas);
        	  
        	  datos[2] = tiposCamaHab;
        	  tablaHabs.addRow(datos);
          }
    }
	
	 /**
     * M�todo: guardarDatosSeleccionados = guarda los datos seleccionados por el usuario en los objetos.
     * Este m�todo guarda el tipo de alojamiento que ha seleccionado el usuario (hotel , casa o apartamento).
     */
	public void guardarDatosSeleccionadosAlojamiento() {
		int filaAlojSeleccionado; 
		
		//primero miramos que tipo de alojamiento ha seleccionado el usuario:
		TipoAlojamiento tiposAloj = (TipoAlojamiento) vista.buscarAlojamiento.cBTipoAloj.getSelectedItem();
		int codTipoAlojSeleccionado = tiposAloj.getCodTipoAlojamiento();
		this.tiposAloj = tiposAloj;
		
		//SI SE SELECCIONA UN HOTEL:
		if(codTipoAlojSeleccionado == 10) {
			//se guarda en filaHotelsel la posici�n seleccionada en la tabla
			filaAlojSeleccionado = vista.buscarAlojamiento.tab.getSelectedRow(); 	 
	    
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
			//se guarda en filaAlojSeleccionado la posici�n seleccionada en la tabla
			filaAlojSeleccionado = vista.buscarAlojamiento.table.getSelectedRow(); 	
				
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
			//se guarda en filaAlojSeleccionado la posici�n seleccionada en la tabla
			filaAlojSeleccionado = vista.buscarAlojamiento.table.getSelectedRow(); 	 
			    
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
	 * M�todo: guardarDatosSeleccionadosFechas = guarda las fechas seleccionadas en el JCalendar en el modelo.
	 * 
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
	 * M�todo: mostrarDetallesHabs = se muestran los detalles de las habitaciones
	 * tabla Tabla que se rellena con la informacion de las habitaciones
	 */
	public void mostrarDetallesHabs() {
		// Mostrar los datos de las habitaciones en tabla de la siguiente pantalla: PanSelHabitacion
		DefaultTableModel tablaHabs = (DefaultTableModel) vista.selHabitacion.tab.getModel();
		
		Object[] datos = new Object[5];
		tablaHabs.setRowCount(0);
		for(int i=0; i<listaDormitorios.size();i++) {
			datos[0] = listaDormitorios.get(i).getCodHabitacion();
			datos[1] = listaDormitorios.get(i).getNombreHabitacion();
			//se calcula el numero de camas que tiene la habitaci�n en funci�n del codigo habitaci�n:
			datos[2] = modelo.consultas.buscarNumCamasPorCodHab(listaDormitorios.get(i).getCodHabitacion());
			
			//Mostrar detalles de las camas de la habitaci�n seleccionada: 
			ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(listaDormitorios.get(i).getCodHabitacion());
			String tiposCamaHab = controlador.funcionesReserva.mostrarTiposDeCamas(listaCamas);
			
			//sacamos el dato de ocupacion(aqui saca el de todas las habs)
			//int ocupacion = controlador.funcionesReserva.mostrarOcupacionHab(listaCamas);
			
			//se a�aden tiposCamaHab y numTipCam al objeto habitaci�n del modelo
			//modelo.habitacion.setTiposCamaHab(tiposCamaHab); 
			//modelo.habitacion.setNumTipCam(numTipCam);
			//listaHabitaciones.add(modelo.habitacion);
			
			datos[3] = tiposCamaHab;
			
			datos[4] = (String.format("%.2f", listaDormitorios.get(i).getPrecioHabitacion())  + " � habitaci�n/noche");
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
					 
				    //(1�) Guarda los datos seleecionados en el modelo
					guardarDatosSeleccionadosCiudad();
					guardarDatosSeleccionadosTipoAloj();
					guardarDatosSeleccionadosOrdenarPor();
					guardarDatosSeleccionadosAscDesc();
					guardarDatosSeleccionadosFechas(); //guarda los datos en el modelo, no en modelo.reserva
					
					//Pruebas: muestra fecha y hora actual
					controlador.funcionesReserva.mostrarFechaYHoraActual();
					
					//(2�) Control de fechas: no se pueden hacer reservas anteriores a now() , ni reservas de 0 noches
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
				
				case "Inicio Sesi�n":
					ControladorLogin.panelOrigen = vista.buscarAlojamiento;
					vista.login.setVisible(true);
					vista.buscarAlojamiento.setVisible(false);
					break;
				
				case "Registro":
					ControladorRegistro.panelOrigen = vista.buscarAlojamiento;
					vista.registro.setVisible(true);
					vista.buscarAlojamiento.setVisible(false);
					break;
					
				case "Cancelar":
					vista.bienvenida.setVisible(true);
					vista.buscarAlojamiento.setVisible(false);
					controlador.funcionesBotones.reset();
					break;
				case "Cerrar Sesi�n":
					controlador.funcionesBotones.cerrarSesion();
					break;
					
				case "Aplicar filtros":
					//se hace la buscqueda de listaAlojamientos en funci�n de los filtros seleccionados
					ordenarPor = (String) vista.buscarAlojamiento.cbOrdenar.getSelectedItem();
					ascDesc = (String) vista.buscarAlojamiento.cBAscDesc.getSelectedItem();
					Ciudad ciudad = (Ciudad) vista.buscarAlojamiento.cBCiudad.getSelectedItem();
					int codCiudadSeleccionada = ciudad.getCodCiudad();
					TipoAlojamiento tiposAloj = (TipoAlojamiento) vista.buscarAlojamiento.cBTipoAloj.getSelectedItem();
					int codTipoAlojSeleccionado = tiposAloj.getCodTipoAlojamiento();
					
					//muestra en el JTable los alojamientos filtrados con las selecciones elegidas por el usuario
					mostrarAlojamientosEnJTable(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
					
					//Se muestra en el JTable los alojamientos filtrados con las selecciones elegidas por el usuario 
					
					//Se resetean todos los combobox a no seleccionados
					controlador.funcionesOrdenar.resetearFiltrosServicios();
					break;
			}
			
		//JCOMBOBOX DE CIUDAD Y TIPO ALOJAMIENTO
		} else if (sourceObject instanceof JComboBox) {
			
			actualizarFiltradoJComboBox(); //se actualiza el JTable del PanBuscarHotel con los datos seleccionados por el usuario
			
		}
	}
	

	/**
	 * M�todo actualizarFiltradoJComboBox = actualiza la informaci�n del Jtable dependiendo de los valores escogidos por el usuario en losJComboBox
	 * Adem�s de actualizar la informaci�n de los JcomboBox guarda en las variables lo que ha escogido el usuario.
	 */
	private void actualizarFiltradoJComboBox() {
		// (1�) guarda la ciudad seleccionada
			ciudad = (Ciudad) vista.buscarAlojamiento.cBCiudad.getSelectedItem();
			if (ciudad != null) {
				int codCiudadSeleccionada = ciudad.getCodCiudad();
				
				//(2�) guarda el tipo de alojamiento seleccionado
				tiposAloj = (TipoAlojamiento) vista.buscarAlojamiento.cBTipoAloj.getSelectedItem();
				if (tiposAloj != null) {
					int codTipoAlojSeleccionado = tiposAloj.getCodTipoAlojamiento();
					
					
					//(3�) guarda el dato por el que se va a ordenar y si se ordena asc/desc
						ordenarPor = (String) vista.buscarAlojamiento.cbOrdenar.getSelectedItem();
						ascDesc = (String) vista.buscarAlojamiento.cBAscDesc.getSelectedItem();
							
						
						//(4�) muestra en el JTable los alojamientos filtrados con las selecciones elegidas por el usuario 
						mostrarAlojamientosEnJTable(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
				}			
			
			}
	}
	/**
	 * Listener de la fecha
	 * Este m�todo guarda la fecha que ha cogido el usuario 
	 */
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		// guardamos el nombre del boton pulsado
		JCalendar botonPulsado = ((JCalendar) e.getSource());
		
		if (botonPulsado == vista.buscarAlojamiento.fechaIda) {	
			fechaIda = new Date(vista.buscarAlojamiento.fechaIda.getDate().getTime());
			
		} else {	
			fechaVuelta = new Date(vista.buscarAlojamiento.fechaVuelta.getDate().getTime());
		}		
	
	}
	
	/**
	  * M�todo: actualizarPanDetallesReserva = se actualiza la informaci�n de la reserva en el siguiente panel: PanDetallesReserva 
	  * Aparece en PanDetallesReserva la informaic�n del hotel seleccionado, las habitaciones seleccionadas, el n�mero de noches de la reserva y el precio Total de la reserva 
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
	  * M�todo: mostrarDatosAlojamientoJTable = muestra los detalles del alojamiento seleccionado por el usuario en la pantalla PandetallesReserva 
	  * Este m�todo muestra en la PandetallesReserva un JTable con los servicios adicionales y sus precios. 
	  */
	public void mostrarDatosAlojamientoJTable() {
	
	    DefaultTableModel tablaDetCasApart = (DefaultTableModel) vista.detallesReservaCasaApart.table.getModel();
	    
 		//llena la tabla con los datos del modelo.casa (la alojamiento seleccionada)
		Object[] datos1 = new Object[6];
			
		//si selecciona los servicios adicionales se le muestra el precio
		tablaDetCasApart.setRowCount(0);
		
		if(modelo.servicios != null && modelo.servicios.isWifiSeleccionado()){
			datos1[0] = modelo.servicios.getPrecioWifi() + " �";
		}
		else
			datos1[0] = "00.00 �";
		
		if(modelo.servicios != null && modelo.servicios.isAireSeleccionado()){
			datos1[1] = modelo.servicios.getPrecioAire() + " �";
		}
		else
			datos1[1] = "00.00 �";
			
		if(modelo.servicios != null && modelo.servicios.isPiscinaSeleccionada()){
			datos1[2] = modelo.servicios.getPrecioPiscina() + " �";
		}
		else
			datos1[2] ="00.00 �";
			
		if(modelo.servicios != null && modelo.servicios.isSpaSeleccionado()){
			datos1[3] = modelo.servicios.getPrecioSpa() + " �";
		}
		else
			datos1[3] ="00.00 �";
			
		if(modelo.servicios != null && modelo.servicios.isGimnasioSeleccionado()){
			datos1[4] = modelo.servicios.getPrecioGimnasio() + " �";
		}
		else
			datos1[4] ="00.00 �";
			
		if(modelo.servicios != null && modelo.servicios.isParkingSeleccionado()){
			datos1[5] = modelo.servicios.getPrecioParking() + " �";
		}
		else
			datos1[5] ="00.00 �";
			
		tablaDetCasApart.addRow(datos1);
 	}
	
	/**
	 * M�todo: mostrarDetallesHabsSelec = muestra los detalles de las habitaciones seleccionadas, es decir, muestra el contenido del arrayList listaHabSeleccionadas
	 * 
	 * @param tablaDetCasApart Tabla que se rellena con la informacion de la reserva
	 */
	public void mostrarDetallesHabSelec( DefaultTableModel tablaDetCasApart) {
		Object[] datos = new Object[5];
	
		tablaDetCasApart.setRowCount(0);
			datos[0] = modelo.habitacion.getCodHabitacion();
			datos[1] = modelo.habitacion.getNombreHabitacion();
			datos[2] = modelo.consultas.buscarNumCamasPorCodHab( modelo.habitacion.getCodHabitacion());
			//Mostrar detalles de las camas de la habitaci�n seleccionada: 
			ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(modelo.habitacion.getCodHabitacion());
			String tiposCamaHab = controlador.funcionesReserva.mostrarTiposDeCamas(listaCamas);
			
			datos[3] = tiposCamaHab;
			datos[4] =  (String.format("%.2f", modelo.habitacion.getPrecioHabitacion()) + "�/1 noche");
		//	datos[5] =  (String.format("%.2f", modelo.reserva.getPrecioReserva() + "� / "+ modelo.numNoches+" noches");
			tablaDetCasApart.addRow(datos);
		
	}

//*****************M�TODOS DEL BOTON CONTINUAR:******************************
	
	/**
	 * M�todo continuarHotel = contiene los m�todos a los que se llama cuando el usuario le da al bot�n continuar del panelBuscarHotel y ha seleccionado un Hotel.
	 * Este metodo guarda en el alojamiento el hotel, la lista de dormitorios y muestra los detalles de las habitaciones. 
	 */
	public void continuarHotel() {
		//(3�) Guarda los datos seleecionados en el modelo
		if(vista.buscarAlojamiento.tab.getSelectedRow() != -1) {
			guardarDatosSeleccionadosAlojamiento();
			if(controlador.funcionesServicios.comprobarServicioGuardado()) {
				//(4�) muestra en el siguiente panel las habitaciones en funcion del hotel seleccionado por el usuario
				listaDormitorios = consultas.buscarHabitacionDisponiblel(fechaIda, fechaVuelta, hotel.getCodAlojamiento());
				for(int i = 0; i < listaDormitorios.size(); i++) {
					System.out.println(listaDormitorios.get(i).getCodHabitacion());
				}
				
				//(4.1.) si no hay habitaciones disponibles, muestra un mensaje por pantalla: 
				if(listaDormitorios.size()==0) {
					JOptionPane.showMessageDialog(vista, "Lo sentimos, no existen habitaciones disponibles para ese alojamiento en las fechas elegidas. Por favor, realice otra selecci�n. Gracias. ", null, 0);
					continuar = false;
				}
				
				//(5�)MOSTRAR HABITACIONES Y CAMAS EN JTABLE: M�TODO buscarCamaPorCodigoHabitacion EXISTE EN CONSULTAS
				mostrarDetallesHabs();
				//(6�) Actualiza el siguiente panel, si se cumplen las validaciones.
				if(continuar) {
					vista.buscarAlojamiento.setVisible(false);
					vista.selHabitacion.setVisible(true);
					vista.detallesReservaCasaApart.panelHoteles.setVisible(true);
					vista.detallesReservaCasaApart.panelHoteles.setEnabled(true);
					vista.detallesReservaCasaApart.panelCasaApart.setVisible(false);
					vista.detallesReservaCasaApart.panelCasaApart.setEnabled(false);
					
					//mostrar el texto de las bases legales en el panBases
					controlador.funcionesBasesLegales.mostrarBaseslegales();
				}
			}
			
			else {
				JOptionPane.showMessageDialog(vista, "Por favor, guarde los servicios seleccionados para el alojamiento actual o cancele su seleccion de servicios. Gracias", null, 0);
			}
		}
		else
			JOptionPane.showMessageDialog(vista, "Por favor, seleccione un alojamiento para continuar. Gracias.", null, 0);
	}
	
	/**
	 *
	 * M�todo continuarCasaApart = contiene los m�todos a los que se llama cuando el usuario le da al bot�n continuar del panelBuscarHotel y ha seleccionado una Casa o un Apartamento.
	 * Valida la disponibilidad de casas y apartamentos. 
	 * Este metodo guarda en el alojamiento los datos de casas y alojamiento dependiendo de que ha seleccionado el usuario.
	 */
	
	public void continuarCasaApart() {

		//(0�)Se guardan los datos seleccionados en el modelo
		if(vista.buscarAlojamiento.table.getSelectedRow() != -1) {
			guardarDatosSeleccionadosAlojamiento();
			if(controlador.funcionesServicios.comprobarServicioGuardado()) {

				//(1�) se compueba la disponibilidad del alojamiento para las fechas seleccionadas.
				validarCasaApartDisponible();
			
				//(0�)Se guardan los datos seleccionados en el modelo
				guardarDatosSeleccionadosAlojamiento();
				
				//se muestran los datos de las habitaciones de la casa/Apartamento
				controlador.funcionesReserva.guardarNumHabTipoDeCasaApart();
				
			 
				//(2�)Genera 1 reserva y la guarda en modelo.reserva
				//pasar por par�metro el tiposAloj para diferenciar entre casa y apartamento
				//no se si habria que hacer 1 para casa y 1 para apartamento		
				controlador.funcionesReserva.guardarReservaAlojamiento(tiposAloj);
				
				//(3�) se muestran en la siguiente pantalla los detalles de la reserva y el precio TOTAL de la reserva
				controlador.funcionesReserva.mostrarDatosReservaAloj(tiposAloj);
				
				//(4�) se actualiza la informaci�n del siguiente panel: PanDetallesReservaCasaApart con la info del alojamiento seleccionado y el precio Total de la reserva
				actualizarPanDetallesReservaCasaAloj();
				mostrarDetallesHabsCasa();
				
				
				//Aviso al usuario si el alojamiento no esta disponible
				if (disponible == false){
					JOptionPane.showMessageDialog(vista, "Lo sentimos, ese alojamiento no est� disponible en las fechas seleccionadas. Por favor, haga otra selecci�n. Gracias. ", null, 0);
				}
				//(5�) actualiza el siguiente panel: Desaparece Panel de buscarHotel  y aparece panel de detalles reservaCasaAloj
				//para que esto pase:
				//continuar == true --> fecha introducida por el usuario tiene que ser v�lida.
				//disponible != false -->alojamiento seleccionado tiene que estar disponible para las fechas seleccionadas.
				if(continuar && disponible != false) {
					vista.buscarAlojamiento.setVisible(false);
					vista.detallesReservaCasaApart.setVisible(true);
					vista.detallesReservaCasaApart.panelHoteles.setVisible(false);
					vista.detallesReservaCasaApart.panelHoteles.setEnabled(false);
					vista.detallesReservaCasaApart.panelCasaApart.setVisible(true);
					vista.detallesReservaCasaApart.panelCasaApart.setEnabled(true);
					
					//mostrar el texto de las bases legales en el panBases
					controlador.funcionesBasesLegales.mostrarBaseslegales();
				}
			}
			else {
				JOptionPane.showMessageDialog(vista, "Por favor, guarde los servicios seleccionados para el alojamiento actual o cancele su seleccion de servicios. Gracias", null, 0);
			}
		}
		else {
			JOptionPane.showMessageDialog(vista, "Por favor, seleccione un alojamiento para continuar. Gracias. ", null, 0);
		}
	}
	
	/**
	 * M�todo validarCasaApartDisponible comprueba si la casa o el apartamento seleccionado est� disponible para las fechas seleccionadas
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
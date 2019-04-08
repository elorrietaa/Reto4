package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import bbdd.*;
import modelo.Ciudad;
import modelo.Consultas;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.PrincipalModelo;
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
	Ciudad ciudad;
	Hotel hotel;
	Habitacion habitacion;
	Consultas consultas;
	
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
    	vista.buscarHotel.cBHotel.addActionListener(this);
    	vista.buscarHotel.cBHabitacion.addActionListener(this);
    	vista.buscarHotel.buttonContinuar.addActionListener(this);
    }
    /**
     * Método mostrarCiudad, muestra las ciudades que se han buscado en el método BuscarCiudad (en la BBDD)
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
     * Método mostrarHoteles: muestra los hoteles que se han encontrado mediante el método BuscarHotelesPorCodigoCiudad en base al codCiudadSeleccionado por el usuario
     * @param codCiudadSeleccionada
     */
    public void mostrarHoteles(int codCiudadSeleccionada) {
    	vista.buscarHotel.cBHotel.removeAllItems();
    	listaHoteles = consultas.BuscarHotelPorCodigoCiudad(codCiudadSeleccionada);
	  	for(int i=0; i<listaHoteles.size();i++) {
	  	  hotel = listaHoteles.get(i);
	  	  vista.buscarHotel.cBHotel.addItem(hotel);
	  	}
    }
    /**
     * Método mostrarHotelesEnElJList
     * @param codCiudadSeleccionada
     */
    public void mostrarHotelesEnElJList(int codCiudadSeleccionada) {
    	//borra todos los elementos del JList
    	vista.buscarHotel.modeloOrigen.removeAllElements();
    	//llena el arrayList con la lista de Hoteles
    	listaHoteles = consultas.BuscarHotelPorCodigoCiudad(codCiudadSeleccionada);
    	//muestra en elJlist listHoteles la lista de hoteles de la ciudad seleccionada
	  	for(int i=0; i<listaHoteles.size();i++) {
	  		vista.buscarHotel.modeloOrigen.addElement(listaHoteles.get(i));
			vista.buscarHotel.listHoteles.setModel(vista.buscarHotel.modeloOrigen);
	  	}
    }
    
  
   
    
	public void guardarDatosSeleccionados() {
		//se guarda el hotel seleccionado
		this.ciudad = (Ciudad) vista.buscarHotel.cBCiudad.getSelectedItem();
		//Pruebas
		System.out.println("Ciudad:" + ciudad);
	    this.hotel = (Hotel) vista.buscarHotel.cBHotel.getSelectedItem();
	    //Pruebas
	    System.out.println("Hotel del combox:" + hotel);
	    this.hotel = (Hotel) vista.buscarHotel.listHoteles.getSelectedValue();
	    //Pruebas
	    System.out.println("Hotel de la lista:" + hotel);
	    vista.detallesReserva.textFieldPrecioReserva.setText(Float.toString(this.hotel.getPrecioAlojamiento()));
	    
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
			
			case "Continuar":				
			    	//pasa al panel Detalles Reserva los datos seleccionados en el panel SeleccionarAlojamiento
				guardarDatosSeleccionados();
			
				break;
			
			}
	
		} else if (sourceObject instanceof JComboBox) {
		   
			// guarda la ciudad seleccionada
			Ciudad ciudad = (Ciudad) vista.buscarHotel.cBCiudad.getSelectedItem();
			if (ciudad != null) {
				
			int codCiudadSeleccionada = ciudad.getCodCiudad();
						
			// rellena listaAlojamiento con los alojamientos en función de la ciudad que se ha seleccionado y muestra los hoteles
			mostrarHoteles(codCiudadSeleccionada);
			
			//muestra los hoteles en el JList
			mostrarHotelesEnElJList(codCiudadSeleccionada);
			}
		}
	}
	public ArrayList<Ciudad> getListaCiudades() {
		return listaCiudades;
	}
	public void setListaCiudades(ArrayList<Ciudad> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}
	public ArrayList<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}
	public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}
	
}

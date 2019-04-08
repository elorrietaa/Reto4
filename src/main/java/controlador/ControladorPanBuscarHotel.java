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
    	vista.buscarHotel.buttonContinuar.addActionListener(this);
    }
    /**
     * Método mostrarCiudad, muestra las ciudades que se han b
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
    
    public void mostrarHoteles() {
    	vista.buscarHotel.cBHotel.removeAllItems();
	  	for(int i=0; i<listaHoteles.size();i++) {
	  	  hotel = listaHoteles.get(i);
	  	  vista.buscarHotel.cBHotel.addItem(hotel);
	  	}
    }
	
	public void actualizarPanelBuscarHotel() {
	    this.hotel = (Hotel) vista.buscarHotel.cBHotel.getSelectedItem();
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
				actualizarPanelBuscarHotel();
			
				break;
			
			}
	
		} else if (sourceObject instanceof JComboBox) {
		   
		    // seleccionar ciudad
			this.ciudad = (Ciudad) vista.buscarHotel.cBCiudad.getSelectedItem();
			// rellena listaAlojamiento con los alojamientos en función de la ciudad que se ha seleccionado
			this.listaHoteles = consultas.BuscarHotelPorCodigoCiudad(this.ciudad);
			// seleccionar hotel
			mostrarHoteles();
		
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

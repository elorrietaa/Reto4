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
 * Clase: ControladorPanBuscarHotel: contiene los m�todos utilizados en el Panel PanBuscarHotel.
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
     * M�todo mostrarCiudad, muestra las ciudades que se han buscado en el m�todo BuscarCiudad (en la BBDD)
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
     * M�todo mostrarHoteles: muestra los hoteles que se han encontrado mediante el m�todo BuscarHotelesPorCodigoCiudad en base al codCiudadSeleccionado por el usuario
     * @param codCiudadSeleccionada
     */
    public void mostrarHoteles(int codCiudadSeleccionada) {
    	listaHoteles = consultas.BuscarHotelPorCodigoCiudad(codCiudadSeleccionada);
    	vista.buscarHotel.cBHotel.removeAllItems();
	  	for(int i=0; i<listaHoteles.size();i++) {
	  	  hotel = listaHoteles.get(i);
	  	  vista.buscarHotel.cBHotel.addItem(hotel);
	  	}
    }
    
   /**
    * M�todo mostrarHabitacion: muestra las habitacioness que se han encontrado mediante el m�todo buscarHabitacionPorCodigoHotel en base al codHotelSeleccionado por el usuario
    * @param codHabitacionSeleccionada
    */
    public void mostrarHabitaciones(int codHotelSeleccionado) {
    	listaHabitaciones = consultas.buscarHabitacionPorCodigoHotel(hotel, codHotelSeleccionado) ;
    	vista.buscarHotel.cBCiudad.removeAllItems();
	  	for(int i=0; i<listaHabitaciones.size();i++) {
	  	  habitacion = listaHabitaciones.get(i);
	  	  vista.buscarHotel.cBHotel.addItem(habitacion);
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
		   
			// guarda la ciudad seleccionada
			Ciudad ciudad = (Ciudad) vista.buscarHotel.cBCiudad.getSelectedItem();
			if (ciudad != null) {
				
			int codCiudadSeleccionada = ciudad.getCodCiudad();
			
			// limpia los JList de los hoteles y las habitaciones
			vista.buscarHotel.cBHotel.removeAll();
			//vista.sel_billete.modeloDestino.removeAllElements();
			
			// rellena listaAlojamiento con los alojamientos en funci�n de la ciudad que se ha seleccionado y muestra los hoteles
			mostrarHoteles(codCiudadSeleccionada);
			}else if (hotel != null) {
					// guarda el hotel seleccionado
					this.hotel = (Hotel) vista.buscarHotel.cBHotel.getSelectedItem();
					int codHotelSeleccionado = hotel.getCodAlojamiento();
					System.out.println(codHotelSeleccionado);
					vista.buscarHotel.cBCiudad.removeAll();
					mostrarHabitaciones(codHotelSeleccionado);
		
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

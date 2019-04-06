package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

/**
 * Clase: ControladorPanBuscarHotel: contiene los métodos utilizados en el Panel PanBuscarHotel.
 * @author IN1DM3B_09
 *
 */
public class ControladorPanBuscarHotel implements ActionListener{
	public JframePrincipal vista;
	public Modelo modelo;
	private ArrayList<Ciudad> listaCiudades;
	private ArrayList<Hotel> listaAlojamiento;
	Ciudad ciudad;
	Alojamiento alojamiento;
	Consultas consultas;
	
	/**
	 * Constructor del controlador del panel de bienvenida
	* @param vista Instancia de la vista, para poder utilizarla
	* @param modelo Instancia del modelo, para poder utilizarlo
	*/
	public ControladorPanBuscarHotel(JframePrincipal vista, Modelo modelo) {
	this.vista = vista;
	this.modelo = modelo;
    }
    /**
	 * Se crean los listeners del panel
	 */
    public void addListeners() {
    	vista.buscarHotel.cBCiudad.addActionListener(this);
    	vista.buscarHotel.cBHotel.addActionListener(this);
    	vista.buscarHotel.buttonContinuar.addActionListener(this);
    }
    /*
    /**
     * Método mostrarCiudad, muestra las ciudades que se han b
     * @param listaCiudades
     */
    public void mostrarCiudad() {
		ArrayList <Ciudad> listaCiudades=consultas.BuscarCiudad();
		for(int i=0; i<listaCiudades.size();i++) {
		    ciudad=(Ciudad) listaCiudades.get(i);
		  vista.buscarHotel.cBCiudad.addItem(ciudad);
		}
    }
    public void mostrarAlojamiento() {
	  	for(int i=0; i<listaAlojamiento.size();i++) {
	  	  alojamiento=(Alojamiento) listaAlojamiento.get(i);
	  	  vista.buscarHotel.cBHotel.addItem(alojamiento);
	  	}
    }
	
	public void actualizarPanelBuscarHotel() {
	    this.alojamiento = (Alojamiento) vista.buscarHotel.cBHotel.getSelectedItem();
	    vista.detallesReserva.textFieldPrecioReserva.setText(Float.toString(this.alojamiento.getPrecioAlojamiento()));
	    
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
			this.listaAlojamiento=consultas.BuscarHotelPorCodigoCiudad(ciudad.getCodCiudad());
			// seleccionar hotel
			mostrarAlojamiento();
		
		}
		
	}
}

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
public class ControladorPanBuscarHotel {
    public JframePrincipal vista;
    public PrincipalModelo modelo;
    private ArrayList<Ciudad> listaCiudades;
    Ciudad ciudad;
    private ArrayList<Alojamiento> listaAlojamiento;
    Alojamiento alojamiento;
    
    public ControladorPanBuscarHotel(JframePrincipal vista, PrincipalModelo modelo) {
	this.vista = vista;
	this.modelo = modelo;
    }
    /**
	 * Se crean los listeners del panel
	 */
    public void addListeners() {
	vista.buscarHotel.cBCiudad.addActionListener((ActionListener) this);
    }
    /**
     * Método mostrarCiudad, muestra las ciudades que se han b
     * @param listaCiudades
     */
    public void mostrarCiudad() {
	ArrayList listaCiudades=ConsultasModelo.BuscarCiudad();
	for(int i=0; i<listaCiudades.size();i++) {
	    ciudad=(Ciudad) listaCiudades.get(i);
	  vista.buscarHotel.cBCiudad.addItem(ciudad);
	}
    }
    /**
	 * Esta funcion valida los datos en el Panel Busqueda Hotel
	 * 
	 * @return Retorna si los datos son correctos o no
	 */
	public void seleccionarDatos() {
		// seleccionar ciudad
		this.ciudad = (Ciudad) vista.buscarHotel.cBCiudad.getSelectedItem();
		
		// seleccionar hotel
		this.alojamiento = (Alojamiento) vista.buscarHotel.cBHotel.getSelectedItem();
		
	}
	
	public void actualizarFrame() {
	    seleccionarDatos();
	    vista.detallesReserva.textFieldPrecioReserva.setText(Float.toString(this.alojamiento.getPrecioAlojamiento()));
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
				
				actualizarFrame();
				
				
				
				break;
			
			}
	
		} else if (sourceObject instanceof JComboBox) {
		   
			// guarda la linea seleccionada
			Linea linea = (Linea) vista.sel_billete.boxLineas.getSelectedItem();
			
			if (linea != null) {
				
				String codLinea = linea.getCodLinea();
				
				// limpia los JList de las paradas
				vista.sel_billete.modeloOrigen.removeAllElements();
				vista.sel_billete.modeloDestino.removeAllElements();
				
				// carga las paradas de la linea selecciona desde la BBDD
				paradas = modelo.consultas.getParadasByLinea(codLinea); 			
				
				//muestra las paradas en los JList
				for(int i=0; i<paradas.size(); i++) {
	
					// carga las paradas en el jlist origen
					vista.sel_billete.modeloOrigen.addElement(paradas.get(i));
					vista.sel_billete.listaOrigen.setModel(vista.sel_billete.modeloOrigen);
					
					// carga las paradas en el jlist destino
					vista.sel_billete.modeloDestino.addElement(paradas.get(i));
					vista.sel_billete.listaDestino.setModel(vista.sel_billete.modeloDestino);
					
				}
				
			}
		  
		}
		
	}
}

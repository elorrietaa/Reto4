package controlador;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class FuncionesServicios {
	
	private JframePrincipal vista;
	private PrincipalModelo modelo;
	private PrincipalControlador controlador;
	
	public ServiciosAdicionales servicios;
	/**
	 * Este es el constructor de funcionesServicios, al cual le pasamos el modelo,vista y controlador.
	 * @param modelo
	 * @param vista
	 * @param controlador
	 */
	public FuncionesServicios(PrincipalModelo modelo, JframePrincipal vista, PrincipalControlador controlador) {
		this.vista = vista;
		this.modelo = modelo;
		this.controlador = controlador;
	}
	/**
	 * Este método activa el panel de los servicios adicionales si el usuario ha seleccionado algun alojamiento 	
	 */
	public void activarPanel() {
		if(vista.buscarAlojamiento.panelHotel.isVisible() == true) {
			if(vista.buscarAlojamiento.tab.getSelectedRow() != -1)
				cargarServicios();
			else
				JOptionPane.showMessageDialog(vista, "Por favor, seleccione un alojamiento para poder ver sus servicios disponibles. Gracias.", null, 0);
		}
		else {
			if(vista.buscarAlojamiento.table.getSelectedRow() != -1)
				cargarServicios();
			else
				JOptionPane.showMessageDialog(vista, "Por favor, seleccione un alojamiento para poder ver sus servicios disponibles. Gracias.", null, 0);
		}
	}
	/**
	 * Este metodo hace visible los todos los componentes del panel servicios adicionales.
	 * Además llama al metodo de comprobarServicios.
	 */
	public void cargarServicios() {
		vista.buscarAlojamiento.panelServicios.setVisible(true);
		vista.buscarAlojamiento.btnServicios.setVisible(false);
		vista.buscarAlojamiento.btnServicios.setEnabled(false);
		vista.buscarAlojamiento.btnActualizar.setVisible(true);
		vista.buscarAlojamiento.btnActualizar.setEnabled(true);
		vista.buscarAlojamiento.lblMensajeActualizar.setVisible(true);
		vista.buscarAlojamiento.lblMensajeContratar.setVisible(true);
		
		controlador.controladorPanBuscarAlojamiento.guardarDatosSeleccionadosAlojamiento();
		int codTipoAloj = controlador.controladorPanBuscarAlojamiento.tiposAloj.getCodTipoAlojamiento();
		int codAlojamiento = 0;
		
		if(codTipoAloj == 10)
			codAlojamiento = controlador.controladorPanBuscarAlojamiento.hotel.getCodAlojamiento();
		
		if(codTipoAloj == 20)
			codAlojamiento = controlador.controladorPanBuscarAlojamiento.casa.getCodAlojamiento();
		
		if(codTipoAloj == 30)
			codAlojamiento = controlador.controladorPanBuscarAlojamiento.apartamento.getCodAlojamiento();
		
		this.servicios = modelo.consultas.buscarServiciosAdicionales(codAlojamiento);
		comprobarServicios();
	}
	/**
	 * Este método comprueba si los servicios estan en el alojamiento escogido.
	 */
	public void comprobarServicios() {
		if(this.servicios.isWifi() == true)
			vista.buscarAlojamiento.checkWifi.setEnabled(true);
		else
			vista.buscarAlojamiento.checkWifi.setEnabled(false);
		
		if(this.servicios.isAire() == true)
			vista.buscarAlojamiento.checkAire.setEnabled(true);
		else
			vista.buscarAlojamiento.checkAire.setEnabled(false);
		
		if(this.servicios.isPiscina() == true)
			vista.buscarAlojamiento.checkPiscina.setEnabled(true);
		else
			vista.buscarAlojamiento.checkPiscina.setEnabled(false);
		
		if(this.servicios.isSpa() == true)
			vista.buscarAlojamiento.checkSpa.setEnabled(true);
		else
			vista.buscarAlojamiento.checkSpa.setEnabled(false);
		
		if(this.servicios.isGimnasio() == true)
			vista.buscarAlojamiento.checkGimnasio.setEnabled(true);
		else
			vista.buscarAlojamiento.checkGimnasio.setEnabled(false);
		
		if(this.servicios.isParking() == true)
			vista.buscarAlojamiento.checkParking.setEnabled(true);
		else
			vista.buscarAlojamiento.checkParking.setEnabled(false);
	}
	/**
	 * Este metodo mira que servicios estan seleccionados y llama al metodo que calcula el precio de los servicios.
	 */
	public void contratarServicios() {
		servicios.setWifiSeleccionado(vista.buscarAlojamiento.checkWifi.isSelected());
		servicios.setAireSeleccionado(vista.buscarAlojamiento.checkAire.isSelected());
		servicios.setPiscinaSeleccionada(vista.buscarAlojamiento.checkPiscina.isSelected());
		servicios.setSpaSeleccionado(vista.buscarAlojamiento.checkSpa.isSelected());
		servicios.setGimnasioSeleccionado(vista.buscarAlojamiento.checkGimnasio.isSelected());
		servicios.setParkingSeleccionado(vista.buscarAlojamiento.checkParking.isSelected());
		
		modelo.servicios = this.servicios;
		
		vista.buscarAlojamiento.labelServicios.setVisible(true);
		calcularPrecioServicios();
	}
	/**
	 * Este metodo comprueba se el servicio esta guardado
	 * @return true/false
	 */
	public boolean comprobarServicioGuardado() {
		int codTipoAloj = controlador.controladorPanBuscarAlojamiento.tiposAloj.getCodTipoAlojamiento();
		if(modelo.servicios != null) {
			if(modelo.hotel != null && modelo.hotel.getCodAlojamiento() == modelo.servicios.getCodAlojamiento())
				return true;
			else if(modelo.casa != null && modelo.casa.getCodAlojamiento() == modelo.servicios.getCodAlojamiento())
				return true;
			else if(modelo.apartamento != null && modelo.apartamento.getCodAlojamiento() == modelo.servicios.getCodAlojamiento())
				return true;
			else
				return false;
		}
		else
			return true;
	}
	/**
	 * Este metodo calcula el precio de los servicios adicinales.
	 */
	public void calcularPrecioServicios() {
		float precio = 0;
		if(servicios.isWifiSeleccionado())
			precio = precio + servicios.getPrecioWifi();
		if(servicios.isAireSeleccionado())
			precio = precio + servicios.getPrecioAire();
		if(servicios.isGimnasioSeleccionado())
			precio = precio + servicios.getPrecioGimnasio();
		if(servicios.isParkingSeleccionado())
			precio = precio + servicios.getPrecioParking();
		if(servicios.isPiscinaSeleccionada())
			precio = precio + servicios.getPrecioPiscina();
		if(servicios.isSpaSeleccionado())
			precio = precio + servicios.getPrecioSpa();
		
		modelo.precioServicios = precio;
	}
}
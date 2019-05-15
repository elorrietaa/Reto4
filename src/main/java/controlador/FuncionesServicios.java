package controlador;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class FuncionesServicios {
	
	private JframePrincipal vista;
	private PrincipalModelo modelo;
	
	public ServiciosAdicionales servicios;
	
	public FuncionesServicios(PrincipalModelo modelo, JframePrincipal vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
		
	public void activarPanel(PrincipalControlador controlador) {
		if(vista.buscarAlojamiento.tab.getSelectedRow() != -1) {
			vista.buscarAlojamiento.panelServicios.setVisible(true);
			vista.buscarAlojamiento.btnServicios.setVisible(false);
			vista.buscarAlojamiento.btnServicios.setEnabled(false);
			vista.buscarAlojamiento.btnActualizar.setVisible(true);
			vista.buscarAlojamiento.btnActualizar.setEnabled(true);
			cargarServicios(controlador);
		}
		else {
			JOptionPane.showMessageDialog(vista, "Por favor, seleccione un alojamiento para poder ver sus servicios disponibles. Gracias.", null, 0);
		}
	}
	
	public void cargarServicios(PrincipalControlador controlador) {
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
	
	public void contratarServicios() {
		servicios.setWifiSeleccionado(vista.buscarAlojamiento.checkWifi.isSelected());
		servicios.setAireSeleccionado(vista.buscarAlojamiento.checkAire.isSelected());
		servicios.setPiscinaSeleccionada(vista.buscarAlojamiento.checkPiscina.isSelected());
		servicios.setSpaSeleccionado(vista.buscarAlojamiento.checkSpa.isSelected());
		servicios.setGimnasioSeleccionado(vista.buscarAlojamiento.checkGimnasio.isSelected());
		servicios.setParkingSeleccionado(vista.buscarAlojamiento.checkParking.isSelected());
		
		modelo.servicios = this.servicios;
		
		vista.buscarAlojamiento.labelServicios.setVisible(true);
	}
}
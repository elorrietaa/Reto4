package controlador;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class FuncionesServicios {
	
	private JframePrincipal vista;
	private PrincipalModelo modelo;
	
	public FuncionesServicios(PrincipalModelo modelo, JframePrincipal vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
		
	public void activarPanel() {
		if(vista.buscarAlojamiento.tab.getSelectedRow() != -1) {
			vista.buscarAlojamiento.panelServicios.setVisible(true);
			vista.buscarAlojamiento.btnServicios.setVisible(false);
			vista.buscarAlojamiento.btnServicios.setEnabled(false);
		}
		else {
			JOptionPane.showMessageDialog(vista, "Por favor, seleccione un alojamiento para poder ver sus servicios disponibles. Gracias.", null, 0);
		}
	}
}

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.*;
import vista.*;

public class ControladorPanServiciosAdicionales implements ActionListener {

    private JframePrincipal vista;
    private PrincipalModelo modelo;
    private PrincipalControlador controlador;

    private ServiciosAdicionales servicios;

    public ControladorPanServiciosAdicionales(JframePrincipal vista, PrincipalModelo modelo,
	    PrincipalControlador controlador) {
	this.vista = vista;
	this.modelo = modelo;
	this.controlador = controlador;
    }

    /**
     * Se crean los listeners del panel
     */
    public void addListeners() {
	vista.buscarAlojamiento.btnServicios.addActionListener(this);
	vista.buscarAlojamiento.btnActualizar.addActionListener(this);
	vista.buscarAlojamiento.btnContratar.addActionListener(this);
	vista.buscarAlojamiento.btnCancelarSer.addActionListener(this);
    }

    /**
     * Acción de los distintos listeners
     */
    public void actionPerformed(ActionEvent e) {

	Object sourceObject = e.getSource();

	if (sourceObject instanceof JButton) {

	    String botonPulsado = ((JButton) sourceObject).getActionCommand();

	    switch (botonPulsado) {
	    case "Contratar":
		controlador.funcionesServicios.contratarServicios();
		break;
	    case " Cancelar ":
		controlador.funcionesBotones.resetServicios();
		break;
	    case "Contratar servicios adicionales":
		controlador.funcionesServicios.activarPanel();

		break;
	    case "Actualizar servicios":
		controlador.funcionesServicios.activarPanel();
		vista.buscarAlojamiento.checkWifi.setSelected(false);
		vista.buscarAlojamiento.checkAire.setSelected(false);
		vista.buscarAlojamiento.checkGimnasio.setSelected(false);
		vista.buscarAlojamiento.checkParking.setSelected(false);
		vista.buscarAlojamiento.checkPiscina.setSelected(false);
		vista.buscarAlojamiento.checkSpa.setSelected(false);
		break;
	    }
	}
    }
}
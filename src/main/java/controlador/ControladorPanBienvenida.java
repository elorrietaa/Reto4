package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class ControladorPanBienvenida implements ActionListener {

    private JframePrincipal vista;
    private PrincipalControlador controlador;

    public ControladorPanBienvenida(JframePrincipal vista, PrincipalControlador controlador) {
	this.vista = vista;
	this.controlador = controlador;
    }

    /**
     * Se crean los listeners del panel
     */
    public void addListeners() {
	vista.bienvenida.btnContinuar.addActionListener(this);
    }

    /**
     * Acción de los distintos listeners
     */
    public void actionPerformed(ActionEvent e) {
	vista.buscarAlojamiento.setVisible(true);
	vista.bienvenida.setVisible(false);

	this.controlador.controladorPanBuscarAlojamiento.mostrarCiudad();
	this.controlador.controladorPanBuscarAlojamiento.mostrarTiposAloj();
	;
	this.controlador.controladorPanBuscarAlojamiento.mostrarOpcionesParaOrdenar();
	this.controlador.controladorPanBuscarAlojamiento.mostrarOpcionesAscDesc();
    }
}
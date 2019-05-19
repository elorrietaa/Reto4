package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class ControladorPanVueltas implements ActionListener {
	
	private JframePrincipal vista;
	private PrincipalModelo modelo;
	private PrincipalControlador controlador;
	private ControladorPanPago pago;
	
	public ControladorPanVueltas(JframePrincipal vista, PrincipalModelo modelo, PrincipalControlador controlador, ControladorPanPago pago) {
		this.vista = vista;
		this.modelo = modelo;
		this.controlador = controlador;
		this.pago = pago;
	}
	
	/**
	 * Se crean los listeners del panel
	 */
	public void addListeners() {
		vista.vueltas.btnFinalizar.addActionListener(this);
	}
	
	/**
	 * Acción de los distintos listeners
	 */
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
				
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Finalizar":
				JOptionPane.showMessageDialog(vista, "Reserva realizada con exito, muchas gracias.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				vista.bienvenida.setVisible(true);
				vista.vueltas.setVisible(false);
				controlador.funcionesBotones.resetPago(this.pago);
				break;
		}
	}
}
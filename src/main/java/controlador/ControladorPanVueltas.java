package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class ControladorPanVueltas implements ActionListener {
	
	public JframePrincipal vista;
	public PrincipalModelo modelo;
	
	public ControladorPanVueltas(JframePrincipal vista, PrincipalModelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void addListeners() {
		vista.vueltas.btnFinalizar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
				
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
			
			case "Finalizar":
				JOptionPane.showMessageDialog(vista, "Reserva realizada con exito, muchas gracias.", null, 0);
				System.exit(0);
				break;
		}
	}
}
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class ControladorPanBases implements ActionListener{
	
	private JframePrincipal vista;
	private PrincipalModelo modelo;
	private PrincipalControlador controlador;
	
	public ControladorPanBases(JframePrincipal vista, PrincipalModelo modelo, PrincipalControlador controlador) {
		this.vista = vista;
		this.modelo = modelo;
		this.controlador = controlador;
	}
	
	public void addListeners() {
		this.vista.bases.btnAceptar.addActionListener(this);
		this.vista.bases.btnDeclinar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand(); // Almacena el texto del boton para poder identificarlo posteriormente
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Aceptar":
				if(modelo.tiposAloj.getCodTipoAlojamiento() == 10) {
					vista.panPersonasAlojadas.setVisible(true);
					vista.bases.setVisible(false);
					modelo.basesAceptadas = true;
				}
				else {
					vista.panPersonasAlojadas.setVisible(true);
					vista.bases.setVisible(false);
					modelo.basesAceptadas = true;
				}
				break;
				
			case "Declinar":
				if (JOptionPane.showConfirmDialog(vista, "¿Estas segudo de querer declinar las politicas? Si lo haces se reseteara la aplicacion", "Declinar politicas", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					vista.bienvenida.setVisible(true);
					vista.bases.setVisible(false);
					controlador.funcionesBotones.reset();
				}
				break;
		}
	}
}
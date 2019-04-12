package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import vista.JframePrincipal;

public class ControladorJframe {
	private JframePrincipal vista;
	
	public ControladorJframe(JframePrincipal vista) {
		this.vista = vista;
	}
	
	public void addListeners() {
		vista.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// Se pide una confirmación antes de finalizar el programa
	            if (JOptionPane.showConfirmDialog(vista, "¿Estas seguro que quieres salir de la aplicación?", "Salir de la aplicación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	            	System.exit(0);
	            }
			}
		});
	}
}

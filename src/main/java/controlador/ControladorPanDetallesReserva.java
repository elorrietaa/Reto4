package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class ControladorPanDetallesReserva implements ActionListener {

	public JframePrincipal vista;
	public PrincipalModelo modelo;
	public PrincipalControlador controlador;
	/**
	 * Constructor del controlador de detalles
	 * 
	 * @param vista Instancia del main frame para poder utilizarlo
	 * @param modelo Instancia del modelo para poder utilizarlo
	 * @param conexion 
	 */
	public ControladorPanDetallesReserva(JframePrincipal vista, PrincipalModelo modelo, PrincipalControlador controlador) {
		this.vista = vista;
		this.modelo = modelo;
		this.controlador = controlador;
	}
	
	/**
	 * Creacion de los listeners para los distintos elementos del panel
	 */
	public void addListeners() {
		vista.detallesReserva.btnCancelar.addActionListener(this);
		vista.detallesReserva.btnInicioSesion.addActionListener(this);
		vista.detallesReserva.btnRegistro.addActionListener(this);
		vista.detallesReserva.btnAtras.addActionListener(this);
		vista.detallesReserva.btnContinuar.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object sourceObject = e.getSource();
		
		if (sourceObject instanceof JButton) {
			
			String botonPulsado = ((JButton) sourceObject).getActionCommand();
		   
			// comprobamos que boton se ha pulsado y ejecutamos sus acciones
			switch (botonPulsado) { 
				
			case "Atras":
				vista.detallesReserva.setVisible(false);
				vista.selHabitacion.setVisible(true);
				break;
			
			case "Continuar":
				funcionContinuar();
				break;
			case "Inicio Sesión":
				ControladorLogin.panelOrigen = vista.detallesReserva;
				vista.login.setVisible(true);
				vista.detallesReserva.setVisible(false);
				break;
			
			case "Registro":
				ControladorRegistro.panelOrigen = vista.detallesReserva;
				vista.registro.setVisible(true);
				vista.detallesReserva.setVisible(false);
				break;
				
			case "Cancelar":
				vista.bienvenida.setVisible(true);
				vista.detallesReserva.setVisible(false);
				controlador.funcionesRegistro.mostrarBotones();
				controlador.funcionesBotones.reset();
				break;
			}
		}
	}
	
	public void funcionContinuar() {
		ControladorLogin.panelOrigen = vista.detallesReserva;
		ControladorLogin.detalles = true;
		vista.pago.total.setText(Float.toString(this.modelo.precioTotal) + " €");
		vista.pago.aPagar.setText(Float.toString(this.modelo.precioTotal) + " €");
		if(modelo.cliente == null) {
			vista.login.setVisible(true);
			vista.detallesReserva.setVisible(false);
		}
		else {
			vista.pago.setVisible(true);
			vista.detallesReserva.setVisible(false);
		}
	}
}

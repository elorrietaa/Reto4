package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class ContrPanDetReserCasaApart implements ActionListener {

	public JframePrincipal vista;
	public PrincipalModelo modelo;
	/**
	 * Constructor del controlador de detalles
	 * 
	 * @param vista Instancia del main frame para poder utilizarlo
	 * @param modelo Instancia del modelo para poder utilizarlo
	 * @param conexion 
	 */
	public ContrPanDetReserCasaApart(JframePrincipal vista, PrincipalModelo modelo) {
		this.vista = vista;
		this.modelo = modelo;		
	}
	
	/**
	 * Creacion de los listeners para los distintos elementos del panel
	 */
	public void addListeners() {
		vista.detallesReservaCasaApart.btnAtras.addActionListener(this);
		vista.detallesReservaCasaApart.btnContinuar.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object sourceObject = e.getSource();
		
		if (sourceObject instanceof JButton) {
			
			String botonPulsado = ((JButton) sourceObject).getActionCommand();
		   
			// comprobamos que boton se ha pulsado y ejecutamos sus acciones
			switch (botonPulsado) { 
				
			case "Atras":
				vista.buscarHotel.setVisible(true);
				vista.detallesReservaCasaApart.setVisible(false);
				break;
			
			case "Continuar":
				funcionContinuar();
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

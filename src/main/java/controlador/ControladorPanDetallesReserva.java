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
	 * @param controlador Instancia del controlador para poder utilizarlo
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
		vista.detallesReserva.btnCerrarSesion.addActionListener(this);
		vista.detallesReserva.btnCancelar.addActionListener(this);
		vista.detallesReserva.btnInicioSesion.addActionListener(this);
		vista.detallesReserva.btnRegistro.addActionListener(this);
		vista.detallesReserva.btnAtras.addActionListener(this);
		vista.detallesReserva.btnContinuar.addActionListener(this);
	}
	
	/**
	 * Acci�n de los distintos listeners
	 */
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
			case "Inicio Sesi�n":
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
				controlador.funcionesBotones.reset();
				break;
			case "Cerrar Sesi�n":
				controlador.funcionesBotones.cerrarSesion();
				break;
			}
		}
	}
	
	/**
	 * M�todo funcionContinuar = contiene los m�todos que se ejecutar�n cuando el usuario pulse al bot�n continuar
	 */
	public void funcionContinuar() {
		ControladorLogin.panelOrigen = vista.detallesReserva;
		ControladorLogin.detalles = true;
		
		//Si no se ha iniciado sesi�n, es decir, si el cliente es null, cuando se pulse el bot�n continuar se ir� al panel PanDetallesReservaAloj
		if(modelo.cliente == null) {
			vista.login.setVisible(true);
			vista.detallesReserva.setVisible(false);
		}
		////Si no se han aceptado las bases, es decir, si el basesAceptadas es null, cuando se pulse el bot�n continuar se ir� al panel PanBasesLegales
		else if(modelo.basesAceptadas == true){
			vista.pago.setVisible(true);
			vista.detallesReserva.setVisible(false);
		}
		//sino, se ir� al panel PanDetallesReserva
		else {
			vista.bases.setVisible(true);
			vista.detallesReserva.setVisible(false);
		}
	}
}

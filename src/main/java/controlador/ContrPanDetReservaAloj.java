package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class ContrPanDetReservaAloj implements ActionListener {

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
	public ContrPanDetReservaAloj(JframePrincipal vista, PrincipalModelo modelo, PrincipalControlador controlador) {
		this.vista = vista;
		this.modelo = modelo;
		this.controlador = controlador;
	}
	
	/**
	 * Creacion de los listeners para los distintos elementos del panel
	 */
	public void addListeners() {
		vista.detallesReservaCasaApart.btnCancelar.addActionListener(this);
		vista.detallesReservaCasaApart.btnInicioSesion.addActionListener(this);
		vista.detallesReservaCasaApart.btnRegistro.addActionListener(this);
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
				//falta meter en un metrodo reset()
				//Que se reseteen los datos del panel
				vista.detallesReservaCasaApart.textFieldDetHabs.setText("");
				
				if(modelo.tiposAloj.getCodTipoAlojamiento() == 10) {
					vista.selHabitacion.setVisible(true);
					vista.detallesReservaCasaApart.setVisible(false);
				}
				else if (modelo.tiposAloj.getCodTipoAlojamiento() == 20 || modelo.tiposAloj.getCodTipoAlojamiento() == 30) {
					vista.buscarAlojamiento.setVisible(true);
					vista.detallesReservaCasaApart.setVisible(false);
				}
				
				break;
			
			case "Continuar":
				funcionContinuar();
				break;
				
			case "Inicio Sesión":
				ControladorLogin.panelOrigen = vista.detallesReservaCasaApart;
				vista.login.setVisible(true);
				vista.detallesReservaCasaApart.setVisible(false);
				break;
			
			case "Registro":
				ControladorRegistro.panelOrigen = vista.detallesReservaCasaApart;
				vista.registro.setVisible(true);
				vista.detallesReservaCasaApart.setVisible(false);
				break;
				
			case "Cancelar":
				vista.bienvenida.setVisible(true);
				vista.detallesReservaCasaApart.setVisible(false);
				controlador.funcionesBotones.reset();
				break;
			}
		}
	}
	
	public void funcionContinuar() {
		ControladorLogin.panelOrigen = vista.detallesReservaCasaApart;
		ControladorLogin.detalles = true;
		vista.pago.total.setText(Float.toString(modelo.precioTotal) + " €");
		vista.pago.aPagar.setText(Float.toString(modelo.precioTotal) + " €");
		if(modelo.cliente == null) {
			vista.login.setVisible(true);
			vista.detallesReservaCasaApart.setVisible(false);
		}
		
		else {
			//se carga el comboBox con los cuponesPromocionales en el panel pago
			controlador.funcionesCodigosPromo.mostrarTodosCuponesDescuento();
		    controlador.funcionesCodigosPromo.mostrarCuponesDescuento();
			
			vista.cupon.setVisible(true);
			vista.detallesReservaCasaApart.setVisible(false);
		}
	}
}

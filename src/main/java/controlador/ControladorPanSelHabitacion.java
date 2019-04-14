package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import bbdd.Conexion;
import modelo.Consultas;
import modelo.PrincipalModelo;
import vista.JframePrincipal;


/**
 * Esta clase controla el panel de detalles y se encarga de enlazar esa parte de la vista con el modelo
 * 
 */
public class ControladorPanSelHabitacion implements ActionListener {
	
	public JframePrincipal vista;
	public PrincipalModelo modelo; 
	Consultas consultas;
	public PrincipalControlador controlador;
	/**
	 * Constructor del controlador de detalles
	 * 
	 * @param vista Instancia del main frame para poder utilizarlo
	 * @param modelo Instancia del modelo para poder utilizarlo
	 */
	public ControladorPanSelHabitacion(JframePrincipal vista, PrincipalModelo modelo,Conexion conexion, PrincipalControlador controlador ) {
		this.vista = vista;
		this.modelo = modelo;		
		this.consultas = new Consultas(conexion);
		this.controlador = controlador;
	}
	/**
	 * Creacion de los listeners para los distintos elementos del panel
	 */
	public void addListeners() {
		vista.selHabitacion.btnAtras.addActionListener(this);
		vista.selHabitacion.btnContinuar.addActionListener(this);
	}
	/**
	 * Acciones de los distintos componentes del panel
	 */
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Atrás":
				
				vista.buscarHotel.setVisible(true);
				vista.selHabitacion.setVisible(false);
				break;
			
			
			case "Continuar":
				
				// Se guardan los detalles de la (o las habitaciones seleecionadas)
				
				//Se calcula el precio de la reserva
				
				//se gudardan los datos de la reserva en el objeto reserva, y concretamente en un arrayLista listaReservas
				
				// Desaparece Panel de Seleccionar habitacion  y aparece panel de detalles reserva
				vista.selHabitacion.setVisible(false);
				vista.detallesReserva.setVisible(true);
				
				break;
	
				
				
		}
		
	}
	/**
	 * Funciones del boton de clancelar
	 */
	public void reset() {
		modelo.cliente = null;
		
		/*
		modelo.billeteIda = null;
		modelo.billeteVuelta = null;
		modelo.linea = null;
		modelo.paradaOrigen = null;
		modelo.paradaDestino = null;
		modelo.autobus = null;
		vista.sel_billete.rbtnIda.setSelected(true);
		vista.sel_billete.rbtnVuelta.setSelected(false);
		*/
		
		modelo.precioTotal = 0;
		vista.login.userField.setText("");
		vista.login.password.setText("");
		
		vista.registro.txtNombre.setText("");
		vista.registro.txtApellidos.setText("");
		vista.registro.rbtnMasc.setSelected(false);
		vista.registro.rbtnFem.setSelected(false);
		vista.registro.txtDni.setText("");
		vista.registro.passwordField.setText("");
		vista.registro.passwordField2.setText("");
	}
	
}

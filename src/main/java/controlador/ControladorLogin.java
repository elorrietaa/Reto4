package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

/**
 * Esta clase controla las distintas funciones de la ventana de inicio de sesion
 */

public class ControladorLogin implements ActionListener {
	
	private JframePrincipal vista; // Instancia del MainFrame.
	private PrincipalModelo modelo; // Instancia del Modelo.
	private PrincipalControlador controlador;
	public static JPanel panelOrigen; // Guarda el panel del que se viene al panel de registro.
	public static Boolean detalles; // Indica si se viene de la ventana de detalles.
	/**
	 * Constructor del controlador de inicio de sesion
	 * 
	 * @param vista Guarda el objeto vista para poder utilizar los distintos elementos de la interfaz
 	 * @param modelo Guarda el objeto modelo para poder acceder a los metodos del modelo
	 */
	public ControladorLogin(JframePrincipal vista, PrincipalModelo modelo, PrincipalControlador controlador) { // Constructor
		this.vista = vista;
		this.modelo = modelo;
		this.controlador = controlador;
		panelOrigen = null;
		detalles = false;
	}
	/**
	 * Creamos los listeners del panel de inicio de sesion
	 */
	public void addListeners() {
		//vista.login.btnAtras.addActionListener(this);
		vista.login.btnCancelar.addActionListener(this);
		vista.login.btnRegistro.addActionListener(this);
		vista.login.btnLogin.addActionListener(this);
		vista.login.btnAtras.addActionListener(this);
	}
	/**
	 * Metodo que designa la accion realizada por cada listener
	 */
	public void actionPerformed(ActionEvent e) { // Acciones de los botones de la ventana de inicio de sesion.
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones.
		switch (botonPulsado) {
		
			case "Atrás":
				
				panelOrigen.setVisible(true);
				vista.login.setVisible(false);
				break;
			
			case "Cancelar":
				
				vista.bienvenida.setVisible(true);
				vista.login.setVisible(false);
				controlador.funcionesBotones.reset();
				break;
				
			case "Registro":
				
				vista.registro.setVisible(true);
				vista.login.setVisible(false);
				ControladorRegistro.panelOrigen = panelOrigen;
				break;
				
			case "Iniciar Sesión":
				
				// recogemos los datos ingresados por el usuario
				String dni = vista.login.userField.getText(); // Recoge el dni que ha sido introducido desde la interfaz.
				char[] cont = vista.login.password.getPassword(); // Recoge la contraseña que ha sido introducida desde la interfaz.
				String contString = new String(cont); // Transforma la contraseña que esta en un array de caracteres a String.
				
				// comprobamos si el usuario esta registrado
				modelo.cliente = controlador.funcionesRegistro.comprobarInicio(dni, contString); // Llamada a la funcion comprobarInicio.
			
				// mostramos la pantalla adecuada
				if(modelo.cliente != null) { // Comprueba si hay un cliente.
					
					controlador.funcionesRegistro.ocultarBotones();
					if(detalles == false) {
						// mostrar la pantalla adecuada
						panelOrigen.setVisible(true);
						vista.login.setVisible(false);
					}
				//	else if(modelo.basesAceptadas == true){
						// mostrar la pantalla adecuada
					//	vista.pago.setVisible(true);
					//	vista.login.setVisible(false);
				//	}
					else {
						//se carga el comboBox con los cuponesPromocionales en el panel pago
						controlador.funcionesCodigosPromo.mostrarTodosCuponesDescuento();
					    controlador.funcionesCodigosPromo.mostrarCuponesDescuento();
					    
						vista.cupon.setVisible(true);
						vista.login.setVisible(false);
					}
					
				} else {
					JOptionPane.showMessageDialog(vista, "Datos erróneos. Inténtelo de nuevo", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				break;
		}
	}
}
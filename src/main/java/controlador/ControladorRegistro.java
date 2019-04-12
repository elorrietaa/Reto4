package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import modelo.Cliente;
import modelo.Modelo;
import vista.MainFrame;

/**
 * Esta clase se encarga de controlar las funciones del panel de registro.
 * 
 */

public class ControladorRegistro implements ActionListener {
	
	private MainFrame vista; // Instancia del MainFrame
	private Modelo modelo; // Instancia del Modelo
	
	private String nombre; // Guarda el nombre
	private String apellidos; // Guarda el apellido
	private String dni; // Guarda el DNI
	private Date fecha; // Guarda la fecha
	private char sexo; // Guarda el sexo
	private String contrasena; // Guarda la contraseña
	
	public static JPanel panelOrigen; // Guarda el panel del que se viene al panel de registro
	public static Boolean detalles; // Indica si se viene de la ventana de detalles
	/**
	 * Constructor del controlador de registro
	 * 
	 * @param vista: Guarda el objeto vista para poder utilizar los distintos elementos de la interfaz
	 * @param modelo: Guarda el objeto modelo para poder acceder a los metodos del modelo
	 */
	public ControladorRegistro(MainFrame vista, Modelo modelo) { // Constructor
		this.vista = vista;
		this.modelo = modelo;
		panelOrigen = null;
		detalles = false;
	}
	/**
	 * Creamos los listeners necesarios para el panel
	 */
	public void addListeners() {
		vista.registro.btnAtras.addActionListener(this);
		vista.registro.btnCancelar.addActionListener(this);
		vista.registro.btnLogin.addActionListener(this);
		vista.registro.btnRegistro.addActionListener(this);
	}
	/**
	 * Asignamos la accion para cada uno de los listeners
	 */
	public void actionPerformed(ActionEvent e) { // Accion de los botones de la ventana de registro
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Atrás":
				
				panelOrigen.setVisible(true);
				vista.registro.setVisible(false);
				break;
			
			case "Cancelar":
				
				vista.bienvenida.setVisible(true);
				vista.registro.setVisible(false);
				reset();
				break;
				
			case "Inicio Sesión":
				
				vista.login.setVisible(true);
				vista.registro.setVisible(false);
				ControladorLogin.panelOrigen = panelOrigen; // Guarda el panel del que venimos
				break;
				
			case "Registrarse":

				if(validarDatos()) {
					
					if(modelo.consultas.getClienteByDNI(dni) != null) { // Comprueba si existe un usuario con el mismo DNI
						JOptionPane.showMessageDialog(vista, "Ya existe un usuario con ese DNI " + this.dni, "Aviso", JOptionPane.WARNING_MESSAGE); // Si existe, muestra un mensaje de error
					} else { // Si no, registra al cliente
						modelo.cliente = new Cliente(dni, nombre, apellidos, fecha, sexo, contrasena);
						modelo.consultas.insertarCliente(modelo.cliente);
					}
					
					// actualizar pantalla
					if(modelo.cliente != null) {
					
						// deshabilitar botones de login y registro en todos los paneles
						vista.sel_billete.btnLogin.setVisible(false);
						vista.sel_billete.btnLogin.setEnabled(false);
						vista.sel_billete.btnRegistro.setVisible(false);
						vista.sel_billete.btnRegistro.setEnabled(false);
						vista.sel_fecha.btnLogin.setVisible(false);
						vista.sel_fecha.btnLogin.setEnabled(false);
						vista.sel_fecha.btnRegistro.setVisible(false);
						vista.sel_fecha.btnRegistro.setEnabled(false);
						vista.detalles_compra.btnLogin.setVisible(false);
						vista.detalles_compra.btnLogin.setEnabled(false);
						vista.detalles_compra.btnRegistro.setVisible(false);
						vista.detalles_compra.btnRegistro.setEnabled(false);
						
						// mostrar la pantalla adecuada
						if(detalles == false) {
							panelOrigen.setVisible(true);
							vista.registro.setVisible(false);
						}
						else {
							vista.pago.setVisible(true);
							vista.registro.setVisible(false);
						}
					
					}
					
				}
				
				break;
			}
		
	}
	/**
	 * Funcion que valida los datos de registro
	 * 
	 * @return Retorna false si los datos han dado un fallo en la validacion e inica cual es el fallo. Retorna true si la validacion ha sido correcta
	 */
	public boolean validarDatos() { // Funcion que valida los datos de registro
		
		String nombre = vista.registro.txtNombre.getText(); // Guarda la informacion de la interfaz en diferentes variables
		String apellidos = vista.registro.txtApellidos.getText();
		JDateChooser fecha = vista.registro.dateChooser;
		boolean femenino = vista.registro.rbtnFem.isSelected();
		boolean masculino = vista.registro.rbtnMasc.isSelected();
		String dni = vista.registro.txtDni.getText();
		char[] contrasenaChar = vista.registro.passwordField.getPassword();
		char[] contrasena2Char = vista.registro.passwordField2.getPassword();
		String contrasena = new String(contrasenaChar);
		String contrasena2 = new String(contrasena2Char);
		
		// comprobamos que el nombre no este vacio
		if (nombre.equals("")) {
			JOptionPane.showMessageDialog(vista, "Nombre no introducido.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.nombre = nombre;
		}
		
		// comprobamos que el apellido no este vacio
		if (apellidos.equals("")) {
			JOptionPane.showMessageDialog(vista, "Apellido no introducido.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.apellidos = apellidos;
		}
		
		// comprobamos que se ha seleccionado una fecha
		if (fecha.getDate() == null) {
			JOptionPane.showMessageDialog(vista, "Ninguna fecha seleccionada.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.fecha = new Date(fecha.getDate().getTime());
		}
		
		// comprobamos que haya sido seleccionado un sexo y le asignamos el valor adecuado a la variable
		if (!femenino && !masculino) {
			JOptionPane.showMessageDialog(vista, "Sexo no seleccionado.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (femenino) {
			this.sexo = 'M';
		} else {
			this.sexo = 'V';
		}
		
		// comprobamos que el dni ha sido introducido correctamente
		if (modelo.funcionesRegistro.validarDNI(dni) == false) {
			JOptionPane.showMessageDialog(vista, "DNI no introducido o el introducido no es valido.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else 
			this.dni = dni;
				
		// comprobamos que la contraseña no este vacia
		if (contrasena.equals("")) {
			JOptionPane.showMessageDialog(vista, "Contraseña no introducida.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		// comprobamos que la contraseña2 no este vacia
		if (contrasena2.equals("")) {
			JOptionPane.showMessageDialog(vista, "Confirmar contraseña no introducida.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		// comprobamos que las dos contraseñas sean iguales
		if(!contrasena.equals(contrasena2)) {
			JOptionPane.showMessageDialog(vista, "Las contraseñas no son iguales", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.contrasena = contrasena;
			this.contrasena = modelo.funcionesRegistro.encriptacion(this.contrasena);
		}
		
		return true;
		
	}
	/**
	 * Funcion del boton de cancelar
	 */
	public void reset() {
		modelo.cliente = null;
		modelo.billeteIda = null;
		modelo.billeteVuelta = null;
		modelo.linea = null;
		modelo.paradaOrigen = null;
		modelo.paradaDestino = null;
		modelo.autobus = null;
		modelo.precioTotal = 0;
		
		vista.sel_billete.rbtnIda.setSelected(true);
		vista.sel_billete.rbtnVuelta.setSelected(false);
		
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

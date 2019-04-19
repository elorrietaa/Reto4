package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanLogin extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JLabel lblUsuario,lblPassword;
	public JTextField userField;
	public JPasswordField password;
	public JButton btnLogin,btnRegistro,btnCancelar, btnAtras;

	/**
	 * Create the panel.
	 */
	public PanLogin() {
		setBackground(Color.WHITE);
		
		// configuracion del panel
		setLayout(null);
		setBounds(0,0,1024,720);
		
		// boton registarse
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(875, 30, 81, 25);
		add(btnRegistro);
		
		// label usuario
		lblUsuario = new JLabel("Usuario (DNI)");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(397, 283, 215, 25);
		add(lblUsuario);
		
		// campo usuario
		userField = new JTextField();
		userField.setBounds(397, 308, 215, 30);
		userField.setColumns(10);
		add(userField);
		
		// label password
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(397, 353, 215, 25);
		add(lblPassword);
		
		// campo password
		password = new JPasswordField();
		password.setBounds(397, 378, 215, 30);
		add(password);
		
		// boton de iniciar sesion
		btnLogin = new JButton("Iniciar Sesi\u00F3n");
		btnLogin.setBounds(452, 441, 120, 40);
		add(btnLogin);
		
		// boton cancelar
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(74, 622, 75, 30);
		add(btnCancelar);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(178, 622, 65, 30);
		add(btnAtras);
		
	}
}

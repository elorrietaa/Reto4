package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;

public class PanRegistro extends JPanel {
	
	private static final long serialVersionUID = 1L;
		
	public JLabel lblNombre,lblApellidos,lblDni, lblSexo,lblPassword, lblPassword2, lblfechaNac, lblErrorDNI, lblErrorContrasenas, lblErrorSexo, lblErrorDNINoIntroducido;
	public JTextField txtNombre, txtApellidos, txtDni;
	public JButton btnLogin, btnRegistro, btnCancelar, btnAtras;
	public final ButtonGroup rbtnGroupSexo = new ButtonGroup();
	public JRadioButton rbtnMasc, rbtnFem;
	public JPasswordField passwordField, passwordField2;
	public JDateChooser dateChooser;
	public JProgressBar progressBar;

	/**
	 * Create the panel.
	 */
	
	public PanRegistro() {
		
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0,0,1024,720);
		
		btnLogin = new JButton("Inicio Sesi\u00F3n");
		btnLogin.setBounds(859, 38, 97, 20);
		add(btnLogin);
		
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(452, 537, 120, 40);
		add(btnRegistro);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(164, 653, 77, 20);
		add(btnAtras);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(59, 653, 77, 20);
		add(btnCancelar); 

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(322, 269, 77, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(409, 266, 216, 20);
		txtNombre.setColumns(10);
		add(txtNombre);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(322, 300, 77, 14);
		add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(409, 297, 216, 20);
		txtApellidos.setColumns(10);
		add(txtApellidos);
		
		lblfechaNac = new JLabel("Fecha nacimiento");
		lblfechaNac.setBounds(322, 328, 123, 20);
		add(lblfechaNac);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(455, 328, 170, 20);
		add(dateChooser);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(322, 377, 77, 14);
		add(lblSexo);
		
		rbtnMasc = new JRadioButton("Masculino");
		rbtnMasc.setBackground(Color.WHITE);
		rbtnGroupSexo.add(rbtnMasc);
		rbtnMasc.setBounds(462, 362, 112, 23);
		add(rbtnMasc);
		
		rbtnFem = new JRadioButton("Femenino");
		rbtnFem.setBackground(Color.WHITE);
		rbtnGroupSexo.add(rbtnFem);
		rbtnFem.setBounds(462, 388, 112, 23);
		add(rbtnFem);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(322, 421, 77, 14);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(409, 418, 216, 20);
		txtDni.setColumns(10);
		add(txtDni);
		
		lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(322, 455, 109, 14);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(450, 452, 140, 20);
		add(passwordField);
		
		lblPassword2 = new JLabel("Confirmar contraseña");
		lblPassword2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword2.setBounds(260, 486, 170, 14);
		add(lblPassword2);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(450, 483, 140, 20);
		add(passwordField2);
		
	}
}

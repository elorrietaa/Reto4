package vista;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
/**
 * Clase PanVueltas = contiene los elementos necesarios para formar el Panel en el que se muestran los detalles de las vueltas del pago
 * @author alba
 *
 */
public class PanVueltas extends JPanel {
	public JTextField textField, textField_1;
	public JLabel lblTotalAPagar, lblTotalIntroducido, lblVueltas;
	public JTextPane PanelVueltas;
	public JButton btnFinalizar;

	/**
	 * Create the panel.
	 */
	public PanVueltas() {
		setBackground(Color.LIGHT_GRAY);
		setBounds(0, 0, 1024, 720);
		setLayout(null);
		
		lblTotalAPagar = new JLabel("Total a pagar");
		lblTotalAPagar.setBounds(356, 239, 80, 14);
		add(lblTotalAPagar);
		
		lblTotalIntroducido = new JLabel("Total introducido");
		lblTotalIntroducido.setBounds(356, 281, 80, 14);
		add(lblTotalIntroducido);
		
		textField = new JTextField();
		textField.setBounds(483, 239, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(483, 281, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblVueltas = new JLabel("Vueltas");
		lblVueltas.setBounds(356, 328, 46, 14);
		add(lblVueltas);
		
		PanelVueltas = new JTextPane();
		PanelVueltas.setBounds(440, 328, 129, 159);
		add(PanelVueltas);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(415, 519, 89, 23);
		add(btnFinalizar);
	}
}
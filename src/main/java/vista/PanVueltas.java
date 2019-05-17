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
	public JTextField txtTotal, txtTotalIntro;
	public JLabel lblTotalAPagar, lblTotalIntroducido, lblVueltas;
	public JTextPane PanelVueltas;
	public JButton btnFinalizar;

	/**
	 * Create the panel.
	 */
	public PanVueltas() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1024, 720);
		setLayout(null);
		
		lblTotalAPagar = new JLabel("Total a pagar");
		lblTotalAPagar.setBackground(new Color(240, 240, 240));
		lblTotalAPagar.setBounds(356, 239, 80, 14);
		add(lblTotalAPagar);
		
		lblTotalIntroducido = new JLabel("Total introducido");
		lblTotalIntroducido.setBounds(356, 281, 80, 14);
		add(lblTotalIntroducido);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(483, 239, 86, 20);
		add(txtTotal);
		txtTotal.setColumns(10);
		
		txtTotalIntro = new JTextField();
		txtTotalIntro.setEditable(false);
		txtTotalIntro.setBounds(483, 281, 86, 20);
		add(txtTotalIntro);
		txtTotalIntro.setColumns(10);
		
		lblVueltas = new JLabel("Vueltas");
		lblVueltas.setBounds(356, 328, 46, 14);
		add(lblVueltas);
		
		PanelVueltas = new JTextPane();
		PanelVueltas.setBackground(new Color(245, 245, 245));
		PanelVueltas.setEditable(false);
		PanelVueltas.setBounds(440, 328, 129, 159);
		add(PanelVueltas);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(415, 519, 89, 23);
		FormatoDiseno.formatoBtn(btnFinalizar);
		add(btnFinalizar);
	}
}
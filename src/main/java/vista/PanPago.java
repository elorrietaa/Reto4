package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanPago extends JPanel {
	public JTextField total, totalIntro, aPagar;
	public JButton

	/**
	 * Create the panel.
	 */
	public PanPago() {
		setBackground(Color.LIGHT_GRAY);
		setBounds(0, 0, 1024, 720);
		setLayout(null);
		
		JButton btn200 = new JButton("200 \u20AC");
		btn200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn200.setBounds(163, 188, 89, 23);
		add(btn200);
		
		JButton btn100 = new JButton("100 \u20AC");
		btn100.setBounds(163, 236, 89, 23);
		add(btn100);
		
		JButton btn50 = new JButton("50 \u20AC");
		btn50.setBounds(163, 284, 89, 23);
		add(btn50);
		
		JButton btn20 = new JButton("20 \u20AC");
		btn20.setBounds(163, 337, 89, 23);
		add(btn20);
		
		JButton btn10 = new JButton("10 \u20AC");
		btn10.setBounds(163, 388, 89, 23);
		add(btn10);
		
		JButton btn5 = new JButton("5 \u20AC");
		btn5.setBounds(163, 441, 89, 23);
		add(btn5);
		
		JButton btn2 = new JButton("2 \u20AC");
		btn2.setBounds(339, 284, 89, 23);
		add(btn2);
		
		JButton btn1 = new JButton("1 \u20AC");
		btn1.setBounds(339, 337, 89, 23);
		add(btn1);
		
		JButton btn50cen = new JButton("0,5 \u20AC");
		btn50cen.setBounds(513, 188, 89, 23);
		add(btn50cen);
		
		JButton btn20cen = new JButton("0,2 \u20AC");
		btn20cen.setBounds(513, 236, 89, 23);
		add(btn20cen);
		
		JButton btn10cen = new JButton("0,1 \u20AC");
		btn10cen.setBounds(513, 284, 89, 23);
		add(btn10cen);
		
		JButton btn3cen = new JButton("0,05 \u20AC");
		btn3cen.setBounds(513, 337, 89, 23);
		add(btn3cen);
		
		JButton btn2cen = new JButton("0,02 \u20AC");
		btn2cen.setBounds(513, 388, 89, 23);
		add(btn2cen);
		
		JButton btn1cen = new JButton("0,01 \u20AC");
		btn1cen.setBounds(513, 441, 89, 23);
		add(btn1cen);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(187, 63, 46, 14);
		add(lblTotal);
		
		total = new JTextField();
		total.setBounds(163, 88, 86, 20);
		add(total);
		total.setColumns(10);
		
		JLabel lblTotalIntroducido = new JLabel("Total introducido");
		lblTotalIntroducido.setBounds(339, 63, 89, 14);
		add(lblTotalIntroducido);
		
		totalIntro = new JTextField();
		totalIntro.setBounds(339, 88, 86, 20);
		add(totalIntro);
		totalIntro.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("A pagar");
		lblNewLabel.setBounds(533, 63, 46, 14);
		add(lblNewLabel);
		
		aPagar = new JTextField();
		aPagar.setBounds(513, 88, 86, 20);
		add(aPagar);
		aPagar.setColumns(10);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(36, 630, 89, 23);
		add(btnAtras);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(713, 630, 89, 23);
		add(btnContinuar);
	}
}
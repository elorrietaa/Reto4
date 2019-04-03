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
	public JButton btn200, btn100, btn50, btn20, btn10, btn5, btn2, btn1, btn50cen, btn20cen, btn10cen, btn5cen, btn2cen, btn1cen, btnAtras, btnContinuar;
	public JLabel lblTotal, lblTotalIntroducido, lblAPagar;

	/**
	 * Create the panel.
	 */
	public PanPago() {
		setBackground(Color.LIGHT_GRAY); 
		setBounds(0, 0, 1024, 720);
		setLayout(null);
		
		btn200 = new JButton("200 \u20AC");
		btn200.setBounds(163, 188, 89, 23);
		add(btn200);
		
		btn100 = new JButton("100 \u20AC");
		btn100.setBounds(163, 236, 89, 23);
		add(btn100);
		
		btn50 = new JButton("50 \u20AC");
		btn50.setBounds(163, 284, 89, 23);
		add(btn50);
		
		btn20 = new JButton("20 \u20AC");
		btn20.setBounds(163, 337, 89, 23);
		add(btn20);
		
		btn10 = new JButton("10 \u20AC");
		btn10.setBounds(163, 388, 89, 23);
		add(btn10);
		
		btn5 = new JButton("5 \u20AC");
		btn5.setBounds(163, 441, 89, 23);
		add(btn5);
		
		btn2 = new JButton("2 \u20AC");
		btn2.setBounds(339, 284, 89, 23);
		add(btn2);
		
		btn1 = new JButton("1 \u20AC");
		btn1.setBounds(339, 337, 89, 23);
		add(btn1);
		
		btn50cen = new JButton("0,5 \u20AC");
		btn50cen.setBounds(513, 188, 89, 23);
		add(btn50cen);
		
		btn20cen = new JButton("0,2 \u20AC");
		btn20cen.setBounds(513, 236, 89, 23);
		add(btn20cen);
		
		btn10cen = new JButton("0,1 \u20AC");
		btn10cen.setBounds(513, 284, 89, 23);
		add(btn10cen);
		
		btn5cen = new JButton("0,05 \u20AC");
		btn5cen.setBounds(513, 337, 89, 23);
		add(btn5cen);
		
		btn2cen = new JButton("0,02 \u20AC");
		btn2cen.setBounds(513, 388, 89, 23);
		add(btn2cen);
		
		btn1cen = new JButton("0,01 \u20AC");
		btn1cen.setBounds(513, 441, 89, 23);
		add(btn1cen);
		
		lblTotal = new JLabel("Total");
		lblTotal.setBounds(187, 63, 46, 14);
		add(lblTotal);
		
		total = new JTextField();
		total.setBounds(163, 88, 86, 20);
		add(total);
		total.setColumns(10);
		
		lblTotalIntroducido = new JLabel("Total introducido");
		lblTotalIntroducido.setBounds(339, 63, 89, 14);
		add(lblTotalIntroducido);
		
		totalIntro = new JTextField();
		totalIntro.setBounds(339, 88, 86, 20);
		add(totalIntro);
		totalIntro.setColumns(10);
		
		lblAPagar = new JLabel("A pagar");
		lblAPagar.setBounds(533, 63, 46, 14);
		add(lblAPagar);
		
		aPagar = new JTextField();
		aPagar.setBounds(513, 88, 86, 20);
		add(aPagar);
		aPagar.setColumns(10);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(36, 630, 89, 23);
		add(btnAtras);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(713, 630, 89, 23);
		add(btnContinuar);
	}
}
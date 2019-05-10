package vista;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanBasesLegales extends JPanel {
	
	public JTextPane txBases;
	public JButton btnAceptar, btnDeclinar;

	public PanBasesLegales() {
		setBackground(Color.WHITE);
		setBounds(0,0,1024,720);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 72, 804, 495);
		add(scrollPane);
		
		txBases = new JTextPane();
		scrollPane.setViewportView(txBases);
		
		JLabel lblBasesLegales = new JLabel("Bases legales");
		lblBasesLegales.setHorizontalAlignment(SwingConstants.CENTER);
		lblBasesLegales.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblBasesLegales.setBounds(333, 11, 316, 51);
		add(lblBasesLegales);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(818, 601, 89, 23);
		add(btnAceptar);
		
		btnDeclinar = new JButton("Declinar");
		btnDeclinar.setBounds(103, 601, 89, 23);
		add(btnDeclinar);
	}
}

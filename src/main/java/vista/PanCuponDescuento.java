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
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class PanCuponDescuento extends JPanel {
	public JButton btnAplicar, btnAtras, btnNOAplicar;
	public JComboBox<Object> cBListaCupones;
	public JTextField tFPrecioSinDesc, tFPrecioConDesc;
	public JTextPane textPTodosCupones;
	private JLabel lblDescuentosAplicablesPara;
	private JTextPane textPane;

	public PanCuponDescuento() {
		setBackground(Color.WHITE);
		setBounds(0,0,1024,720);
		setLayout(null);
		
		btnAplicar = new JButton("Aplicar y continuar");
		btnAplicar.setBounds(761, 601, 159, 23);
		add(btnAplicar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(103, 601, 89, 23);
		add(btnAtras);
		
		JLabel label = new JLabel("\u00BFDesea aplicar un cup\u00F3n de descuento?");
		label.setBounds(121, 249, 316, 14);
		add(label);
		
		cBListaCupones = new JComboBox<Object>();
		cBListaCupones.setBounds(121, 305, 316, 20);
		add(cBListaCupones);
		
		tFPrecioSinDesc = new JTextField();
		tFPrecioSinDesc.setEditable(false);
		tFPrecioSinDesc.setColumns(10);
		tFPrecioSinDesc.setBounds(561, 302, 86, 20);
		add(tFPrecioSinDesc);
		
		JLabel label_1 = new JLabel("Precio sin aplicar descuento:");
		label_1.setBounds(561, 266, 177, 14);
		add(label_1);
		
		tFPrecioConDesc = new JTextField();
		tFPrecioConDesc.setEditable(false);
		tFPrecioConDesc.setColumns(10);
		tFPrecioConDesc.setBounds(764, 302, 86, 20);
		add(tFPrecioConDesc);
		
		JLabel label_2 = new JLabel("Precio aplicando descuento:");
		label_2.setBounds(764, 266, 192, 14);
		add(label_2);
		
		JLabel lblSusDescuentos = new JLabel("Todos sus descuentos:");
		lblSusDescuentos.setBounds(121, 11, 221, 14);
		add(lblSusDescuentos);
		
		btnNOAplicar = new JButton("No deseo aplicar nung\u00FAn descuento");
		btnNOAplicar.setBounds(645, 632, 275, 23);
		add(btnNOAplicar);
		
		lblDescuentosAplicablesPara = new JLabel("Descuentos aplicables para el alojamiento que ha seleccionado:");
		lblDescuentosAplicablesPara.setBounds(121, 280, 379, 14);
		add(lblDescuentosAplicablesPara);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 47, 379, 120);
		add(scrollPane);
		
		textPTodosCupones = new JTextPane();
		textPTodosCupones.setEditable(false);
		scrollPane.setViewportView(textPTodosCupones);
		
	
		
		
	}
}

package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
/**
 * Clase PanPago = contiene los elementos necesarios para formar el Panel en el que se muestran los detalles para realizar el pago.
 * @author alba
 *
 */
public class PanPago extends JPanel {
	public JTextField total, totalIntro, aPagar;
	public JButton btn200, btn100, btn50, btn20, btn10, btn5, btn2, btn1, btn50cen, btn20cen, btn10cen, btn5cen, btn2cen, btn1cen, btnAtras, btnContinuar;
	public JLabel lblTotal, lblTotalIntroducido, lblAPagar, lbldeseaAplicarUn;
	public JButton btnCancelar, btnAplicar, btnNoAplicar;
	public JComboBox<Object> cBListaCupones;
	private JTextField totalSindesc;
	private JTextField totalCondesc;

	/**
	 * Create the panel.
	 */
	public PanPago() {
		setBackground(Color.WHITE); 
		setBounds(0, 0, 1024, 720);
		setLayout(null);
		
		btn200 = new JButton("200 \u20AC");
		btn200.setBounds(251, 354, 89, 23);
		add(btn200);
		
		btn100 = new JButton("100 \u20AC");
		btn100.setBounds(251, 402, 89, 23);
		add(btn100);
		
		btn50 = new JButton("50 \u20AC");
		btn50.setBounds(251, 450, 89, 23);
		add(btn50);
		
		btn20 = new JButton("20 \u20AC");
		btn20.setBounds(251, 503, 89, 23);
		add(btn20);
		
		btn10 = new JButton("10 \u20AC");
		btn10.setBounds(251, 554, 89, 23);
		add(btn10);
		
		btn5 = new JButton("5 \u20AC");
		btn5.setBounds(427, 354, 89, 23);
		add(btn5);
		
		btn2 = new JButton("2 \u20AC");
		btn2.setBounds(427, 402, 89, 23);
		add(btn2);
		
		btn1 = new JButton("1 \u20AC");
		btn1.setBounds(427, 455, 89, 23);
		add(btn1);
		
		btn50cen = new JButton("0,5 \u20AC");
		btn50cen.setBounds(427, 506, 89, 23);
		add(btn50cen);
		
		btn20cen = new JButton("0,2 \u20AC");
		btn20cen.setBounds(601, 354, 89, 23);
		add(btn20cen);
		
		btn10cen = new JButton("0,1 \u20AC");
		btn10cen.setBounds(601, 402, 89, 23);
		add(btn10cen);
		
		btn5cen = new JButton("0,05 \u20AC");
		btn5cen.setBounds(601, 455, 89, 23);
		add(btn5cen);
		
		btn2cen = new JButton("0,02 \u20AC");
		btn2cen.setBounds(601, 506, 89, 23);
		add(btn2cen);
		
		btn1cen = new JButton("0,01 \u20AC");
		btn1cen.setBounds(601, 559, 89, 23);
		add(btn1cen);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotal.setBounds(263, 245, 65, 26);
		add(lblTotal);
		
		total = new JTextField();
		total.setEditable(false);
		total.setBounds(251, 280, 86, 20);
		add(total);
		total.setColumns(10);
		
		lblTotalIntroducido = new JLabel("Total introducido:");
		lblTotalIntroducido.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotalIntroducido.setBounds(395, 250, 172, 16);
		add(lblTotalIntroducido);
		
		totalIntro = new JTextField();
		totalIntro.setEditable(false);
		totalIntro.setBounds(427, 280, 86, 20);
		add(totalIntro);
		totalIntro.setColumns(10);
		
		lblAPagar = new JLabel("A pagar:");
		lblAPagar.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAPagar.setBounds(601, 242, 111, 33);
		add(lblAPagar);
		
		aPagar = new JTextField();
		aPagar.setEditable(false);
		aPagar.setBounds(601, 280, 86, 20);
		add(aPagar);
		aPagar.setColumns(10);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(36, 630, 89, 23);
		add(btnAtras);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(713, 630, 89, 23);
		add(btnContinuar);
		btnContinuar.setEnabled(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(36, 664, 89, 23);
		add(btnCancelar);
		
		cBListaCupones = new JComboBox<Object>();
		cBListaCupones.setBounds(53, 50, 316, 20);
		add(cBListaCupones);
		
		lbldeseaAplicarUn = new JLabel("\u00BFDesea aplicar un cup\u00F3n de descuento?");
		lbldeseaAplicarUn.setBounds(53, 25, 221, 14);
		add(lbldeseaAplicarUn);
		
		btnAplicar = new JButton("Aplicar");
		btnAplicar.setBounds(403, 49, 89, 23);
		add(btnAplicar);
		
		btnNoAplicar = new JButton("No aplicar");
		btnNoAplicar.setBounds(403, 92, 89, 23);
		add(btnNoAplicar);
		
		totalSindesc = new JTextField();
		totalSindesc.setEditable(false);
		totalSindesc.setColumns(10);
		totalSindesc.setBounds(601, 85, 86, 20);
		add(totalSindesc);
		
		JLabel lblPrecioSinAplicar = new JLabel("Precio sin aplicar descuento:");
		lblPrecioSinAplicar.setBounds(601, 49, 146, 14);
		add(lblPrecioSinAplicar);
		
		totalCondesc = new JTextField();
		totalCondesc.setEditable(false);
		totalCondesc.setColumns(10);
		totalCondesc.setBounds(774, 86, 86, 20);
		add(totalCondesc);
		
		JLabel lblPrecioAplicandoDescuento = new JLabel("Precio aplicando descuento:");
		lblPrecioAplicandoDescuento.setBounds(774, 50, 146, 14);
		add(lblPrecioAplicandoDescuento);
		btnContinuar.setVisible(false);
	}
}
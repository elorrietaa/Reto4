package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PanBuscarHotel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanBuscarHotel() {
		setLayout(null);
		
		JButton buttonContinuar = new JButton("Continuar");
		buttonContinuar.setBounds(446, 354, 89, 23);
		add(buttonContinuar);
		
		JComboBox cBHotel = new JComboBox();
		cBHotel.setBounds(261, 210, 179, 20);
		add(cBHotel);
		
		JLabel labelHotel = new JLabel("Seleccione Hotel :");
		labelHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelHotel.setBounds(53, 211, 125, 14);
		add(labelHotel);
		
		JLabel labelCiudad = new JLabel("Selecciona la ciudad :");
		labelCiudad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCiudad.setBounds(53, 80, 137, 14);
		add(labelCiudad);
		
		JComboBox cBCiudad = new JComboBox();
		cBCiudad.setBounds(261, 79, 179, 20);
		add(cBCiudad);
		
		JLabel labelFecha = new JLabel("Seleccione Fecha :");
		labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelFecha.setBounds(53, 344, 125, 14);
		add(labelFecha);
		
		JLabel label_5 = new JLabel("1 Noche");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(261, 344, 67, 14);
		add(label_5);

	}

}

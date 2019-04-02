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
		setBounds(0,0,1024,720);
		
		JButton buttonContinuar = new JButton("Continuar");
		buttonContinuar.setBounds(708, 663, 89, 23);
		add(buttonContinuar);
		
		JComboBox cBHotel = new JComboBox();
		cBHotel.setBounds(373, 388, 179, 20);
		add(cBHotel);
		
		JLabel labelHotel = new JLabel("Seleccione Hotel :");
		labelHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelHotel.setBounds(101, 389, 125, 14);
		add(labelHotel);
		
		JLabel labelCiudad = new JLabel("Selecciona la ciudad :");
		labelCiudad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCiudad.setBounds(101, 153, 137, 14);
		add(labelCiudad);
		
		JComboBox cBCiudad = new JComboBox();
		cBCiudad.setBounds(373, 152, 179, 20);
		add(cBCiudad);
		
		JLabel labelFecha = new JLabel("Seleccione Fecha :");
		labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelFecha.setBounds(101, 582, 125, 14);
		add(labelFecha);
		
		JLabel label_5 = new JLabel("1 Noche");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(373, 582, 67, 14);
		add(label_5);

	}

}

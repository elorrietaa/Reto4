package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
/**
 * Clase PanBuscarHotel: contiene los elementos necesarios para formar el Panel en el que se realiza la búsqueda del alojamiento
 * @author alba
 *
 */
public class PanBuscarHotel extends JPanel {
	/**
	 * Create the panel.
	 */
    	public JButton buttonContinuar;
    	public JComboBox cBHotel, cBCiudad; 
    	public JLabel labelHotel, labelCiudad, labelFecha, label_5;
	public PanBuscarHotel() {
		setLayout(null);
		setBounds(0,0,1024,720);
		
		buttonContinuar = new JButton("Continuar");
		buttonContinuar.setBounds(708, 663, 89, 23);
		add(buttonContinuar);
		
		cBHotel = new JComboBox();
		cBHotel.setBounds(373, 388, 179, 20);
		add(cBHotel);
		
		labelHotel = new JLabel("Seleccione Hotel :");
		labelHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelHotel.setBounds(101, 389, 125, 14);
		add(labelHotel);
		
		labelCiudad = new JLabel("Selecciona la ciudad :");
		labelCiudad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCiudad.setBounds(101, 153, 137, 14);
		add(labelCiudad);
		
		cBCiudad = new JComboBox();
		cBCiudad.setBounds(373, 152, 179, 20);
		add(cBCiudad);
		
		labelFecha = new JLabel("Seleccione Fecha :");
		labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelFecha.setBounds(101, 582, 125, 14);
		add(labelFecha);
		
		label_5 = new JLabel("1 Noche");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(373, 582, 67, 14);
		add(label_5);

	}

}

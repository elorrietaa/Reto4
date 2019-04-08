package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
/**
 * Clase PanBuscarHotel: contiene los elementos necesarios para formar el Panel en el que se realiza la b�squeda del alojamiento
 * @author alba
 *
 */
public class PanBuscarHotel extends JPanel {
	/**
	 * Create the panel.
	 */
		public JPanel panelOcultarHoteles;
    	public JButton buttonContinuar;
    	public JComboBox<Object> cBHotel, cBCiudad; 
    	public JLabel labelHotel, labelCiudad, labelFecha, label_5;
    	public JList listHoteles;
    	
	public PanBuscarHotel() {
		setLayout(null);
		setBounds(0,0,1024,720);
		
		buttonContinuar = new JButton("Continuar");
		buttonContinuar.setBounds(708, 663, 89, 23);
		add(buttonContinuar);
		
		labelCiudad = new JLabel("Selecciona la ciudad :");
		labelCiudad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCiudad.setBounds(101, 153, 137, 14);
		add(labelCiudad);
		
		cBCiudad = new JComboBox<Object>();
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
		
		labelHotel = new JLabel("Seleccione Hotel :");
		labelHotel.setBounds(101, 311, 125, 14);
		labelHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(labelHotel);
		
		cBHotel = new JComboBox<Object>();
		cBHotel.setBounds(372, 310, 179, 20);
		add(cBHotel);
		
		listHoteles = new JList();
		listHoteles.setBounds(394, 341, 192, 182);
		add(listHoteles);

	}
}

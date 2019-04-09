package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 * Clase PanBuscarHotel: contiene los elementos necesarios para formar el Panel en el que se realiza la búsqueda del alojamiento
 * @author alba
 *
 */
public class PanBuscarHotel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
		public DefaultListModel<Object> modeloHotel = new DefaultListModel<Object>();
		public DefaultListModel<Object> modeloHibitacion = new DefaultListModel<Object>();
		public JList<Object> listHoteles,listHabitacion;
		public JPanel panelOcultarHoteles;
    	public JButton buttonContinuar;
    	public JComboBox<Object> cBCiudad, cBHabitacion; 
    	public JLabel labelHotel, labelCiudad, labelFecha, label_5, lblSeleccioneHabitacin, lblPrecioHabi;
    	private JTextField precioHabitacion;
    	
    	
	public PanBuscarHotel() {
		setLayout(null);
		setBounds(0,0,1024,720);
		
		buttonContinuar = new JButton("Continuar");
		buttonContinuar.setBounds(708, 663, 89, 23);
		add(buttonContinuar);
		
		labelCiudad = new JLabel("Selecciona la ciudad :");
		labelCiudad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCiudad.setBounds(83, 132, 137, 14);
		add(labelCiudad);
		
		cBCiudad = new JComboBox<Object>();
		cBCiudad.setBounds(247, 131, 179, 20);
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
		labelHotel.setBounds(83, 208, 125, 14);
		labelHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(labelHotel);
		
		listHoteles = new JList<Object>();
		//FormatoDiseno.formatoList(listHoteles);
		listHoteles.setBounds(247, 209, 312, 182);
		add(listHoteles);
		
		lblSeleccioneHabitacin = new JLabel("Seleccione Habitaci\u00F3n:");
		lblSeleccioneHabitacin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeleccioneHabitacin.setBounds(489, 179, 125, 14);
		add(lblSeleccioneHabitacin);
		
		cBHabitacion = new JComboBox<Object>();
		cBHabitacion.setBounds(624, 178, 179, 20);
		add(cBHabitacion);
		
		listHabitacion = new JList<Object>();
		//FormatoDiseno.formatoList(listHabitacion);
		listHabitacion.setBounds(624, 209, 192, 182);
		add(listHabitacion);
		
		lblPrecioHabi = new JLabel("Precio de la habitaci\u00F3n:");
		lblPrecioHabi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecioHabi.setBounds(83, 416, 157, 14);
		add(lblPrecioHabi);
		
		precioHabitacion = new JTextField();
		precioHabitacion.setBounds(274, 415, 86, 20);
		add(precioHabitacion);
		precioHabitacion.setColumns(10);

	}
}

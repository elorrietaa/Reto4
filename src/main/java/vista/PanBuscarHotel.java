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
import javax.swing.JTextPane;
/**
 * Clase PanBuscarHotel: contiene los elementos necesarios para formar el Panel en el que se realiza la b�squeda del alojamiento
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
    	public JButton buttonContinuar, btnMostrarDetalles;
    	public JComboBox<Object> cBCiudad; 
    	public JLabel labelHotel, labelCiudad, labelFecha, label_5, lblSeleccioneHabitacin, lblPrecioHabi, lblDetallesDelHotel;
    	public JTextField precioHabitacion;
    	
    	
	public PanBuscarHotel() {
		setLayout(null);
		setBounds(0,0,1024,720);
		
		buttonContinuar = new JButton("Continuar");
		buttonContinuar.setBounds(708, 663, 89, 23);
		add(buttonContinuar);
		
		labelCiudad = new JLabel("Selecciona la ciudad :");
		labelCiudad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCiudad.setBounds(83, 53, 137, 14);
		add(labelCiudad);
		
		cBCiudad = new JComboBox<Object>();
		cBCiudad.setBounds(249, 52, 179, 20);
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
		labelHotel.setBounds(101, 92, 125, 14);
		labelHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(labelHotel);
		
		listHoteles = new JList<Object>();
		//FormatoDiseno.formatoList(listHoteles);
		listHoteles.setBounds(249, 93, 243, 182);
		add(listHoteles);
		
		lblSeleccioneHabitacin = new JLabel("Seleccione Habitaci\u00F3n:");
		lblSeleccioneHabitacin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeleccioneHabitacin.setBounds(83, 300, 164, 23);
		add(lblSeleccioneHabitacin);
		
		listHabitacion = new JList<Object>();
		//FormatoDiseno.formatoList(listHabitacion);
		listHabitacion.setBounds(249, 305, 243, 135);
		add(listHabitacion);
		
		lblPrecioHabi = new JLabel("Precio de la habitaci\u00F3n:");
		lblPrecioHabi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecioHabi.setBounds(83, 492, 157, 14);
		add(lblPrecioHabi);
		
		precioHabitacion = new JTextField();
		precioHabitacion.setBounds(249, 491, 113, 23);
		add(precioHabitacion);
		precioHabitacion.setColumns(10);
		
		lblDetallesDelHotel = new JLabel("Detalles del hotel seleccionado:");
		lblDetallesDelHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDetallesDelHotel.setBounds(538, 92, 269, 14);
		add(lblDetallesDelHotel);
		
		btnMostrarDetalles = new JButton("Mostrar detalles");
		btnMostrarDetalles.setBounds(752, 90, 89, 23);
		add(btnMostrarDetalles);

	}
}

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
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
		public DefaultListModel<Object> modeloHabitacion = new DefaultListModel<Object>();
		public JList<Object> listHoteles;
		public JPanel panelOcultarHoteles;
    	public JButton buttonContinuar, btnMostrarDetalles;
    	public JComboBox<Object> cBCiudad; 
    	public JLabel labelHotel, labelCiudad, labelFecha;
    	public JTextPane textPaneDetHot;
    	public JCalendar fechaIda, fechaVuelta;
    	
    	
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
		labelFecha.setBounds(95, 392, 125, 14);
		add(labelFecha);
		
		labelHotel = new JLabel("Seleccione Hotel :");
		labelHotel.setBounds(101, 92, 125, 14);
		labelHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(labelHotel);
		
		listHoteles = new JList<Object>();
		//FormatoDiseno.formatoList(listHoteles);
		listHoteles.setBounds(249, 93, 210, 182);
		add(listHoteles);
		
		btnMostrarDetalles = new JButton("Mostrar detalles del hotel seleccionado:");
		btnMostrarDetalles.setBounds(486, 90, 515, 23);
		add(btnMostrarDetalles);
		
		textPaneDetHot = new JTextPane();
		textPaneDetHot.setEditable(false);
		textPaneDetHot.setBounds(486, 124, 515, 106);
		add(textPaneDetHot);
		
		//FECHAS:
		fechaIda = new JCalendar();
		fechaIda.setBounds(255, 392, 184, 153);
		add(fechaIda);
		
		fechaVuelta = new JCalendar();
		fechaVuelta.setBounds(468, 392, 184, 153);
		add(fechaVuelta);

	}
}

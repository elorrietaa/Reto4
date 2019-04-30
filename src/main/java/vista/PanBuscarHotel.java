
package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Color;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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
		public DefaultListModel<Object> modeloHotel = new DefaultListModel<Object>();//BORRAR
		public JPanel panelOcultarHoteles;
    	public JButton buttonContinuar, btnRegistro, btnInicioSesion;
    	public JComboBox<Object> cBCiudad; 
    	public JLabel labelHotel, labelCiudad, labelFecha;
    	public JCalendar fechaIda, fechaVuelta;
    	
    	public DefaultListModel<Object> modelo = new DefaultListModel<Object>();
    	public JTable tab;
    	public JScrollPane scrollPaneIda;
    	
	public PanBuscarHotel() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0,0,1024,720);
		
		buttonContinuar = new JButton("Continuar");
		buttonContinuar.setBounds(708, 663, 89, 23);
		add(buttonContinuar);
		
		labelCiudad = new JLabel("Seleccione una ciudad :");
		labelCiudad.setFont(new Font("Dialog", Font.BOLD, 20));
		labelCiudad.setBounds(44, 37, 245, 25);
		add(labelCiudad);
		
		cBCiudad = new JComboBox<Object>();
		cBCiudad.setBounds(294, 42, 179, 20);
		add(cBCiudad);
		
		labelFecha = new JLabel("Seleccione su fecha de llegada y su fecha de salida:");
		labelFecha.setFont(new Font("Dialog", Font.BOLD, 20));
		labelFecha.setBounds(44, 365, 645, 43);
		add(labelFecha);
		
		labelHotel = new JLabel("Seleccione un hotel :");
		labelHotel.setBounds(72, 92, 208, 23);
		labelHotel.setFont(new Font("Dialog", Font.BOLD, 19));
		add(labelHotel);
		
		// TABLA HOTELES
				tab = new JTable();
				Object[][] datos = {};
				String[] columnNames = {"Nombre", "Estrellas"};
				tab.setModel(new DefaultTableModel(datos,columnNames) {
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, int.class, String.class, String.class, float.class
					};
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					@Override
				    public boolean isCellEditable(int row, int column) {
				        return false;
				    }
				});
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				
				tab.setDefaultRenderer(String.class, centerRenderer);
				tab.setDefaultRenderer(int.class, centerRenderer);
				tab.setDefaultRenderer(float.class, centerRenderer);
				tab.setFillsViewportHeight(true);
				tab.setBackground(Color.WHITE);
				tab.setBounds(45, 200, 834, 100);
				tab.setRowHeight(50);
				tab.setFocusable(false);
				tab.setRowSelectionAllowed(true);
				tab.getColumnModel().getColumn(0).setPreferredWidth(80);
				tab.getColumnModel().getColumn(1).setPreferredWidth(80);
				
				scrollPaneIda = new JScrollPane(tab);
				scrollPaneIda.setBounds(290,92,399,216);
				add(scrollPaneIda);
		
		//FECHAS:
		fechaIda = new JCalendar();
		fechaIda.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		fechaIda.setBounds(289, 419, 184, 153);
		add(fechaIda);
		
		fechaVuelta = new JCalendar();
		fechaVuelta.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		fechaVuelta.setBounds(505, 419, 184, 153);
		add(fechaVuelta);
		
		btnInicioSesion = new JButton("Inicio Sesi\u00F3n");
		btnInicioSesion.setBounds(869, 42, 105, 23);
		add(btnInicioSesion);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(869, 8, 105, 23);
		add(btnRegistro);

	}
}


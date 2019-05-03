
package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
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
		public JPanel panelOcultarHoteles, panelHotel, panelCasaApart;
    	public JButton buttonContinuar, btnRegistro, btnInicioSesion;
    	public JComboBox<Object> cBCiudad, cBTipoAloj; 
    	public JLabel labelHotel, labelCiudad,lblTipoAloj, labelFecha;
    	public JCalendar fechaIda, fechaVuelta;
    	
    	public DefaultListModel<Object> modelo = new DefaultListModel<Object>();
    	public JTable tab, table;
    	public JScrollPane scrollPaneIda, scrollPaneCasaApart;

    	
    	
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
		
		lblTipoAloj = new JLabel("Seleccione un tipo de alojamiento:");
		lblTipoAloj.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTipoAloj.setBounds(44, 83, 348, 25);
		add(lblTipoAloj);
		
		cBTipoAloj = new JComboBox<Object>();
		cBTipoAloj.setBounds(380, 89, 179, 20);
		add(cBTipoAloj);
		
		labelFecha = new JLabel("Seleccione su fecha de llegada y su fecha de salida:");
		labelFecha.setFont(new Font("Dialog", Font.BOLD, 20));
		labelFecha.setBounds(40, 413, 645, 43);
		add(labelFecha);
		
		labelHotel = new JLabel("Seleccione un alojamiento:");
		labelHotel.setBounds(44, 119, 324, 23);
		labelHotel.setFont(new Font("Dialog", Font.BOLD, 19));
		add(labelHotel);
				Object[][] datos = {};
				String[] columnNames = {"Nombre", "Estrellas"};
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		//FECHAS:
		fechaIda = new JCalendar();
		fechaIda.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		fechaIda.setBounds(314, 457, 184, 153);
		add(fechaIda);
		
		fechaVuelta = new JCalendar();
		fechaVuelta.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		fechaVuelta.setBounds(530, 457, 184, 153);
		add(fechaVuelta);
		
		btnInicioSesion = new JButton("Inicio Sesi\u00F3n");
		btnInicioSesion.setBounds(869, 42, 105, 23);
		add(btnInicioSesion);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(869, 8, 105, 23);
		add(btnRegistro);
		Object[][] datos1 = {};
		String[] columnNames1 = {"Nombre", "desde"};
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment( JLabel.CENTER );
		
		panelHotel = new JPanel();
		panelHotel.setBounds(282, 167, 432, 235);
		add(panelHotel);
		panelHotel.setBackground(Color.WHITE);
		panelHotel.setLayout(null);
		
		// TABLA HOTELES
				tab = new JTable();
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
				
				tab.setDefaultRenderer(String.class, centerRenderer);
				tab.setDefaultRenderer(int.class, centerRenderer);
				tab.setDefaultRenderer(float.class, centerRenderer);
				tab.setFillsViewportHeight(true);
				tab.setBackground(Color.WHITE);
				tab.setBounds(45, 200, 397, 189);
				tab.setRowHeight(50);
				tab.setFocusable(false);
				tab.setRowSelectionAllowed(true);
				tab.getColumnModel().getColumn(0).setPreferredWidth(80);
				tab.getColumnModel().getColumn(1).setPreferredWidth(80);
				
				scrollPaneIda = new JScrollPane(tab);
				scrollPaneIda.setBounds(0, 0, 399, 216);
				panelHotel.add(scrollPaneIda);
				
				panelCasaApart = new JPanel();
				panelCasaApart.setBounds(282, 167, 432, 235);
				add(panelCasaApart);
				panelCasaApart.setBackground(Color.WHITE);
				panelCasaApart.setLayout(null);
				panelCasaApart.setVisible(false);
				panelCasaApart.setEnabled(false);
				
				
				
				
	
				
				// TABLA CASAS o APARTAMENTOS
				table = new JTable();
				add(table);
				table.setModel(new DefaultTableModel(datos1,columnNames1) {
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
				
				table.setDefaultRenderer(String.class, centerRenderer1);
				table.setDefaultRenderer(int.class, centerRenderer1);
				table.setDefaultRenderer(float.class, centerRenderer1);
				table.setFillsViewportHeight(true);
				table.setBackground(Color.WHITE);
				table.setBounds(681, 83, 397, 189);
				table.setRowHeight(50);
				table.setFocusable(false);
				table.setRowSelectionAllowed(true);
				table.getColumnModel().getColumn(0).setPreferredWidth(80);
				table.getColumnModel().getColumn(1).setPreferredWidth(80);
				
				scrollPaneCasaApart = new JScrollPane(table);
				scrollPaneCasaApart.setBounds(0, 0, 399, 216);
				panelCasaApart.add(scrollPaneCasaApart);

	}
}


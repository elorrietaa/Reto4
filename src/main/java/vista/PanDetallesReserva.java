package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 * Clase PanDetallesReserva = contiene los elementos necesarios para formar el Panel en el que se muestran los detalles de la reserva
 * @author alba
 *
 */
public class PanDetallesReserva extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField tFPrecioReserva, textFieldNumNoches;
	public JLabel lblSuReserva, lblDatosAlojamiento,lblDetallesHabitaciones, lblPrecio;
	public JButton btnContinuar, btnAtras;
	public JList<String> listDetalleReserva;
	public JTextPane textPDatosAlo, textPaneDetHot;
	
	
	public DefaultListModel<Object> modelo = new DefaultListModel<Object>();
	public JTable tab, tabHot;
	public JScrollPane scrollPaneIda;

	
	/**
	 * Create the panel.
	 */
	public PanDetallesReserva() {
		setBackground(Color.WHITE);
		setBounds(0,0,1024,720);
		setLayout(null);
		 
		lblSuReserva = new JLabel("DETALLES DE SU RESERVA :");
		lblSuReserva.setForeground(Color.BLACK);
		lblSuReserva.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblSuReserva.setBounds(128, 48, 513, 39);
		add(lblSuReserva);
		
		lblDatosAlojamiento = new JLabel("Detalles de su alojamiento:");
		lblDatosAlojamiento.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblDatosAlojamiento.setBounds(128, 106, 279, 23);
		add(lblDatosAlojamiento);
		
		lblDetallesHabitaciones = new JLabel("Detalles de sus habitaciones:");
		lblDetallesHabitaciones.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblDetallesHabitaciones.setBounds(128, 278, 319, 23);
		add(lblDetallesHabitaciones);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(861, 651, 89, 23);
		add(btnContinuar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(128, 651, 89, 23);
		add(btnAtras);
		
		lblPrecio = new JLabel("Precio TOTAL:");
		lblPrecio.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblPrecio.setBounds(588, 469, 224, 34);
		add(lblPrecio);
		
		tFPrecioReserva = new JTextField();
		tFPrecioReserva.setFont(new Font("Monospaced", Font.BOLD, 25));
		tFPrecioReserva.setEditable(false);
		tFPrecioReserva.setBounds(796, 469, 154, 34);
		add(tFPrecioReserva);
		tFPrecioReserva.setColumns(10);
		
		textPDatosAlo = new JTextPane();
		textPDatosAlo.setEditable(false);
		textPDatosAlo.setBounds(538, 140, 427, 94);
		add(textPDatosAlo);
		
		
		
		
		// TABLA HOTELES
		tabHot = new JTable();
		tabHot.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Object[][] datosHot = {};
		String[] columnNamesHot = {"Nombre", "Estrellas"};
		tabHot.setModel(new DefaultTableModel(datosHot,columnNamesHot) {
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
		
		tabHot.setDefaultRenderer(String.class, centerRenderer);
		tabHot.setDefaultRenderer(int.class, centerRenderer);
		tabHot.setDefaultRenderer(float.class, centerRenderer);
		tabHot.setFillsViewportHeight(true);
		tabHot.setBackground(Color.WHITE);
		tabHot.setBounds(45, 200, 834, 100);
		tabHot.setRowHeight(50);
		tabHot.setFocusable(false);
		tabHot.setRowSelectionAllowed(true);
		tabHot.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabHot.getColumnModel().getColumn(1).setPreferredWidth(80);
		
		scrollPaneIda = new JScrollPane(tabHot);
		scrollPaneIda.setBounds(128,140,399,94);
		add(scrollPaneIda);
		
		
		// TABLA HABITACIONES SELECCIONADAS
		tab = new JTable();
		Object[][] datos = {};
		String[] columnNames = {"Código de la habitación", "Número de camas ", "Tipo de camas", "Precio habitación 1 noche ","Precio total por habitación" };
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
		
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment( JLabel.CENTER );
		
		tab.setDefaultRenderer(String.class, centerRenderer);
		tab.setDefaultRenderer(int.class, centerRenderer);
		tab.setDefaultRenderer(float.class, centerRenderer);
		tab.setFillsViewportHeight(true);
		tab.setBackground(Color.WHITE);
		tab.setBounds(45, 300, 934, 100);
		tab.setRowHeight(50);
		tab.setFocusable(false);
		tab.setRowSelectionAllowed(true);
		tab.getColumnModel().getColumn(0).setPreferredWidth(150);
		tab.getColumnModel().getColumn(1).setPreferredWidth(120);
		tab.getColumnModel().getColumn(2).setPreferredWidth(180);
		tab.getColumnModel().getColumn(3).setPreferredWidth(180);
		tab.getColumnModel().getColumn(4).setPreferredWidth(180);
		
		scrollPaneIda = new JScrollPane(tab);
		scrollPaneIda.setBounds(128,312,839,136);
		add(scrollPaneIda);
		
		JLabel lblNmeroDeNoches = new JLabel("N\u00FAmero de noches: ");
		lblNmeroDeNoches.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblNmeroDeNoches.setBounds(128, 245, 189, 19);
		add(lblNmeroDeNoches);
		
		textFieldNumNoches = new JTextField();
		textFieldNumNoches.setEditable(false);
		textFieldNumNoches.setColumns(10);
		textFieldNumNoches.setBounds(327, 247, 86, 20);
		add(textFieldNumNoches);
		

	}
}

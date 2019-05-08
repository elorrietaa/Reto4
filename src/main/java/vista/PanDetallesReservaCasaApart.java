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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 * Clase PanDetallesReserva = contiene los elementos necesarios para formar el Panel en el que se muestran los detalles de la reserva
 * @author alba
 *
 */
public class PanDetallesReservaCasaApart extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField tFPrecioReserva, textFieldNumNoches, textFieldDetHabs;
	public JLabel lblSuReserva, lblDatosAlojamiento,lblDetallesHabitaciones, lblPrecio;
	public JButton btnContinuar, btnAtras, btnInicioSesion, btnRegistro, btnCancelar;
	public JList<String> listDetalleReserva;
	public JTextPane textPDatosAlo, textPaneDetHot, textDetTarifa, textDetFestivos, textDetPrecioFinal;
	public JPanel panelHoteles, panelCasaApart;
	 
	
	public DefaultListModel<Object> modelo = new DefaultListModel<Object>();
	public JTable table, tab, tab2;
	public JScrollPane scrollPaneIda, scrollPaneCasaApart, scrollPaneIda2;



	
	/**
	 * Create the panel.
	 */
	public PanDetallesReservaCasaApart() {
		setBackground(Color.WHITE);
		setBounds(0,0,1024,720);
		setLayout(null);
		 
		lblSuReserva = new JLabel("DETALLES DE SU RESERVA :");
		lblSuReserva.setForeground(Color.BLACK);
		lblSuReserva.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblSuReserva.setBounds(121, -2, 513, 39);
		add(lblSuReserva);
		
		lblDatosAlojamiento = new JLabel("Detalles de su alojamiento:");
		lblDatosAlojamiento.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblDatosAlojamiento.setBounds(121, 44, 279, 23);
		add(lblDatosAlojamiento);
		
		lblDetallesHabitaciones = new JLabel("Detalles de sus habitaciones:");
		lblDetallesHabitaciones.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblDetallesHabitaciones.setBounds(121, 213, 319, 23);
		add(lblDetallesHabitaciones);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(861, 651, 89, 23);
		add(btnContinuar);
		
		lblPrecio = new JLabel("Precio TOTAL:");
		lblPrecio.setFont(new Font("Monospaced", Font.BOLD, 22));
		lblPrecio.setBounds(609, 613, 182, 34);
		add(lblPrecio);
		
		tFPrecioReserva = new JTextField();
		tFPrecioReserva.setFont(new Font("Monospaced", Font.BOLD, 25));
		tFPrecioReserva.setEditable(false);
		tFPrecioReserva.setBounds(796, 606, 154, 34);
		add(tFPrecioReserva);
		tFPrecioReserva.setColumns(10);
		
		textPDatosAlo = new JTextPane();
		textPDatosAlo.setEditable(false);
		textPDatosAlo.setBounds(563, -2, 279, 74);
		add(textPDatosAlo);
		
		
		
		
		// TABLA DETALLES HOTELES CASAS o APARTAMENTOS
		table = new JTable();
		Object[][] datos1 = {};
		String[] columnNames1 = {"Nombre", "Precio desde", "Detalles"};
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
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
				
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setDefaultRenderer(int.class, centerRenderer);
		table.setDefaultRenderer(float.class, centerRenderer);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.WHITE);
		table.setBounds(681, 83, 397, 189);
		table.setRowHeight(50);
		table.setFocusable(false);
		table.setRowSelectionAllowed(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
				
		scrollPaneCasaApart = new JScrollPane(table);
		scrollPaneCasaApart.setBounds(121,78,839,94);
		add(scrollPaneCasaApart);		
			
		JLabel lblNmeroDeNoches = new JLabel("N\u00FAmero de noches: ");
		lblNmeroDeNoches.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblNmeroDeNoches.setBounds(121, 183, 189, 19);
		add(lblNmeroDeNoches);
		
		textFieldNumNoches = new JTextField();
		textFieldNumNoches.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNumNoches.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumNoches.setEditable(false);
		textFieldNumNoches.setColumns(10);
		textFieldNumNoches.setBounds(300, 183, 46, 20);
		add(textFieldNumNoches);
		
		btnInicioSesion = new JButton("Inicio Sesi\u00F3n");
		btnInicioSesion.setBounds(869, 42, 105, 23);
		add(btnInicioSesion);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(869, 8, 105, 23);
		add(btnRegistro);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(78, 623, 89, 23);
		add(btnAtras);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(78, 657, 89, 23);
		add(btnCancelar);
		
		textDetTarifa = new JTextPane();
		textDetTarifa.setEditable(false);
		textDetTarifa.setBounds(121, 456, 563, 53);
		add(textDetTarifa);
		
		textDetFestivos = new JTextPane();
		textDetFestivos.setEditable(false);
		textDetFestivos.setBounds(121, 505, 563, 34);
		add(textDetFestivos);
		
		panelHoteles = new JPanel();
		panelHoteles.setBackground(Color.WHITE);
		panelHoteles.setBounds(121, 309, 839, 136);
		add(panelHoteles);
		panelHoteles.setLayout(null);
		
		Object[][] datos = {};
		String[] columnNames = {"Código habitación", "Habitación", "Número de camas ", "Tipo de camas", "Precio habitación 1 noche " };
		
		// TABLA HABITACION HOTEL SELECCIONADA
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
		tab.setBounds(45, 300, 934, 100);
		tab.setRowHeight(50);
		tab.setFocusable(false);
		tab.setRowSelectionAllowed(true);
		tab.getColumnModel().getColumn(0).setPreferredWidth(60);
		tab.getColumnModel().getColumn(1).setPreferredWidth(140);
		tab.getColumnModel().getColumn(2).setPreferredWidth(60);
		tab.getColumnModel().getColumn(3).setPreferredWidth(180);
		tab.getColumnModel().getColumn(4).setPreferredWidth(100);
						
		scrollPaneIda = new JScrollPane(tab);
		scrollPaneIda.setBounds(0, 0, 839, 136);
		panelHoteles.add(scrollPaneIda);

		
		panelCasaApart = new JPanel();
		panelCasaApart.setBackground(Color.WHITE);
		panelCasaApart.setBounds(121, 309, 839, 136);
		add(panelCasaApart);
		panelCasaApart.setLayout(null);
		panelCasaApart.setVisible(false);
		panelCasaApart.setEnabled(false);
		
		Object[][] datos2 = {};
		String[] columnNames2 = {"Tipo de habitacion", "Número de camas", "Tipo de camas"};
		
		// TABLA DORMITORIOS SELECCIONADAS
		tab2 = new JTable();
		tab2.setModel(new DefaultTableModel(datos2,columnNames2) {
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
						
		tab2.setDefaultRenderer(String.class, centerRenderer);
		tab2.setDefaultRenderer(int.class, centerRenderer);
		tab2.setDefaultRenderer(float.class, centerRenderer);
		tab2.setFillsViewportHeight(true);
		tab2.setBackground(Color.WHITE);
		tab2.setBounds(45, 300, 934, 100);
		tab2.setRowHeight(50);
		tab2.setFocusable(false);
		tab2.setRowSelectionAllowed(true);
		tab2.getColumnModel().getColumn(0).setPreferredWidth(60);
		tab2.getColumnModel().getColumn(1).setPreferredWidth(140);
		tab2.getColumnModel().getColumn(2).setPreferredWidth(60);
						
		scrollPaneIda2 = new JScrollPane(tab2);
		scrollPaneIda2.setBounds(0, 0, 839, 136);
		panelCasaApart.add(scrollPaneIda2);
		
		textFieldDetHabs = new JTextField();
		textFieldDetHabs.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDetHabs.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldDetHabs.setEditable(false);
		textFieldDetHabs.setColumns(10);
		textFieldDetHabs.setBounds(121, 253, 703, 34);
		add(textFieldDetHabs);
		
		textDetPrecioFinal = new JTextPane();
		textDetPrecioFinal.setEditable(false);
		textDetPrecioFinal.setBounds(121, 550, 563, 39);
		add(textDetPrecioFinal);

	}
}
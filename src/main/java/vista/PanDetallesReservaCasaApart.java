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
	public JTextField tFPrecioReserva, textFieldNumNoches;
	public JLabel lblSuReserva, lblDatosAlojamiento,lblDetallesHabitaciones, lblPrecio;
	public JButton btnContinuar, btnAtras, btnInicioSesion, btnRegistro, btnCancelar;
	public JList<String> listDetalleReserva;
	public JTextPane textPDatosAlo, textPaneDetHot, textDetTarifa, textDetDestinos;
	
	
	public DefaultListModel<Object> modelo = new DefaultListModel<Object>();
	public JTable table, tab, tab2;
	public JScrollPane scrollPaneIda, scrollPaneCasaApart;

	
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
				DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
				centerRenderer1.setHorizontalAlignment( JLabel.CENTER );
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
				table.getColumnModel().getColumn(0).setPreferredWidth(10);
				table.getColumnModel().getColumn(1).setPreferredWidth(10);
				table.getColumnModel().getColumn(2).setPreferredWidth(250);
				
				scrollPaneCasaApart = new JScrollPane(table);
				scrollPaneCasaApart.setBounds(121,78,839,94);
				add(scrollPaneCasaApart);

				// TABLA DORMITORIOS SELECCIONADAS
				tab = new JTable();
				Object[][] datos = {};
				String[] columnNames = {"C�digo habitaci�n", "Habitaci�n", "N�mero de camas ", "Tipo de camas", "Precio habitaci�n 1 noche " };
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
				
				DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
				centerRenderer2.setHorizontalAlignment( JLabel.CENTER );
				
				tab.setDefaultRenderer(String.class, centerRenderer2);
				tab.setDefaultRenderer(int.class, centerRenderer2);
				tab.setDefaultRenderer(float.class, centerRenderer2);
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
				scrollPaneIda.setBounds(128,309,839,136);
				add(scrollPaneIda);
		
		
				
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
		textDetTarifa.setBounds(128, 456, 563, 151);
		add(textDetTarifa);
		
		textDetDestinos = new JTextPane();
		textDetDestinos.setEditable(false);
		textDetDestinos.setBounds(128, 523, 563, 39);
		add(textDetDestinos);


	}
}

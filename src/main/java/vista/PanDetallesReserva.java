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
	public JTable tab;
	public JScrollPane scrollPaneIda;

	
	/**
	 * Create the panel.
	 */
	public PanDetallesReserva() {
		setBounds(0,0,1024,720);
		setLayout(null);
		 
		lblSuReserva = new JLabel("Su Reserva :");
		lblSuReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSuReserva.setBounds(288, 32, 84, 14);
		add(lblSuReserva);
		
		lblDatosAlojamiento = new JLabel("Detalles Alojamiento:");
		lblDatosAlojamiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDatosAlojamiento.setBounds(141, 132, 154, 14);
		add(lblDatosAlojamiento);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(673, 651, 89, 23);
		add(btnContinuar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(41, 651, 89, 23);
		add(btnAtras);
		
		lblPrecio = new JLabel("Precio TOTAL :");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(640, 509, 122, 19);
		add(lblPrecio);
		
		tFPrecioReserva = new JTextField();
		tFPrecioReserva.setEditable(false);
		tFPrecioReserva.setBounds(789, 510, 86, 20);
		add(tFPrecioReserva);
		tFPrecioReserva.setColumns(10);
		
		textPDatosAlo = new JTextPane();
		textPDatosAlo.setEditable(false);
		textPDatosAlo.setBounds(305, 132, 486, 159);
		add(textPDatosAlo);
		
		lblDetallesHabitaciones = new JLabel("Detalles habitaciones:");
		lblDetallesHabitaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDetallesHabitaciones.setBounds(141, 302, 154, 14);
		add(lblDetallesHabitaciones);
		
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
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
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
		scrollPaneIda.setBounds(141,327,839,136);
		add(scrollPaneIda);
		
		JLabel lblNmeroDeNoches = new JLabel("N\u00FAmero de noches: ");
		lblNmeroDeNoches.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmeroDeNoches.setBounds(141, 509, 154, 19);
		add(lblNmeroDeNoches);
		
		textFieldNumNoches = new JTextField();
		textFieldNumNoches.setEditable(false);
		textFieldNumNoches.setColumns(10);
		textFieldNumNoches.setBounds(298, 510, 86, 20);
		add(textFieldNumNoches);
		

	}
}

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
 * Clase PanDetallesReserva = contiene los elementos necesarios para formar el
 * Panel en el que se muestran los detalles de la reserva
 * 
 * @author alba
 *
 */
public class PanDetallesReserva extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public JTextField tFPrecioReserva, textFieldNumNoches;
    public JLabel lblSuReserva, lblDatosAlojamiento, lblDetallesHabitaciones, lblPrecio;
    public JButton btnContinuar, btnAtras, btnInicioSesion, btnRegistro, btnCancelar, btnCerrarSesion;
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
	setBounds(0, 0, 1024, 720);
	setLayout(null);

	lblSuReserva = new JLabel("DETALLES DE SU RESERVA :");
	lblSuReserva.setForeground(Color.BLACK);
	lblSuReserva.setFont(new Font("Monospaced", Font.BOLD, 30));
	lblSuReserva.setBounds(23, 27, 513, 39);
	add(lblSuReserva);

	lblDatosAlojamiento = new JLabel("Detalles de su alojamiento:");
	lblDatosAlojamiento.setFont(new Font("Monospaced", Font.BOLD, 16));
	lblDatosAlojamiento.setBounds(23, 77, 279, 23);
	add(lblDatosAlojamiento);

	lblDetallesHabitaciones = new JLabel("Detalles de sus habitaciones:");
	lblDetallesHabitaciones.setFont(new Font("Monospaced", Font.BOLD, 16));
	lblDetallesHabitaciones.setBounds(23, 275, 319, 23);
	add(lblDetallesHabitaciones);

	btnContinuar = new JButton("Continuar");
	btnContinuar.setBounds(861, 651, 89, 23);
	add(btnContinuar);

	lblPrecio = new JLabel("Precio TOTAL:");
	lblPrecio.setFont(new Font("Monospaced", Font.BOLD, 25));
	lblPrecio.setBounds(598, 573, 204, 34);
	add(lblPrecio);

	tFPrecioReserva = new JTextField();
	tFPrecioReserva.setFont(new Font("Monospaced", Font.BOLD, 25));
	tFPrecioReserva.setEditable(false);
	tFPrecioReserva.setBounds(822, 573, 128, 34);
	add(tFPrecioReserva);
	tFPrecioReserva.setColumns(10);

	textPDatosAlo = new JTextPane();
	textPDatosAlo.setEditable(false);
	textPDatosAlo.setBounds(483, 8, 319, 94);
	add(textPDatosAlo);

	// TABLA HOTELES
	tabHot = new JTable();
	tabHot.setFont(new Font("Tahoma", Font.PLAIN, 11));
	Object[][] datosHot = {};
	String[] columnNamesHot = { "Nombre", "Precio desde", "Estrellas", "Detalles" };
	tabHot.setModel(new DefaultTableModel(datosHot, columnNamesHot) {
	    private static final long serialVersionUID = 1L;
	    @SuppressWarnings("rawtypes")
	    Class[] columnTypes = new Class[] { String.class, String.class, String.class, int.class, String.class,
		    String.class, float.class };

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
	centerRenderer.setHorizontalAlignment(JLabel.CENTER);

	tabHot.setDefaultRenderer(String.class, centerRenderer);
	tabHot.setDefaultRenderer(int.class, centerRenderer);
	tabHot.setDefaultRenderer(float.class, centerRenderer);
	tabHot.setFillsViewportHeight(true);
	tabHot.setBackground(Color.WHITE);
	tabHot.setBounds(45, 200, 834, 100);
	tabHot.setRowHeight(50);
	tabHot.setFocusable(false);
	tabHot.setRowSelectionAllowed(true);
	tabHot.getColumnModel().getColumn(0).setPreferredWidth(200);
	tabHot.getColumnModel().getColumn(1).setPreferredWidth(150);
	tabHot.getColumnModel().getColumn(2).setPreferredWidth(-20);
	tabHot.getColumnModel().getColumn(3).setPreferredWidth(400);

	scrollPaneIda = new JScrollPane(tabHot);
	scrollPaneIda.setBounds(23, 111, 942, 75);
	add(scrollPaneIda);

	// TABLA HABITACIONES SELECCIONADAS
	tab = new JTable();
	Object[][] datos = {};
	String[] columnNames = { "Código habitación", "Habitación", "Número de camas ", "Tipo de camas",
		"Precio habitación 1 noche ", "Precio total por habitación" };
	tab.setModel(new DefaultTableModel(datos, columnNames) {
	    private static final long serialVersionUID = 1L;
	    @SuppressWarnings("rawtypes")
	    Class[] columnTypes = new Class[] { String.class, String.class, String.class, int.class, String.class,
		    String.class, float.class };

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
	centerRenderer1.setHorizontalAlignment(JLabel.CENTER);

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
	tab.getColumnModel().getColumn(5).setPreferredWidth(100);

	scrollPaneIda = new JScrollPane(tab);
	scrollPaneIda.setBounds(23, 309, 942, 216);
	add(scrollPaneIda);

	JLabel lblNmeroDeNoches = new JLabel("N\u00FAmero de noches: ");
	lblNmeroDeNoches.setFont(new Font("Monospaced", Font.BOLD, 16));
	lblNmeroDeNoches.setBounds(23, 232, 189, 19);
	add(lblNmeroDeNoches);

	textFieldNumNoches = new JTextField();
	textFieldNumNoches.setFont(new Font("Tahoma", Font.PLAIN, 11));
	textFieldNumNoches.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldNumNoches.setEditable(false);
	textFieldNumNoches.setColumns(10);
	textFieldNumNoches.setBounds(222, 233, 46, 20);
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

	btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
	btnCerrarSesion.setBounds(870, 26, 121, 23);
	add(btnCerrarSesion);
	btnCerrarSesion.setVisible(false);
	btnCerrarSesion.setEnabled(false);

    }
}

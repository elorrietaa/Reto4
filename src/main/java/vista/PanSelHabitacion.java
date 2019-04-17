package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.ImageIcon;

public class PanSelHabitacion extends JPanel {

	private static final long serialVersionUID = 1L;
	public DefaultListModel<Object> modelo = new DefaultListModel<Object>();
	public JButton btnLogin,btnRegistro,btnContinuar,btnAtras,btnCancelar;
	public JLabel lblIcono, lblTitulo, lblBilleteIda;
	public JTable tab;
	public JScrollPane scrollPaneIda;
	public JList<Object> listHabitacion;

	public PanSelHabitacion() {
		
		// configuracion del panel
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1024, 720);
		setBorder(UIManager.getBorder("Button.border"));
		setLayout(null);
		
		// logo
		lblIcono = new JLabel("");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		lblTitulo = new JLabel("DETALLES DE BILLETE");
		FormatoDiseno.formatoIcono(lblTitulo);
		add(lblTitulo);		
		
		// label billete ida
		lblBilleteIda = new JLabel("Seleccione una o varias habitaciones");
		lblBilleteIda.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblBilleteIda.setHorizontalAlignment(SwingConstants.LEFT);
		lblBilleteIda.setBounds(45, 60, 505, 40);
		add(lblBilleteIda);
		
		// TABLA HABITACIONES
		tab = new JTable();
		Object[][] datos = {};
		String[] columnNames = {"Código de la habitación", "Número de camas ", "Tipo de camas", "Capacidad", "Precio por habitación"};
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
		tab.getColumnModel().getColumn(0).setPreferredWidth(180);
		tab.getColumnModel().getColumn(1).setPreferredWidth(180);
		tab.getColumnModel().getColumn(2).setPreferredWidth(180);
		tab.getColumnModel().getColumn(3).setPreferredWidth(120);
		tab.getColumnModel().getColumn(4).setPreferredWidth(150);
		
		scrollPaneIda = new JScrollPane(tab);
		scrollPaneIda.setBounds(45,111,935,221);
		add(scrollPaneIda);
		//Object[][] datosVuelta = {};
		
		/*
		 * Botones
		 */
		/*
		btnLogin = new JButton("Inicio Sesi\u00F3n");
		FormatoDiseno.formatoBtnLogin(btnLogin);
		add(btnLogin);
		
		btnRegistro = new JButton("Registro");
		FormatoDiseno.formatoBtnRegistro(btnRegistro);
		add(btnRegistro);
		
		btnCancelar = new JButton("Cancelar");
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar);
		*/
		
		btnAtras = new JButton("Atr\u00E1s");
		FormatoDiseno.formatoBtnAtras(btnAtras);
		add(btnAtras);
		
		
		
		btnContinuar = new JButton("Continuar");
		FormatoDiseno.formatoBtnContinuar(btnContinuar);
		add(btnContinuar);
		
		listHabitacion = new JList<Object>();
		listHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		listHabitacion.setBackground(Color.LIGHT_GRAY);
		FormatoDiseno.formatoList(listHabitacion);
		listHabitacion.setBounds(45, 357, 212, 239);
		add(listHabitacion);
	
	}
}

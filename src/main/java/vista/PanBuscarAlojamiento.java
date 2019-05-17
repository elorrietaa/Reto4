
package vista;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
/**
 * Clase PanBuscarHotel: contiene los elementos necesarios para formar el Panel en el que se realiza la búsqueda del alojamiento
 * @author alba
 *
 */
public class PanBuscarAlojamiento extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	/**
	 * Create the panel.
	 */
		public DefaultListModel<Object> modeloHotel = new DefaultListModel<Object>();//BORRAR
		public JPanel panelOcultarHoteles, panelHotel, panelCasaApart, panelServicios;
    	public JButton buttonContinuar,btnAplicarFiltros, btnRegistro, btnInicioSesion, btnCancelar, btnCerrarSesion, btnServicios, btnContratar, btnCancelarSer, btnActualizar;
    	public JComboBox<Object> cBCiudad, cBTipoAloj, cbOrdenar, cBAscDesc; 
    	public JLabel labelHotel, labelCiudad,lblTipoAloj, labelFecha, labelServicios;
    	public JCalendar fechaIda, fechaVuelta;
    	public JCheckBox chckbxWifiSel, chckbxAireSel, chckbxPiscinaSel, chckbxSpaSel, chckbxGimSel, chckbxParkingsel, chckbxRestSel, chckbxBarSel;
    	public JCheckBox checkWifi, checkSpa, checkAire, checkPiscina, checkGimnasio, checkParking;
    	
    	public DefaultListModel<Object> modelo = new DefaultListModel<Object>();
    	public JTable tab, table;
    	public JScrollPane scrollPaneIda, scrollPaneCasaApart;
    	public Date min1;
    
  	
    	
	public PanBuscarAlojamiento() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0,0,1024,720);
		
		buttonContinuar = new JButton("Continuar");
		buttonContinuar.setBounds(708, 663, 89, 23);
		FormatoDiseno.formatoBtn(buttonContinuar);
		add(buttonContinuar);
		
		labelCiudad = new JLabel("Seleccione una ciudad :");
		labelCiudad.setFont(new Font("Dialog", Font.BOLD, 18));
		labelCiudad.setBounds(10, 8, 245, 25);
		add(labelCiudad);
		
		cBCiudad = new JComboBox<Object>();
		cBCiudad.setBounds(228, 13, 179, 20);
		add(cBCiudad);
		
		lblTipoAloj = new JLabel("Seleccione un tipo de alojamiento:");
		lblTipoAloj.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTipoAloj.setBounds(10, 44, 348, 25);
		add(lblTipoAloj);
		
		cBTipoAloj = new JComboBox<Object>();
		cBTipoAloj.setBounds(323, 44, 179, 20);
		add(cBTipoAloj);
		
		labelFecha = new JLabel("Seleccione su fecha de llegada y su fecha de salida:");
		labelFecha.setFont(new Font("Dialog", Font.BOLD, 18));
		labelFecha.setBounds(44, 440, 465, 43);
		add(labelFecha);
		
		labelHotel = new JLabel("Seleccione un alojamiento:");
		labelHotel.setBounds(10, 137, 324, 23);
		labelHotel.setFont(new Font("Dialog", Font.BOLD, 18));
		add(labelHotel);
				Object[][] datos = {};
				String[] columnNames = {"Nombre", "Precio desde", "Estrellas", "Detalles"};
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		//FECHAS:
		min1 = new Date();		
		fechaIda = new JCalendar();
		fechaIda.getDayChooser();
		fechaIda.getMonthChooser();
		fechaIda.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		fechaIda.setBounds(69, 484, 184, 153);
		fechaIda.setMinSelectableDate(min1);
		add(fechaIda);
		
		fechaVuelta = new JCalendar();
		fechaVuelta.getDayChooser();
		fechaVuelta.getMonthChooser();
		fechaVuelta.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		fechaVuelta.setBounds(289, 484, 184, 153);
		fechaVuelta.setMinSelectableDate(min1);
		add(fechaVuelta);
		
		btnInicioSesion = new JButton("Inicio Sesi\u00F3n");
		btnInicioSesion.setBounds(870, 8, 121, 23);
		FormatoDiseno.formatoBtn(btnInicioSesion);
		add(btnInicioSesion);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(771, 8, 89, 23);
		FormatoDiseno.formatoBtn(btnRegistro);
		add(btnRegistro);
		Object[][] datos1 = {};
		String[] columnNames1 = {"Nombre", "Precio desde", "Detalles"};
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment( JLabel.CENTER );
		
		panelHotel = new JPanel();
		panelHotel.setBounds(-23, 152, 1047, 250);
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
				tab.getColumnModel().getColumn(0).setPreferredWidth(200);
				tab.getColumnModel().getColumn(1).setPreferredWidth(150);
				tab.getColumnModel().getColumn(2).setPreferredWidth(-20);
				tab.getColumnModel().getColumn(3).setPreferredWidth(400);
				
				
				scrollPaneIda = new JScrollPane(tab);
				scrollPaneIda.setBounds(35, 11, 984, 216);
				panelHotel.add(scrollPaneIda);
				
				panelCasaApart = new JPanel();
				panelCasaApart.setBounds(10, 161, 1034, 241);
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
				table.getColumnModel().getColumn(0).setPreferredWidth(10);
				table.getColumnModel().getColumn(1).setPreferredWidth(10);
				table.getColumnModel().getColumn(2).setPreferredWidth(250);
				
				scrollPaneCasaApart = new JScrollPane(table);
				scrollPaneCasaApart.setBounds(0, 0, 942, 216);
				panelCasaApart.add(scrollPaneCasaApart);
				
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(44, 663, 89, 23);
				FormatoDiseno.formatoBtn(btnCancelar);
				add(btnCancelar);
				
				btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
				btnCerrarSesion.setBounds(870, 26, 121, 23);
				FormatoDiseno.formatoBtn(btnCerrarSesion);
				add(btnCerrarSesion);
				btnCerrarSesion.setVisible(false);
				btnCerrarSesion.setEnabled(false);
				
				btnServicios = new JButton("Contratar servicios adicionales");
				btnServicios.setBounds(612, 553, 275, 23);
				FormatoDiseno.formatoBtn(btnServicios);
				add(btnServicios);
				
				panelServicios = new JPanel();
				panelServicios.setBackground(Color.WHITE);
				panelServicios.setBounds(506, 484, 485, 153);
				add(panelServicios);
				panelServicios.setLayout(null);
				panelServicios.setVisible(false);
				
				btnContratar = new JButton("Contratar");
				btnContratar.setBounds(386, 119, 89, 23);
				FormatoDiseno.formatoBtn(btnContratar);
				panelServicios.add(btnContratar);
				
				btnCancelarSer = new JButton(" Cancelar ");
				btnCancelarSer.setBounds(10, 119, 110, 23);
				FormatoDiseno.formatoBtn(btnCancelarSer);
				panelServicios.add(btnCancelarSer);
				
				checkWifi = new JCheckBox("WiFi");
				checkWifi.setBackground(Color.WHITE);
				checkWifi.setBounds(96, 19, 179, 23);
				panelServicios.add(checkWifi);
				
				checkSpa = new JCheckBox("Spa");
				checkSpa.setBackground(Color.WHITE);
				checkSpa.setBounds(277, 19, 97, 23);
				panelServicios.add(checkSpa);
				
				checkAire = new JCheckBox("Aire Acondicionado");
				checkAire.setBackground(Color.WHITE);
				checkAire.setBounds(96, 45, 179, 23);
				panelServicios.add(checkAire);
				
				checkPiscina = new JCheckBox("Piscina");
				checkPiscina.setBackground(Color.WHITE);
				checkPiscina.setBounds(96, 71, 97, 23);
				panelServicios.add(checkPiscina);
				
				checkGimnasio = new JCheckBox("Gimnasio");
				checkGimnasio.setBackground(Color.WHITE);
				checkGimnasio.setBounds(277, 45, 97, 23);
				panelServicios.add(checkGimnasio);
				
				checkParking = new JCheckBox("Parking");
				checkParking.setBackground(Color.WHITE);
				checkParking.setBounds(277, 71, 97, 23);
				panelServicios.add(checkParking);
				
				labelServicios = new JLabel("Servicios contratados correctamente");
				labelServicios.setHorizontalAlignment(SwingConstants.CENTER);
				labelServicios.setBounds(141, 123, 215, 14);
				panelServicios.add(labelServicios);
				labelServicios.setVisible(false);
				
				btnActualizar = new JButton("Actualizar servicios");
				btnActualizar.setBounds(632, 453, 215, 23);
				FormatoDiseno.formatoBtn(btnActualizar);
				add(btnActualizar);
				btnActualizar.setVisible(false);
				btnActualizar.setEnabled(false);
				
				JLabel lblOrdenarPor = new JLabel("Ordenar por:");
				lblOrdenarPor.setFont(new Font("Dialog", Font.BOLD, 18));
				lblOrdenarPor.setBounds(10, 75, 348, 25);
				add(lblOrdenarPor);
				
				JLabel lblFiltrarPor = new JLabel("Filtrar por:");
				lblFiltrarPor.setFont(new Font("Dialog", Font.BOLD, 18));
				lblFiltrarPor.setBounds(10, 105, 348, 25);
				add(lblFiltrarPor);
				
				cbOrdenar = new JComboBox<Object>();
				cbOrdenar.setBounds(129, 75, 179, 20);
				add(cbOrdenar);
				
				cBAscDesc = new JComboBox<Object>();
				cBAscDesc.setBounds(323, 75, 179, 20);
				add(cBAscDesc);
				
				chckbxWifiSel = new JCheckBox("Wifi");
				chckbxWifiSel.setBackground(Color.WHITE);
				chckbxWifiSel.setBounds(103, 107, 49, 23);
				add(chckbxWifiSel);
				
				chckbxAireSel = new JCheckBox("Aire acondicionado");
				chckbxAireSel.setBackground(Color.WHITE);
				chckbxAireSel.setBounds(151, 107, 139, 23);
				add(chckbxAireSel);
				
				chckbxPiscinaSel = new JCheckBox("Piscina");
				chckbxPiscinaSel.setBackground(Color.WHITE);
				chckbxPiscinaSel.setBounds(289, 107, 76, 23);
				add(chckbxPiscinaSel);
				
				chckbxSpaSel = new JCheckBox("Spa");
				chckbxSpaSel.setBackground(Color.WHITE);
				chckbxSpaSel.setBounds(367, 109, 56, 23);
				add(chckbxSpaSel);
				
				chckbxGimSel = new JCheckBox("Gimnasio");
				chckbxGimSel.setBackground(Color.WHITE);
				chckbxGimSel.setBounds(425, 109, 84, 23);
				add(chckbxGimSel);
				
				chckbxParkingsel = new JCheckBox("Parking");
				chckbxParkingsel.setBackground(Color.WHITE);
				chckbxParkingsel.setBounds(517, 109, 73, 23);
				add(chckbxParkingsel);
				
				chckbxRestSel = new JCheckBox("Restaurante");
				chckbxRestSel.setBackground(Color.WHITE);
				chckbxRestSel.setBounds(592, 109, 106, 23);
				add(chckbxRestSel);
				
				chckbxBarSel = new JCheckBox("Bar");
				chckbxBarSel.setBackground(Color.WHITE);
				chckbxBarSel.setBounds(700, 109, 56, 23);
				add(chckbxBarSel);
				
				btnAplicarFiltros  = new JButton("Aplicar filtros");
				btnAplicarFiltros.setBounds(762, 109, 125, 23);
				FormatoDiseno.formatoBtn(btnAplicarFiltros);
				add(btnAplicarFiltros);
	}
}


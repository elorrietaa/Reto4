package controlador;

import bbdd.Conexion;
import modelo.FechasTarifas;
import modelo.PrincipalModelo;
import vista.JframePrincipal;

/**
 * Clase PrincipalControlador:
 * Contiene las instancias de todas las clases del paquete controlador. 
 * @author alba
 *
 */
public class PrincipalControlador {
    public PrincipalModelo modelo;
    public JframePrincipal vista;
    public Conexion conexion;
    
    private ControladorJframe controladorJframe;
    private ControladorPanBienvenida controladorPanBienvenida;
    public ControladorPanBuscarAlojamiento controladorPanBuscarHotel;
    private ControladorPanSelHabitacion controladorPanSelHabitacion;
    private ControladorPanDetallesReserva controladorPanDetallesReserva;
    private ContrPanDetReserCasaApart contrPanDetReserCasaApart;
    private ControladorPanPago controladorPanPago; 
    private ControladorPanVueltas controladorPanVueltas;
    private ControladorLogin controladorLogin;
    private ControladorRegistro controladorRegistro;
    public FuncionesPago funcionesPago;
    public FuncionesRegistro funcionesRegistro;
    public FuncionesReserva funcionesReserva;
    public FuncionesValidaciones funcionesValidaciones;
    public FechasTarifas fechasTarifas;
    public FuncionesBotones funcionesBotones;
    
    /**
     * Constructor del PrincipalControlador
     * @param modelo
     * @param vista
     */
    public PrincipalControlador(PrincipalModelo modelo, JframePrincipal vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.conexion = new Conexion();
		this.funcionesPago = new FuncionesPago(modelo);
		this.funcionesRegistro = new FuncionesRegistro(modelo, this, vista);
		this.funcionesReserva = new FuncionesReserva(modelo,vista,this);
		this.funcionesValidaciones = new FuncionesValidaciones(modelo,vista,this);
		this.fechasTarifas = new FechasTarifas(modelo,vista,this);
		this.funcionesBotones = new FuncionesBotones(modelo, vista, this);
    }
    /**
	 * Esta funcion se encarga de inicializar la interfaz
	 */
    public void inicializarVista() {
    	vista.setVisible(true);
    	vista.buscarAlojamiento.setVisible(true);
    	vista.selHabitacion.setVisible(false);
    	vista.detallesReserva.setVisible(false);
    	vista.detallesReservaCasaApart.setVisible(false);
    	vista.pago.setVisible(false);
    	vista.vueltas.setVisible(false);
    	vista.login.setVisible(false);
    	vista.registro.setVisible(false);
    }
    /**
	 * Esta funcion de encarga de inicializar los botones
	 */
    public void inicializarListeners() {
    	// añadimos un listener para comprobar el cierre de la aplicacion en el Jframe principal
    	this.controladorJframe = new ControladorJframe(vista);
    	this.controladorJframe.addListeners();
    	
    	// añadimos listeners a los botones del panel bienvenida
    	this.controladorPanBienvenida = new ControladorPanBienvenida(vista, this);
    	this.controladorPanBienvenida.addListeners();
    	
    	// añadimos listeners a los botones del panel 'controladorPanBuscarHotel'
    	this.controladorPanBuscarHotel = new ControladorPanBuscarAlojamiento(vista, modelo, conexion, this);
    	this.controladorPanBuscarHotel.addListeners();
    	
    	// añadimos listeners a los botones del panel 'controladorPanSelHabitacion;'
    	this.controladorPanSelHabitacion = new ControladorPanSelHabitacion(vista, modelo, conexion, this);
    	this.controladorPanSelHabitacion.addListeners();
    	
    	// añadimos listeners a los botones del panel 'controladorPanDetallesReserva'
    	this.controladorPanDetallesReserva = new ControladorPanDetallesReserva(vista, modelo, this);
    	this.controladorPanDetallesReserva.addListeners();
    	
    	// añadimos listeners a los botones del panel 'contrPanDetReserCasaApart'
    	this.contrPanDetReserCasaApart = new ContrPanDetReserCasaApart(vista, modelo, this);
    	this.contrPanDetReserCasaApart.addListeners();
    	
    	
    	// añadimos listeners a los botones del panel 'controladorPanPago'
    	this.controladorPanPago = new ControladorPanPago(vista, modelo, this);
    	this.controladorPanPago.addListeners();
    	
    	// añadimos listeners a los botones del panel 'controladorPanVueltas'
    	this.controladorPanVueltas = new ControladorPanVueltas(vista, modelo, this, controladorPanPago);
    	this.controladorPanVueltas.addListeners();
    	
    	// añadimos listeners a los botones del panel de log in
    	this.controladorLogin = new ControladorLogin(vista, modelo, this);
    	this.controladorLogin.addListeners();
    	
    	// añadimos listeners a los botones del panel de registro
    	this.controladorRegistro = new ControladorRegistro(vista, modelo, this);
    	this.controladorRegistro.addListeners();
    }
}
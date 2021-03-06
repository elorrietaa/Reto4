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
    public ControladorPanBuscarAlojamiento controladorPanBuscarAlojamiento;
    private ControladorPanSelHabitacion controladorPanSelHabitacion;
    private ControladorPanDetallesReserva controladorPanDetallesReserva;
    private ContrPanDetReservaAloj contrPanDetReserCasaApart;
    public ControladorPanPersonasAloj controladorPanPersonasAloj;
    private ControladorPanPago controladorPanPago; 
    private ControladorPanVueltas controladorPanVueltas;
    private ControladorLogin controladorLogin;
    private ControladorRegistro controladorRegistro;
    private ControladorPanBases controladorBases;
    private ControladorPanCuponDesc controladorCupon;
    private ControladorPanServiciosAdicionales controladorServicios;
    
    public FuncionesPago funcionesPago;
    public FuncionesRegistro funcionesRegistro;
    public FuncionesReserva funcionesReserva;
    public FuncionesValidaciones funcionesValidaciones;
    public FuncionesOrdenar funcionesOrdenar;
    public FuncionesServicios funcionesServicios;
    
    public FuncionesBasesLegales funcionesBasesLegales;
    public FuncionesCodigosPromo funcionesCodigosPromo;
    public FuncionesPersonasAlojadas funcionesPersonasAlojadas;
    
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
		this.funcionesOrdenar = new FuncionesOrdenar(modelo, vista, this);
		this.funcionesBasesLegales = new FuncionesBasesLegales(modelo, vista, this);
		this.funcionesCodigosPromo = new FuncionesCodigosPromo(modelo, vista, this);
		this.funcionesPersonasAlojadas = new FuncionesPersonasAlojadas(modelo, vista, this);
		this.funcionesServicios = new FuncionesServicios(modelo, vista, this);
		
    }
    /**
	 * Esta funcion se encarga de inicializar la interfaz
	 */
    public void inicializarVista() {
    	vista.setVisible(true);
    	vista.bienvenida.setVisible(true);
    	vista.buscarAlojamiento.setVisible(false);
    	vista.selHabitacion.setVisible(false);
    	vista.detallesReserva.setVisible(false);
    	vista.detallesReservaCasaApart.setVisible(false);
    	vista.panPersonasAlojadas.setVisible(false);
    	vista.pago.setVisible(false);
    	vista.vueltas.setVisible(false);
    	vista.login.setVisible(false);
    	vista.registro.setVisible(false);
    	vista.bases.setVisible(false);
    	vista.cupon.setVisible(false);
    }
    /**
	 * Esta funcion de encarga de inicializar los botones
	 */
    public void inicializarListeners() {
    	// a�adimos un listener para comprobar el cierre de la aplicacion en el Jframe principal
    	this.controladorJframe = new ControladorJframe(vista);
    	this.controladorJframe.addListeners();
    	
    	// a�adimos listeners a los botones del panel bienvenida
    	this.controladorPanBienvenida = new ControladorPanBienvenida(vista, this);
    	this.controladorPanBienvenida.addListeners();
    	
    	// a�adimos listeners a los botones del panel 'controladorPanBuscarHotel'
    	this.controladorPanBuscarAlojamiento = new ControladorPanBuscarAlojamiento(vista, modelo, conexion, this);
    	this.controladorPanBuscarAlojamiento.addListeners();
    	
    	// a�adimos listeners a los botones del panel 'controladorPanSelHabitacion;'
    	this.controladorPanSelHabitacion = new ControladorPanSelHabitacion(vista, modelo, conexion, this);
    	this.controladorPanSelHabitacion.addListeners();
    	
    	// a�adimos listeners a los botones del panel 'controladorPanDetallesReserva'
    	this.controladorPanDetallesReserva = new ControladorPanDetallesReserva(vista, modelo, this);
    	this.controladorPanDetallesReserva.addListeners();
    	
    	// a�adimos listeners a los botones del panel 'contrPanDetReserCasaApart'
    	this.contrPanDetReserCasaApart = new ContrPanDetReservaAloj(vista, modelo, this);
    	this.contrPanDetReserCasaApart.addListeners();
    	
    	// a�adimos listeners a los botones del panel 'ControladorPanPersonasAloj'
    	this.controladorPanPersonasAloj = new ControladorPanPersonasAloj(vista, modelo, conexion, this);
    	this.controladorPanPersonasAloj.addListeners();
    	
    	// a�adimos listeners a los botones del panel 'controladorPanPago'
    	this.controladorPanPago = new ControladorPanPago(vista, modelo, this);
    	this.controladorPanPago.addListeners();
    	
    	// a�adimos listeners a los botones del panel 'controladorPanVueltas'
    	this.controladorPanVueltas = new ControladorPanVueltas(vista, modelo, this, controladorPanPago);
    	this.controladorPanVueltas.addListeners();
    	
    	// a�adimos listeners a los botones del panel de log in
    	this.controladorLogin = new ControladorLogin(vista, modelo, this);
    	this.controladorLogin.addListeners();
    	
    	// a�adimos listeners a los botones del panel de registro
    	this.controladorRegistro = new ControladorRegistro(vista, modelo, this);
    	this.controladorRegistro.addListeners();
    	
    	// a�adimos listeners a los botones del panel de las bases legales
    	this.controladorBases = new ControladorPanBases(vista, modelo, this);
    	this.controladorBases.addListeners();
    	
    	// a�adimos listeners a los botones del panel de los cupones descuento
    	this.controladorCupon = new ControladorPanCuponDesc(vista, modelo, this);
    	this.controladorCupon.addListeners();
    	
    	// a�adimos listeners a los botones del panel de seleccion de servicios adicionales
    	this.controladorServicios = new ControladorPanServiciosAdicionales(vista, modelo, this);
    	this.controladorServicios.addListeners();
    }
}
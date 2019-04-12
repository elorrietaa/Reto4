package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.*;
import vista.*;

/**
 * Esta clase se encarga de controlar las funciones del panel de pago
 */

public class ControladorPanPago implements ActionListener{ 
	
	private JframePrincipal vista; // Declara el objeto vista
	private PrincipalModelo modelo; // Declara el objeto modelo	
	private FuncionesPago funcionesPago;
	private JTextField introducido, restante; // Instancia los label del dinero para poder cambiarlos en la interfaz
	public float total = 0; // Total del importe que se debe pagar
	public float dinero = 0; // Total del dinero que ha sido introdcido hasta al momento
	private float falta = 0; // Total del dinero que falta por introducir
	private float moneda = 0; // Guarda el valos de la ultima moneda o billete introducido
	public String sobra = ""; // Cantidad minima de monedas que tiene que devolver
	public float[] monedas; // Almacena el valor de las monedas y billetes que se van introducioendo para luego poder retarlos.
	/**
	 * Constructor del controlador de pago
	 * 
	 * @param vista: Guarda el objeto vista para poder utilizar los distintos elementos de la interfaz
	 * @param modelo: Guarda el objeto modelo para poder acceder a los metodos del modelo
	 */
	public ControladorPanPago(JframePrincipal vista, PrincipalModelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.introducido = this.vista.pago.totalIntro;
		this.restante = this.vista.pago.aPagar;
		this.monedas = new float[0];
	}
	/**
	 * Generamos los listeners necesarios para el panel
	 */
	public void addListeners() {
		// Se agregan los action listeners a los botones para poder utilizarlos
		this.vista.pago.btn1cen.addActionListener(this);
		this.vista.pago.btn2cen.addActionListener(this);
		this.vista.pago.btn5cen.addActionListener(this);
		this.vista.pago.btn10cen.addActionListener(this);
		this.vista.pago.btn20cen.addActionListener(this);
		this.vista.pago.btn50cen.addActionListener(this);
		this.vista.pago.btn1.addActionListener(this);
		this.vista.pago.btn2.addActionListener(this);
		this.vista.pago.btn5.addActionListener(this);
		this.vista.pago.btn10.addActionListener(this);
		this.vista.pago.btn20.addActionListener(this);
		this.vista.pago.btn50.addActionListener(this);
		this.vista.pago.btn100.addActionListener(this);
		this.vista.pago.btn200.addActionListener(this);
		
		this.vista.pago.btnAtras.addActionListener(this);
		//this.vista.pago.btnCancelar.addActionListener(this);
		//this.vista.pago.btnCancelarPago.addActionListener(this);
		this.vista.pago.btnContinuar.addActionListener(this);
	}
	/**
	 * Metodo que contiene las acciones realizadas por cada uno de los listeners
	 */
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand(); // Almacena el texto del boton para poder identificarlo posteriormente
		float importe; // Almacena el importe que representa cada uno de los botones, para así poder realizar las operaciones con el dinero
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "0,01 €":
				importe = 0.01f;
				FuncionBotonDinero(importe); // Llama a la funcion que realiza las operaciones con el importe de cada boton
				break;
				
			case "0,02 €":
				importe = 0.02f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,05 €":
				importe = 0.05f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,1 €":
				importe = 0.1f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,2 €":
				importe = 0.2f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,5 €":
				importe = 0.5f;
				FuncionBotonDinero(importe);
				break;
				
			case "1 €":
				importe = 1f;
				FuncionBotonDinero(importe);
				break;
				
			case "2 €":
				importe = 2f;
				FuncionBotonDinero(importe);
				break;
				
			case "5 €":
				importe = 5f;
				FuncionBotonDinero(importe);
				break;
				
			case "10 €":
				importe = 10f;
				FuncionBotonDinero(importe);
				break;
				
			case "20 €":
				importe = 20f;
				FuncionBotonDinero(importe);
				break;
				
			case "50 €":
				importe = 50f;
				FuncionBotonDinero(importe);
				break;
				
			case "100 €":
				importe = 100f;
				FuncionBotonDinero(importe);
				break;
				
			case "200 €":
				importe = 200f;
				FuncionBotonDinero(importe);
				break;
				
			case "Atrás":
				vista.detallesReserva.setVisible(true);
				vista.pago.setVisible(false);
				reset();
				break;
				
			//case "Cancelar":
				//vista.bienvenida.setVisible(true);
				//vista.pago.setVisible(false);
				//reset();
				//break;
				
			//case "Devolver":
				//FuncionDevolver();
				//break;
				
			case "Continuar":
				if(dinero >= total) {
					FuncionContinuar();
				}
				else {
					 JOptionPane.showMessageDialog(vista, "Lo sentimos. No puede continuar su compra hasta que abone el importe completo. Gracias. ", null, 0);
					System.out.println("Le falta dinero por introducir");
				}
				
				break;
				
		}
	}
	/**
	 * Realiza las operaciones con el importe de cada boton, tambien almacena las cantidades que se ban introduciendo, se calcula el dinero que fala por introducir o lo que sobra
	 * 
	 * @param importe: Variable que guarda el valor monetario de cada uno de los botones de pago, para luego pasarlo como parametro en la funcion hace los calculos con el dinero
	 */
	public void FuncionBotonDinero(float importe) {
		int posicion; // Guarda la posicion en la que se debe almacenar el importe del boton pulsado en al array de monedas
		this.total = this.modelo.precioTotal; // Guarda el importe total que se debe introducir
		dinero = dinero + importe; // Se suma el importe del boton pulsado al dinero que ya se habia introducido
		dinero = Math.round(dinero*100); // Redondea el resultado
		dinero = dinero/100;
		//monedas = controlador.FuncionesPago
		monedas = FuncionesPago.redimensionarArrayMayor(monedas); // Redimensiona el array monedas a un array una posicion mayos para poder guardar el importe del boton pulsado
		posicion = monedas.length - 1;
		monedas[posicion] = importe; // Guarda el importe en la ultima posicion del array
		introducido.setText(Float.toString(dinero) + " €"); // Muestra en la interfaz el dinero que se ha introducido hasta el momento
		if(dinero < total) { // Comprueba si todabia falta dinero para llegar al total
			falta = modelo.funcionesPago.falta(total, dinero); // En caso de no llegar o sobrepasar el total necesario, se calcula el dinero faltante
			restante.setText(Float.toString(falta) + " €"); // Muestra en la interfaz el dinero que falta para alcanzar el total
		}
		else
			TodoIntroducido(); // Si se ha introducedo o sobrepasado el total, llama a esta funcion
	}
	/**
	 * Realiza las operaciones necesarias cuando el usuario pide que se le devuelva la ultima moneda introducida
	 */
	/*public void FuncionDevolver() {
		int posicion;
		if(dinero > 0) {
			posicion = monedas.length - 1;
			moneda = monedas[posicion]; // Guarda el valor de la ultima moneda introducida en el array
			dinero = dinero - moneda; // Resta al dinero total el importe de la ultima moneda introducida
			dinero = Math.round(dinero*100); 
			dinero = dinero/100;
			introducido.setText(Float.toString(dinero) + " €"); // Actualiza el indicador del dinero introducido en la interfaz, con el valor que tiene despues de sacar la ultima moneda introducida
			monedas = modelo.funcionesPago.redimensionarArrayMenor(monedas);
			if(dinero < total) { // Comprueba si despues de sacar la moneda el dinero introducido hasta el momento es menor que el total
				falta = modelo.funcionesPago.falta(total, dinero); // Calcula el dinero que falta para llegar al total
				restante.setText(Float.toString(falta) + " €"); // Muestra en la interfaz el dinero que falta
				this.vista.pago.btn1cen.setEnabled(true); // Vuelve a habilitar los botones con el dinero
				this.vista.pago.btn2cen.setEnabled(true);
				this.vista.pago.btn5cen.setEnabled(true);
				this.vista.pago.btn10cen.setEnabled(true);
				this.vista.pago.btn20cen.setEnabled(true);
				this.vista.pago.btn50cen.setEnabled(true);
				this.vista.pago.btn1.setEnabled(true);
				this.vista.pago.btn2.setEnabled(true);
				this.vista.pago.btn5.setEnabled(true);
				this.vista.pago.btn10.setEnabled(true);
				this.vista.pago.btn20.setEnabled(true);
				this.vista.pago.btn50.setEnabled(true);
				this.vista.pago.btn100.setEnabled(true);
				this.vista.pago.btn200.setEnabled(true);
				
				this.vista.pago.btnContinuar.setVisible(false); // Desabilita el boton de continuar y lo hace invisible
				this.vista.pago.btnContinuar.setEnabled(false);
			}
			else
				TodoIntroducido(); // Si el dinero es igual o mayor que el total, llama a esta funcion
		}
	}*/
	/**
	 * Funcion que se utiliza una vez que el dinero ha llegado o sobrepasado el total
	 */
	public void TodoIntroducido() {
		
		introducido.setText(Float.toString(dinero) + " €"); // Muestra el dinero que se ha introducido
		restante.setText("0 €"); // Pone el texto del dinero restante a 0
		
		this.vista.pago.btn1cen.setEnabled(false); // Deshabilita todo los botones de dinero
		this.vista.pago.btn2cen.setEnabled(false);
		this.vista.pago.btn5cen.setEnabled(false);
		this.vista.pago.btn10cen.setEnabled(false);
		this.vista.pago.btn20cen.setEnabled(false);
		this.vista.pago.btn50cen.setEnabled(false);
		this.vista.pago.btn1.setEnabled(false);
		this.vista.pago.btn2.setEnabled(false);
		this.vista.pago.btn5.setEnabled(false);
		this.vista.pago.btn10.setEnabled(false);
		this.vista.pago.btn20.setEnabled(false);
		this.vista.pago.btn50.setEnabled(false);
		this.vista.pago.btn100.setEnabled(false);
		this.vista.pago.btn200.setEnabled(false);
		
		this.vista.pago.btnContinuar.setVisible(true); // Habilita y vuelve visible en boton de continuar
		this.vista.pago.btnContinuar.setEnabled(true);
		
	}
	/**
	 * Funcion del boton continuar
	 */
	public void FuncionContinuar() {
		sobra = modelo.funcionesPago.sobra(total, dinero); // Calcula el dinero que sobra para devolverselo al usuario
		vista.vueltas.setVisible(true); // Pone el panel fin de pago visible
		vista.pago.setVisible(false); // Pone el panel de pago en invisible
		
		vista.vueltas.txtTotal.setText(Float.toString(total) + " €"); // Muesta el dinero total
		vista.vueltas.txtTotalIntro.setText(Float.toString(dinero) + " €"); // Muestra el dinero introducido
		vista.vueltas.PanelVueltas.setText(sobra); // Muestra el dinero sobrante
		
		//guarda los datos de la reserva en en un fichero
		modelo.funcionesReserva.escribeEnFichero(modelo, vista);
		
		/*// rellenar datos del cliente en el billete	
		modelo.billeteIda.setDni(modelo.cliente.getDni());
		
		// insertar billete en BBDD
		int codBilleteIda = modelo.consultas.insertarBillete(modelo.billeteIda);
		modelo.billeteIda.setCodBillete(codBilleteIda);
		
		// comprobar si existe billete de vuelta
		if (modelo.billeteVuelta != null) {
			
			// rellenar datos del cliente en el billete	
			modelo.billeteVuelta.setDni(modelo.cliente.getDni());
			
			// insertar billete en BBDD
			int codBilleteVuelta = modelo.consultas.insertarBillete(modelo.billeteVuelta);
			modelo.billeteVuelta.setCodBillete(codBilleteVuelta);
			
		}*/
		
	}
	/**
	 * Funcion del boton de cancelar
	 */
	public void reset() {
		//	modelo.cliente = null;
		//	modelo.billeteIda = null;
		//	modelo.billeteVuelta = null;
		//	modelo.linea = null;
		//	modelo.paradaOrigen = null;
		//	modelo.paradaDestino = null;
		//	modelo.autobus = null;
		//	modelo.precioTotal = 0;
		
		//	vista.sel_billete.rbtnIda.setSelected(true);
		//	vista.sel_billete.rbtnVuelta.setSelected(false);
		
		//	vista.login.userField.setText("");
		//	vista.login.password.setText("");
		
		//	vista.registro.txtNombre.setText("");
		//	vista.registro.txtApellidos.setText("");
		//	vista.registro.rbtnMasc.setSelected(false);
		//	vista.registro.rbtnFem.setSelected(false);
		//	vista.registro.txtDni.setText("");
		//	vista.registro.passwordField.setText("");
		//	vista.registro.passwordField2.setText("");
		
		this.introducido.setText("0 \u20AC");
		this.restante.setText("0 \u20AC");
		this.monedas = new float[0];
		this.dinero = 0f;
		
		this.vista.pago.btn1cen.setEnabled(true); // Habilita todo los botones de dinero
		this.vista.pago.btn2cen.setEnabled(true);
		this.vista.pago.btn5cen.setEnabled(true);
		this.vista.pago.btn10cen.setEnabled(true);
		this.vista.pago.btn20cen.setEnabled(true);
		this.vista.pago.btn50cen.setEnabled(true);
		this.vista.pago.btn1.setEnabled(true);
		this.vista.pago.btn2.setEnabled(true);
		this.vista.pago.btn5.setEnabled(true);
		this.vista.pago.btn10.setEnabled(true);
		this.vista.pago.btn20.setEnabled(true);
		this.vista.pago.btn50.setEnabled(true);
		this.vista.pago.btn100.setEnabled(true);
		this.vista.pago.btn200.setEnabled(true);
		
		this.vista.pago.btnContinuar.setVisible(false);
		this.vista.pago.btnContinuar.setEnabled(false);
		
	}
}
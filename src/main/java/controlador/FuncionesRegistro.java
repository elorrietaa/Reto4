package controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import modelo.Cliente;
import modelo.PrincipalModelo;
import vista.JframePrincipal;

/**
 * Esta clase se utiliza para validar el DNI del usuario y encriptar su contrase�a
 * 
 * @author Mikel
 * 
 * @param letraMayuscula Almacena la letra el DNI en mayuscula para poder comprobarla
 * @param numero Guarda los numeros del DNI
 * @param dni2 Almacena solo los numeros del DNI para poder comprobarlos
 * @param numerosUnoNueve Guarda los numero del 0 al nueve para poder comprobarlos
 * @param Contrase�aEncriptar Es la contrase�a que se va a encriptar
 * @param contrase�aGenerada Es la contrase�a una vez encriptada
 * @param md Instancia de MessageDigest, se utiliza para separar la contrase�a en fragmentos para poder encriptarla
 * @param bytes Array que almacena los distintros trozos separados de la contrase�a con MessageDigest transformados en bytes
 * @param sb Instancia de StringBuilder, se utiliza para volver a unir las diferentes partes de la contrasela vez encriptada
*/
public class FuncionesRegistro {
	
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	/**
	 * Contructor de la clase FuncionesRegistro
	 * 
	 * @param modelo Instancia del modelo para poder utilizarlo
	 */
	public FuncionesRegistro (PrincipalModelo modelo, PrincipalControlador controlador, JframePrincipal vista) {
		this.modelo = modelo;
		this.controlador = controlador;
		this.vista = vista;
	}
	/**
	 * Metodo que se encarga de validar el DNI
	 * 
	 * @param dni DNI que se quiere validar
	 * 
	 * @return Retorna true o false si el DNI ha sido validad satisfactoriamente o no respectivamente
	 */
	public boolean validarDNI(String dni) {
		String letraMayuscula = "";
		if(dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) 
			return false;
		letraMayuscula = (dni.substring(8)).toUpperCase();
		if(soloNumeros(dni) == true && letraDNI(dni).equals(letraMayuscula))
			return true;
		else
			return false;
	}
	/**
	 * Metodo que comprueba que los 8 primeros caracteres del DNI son solo numeros
	 * 
	 * @param dni DNI que se quiere comprobar
	 * 
	 * @return Retorna true o false si la comprobacion ha dado un resultado satisfactoriamente o no respectivamente
	 */
	public boolean soloNumeros(String dni) {
		String numero = "";
		String dni2 = "";
		String[] numerosUnoNueve = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		for(int i = 0; i < dni.length() - 1; i++) {
			numero = dni.substring(i, i+1);
			for(int j = 0; j < numerosUnoNueve.length; j++) {
				if(numero.equals(numerosUnoNueve[j]))
					dni2 = dni2 + numerosUnoNueve[j];
			}
		}
		if(dni2.length() != 8)
			return false;
		else
			return true;
	}
	/**
	 * Metodo que comprueba que la letra del DNI sea valida
	 * 
	 * @param dni DNI que se quiere comprobar
	 * 
	 * @return Reotrna la letra valida
	 */
	public String letraDNI(String dni) {
		int dni2 = Integer.parseInt(dni.substring(0, 8));
		int posicion = 0;
		String letra = "";
		String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E", "T"};
		
		posicion = dni2 % 23;
		letra = letras[posicion];
		
		return letra;
	}
	/**
	 * Metodo que se ancarga de encriptar la contrase�a
	 * 
	 * @param contrase�aAEncriptar Contrase�a que se quiere encriptar
	 * 
	 * @return Retorna la contrase�a encriptada
	 */
	public String encriptacion(String contrase�aAEncriptar){
        String contrase�aGenerada = null;
        try {
        	// Crea una instancia de MessageDigest para MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Agrega la contrase�a separada en bytes para separarla
            md.update(contrase�aAEncriptar.getBytes());
            // Saca los bytes separados
            byte[] bytes = md.digest();
            // bytes[] almacena los bytes en formato decimal
            // Los bytes en decimal pasan a hexadecimal
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Coge los bytes separados de la contrase�a en hexadecimal y los junta en un string
            contrase�aGenerada = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return contrase�aGenerada;
    }
	/**
	 * Metodo que comprueba si el usuario existe a la hora de iniciar sesion
	 * @param usuario DNI del usuario que se quiere comprobar
	 * @param contrasena Contrase�a del usuario que se quiere comprobar
	 * @return Retorna un objeto cliente con los datos del usuario
	 */
	public Cliente comprobarInicio(String usuario, String contrasena) {
		
		Cliente cliente = null;
		contrasena = controlador.funcionesRegistro.encriptacion(contrasena);
		
		cliente = modelo.consultas.buscarClientePorDNI(usuario);
		 
		if(cliente != null) {
			if(!contrasena.equals(cliente.getContrasena())) {
				cliente = null;
			}
		}
		
		return cliente;
		
	}
	/**
	 * Este m�todo oculta los botones
	 */
	public void ocultarBotones() {
		vista.buscarAlojamiento.btnInicioSesion.setVisible(false);
		vista.buscarAlojamiento.btnInicioSesion.setEnabled(false);
		vista.buscarAlojamiento.btnRegistro.setVisible(false);
		vista.buscarAlojamiento.btnRegistro.setEnabled(false);
		vista.selHabitacion.btnInicioSesion.setVisible(false);
		vista.selHabitacion.btnInicioSesion.setEnabled(false);
		vista.selHabitacion.btnRegistro.setVisible(false);
		vista.selHabitacion.btnRegistro.setEnabled(false);
		vista.detallesReserva.btnInicioSesion.setVisible(false);
		vista.detallesReserva.btnInicioSesion.setEnabled(false);
		vista.detallesReserva.btnRegistro.setVisible(false);
		vista.detallesReserva.btnRegistro.setEnabled(false);
		vista.detallesReservaCasaApart.btnInicioSesion.setVisible(false);
		vista.detallesReservaCasaApart.btnInicioSesion.setEnabled(false);
		vista.detallesReservaCasaApart.btnRegistro.setVisible(false);
		vista.detallesReservaCasaApart.btnRegistro.setEnabled(false);
		vista.buscarAlojamiento.btnCerrarSesion.setVisible(true);
		vista.buscarAlojamiento.btnCerrarSesion.setEnabled(true);
		vista.selHabitacion.btnCerrarSesion.setVisible(true);
		vista.selHabitacion.btnCerrarSesion.setEnabled(true);
		vista.detallesReserva.btnCerrarSesion.setVisible(true);
		vista.detallesReserva.btnCerrarSesion.setEnabled(true);
		vista.detallesReservaCasaApart.btnCerrarSesion.setVisible(true);
		vista.detallesReservaCasaApart.btnCerrarSesion.setEnabled(true);
		
	}
	/**
	 * Este m�todo muestra lo Botones y oculta otros.
	 */
	public void mostrarBotones() {
		vista.buscarAlojamiento.btnInicioSesion.setVisible(true);
		vista.buscarAlojamiento.btnInicioSesion.setEnabled(true);
		vista.buscarAlojamiento.btnRegistro.setVisible(true);
		vista.buscarAlojamiento.btnRegistro.setEnabled(true);
		vista.selHabitacion.btnInicioSesion.setVisible(true);
		vista.selHabitacion.btnInicioSesion.setEnabled(true);
		vista.selHabitacion.btnRegistro.setVisible(true);
		vista.selHabitacion.btnRegistro.setEnabled(true);
		vista.detallesReserva.btnInicioSesion.setVisible(true);
		vista.detallesReserva.btnInicioSesion.setEnabled(true);
		vista.detallesReserva.btnRegistro.setVisible(true);
		vista.detallesReserva.btnRegistro.setEnabled(true);
		vista.detallesReservaCasaApart.btnInicioSesion.setVisible(true);
		vista.detallesReservaCasaApart.btnInicioSesion.setEnabled(true);
		vista.detallesReservaCasaApart.btnRegistro.setVisible(true);
		vista.detallesReservaCasaApart.btnRegistro.setEnabled(true);
		vista.buscarAlojamiento.btnCerrarSesion.setVisible(false);
		vista.buscarAlojamiento.btnCerrarSesion.setEnabled(false);
		vista.selHabitacion.btnCerrarSesion.setVisible(false);
		vista.selHabitacion.btnCerrarSesion.setEnabled(false);
		vista.detallesReserva.btnCerrarSesion.setVisible(false);
		vista.detallesReserva.btnCerrarSesion.setEnabled(false);
		vista.detallesReservaCasaApart.btnCerrarSesion.setVisible(false);
		vista.detallesReservaCasaApart.btnCerrarSesion.setEnabled(false);
	}

}

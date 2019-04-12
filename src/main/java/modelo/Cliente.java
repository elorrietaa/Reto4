package modelo;

import java.sql.Date;
/**
 * Este objeto se encarga de almacenar toda la informacion necesaria para registrar y logear a los clientes
 */
public class Cliente {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private char sexo;
	private String contrasena;
	/**
	 * Constructor vacio del objeto cliente
	 */
	public Cliente() {
		
	}
	/**
	 * Constructor con parametros del objeto cliente
	 * 
	 * @param dni: Guarda el DNI del cliente
	 * @param nombre: Guarda el nombre del cliente
	 * @parma apellidos: Guarda los apellidos del cliente
	 * @param fechaNacimiento: Guarda la fecha de nacimiento del cliente
	 * @param sexo: Guarda el sexo del cliente, en forma de caracter
	 * @param contrasena: Guarda la contraseña del cliente
	 */
	public Cliente(String dni, String nombre, String apellidos, Date fechaNacimiento, char sexo, String contrasena) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.contrasena = contrasena;
	}
	/**
	 * Geter del dni del cliente
	 * 
	 * @return Retorna el DNI del cliente
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Seter del dni del cliente
	 * 
	 * @param dni Guarda el DNI del cliente
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * Geter del nombre del cliente
	 * 
	 * @return Retorna el nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Seter del nombre del cliente
	 * 
	 * @param nombre Guarda el nombre del cliente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Geter de los apellidos del cliente
	 * 
	 * @return Retorna los apellidos del cliente
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Seter de los apellidos del cliente
	 * 
	 * @param apellidos Guarda los apellidos del cliente
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * Geter de la fecha de nacimiento del cliente
	 * 
	 * @return Retorna la fecha de nacimiento del cliente
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * Seter de la fecha de nacimiento del cliente
	 * 
	 * @param fechaNacimiento Guarda la fecha de nacimiento del cliente
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * Geter del sexo del cliente
	 * 
	 * @return Retorna el sexo del cliente, en forma de caracter
	 */
	public char getSexo() {
		return sexo;
	}
	/**
	 * Seter del sexo del cliente
	 * 
	 * @param sexo Guarda el sexo del cliente, en forma de caracter
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	/**
	 * Geter de la contraseña del cliente
	 * 
	 * @return Retorna la contraseña del cliente
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * Seter de la contraseña del cliente
	 * 
	 * @param contrasena Guarda la contraseña del cliente
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
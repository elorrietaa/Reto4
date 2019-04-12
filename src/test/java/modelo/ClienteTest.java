package modelo;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class ClienteTest { 


	private String dni = "22758299X";
	private String nombre = "Alba";
	private String apellidos = "Rodriguez Salvador";
	private Date fechaNacimiento = new Date(31-01-2019);
	private char sexo = 'M';
	private String contrasena = "abracadaver";
	private Cliente cliente = new Cliente();
	
	@Test
	public void testConstructorVacioCliente() {
		//Arrange
		Cliente cliente = new Cliente();
		
		//Assert
		assertEquals(null, cliente.getDni());
		assertEquals(null, cliente.getNombre());
		assertEquals(null, cliente.getApellidos());
		assertEquals(null, cliente.getFechaNacimiento());
		assertEquals(0, cliente.getSexo());
		assertEquals(null, cliente.getContrasena());
	}
	
	@Test
	public void testConstructorCliente() {
		
		//Arrange
		Cliente cliente = new Cliente(dni,nombre,apellidos, fechaNacimiento, sexo, contrasena);
		
		//Assert
		assertEquals(dni, cliente.getDni());
		assertEquals(nombre, cliente.getNombre());
		assertEquals(apellidos, cliente.getApellidos());
		assertEquals(fechaNacimiento, cliente.getFechaNacimiento());
		assertEquals(sexo, cliente.getSexo()); 
		assertEquals(contrasena, cliente.getContrasena());
	}
	
	@Test
	public void testDni() {
		cliente.setDni(dni);
		assertEquals(dni, cliente.getDni());
	}
	
	@Test
	public void testNombre() {
		cliente.setNombre(nombre);
		assertEquals(nombre, cliente.getNombre());
	}
	
	@Test
	public void testApellidos() {
		cliente.setApellidos(apellidos);
		assertEquals(apellidos, cliente.getApellidos());
	}
	
	@Test
	public void testFechaNac() {
		cliente.setFechaNacimiento(fechaNacimiento);
		assertEquals(fechaNacimiento, cliente.getFechaNacimiento());
	}
	
	@Test
	public void testSexo() {
		cliente.setSexo(sexo);
		assertEquals(sexo, cliente.getSexo());
	}
	
	@Test
	public void testContrasena() {
		cliente.setContrasena(contrasena);
		assertEquals(contrasena, cliente.getContrasena());
	}
	

}

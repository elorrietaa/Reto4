package controlador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class FuncionesRegistroTest {


	PrincipalModelo modelo = new PrincipalModelo();
	JframePrincipal vista = new JframePrincipal();
	PrincipalControlador controlador  = new PrincipalControlador(modelo, null);
	FuncionesRegistro funcionesRegistro = new FuncionesRegistro(modelo, null,vista);
	
	@Test
	public void testValidarDNI() {
		String dni = "72317852X";
		assertEquals(true, funcionesRegistro.validarDNI(dni));
	}
	
	@Test
	public void testValidarDNIError() {
		String dni = "12317852X";
		assertNotEquals(true, funcionesRegistro.validarDNI(dni));
	}
	@Test
	public void testValidarDNIError2() {
		String dni = "1231785256X";
		assertNotEquals(true, funcionesRegistro.validarDNI(dni));
	}
	@Test
	public void testValidarDNIError3() {
		String dni = "1231785256";
		assertNotEquals(true, funcionesRegistro.validarDNI(dni));
	}
	
	@Test
	public void testValidarDNIError4() {
		String dni = "123178m";
		assertNotEquals(true, funcionesRegistro.validarDNI(dni));
	}
	
	@Test
	public void testValidarDNIError5() {
		String dni = "12345678m";
		assertEquals(false, funcionesRegistro.validarDNI(dni));
	}
	
	@Test
	public void testSoloNumeros() {
		String dni = "72317852X";
		assertEquals(true, funcionesRegistro.soloNumeros(dni));
	}
	
	@Test
	public void testSoloNumerosError() {
		String dni = "123178ffX";
		assertNotEquals(true, funcionesRegistro.soloNumeros(dni));
	}
	
	@Test
	public void testLetraDNI() {
		String dni = "72317852X";
		String letraMayuscula = (dni.substring(8)).toUpperCase();
		assertEquals(letraMayuscula, funcionesRegistro.letraDNI(dni));
	}
	
	@Test
	public void testLetraDNIError() {
		String dni = "12317852B";
		String letraMayuscula = (dni.substring(8)).toUpperCase();
		assertNotEquals(letraMayuscula, funcionesRegistro.letraDNI(dni));
	}

	@Test
	public void testEncriptacion() {
		
		String contraseña = "abracadabra";
		String contraseñaEncriptada = "ec5287c45f0e70ec22d52e8bcbeeb640";
		
		assertEquals(contraseñaEncriptada, funcionesRegistro.encriptacion(contraseña));
	}
	
	@Test
	public void testEncriptacionMal() {
		
		String contraseña = "abracadabra";
		String contraseñaEncriptada = "11ec5287c45f0e70ec22d52e8bcbeeb640";
		
		assertNotEquals(contraseñaEncriptada, funcionesRegistro.encriptacion(contraseña));
	}
	

		

}

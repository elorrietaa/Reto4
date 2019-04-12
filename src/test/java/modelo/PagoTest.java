package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.FuncionesPago;

public class PagoTest {

	PrincipalModelo modelo = new PrincipalModelo();
	FuncionesPago funcionesPago = new FuncionesPago(modelo);
	
	@Test
	public void testRedimensionarArrayMayor() {
		
		float[] array = new float[0];
		array = funcionesPago.redimensionarArrayMayor(array);
		
		assertEquals(1, array.length);
	}
	
	@Test
	public void testRedimensionarArrayMenor() {
		
		float[] array = new float[2];
		array = funcionesPago.redimensionarArrayMenor(array);
		
		assertEquals(1, array.length);
	}
	
	@Test
	public void testFalta() {
		
		float total = 85.7f;
		float dinero = 83.5f;
		float falta = 2.2f;
		
		assertEquals(falta, funcionesPago.falta(total, dinero), 0);	
	}
	
	@Test
	public void testSobra200() {
		
		float total = 0f;
		float dinero = 200f;
		String sobra = "1 billetes de 200€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra100() {
		
		float total = 0f;
		float dinero = 100f;
		String sobra = "1 billetes de 100€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra50() {
		
		float total = 0f;
		float dinero = 50f;
		String sobra = "1 billetes de 50€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra20() {
		
		float total = 0f;
		float dinero = 20f;
		String sobra = "1 billetes de 20€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra10() {
		
		float total = 0f;
		float dinero = 10f;
		String sobra = "1 billetes de 10€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra5() {
		
		float total = 0f;
		float dinero = 5f;
		String sobra = "1 billetes de 5€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra2() {
		
		float total = 0f;
		float dinero = 2f;
		String sobra = "1 monedas de 2€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra1() {
		
		float total = 0f;
		float dinero = 1f;
		String sobra = "1 monedas de 1€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra50cen() {
		
		float total = 0f;
		float dinero = 0.5f;
		String sobra = "1 monedas de 0,50€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra20cent() {
		
		float total = 0f;
		float dinero = 0.2f;
		String sobra = "1 monedas de 0,20€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra10cent() {
		
		float total = 0f;
		float dinero = 0.1f;
		String sobra = "1 monedas de 0,10€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra5cent() {
		
		float total = 0f;
		float dinero = 0.05f;
		String sobra = "1 monedas de 0,05€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra2cent() {
		
		float total = 0f;
		float dinero = 0.02f;
		String sobra = "1 monedas de 0,02€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra1cent() {
		
		float total = 0f;
		float dinero = 0.01f;
		String sobra = "1 monedas de 0,01€\n";
		
		assertEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
}
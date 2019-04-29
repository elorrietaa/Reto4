package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.FuncionesPago;
import modelo.PrincipalModelo;

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
	public void testFaltaMal() {
		
		float total = 85.7f;
		float dinero = 83.5f;
		float falta = 2.6f;
		
		assertNotEquals(falta, funcionesPago.falta(total, dinero), 0);	
	}
	
	@Test
	public void testFalta1() {
		
		float total = 85.7f;
		float dinero = 85.7f;
		float falta = 0f;
		
		assertEquals(falta, funcionesPago.falta(total, dinero), 0);	
	}
	
	@Test
	public void testFalta1Mal() {
		
		float total = 85.7f;
		float dinero = 85.9f;
		float falta = 0f;
		
		assertNotEquals(falta, funcionesPago.falta(total, dinero), 0);	
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
	
	@Test
	public void testSobra200Mal() {
		
		float total = 0f;
		float dinero = 9200f;
		String sobra = "1 billetes de 200€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	
	@Test
	public void testSobra100Mal() {
		
		float total = 0f;
		float dinero = 9100f;
		String sobra = "1 billetes de 100€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra50Mal() {
		
		float total = 0f;
		float dinero = 950f;
		String sobra = "1 billetes de 50€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra20Mal() {
		
		float total = 0f;
		float dinero = 290f;
		String sobra = "1 billetes de 20€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra10Mal() {
		
		float total = 0f;
		float dinero = 910f;
		String sobra = "1 billetes de 10€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra5Mal() {
		
		float total = 0f;
		float dinero = 95f;
		String sobra = "1 billetes de 5€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra2Mal() {
		
		float total = 0f;
		float dinero = 92f;
		String sobra = "1 monedas de 2€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra1Mal() {
		
		float total = 0f;
		float dinero = 91f;
		String sobra = "1 monedas de 1€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra50cenMal() {
		
		float total = 0f;
		float dinero = 90.5f;
		String sobra = "1 monedas de 0,50€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra20centMal() {
		
		float total = 0f;
		float dinero = 90.2f;
		String sobra = "1 monedas de 0,20€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra10centMal() {
		
		float total = 0f;
		float dinero = 90.1f;
		String sobra = "1 monedas de 0,10€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra5centMal() {
		
		float total = 0f;
		float dinero = 90.05f;
		String sobra = "1 monedas de 0,05€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra2centMal() {
		
		float total = 0f;
		float dinero = 90.02f;
		String sobra = "1 monedas de 0,02€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
	
	@Test
	public void testSobra1centMal() {
		
		float total = 0f;
		float dinero = 90.01f;
		String sobra = "1 monedas de 0,01€\n";
		
		assertNotEquals(sobra, funcionesPago.sobra(total, dinero));	
	}
}
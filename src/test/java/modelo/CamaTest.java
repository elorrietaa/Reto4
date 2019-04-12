package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CamaTest {
    private int codCama=1;
    private String tipoCama="Simple";
    
    Cama cama  = new Cama();
    Cama camaPrueba = new Cama(codCama, tipoCama);
	
	@Test
	public void testConstructorVacio() {   	
	}
	
	@Test
	public void testConstuctor() {
		assertEquals(codCama, camaPrueba.getCodCama());
		assertEquals(tipoCama, camaPrueba.getTipoCama());
	}
	 @Test
	public void testCodCama() {
	     camaPrueba.setCodCama(codCama);
	     assertEquals(camaPrueba, camaPrueba.getCodCama());
	}
	 @Test
	public void testTipoCama() {
	     camaPrueba.setTipoCama(tipoCama);
	     assertEquals(tipoCama, camaPrueba.getTipoCama());
	}

}

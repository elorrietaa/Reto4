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
	public void testConstuctorMal() {
		assertNotEquals(5, camaPrueba.getCodCama());
		assertNotEquals("d", camaPrueba.getTipoCama());
	}
	
	 @Test
	public void testCodCama() {
	     camaPrueba.setCodCama(codCama);
	     assertEquals(codCama, camaPrueba.getCodCama());
	} 
	
	@Test
	public void testCodCamaMal() {
		camaPrueba.setCodCama(codCama);
		assertNotEquals(6, camaPrueba.getCodCama());
	} 
	 
	 @Test
	public void testTipoCama() {
	     camaPrueba.setTipoCama(tipoCama);
	     assertEquals(tipoCama, camaPrueba.getTipoCama());
	}
	 
	@Test
	public void testTipoCamaMal() {
		  camaPrueba.setTipoCama(tipoCama);
		  assertNotEquals("f", camaPrueba.getTipoCama());
	}
	 
	 @Test
	public void testToString() {
		assertEquals(tipoCama, camaPrueba.toString());
	}
	 
	 @Test
	public void testToStringMal() {
		assertNotEquals("f", camaPrueba.toString());
	}

}

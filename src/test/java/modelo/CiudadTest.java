package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CiudadTest {
    private int codCiudad=1;
    private String nombreCiudad="Bilbao";
    
    Ciudad ciudad  = new Ciudad();
    Ciudad ciudadPrueba = new Ciudad(codCiudad, nombreCiudad);
	
	@Test
	public void testConstructorVacio() {   	
	}
	
	@Test
	public void testConstuctor() {
		assertEquals(codCiudad, ciudadPrueba.getCodCiudad());
		assertEquals(nombreCiudad, ciudadPrueba.getNombreCiudad());
		assertNotEquals(2, ciudadPrueba.getCodCiudad());
		assertNotEquals("Madrid", ciudadPrueba.getNombreCiudad());
	}
	 @Test
	public void testCodCiudad() {
	     ciudadPrueba.setCodCiudad(codCiudad);
	     assertEquals(codCiudad, ciudadPrueba.getCodCiudad());
	}
	 
	 @Test
	public void testCodCiudadMal() {
		ciudadPrueba.setCodCiudad(codCiudad);
		assertNotEquals(3, ciudadPrueba.getCodCiudad());
	}
	 
	 @Test
	public void testNombreCiudad() {
	     ciudadPrueba.setNombreCiudad(nombreCiudad);
	     assertEquals(nombreCiudad, ciudadPrueba.getNombreCiudad());
	}
	 
	@Test
	public void testNombreCiudadMal() {
		  ciudadPrueba.setNombreCiudad(nombreCiudad);
		  assertNotEquals("Madrid", ciudadPrueba.getNombreCiudad());
	}	
	
	@Test
	public void testToString() {
		 assertEquals(nombreCiudad, ciudadPrueba.toString());
	}
	 
	@Test
	public void testToStringMal() {
		assertNotEquals("k", ciudadPrueba.toString());
	}

}

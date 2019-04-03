package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CiudadesTest {
    private int codCiudad=1;
    private String nombreCiudad="BILBAO";
    Ciudades ciudadPrueba = new Ciudades(codCiudad, nombreCiudad);
    
    @Test
	public void testConstuctor() {
		assertEquals(codCiudad, ciudadPrueba.getCodCiudad());
		assertEquals(nombreCiudad, ciudadPrueba.getNombreCiudad());
	}
    @Test
   	public void testCodCiudad() {
		ciudadPrueba.setCodCiudad(codCiudad); 
   		assertEquals(codCiudad,ciudadPrueba.getCodCiudad());
   	}
    @Test
	public void testNombreCiudad() {
		ciudadPrueba.setNombreCiudad(nombreCiudad); 
		assertEquals(nombreCiudad,ciudadPrueba.getNombreCiudad());
	}
}

package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

public class CiudadTest {
    private int codCiudad=1;
    private String nombreCiudad="BILBAO";
    Ciudad ciudadPrueba = new Ciudad(codCiudad,nombreCiudad);
    @Test
    public void testConstructor() {
	assertEquals(codCiudad,ciudadPrueba.getCodCiudad());
	assertEquals(nombreCiudad,ciudadPrueba.getNombreCiudad());
    }
    
    @Test
    public void testGetCodCiudad() {
	ciudadPrueba.getCodCiudad();
	assertEquals(codCiudad,ciudadPrueba.getCodCiudad());
	}
    
    @Test
	public void testSetCodCiudad() {
	ciudadPrueba.setCodCiudad(codCiudad);
	assertEquals(codCiudad,ciudadPrueba.getCodCiudad());
	}
    @Test
    public void testGetNombreCiudad() {
	ciudadPrueba.getNombreCiudad();
	assertEquals(nombreCiudad,ciudadPrueba.getNombreCiudad());
	}
    @Test
   public void testSetNombreCiudad() {
	ciudadPrueba.setNombreCiudad(nombreCiudad);
	assertEquals(nombreCiudad,ciudadPrueba.getNombreCiudad());
   }

}

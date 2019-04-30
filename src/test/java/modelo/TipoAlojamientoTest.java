package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TipoAlojamientoTest {
	 private int codTipoAlojamiento=1;
	    private String tipoAlojamiento="Bilbao";
	    
	    TipoAlojamiento tipoAloj  = new TipoAlojamiento();
	    TipoAlojamiento tipoAlojPrueba = new TipoAlojamiento(codTipoAlojamiento, tipoAlojamiento);
		
		@Test
		public void testConstructorVacio() {   	
		}
		
		@Test
		public void testConstuctor() {
			assertEquals(codTipoAlojamiento, tipoAlojPrueba.getCodTipoAlojamiento());
			assertEquals(tipoAlojamiento, tipoAlojPrueba.getTipoAlojamiento());
			assertNotEquals(2, tipoAlojPrueba.getCodTipoAlojamiento());
			assertNotEquals("Madrid", tipoAlojPrueba.getTipoAlojamiento());
		}
		 @Test
		public void testCodTipoAlojamiento() {
		     tipoAlojPrueba.setCodTipoAlojamiento(codTipoAlojamiento);
		     assertEquals(codTipoAlojamiento, tipoAlojPrueba.getCodTipoAlojamiento());
		}
		 
		 @Test
		public void testCodTipoAlojamientoMal() {
			tipoAlojPrueba.setCodTipoAlojamiento(codTipoAlojamiento);
			assertNotEquals(3, tipoAlojPrueba.getCodTipoAlojamiento());
		}
		 
		 @Test
		public void testTipoAlojamiento() {
		     tipoAlojPrueba.setTipoAlojamiento(tipoAlojamiento);
		     assertEquals(tipoAlojamiento, tipoAlojPrueba.getTipoAlojamiento());
		}
		 
		@Test
		public void testTipoAlojamientoMal() {
			  tipoAlojPrueba.setTipoAlojamiento(tipoAlojamiento);
			  assertNotEquals("Madrid", tipoAlojPrueba.getTipoAlojamiento());
		}	
		
		@Test
		public void testToString() {
			 assertEquals(tipoAlojamiento, tipoAlojPrueba.toString());
		}
		 
		@Test
		public void testToStringMal() {
			assertNotEquals("k", tipoAlojPrueba.toString());
		}

	}

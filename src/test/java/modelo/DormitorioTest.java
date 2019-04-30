package modelo;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.Alojamiento;
import modelo.Dormitorio;

public class DormitorioTest {
	protected int codHabitacion=1;
	protected String tipoHabitacion="Dormitorio";
	protected String nombreHabitacion = "Doble";
	protected float tamanio=15;
	protected int numCamas=2;
	protected int ocupacion = 2;
	protected float precioHabitacion=(float) 172.5;
	private int numTipCam [] = {2,0,0};
	protected String tiposCamaHab = "simple";
	
	Dormitorio habitacion = new Dormitorio();
	Dormitorio habitacionPrueba = new Dormitorio(codHabitacion,nombreHabitacion, tipoHabitacion, tamanio, numCamas, ocupacion, numTipCam,precioHabitacion, tiposCamaHab);
	 
	@Test
	public void testConstructorVacio() {   	
	}
	
	@Test 
	public void testConstuctor() {
		assertEquals(codHabitacion, habitacionPrueba.getCodHabitacion());
		assertEquals(tipoHabitacion, habitacionPrueba.getTipoHabitacion());
		assertEquals(nombreHabitacion, habitacionPrueba.getNombreHabitacion());
		assertEquals(tamanio, habitacionPrueba.getTamanio(), 0.1); 
		assertEquals(numCamas,habitacionPrueba.getNumCamas());
		assertEquals(ocupacion, habitacionPrueba.getOcupacion());
		assertEquals(precioHabitacion, habitacionPrueba.getPrecioHabitacion(),0.1);
		assertEquals(numTipCam, habitacionPrueba.getNumTipCam());
		assertEquals(tiposCamaHab, habitacionPrueba.getTiposCamaHab());
	}
	 @Test
	public void testCodHabitacion() {
	habitacionPrueba.setCodHabitacion(codHabitacion); 
		assertEquals(codHabitacion,habitacionPrueba.getCodHabitacion());
	}
	 @Test
	public void testNombreHabitacion() {
	habitacionPrueba.setNombreHabitacion(nombreHabitacion);
		assertEquals(nombreHabitacion, habitacionPrueba.getNombreHabitacion());
	}
	 
	 @Test
	public void testTipoHabitacion() {
	habitacionPrueba.setTipoHabitacion(tipoHabitacion);
		assertEquals(tipoHabitacion, habitacionPrueba.getTipoHabitacion());
	}
	 @Test
	public void testTamanio() {
	habitacionPrueba.setTamanio(tamanio);
		assertEquals(tamanio, habitacionPrueba.getTamanio(),0.1);
	}
	 @Test
		public void testOcupacion() {
			habitacionPrueba.setOcupacion(ocupacion);
			assertEquals(ocupacion, habitacionPrueba.getOcupacion());
		}
	 @Test
	public void testNumCamas() {
		habitacionPrueba.setNumCamas(numCamas);
		assertEquals(numCamas, habitacionPrueba.getNumCamas());
	}
	 @Test
	public void testPrecioHabitacion() {
		habitacionPrueba.setPrecioHabitacion(precioHabitacion);
		assertEquals(precioHabitacion, habitacionPrueba.getPrecioHabitacion(),0.1);
	}
	 @Test
	public void testNumTipCama() {
		habitacionPrueba.setNumTipCam(numTipCam);
		assertEquals(numTipCam, habitacionPrueba.getNumTipCam());
	}
	@Test
	public void testTiposCamaHab() {
		habitacionPrueba.setTiposCamaHab(tiposCamaHab);
		assertEquals(tiposCamaHab, habitacionPrueba.getTiposCamaHab());
	}	
	
	 @Test
	public void testToString() {
		assertEquals(tipoHabitacion, habitacionPrueba.toString());
	}
	
	 @Test 
		public void testConstuctorMal() {
			assertNotEquals(7, habitacionPrueba.getCodHabitacion());
			assertNotEquals("k", habitacionPrueba.getTipoHabitacion());
			assertNotEquals(0, habitacionPrueba.getTamanio(), 0.1); 
			assertNotEquals(0,habitacionPrueba.getNumCamas());
			assertNotEquals(0, habitacionPrueba.getPrecioHabitacion(),0.1);
			assertNotEquals(0, habitacionPrueba.getNumTipCam());
			assertNotEquals("k", habitacionPrueba.getTiposCamaHab());
		}
		 @Test
		public void testCodHabitacionMal() {
		habitacionPrueba.setCodHabitacion(codHabitacion); 
		assertNotEquals(0,habitacionPrueba.getCodHabitacion());
		}

		 @Test
		public void testTipoHabitacionMal() {
		habitacionPrueba.setTipoHabitacion(tipoHabitacion);
		assertNotEquals("k", habitacionPrueba.getTipoHabitacion());
		}
		 @Test
		public void testTamanioMal() {
		habitacionPrueba.setTamanio(tamanio);
		assertNotEquals(0, habitacionPrueba.getTamanio(),0.1);
		}
		 @Test
		public void testNumCamasMal() {
			habitacionPrueba.setNumCamas(numCamas);
			assertNotEquals(0, habitacionPrueba.getNumCamas());
		}
		 @Test
		public void testPrecioHabitacionMal() {
			habitacionPrueba.setPrecioHabitacion(precioHabitacion);
			assertNotEquals(0, habitacionPrueba.getPrecioHabitacion(),0.1);
		}
		 @Test
		public void testNumTipCamaMal() {
			habitacionPrueba.setNumTipCam(numTipCam);
			assertNotEquals(0, habitacionPrueba.getNumTipCam());
		}
		@Test
		public void testTiposCamaHabMal() {
			habitacionPrueba.setTiposCamaHab(tiposCamaHab);
			assertNotEquals("k", habitacionPrueba.getTiposCamaHab());
		}	
		
		 @Test
		public void testToStringMal() {
			 assertNotEquals("k", habitacionPrueba.toString());
		}
}

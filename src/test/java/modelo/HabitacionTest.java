package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class HabitacionTest {
	protected int codHabitacion=1;
	protected String tipoHabitacion="Dormitorio";
	protected float tamanio=15;
	
	Habitacion habitacion = new Habitacion();
	Habitacion habitacionPrueba = new Habitacion(codHabitacion, tipoHabitacion, tamanio);
	 
	@Test
	public void testConstructorVacio() {   	
	}
	
	@Test 
	public void testConstuctor() {
		assertEquals(codHabitacion, habitacionPrueba.getCodHabitacion());
		assertEquals(tipoHabitacion, habitacionPrueba.getTipoHabitacion());
		assertEquals(tamanio, habitacionPrueba.getTamanio(), 0.1); 
		
	}
	 @Test
	public void testCodHabitacion() {
	habitacionPrueba.setCodHabitacion(codHabitacion); 
		assertEquals(codHabitacion,habitacionPrueba.getCodHabitacion());
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
		public void testConstuctorMal() {
			assertNotEquals(7, habitacionPrueba.getCodHabitacion());
			assertNotEquals("k", habitacionPrueba.getTipoHabitacion());
			assertNotEquals(0, habitacionPrueba.getTamanio(), 0.1); 
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
}
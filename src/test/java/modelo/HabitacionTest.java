package modelo;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.Alojamiento;
import modelo.Habitacion;

public class HabitacionTest {
	protected int codHabitacion=1;
	protected Alojamiento alojamiento= new Alojamiento(1, "Hotel uno", 14, "BILBAO", (float) 12.2);
	protected String tipoHabitacion="Dormitorio";
	protected float tamanio=15;
	protected int numCamas=2;
	protected String estadoHabitacion="DISPONIBLE";
	
	Habitacion habitacion = new Habitacion();
	Habitacion habitacionPrueba = new Habitacion(codHabitacion, alojamiento, tipoHabitacion, tamanio, numCamas, estadoHabitacion);
	
	@Test
	public void testConstuctor() {
		assertEquals(codHabitacion, habitacionPrueba.getCodHabitacion());
		assertEquals(alojamiento, habitacionPrueba.getAlojamiento());
		assertEquals(tipoHabitacion, habitacionPrueba.getTipoHabitacion());
		assertEquals(tamanio, habitacionPrueba.getTamanio(), 0.1);
		assertEquals(numCamas,habitacionPrueba.getNumCamas());
	}
	 @Test
		public void testCodHabitacion() {
		 habitacionPrueba.setCodHabitacion(codHabitacion); 
			assertEquals(codHabitacion,habitacionPrueba.getCodHabitacion());
		}

	 @Test
		public void testAlojamiento() {
		 habitacionPrueba.setAlojamiento(alojamiento); 
			assertEquals(alojamiento, habitacionPrueba.getAlojamiento());
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
		public void testNumCamas() {
		 habitacionPrueba.setNumCamas(numCamas);
		 	assertEquals(numCamas, habitacionPrueba.getNumCamas());
		}
	 @Test
		public void testEstadoHabitacion() {
		 habitacionPrueba.setEstadoHabitacion(estadoHabitacion);
		 	assertEquals(estadoHabitacion, habitacionPrueba.getEstadoHabitacion());
		}
}

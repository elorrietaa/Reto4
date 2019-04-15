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
	protected String tiposCamaHab = "simple";
	protected String estadoHabitacion="DISPONIBLE";
	
	Habitacion habitacion = new Habitacion();
	Habitacion habitacionPrueba = new Habitacion(codHabitacion, tipoHabitacion, tamanio, numCamas, tiposCamaHab);
	
	@Test
	public void testConstructorVacio() {   	
	}
	
	@Test
	public void testConstuctor() {
		assertEquals(codHabitacion, habitacionPrueba.getCodHabitacion());
		assertEquals(tipoHabitacion, habitacionPrueba.getTipoHabitacion());
		assertEquals(tamanio, habitacionPrueba.getTamanio(), 0.1); 
		assertEquals(numCamas,habitacionPrueba.getNumCamas());
		assertEquals(tiposCamaHab, habitacionPrueba.getTiposCamaHab());
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
	public void testNumCamas() {
		habitacionPrueba.setNumCamas(numCamas);
		assertEquals(numCamas, habitacionPrueba.getNumCamas());
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
}

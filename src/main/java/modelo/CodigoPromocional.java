package modelo;

public class CodigoPromocional {

	private String cod_promocional;
	private String dni;
	private int cod_alojamiento;
	private float descuento;
	
	
	
	public CodigoPromocional() {
		
	}
	
	public CodigoPromocional(String cod_promocional, String dni, int cod_alojamiento, float descuento) {
		this.cod_promocional = cod_promocional;
		this.dni = dni;
		this.cod_alojamiento = cod_alojamiento;
		this.descuento = descuento;
	}
	
	
	
	
	public String getCod_promocional() {
		return cod_promocional;
	}
	public void setCod_promocional(String cod_promocional) {
		this.cod_promocional = cod_promocional;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getCod_alojamiento() {
		return cod_alojamiento;
	}
	public void setCod_alojamiento(int cod_alojamiento) {
		this.cod_alojamiento = cod_alojamiento;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	
	 public String toString() {
	    	return "Cupón: " + this.cod_promocional + " - Descuento:" + (String.format("%.0f", (this.descuento*100))) + "%";
	    }
	
}

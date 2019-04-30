package modelo;

public class TipoAlojamiento {
	private int codTipoAlojamiento;
    private String tipoAlojamiento;
    /**
     * Constructor del objeto TipoAlojamiento vacio
     */
    public TipoAlojamiento() {
	
    }
    /**
     * Constructor del objeto TipoAlojamiento
     * @param codTipoAlojamiento
     * @param tipoAlojamiento
     */
    public TipoAlojamiento(int codTipoAlojamiento, String tipoAlojamiento) {
	this.codTipoAlojamiento = codTipoAlojamiento;
	this.tipoAlojamiento = tipoAlojamiento;
    }
    
	public int getCodTipoAlojamiento() {
		return codTipoAlojamiento;
	}
	public void setCodTipoAlojamiento(int codTipoAlojamiento) {
		this.codTipoAlojamiento = codTipoAlojamiento;
	}
	public String getTipoAlojamiento() {
		return tipoAlojamiento;
	}
	public void setTipoAlojamiento(String tipoAlojamiento) {
		this.tipoAlojamiento = tipoAlojamiento;
	}
	 /**
     * toString del nombre de la ciudad
     */
    public String toString() {
    	return this.tipoAlojamiento;
    }
}

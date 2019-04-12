package modelo;

public class Cama {
    //atributos
    private int codCama;
    private String tipoCama;
    
    /**
     * Constructor vacio:
     */
    public Cama() {
	
    }
    
    /*
     * Constructor Cama
     */
    public Cama(int codCama, String tipoCama) {
	super();
	this.codCama = codCama;
	this.tipoCama = tipoCama;
    }

    public int getCodCama() {
        return codCama;
    }

    public void setCodCama(int codCama) {
        this.codCama = codCama;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }
    
   public String toString() {
       return tipoCama;
   }
}

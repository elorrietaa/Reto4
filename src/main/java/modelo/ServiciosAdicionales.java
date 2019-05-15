package modelo;

public class ServiciosAdicionales {
	
	private boolean wifi;
	private boolean aire;
	private boolean piscina;
	private boolean spa;
	private boolean gimnasio;
	private boolean parking;
	private boolean restaurante;
	private boolean bar;
	
	private float precioWifi;
	private float precioAire;
	private float precioPiscina;
	private float precioSpa;
	private float precioGimnasio;
	private float precioParking;
	
	private boolean wifiSeleccionado;
	private boolean aireSeleccionado;
	private boolean piscinaSeleccionada;
	private boolean spaSeleccionado;
	private boolean gimnasioSeleccionado;
	private boolean parkingSeleccionado;
	
	public ServiciosAdicionales(int wifi, float precioWifi, int aire, float precioAire, int piscina, float precioPiscina, int spa, float precioSpa, int gimnasio, float precioGimnasio, int parking, float precioParking, int restaurante, int bar) {
		this.wifi = comprobarBoolean(wifi);
		this.aire = comprobarBoolean(aire);
		this.piscina = comprobarBoolean(piscina);
		this.spa = comprobarBoolean(spa);
		this.gimnasio = comprobarBoolean(gimnasio);
		this.parking = comprobarBoolean(parking);
		this.restaurante = comprobarBoolean(restaurante);
		this.bar = comprobarBoolean(bar);
		
		this.precioWifi = precioWifi;
		this.precioAire = precioAire;
		this.precioPiscina = precioPiscina;
		this.precioSpa = precioSpa;
		this.precioGimnasio = precioGimnasio;
		this.precioParking = precioParking;
	}
	
	public boolean isWifi() {
		return wifi;
	}
	
	public boolean isAire() {
		return aire;
	}
	
	public boolean isPiscina() {
		return piscina;
	}
	
	public boolean isSpa() {
		return spa;
	}
	
	public boolean isGimnasio() {
		return gimnasio;
	}
	
	public boolean isParking() {
		return parking;
	}
	
	public float getPrecioWifi() {
		return precioWifi;
	}
	
	public float getPrecioAire() {
		return precioAire;
	}
	
	public float getPrecioPiscina() {
		return precioPiscina;
	}
	
	public float getPrecioSpa() {
		return precioSpa;
	}
	
	public float getPrecioGimnasio() {
		return precioGimnasio;
	}
	
	public float getPrecioParking() {
		return precioParking;
	}
	
	public boolean isWifiSeleccionado() {
		return wifiSeleccionado;
	}
	
	public void setWifiSeleccionado(boolean wifiSeleccionado) {
		this.wifiSeleccionado = wifiSeleccionado;
	}
	
	public boolean isAireSeleccionado() {
		return aireSeleccionado;
	}
	
	public void setAireSeleccionado(boolean aireSeleccionado) {
		this.aireSeleccionado = aireSeleccionado;
	}
	
	public boolean isPiscinaSeleccionada() {
		return piscinaSeleccionada;
	}
	
	public void setPiscinaSeleccionada(boolean piscinaSeleccionada) {
		this.piscinaSeleccionada = piscinaSeleccionada;
	}
	
	public boolean isSpaSeleccionado() {
		return spaSeleccionado;
	}
	
	public void setSpaSeleccionado(boolean spaSeleccionado) {
		this.spaSeleccionado = spaSeleccionado;
	}
	
	public boolean isGimnasioSeleccionado() {
		return gimnasioSeleccionado;
	}
	
	public void setGimnasioSeleccionado(boolean gimnasioSeleccionado) {
		this.gimnasioSeleccionado = gimnasioSeleccionado;
	}
	
	public boolean isParkingSeleccionado() {
		return parkingSeleccionado;
	}
	
	public void setParkingSeleccionado(boolean parkingSeleccionado) {
		this.parkingSeleccionado = parkingSeleccionado;
	}
	
	public boolean comprobarBoolean(int num) {
		if(num == 1)
			return true;
		else
			return false;
	}
}
package modelo;

public class ServiciosAdicionales {
	
	private boolean wifi;
	private boolean aire;
	private boolean piscina;
	private boolean spa;
	private boolean gimnasio;
	private boolean parking;
	
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
	
	public ServiciosAdicionales(boolean wifi, boolean aire, boolean piscina, boolean spa, boolean gimnasio, boolean parking, float precioWifi, float precioAire, float precioPiscina, float precioSpa, float precioGimnasio, float precioParking) {
		this.wifi = wifi;
		this.aire = aire;
		this.piscina = piscina;
		this.spa = spa;
		this.gimnasio = gimnasio;
		this.parking = parking;
		
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
}
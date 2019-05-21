package modelo;
/**
 * Clase ServiciosAdicionales, guarda la información de los servicios adicionales que ofrece un alojamiento. Tambien guarda cuales de esos servicios han sido seleccionados por el usuario
 *
 */
public class ServiciosAdicionales {
	
	private int codAlojamiento;
	private int codServicios;
	private int codServiciosContratados;
	
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
	/**
	 * Constructor de la calse ServiciosAdicionales, recibe por parametro el resultado de diversas consultas a la base de datos
	 * 
	 * @param codServicios = Codigo que identifica una seleccion concreta de servicios hecha por un usuario para un alojamiento
	 * @param codAlojamiento = Codigo que referencia el alojamiento para el cual se han seleccionado los servicios
	 * @param wifi = Variable que indica si el alojamiento tiene WiFi disponible
	 * @param precioWifi = Variable que indica el precio del WiFi en el alojamiento seleccionado
	 * @param aire = Variable que indica si el alojamiento tiene aire acondicionado disponible
	 * @param precioAire = Variable que indica el precio del aire acondicionado en el alojamiento seleccionado
	 * @param piscina = Variable que indica si el alojamiento tiene piscina
	 * @param precioPiscina = Variable que indica el precio por utilizar la piscina en el alojamiento seleccionado
	 * @param spa = Variable que indica si el alojamiento cuenta con un spa
	 * @param precioSpa = Variable que indica el precio por utilizar el spa en el alojamiento seleccionado
	 * @param gimnasio = Variable que indica si el alojamiento cuenta con un gimnasio
	 * @param precioGimnasio = Variable que indica el precio por utilizar el gimnasio del alojamiento seleccinado
	 * @param parking = Variable que indica si el alojamiento dispone de un parking
	 * @param precioParking = Variable que indica el precio por utilizar el parking del alojamieto seleccionado
	 * @param restaurante = Variable que indica si el alojamiento dispone de un restaurante
	 * @param bar = Variable que indica si el alojamiento dispone de un bar
	 */
	public ServiciosAdicionales(int codServicios ,int codAlojamiento, int wifi, float precioWifi, int aire, float precioAire, int piscina, float precioPiscina, int spa, float precioSpa, int gimnasio, float precioGimnasio, int parking, float precioParking, int restaurante, int bar) {
		this.codServicios = codServicios;
		this.codAlojamiento = codAlojamiento;
		
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
	/**
	 * Metodo que devuelve true o false dependiendo de la disponibilidad del WiFi
	 * 
	 * @return Retorna true o false dependiendo de la disponibilidad del WiFi
	 */
	public boolean isWifi() {
		return wifi;
	}
	/**
	 * Metodo que devuelve true o false dependiendo de la disponibilidad del aire acondicionado
	 * 
	 * @return Retorna true o false dependiendo de la disponibilidad del aire acondicionado
	 */
	public boolean isAire() {
		return aire;
	}
	/**
	 * Metodo que devuelve true o false dependiendo de la disponibilidad de la piscina
	 * 
	 * @return Retorna true o false dependiendo de la disponibilidad de la piscina
	 */
	public boolean isPiscina() {
		return piscina;
	}
	/**
	 * Metodo que devuelve true o false dependiendo de la disponibilidad del spa
	 * 
	 * @return Retorna true o false dependiendo de la disponibilidad del spa
	 */
	public boolean isSpa() {
		return spa;
	}
	/**
	 * Metodo que devuelve true o false dependiendo de la disponibilidad del gimnasio
	 * 
	 * @return Retorna true o false dependiendo de la disponibilidad del gimnasio
	 */
	public boolean isGimnasio() {
		return gimnasio;
	}
	/**
	 * Metodo que devuelve true o false dependiendo de la disponibilidad del parking
	 * 
	 * @return Retorna true o false dependiendo de la disponibilidad del parking
	 */
	public boolean isParking() {
		return parking;
	}
	/**
	 * Metodo que devuelve el precio del WiFi para el alojamiento seleccionado
	 * 
	 * @return Retorna el precio del WiFi
	 */
	public float getPrecioWifi() {
		return precioWifi;
	}
	/**
	 * Metodo que devuelve el precio del aire acondicionado para el alojamiento seleccionado
	 * 
	 * @return Retorna el precio del aire acondicionado
	 */
	public float getPrecioAire() {
		return precioAire;
	}
	/**
	 * Metodo que devuelve el precio por utilizar la piscina para el alojamiento seleccionado
	 * 
	 * @return Retorna el precio por utilizar la piscina
	 */
	public float getPrecioPiscina() {
		return precioPiscina;
	}
	/**
	 * Metodo que devuelve el precio por utilizar el spa para el alojamiento seleccionado
	 * 
	 * @return Retorna el precio por utilizar el spa
	 */
	public float getPrecioSpa() {
		return precioSpa;
	}
	/**
	 * Metodo que devuelve el precio por utilizar el gimnasio para el alojamiento seleccionado
	 * 
	 * @return Retorna el precio por utilizar el gimnasio
	 */
	public float getPrecioGimnasio() {
		return precioGimnasio;
	}
	/**
	 * Metodo que devuelve el precio por utilizar el parking para el alojamiento seleccionado
	 * 
	 * @return Retorna el precio por utilizar el parking
	 */
	public float getPrecioParking() {
		return precioParking;
	}
	/**
	 * Metodo que devuelve true o false dependiendo de si el usuario a seleccionado o no el servicio WiFI
	 * 
	 * @return Retorna true o false dependiendo de la seleccion del usuario
	 */
	public boolean isWifiSeleccionado() {
		return wifiSeleccionado;
	}
	/**
	 * Metodo que sirve para guardar la seleccion del servicio WiFi por parte del usuario
	 * 
	 * @param wifiSeleccionado = Establece si el wifi ha sido o no seleccionado por el usuario
	 */
	public void setWifiSeleccionado(boolean wifiSeleccionado) {
		this.wifiSeleccionado = wifiSeleccionado;
	}
	/**
	 * Metodo que devuelve true o false dependiendo de si el usuario a seleccionado o no el servicio aire acondicionado
	 * 
	 * @return Retorna true o false dependiendo de la seleccion del usuario
	 */
	public boolean isAireSeleccionado() {
		return aireSeleccionado;
	}
	/**
	 * Metodo que sirve para guardar la seleccion del servicio aire acondicionado por parte del usuario
	 * 
	 * @param aireSeleccionado = Establece si el aire acondicionado ha sido o no seleccionado por el usuario
	 */
	public void setAireSeleccionado(boolean aireSeleccionado) {
		this.aireSeleccionado = aireSeleccionado;
	}
	/**
	 * Metodo que devuelve true o false dependiendo de si el usuario a seleccionado o no el servicio piscina
	 * 
	 * @return Retorna true o false dependiendo de la seleccion del usuario
	 */
	public boolean isPiscinaSeleccionada() {
		return piscinaSeleccionada;
	}
	/**
	 * Metodo que sirve para guardar la seleccion del servicio piscina por parte del usuario
	 * 
	 * @param piscinaSeleccionada = Establece si el servicio de piscina ha sido o no seleccionado por el usuario
	 */
	public void setPiscinaSeleccionada(boolean piscinaSeleccionada) {
		this.piscinaSeleccionada = piscinaSeleccionada;
	}
	/**
	 * Metodo que devuelve true o false dependiendo de si el usuario a seleccionado o no el servicio spa
	 * 
	 * @return Retorna true o false dependiendo de la seleccion del usuario
	 */
	public boolean isSpaSeleccionado() {
		return spaSeleccionado;
	}
	/**
	 * Metodo que sirve para guardar la seleccion del servicio spa por parte del usuario
	 * 
	 * @param spaSeleccionado = Establece si el servicio de spa ha sido o no seleccionado por el usuario
	 */
	public void setSpaSeleccionado(boolean spaSeleccionado) {
		this.spaSeleccionado = spaSeleccionado;
	}
	/**
	 * Metodo que devuelve true o false dependiendo de si el usuario a seleccionado o no el servicio gimnasio
	 * 
	 * @return Retorna true o false dependiendo de la seleccion del usuario
	 */
	public boolean isGimnasioSeleccionado() {
		return gimnasioSeleccionado;
	}
	/**
	 * Metodo que sirve para guardar la seleccion del servicio gimnasio por parte del usuario
	 * 
	 * @param gimnasioSeleccionado = Establece si el servicio de gimnasio ha sido o no seleccionado por el usuario
	 */
	public void setGimnasioSeleccionado(boolean gimnasioSeleccionado) {
		this.gimnasioSeleccionado = gimnasioSeleccionado;
	}
	/**
	 * Metodo que devuelve true o false dependiendo de si el usuario a seleccionado o no el servicio parking
	 * 
	 * @return Retorna true o false dependiendo de la seleccion del usuario
	 */
	public boolean isParkingSeleccionado() {
		return parkingSeleccionado;
	}
	/**
	 * Metodo que sirve para guardar la seleccion del servicio parking por parte del usuario
	 * 
	 * @param parkingSeleccionado = Establece si el servicio de parking ha sido o no seleccionado por el usuario
	 */
	public void setParkingSeleccionado(boolean parkingSeleccionado) {
		this.parkingSeleccionado = parkingSeleccionado;
	}
	/**
	 * Este metodo se utiliza para comprobar los servicios de que alojamiento estan almacenado, de esta manera se puede comprobar si los servicios seleccionados coinciden con el alojamiento seleccionado
	 * 
	 * @return Retorna el codigo del alojamiento para el cual son los servicios almacenados en el objeto
	 */
	public int getCodAlojamiento() {
		return this.codAlojamiento;
	}
	/**
	 * Metodo utilizado para interpretar los resultados del select de servicios, ya que en lugar de un booleano, devuelve 1 o 0 dependiendo de si es true o false, este metodo comprueba el numero y devuelve
	 * el resultado en forma de booleano
	 * 
	 * @param num = Numero que se quiere comprobar
	 * @return Retorna true si el numero introducido es 1 y false si el numero introducido es 0
	 */
	public boolean comprobarBoolean(int num) {
		if(num == 1)
			return true;
		else
			return false;
	}
	/**
	 * Metodo utilizado para devolver el codigo referente a la contratacion de servicios por el usuario actual para un alojamiento
	 * 
	 * @return Retorna el codigo identificador de la lista de servicios contratados
	 */
	public int getCodServiciosContratados() {
		return codServiciosContratados;
	}
	/**
	 * Metodo utilizado para establecer un codigo identificador a la lista de servicios contratados por el usuario actual, mediente una consulta a la base de datos, recibe la cantidad de entradas
	 * que hay en la tabla de servicios contratados en la base de datos, a la cual le suma 1, lo que seirve como codigo identificados para una contratacion concreta
	 * 
	 * @param codServiciosContratados = Codigo que una seleccion de servicios a contratar concreta
	 */
	public void setCodServiciosContratados(int codServiciosContratados) {
		this.codServiciosContratados = codServiciosContratados + 1;
	}
	/**
	 * Metodo que devuelve el codigo de la lista de servicios adicionales disponibles guardados en el objeto
	 * 
	 * @return Retorna el codigo de la lista de servicios guardados en el objeto
	 */
	public int getCodServicios() {
		return codServicios;
	}
}
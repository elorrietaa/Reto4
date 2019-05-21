package controlador;

//import java.sql.Date;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import modelo.Cama;
import modelo.Casa;
import modelo.Dormitorio;
import modelo.Habitacion;
import modelo.PrincipalModelo;
import modelo.Reserva;
import modelo.TipoAlojamiento;
import vista.JframePrincipal;

public class FuncionesReserva {

	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	public float precioHabitacion;
	public float precioReserva;
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	Date inicioEstival = null;
	Date finEstival = null;
	public ArrayList<Habitacion> listaHabitaciones;

	/**
	 * Constructor de la clase FuncionesPago
	 * 
	 * @param modelo Instancia de la clase modelo para poder utilizarlo
	 */
	public FuncionesReserva(PrincipalModelo modelo, JframePrincipal vista, PrincipalControlador controlador) {
		this.modelo = modelo;
		this.controlador = controlador;
		this.vista = vista;
	}

	/**
	 * Metodo para calcular el precio de la reserva del hotel
	 * 
	 * @param reserva Objeto con la informacion de la reserva
	 * 
	 * @return Retorna el precio de la reserva
	 */
	public float calcularPrecioTotalFinalReserva(TipoAlojamiento tiposAloj) {
		float precioReserva = 0;

		// (1º) el precio de la casa/apartamento en función del NÚMERO DE NOCHES
		// seleccionadas por el usuario Y DE LA TARIFA (y festivos)
		if (tiposAloj.getCodTipoAlojamiento() == 10) {
			precioReserva = precioReserva + calcularPrecioPorTarifa(tiposAloj, modelo.habitacion.getPrecioHabitacion()); // en este caso se coge el precio de la habitacion no del hotel
		} else if (tiposAloj.getCodTipoAlojamiento() == 20) {
			precioReserva = precioReserva + calcularPrecioPorTarifa(tiposAloj, modelo.casa.getPrecioAlojamiento());
		} else if (tiposAloj.getCodTipoAlojamiento() == 30) {
			precioReserva = precioReserva
					+ calcularPrecioPorTarifa(tiposAloj, modelo.apartamento.getPrecioAlojamiento());
		}
		// Sumamos el precio de los servicios que ha seleccionado el cliente
		precioReserva = precioReserva + modelo.precioServicios;
		vista.detallesReservaCasaApart.textPaneDetServAdic
				.setText("Precio servicios adicionales: " + modelo.precioServicios + " €");

		// (2º)Redondeamos a 2 decimales
		precioReserva = Math.round(precioReserva * 100); // redondear a dos decimales
		precioReserva = precioReserva / 100;// redondear a dos decimales

		// (3º) metemos el precio total de la reserva en el modelo:
		modelo.precioTotal = precioReserva;

		return precioReserva;
	}

	/**
	 * Método calcularNochesReservadas = calcula el número de noches reservadas por
	 * el usuario.
	 * 
	 * @return numNoches
	 */
	public int calcularNochesReservadas() {
		int numNoches = (int) ((modelo.fechaVuelta.getTime() - modelo.fechaIda.getTime()) / 86400000);

		// metemos el número de noches en el modelo:
		modelo.numNoches = numNoches;

		// mostramos num de noches en la vista
		vista.detallesReserva.textFieldNumNoches.setText(Integer.toString(modelo.numNoches));

		return numNoches;
	}
	
	public float calcularPrecioPorTarifa(TipoAlojamiento tiposAloj, float precioAloj) {
		// Se rellena el array NumNochesPorTarifa
		int[] NumNochesPorTarifa = calcularNumNochesPorTarifa(precioAloj);
		float suplementoFestivos = calcularSuplementoFestivos(precioAloj);

		// el precio precioTarifaAplicada = (noches tarifa normal * precioAloj) +
		// (noches estivales * el precioAloj + un 12% el precio del alojamiento) +
		// (noches festivos * el precioAloj y un 20% más)
		float precioTarifaNormal = (NumNochesPorTarifa[0] * precioAloj);
		float precioTarifaEstival = (float) (NumNochesPorTarifa[1] * (precioAloj * 1.12));
		float precioTarifaFestivo = (float) (NumNochesPorTarifa[2] * (suplementoFestivos));

		float precioTarifaAplicada = precioTarifaNormal + precioTarifaEstival + precioTarifaFestivo;

		int numNoches = calcularNochesReservadas();

		// muestra los detalles de la tarifa aplicada, el número de noches y el precio
		// en detallesReservaCasaApart
		mostrarDetTipoTarifaCasApart(NumNochesPorTarifa, precioAloj, precioTarifaNormal, precioTarifaEstival,
				precioTarifaAplicada, numNoches);

		return precioTarifaAplicada;
	}


	public float calcularSuplementoFestivos(float precioAloj) {
		float suplementoFestivos = 0;

		suplementoFestivos = (float) (precioAloj * 0.20);

		return suplementoFestivos;
	}

	
	/**
	 * Método mostrarDetTipoTarifaCasApart = se muestran en vista.detallesReservaCasaApart los detalles de la tarifa aplicada al precio.
	 * @param NumNochesPorTarifa contiene el numero de noches de cada tarifa
	 * @param precioAloj contiene el precio del alojamiento
	 * @param precioTarifaNormal contiene el precio de la tarifa normal
	 * @param precioTarifaEstival contiene le precio de la tarifa estival
	 * @param precioTarifaAplicada contiene el precio de la tarifa aplicada
	 * @param numNoches contiene el número d enoches total de la reserva
	 */
	public void mostrarDetTipoTarifaCasApart(int[] NumNochesPorTarifa, float precioAloj, float precioTarifaNormal,
			float precioTarifaEstival, float precioTarifaAplicada, int numNoches) {
		vista.detallesReservaCasaApart.textDetTarifa.setText(
				(String) "ATENCIÓN: El precio de los alojamiento puede variar en función de las fechas seleccionadas."
						+ "\n" + " A continuación se muestran los detalles de las tarifas aplicada a su selección: "
						+ "\n" + "TARIFA NORMAL: Número de noches: " + NumNochesPorTarifa[0] + " Precio 1 noche: "
						+ precioAloj + "€ Precio: " + +NumNochesPorTarifa[0] + " noches: "
						+ (String.format("%.2f", precioTarifaNormal)) + "€" + "\n"
						+ "TARIFA ESTIVAL: Número de noches: " + NumNochesPorTarifa[1] + " Precio 1 noche: "
						+ (String.format("%.2f", (precioAloj * 1.12))) + "€ Precio: " + NumNochesPorTarifa[1]
						+ " noches: " + (String.format("%.2f", precioTarifaEstival)) + "€" + "\n");
		vista.detallesReservaCasaApart.textDetPrecioFinal.setText((String) "El precio final tras aplicar las tarifas para su reserva de " + numNoches
						+ " noches es de: " + (String.format("%.2f", precioTarifaAplicada)) + "€");
	}

	/**
	 * Método calcularNumNochesPorTarifa = calcula el número de noches a las que se le aplica la tarifa normal y el número de noches a las que se aplica la  tarifa estival
	 * 
	 * @return NumNochesPorTarifa = es un array que contiene en su primera posición [0] el número de noches a las que se aplica la tarifa normal y en [1] 
	 * el número de noches a las que se aplica la tarifa estival
	 */
	public int[] calcularNumNochesPorTarifa(float precioAloj) {
		// Declaración e inicialización de variables:
		int numNochesNormal = 0;
		int numNochesEstival = 0;
		int numNochesFestivos = 0;

		int mesIda = vista.buscarAlojamiento.fechaIda.getMonthChooser().getMonth();
		int mesVuelta = vista.buscarAlojamiento.fechaVuelta.getMonthChooser().getMonth();

		int[] NumNochesPorTarifa = new int[3];

		// Definimos el inicio y el fin de la tarifa estival
		definirInicioFinTarifaEstival();

		// calculamos el número de noche de festivos
		numNochesFestivos = calcularNumNochesFestivos(precioAloj);

		// Se pueden dar 4 posibilidades en cuanto a la TARIFA ESTIVAL, porque la
		// reserva máxima que se puede hacer es de 30 días, sino habría cuatro
		// posibilidades.
		// Nota: los meses van de 0 a 11.

		// 1º Posibilidad: que toda la reserva esté en tarifa estival: mes entrada >=
		// Junio y mes salida <= Septiembre
		if (mesIda >= 5 && mesVuelta <= 8) {
			numNochesEstival = (int) ((modelo.fechaVuelta.getTime() - modelo.fechaIda.getTime()) / 86400000);
		}

		// 2º Posibilidad: Que la primera parte de la reserva seatarifa normal y la
		// última tarifa estival.
		else if (mesIda < 5 && (mesVuelta >= 5 && mesVuelta <= 8)) {
			numNochesEstival = (int) ((inicioEstival.getTime() - modelo.fechaIda.getTime()) / 86400000) + 1;
			numNochesNormal = (int) ((modelo.fechaVuelta.getTime() - inicioEstival.getTime()) / 86400000);
		}

		// 3º Posibilidad: Que la primera parte de la reserva no sea tarifa estival y la
		// última sea tarifa estival.
		else if ((mesIda >= 5 && mesIda <= 8) && (mesVuelta > 8)) {
			numNochesEstival = (int) ((finEstival.getTime() - modelo.fechaIda.getTime()) / 86400000) + 1;
			numNochesNormal = (int) ((modelo.fechaVuelta.getTime() - finEstival.getTime()) / 86400000);
		} else {
			numNochesNormal = (int) ((modelo.fechaVuelta.getTime() - modelo.fechaIda.getTime()) / 86400000);
		}

		// se rellena el array
		NumNochesPorTarifa[0] = numNochesNormal;
		NumNochesPorTarifa[1] = numNochesEstival;
		NumNochesPorTarifa[2] = numNochesFestivos;

		return NumNochesPorTarifa;
	}

	/**
	 * Método calcularNumNochesFestivos = calcula el número de noches a los que se
	 * le aplicará la tarifa festivo en las fechas seleccionadas por el usuario.
	 * 
	 * @param precioAloj es el precio de alojamiento sin servicios.
	 * @return numNochesFestivos
	 */
	public int calcularNumNochesFestivos(float precioAloj) {
		int numNochesFestivos = 0;
		String nombreFestivosReser = "";

		int diaIda = vista.buscarAlojamiento.fechaIda.getDayChooser().getDay();
		int diaVuelta = vista.buscarAlojamiento.fechaVuelta.getDayChooser().getDay();
		int mesIda = vista.buscarAlojamiento.fechaIda.getMonthChooser().getMonth();
		int mesVuelta = vista.buscarAlojamiento.fechaVuelta.getMonthChooser().getMonth();

		// NO VA // Object [] arrayDatosFestivos =
		// modelo.fechasTarifas.arrayDatosFestivos;
		int[] diasFestivos = modelo.fechasTarifas.diasFestivos; // array con los días festivos
		int[] mesesFestivos = modelo.fechasTarifas.mesesFestivos; // array con los meses festivos
		String[] nombreFestivos = modelo.fechasTarifas.nombreFestivos; // array con el nombre de los festivos

		// Teniendo en cuenta que las reservas que se pueden realizar son máximo de 30
		// días
		// EXPLICACIÓN FÓRMULA: El festivo está en el rango de fechas seleccionadas si:
		// La fechaIdaSeleccionada coincide con fechafestivo || (mesSeleccionado == mes
		// anterior al mes festivo || mesSeleccionado == mesFestivo) && (mesSeleccionado
		// == mes festivo || mesSeleccionado == mes siguiente al mesFestivo)

		for (int i = 0; i < modelo.fechasTarifas.diasFestivos.length; i++) { // se recorren todos los festivos
			// si reserva la ida el mes anterior al festivo y la vuelta un mes después del
			// festivo, significa que ha reservado el festivo
			if (diaIda == diasFestivos[i] && mesIda == mesesFestivos[i]
					|| (mesIda == (mesesFestivos[i] - 1) || diaIda <= diasFestivos[i] && mesIda == mesesFestivos[i])
							&& (diaVuelta >= diasFestivos[i] && mesVuelta == mesesFestivos[i]
									|| mesVuelta == (mesesFestivos[i] + 1))) {
				numNochesFestivos = numNochesFestivos + 1; // si se comple la condición, se añade una noche al número de
															// noches festivos
				nombreFestivosReser = nombreFestivosReser + " Día: " + diasFestivos[i] + " - " + " Mes: "
						+ (mesesFestivos[i] + 1) + " - " + " Festivo: " + nombreFestivos[i]; // se añade el nombre del festivo a nombreFestivosReser
			}
		}

		// Los festivos de los meses enero y diciembre se tratan aparte porque el for no
		// los contempla.
		if (diaIda == 1 && mesIda == 0 || (mesIda == 11 && mesVuelta == 0)) { // FESTIVO AÑO NUEVO 1-01 .El mes de Enero (posición 0) es especial por ser el anterior el mes dic(posicion11)
			numNochesFestivos = numNochesFestivos + 1;
			nombreFestivosReser = nombreFestivosReser + " Día: " + 1 + " - " + " Mes: " + 1 + " - " + " Festivo: "
					+ "Año Nuevo";
		} else if (diaIda == 6 && mesIda == 0 || (mesIda == 11 || diaIda <= 6 && mesIda == 0)
				&& (diaVuelta >= 6 && mesVuelta == 0 || mesVuelta == 1)) { // FESTIVO REYES 6-01 .El mes de Enero (posición 0) es especial por ser el anterior el mes dic(posicion11)
			numNochesFestivos = numNochesFestivos + 1;
			nombreFestivosReser = nombreFestivosReser + " Día: " + 6 + " - " + " Mes: " + 1 + " - " + " Festivo: "
					+ "Día de Reyes";
		} else if (diaIda == 8 && mesIda == 11 || (mesIda == 10 || diaIda <= 8 && mesIda == 11)
				&& (diaVuelta >= 8 && mesVuelta == 11 || mesVuelta == 0)) { // FESTIVO DIA DE LA CONCEPCION 6-11 .El mes de diciembre (posición 11) es especial por ser el posterior al mes enero(posicion0)
			numNochesFestivos = numNochesFestivos + 1;
			nombreFestivosReser = nombreFestivosReser + " Día: " + 8 + " - " + " Mes: " + 12 + " - " + " Festivo: "
					+ "La Inmaculada Concepción";
		} else if (diaIda == 25 && mesIda == 11 || (mesIda == 10 || diaIda <= 25 && mesIda == 11)
				&& (diaVuelta >= 25 && mesVuelta == 11 || mesVuelta == 0)) { // FESTIVO NAVIDAD 25-11 .El mes de diciembre (posición 11) es especial por ser el posterior al mes enero(posicion0)
			numNochesFestivos = numNochesFestivos + 1;
			nombreFestivosReser = nombreFestivosReser + " Día: " + 25 + " - " + " Mes: " + 12 + " - " + " Festivo: "
					+ "Navidad";
		}
		// FALTA se mete el nombreFestivosReser en el modelo.reserva o se muestra en un jtext

		if (numNochesFestivos > 0) {
			float suplementoFestivos = calcularSuplementoFestivos(precioAloj);
			vista.detallesReservaCasaApart.textDetFestivos.setText((String) "Además, su reserva incluye "
					+ numNochesFestivos + " festivos:" + "\n" + nombreFestivosReser + "Suplemento por festivo: "
					+ (String.format("%.2f", (precioAloj * 0.20)) + "€" + "\n"));
		}

		return numNochesFestivos;
	}

	/*
	 * Método definirInicioFinTarifaEstival = define la fecha deinicio y la fecha
	 * final de la tarifa estival
	 */
	private void definirInicioFinTarifaEstival() {
		// Definimos el inicio y el fin de la tarifa estival
		String sInicioEstival = "2019-06-01";
		String sFinEstival = "2019-10-01";
		try {
			inicioEstival = formato.parse(sInicioEstival);
			finEstival = formato.parse(sFinEstival);
		} catch (ParseException ex) {
			System.out.println(ex);
		}
	}

	public void mostrarFechaYHoraActual() {
		// se consulta la fehca y la hora actual en sql
		Date fechaActual = (modelo.consultas.mostrarFechaActual());
		Date horaActual1 = modelo.consultas.mostrarHoraActual();

		// se le da formato a la hora
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String horaActual = dateFormat.format(horaActual1);

	}

	/**
	 * Método: guardarReservaAlojamiento = Genera la reserva de la casa/alojamientoy la guarda en modelo.reserva
	 * 
	 * @param tiposAloj es el tipo de alojamiento(hotel,casa,apartamento).
	 */
	public void guardarReservaAlojamiento(TipoAlojamiento tiposAloj) {

		// se calcula el codigo de reserva que corresponde a esta reserva
		int codReserva = modelo.consultas.mostrarNumReservas();

		// metemos los datos en la reserva
		modelo.reserva = new Reserva();
		codReserva = codReserva + 1;
		modelo.reserva.setCodReserva(codReserva);
		modelo.reserva.setCliente(modelo.cliente);

		// se guarda el alojamiento en la reserva, diferenciando si es una casa o un
		// apartamento
		if (tiposAloj.getCodTipoAlojamiento() == 10) {
			modelo.reserva.setAlojamiento(modelo.hotel);
			modelo.reserva.setHabitacion(modelo.habitacion);

		} else if (tiposAloj.getCodTipoAlojamiento() == 20) {
			modelo.reserva.setAlojamiento(modelo.casa);
		} else if (tiposAloj.getCodTipoAlojamiento() == 30) {
			modelo.reserva.setAlojamiento(modelo.apartamento);
		}

		modelo.reserva.setFechaIda(modelo.fechaIda);
		modelo.reserva.setFechaVuelta(modelo.fechaVuelta);
		modelo.reserva.setPrecioReserva(calcularPrecioTotalFinalReserva(tiposAloj));

	}

	/**
	 * Método mostrarDatosReservacasaApart = muestra los datos de la reserva. Los
	 * datos de la reserva son aquellos datos seleccionados por el usuario.
	 * 
	 * @param tiposAloj Variable que guarda un valor numerico referente al tipo de alojamiento
	 */
	public void mostrarDatosReservaAloj(TipoAlojamiento tiposAloj) {
		// muestra el nombre del alojamiento
		vista.detallesReservaCasaApart.textPaneNombreAloj.setText((String) modelo.reserva.getAlojamiento().getNombre());

		// muestra datos del alojamiento
		vista.detallesReservaCasaApart.textPDatosAlo.setText((String) "Ciudad: " + modelo.reserva.getAlojamiento().getUbicacion()
						+ " Código del alojamiento: " + modelo.reserva.getAlojamiento().getCodAlojamiento() + "\n"
						+ "Dirección: " + modelo.reserva.getAlojamiento().getDireccion() + "   " + "Teléfono: "
						+ modelo.reserva.getAlojamiento().getTelefono());

		// muestra los detalles de las habitaciones del alojamiento: cuales tiene y cuantas
		mostrarDatosHabsReservaCasaApart();

		// mostramos num de noches en la vista
		vista.detallesReservaCasaApart.textFieldNumNoches.setText(Integer.toString(modelo.numNoches));

		// muestra el PRECIO TOTAL DE LA RESERVA:
		calcularPrecioTotalFinalReserva(tiposAloj);

		// SE MUESTRA EL PRECIO TOTAL:
		vista.detallesReservaCasaApart.tFPrecioReserva.setText((String.format("%.2f", modelo.precioTotal)) + " €");
	}

	/*
	 * Método mostrarDatosHabsReservaCasaApart = muestra los detalles de las
	 * habitaciones del alojamiento: cuales tiene y cuantas
	 */
	public void mostrarDatosHabsReservaCasaApart() {
		// muestra los detalles de las habitaciones del alojamiento: cuales tiene y cuantas
		int[] arrayNumHabitaciones = guardarNumHabTipoDeCasaApart();
		String[] arrayNombreHabitaciones = { " dormitorios, ", " baños, ", " sala, ", " comedor, ", " cocina, ",
				" balcon, ", " garaje." };

		String textoDetHabs = " ";

		for (int i = 0; i < arrayNumHabitaciones.length; i++) {
			if (arrayNumHabitaciones[i] > 0) {
				textoDetHabs = textoDetHabs + arrayNumHabitaciones[i] + " " + arrayNombreHabitaciones[i];
			}
		}

		vista.detallesReservaCasaApart.textFieldDetHabs.setText((String) textoDetHabs);

	}

	/*
	 * Método generarFicherosReservasHabitacionesSel = genera un fichero por cada
	 * habitación de hotel reservada.
	 */
	public void generarFicherosReservasHabitacionesSel() {
		// guarda los datos de la reserva en en un fichero, 1 reserva por cada
		// habitación.
		for (int i = 0; modelo.listaReservas.size() > i; i++) {
			modelo.funcionesFichero.imprimirReservaHabitacionesHotel(modelo, vista, i);
		}
	}

	/*
	 * Método generarFicherosReservasHabitacionesSel = genera un fichero para la
	 * habitación de hotel reservada.
	 */
	public void generarFicherosReserva1HabHotel() {
		// guarda los datos de la reserva en en un fichero
		modelo.funcionesFichero.imprimirReserva1HabHotel(modelo, vista);
	}

	/*
	 * Método generarFicherosReservaCasa = guarda los datos de la reserva en en un
	 * fichero
	 */
	public void generarFicherosReservaCasa() {
		// guarda los datos de la reserva en en un fichero
		modelo.funcionesFichero.imprimirReservaFicheroCasa(modelo, vista);
	}

	/*
	 * Método generarFicherosReservaApart = guarda los datos de la reserva en en un
	 * fichero
	 */
	public void generarFicherosReservaApart() {
		// guarda los datos de la reserva en en un fichero
		modelo.funcionesFichero.imprimirReservaFicheroApart(modelo, vista);
	}

	/**
	 * Método: mostrarTiposDeCamas devuelve un String que contiene el número de
	 * camas de cada tipo que hay.
	 * 
	 * @param listaCamas Array list con la lista de camas de la habitación seleccionada
	 * @return tiposCamaHab
	 */
	public String mostrarTiposDeCamas(ArrayList<Cama> listaCamas) {
		String tiposCamaHab = "";
		int numTipCam[] = new int[3];

		for (int i = 0; listaCamas.size() > i; i++) {
			if (listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("simple")) {
				numTipCam[0] = numTipCam[0] + 1;
			} else if (listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("matrimonio")) {
				numTipCam[1] = numTipCam[1] + 1;
			} else if (listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("infantil")) {
				numTipCam[2] = numTipCam[2] + 1;
			}
			System.out.println(listaCamas.get(i).getTipoCama().toString());

		}
		// se rellena el String con los tipos de cama
		tiposCamaHab = numTipCam[0] + " simple, " + numTipCam[1] + " matrimonio y " + numTipCam[2] + " infantil.";

		return tiposCamaHab;
	}

	/**
	 * El método guardarNumHabTipoDeCasaApart rellena un array arrayNumHabitaciones que contiene el número de habitaciones de cada tipo de
	 * habitacion y lo guarda en el modelo
	 * 
	 * @return arrayNumHabitaciones
	 */
	public int[] guardarNumHabTipoDeCasaApart() {
		String detallesHabs = "";

		int numDormitorios = 0;
		int numBanos = 0;
		int numSalas = 0;
		int numComedores = 0;
		int numCocinas = 0;
		int numBalcones = 0;
		int numGarajes = 0;
		// array que contiene el nombre de las habitaciones
		String[] arrayNombreHabitaciones = { "DORMITORIO", "BAÑO", "SALA", "COMEDOR", "COCINA", "BALCON", "GARAJE" };
		// rellenamos el arrayNumHabitaciones;
		int[] arrayNumHabitaciones = { numDormitorios, numBanos, numSalas, numComedores, numCocinas, numBalcones,
				numGarajes };

		// se muestra la lista de habitaciones en función de si es Casa o Apartamento
		if (modelo.casa != null) {
			listaHabitaciones = modelo.consultas.buscarHabitacionPorCodigoAlojamiento(modelo.casa,
					modelo.casa.getCodAlojamiento());

			for (int i = 0; i < arrayNombreHabitaciones.length; i++) {
				arrayNumHabitaciones[i] = modelo.consultas.buscarNumHabDeCadaTipo(modelo.casa.getCodAlojamiento(),
						arrayNombreHabitaciones[i]);
			}

		}
		if (modelo.apartamento != null) {
			listaHabitaciones = modelo.consultas.buscarHabitacionPorCodigoAlojamiento(modelo.apartamento,
					modelo.apartamento.getCodAlojamiento());

			for (int i = 0; i < arrayNombreHabitaciones.length; i++) {
				arrayNumHabitaciones[i] = modelo.consultas
						.buscarNumHabDeCadaTipo(modelo.apartamento.getCodAlojamiento(), arrayNombreHabitaciones[i]);
			}
		}

		return arrayNumHabitaciones;
	}

	/**
	 * Método: mostrarOcupacionHab = devuelve un int que contiene el número de
	 * ocupantes de la habitacion
	 * 
	 * @param listaCamas Array list que almacena la lista de camas para la habitación seleccionada
	 * @return ocupacion
	 */
	public int mostrarOcupacionHab(ArrayList<Cama> listaCamas) {
		int ocupacion = 0;
		int numTipCam[] = new int[3];

		for (int i = 0; listaCamas.size() > i; i++) {
			if (listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("simple")) {
				numTipCam[0] = numTipCam[0] + 1;
			} else if (listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("matrimonio")) {
				numTipCam[1] = numTipCam[1] + 1;
			} else if (listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("infantil")) {
				numTipCam[2] = numTipCam[2] + 1;
			}

		}
		// se rellena la variable ocupacion con el numero de ocupantes de las camas de
		// la habitacion
		ocupacion = numTipCam[0] * 1 + numTipCam[1] * 2 + numTipCam[2] * 1;

		return ocupacion;
	}

}

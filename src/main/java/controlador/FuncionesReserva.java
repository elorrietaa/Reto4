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
/*
	//int aino=2019;
	//Date inicioEstival = new Date(1-06-aino);
	String sInicioEstival = "2019-06-01" ;
	Date finEstival = new Date(2019-10-01);
	try {
	    
	    Date inicioEstival = sdf.parse(sInicioEstival);
		
	} 
	catch(ParseException ex){
	    ex.printStackTrace();
	}
*/	
	/**
	 * Constructor de la clase FuncionesPago
	 * 
	 * @param modelo Instancia de la clase modelo para poder utilizarlo
	 */
	public FuncionesReserva (PrincipalModelo modelo,JframePrincipal vista, PrincipalControlador controlador) {
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
	public float calcularPrecioReservaCasApart(TipoAlojamiento tiposAloj) {
		float precioReserva=0;
		
		//(1º) el precio de la casa/apartamento en función del NÚMERO DE NOCHES seleccionadas por el usuario Y DE LA TARIFA (y festivos)
		if(tiposAloj.getCodTipoAlojamiento() == 10) {	
			precioReserva = precioReserva + calcularPrecioPorTarifa(tiposAloj, modelo.habitacion.getPrecioHabitacion()); //en este caso se coge el precio de la habitacion no del hotel	
		}
		else if(tiposAloj.getCodTipoAlojamiento() == 20) {
			precioReserva = precioReserva + calcularPrecioPorTarifa(tiposAloj, modelo.casa.getPrecioAlojamiento());
		}
		else if(tiposAloj.getCodTipoAlojamiento() == 30) {
			precioReserva = precioReserva + calcularPrecioPorTarifa(tiposAloj, modelo.apartamento.getPrecioAlojamiento());
		}
		
		//(2º)Redondeamos a 2 decimales
		precioReserva = Math.round(precioReserva*100); //redondear a dos decimales
		precioReserva = precioReserva/100;//redondear a dos decimales
		
		//(3º) metemos el precio total de la reserva en el modelo:
		modelo.precioTotal = precioReserva;
		System.out.println("EL PRECIO TOTAL DE LA RESERVA de la CASA/APARTAMENTO ES "+modelo.precioTotal);
		
		return precioReserva;
	}
	
	/**
	 * Metodo para calcular el precio de la reserva del hotel
	 * 
	 * @param reserva Objeto con la informacion de la reserva
	 * 
	 * @return Retorna el precio de la reserva 
	 */
	public float calcularPrecioReservaHotel( ArrayList<Dormitorio> listaHabSeleccionadas) {
		float precioReserva=0;
		
		//(1º) el precio total de la reserva será la suma de los precios de las habitaciones seleccionadas
		for(int i=0; i<listaHabSeleccionadas.size();i++) {
			precioReserva = precioReserva + listaHabSeleccionadas.get(i).getPrecioHabitacion();
		}
		
		
		//(2º) calcular el precio en función del NÚMERO DE NOCHES seleccionadas por el usuario.
		int numNoches = calcularNochesReservadas();  
		
		precioReserva = precioReserva*numNoches;
		
		//(3º)Redondeamos a 2 decimales
		precioReserva = Math.round(precioReserva*100); //redondear a dos decimales
		precioReserva = precioReserva/100;//redondear a dos decimales
		
		//(4º) metemos el precio total de la reserva en el modelo:
		modelo.precioTotal = precioReserva;
		System.out.println("EL PRECIO TOTAL DE LA RESERVA DE TODAS LAS HABS DEL HOTEL ES calcularPrecioReservaHotel "+modelo.precioTotal);
		
		return precioReserva;
	}
	
	/** 
	 * Método calcularPrecioHabXNoches = calcula el precio de una habitación por el número de noches que se desea reservar
	 * @param listaHabSeleccionadas = se le pasa la lista con la shabitaciones seleccionadas
	 * @param pos = la posición que está recorriendo un for.
	 * @return
	 */
	public float calcularPrecioHabXNoches( ArrayList<Dormitorio> listaHabSeleccionadas, int pos) {
		float precioHabXnoches=0;
		 DecimalFormat f = new DecimalFormat("##.00");
		 
		//(1º) Calcular el precio en función del NÚMERO DE NOCHES seleccionadas por el usuario.
		int numNoches = calcularNochesReservadas();
		
		//calcular el precio de la habitacion x noches.
		precioHabXnoches = listaHabSeleccionadas.get(pos).getPrecioHabitacion() * numNoches;
		
		precioHabXnoches = Math.round(precioHabXnoches*100); //redondear a dos decimales
		precioHabXnoches = precioHabXnoches/100;//redondear a dos decimales
		
/*
		//CALCULA EL PRECIO DE LAS HABITACIONES EN FUNCIÓN DE LA TARIFA SELECCIONADA
		 precioHabXnoches = calcularPrecioPorTarifa(listaHabSeleccionadas.get(pos).getPrecioHabitacion() );
		*/		
		return precioHabXnoches;
	}
	
	
	/**
	 * Método calcularNochesReservadas = calcula el número de noches reservadas por el usuario.
	 */
	public int calcularNochesReservadas() { 
		int numNoches=(int) ((modelo.fechaVuelta.getTime()-modelo.fechaIda.getTime())/86400000);
		 
		//metemos el número de noches en el modelo:
		modelo.numNoches = numNoches;
		System.out.println("Noches reservadas:  "+modelo.numNoches);
		
		//mostramos num de noches en la vista 
		vista.detallesReserva.textFieldNumNoches.setText(Integer.toString(modelo.numNoches));
		
		return numNoches;
	}
	
	/**
	 * Método calcularPrecioPorTarifa = calcula el precio en función de las fechas seleccionadas aplicando el precio de la tarifa normal o tarifa estival en función del número de noches normales y numero de noches en fechas de tarifa estival seleccionadas
	 * @param precioAloj
	 * @param NumNochesPorTarifa = es un array que contiene en su primera posición [0] el número de noches a las que se aplica la tarifa normal y en [1] el número de noches a las que se aplica la tarifa estival
	 * @return
	 */
	
	public float calcularPrecioPorTarifa(TipoAlojamiento tiposAloj, float precioAloj) {
		 //Se rellena el array NumNochesPorTarifa
		  int [] NumNochesPorTarifa = calcularNumNochesPorTarifa(precioAloj);
		  float suplementoFestivos = calcularSuplementoFestivos(precioAloj);
		   
		 //el precio precioTarifaAplicada = (noches tarifa normal * precioAloj) + (noches estivales * el precioAloj + un 12% el precio del alojamiento) + (noches festivos * el precioAloj y un 20% más)
		  float precioTarifaNormal = (NumNochesPorTarifa[0] * precioAloj);
		  float precioTarifaEstival = (float) (NumNochesPorTarifa[1] * (precioAloj * 1.12));
		  float precioTarifaFestivo = (float) (NumNochesPorTarifa[2] * (suplementoFestivos));
		  
		  float precioTarifaAplicada = precioTarifaNormal + precioTarifaEstival + precioTarifaFestivo; 
		   
		  int numNoches = calcularNochesReservadas();  
		  
		 //muestra los detalles de la tarifa aplicada, el número de noches y el precio en detallesReservaCasaApart
		  mostrarDetTipoTarifaCasApart(NumNochesPorTarifa,  precioAloj, precioTarifaNormal, precioTarifaEstival, precioTarifaAplicada, numNoches);
		
		
		  return precioTarifaAplicada;
	}
	
	/**
	 * Método calcularSuplementoFestivos = calcula el suplemento a pagar por el cliente que escoja tarifa de festivo. 
	 * @param precioAloj
	 * @return
	 */
	public float calcularSuplementoFestivos(float precioAloj) {
		float suplementoFestivos =0;
		
		suplementoFestivos = (float) (precioAloj * 0.20);
		
		return suplementoFestivos;
	}
	
	/**
	 * Método mostrarDetTipoTarifaCasApart = se muestran en vista.detallesReservaCasaApart los detalles de la tarifa aplicada al precio.
	 * @param NumNochesPorTarifa
	 */
	public void mostrarDetTipoTarifaCasApart(int [] NumNochesPorTarifa, float precioAloj, float precioTarifaNormal, float precioTarifaEstival, float precioTarifaAplicada, int numNoches) {
		 vista.detallesReservaCasaApart.textDetTarifa.setText((String) "ATENCIÓN: El precio de los alojamiento puede variar en función de las fechas seleccionadas." + "\n" + 
					" A continuación se muestran los detalles de las tarifas aplicada a su selección: " + "\n" + 
					"TARIFA NORMAL: Número de noches: " + NumNochesPorTarifa[0] +  " Precio 1 noche: " +precioAloj+ "€ Precio: "+ + NumNochesPorTarifa[0] +" noches: " +precioTarifaNormal +"€" + "\n" +
					"TARIFA ESTIVAL: Número de noches: " + NumNochesPorTarifa[1] +" Precio 1 noche: " + (String.format("%.2f", (precioAloj * 1.12))) +  "€ Precio: " + NumNochesPorTarifa[1] +" noches: " +precioTarifaEstival +"€"+ "\n" +
					 "\n" +
					 "\n" +
					 "\n" +
					"El precio final tras aplicar las tarifas para su reserva de "+ numNoches + " noches es de: " + precioTarifaAplicada +"€");

	}
	
	/**
	 * Método calcularNumNochesPorTarifa = calcula el número de noches a las que se le aplica la tarifa normal y el número de noches a las que se aplica la tarifa estival
	 * @return NumNochesPorTarifa = es un array que contiene en su primera posición [0] el número de noches a las que se aplica la tarifa normal y en [1] el número de noches a las que se aplica la tarifa estival
	 */
	public int [] calcularNumNochesPorTarifa(float precioAloj) {
	   //Declaración e inicialización de variables:
	   int numNochesNormal=0;
	   int numNochesEstival=0;
	   int numNochesFestivos=0;
	   
	   int mesIda = vista.buscarHotel.fechaIda.getMonthChooser().getMonth();
	   int mesVuelta = vista.buscarHotel.fechaVuelta.getMonthChooser().getMonth();
	   
	   int [] NumNochesPorTarifa = new int [3];
	   
	 //Definimos el inicio y el fin de la tarifa estival
	   definirInicioFinTarifaEstival();
	   
	 //calculamos el número de noche de festivos 
	   numNochesFestivos =  calcularNumNochesFestivos(precioAloj); 
	   
	   //Se pueden dar 4 posibilidades en cuanto a la TARIFA ESTIVAL, porque la reserva máxima que se puede hacer es de 30 días, sino habría cuatro posibilidades.
	   		//Nota: los meses van de 0 a 11. 
	   
	   //1º Posibilidad: que toda la reserva esté en tarifa estival: mes entrada >= Junio y mes salida <= Septiembre
	   if(mesIda>=5 && mesVuelta <=8) {
		   numNochesEstival = (int) ((modelo.fechaVuelta.getTime()-modelo.fechaIda.getTime())/86400000);
			System.out.println("-------------------------------------->SI es tarifa estival" + " Num noches tarifa estival: " + numNochesEstival);
			
		    }
	   
	   //2º Posibilidad: Que la primera parte de la reserva seatarifa normal y la última tarifa estival. 
	   else if (mesIda<5 && (mesVuelta>=5 && mesVuelta <=8)) {
		   numNochesEstival =(int) ((inicioEstival.getTime()-modelo.fechaIda.getTime())/86400000)+1;
		   numNochesNormal =(int) ((modelo.fechaVuelta.getTime()-inicioEstival.getTime())/86400000);
		   System.out.println("-------------------------------------->Empieza NO estival y termina SI estival" + " Num noches tarifa estival: " + numNochesEstival + " Num noches tarifa no estival: " + numNochesNormal);
	   }
	   
	   //3º Posibilidad: Que la primera parte de la reserva no sea tarifa estival y la última sea tarifa estival. 
	   else if ((mesIda>=5 && mesIda <=8)&& (mesVuelta>8)) {
		   numNochesEstival =(int) ((finEstival.getTime()-modelo.fechaIda.getTime())/86400000)+1;
		   numNochesNormal =(int) ((modelo.fechaVuelta.getTime()-finEstival.getTime())/86400000);
		   System.out.println("-------------------------------------->Empieza Si estival y termina No estival" + " Num noches tarifa estival: " + numNochesEstival + " Num noches tarifa no estival: " + numNochesNormal);
	   }
	   else {
		   numNochesNormal = (int) ((modelo.fechaVuelta.getTime()-modelo.fechaIda.getTime())/86400000);
	   }
	 
	   //pruebaaaas
			   if(modelo.fechaIda.after(inicioEstival) && modelo.fechaVuelta.before(finEstival)) {
				System.out.println("-------------------------------------->1es tarifa estival");
			    }
			   
			   
			  
			   
	   //pruebassss
	
	   //se rellena el array
		NumNochesPorTarifa[0] = numNochesNormal;
		NumNochesPorTarifa[1] = numNochesEstival;
		NumNochesPorTarifa[2] = numNochesFestivos;
		System.out.println("--ARRAY --NumNochesPorTarifa---------------------------------->Empieza Si estival y termina No estival" + " Num noches tarifa normal: " + NumNochesPorTarifa[0] + " Num noches tarifa estival: " + NumNochesPorTarifa[1] + "num noches festivo" + NumNochesPorTarifa[2]);

	    return NumNochesPorTarifa;
	}
	
	/**
	 * Método calcularNumNochesFestivos = calcula el número de noches a los que se le aplicará la tarifa festivo en las fechas seleccionadas por el usuario.
	 * @return
	 */
	public int calcularNumNochesFestivos(float precioAloj) {
		int numNochesFestivos = 0;
		String nombreFestivosReser = "";
		
		int diaIda = vista.buscarHotel.fechaIda.getDayChooser().getDay();
		int diaVuelta = vista.buscarHotel.fechaVuelta.getDayChooser().getDay();
		int mesIda = vista.buscarHotel.fechaIda.getMonthChooser().getMonth();
		int mesVuelta = vista.buscarHotel.fechaVuelta.getMonthChooser().getMonth();
		
		// NO VA // Object [] arrayDatosFestivos = modelo.fechasTarifas.arrayDatosFestivos; 
		int [] diasFestivos = modelo.fechasTarifas.diasFestivos; // array con los días festivos
		int [] mesesFestivos = modelo.fechasTarifas.mesesFestivos; // array con los meses festivos
		String [] nombreFestivos = modelo.fechasTarifas.nombreFestivos; // array con el nombre de los festivos
	
		for (int i=0; i<modelo.fechasTarifas.diasFestivos.length; i++ ) {
			
			//no va // System.out.println("--ARRAY -->--> Probando arrayDatosFestivos" +  arrayDatosFestivos[0] + arrayDatosFestivos[1] + arrayDatosFestivos[2]);
			System.out.println("--ARRAY -->-->--> "+diasFestivos[i]+" - "+ mesesFestivos[i] +" - "+ nombreFestivos[i]);
		}
		
		//Teniendo en cuenta que las reservas que se pueden realizar son máximo de 30 días
		// EXPLICACIÓN FÓRMULA: El festivo está en el rango de fechas seleccionadas si:  La fechaIdaSeleccionada coincide con fechafestivo || (mesSeleccionado == mes anterior al mes festivo || mesSeleccionado == mesFestivo) && (mesSeleccionado == mes festivo || mesSeleccionado == mes siguiente al mesFestivo)

		for (int i=0; i<modelo.fechasTarifas.diasFestivos.length; i++ ) { //se recorren todos los festivos
			// si reserva la ida el mes anterior al festivo y la vuelta un mes después del festivo, significa que ha reservado el festivo
			if(diaIda == diasFestivos[i] && mesIda == mesesFestivos[i] || (mesIda ==( mesesFestivos[i] - 1 ) || diaIda <=diasFestivos[i] && mesIda == mesesFestivos[i]) && (diaVuelta >=diasFestivos[i] && mesVuelta == mesesFestivos[i] || mesVuelta == ( mesesFestivos[i] + 1 )) ) {
				numNochesFestivos = numNochesFestivos + 1; // si se comple la condición, se añade una noche al número de noches festivos
				nombreFestivosReser = nombreFestivosReser + " Día: "+ diasFestivos[i]+" - "+ " Mes: "+ ( mesesFestivos[i] + 1 ) +" - "+" Festivo: "+ nombreFestivos[i];	//se añade el nombre del festivo a nombreFestivosReser
			}
		}
	
		//Los festivos de los meses enero y diciembre se tratan aparte porque el for no los contempla.
		if(diaIda == 1 && mesIda == 0 || ( mesIda == 11 && mesVuelta == 0)) { //FESTIVO AÑO NUEVO 1-01 .El mes de Enero (posición 0) es especial por ser el anterior el mes dic(posicion11)
			numNochesFestivos = numNochesFestivos + 1; 
			nombreFestivosReser = nombreFestivosReser + " Día: " + 1 + " - " + " Mes: "+ 1 +" - " + " Festivo: " + "Año Nuevo";
		}
		else if(diaIda == 6 && mesIda == 0 || (mesIda == 11 || diaIda <=6 && mesIda == 0) && (diaVuelta >=6 &&  mesVuelta == 0 || mesVuelta == 1) ) { //FESTIVO REYES  6-01 .El mes de Enero (posición 0) es especial por ser el anterior el mes dic(posicion11)
			numNochesFestivos = numNochesFestivos + 1; 
			nombreFestivosReser = nombreFestivosReser + " Día: " + 6 + " - " + " Mes: "+ 1 +" - " + " Festivo: " + "Día de Reyes";
		}
		else if(diaIda == 8 && mesIda == 11 || (mesIda == 10 || diaIda <=8 && mesIda == 11) && (diaVuelta >=8 && mesVuelta == 11 || mesVuelta == 0) ) { //FESTIVO DIA DE LA CONCEPCION 6-11 .El mes de diciembre (posición 11) es especial por ser el posterior al mes enero(posicion0)
			numNochesFestivos = numNochesFestivos + 1; 
			nombreFestivosReser = nombreFestivosReser + " Día: " + 8 + " - " + " Mes: "+ 12 +" - " + " Festivo: " + "La Inmaculada Concepción";
		}
		else if(diaIda == 25 && mesIda == 11 || (mesIda == 10 || diaIda <=25 && mesIda == 11) && (diaVuelta >=25 && mesVuelta == 11 || mesVuelta == 0) ) { //FESTIVO NAVIDAD 25-11 .El mes de diciembre (posición 11) es especial por ser el posterior al mes enero(posicion0)
			numNochesFestivos = numNochesFestivos + 1; 
			nombreFestivosReser = nombreFestivosReser + " Día: " + 25 + " - " + " Mes: "+ 12 +" - " + " Festivo: " + "Navidad";
		}
	
		System.out.println("numNochesFestivos" + numNochesFestivos+ "nombreFestivosReser"+ nombreFestivosReser);
		//FALTA se mete el nombreFestivosReser en el modelo.reserva  o se muestra en un jtext
		
		if(numNochesFestivos > 0) {
			float suplementoFestivos = calcularSuplementoFestivos(precioAloj);
			vista.detallesReservaCasaApart.textDetDestinos.setText((String) "Además, su reserva incluye "+ numNochesFestivos + " festivos:" + "\n" + 
					nombreFestivosReser + "Suplemento por festivo: "+ (precioAloj * 0.20) +   "€" +"\n");

	
		}
		 
		return numNochesFestivos;
	}
	
	
	
	
	/**
	 * Método definirInicioFinTarifaEstival = define la fecha deinicio y la fecha final de la tarifa estival
	 */
	private void definirInicioFinTarifaEstival() {
		//Definimos el inicio y el fin de la tarifa estival
		String sInicioEstival = "2019-06-01" ;
		String sFinEstival = "2019-10-01" ;
			try {
				inicioEstival = formato.parse(sInicioEstival);
		        finEstival = formato.parse(sFinEstival);
		    } 
		    catch (ParseException ex) 
		    {
		       System.out.println(ex);
		    }
	}

	/**
	 * Método: guardarReservaAlojamiento = Genera la reserva de la casa/alojamiento y la guarda en modelo.reserva
	 */
	public void guardarReservaAlojamiento(TipoAlojamiento tiposAloj) {
		
		//se calcula el codigo de reserva que corresponde a esta reserva
		int codReserva= modelo.consultas.mostrarNumReservas();
		
		//metemos los datos en la reserva 
		modelo.reserva = new Reserva(); 
		codReserva = codReserva + 1;
		modelo.reserva.setCodReserva(codReserva);
		modelo.reserva.setCliente(modelo.cliente);
		
		//se guarda el alojamiento en la reserva, diferenciando si es una casa o un apartamento
		if(tiposAloj.getCodTipoAlojamiento() == 10) {
			modelo.reserva.setAlojamiento(modelo.hotel);
			modelo.reserva.setHabitacion(modelo.habitacion);
			
		}
		else if(tiposAloj.getCodTipoAlojamiento() == 20) {
			modelo.reserva.setAlojamiento(modelo.casa);
		}
		else if (tiposAloj.getCodTipoAlojamiento() == 30) {
			modelo.reserva.setAlojamiento(modelo.apartamento);
		}
		
		
		modelo.reserva.setFechaIda(modelo.fechaIda);
		modelo.reserva.setFechaVuelta(modelo.fechaVuelta);
		modelo.reserva.setPrecioReserva(calcularPrecioReservaCasApart(tiposAloj));
			    
		//probamos que la reserva se haya creado y rellenado correctamente
		 System.out.println("------->La reserva de la casa o apartamento es: " +"Código reserva: " + modelo.reserva.getCodReserva() + "cod alojamiento reservado " +  modelo.reserva.getAlojamiento().getCodAlojamiento() + "precio reserva alojamiento: "+  modelo.reserva.getPrecioReserva());
		
		}

	/**
	 * Método mostrarDatosReservacasaApart = muestra los datos de la reserva. Los datos de la reserva son aquellos datos seleccionados por el usuario. 
	 */
	public void mostrarDatosReservaCasaApart(TipoAlojamiento tiposAloj) {
		//muestra datos del alojamiento
		vista.detallesReservaCasaApart.textPDatosAlo.setText((String) "Ciudad: " + modelo.reserva.getAlojamiento().getUbicacion() + "\n" + "Código del hotel: "+ modelo.reserva.getAlojamiento().getCodAlojamiento() + "\n" + "Hotel: " +modelo.reserva.getAlojamiento().getNombre());
		
		//mostramos num de noches en la vista 
		vista.detallesReservaCasaApart.textFieldNumNoches.setText(Integer.toString(modelo.numNoches));
		
		//muestra el PRECIO TOTAL DE LA RESERVA: 
		calcularPrecioReservaCasApart(tiposAloj);
		
		//SE MUESTRA EL PRECIO TOTAL:
		vista.detallesReservaCasaApart.tFPrecioReserva.setText((String.format("%.2f", modelo.precioTotal))+ " €");
	}
	
	
	/**
	 * Método mostrarDatosReserva = muestra los datos de la reserva. Los datos de la reserva son aquellos datos seleccionados por el usuario. 
	 */
	public void mostrarDatosReserva(ArrayList<Dormitorio> listaHabSeleccionadas) {
		//muestra datos del alojamiento
		vista.detallesReserva.textPDatosAlo.setText((String) "Ciudad: " + modelo.reserva.getAlojamiento().getUbicacion() + "\n" + "Código del hotel: "+ modelo.reserva.getAlojamiento().getCodAlojamiento() + "\n" + "Hotel: " +modelo.reserva.getAlojamiento().getNombre()+"\n" + "Número de estrellas:" + modelo.hotel.getEstrellas() );
		
		//muestra el PRECIO TOTAL DE LA RESERVA: 
		calcularPrecioReservaHotel(listaHabSeleccionadas);
		
		//SE MUESTRA EL PRECIO TOTAL:
	  	vista.detallesReserva.tFPrecioReserva.setText((String.format("%.2f", modelo.precioTotal))+ " €");
	}
	
	/**
	 * Método insertarReservasHabitacionesSel = inserta en la base de datos las reservas de las habitaciones seleccionadas del hotel (inserta una reserva por cada habitación de hotel seleccionada)
	 */
	public void insertarReservasHabitacionesSel() {
		
		for(int i=0; modelo.listaReservas.size()>i; i++) {
			modelo.consultas.insertarReserva(modelo.listaReservas, i, modelo.cliente.getDni(), modelo.fechaIda, modelo.fechaVuelta);
		}
	}
	
	/**
	 * Método insertarReservaHabitacionSel = inserta en la base de datos la reserva de las habitacion seleccionada del hotel 
	 */
	public void insertarReservaHabitacionSel() {
		
		modelo.consultas.insertar1Reserva(modelo.reserva, modelo.habitacion, modelo.cliente.getDni(), modelo.fechaIda, modelo.fechaVuelta);
		 
	}
	
	/**
	 * Método generarFicherosReservasHabitacionesSel = genera un fichero por cada habitación de hotel reservada.
	 */
	public void generarFicherosReservasHabitacionesSel() {
		//guarda los datos de la reserva en en un fichero, 1 reserva por cada habitación. 
		for(int i=0; modelo.listaReservas.size()>i; i++) {
			modelo.funcionesFichero.imprimirReservaHabitacionesHotel(modelo, vista, i);
		}
	}
	public void generarFicherosReserva1HabHotel() {
		//guarda los datos de la reserva en en un fichero
		modelo.funcionesFichero.imprimirReserva1HabHotel(modelo, vista);
		
	}
	
	public void generarFicherosReservaCasa() {
		//guarda los datos de la reserva en en un fichero
		modelo.funcionesFichero.imprimirReservaFicheroCasa(modelo, vista);
		
	}
	
	public void generarFicherosReservaApart() {
		//guarda los datos de la reserva en en un fichero
		modelo.funcionesFichero.imprimirReservaFicheroApart(modelo, vista);
		
	}
	
	
	/**
	 * Método: mostrarTiposDeCamas = devuelve un String que contiene el número de camas de cada tipo que hay.
	 * @param listaCamas
	 * @return
	 */
	public String mostrarTiposDeCamas(ArrayList<Cama> listaCamas) {
		System.out.println("****TIPOS DE CAMAS DE LA HABITACIÓN SELECCIONADA***");
		String tiposCamaHab = "";
		int numTipCam [] = new int [3];
		
		for (int i=0; listaCamas.size()>i; i++) {
			if(listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("simple")) {
				numTipCam[0] = numTipCam[0] +1;
			}
			else if(listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("matrimonio")) {
				numTipCam[1] = numTipCam[1] + 1;
			}
			else if(listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("infantil")) {
				numTipCam[2] = numTipCam[2] + 1;
			}
			System.out.println(listaCamas.get(i).getTipoCama().toString());
		
		}
		//se rellena el String con los tipos de cama 
		tiposCamaHab = numTipCam[0] + " simple, " + numTipCam[1] + " matrimonio y " + numTipCam[2] + " infantil.";
		System.out.println(tiposCamaHab);
		
	
		
		return tiposCamaHab;
	}
	
	/**
	 * Método: mostrarOcupacionHab = devuelve un int que contiene el número de ocupantes de la habitacion
	 * @param listaCamas
	 * @return
	 */
	public int mostrarOcupacionHab(ArrayList<Cama> listaCamas) {
		System.out.println("****Ocupacion DE LA HABITACIÓN SELECCIONADA***");
		int ocupacion = 0;
		int numTipCam [] = new int [3];
		
		for (int i=0; listaCamas.size()>i; i++) {
			if(listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("simple")) {
				numTipCam[0] = numTipCam[0] +1;
			}
			else if(listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("matrimonio")) {
				numTipCam[1] = numTipCam[1] + 1;
			}
			else if(listaCamas.get(i).getTipoCama().toString().equalsIgnoreCase("infantil")) {
				numTipCam[2] = numTipCam[2] + 1;
			}
			System.out.println(listaCamas.get(i).getTipoCama().toString());
		
		}
		//se rellena la variable ocupacion con el umero de ocupantes de las camas de la habitacion
		ocupacion = numTipCam[0] * 1 + numTipCam[1] * 2 + numTipCam[2] *1;
		System.out.println("ocupacion" + ocupacion);
	
		return ocupacion;
	}
	
	/*
	public String mostrarStringTiposCama(int [] numTipCam) {
		String tiposCamaHab = "";
		for (int i=0; numTipCam.length>i; i++) {
			tiposCamaHab = numTipCam[0] + " camas simples, " + numTipCam[1] + " camas de matrimonio y " + numTipCam[2] + " cunas o camas infantiles.";
		}
		System.out.println(tiposCamaHab);
		
		return tiposCamaHab;
	}
	*/
}

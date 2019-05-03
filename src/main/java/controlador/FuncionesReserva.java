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
		
		//(1�) el precio de la casa/apartamento en funci�n del N�MERO DE NOCHES seleccionadas por el usuario Y DE LA TARIFA
		if(tiposAloj.getCodTipoAlojamiento() == 20) {
			precioReserva = precioReserva + calcularPrecioPorTarifa(tiposAloj, modelo.casa.getPrecioAlojamiento());
		}
		else if(tiposAloj.getCodTipoAlojamiento() == 30) {
			precioReserva = precioReserva + calcularPrecioPorTarifa(tiposAloj, modelo.apartamento.getPrecioAlojamiento());
		}
		//(2�) calcular el precio 
	//	int numNoches = calcularNochesReservadas();  
		
		//precioReserva = precioReserva*numNoches;
		
		//(3�)Redondeamos a 2 decimales
		precioReserva = Math.round(precioReserva*100); //redondear a dos decimales
		precioReserva = precioReserva/100;//redondear a dos decimales
		
		//(4�) metemos el precio total de la reserva en el modelo:
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
		
		//(1�) el precio total de la reserva ser� la suma de los precios de las habitaciones seleccionadas
		for(int i=0; i<listaHabSeleccionadas.size();i++) {
			precioReserva = precioReserva + listaHabSeleccionadas.get(i).getPrecioHabitacion();
		}
		
		
		//(2�) calcular el precio en funci�n del N�MERO DE NOCHES seleccionadas por el usuario.
		int numNoches = calcularNochesReservadas();  
		
		precioReserva = precioReserva*numNoches;
		
		//(3�)Redondeamos a 2 decimales
		precioReserva = Math.round(precioReserva*100); //redondear a dos decimales
		precioReserva = precioReserva/100;//redondear a dos decimales
		
		//(4�) metemos el precio total de la reserva en el modelo:
		modelo.precioTotal = precioReserva;
		System.out.println("EL PRECIO TOTAL DE LA RESERVA DE TODAS LAS HABS DEL HOTEL ES calcularPrecioReservaHotel "+modelo.precioTotal);
		
		return precioReserva;
	}
	
	/** 
	 * M�todo calcularPrecioHabXNoches = calcula el precio de una habitaci�n por el n�mero de noches que se desea reservar
	 * @param listaHabSeleccionadas = se le pasa la lista con la shabitaciones seleccionadas
	 * @param pos = la posici�n que est� recorriendo un for.
	 * @return
	 */
	public float calcularPrecioHabXNoches( ArrayList<Dormitorio> listaHabSeleccionadas, int pos) {
		float precioHabXnoches=0;
		 DecimalFormat f = new DecimalFormat("##.00");
		 
		//(1�) Calcular el precio en funci�n del N�MERO DE NOCHES seleccionadas por el usuario.
		int numNoches = calcularNochesReservadas();
		
		//calcular el precio de la habitacion x noches.
		precioHabXnoches = listaHabSeleccionadas.get(pos).getPrecioHabitacion() * numNoches;
		
		precioHabXnoches = Math.round(precioHabXnoches*100); //redondear a dos decimales
		precioHabXnoches = precioHabXnoches/100;//redondear a dos decimales
		
/*
		//CALCULA EL PRECIO DE LAS HABITACIONES EN FUNCI�N DE LA TARIFA SELECCIONADA
		 precioHabXnoches = calcularPrecioPorTarifa(listaHabSeleccionadas.get(pos).getPrecioHabitacion() );
		*/		
		return precioHabXnoches;
	}
	
	
	/**
	 * M�todo calcularNochesReservadas = calcula el n�mero de noches reservadas por el usuario.
	 */
	public int calcularNochesReservadas() { 
		int numNoches=(int) ((modelo.fechaVuelta.getTime()-modelo.fechaIda.getTime())/86400000);
		 
		//metemos el n�mero de noches en el modelo:
		modelo.numNoches = numNoches;
		System.out.println("Noches reservadas:  "+modelo.numNoches);
		
		//mostramos num de noches en la vista 
		vista.detallesReserva.textFieldNumNoches.setText(Integer.toString(modelo.numNoches));
		
		return numNoches;
	}
	
	/**
	 * M�todo calcularPrecioPorTarifa = calcula el precio en funci�n de las fechas seleccionadas aplicando el precio de la tarifa normal o tarifa estival en funci�n del n�mero de noches normales y numero de noches en fechas de tarifa estival seleccionadas
	 * @param precioAloj
	 * @param NumNochesPorTarifa = es un array que contiene en su primera posici�n [0] el n�mero de noches a las que se aplica la tarifa normal y en [1] el n�mero de noches a las que se aplica la tarifa estival
	 * @return
	 */
	
	public float calcularPrecioPorTarifa(TipoAlojamiento tiposAloj, float precioAloj) {
		 //Se rellena el array NumNochesPorTarifa
		  int [] NumNochesPorTarifa = calcularNumNochesPorTarifa();
		   
		 //el precio precioTarifaAplicada = (noches tarifa normal * precioAloj) + (noches estivales * el precioAloj + un 12% el precio del alojamiento) 
		  float precioTarifaNormal = (NumNochesPorTarifa[0] * precioAloj);
		  float precioTarifaEstival = (float) (NumNochesPorTarifa[1] * (precioAloj * 1.12));
		  float precioTarifaAplicada = precioTarifaNormal + precioTarifaEstival; 
		  int numNoches = calcularNochesReservadas();  
		  
		 //muestra los detalles de la tarifa aplicada, el n�mero de noches y el precio en detallesReservaCasaApart
		  if(tiposAloj.getCodTipoAlojamiento() == 10) {
			 
			}
		  else if(tiposAloj.getCodTipoAlojamiento() == 20 || tiposAloj.getCodTipoAlojamiento() == 30) {
			  vista.detallesReservaCasaApart.textDetTarifa.setText((String) "ATENCI�N: El precio de los alojamiento puede variar en funci�n de las fechas seleccionadas." + "\n" + 
						" A continuaci�n se muestran los detalles de las tarifas aplicada a su selecci�n: " + "\n" + 
						"TARIFA NORMAL: N�mero de noches: " + NumNochesPorTarifa[0] +  " Precio 1 noche: " +precioAloj+ "� Precio: "+ + NumNochesPorTarifa[0] +" noches: " +precioTarifaNormal +"�" + "\n" +
						"TARIFA ESTIVAL: N�mero de noches: " + NumNochesPorTarifa[1] +" Precio 1 noche: " + (String.format("%.2f", (precioAloj * 1.12))) +  "� Precio: " + NumNochesPorTarifa[1] +" noches: " +precioTarifaEstival +"�"+ "\n" +
						"El precio final tras aplicar las tarifas para su reserva de "+ numNoches + " noches es de:" + precioTarifaAplicada +"�");
	
			}
		
		   return precioTarifaAplicada;
	}
	
	/**
	 * M�todo calcularNumNochesPorTarifa = calcula el n�mero de noches a las que se le aplica la tarifa normal y el n�mero de noches a las que se aplica la tarifa estival
	 * @return NumNochesPorTarifa = es un array que contiene en su primera posici�n [0] el n�mero de noches a las que se aplica la tarifa normal y en [1] el n�mero de noches a las que se aplica la tarifa estival
	 */
	public int [] calcularNumNochesPorTarifa() {
	   //Declaraci�n e inicializaci�n de variables:
	   int numNochesEstival=0;
	   int numNochesNormal=0;
	   int mesIda = vista.buscarHotel.fechaIda.getMonthChooser().getMonth();
	   int mesVuelta = vista.buscarHotel.fechaVuelta.getMonthChooser().getMonth();
	   
	   int [] NumNochesPorTarifa = new int [2];
	   
	   definirInicioFinTarifaEstival();//Definimos el inicio y el fin de la tarifa estival
	    
	   //Se pueden dar 4 posibilidades en cuanto a la TARIFA ESTIVAL, porque la reserva m�xima que se puede hacer es de 30 d�as, sino habr�a cuatro posibilidades.
	   		//Nota: los meses van de 0 a 11. 
	   
	   //1� Posibilidad: que toda la reserva est� en tarifa estival: mes entrada >= Junio y mes salida <= Septiembre
	   if(mesIda>=5 && mesVuelta <=8) {
		   numNochesEstival = (int) ((modelo.fechaVuelta.getTime()-modelo.fechaIda.getTime())/86400000);
			System.out.println("-------------------------------------->SI es tarifa estival" + " Num noches tarifa estival: " + numNochesEstival);
			
		    }
	   
	   //2� Posibilidad: Que la primera parte de la reserva seatarifa normal y la �ltima tarifa estival. 
	   else if (mesIda<5 && (mesVuelta>=5 && mesVuelta <=8)) {
		   numNochesEstival =(int) ((inicioEstival.getTime()-modelo.fechaIda.getTime())/86400000)+1;
		   numNochesNormal =(int) ((modelo.fechaVuelta.getTime()-inicioEstival.getTime())/86400000);
		   System.out.println("-------------------------------------->Empieza NO estival y termina SI estival" + " Num noches tarifa estival: " + numNochesEstival + " Num noches tarifa no estival: " + numNochesNormal);
	   }
	   
	   //3� Posibilidad: Que la primera parte de la reserva no sea tarifa estival y la �ltima sea tarifa estival. 
	   else if ((mesIda>=5 && mesIda <=8)&& (mesVuelta>8)) {
		   numNochesEstival =(int) ((finEstival.getTime()-modelo.fechaIda.getTime())/86400000)+1;
		   numNochesNormal =(int) ((modelo.fechaVuelta.getTime()-finEstival.getTime())/86400000);
		   System.out.println("-------------------------------------->Empieza Si estival y termina No estival" + " Num noches tarifa estival: " + numNochesEstival + " Num noches tarifa no estival: " + numNochesNormal);
	   }
	 
	   //pruebaaaas
	   
				System.out.println(inicioEstival);
				System.out.println(inicioEstival);
				System.out.println(finEstival);
				
				System.out.println("fecha ida:" + modelo.fechaIda);
				System.out.println("mes fecha ida:" + vista.buscarHotel.fechaIda.getMonthChooser().getMonth());
			
				
			   if(modelo.fechaIda.after(inicioEstival) && modelo.fechaVuelta.before(finEstival)) {
				System.out.println("-------------------------------------->1es tarifa estival");
			    }
	   
	   //pruebassss
	
	   //se rellena el array
		NumNochesPorTarifa[0] = numNochesNormal;
		NumNochesPorTarifa[1] = numNochesEstival;
		System.out.println("--ARRAY --NumNochesPorTarifa---------------------------------->Empieza Si estival y termina No estival" + " Num noches tarifa estival: " + numNochesEstival + " Num noches tarifa no estival: " + numNochesNormal);

	    return NumNochesPorTarifa;
	}
	
	
	
	
	
	
	/**
	 * M�todo definirInicioFinTarifaEstival = define la fecha deinicio y la fecha final de la tarifa estival
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
	 * M�todo: guardarReservaAlojamiento = Genera la reserva de la casa/alojamiento y la guarda en modelo.reserva
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
		if(tiposAloj.getCodTipoAlojamiento() == 20) {
			modelo.reserva.setAlojamiento(modelo.casa);
		}
		else if (tiposAloj.getCodTipoAlojamiento() == 30) {
			modelo.reserva.setAlojamiento(modelo.apartamento);
		}
		
		
		modelo.reserva.setFechaIda(modelo.fechaIda);
		modelo.reserva.setFechaVuelta(modelo.fechaVuelta);
		modelo.reserva.setPrecioReserva(calcularPrecioReservaCasApart(tiposAloj));
			    
		//probamos que la reserva se haya creado y rellenado correctamente
		 System.out.println("------->La reserva de la casa o apartamento es: " +"C�digo reserva: " + modelo.reserva.getCodReserva() + "cod alojamiento reservado " +  modelo.reserva.getAlojamiento().getCodAlojamiento() + "precio reserva alojamiento: "+  modelo.reserva.getPrecioReserva());
		
		}

	/**
	 * M�todo mostrarDatosReservacasaApart = muestra los datos de la reserva. Los datos de la reserva son aquellos datos seleccionados por el usuario. 
	 */
	public void mostrarDatosReservaCasaApart(TipoAlojamiento tiposAloj) {
		//muestra datos del alojamiento
		vista.detallesReservaCasaApart.textPDatosAlo.setText((String) "Ciudad: " + modelo.reserva.getAlojamiento().getUbicacion() + "\n" + "C�digo del hotel: "+ modelo.reserva.getAlojamiento().getCodAlojamiento() + "\n" + "Hotel: " +modelo.reserva.getAlojamiento().getNombre());
		
		//mostramos num de noches en la vista 
		vista.detallesReservaCasaApart.textFieldNumNoches.setText(Integer.toString(modelo.numNoches));
		
		//muestra el PRECIO TOTAL DE LA RESERVA: 
		calcularPrecioReservaCasApart(tiposAloj);
		
		//SE MUESTRA EL PRECIO TOTAL:
		vista.detallesReservaCasaApart.tFPrecioReserva.setText((String.format("%.2f", modelo.precioTotal))+ " �");
	}
	
	
	/**
	 * M�todo mostrarDatosReserva = muestra los datos de la reserva. Los datos de la reserva son aquellos datos seleccionados por el usuario. 
	 */
	public void mostrarDatosReserva(ArrayList<Dormitorio> listaHabSeleccionadas) {
		//muestra datos del alojamiento
		vista.detallesReserva.textPDatosAlo.setText((String) "Ciudad: " + modelo.reserva.getAlojamiento().getUbicacion() + "\n" + "C�digo del hotel: "+ modelo.reserva.getAlojamiento().getCodAlojamiento() + "\n" + "Hotel: " +modelo.reserva.getAlojamiento().getNombre()+"\n" + "N�mero de estrellas:" + modelo.hotel.getEstrellas() );
		
		//muestra el PRECIO TOTAL DE LA RESERVA: 
		calcularPrecioReservaHotel(listaHabSeleccionadas);
		
		//SE MUESTRA EL PRECIO TOTAL:
	  	vista.detallesReserva.tFPrecioReserva.setText((String.format("%.2f", modelo.precioTotal))+ " �");
	}
	
	/**
	 * M�todo insertarReservasHabitacionesSel = inserta en la base de datos las reservas de las habitaciones seleccionadas del hotel (inserta una reserva por cada habitaci�n de hotel seleccionada)
	 */
	public void insertarReservasHabitacionesSel() {
		
		for(int i=0; modelo.listaReservas.size()>i; i++) {
			modelo.consultas.insertarReserva(modelo.listaReservas, i, modelo.cliente.getDni(), modelo.fechaIda, modelo.fechaVuelta);
		}
	}
	
	/**
	 * M�todo generarFicherosReservasHabitacionesSel = genera un fichero por cada habitaci�n de hotel reservada.
	 */
	public void generarFicherosReservasHabitacionesSel() {
		//guarda los datos de la reserva en en un fichero, 1 reserva por cada habitaci�n. 
		for(int i=0; modelo.listaReservas.size()>i; i++) {
			modelo.funcionesFichero.imprimirReservaHabitacionesHotel(modelo, vista, i);
		}
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
	 * M�todo: mostrarTiposDeCamas = devuelve un String que contiene el n�mero de camas de cada tipo que hay.
	 * @param listaCamas
	 * @return
	 */
	public String mostrarTiposDeCamas(ArrayList<Cama> listaCamas) {
		System.out.println("****TIPOS DE CAMAS DE LA HABITACI�N SELECCIONADA***");
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
	 * M�todo: mostrarOcupacionHab = devuelve un int que contiene el n�mero de ocupantes de la habitacion
	 * @param listaCamas
	 * @return
	 */
	public int mostrarOcupacionHab(ArrayList<Cama> listaCamas) {
		System.out.println("****Ocupacion DE LA HABITACI�N SELECCIONADA***");
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

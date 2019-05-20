package controlador;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class FuncionesBasesLegales {
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	public float precioReserva;
	
	public FuncionesBasesLegales (PrincipalModelo modelo,JframePrincipal vista, PrincipalControlador controlador) {
		this.modelo = modelo;
		this.controlador = controlador;
		this.vista = vista;
	} 
	
	/**
	 * M�todo mostrarBaseslegales = se muestran en el textField del panelbasesLegales las bases legales
	 */
	public void mostrarBaseslegales() {
		vista.bases.txBases.setText("BOLET�N OFICIAL DEL ESTADO"+ "\n" + 
				"LEGISLACI�N CONSOLIDADA"+
				"T�TULO VII\r\n" + 
				"Autoridades de protecci�n de datos\r\n" + 
				"CAP�TULO I\r\n" + 
				"La Agencia Espa�ola de Protecci�n de Datos\r\n" + 
				"Secci�n 1.� Disposiciones generales\r\n" + 
				 "\n" + 
				"Art�culo 44. Disposiciones generales.\r\n" + 
				"1. La Agencia Espa�ola de Protecci�n de Datos es una autoridad administrativa\r\n" + 
				"independiente de �mbito estatal, de las previstas en la Ley 40/2015, de 1 de octubre, de\r\n" + 
				"R�gimen Jur�dico del Sector P�blico, con personalidad jur�dica y plena capacidad p�blica y\r\n" + 
				"privada, que act�a con plena independencia de los poderes p�blicos en el ejercicio de sus\r\n" + 
				"funciones.\r\n" + 
				"Su denominaci�n oficial, de conformidad con lo establecido en el art�culo 109.3 de la Ley\r\n" + 
				"40/2015, de 1 de octubre, de R�gimen Jur�dico del Sector P�blico, ser� �Agencia Espa�ola\r\n" + 
				"de Protecci�n de Datos, Autoridad Administrativa Independiente�.\r\n" + 
				"Se relaciona con el Gobierno a trav�s del Ministerio de Justicia.\r\n" + 
				"2. La Agencia Espa�ola de Protecci�n de Datos tendr� la condici�n de representante\r\n" + 
				"com�n de las autoridades de protecci�n de datos del Reino de Espa�a en el Comit� Europeo\r\n" + 
				"de Protecci�n de Datos.\r\n" + 
				"3. La Agencia Espa�ola de Protecci�n de Datos y el Consejo General del Poder Judicial\r\n" + 
				"colaborar�n en aras del adecuado ejercicio de las respectivas competencias que la Ley\r\n" + 
				"Org�nica 6/1985, de 1 julio, del Poder Judicial, les atribuye en materia de protecci�n de\r\n" + 
				"datos personales en el �mbito de la Administraci�n de Justicia.\r\n" + 
				"\n" + 
				"Art�culo 45. R�gimen jur�dico.\r\n" + 
				"1. La Agencia Espa�ola de Protecci�n de Datos se rige por lo dispuesto en el\r\n" + 
				"Reglamento (UE) 2016/679, la presente ley org�nica y sus disposiciones de desarrollo.\r\n" + 
				"Supletoriamente, en cuanto sea compatible con su plena independencia y sin perjuicio\r\n" + 
				"de lo previsto en el art�culo 63.2 de esta ley org�nica, se regir� por las normas citadas en el\r\n" + 
				"art�culo 110.1 de la Ley 40/2015, de 1 de octubre, de R�gimen Jur�dico del Sector P�blico.\r\n" + 
				"2. El Gobierno, a propuesta de la Agencia Espa�ola de Protecci�n de Datos, aprobar� su\r\n" + 
				"Estatuto mediante real decreto.\r\n" + 
				"\n" + 
				"Art�culo 46. R�gimen econ�mico presupuestario y de personal.\r\n" + 
				"1. La Agencia Espa�ola de Protecci�n de Datos elaborar� y aprobar� su presupuesto y\r\n" + 
				"lo remitir� al Gobierno para que sea integrado, con independencia, en los Presupuestos\r\n" + 
				"Generales del Estado.\r\n" + 
				"2. El r�gimen de modificaciones y de vinculaci�n de los cr�ditos de su presupuesto ser�\r\n" + 
				"el establecido en el Estatuto de la Agencia Espa�ola de Protecci�n de Datos.\r\n" + 
				"Corresponde a la Presidencia de la Agencia Espa�ola de Protecci�n de Datos autorizar\r\n" + 
				"las modificaciones presupuestarias que impliquen hasta un tres por ciento de la cifra inicial\r\n" + 
				"de su presupuesto total de gastos, siempre que no se incrementen los cr�ditos para gastos\r\n" + 
				"de personal. Las restantes modificaciones que no excedan de un cinco por ciento del\r\n" + 
				"presupuesto ser�n autorizadas por el Ministerio de Hacienda y, en los dem�s casos, por el\r\n" + 
				"Gobierno.\r\n" + 
				"3. La Agencia Espa�ola de Protecci�n de Datos contar� para el cumplimiento de sus\r\n" + 
				"fines con las asignaciones que se establezcan con cargo a los Presupuestos Generales del\r\n" + 
				"Estado, los bienes y valores que constituyan su patrimonio y los ingresos, ordinarios y\r\n" + 
				"extraordinarios derivados del ejercicio de sus actividades, incluidos los derivados del\r\n" + 
				"ejercicio de las potestades establecidos en el art�culo 58 del Reglamento (UE) 2016/679." + 
				"4. El resultado positivo de sus ingresos se destinar� por la Agencia Espa�ola de\r\n" + 
				"Protecci�n de Datos a la dotaci�n de sus reservas con el fin de garantizar su plena\r\n" + 
				"independencia.\r\n" + 
				"5. El personal al servicio de la Agencia Espa�ola de Protecci�n de Datos ser�\r\n" + 
				"funcionario o laboral y se regir� por lo previsto en el texto refundido de la Ley del Estatuto\r\n" + 
				"B�sico del Empleado P�blico, aprobado por Real Decreto Legislativo 5/2015, de 30 de\r\n" + 
				"octubre, y dem�s normativa reguladora de los funcionarios p�blicos y, en su caso, por la\r\n" + 
				"normativa laboral.\r\n" + 
				"6. La Agencia Espa�ola de Protecci�n Datos elaborar� y aprobar� su relaci�n de\r\n" + 
				"puestos de trabajo, en el marco de los criterios establecidos por el Ministerio de Hacienda,\r\n" + 
				"respetando el l�mite de gasto de personal establecido en el presupuesto. En dicha relaci�n\r\n" + 
				"de puestos de trabajo constar�n, en todo caso, aquellos puestos que deban ser\r\n" + 
				"desempe�ados en exclusiva por funcionarios p�blicos, por consistir en el ejercicio de las\r\n" + 
				"funciones que impliquen la participaci�n directa o indirecta en el ejercicio de potestades\r\n" + 
				"p�blicas y la salvaguarda de los intereses generales del Estado y de las Administraciones\r\n" + 
				"P�blicas.\r\n" + 
				"7. Sin perjuicio de las competencias atribuidas al Tribunal de Cuentas, la gesti�n\r\n" + 
				"econ�mico-financiera de la Agencia Espa�ola de Protecci�n de Datos estar� sometida al\r\n" + 
				"control de la Intervenci�n General de la Administraci�n del Estado en los t�rminos que\r\n" + 
				"establece la Ley 47/2003, de 26 de noviembre, General Presupuestaria.\r\n" + 
				"Art�culo 47. Funciones y potestades de la Agencia Espa�ola de Protecci�n de Datos.\r\n" + 
				"Corresponde a la Agencia Espa�ola de Protecci�n de Datos supervisar la aplicaci�n de\r\n" + 
				"esta ley org�nica y del Reglamento (UE) 2016/679 y, en particular, ejercer las funciones\r\n" + 
				"establecidas en el art�culo 57 y las potestades previstas en el art�culo 58 del mismo\r\n" + 
				"reglamento, en la presente ley org�nica y en sus disposiciones de desarrollo.\r\n" + 
				"Asimismo, corresponde a la Agencia Espa�ola de Protecci�n de Datos el desempe�o de\r\n" + 
				"las funciones y potestades que le atribuyan otras leyes o normas de Derecho de la Uni�n\r\n" + 
				"Europea.\r\n" + 
				"\n" + 
				"Art�culo 48. La Presidencia de la Agencia Espa�ola de Protecci�n de Datos.\r\n" + 
				"1. La Presidencia de la Agencia Espa�ola de Protecci�n de Datos la dirige, ostenta su\r\n" + 
				"representaci�n y dicta sus resoluciones, circulares y directrices.\r\n" + 
				"2. La Presidencia de la Agencia Espa�ola de Protecci�n de Datos estar� auxiliada por un\r\n" + 
				"Adjunto en el que podr� delegar sus funciones, a excepci�n de las relacionadas con los\r\n" + 
				"procedimientos regulados por el T�tulo VIII de esta ley org�nica, y que la sustituir� en el\r\n" + 
				"ejercicio de las mismas en los t�rminos previstos en el Estatuto Org�nico de la Agencia\r\n" + 
				"Espa�ola de Protecci�n de Datos.\r\n" + 
				"Ambos ejercer�n sus funciones con plena independencia y objetividad y no estar�n\r\n" + 
				"sujetos a instrucci�n alguna en su desempe�o. Les ser� aplicable la legislaci�n reguladora\r\n" + 
				"del ejercicio del alto cargo de la Administraci�n General del Estado.\r\n" + 
				"3. La Presidencia de la Agencia Espa�ola de Protecci�n de Datos y su Adjunto ser�n\r\n" + 
				"nombrados por el Gobierno, a propuesta del Ministerio de Justicia, entre personas de\r\n" + 
				"reconocida competencia profesional, en particular en materia de protecci�n de datos.\r\n" + 
				"Dos meses antes de producirse la expiraci�n del mandato o, en el resto de las causas de\r\n" + 
				"cese, cuando se haya producido �ste, el Ministerio de Justicia ordenar� la publicaci�n en el\r\n" + 
				"Bolet�n Oficial del Estado de la convocatoria p�blica de candidatos.\r\n" + 
				"Previa evaluaci�n del m�rito, capacidad, competencia e idoneidad de los candidatos, el\r\n" + 
				"Gobierno remitir� al Congreso de los Diputados una propuesta de Presidencia y Adjunto\r\n" + 
				"acompa�ada de un informe justificativo que, tras la celebraci�n de la preceptiva audiencia de\r\n" + 
				"los candidatos, deber� ser ratificada por la Comisi�n de Justicia en votaci�n p�blica por\r\n" + 
				"mayor�a de tres quintos de sus miembros en primera votaci�n o, de no alcanzarse �sta, por\r\n" + 
				"mayor�a absoluta en segunda votaci�n, que se realizar� inmediatamente despu�s de la\r\n" + 
				"primera. En este �ltimo supuesto, los votos favorables deber�n proceder de Diputados\r\n" + 
				"pertenecientes, al menos, a dos grupos parlamentarios diferentes.\r\n" + 
				"4. La Presidencia y el Adjunto de la Agencia Espa�ola de Protecci�n de Datos ser�n\r\n" + 
				"nombrados por el Consejo de Ministros mediante real decreto.5. El mandato de la Presidencia y del Adjunto de la Agencia Espa�ola de Protecci�n de\r\n" + 
				"Datos tiene una duraci�n de cinco a�os y puede ser renovado para otro per�odo de igual\r\n" + 
				"duraci�n.\r\n" + 
				"La Presidencia y el Adjunto solo cesar�n antes de la expiraci�n de su mandato, a\r\n" + 
				"petici�n propia o por separaci�n acordada por el Consejo de Ministros, por:\r\n" + 
				"a) Incumplimiento grave de sus obligaciones,\r\n" + 
				"b) incapacidad sobrevenida para el ejercicio de su funci�n,\r\n" + 
				"c) incompatibilidad, o\r\n" + 
				"d) condena firme por delito doloso.\r\n" + 
				"En los supuestos previstos en las letras a), b) y c) ser� necesaria la ratificaci�n de la\r\n" + 
				"separaci�n por las mayor�as parlamentarias previstas en el apartado 3 de este art�culo.\r\n" + 
				"6. Los actos y disposiciones dictados por la Presidencia de la Agencia Espa�ola de\r\n" + 
				"Protecci�n de Datos ponen fin a la v�a administrativa, siendo recurribles, directamente, ante\r\n" + 
				"la Sala de lo Contencioso-administrativo de la Audiencia Nacional."+
				"\n" + 	
				"Art�culo 49. Consejo Consultivo de la Agencia Espa�ola de Protecci�n de Datos.\r\n" + 
				"1. La Presidencia de la Agencia Espa�ola de Protecci�n de Datos estar� asesorada por\r\n" + 
				"un Consejo Consultivo compuesto por los siguientes miembros:\r\n" + 
				"a) Un Diputado, propuesto por el Congreso de los Diputados.\r\n" + 
				"b) Un Senador, propuesto por el Senado.\r\n" + 
				"c) Un representante designado por el Consejo General del Poder Judicial.\r\n" + 
				"d) Un representante de la Administraci�n General del Estado con experiencia en la\r\n" + 
				"materia, propuesto por el Ministro de Justicia.\r\n" + 
				"e) Un representante de cada Comunidad Aut�noma que haya creado una Autoridad de\r\n" + 
				"protecci�n de datos en su �mbito territorial, propuesto de acuerdo con lo que establezca la\r\n" + 
				"respectiva Comunidad Aut�noma.\r\n" + 
				"f) Un experto propuesto por la Federaci�n Espa�ola de Municipios y Provincias.\r\n" + 
				"g) Un experto propuesto por el Consejo de Consumidores y Usuarios.\r\n" + 
				"h) Dos expertos propuestos por las Organizaciones Empresariales.\r\n" + 
				"i) Un representante de los profesionales de la protecci�n de datos y de la privacidad,\r\n" + 
				"propuesto por la asociaci�n de �mbito estatal con mayor n�mero de asociados.\r\n" + 
				"j) Un representante de los organismos o entidades de supervisi�n y resoluci�n\r\n" + 
				"extrajudicial de conflictos previstos en el Cap�tulo IV del T�tulo V, propuesto por el Ministro de\r\n" + 
				"Justicia.\r\n" + 
				"k) Un experto, propuesto por la Conferencia de Rectores de las Universidades\r\n" + 
				"Espa�olas.\r\n" + 
				"l) Un representante de las organizaciones que agrupan a los Consejos Generales,\r\n" + 
				"Superiores y Colegios Profesionales de �mbito estatal de las diferentes profesiones\r\n" + 
				"colegiadas, propuesto por el Ministro de Justicia.\r\n" + 
				"m) Un representante de los profesionales de la seguridad de la informaci�n, propuesto\r\n" + 
				"por la asociaci�n de �mbito estatal con mayor n�mero de asociados.\r\n" + 
				"n) Un experto en transparencia y acceso a la informaci�n p�blica propuesto por el\r\n" + 
				"Consejo de Transparencia y Buen Gobierno.\r\n" + 
				"�) Dos expertos propuestos por las organizaciones sindicales m�s representativas.\r\n" + 
				"2. A los efectos del apartado anterior, la condici�n de experto requerir� acreditar\r\n" + 
				"conocimientos especializados en el Derecho y la pr�ctica en materia de protecci�n de datos\r\n" + 
				"mediante el ejercicio profesional o acad�mico.\r\n" + 
				"3. Los miembros del Consejo Consultivo ser�n nombrados por orden del Ministro de\r\n" + 
				"Justicia, publicada en el Bolet�n Oficial del Estado.\r\n" + 
				"4. El Consejo Consultivo se reunir� cuando as� lo disponga la Presidencia de la Agencia\r\n" + 
				"Espa�ola de Protecci�n de Datos y, en todo caso, una vez al semestre.\r\n" + 
				"5. Las decisiones tomadas por el Consejo Consultivo no tendr�n en ning�n caso car�cter\r\n" + 
				"vinculante."+
				"6. En todo lo no previsto por esta ley org�nica, el r�gimen, competencias y\r\n" + 
				"funcionamiento del Consejo Consultivo ser�n los establecidos en el Estatuto Org�nico de la\r\n" + 
				"Agencia Espa�ola de Protecci�n de Datos.\r\n" + 
				"\n" + 	
				"Art�culo 50. Publicidad.\r\n" + 
				"La Agencia Espa�ola de Protecci�n de Datos publicar� las resoluciones de su\r\n" + 
				"Presidencia que declaren haber lugar o no a la atenci�n de los derechos reconocidos en los\r\n" + 
				"art�culos 15 a 22 del Reglamento (UE) 2016/679, las que pongan fin a los procedimientos de\r\n" + 
				"reclamaci�n, las que archiven las actuaciones previas de investigaci�n, las que sancionen\r\n" + 
				"con apercibimiento a las entidades a que se refiere el art�culo 77.1 de esta ley org�nica, las\r\n" + 
				"que impongan medidas cautelares y las dem�s que disponga su Estatuto.\r\n" + 
				""+
				"\n" + 	
				"Para m�s informaci�n, no dude en consultar:"+
				"\n" + 	
				"BOLET�N OFICIAL DEL ESTADO"+ "\n" + 
				"LEGISLACI�N CONSOLIDADA"+
				"T�TULO VII\r\n" + 
				"Autoridades de protecci�n de datos\r\n" +
				""
				);
	}
	

}

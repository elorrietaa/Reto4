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
	 * Método mostrarBaseslegales = se muestran en el textField del panelbasesLegales las bases legales
	 */
	public void mostrarBaseslegales() {
		vista.bases.txBases.setText("BOLETÍN OFICIAL DEL ESTADO"+ "\n" + 
				"LEGISLACIÓN CONSOLIDADA"+
				"TÍTULO VII\r\n" + 
				"Autoridades de protección de datos\r\n" + 
				"CAPÍTULO I\r\n" + 
				"La Agencia Española de Protección de Datos\r\n" + 
				"Sección 1.ª Disposiciones generales\r\n" + 
				 "\n" + 
				"Artículo 44. Disposiciones generales.\r\n" + 
				"1. La Agencia Española de Protección de Datos es una autoridad administrativa\r\n" + 
				"independiente de ámbito estatal, de las previstas en la Ley 40/2015, de 1 de octubre, de\r\n" + 
				"Régimen Jurídico del Sector Público, con personalidad jurídica y plena capacidad pública y\r\n" + 
				"privada, que actúa con plena independencia de los poderes públicos en el ejercicio de sus\r\n" + 
				"funciones.\r\n" + 
				"Su denominación oficial, de conformidad con lo establecido en el artículo 109.3 de la Ley\r\n" + 
				"40/2015, de 1 de octubre, de Régimen Jurídico del Sector Público, será «Agencia Española\r\n" + 
				"de Protección de Datos, Autoridad Administrativa Independiente».\r\n" + 
				"Se relaciona con el Gobierno a través del Ministerio de Justicia.\r\n" + 
				"2. La Agencia Española de Protección de Datos tendrá la condición de representante\r\n" + 
				"común de las autoridades de protección de datos del Reino de España en el Comité Europeo\r\n" + 
				"de Protección de Datos.\r\n" + 
				"3. La Agencia Española de Protección de Datos y el Consejo General del Poder Judicial\r\n" + 
				"colaborarán en aras del adecuado ejercicio de las respectivas competencias que la Ley\r\n" + 
				"Orgánica 6/1985, de 1 julio, del Poder Judicial, les atribuye en materia de protección de\r\n" + 
				"datos personales en el ámbito de la Administración de Justicia.\r\n" + 
				"\n" + 
				"Artículo 45. Régimen jurídico.\r\n" + 
				"1. La Agencia Española de Protección de Datos se rige por lo dispuesto en el\r\n" + 
				"Reglamento (UE) 2016/679, la presente ley orgánica y sus disposiciones de desarrollo.\r\n" + 
				"Supletoriamente, en cuanto sea compatible con su plena independencia y sin perjuicio\r\n" + 
				"de lo previsto en el artículo 63.2 de esta ley orgánica, se regirá por las normas citadas en el\r\n" + 
				"artículo 110.1 de la Ley 40/2015, de 1 de octubre, de Régimen Jurídico del Sector Público.\r\n" + 
				"2. El Gobierno, a propuesta de la Agencia Española de Protección de Datos, aprobará su\r\n" + 
				"Estatuto mediante real decreto.\r\n" + 
				"\n" + 
				"Artículo 46. Régimen económico presupuestario y de personal.\r\n" + 
				"1. La Agencia Española de Protección de Datos elaborará y aprobará su presupuesto y\r\n" + 
				"lo remitirá al Gobierno para que sea integrado, con independencia, en los Presupuestos\r\n" + 
				"Generales del Estado.\r\n" + 
				"2. El régimen de modificaciones y de vinculación de los créditos de su presupuesto será\r\n" + 
				"el establecido en el Estatuto de la Agencia Española de Protección de Datos.\r\n" + 
				"Corresponde a la Presidencia de la Agencia Española de Protección de Datos autorizar\r\n" + 
				"las modificaciones presupuestarias que impliquen hasta un tres por ciento de la cifra inicial\r\n" + 
				"de su presupuesto total de gastos, siempre que no se incrementen los créditos para gastos\r\n" + 
				"de personal. Las restantes modificaciones que no excedan de un cinco por ciento del\r\n" + 
				"presupuesto serán autorizadas por el Ministerio de Hacienda y, en los demás casos, por el\r\n" + 
				"Gobierno.\r\n" + 
				"3. La Agencia Española de Protección de Datos contará para el cumplimiento de sus\r\n" + 
				"fines con las asignaciones que se establezcan con cargo a los Presupuestos Generales del\r\n" + 
				"Estado, los bienes y valores que constituyan su patrimonio y los ingresos, ordinarios y\r\n" + 
				"extraordinarios derivados del ejercicio de sus actividades, incluidos los derivados del\r\n" + 
				"ejercicio de las potestades establecidos en el artículo 58 del Reglamento (UE) 2016/679." + 
				"4. El resultado positivo de sus ingresos se destinará por la Agencia Española de\r\n" + 
				"Protección de Datos a la dotación de sus reservas con el fin de garantizar su plena\r\n" + 
				"independencia.\r\n" + 
				"5. El personal al servicio de la Agencia Española de Protección de Datos será\r\n" + 
				"funcionario o laboral y se regirá por lo previsto en el texto refundido de la Ley del Estatuto\r\n" + 
				"Básico del Empleado Público, aprobado por Real Decreto Legislativo 5/2015, de 30 de\r\n" + 
				"octubre, y demás normativa reguladora de los funcionarios públicos y, en su caso, por la\r\n" + 
				"normativa laboral.\r\n" + 
				"6. La Agencia Española de Protección Datos elaborará y aprobará su relación de\r\n" + 
				"puestos de trabajo, en el marco de los criterios establecidos por el Ministerio de Hacienda,\r\n" + 
				"respetando el límite de gasto de personal establecido en el presupuesto. En dicha relación\r\n" + 
				"de puestos de trabajo constarán, en todo caso, aquellos puestos que deban ser\r\n" + 
				"desempeñados en exclusiva por funcionarios públicos, por consistir en el ejercicio de las\r\n" + 
				"funciones que impliquen la participación directa o indirecta en el ejercicio de potestades\r\n" + 
				"públicas y la salvaguarda de los intereses generales del Estado y de las Administraciones\r\n" + 
				"Públicas.\r\n" + 
				"7. Sin perjuicio de las competencias atribuidas al Tribunal de Cuentas, la gestión\r\n" + 
				"económico-financiera de la Agencia Española de Protección de Datos estará sometida al\r\n" + 
				"control de la Intervención General de la Administración del Estado en los términos que\r\n" + 
				"establece la Ley 47/2003, de 26 de noviembre, General Presupuestaria.\r\n" + 
				"Artículo 47. Funciones y potestades de la Agencia Española de Protección de Datos.\r\n" + 
				"Corresponde a la Agencia Española de Protección de Datos supervisar la aplicación de\r\n" + 
				"esta ley orgánica y del Reglamento (UE) 2016/679 y, en particular, ejercer las funciones\r\n" + 
				"establecidas en el artículo 57 y las potestades previstas en el artículo 58 del mismo\r\n" + 
				"reglamento, en la presente ley orgánica y en sus disposiciones de desarrollo.\r\n" + 
				"Asimismo, corresponde a la Agencia Española de Protección de Datos el desempeño de\r\n" + 
				"las funciones y potestades que le atribuyan otras leyes o normas de Derecho de la Unión\r\n" + 
				"Europea.\r\n" + 
				"\n" + 
				"Artículo 48. La Presidencia de la Agencia Española de Protección de Datos.\r\n" + 
				"1. La Presidencia de la Agencia Española de Protección de Datos la dirige, ostenta su\r\n" + 
				"representación y dicta sus resoluciones, circulares y directrices.\r\n" + 
				"2. La Presidencia de la Agencia Española de Protección de Datos estará auxiliada por un\r\n" + 
				"Adjunto en el que podrá delegar sus funciones, a excepción de las relacionadas con los\r\n" + 
				"procedimientos regulados por el Título VIII de esta ley orgánica, y que la sustituirá en el\r\n" + 
				"ejercicio de las mismas en los términos previstos en el Estatuto Orgánico de la Agencia\r\n" + 
				"Española de Protección de Datos.\r\n" + 
				"Ambos ejercerán sus funciones con plena independencia y objetividad y no estarán\r\n" + 
				"sujetos a instrucción alguna en su desempeño. Les será aplicable la legislación reguladora\r\n" + 
				"del ejercicio del alto cargo de la Administración General del Estado.\r\n" + 
				"3. La Presidencia de la Agencia Española de Protección de Datos y su Adjunto serán\r\n" + 
				"nombrados por el Gobierno, a propuesta del Ministerio de Justicia, entre personas de\r\n" + 
				"reconocida competencia profesional, en particular en materia de protección de datos.\r\n" + 
				"Dos meses antes de producirse la expiración del mandato o, en el resto de las causas de\r\n" + 
				"cese, cuando se haya producido éste, el Ministerio de Justicia ordenará la publicación en el\r\n" + 
				"Boletín Oficial del Estado de la convocatoria pública de candidatos.\r\n" + 
				"Previa evaluación del mérito, capacidad, competencia e idoneidad de los candidatos, el\r\n" + 
				"Gobierno remitirá al Congreso de los Diputados una propuesta de Presidencia y Adjunto\r\n" + 
				"acompañada de un informe justificativo que, tras la celebración de la preceptiva audiencia de\r\n" + 
				"los candidatos, deberá ser ratificada por la Comisión de Justicia en votación pública por\r\n" + 
				"mayoría de tres quintos de sus miembros en primera votación o, de no alcanzarse ésta, por\r\n" + 
				"mayoría absoluta en segunda votación, que se realizará inmediatamente después de la\r\n" + 
				"primera. En este último supuesto, los votos favorables deberán proceder de Diputados\r\n" + 
				"pertenecientes, al menos, a dos grupos parlamentarios diferentes.\r\n" + 
				"4. La Presidencia y el Adjunto de la Agencia Española de Protección de Datos serán\r\n" + 
				"nombrados por el Consejo de Ministros mediante real decreto.5. El mandato de la Presidencia y del Adjunto de la Agencia Española de Protección de\r\n" + 
				"Datos tiene una duración de cinco años y puede ser renovado para otro período de igual\r\n" + 
				"duración.\r\n" + 
				"La Presidencia y el Adjunto solo cesarán antes de la expiración de su mandato, a\r\n" + 
				"petición propia o por separación acordada por el Consejo de Ministros, por:\r\n" + 
				"a) Incumplimiento grave de sus obligaciones,\r\n" + 
				"b) incapacidad sobrevenida para el ejercicio de su función,\r\n" + 
				"c) incompatibilidad, o\r\n" + 
				"d) condena firme por delito doloso.\r\n" + 
				"En los supuestos previstos en las letras a), b) y c) será necesaria la ratificación de la\r\n" + 
				"separación por las mayorías parlamentarias previstas en el apartado 3 de este artículo.\r\n" + 
				"6. Los actos y disposiciones dictados por la Presidencia de la Agencia Española de\r\n" + 
				"Protección de Datos ponen fin a la vía administrativa, siendo recurribles, directamente, ante\r\n" + 
				"la Sala de lo Contencioso-administrativo de la Audiencia Nacional."+
				"\n" + 	
				"Artículo 49. Consejo Consultivo de la Agencia Española de Protección de Datos.\r\n" + 
				"1. La Presidencia de la Agencia Española de Protección de Datos estará asesorada por\r\n" + 
				"un Consejo Consultivo compuesto por los siguientes miembros:\r\n" + 
				"a) Un Diputado, propuesto por el Congreso de los Diputados.\r\n" + 
				"b) Un Senador, propuesto por el Senado.\r\n" + 
				"c) Un representante designado por el Consejo General del Poder Judicial.\r\n" + 
				"d) Un representante de la Administración General del Estado con experiencia en la\r\n" + 
				"materia, propuesto por el Ministro de Justicia.\r\n" + 
				"e) Un representante de cada Comunidad Autónoma que haya creado una Autoridad de\r\n" + 
				"protección de datos en su ámbito territorial, propuesto de acuerdo con lo que establezca la\r\n" + 
				"respectiva Comunidad Autónoma.\r\n" + 
				"f) Un experto propuesto por la Federación Española de Municipios y Provincias.\r\n" + 
				"g) Un experto propuesto por el Consejo de Consumidores y Usuarios.\r\n" + 
				"h) Dos expertos propuestos por las Organizaciones Empresariales.\r\n" + 
				"i) Un representante de los profesionales de la protección de datos y de la privacidad,\r\n" + 
				"propuesto por la asociación de ámbito estatal con mayor número de asociados.\r\n" + 
				"j) Un representante de los organismos o entidades de supervisión y resolución\r\n" + 
				"extrajudicial de conflictos previstos en el Capítulo IV del Título V, propuesto por el Ministro de\r\n" + 
				"Justicia.\r\n" + 
				"k) Un experto, propuesto por la Conferencia de Rectores de las Universidades\r\n" + 
				"Españolas.\r\n" + 
				"l) Un representante de las organizaciones que agrupan a los Consejos Generales,\r\n" + 
				"Superiores y Colegios Profesionales de ámbito estatal de las diferentes profesiones\r\n" + 
				"colegiadas, propuesto por el Ministro de Justicia.\r\n" + 
				"m) Un representante de los profesionales de la seguridad de la información, propuesto\r\n" + 
				"por la asociación de ámbito estatal con mayor número de asociados.\r\n" + 
				"n) Un experto en transparencia y acceso a la información pública propuesto por el\r\n" + 
				"Consejo de Transparencia y Buen Gobierno.\r\n" + 
				"ñ) Dos expertos propuestos por las organizaciones sindicales más representativas.\r\n" + 
				"2. A los efectos del apartado anterior, la condición de experto requerirá acreditar\r\n" + 
				"conocimientos especializados en el Derecho y la práctica en materia de protección de datos\r\n" + 
				"mediante el ejercicio profesional o académico.\r\n" + 
				"3. Los miembros del Consejo Consultivo serán nombrados por orden del Ministro de\r\n" + 
				"Justicia, publicada en el Boletín Oficial del Estado.\r\n" + 
				"4. El Consejo Consultivo se reunirá cuando así lo disponga la Presidencia de la Agencia\r\n" + 
				"Española de Protección de Datos y, en todo caso, una vez al semestre.\r\n" + 
				"5. Las decisiones tomadas por el Consejo Consultivo no tendrán en ningún caso carácter\r\n" + 
				"vinculante."+
				"6. En todo lo no previsto por esta ley orgánica, el régimen, competencias y\r\n" + 
				"funcionamiento del Consejo Consultivo serán los establecidos en el Estatuto Orgánico de la\r\n" + 
				"Agencia Española de Protección de Datos.\r\n" + 
				"\n" + 	
				"Artículo 50. Publicidad.\r\n" + 
				"La Agencia Española de Protección de Datos publicará las resoluciones de su\r\n" + 
				"Presidencia que declaren haber lugar o no a la atención de los derechos reconocidos en los\r\n" + 
				"artículos 15 a 22 del Reglamento (UE) 2016/679, las que pongan fin a los procedimientos de\r\n" + 
				"reclamación, las que archiven las actuaciones previas de investigación, las que sancionen\r\n" + 
				"con apercibimiento a las entidades a que se refiere el artículo 77.1 de esta ley orgánica, las\r\n" + 
				"que impongan medidas cautelares y las demás que disponga su Estatuto.\r\n" + 
				""+
				"\n" + 	
				"Para más información, no dude en consultar:"+
				"\n" + 	
				"BOLETÍN OFICIAL DEL ESTADO"+ "\n" + 
				"LEGISLACIÓN CONSOLIDADA"+
				"TÍTULO VII\r\n" + 
				"Autoridades de protección de datos\r\n" +
				""
				);
	}
	

}

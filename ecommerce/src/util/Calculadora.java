package util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

//Retorna o intervalo de tempo em segundos

public class Calculadora {
	public static Long calculaIntervaloTempo(Long inicio, Long fim) {
		return (inicio - fim)/ 1000;
	} 

}

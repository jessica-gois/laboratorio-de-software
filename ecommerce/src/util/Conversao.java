package util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversao {
	
	public static Integer parseStringToInt (String parameter) {
		int number=0;
		if(parameter!=""){
		  number = Integer.parseInt(parameter);
		}
		return number;
	}
	
	public static Double parseStringToDouble (String parameter) {
		Double number= 0.0;
		if(parameter!=""){
		  number = Double.parseDouble(parameter);
		}
		return number;
	}
	
	public static Date parseStringToDate (String parameter) throws ParseException {
		Date data = null;
		if(parameter!=""){
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		data = sdf.parse(parameter);
		}
		return data;
	}
	
	public static Boolean parseStringToBoolean (String parameter) {
		Boolean b= true;
		if(parameter!=""){
		  b = Boolean.parseBoolean(parameter);
		}
		return b;
	}
	

}

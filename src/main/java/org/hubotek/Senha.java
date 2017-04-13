package org.hubotek;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Senha {

	public Senha() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(senhaCorreta());
		System.out.println(senhaCorreta1());
		testOr();
	}

	public static String senhaCorreta() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		Date d = new Date(System.currentTimeMillis());
		cal.setTime(d);
		String retorno="";
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			 cal.add(Calendar.DATE, -1);    
		} else {
			cal.add(Calendar.WEEK_OF_YEAR, -1);
			cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		}
		retorno = df.format(cal.getTime()).replace("/", "").substring(0, 4);
		return retorno;
	}
	
	public static String senhaCorreta1() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		Date d = new Date(System.currentTimeMillis());
		cal.setTime(d);
		String retorno="";
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			 cal.add(Calendar.DATE, -1);    
		} else {
			cal.add(Calendar.WEEK_OF_YEAR, -1);
			cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		}
		retorno = df.format(cal.getTime()).replace("/", "");
		return retorno;
	}
	
	public static void testOr()
	{ 
		if (verificaPerfil("FEC-NPV") 
				|| verificaPerfil("FEC-ASAG") 
				|| verificaPerfil("FEC-GPV") 
				|| verificaPerfil("FEC-NPV-REM") 
				|| verificaPerfil("FEC-ASAG-REM") 
				|| verificaPerfil("FEC-GG-REM") 
				|| verificaPerfil("FEC-CDN-REM") 
				|| verificaPerfil("FEC-GPA") 
				|| verificaPerfil("FEC-CDN"));
	}

	private static boolean verificaPerfil(String string) {
		System.out.println(string);
		return true;
	}
}

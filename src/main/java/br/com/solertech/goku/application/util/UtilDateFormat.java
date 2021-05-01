package br.com.solertech.goku.application.util;

import org.springframework.stereotype.Component;

@Component
public class UtilDateFormat {

	public String dateConverter(String dateEnter)  {
		
		//02/03/1974
		
		
		String dateNew = dateEnter.substring(6, 10) + "-" +  dateEnter.substring(3, 5) + "-" +  dateEnter.substring(0, 2);
		
		
//		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
//		Date data = null;
//		try {
//			data = formato.parse(dateEnter);
//		} catch (java.text.ParseException e) {
//			e.printStackTrace();
//		}
		
		
//		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate date  = LocalDate.parse(dateEnter,formatterDate);
//		String data = date.toString(); 
//		
		return dateNew;

	}
	
	
//		@Override
//		public LocalDate convert(String value) {
//			if(value != null) {
//			     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			return LocalDate.parse(value, formatter);
//			}else {
//				return null;
//			}
//		}

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

/**
 *
 * @author g170959
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexTest {
	private static final String PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
	public static boolean validate(final String date){	
	Pattern pattern = Pattern.compile(PATTERN); 	
	Matcher matcher = pattern.matcher(date);
     if(matcher.matches()){				 
		 matcher.reset();					  
		 if(matcher.find()){			
	         String day = matcher.group(1);
		     String month = matcher.group(2);
		     int year = Integer.parseInt(matcher.group(3));
 
		     if (day.equals("31") && 
			  (month.equals("4") || month .equals("6") || month.equals("9") ||
	                  month.equals("11") || month.equals("04") || month .equals("06") ||
	                  month.equals("09"))) {
				return false;
		     } else if (month.equals("2") || month.equals("02")) {
			  if(year % 4==0){
				  if(day.equals("30") || day.equals("31")){
					  return false;
				  }else{
					  return true;
				  }
			  }else{
			         if(day.equals("29")||day.equals("30")||day.equals("31")){
					  return false;
			         }else{
					  return true;
				  }
			  }
		      }else{				 
			return true;				 
		      }
		   }else{
	    	      return false;
		   }		  
	     }else{
		  return false;
	     }			    
    }
	public static void main(String args[]){ 
		List<String> values = new ArrayList<String>();	
		values.add("9/4/2018"); 
		values.add("09/04/2018"); 
		values.add("39/4/2018");
		values.add("31/11/2010");		
 
		for (String value : values){
		  if(validate(value)){
			  System.out.println("Date "+ value +" is valid");
		  }else{
			  System.out.println("Date "+ value +" is invalid");
		  }		  
		}
	}
}

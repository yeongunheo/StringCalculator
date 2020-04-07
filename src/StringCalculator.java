package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int add(String text) {
		if (text == null || text.isEmpty() || text == " ") return 0;
		if (text.charAt(0) == '-') {
			throw new RuntimeException();
		}
		
		int number = 0;
		try {
			number = Integer.parseInt(text);		
			return number;
		}catch(NumberFormatException e) {
			
			try {
				String str[] = text.split(",|:");
				for (int i = 0; i < str.length; i++) {
					number += Integer.parseInt(str[i]);
				}	
			}catch(NumberFormatException ex) {
				Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
				if(m.find()) {
					String customDelimeter = m.group(1);
					String tokens[] = m.group(2).split(customDelimeter);
				
					for (int i = 0; i < tokens.length; i++) {
						number += Integer.parseInt(tokens[i]);
					}	
					
					return number;
				}
			}
			
			return number;
		}
		
	}

}

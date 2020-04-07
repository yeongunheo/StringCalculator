package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int add(String text) {
		if (text == null || text.isEmpty()) return 0;
		
		String[] str = split(text);
		
		int number = 0;
		number = sum(str);
		
		return number;
	}
	
	public String[] split(String text) {
		String[] str = text.split(",|:");
		if (text.charAt(0) == '/') str = custiomDelimeter(text);
		
		return str;
	}
	
	public int sum(String[] str) {
		int number = 0;
		for (int i = 0; i < str.length; i++) {
			negativeException(str[i]);
			number += Integer.parseInt(str[i]);
		}	
		return number;
	}
	
	public String[] custiomDelimeter(String text) {
		Pattern p = Pattern.compile("//(.)\n(.*)");
		Matcher m = p.matcher(text);
		
		String customDelimeter;
		String[] str = null;
		if (m.find()) {
			customDelimeter = m.group(1);
			str = m.group(2).split(customDelimeter);
		}
		
		return str;
	}
	
	// 반복문과 조건문을 동시에 사용하지 않고
	// 즉, 인덴트의 길이를 1로 유지하면서 음수 전달 예외처리를 어떻게 할 것인가
	// 메소드화한다.
	public void negativeException(String str) {
		if (Integer.parseInt(str) < 0) {
			throw new RuntimeException();
		}
	}
	
}

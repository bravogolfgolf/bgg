package stringCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	private final String COMMA = ",";
	private final String NEW_LINE = System.getProperty("line.separator");
	private String delimiterRegularExpression = COMMA + NEW_LINE;
	private String unSplitString;
	private List<Integer> positive = new ArrayList<Integer>();
	private List<Integer> negative = new ArrayList<Integer>();
	int sum = 0;

	public int add(String input) {
		unSplitString = input;
		if(isNotEmpty(input)){		
			if (checkForDefaultDelimiter(input))
				if (hasDefaultDelimiter(input)) {
					modifyDelimiterRegularExpression(input);
					removeDefaultDelimiterFrom(input);}
			createArraysFrom(unSplitString);
			calculate();
		}
		return sum;
	}

	private boolean isNotEmpty(String input) {
		return !input.isEmpty();
	}

	private boolean checkForDefaultDelimiter(String input) {
		return input.length() > 2;
	}

	private boolean hasDefaultDelimiter(String input) {
		final String DELIMITER_MARKER = "//";
		return input.substring(0,2).equals(DELIMITER_MARKER);
	}

	private void modifyDelimiterRegularExpression(String input) {
		delimiterRegularExpression += getDefaultDelimiterFrom(input);
	}

	private String getDefaultDelimiterFrom(String input) {
		return input.substring(2,3);
	}

	private void removeDefaultDelimiterFrom(String input) {
		String[] splitInput = input.split(NEW_LINE,2);
		unSplitString =  splitInput[1];
	}

	private void createArraysFrom(String input) {
		String[] temp = input.split("[" + delimiterRegularExpression + "]");
		for(int i = 0; i < temp.length; i++){
			if (Integer.parseInt(temp[i].toString()) >0){
				positive.add(Integer.parseInt(temp[i].toString()));				
			}else{
				negative.add(Integer.parseInt(temp[i].toString()));
			}
		}
	}

	private void calculate() {
		for(int i : positive)
			sum += i;
	}
}
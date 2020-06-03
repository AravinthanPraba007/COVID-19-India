package com.aravinthan.covid19.service;

public class NumberFormatHelperService {

	public static String readableNumberFormat(String value){
        value=value.replace(",","");
        char lastDigit=value.charAt(value.length()-1);
        StringBuilder result = new StringBuilder();
        int len = value.length()-1;
        int nDigits = 0;

        for (int i = len - 1; i >= 0; i--)
        {
            result.insert(0,value.charAt(i));
            // result = value.charAt(i) + result;
            nDigits++;
            if (((nDigits % 2) == 0) && (i > 0))
            {
                result.insert(0,",");
                // result = "," + result;
            }
        }
        result.append(lastDigit);
        // return (result+lastDigit);
        value=result.toString();
        return value;
    }
}

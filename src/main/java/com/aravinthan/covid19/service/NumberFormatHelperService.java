package com.aravinthan.covid19.service;

import org.springframework.stereotype.Service;

@Service
public class NumberFormatHelperService {

	public String readableNumberFormat(String value){
//		System.out.println("value entered is -->"+value);
		if(value.equals("0"))
			return value;
        value=value.replace(",","");
        char lastDigit=value.charAt(value.length()-1);
//        StringBuilder result = new StringBuilder();
        String result="";
        int len = value.length()-1;
        int nDigits = 0;

        for (int i = len - 1; i >= 0; i--)
        {
//            result.insert(0,value.charAt(i));
             result = value.charAt(i) + result;
            nDigits++;
            if (((nDigits % 2) == 0) && (i > 0))
            {
//                result.insert(0,",");
                 result = "," + result;
            }
        }
//        result.append(lastDigit);
//        System.out.println("return value-->"+result+lastDigit);
         return (result+lastDigit);
//        value=result.toString();
//        result.setLength(0);
//        System.out.println("value returned -->"+result);
//        return value;
    }
}

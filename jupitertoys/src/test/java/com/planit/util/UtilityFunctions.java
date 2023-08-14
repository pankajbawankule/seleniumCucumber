package com.planit.util;

import java.util.Map;
import java.util.Objects;

public class UtilityFunctions {
    public static String removeLastCharacters(String inputString, int numberOfCharactersToRemove){
        String outputString = null;
        if((inputString!=null) && (inputString.length()>0)){
            outputString=inputString.substring(0,inputString.length() -numberOfCharactersToRemove);
        }
        return outputString;
    }

    public static boolean isDataPresent(Map<String,String> data, String key){
        if(Objects.nonNull(data.get(key))){
            if(data.containsKey(key) && !data.get(key).isEmpty()){
                return true;
            }
            return false;
        }
        return false;
    }
}

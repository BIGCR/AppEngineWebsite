package com.example.myproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilsHelper {
	private List temp;
	
	public static List<String> getTextListForDetection(String textToDetect){
		List<String> list = new ArrayList<String>(Arrays.asList(textToDetect.split(" ")));
		
		return list;
	}
	
	public static List<String> getTextListForSentence(String textToDetect){
		List<String> list = new ArrayList<String>(Arrays.asList(textToDetect));
		
		return list;
	}
	
}

package com.example.beans;

import java.beans.Beans;

public class GoogleAPIBean extends Beans{
	private String textToTranslate;

	public GoogleAPIBean(){
		super();
	}
	
	public String getTextToTranslate() {
		return textToTranslate;
	}

	public void setTextToTranslate(String textToTranslate) {
		this.textToTranslate = textToTranslate;
	}
	
	
}

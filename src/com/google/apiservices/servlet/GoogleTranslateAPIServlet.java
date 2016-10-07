package com.google.apiservices.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.constants.Constants;
import com.example.myproject.UtilsHelper;
import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.Translate.Languages;
import com.google.api.services.translate.TranslateRequestInitializer;
import com.google.api.services.translate.model.LanguagesListResponse;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.apiservices.GoogleAPIKeyHelper;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class GoogleTranslateAPIServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println(req.getParameterMap());
		
		String langInit = req.getParameter("langDropDownInit");
		//String temp = req.getParameter("textToTranslate").replaceAll("\\s"," ").trim();
		//System.out.println(temp);
		//System.out.println(req.getParameter("targetLang"));
		System.out.println(langInit);
		

		JSONObject obj = null;
		
		switch(langInit){
			case "true":
			try {
				obj = languageApi();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case "false":
			try {
				obj = googleTranslateApi("temp", "es");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break; 
			default:
				break;
		}
		
		
		
		//generateGoogleTranslateApi(temp.replaceAll("\\s", "+"));
		//detectLanguage(temp.replaceAll("\\s", "+"));
		
		//detectLanguage(req.getParameter("textToTranslate"));
		
		resp.setContentType("application/json");     
		PrintWriter out = resp.getWriter(); 
		out.print(obj);
		out.flush();
		
		
		
	}
	
	private JSONObject googleTranslateApi(String textToDetect, String targetLang) throws IOException, JSONException{
		HttpTransport httpTransport = new UrlFetchTransport();
	    JsonFactory jsonFactory = new JacksonFactory();
	    
	    Translate translate = new Translate.Builder(httpTransport, jsonFactory, null).setApplicationName("website-resume")
	    		.setGoogleClientRequestInitializer(new TranslateRequestInitializer(GoogleAPIKeyHelper.getGoogletranslatekey())).build();
	    
	    TranslationsListResponse translationResponse = translate.translations().list(UtilsHelper.getTextListForSentence(textToDetect), targetLang).execute();
	    
	    JSONObject json = new JSONObject(translationResponse.toString());
	    
	    return json;		
	}
	
	private JSONObject languageApi() throws IOException, JSONException{
		Translate translate = new Translate.Builder(Constants.HTTP_TRANSPORT, Constants.JSON_FACTORY, null).setApplicationName("website-resume")
	    		.setGoogleClientRequestInitializer(new TranslateRequestInitializer(GoogleAPIKeyHelper.getGoogletranslatekey())).build();
		
		LanguagesListResponse languageListResponse = translate.languages().list().execute();
		Locale temp = new Locale("gu");
		temp.getDisplayLanguage();
		System.out.println(temp.getDisplayLanguage());
		
		
		JSONObject json = new JSONObject(languageListResponse.toString());
		
		return json;
	}
	
	private String detectLanguage(String textToDetect) throws IOException{
			    
	    Translate translate = new Translate.Builder(Constants.HTTP_TRANSPORT, Constants.JSON_FACTORY, null).setApplicationName("website-resume")
	    		.setGoogleClientRequestInitializer(new TranslateRequestInitializer(GoogleAPIKeyHelper.getGoogletranslatekey())).build();
		
	  
	    
	    //DetectionsListResponse detectionResponse = translate.detections().list(UtilsHelper.getTextListForDetection(textToDetect)).execute();
	    //LanguagesListResponse languageResponse = translate.languages().list().execute();
	    
	    TranslationsListResponse translationResponse = translate.translations().list(UtilsHelper.getTextListForSentence(textToDetect), "es").execute();

	    
	    String translatedText = translationResponse.getTranslations().get(0).getTranslatedText();
	    
	    System.out.println(translationResponse);
	    System.out.println("Translated Text: "+translatedText);
	    
		/*

	    resp.setContentType("text/html");
	    resp.setStatus(200);
	    Writer writer = resp.getWriter();
	    writer.write("<ul>");
	    for (Activity a : myActivities) {
	      writer.write("<li>" + a.getTitle() + "</li>");
	    }
	    writer.write("</ul>");
		
	  }
		*/
		
		return null;
	}	
}

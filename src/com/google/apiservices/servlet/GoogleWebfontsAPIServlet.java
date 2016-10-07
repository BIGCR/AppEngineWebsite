package com.google.apiservices.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.constants.Constants;
import com.google.api.services.webfonts.Webfonts;
import com.google.api.services.webfonts.WebfontsRequestInitializer;
import com.google.api.services.webfonts.model.WebfontList;
import com.google.apiservices.GoogleAPIKeyHelper;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class GoogleWebfontsAPIServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		JSONObject obj = null;
		
		try {
			obj = webfontsAPI();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter(); 
		out.print(obj);
		out.flush();
		
	}
	
	public JSONObject webfontsAPI() throws IOException, JSONException{
		Webfonts webfonts = new Webfonts.Builder(Constants.HTTP_TRANSPORT, Constants.JSON_FACTORY, null)
				.setApplicationName("website-resume")
				.setGoogleClientRequestInitializer(new WebfontsRequestInitializer(GoogleAPIKeyHelper.getGoogletranslatekey()))
				.build();
		WebfontList  webfontListResponse = webfonts.webfonts().list().execute();
		
		System.out.println(webfontListResponse);
		
		JSONObject json = new JSONObject(webfontListResponse.toString());
	    
	    return json;	
	}
}

package com.example.constants;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class Constants {
	public static HttpTransport HTTP_TRANSPORT = new UrlFetchTransport();
    public static JsonFactory JSON_FACTORY = new JacksonFactory();
}

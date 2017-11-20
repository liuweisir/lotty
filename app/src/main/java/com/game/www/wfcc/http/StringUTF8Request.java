package com.game.www.wfcc.http;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;

public class StringUTF8Request extends StringRequest {

	public StringUTF8Request(int method, String url, Listener<String> listener, ErrorListener errorListener) {
		super(method, url, listener, errorListener);
		// TODO Auto-generated constructor stub
		 
	}

	@Override
	protected Response<String> parseNetworkResponse(NetworkResponse response) {
		 try {
             // solution 1:
             String jsonString = new String(response.data, "utf-8");

             return Response.success(jsonString,
                     HttpHeaderParser.parseCacheHeaders(response));
         } catch (UnsupportedEncodingException e) {
             return Response.error(new ParseError(e));
         }
	}
}

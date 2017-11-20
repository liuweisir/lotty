package com.game.www.wfcc.http;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.game.www.wfcc.base.MyApplication;

import java.util.Map;


public class VolleyString {
	
	public interface JSInterface{
		public void getJsonString(String json); 
	}
	private JSInterface jsInterface;
	
	public void initInterface(JSInterface JSI){
		jsInterface = JSI;
		volleyGetCode();
	}
	
	private String url;
	private Map<String, String> map;
	public VolleyString(String url, Map<String, String> map) {
		super();
		this.url = url;
		this.map = map;
	}
	
	/**
	 * 
	 *  使用Post方式返回JsonObject类型的请求结果数据
	 *
	 *  new JsonObjectRequest(int method,String url,JsonObject jsonObject,Listener listener,ErrorListener errorListener)
	 *  method：请求方式，Get请求为Method.GET，Post请求为Method.POST
	 *  url：请求地址
	 *  JsonObject：Json格式的请求参数。如果使用的是Get请求方式，请求参数已经包含在url中，所以可以将此参数置为null
	 *  listener：请求成功后的回调
	 *  errorListener：请求失败的回调
	 */


    private void volleyGetCode() {
    	
    	
        StringUTF8Request request = new StringUTF8Request(Method.POST, url,
                new Listener<String>() {
                    @Override
                    public void onResponse(String s) {//s为请求返回的字符串数据
                    	jsInterface.getJsonString(s);
                    	Log.d("jsonStringSuccess", s);
                    }
                },
                new ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                       // Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_LONG).show();
                    	Log.d("jsonStringError", volleyError.toString());
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String,String> map = new HashMap<>();
//                        //将请求参数名与参数值放入map中
//                        map.put("tel","15850781443");
                        return map;
                    }
                }
                ;
        //设置请求的Tag标签，可以在全局请求队列中通过Tag标签进行请求的查找
        request.setTag("StringPost");
        //将请求加入全局队列中
        MyApplication.getHttpQueues().add(request);
    }
	
	

}

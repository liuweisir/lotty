package com.game.www.wfcc.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.bean.Result;
import com.game.www.wfcc.util.ToolToast;

import org.json.JSONObject;

public class VolleyJsonObject {
	private String url;
	private JSONObject jsonObject;
	private int count = 0;

	public static final int Normal = 1;
	public static final int LoginInvalid = 2;
	public static final int Illegal = 3;

	public static final int Error = 0x1000;

	public static final int resultValid(Result result) {
		if (result == null) {
			return Illegal;
		}

		if (!result.IsSuccess) {
			return Error + result.Type;
		}

		return result.IsSuccess ? Normal : Illegal;
	}


	public interface JObjectInterface {
		public void getJsonObject(String json);
	}

	public interface RequestServerErrorInterface {
		public void onResponseError(VolleyError error);
	}

	private RequestServerErrorInterface requestServerErrorInterface;
	private JObjectInterface vInterface;

	public void initInterface(JObjectInterface vi, RequestServerErrorInterface errorInterface) {
		vInterface = vi;
		requestServerErrorInterface = errorInterface;
		volleyGetCode();
	}

	public void initInterface(JObjectInterface vi) {
		initInterface(vi, null);
	}

	public VolleyJsonObject(String url, JSONObject jsonObject) {
		super();
		this.url = url;
		this.jsonObject = jsonObject;
		Log.d("RequestUrl", url);
		Log.d("requestData",jsonObject.toString());
	}
	/**
	 * 使用Post方式返回JsonObject类型的请求结果数据
	 * <p/>
	 * new JsonObjectRequest(int method,String url,JsonObject
	 * jsonObject,Listener listener,ErrorListener errorListener)
	 * method：请求方式，Get请求为Method.GET，Post请求为Method.POST url：请求地址
	 * JsonObject：Json格式的请求参数。如果使用的是Get请求方式，请求参数已经包含在url中，所以可以将此参数置为null
	 * listener：请求成功后的回调 errorListener：请求失败的回调
	 */

	public void volleyGetCode() {
		if (!isOpenNetwork()){
			ToolToast.showShort("网络异常!");
			return;
		}
		JsonObjectUTF8Request request = new JsonObjectUTF8Request(url, jsonObject, new Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject arg0) {
				String json = arg0.toString();
				Log.d("JsonObjectsuccess", json);
				vInterface.getJsonObject(json);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				String error = arg0.toString();
				if (requestServerErrorInterface != null) {
					requestServerErrorInterface.onResponseError(arg0);
					return;
				}

				Log.d("JsonObjectError", error);
				if (error.equals("com.android.volley.TimeoutError")) {
					count++;
					if(count < 3){
						volleyGetCode();
					}
					if(count == 3){
						ToolToast.showLong("请求超时，请检查网络或稍后再试");
					}
					// PublicWay.isClear(PublicWay.context);
					// 网络环境不好, 不代表需要重新登录, 重试即可
				} else if (error.equals("com.android.volley.ServerError")) {
					ToolToast.showLong("网络异常，请检查网络或稍后再试");
				}

			}
		});

		// 设置请求的Tag标签，可以在全局请求队列中通过Tag标签进行请求的查找
		request.setTag("jsonObjectPost");
		// 将请求加入全局队列中
		MyApplication.getHttpQueues().add(request);
	}


	/**
	 * 对网络连接状态进行判断
	 *
	 * @return true, 可用； false， 不可用
	 */
	public static boolean isOpenNetwork() {
		ConnectivityManager connManager = (ConnectivityManager) MyApplication.getContextObject().getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connManager.getActiveNetworkInfo() != null) {
			return connManager.getActiveNetworkInfo().isAvailable();
		}
		return false;

	}

	/**
	 * 启动登录 Activity
	 */
	public static void startLoginActivity(String msg) {
//		MyApplication.getInstance().removeAll();
//		Intent intent = new Intent(MyApplication.getInstance(), LoginActivity.class);
//		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		MyApplication.getInstance().startActivity(intent);
//		ToolToast.showErrorShort(msg);
	}
}
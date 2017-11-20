package com.game.www.wfcc.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


/**
 * 基本的操作共通抽取
 * @author zhangdaweisir
 * @version 1.0
 *
 */
public class Operation {

	/**激活Activity组件意图**/
	private Intent mIntent = new Intent();
	/***上下文**/
	private Context mContext = null;
	/***整个应用Applicaiton**/
	private MyApplication mApplication = null;
	
	public Operation(Context mContext) {
		this.mContext = mContext;
		mApplication = (MyApplication) this.mContext.getApplicationContext();
	}

	/**
	 * 跳转Activity
	 * @param activity 需要跳转至的Activity
	 */
	public void forward(Class<? extends Activity> activity) {
		mIntent.setClass(mContext, activity);
		mContext.startActivity(mIntent);
	}
}

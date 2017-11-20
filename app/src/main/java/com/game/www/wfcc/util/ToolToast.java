package com.game.www.wfcc.util;



import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.MyApplication;


/**
 * 自定义Toast控件
 * @author zhangdawei
 * @version 1.0
 */
public class ToolToast {
	
	private static Toast mToast;
	private static Handler mHandler = new Handler();
	private static Runnable r = new Runnable() {
		public void run() {
			mToast.cancel();
		}
	}; 
	
	/**
	 * 弹出较长时间提示信息
	 * @param context 上下文对象
	 * @param msg 要显示的信息
	 */
	public static void showLong(Context context, String msg){
		buildToast(context,msg, Toast.LENGTH_LONG).show();
	}
	
	/**
	 * 弹出较长时间提示信息
	 * @param msg 要显示的信息
	 */
	public static void showLong(String msg){
		if(msg.equals("非法用户") ||msg.equals("非法用户！")){
			msg = "请先登录";
		}
		buildToast(MyApplication.getInstance(),msg, Toast.LENGTH_LONG).show();
	}
	
	/**
	 * 弹出较短时间提示信息
	 * @param context 上下文对象
	 * @param msg 要显示的信息
	 */
	public static void showShort(Context context, String msg){
		if(msg.equals("非法用户") ||msg.equals("非法用户！")){
			msg = "请先登录";
		}
		buildToast(context,msg, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * 弹出较短时间提示信息
	 * @param msg 要显示的信息
	 */
	public static void showShort(String msg){
		if(msg.equals("非法用户") ||msg.equals("非法用户！")){
			msg = "请先登录";
		}
		buildToast(MyApplication.getInstance(),msg, Toast.LENGTH_SHORT).show();
	}


	public static void showErrorShort(String msg){
		if(TextUtils.isEmpty(msg)){
			return;
		}
		if(msg.equals("非法用户") ||msg.equals("非法用户！")){
			msg = "请先登录";
		}
		buildErrorToast(MyApplication.getInstance(),msg, Toast.LENGTH_SHORT,"#000000",16,10,  R.drawable.tips_negative).show();
	}
	/**
	 * 构造Toast
	 * @param context 上下文
	 * @return
	 */
	private static Toast buildToast(Context context,String msg,int duration){
		return buildToast(context,msg,duration,"#000000",16);
	}
	

	/**
	 * 构造Toast
	 * @param context 上下文
	 * @param msg 消息
	 * @param duration 显示时间
	 * @param bgColor 背景颜色
	 * @return
	 */
	public static Toast buildToast(Context context,String msg,int duration,String bgColor){
		return buildToast(context,msg,duration,bgColor,16);
	}
	
	
	/**
	 * 构造Toast
	 * @param context 上下文
	 * @param msg	消息
	 * @param duration 显示时间
	 * @param bgColor 背景颜色
	 * @param textSp  文字大小
	 * @return
	 */
	public static Toast buildToast(Context context,String msg,int duration,String bgColor,int textSp){
		return buildToast(context,msg,duration,bgColor,textSp,10);
	}
	
	/**
	 * 构造Toast
	 * @param context 上下文
	 * @param msg	消息
	 * @param duration 显示时间
	 * @param bgColor 背景颜色
	 * @param textSp  文字大小
	 * @param cornerRadius  四边圆角弧度
	 * @return
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public static Toast buildToast(Context context, String msg, int duration, String bgColor, int textSp, int cornerRadius){
		mToast = Toast.makeText(context, null, duration);
		mToast.setGravity(Gravity.CENTER, 0, 0);
		//设置Toast文字
		TextView tv = new TextView(context);
		int dpPadding =30;
		tv.setPadding(dpPadding, dpPadding, dpPadding, dpPadding);
		tv.setGravity(Gravity.CENTER);
		tv.setText(msg);
		tv.setTextColor(Color.WHITE);
		tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSp);
		//Toast文字TextView容器
        LinearLayout mLayout = new LinearLayout(context);
        GradientDrawable shape = new GradientDrawable();
	    shape.setColor(Color.parseColor(bgColor));
	    shape.setCornerRadius(cornerRadius);
	    shape.setStroke(1, Color.parseColor(bgColor));
	    shape.setAlpha(180);
        mLayout.setBackground(shape);
        mLayout.setOrientation(LinearLayout.VERTICAL);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		//设置layout_gravity
		params.gravity = Gravity.CENTER;
		mLayout.setLayoutParams(params);
	    //设置gravity
		mLayout.setGravity(Gravity.CENTER);
        mLayout.addView(tv);
        //将自定义View覆盖Toast的View
        mToast.setView(mLayout);
		return mToast;
	}




	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public static Toast buildErrorToast(Context context, String msg, int duration, String bgColor, int textSp, int cornerRadius,int resID){
		mToast = Toast.makeText(context, null, duration);
		mToast.setGravity(Gravity.CENTER, 0, 0);
		//设置Toast文字
		TextView tv = new TextView(context);
		int dpPadding =30;
		tv.setPadding(dpPadding, dpPadding, dpPadding, dpPadding);
		tv.setGravity(Gravity.CENTER);
		tv.setText(msg);
		tv.setPadding(20,30,20,50);
		tv.setTextColor(Color.WHITE);
		tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSp);
		//Toast文字TextView容器
		LinearLayout mLayout = new LinearLayout(context);
		GradientDrawable shape = new GradientDrawable();
		shape.setColor(Color.parseColor(bgColor));
		shape.setCornerRadius(cornerRadius);
		shape.setStroke(1, Color.parseColor(bgColor));
		shape.setAlpha(150);
		mLayout.setBackground(shape);
		mLayout.setOrientation(LinearLayout.VERTICAL);
		LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		//设置layout_gravity
		params.gravity = Gravity.CENTER;
		mLayout.setLayoutParams(params);
		//设置gravity
		mLayout.setGravity(Gravity.CENTER);
		ImageView imageCodeProject = new ImageView(context);
		imageCodeProject.setImageResource(resID);
		imageCodeProject.setPadding(200,80,200,0);
		mLayout.addView(imageCodeProject, 0);
		mLayout.addView(tv);
		//将自定义View覆盖Toast的View
		mToast.setView(mLayout);
		return mToast;
	}
}

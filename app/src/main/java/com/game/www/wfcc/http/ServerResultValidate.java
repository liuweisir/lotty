package com.game.www.wfcc.http;


import com.game.www.wfcc.bean.Result;

public final class ServerResultValidate {

	public static final int None = 0;
	public static final int Normal = 1;
	public static final int LoginInvalid = 2;
	public static final int Illegal = 3;

	public static final int Error = 0x1000;
	
	public static final String RELOGIN_FLAG = "relogin";
	
	/**
	 * 检查服务器端返回值的状态
	 * @param result 服务器应答的返回值
	 * @return 返回服务器端返回的状态
	 */
	public static final int resultValid(Result result) {
		if (result == null) {
			return Illegal;
		}
		
		if (!result.IsSuccess) {
			return Error + result.Type;
		}
		
		return result.IsSuccess ? Normal : Illegal;
	}
	
	/**
	 * 启动登录 Activity
	 */
	public static void startLoginActivity() {
//		Intent intent = new Intent(MyApplication.getInstance(), LoginActivity.class);
//		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		MyApplication.getInstance().startActivity(intent);
	}
	
	public static void identityVerification(int resultType, ResultRunnable runnable) {
		boolean loginInvalid = (resultType & LoginInvalid) == LoginInvalid;
		boolean illegal = (resultType & Illegal) == Illegal;

		if (loginInvalid || illegal) {
			startLoginActivity();
		}
		if (runnable != null) {
			runnable.run(resultType);
		}
	}
	
	public interface ResultRunnable {
		public void run(int resultType);
	}
}

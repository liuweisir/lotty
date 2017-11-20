package com.game.www.wfcc.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PublicWay {
	
	
	


	
	public  interface uploadResult{
		public void upLoadOK(boolean ok, String type);

		public void newAddOK(boolean ok);
	}

	public static uploadResult uploadR;

	public static void InitInterface(uploadResult uR) {
		uploadR = uR;
	}

	

	public static String getTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.SIMPLIFIED_CHINESE);
		Date date = new Date(System.currentTimeMillis());
		String time = format.format(date);
		return time;
	}
	public static String get24Time() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
		Date date = new Date(System.currentTimeMillis());
		String time = format.format(date);
		return time;
	}

	public static String getdate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.SIMPLIFIED_CHINESE);
		Date time = new Date(System.currentTimeMillis());
		String date = format.format(time);
		return date;

	}
	public static String getNamePicDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd/", Locale.SIMPLIFIED_CHINESE);
		Date time = new Date(System.currentTimeMillis());
		String date = format.format(time);
		return date;

	}

	@SuppressLint("SimpleDateFormat")
	public static String getNowTime() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmssSS", Locale.SIMPLIFIED_CHINESE);
		return dateFormat.format(date);
	}

	public static String getHourTime() {
		SimpleDateFormat format = new SimpleDateFormat("HH", Locale.SIMPLIFIED_CHINESE);
		Date date = new Date(System.currentTimeMillis());
		String time = format.format(date);
		return time;
	}

	/**
	 * 错误提示
	 * 
	 * @param prompText
	 */
	public static void Toast(final Context context, final String prompText) {
		((Activity) context).runOnUiThread(new Runnable() {
			public void run() {
				ToolToast.showShort(prompText);
			}
		});
	}

	public static boolean haveSdcard() {
		return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
	}

	public static boolean CreateFiles(String path) {
		File file = new File(path);
		if (!file.exists()) {
			try {
				// 按照指定的路径创建文件夹
				//file.getParentFile().mkdirs();
				
				boolean result = file.mkdirs();

				return true;
			} catch (Exception e) {
			}
		}
		return false;
	}



	
	

	

	private static boolean deleteExistFile(File file) {
		if (file == null) return false;
		
		if (file.exists()) {
			return file.delete();
		}
		
		return false;
	}

	public static void saveFile(Bitmap bm, String filePath) throws IOException {
		File f = new File(filePath);
		
		if (!deleteExistFile(f)) {
			File dir = new File(f.getParent());
			if (!dir.exists()) {
				dir.mkdirs();
			}
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
			bm.compress(Bitmap.CompressFormat.JPEG, 100, bos);
			bos.flush();
			bos.close();
		}
	}

	public static String getRealPathFromUri(Context context, Uri content) {
		Cursor cursor = null;

		try {
			String[] proj = { MediaStore.Images.Media.DATA };

			cursor = context.getContentResolver().query(content, proj, null, null, null);

			int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

			cursor.moveToFirst();
			return cursor.getString(column_index);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if (cursor != null) {
				cursor.close();
			}
		}
		return null;
	}

	/**
	 * 计算时间差
	 *
	 * @param nowTime
	 *           当前时间
	 * @param startTime
	 *            开始时间
	 *            返回类型 ==1----天，时，分。 ==2----时
	 * @return 返回时间差
	 */
	public static String getTimeDifference(String nowTime, String startTime) {
		String timeString = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(TextUtils.isEmpty(nowTime) ||TextUtils.isEmpty(startTime) ){
			return timeString;
		}

		try {
			Date parse = dateFormat.parse(nowTime);
			Date parse1 = dateFormat.parse(startTime);

			long diff = parse1.getTime() - parse.getTime();

			long day = diff / (24 * 60 * 60 * 1000);
			long hour = (diff / (60 * 60 * 1000) - day * 24);
			long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			long ms = (diff - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
					- min * 60 * 1000 - s * 1000);

			timeString = "剩余"+(day>0?day+"天":"")+(hour>0?hour+"小时":"")+(min>0?min+"分钟":"");
			if(timeString.equals("剩余")){
				timeString = "";
			}



		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timeString;

	}
	/**
	 * 计算时间差
	 *
	 * @param nowTime
	 *           当前时间
	 * @param startTime
	 *            开始时间
	 *            返回类型 ==1----天，时，分。 ==2----时
	 * @return 返回时间差
	 * 返回时间只取最大单位数
	 */
	public static String getMaxTimeDifference(String nowTime, String startTime) {
		String timeString = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(TextUtils.isEmpty(nowTime) ||TextUtils.isEmpty(startTime) ){
			return timeString;
		}

		try {
			Date parse = dateFormat.parse(nowTime);
			Date parse1 = dateFormat.parse(startTime);

			long diff = parse1.getTime() - parse.getTime();

			long day = diff / (24 * 60 * 60 * 1000);
			long hour = (diff / (60 * 60 * 1000) - day * 24);
			long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			long ms = (diff - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
					- min * 60 * 1000 - s * 1000);

			if(day>0){
				timeString = day+"天";
			}else if(hour>0){
				timeString = hour+"小时";
			}else if(min>0){
				timeString = min+"分钟";
			}else{
				timeString = "";
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timeString;

	}
	/**
	 * 计算时间差
	 *
	 * @param nowTime
	 *           当前时间
	 * @param startTime
	 *            开始时间
	 *            返回类型 ==1----天，时，分。 ==2----时
	 * @return 返回时间差
	 * 返回时间只取最大单位数
	 */
	public static String getTimeDuration(String nowTime, String startTime) {
		String timeString = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(TextUtils.isEmpty(nowTime) ||TextUtils.isEmpty(startTime) ){
			return timeString;
		}

		try {
			Date parse = dateFormat.parse(nowTime);
			Date parse1 = dateFormat.parse(startTime);

			long diff = parse1.getTime() - parse.getTime();

			long day = diff / (24 * 60 * 60 * 1000);
			long hour = (diff / (60 * 60 * 1000) - day * 24);
			long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			long ms = (diff - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
					- min * 60 * 1000 - s * 1000);


			if(day>0){
				timeString = (day+1)+"天";
			}else if(hour>1){
				timeString = (hour+1)+"小时";
			}else if(hour>0){
				timeString = (60+min)+"分钟";
			}else if (min>0){
				timeString = min+"分钟";
			}else{
				timeString = "";
			}






		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timeString;

	}
}

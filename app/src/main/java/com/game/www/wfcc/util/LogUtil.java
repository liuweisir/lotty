package com.game.www.wfcc.util;

import android.util.Log;

/**
 * Created by Administrator on 2016/11/25.
 */
public class LogUtil {

    private static String DebugTag = "Debug";
    private static String ErrorTag = "Error";

    public static void d(String str){
        d(DebugTag,str);
    }
    public static void d(String tag,String str){
        Log.d(tag,str);
    }


    public static void e(String str){
        d(ErrorTag,str);
    }
    public static void e(String tag,String str){
        Log.e(tag,str);
    }
}

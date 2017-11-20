package com.game.www.wfcc.util;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import com.game.www.wfcc.base.MyApplication;


public class PreferencesUtil {

    //保存
    public static void savePreference(String preferenceType, String preferenceKey, String preferenceValue) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(preferenceType, Context.MODE_PRIVATE);
        Editor edit = preference.edit();
        edit.putString(preferenceKey, preferenceValue);
        edit.commit();
    }

    //获取
    public static String getPreference(String preferenceType, String preferenceKey) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(preferenceType, Context.MODE_PRIVATE);
        return preference.getString(preferenceKey, "");
    }

    public static SharedPreferences getPreferences(String preferenceType) {
        return MyApplication.getInstance().getSharedPreferences(preferenceType, Context.MODE_PRIVATE);
    }

    //清空
    public static void clearPreference(Context context, String preferenceType, String preferenceKey) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(preferenceType, Context.MODE_PRIVATE);
        Editor edit = preference.edit();
        edit.putString(preferenceKey, "");
        edit.commit();
    }

    //删除
    public static void remove(String preferenceType, String preferenceKey) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(preferenceType, Context.MODE_PRIVATE);
        Editor edit = preference.edit();
        edit.remove(preferenceKey);
        edit.commit();
    }

    //包含
    public static boolean contains(String name, String key) {

        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(name, Context.MODE_PRIVATE);
        return preference.contains(key);
    }

    //清空
    public static void clearPreference(String preferenceType) {
        SharedPreferences preference = MyApplication.getInstance().getSharedPreferences(preferenceType, Context.MODE_PRIVATE);
        Editor edit = preference.edit();
        edit.clear();
        edit.commit();
    }
    public static final String isBanSpeechValue = "isBanSpeech";
    public static final String isBanSpeechValue2 = "isBanSpeech2";
    public static void banSpeech(boolean isBanSpeech){
        if(isBanSpeech){
            savePreference(Preferences.USERISBANSPEECHTYPE,Preferences.USERISBANSPEECHKEY,isBanSpeechValue);
        }else{
            savePreference(Preferences.USERISBANSPEECHTYPE,Preferences.USERISBANSPEECHKEY,"");
        }
    }

    public static void banSpeech2(boolean isBanSpeech){
        if(isBanSpeech){
            savePreference(Preferences.USERISBANSPEECHTYPE2,Preferences.USERISBANSPEECHKEY2,isBanSpeechValue2);
        }else{
            savePreference(Preferences.USERISBANSPEECHTYPE2,Preferences.USERISBANSPEECHKEY2,"");
        }
    }
    public static boolean isBanSpeech(){
        boolean isBanSpeech = false;
        String s = getPreference(Preferences.USERISBANSPEECHTYPE,Preferences.USERISBANSPEECHKEY);
        if(!TextUtils.isEmpty(s) && s.equals(isBanSpeechValue)){
            isBanSpeech = true;
        }
        return isBanSpeech;
    }
    public static boolean isBanSpeech2(){
        boolean isBanSpeech = false;
        String s = getPreference(Preferences.USERISBANSPEECHTYPE2,Preferences.USERISBANSPEECHKEY2);
        if(!TextUtils.isEmpty(s) && s.equals(isBanSpeechValue2)){
            isBanSpeech = true;
        }
        return isBanSpeech;
    }
    public static void putUrl(String url){
        String type = getPreference(Preferences.URLTYPE ,Preferences.URLKEY);
        if(TextUtils.isEmpty(type) || !type.equals(url)){
            savePreference(Preferences.URLTYPE,Preferences.URLKEY,url);
        }
    }

    public static String getUrl(){
        return getPreference(Preferences.URLTYPE,Preferences.URLKEY);
    }

}

package com.game.www.wfcc.util;

import android.text.TextUtils;

/**
 * Created by Administrator on 2017/1/9.
 */
public class NumberUtil {




    public static int strToInt(String str){
        try {
            int i = Integer.parseInt(str);
            return i;
        }catch (Exception e){
            return -1;
        }
    }

    public static double strToDouble(String num){
        try {
            if(num.indexOf(",") > -1){
                num = num.replaceAll("," , "");
            }
            double i = Double.parseDouble(num);
            return i;
        }catch (Exception e){
            return Double.MIN_VALUE;
        }
    }

    public static String doubleTrans(double num){
        if(Math.round(num)-num==0){
            return String.valueOf((long)num);
        }
        return String.valueOf(num);
    }

    public static String getInputBankNumber(String num){
        StringBuilder str = new StringBuilder();
        num = num.trim();
        int length = num.length();
        int j = 0;
        for(int i = 0 ; i < length ; i++){
            String tmp = num.substring(j , i + 1);
            j = i;
            if(i % 4 == 0){
                str.append(" ");
            }
            str.append(tmp);
        }
        String r = str.toString();
        r = r.trim();
        return r;
    }
    public static String getBankNumber(String num){
        if(TextUtils.isEmpty(num) || TextUtils.equals("暂无",num)){
            return "暂无";
        }
        StringBuilder str = new StringBuilder();
        int length = num.length();
        int j = 0;
        for(int i = 0 ; i < length ; i++){
            String tmp = num.substring(j , i);
            j = i;
            if(i % 4 == 0){
                str.append(" ");
            }
            if(length - i > 4){
                str.append("*");
            }else{
                str.append(tmp);
            }
        }
        return str.toString();
    }

    public static void main(String[] args){
        System.out.println(getBankNumber("5555525555555555"));
    }
}

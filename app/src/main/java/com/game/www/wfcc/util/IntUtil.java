package com.game.www.wfcc.util;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/2/25.
 */
public class IntUtil {

    public static String DoubleStr(double d){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");//格式化设置
        String s = decimalFormat.format(d);
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }
}

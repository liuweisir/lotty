package com.game.www.wfcc.util;

import android.content.Context;

/**
 * Created by zhangdaweisir on 2017/6/7.
 */
public class ToolUnit {

    public static int dipTopx(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
}

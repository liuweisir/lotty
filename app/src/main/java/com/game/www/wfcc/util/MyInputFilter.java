package com.game.www.wfcc.util;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by Administrator on 2017/5/20.
 */
public class MyInputFilter implements InputFilter {

    private final int DECIMAL_DIGITS = 2;

    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        if (dest.length() == 0 && source.equals(".")) {
            return "0.";
        }
        String dValue = dest.toString();
        String[] splitArray = dValue.split("\\.");
        if (splitArray.length > 1) {
            String dotValue = splitArray[1];
            if (dotValue.length() == DECIMAL_DIGITS) {
                return "";
            }
        }
        return null;
    }

}

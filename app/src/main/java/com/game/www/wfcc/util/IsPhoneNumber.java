package com.game.www.wfcc.util;

import android.text.TextUtils;

public class IsPhoneNumber {
	/** 
	 * 验证手机格式 
	 */  
	public static boolean isMobileNO(String mobiles) {  
		/*
	    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188 
	    联通：130、131、132、152、155、156、185、186 
	    电信：133、153、180、189、（1349卫通） 
	    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9 
	    */
		boolean falg = false;
		if (TextUtils.isEmpty(mobiles)) return falg;
		String[] gexs = new String[]{"^1(3[0-9]|4[57]|5[0-35-9]|8[0-9]|70)\\d{8}$",
				"^(1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7})$",
				"^(1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7})$",
				"^(1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7})$"};
		for (String str : gexs) {
			if (mobiles.matches(str)) {
				falg = true;
				break;
			}
		}
		return falg;
	}

}

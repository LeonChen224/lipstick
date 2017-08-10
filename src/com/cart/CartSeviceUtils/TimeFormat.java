package com.cart.CartSeviceUtils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class TimeFormat {

	public String TimeFormate(long time) {
		Date date=new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
		String t = sdf.format(date);
		return t;
	}

}

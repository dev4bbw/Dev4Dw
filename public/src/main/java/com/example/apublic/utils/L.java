package com.example.apublic.utils;

import android.util.Log;

/**
 * Log统一管理�?
 * 
 * @author way
 * 
 */
public class L
{

	private L()
	{
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	public static boolean isDebug = true;// 是否�?��打印bug，可以在application的onCreate函数里面初始�?
	private static final String TAG = "TAG";

	// 下面四个是默认tag的函�?
	public static void i(String msg)
	{
		if (isDebug)
			Log.i(TAG, msg);
	}

	public static void d(String msg)
	{
		if (isDebug)
			Log.d(TAG, msg);
	}

	public static void e(String msg)
	{
		if (isDebug)
			Log.e(TAG, msg);
	}

	public static void v(String msg)
	{
		if (isDebug)
			Log.v(TAG, msg);
	}

	// 下面是传入自定义tag的函�?
	public static void i(String tag, String msg)
	{
		if (isDebug)
			Log.i(tag, msg);
	}

	public static void d(String tag, String msg)
	{
		if (isDebug)
			Log.i(tag, msg);
	}

	public static void e(String tag, String msg)
	{
		if (isDebug)
			Log.i(tag, msg);
	}

	public static void v(String tag, String msg)
	{
		if (isDebug)
			Log.i(tag, msg);
	}

	public static void log( String tag, String bodyMsg){
		if (bodyMsg.length() > 4000) {
			for (int i = 0; i < bodyMsg.length(); i += 4000) {
				//当前截取的长度<总长度则继续截取最大的长度来打印
				if (i + 4000 < bodyMsg.length()) {
					Log.i(tag + i, bodyMsg.substring(i, i + 4000));
				} else {
					//当前截取的长度已经超过了总长度，则打印出剩下的全部信息
					Log.i(tag + i, bodyMsg.substring(i, bodyMsg.length()));
				}
			}
		} else {
			//直接打印
			Log.i(tag, bodyMsg);
		}
	}


}
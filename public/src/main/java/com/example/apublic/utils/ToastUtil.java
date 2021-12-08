package com.example.apublic.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.apublic.base.BaseApp;


/**
 * 吐司工具类
 * 
 * @ClassName: ToastUtil
 * @Description: 包含: 测试用的系统自带的吐司, 自定义的吐司
 * @author feng
 * @date 2015-2-6
 * @see	
 * @modify chenmignjia
 * @date 2016-10-27
 */
public class ToastUtil {

	// 测试用吐司: 测试阶段时设为 true, 项目完成时设为 false
	private static final boolean isShow = true;
	
	private static Toast toase = null;

	/**
	 * 测试用吐司(系统自带):
	 * 
	 * @param context
	 * @param msg
	 */
	public static void showToastTest(Context context, String msg) {
		if (isShow) {
			if (context != null) {
				Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
			}
		}
	}

	/**
	 * 吐司(系统自带):字符串类型
	 * 
	 * @param context
	 * @param msg
	 */
	public static void showToast(Context context, String msg) {
		if(toase==null){
//			toase = Toast.makeText(context, "", Toast.LENGTH_SHORT);
			toase = Toast.makeText(BaseApp.getInstance(), "", Toast.LENGTH_SHORT);
		}
		toase.setText(msg);
		toase.show();
	}

	/**
	 * 吐司(系统自带): ID类型(xml中)
	 * 
	 * @param context
	 * @param msgResId
	 */
	public static void showToast(Context context, int msgResId) {
//		if (context != null) {
//			Toast.makeText(context, msgResId, Toast.LENGTH_SHORT).show();
//		}
		
		if(toase==null){
//			toase = Toast.makeText(context, "", Toast.LENGTH_SHORT);
			toase = Toast.makeText(BaseApp.getInstance(), "", Toast.LENGTH_SHORT);
		}
		toase.setText(msgResId);
		toase.show();
	}
}

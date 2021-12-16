package com.example.apublic.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.VisibleForTesting;

import com.example.apublic.R;
import com.example.apublic.base.BaseApp;


/**
 * 吐司工具类
 * 
 */
public class ToastUtil {

	private static String mLastToast = null;

	private ToastUtil() {
	}

	private static ToastUtil instance;

	private static Context mContext;

	public static ToastUtil get() {
		if (instance == null) {
			synchronized (ToastUtil.class) {
				if (instance == null) {
					instance = new ToastUtil();
				}
			}
		}
		return instance;
	}

	/**
	 * 在Application中调用，省去每次toast需要传的context,
	 */
	public static void init(Context mContext) {
		ToastUtil.mContext = mContext;
	}

	// Toast对象
	private android.widget.Toast mToast;
	private TextView mTextView;

	/**
	 * 显示toast
	 */
	public void toast(String content) {
		mLastToast = content;
//        if (mToast == null) {
		mToast = new android.widget.Toast(mContext);
		View view = LayoutInflater.from(mContext).inflate(
				R.layout.base_lay_toast, null);
		mTextView = (TextView) view.findViewById(R.id.tvToast);
		mToast.setView(view);
		mToast.setGravity(Gravity.CENTER, 0, 0);
		mToast.setDuration(android.widget.Toast.LENGTH_SHORT);
//        }

		mTextView.setText(content);
		mToast.show();
	}

	/**
	 * 显示toast
	 */
	public void toastCustomer(String content,boolean success) {
		mLastToast = content;
		mToast = new android.widget.Toast(mContext);
		View view = LayoutInflater.from(mContext).inflate(
				R.layout.customer_toast, null);
		ImageView icon = (ImageView)view.findViewById(R.id.icon);
		if (success){
			icon.setImageResource(R.mipmap.icon_toast_success);
		}else {
			icon.setImageResource(R.mipmap.icon_toast_fail);
		}
		mTextView = (TextView) view.findViewById(R.id.tvToast);
		mToast.setView(view);
		mToast.setGravity(Gravity.CENTER, 0, 0);
		mToast.setDuration(android.widget.Toast.LENGTH_SHORT);
		mTextView.setText(content);
		mToast.show();
	}


	private static Toast toast = null;

	public void showToast(Context context, String msg){
		if(toast == null){
			toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
		}
		toast.setText(msg);
		toast.show();

	}



	/**
	 * 显示toast
	 */
	public void toast(int resId) {
		String content = mContext.getString(resId);
		toast(content);
	}

	public void cancelToast() {
		if (mToast != null) {
			mToast.cancel();
		}
	}

	@VisibleForTesting
	public String getLastToast() {
		return mLastToast;
	}

}

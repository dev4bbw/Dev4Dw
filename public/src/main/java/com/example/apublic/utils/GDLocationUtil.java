package com.example.apublic.utils;

import android.content.Context;
import android.webkit.WebView;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

public class GDLocationUtil {
    private volatile static GDLocationUtil instance;
    private static AMapLocationClient mLocationClient;
    private AMapLocationListener mLocationListener;

    Context mContext;

    public GDLocationUtil(Context context) {
        mContext = context;
    }

    public static GDLocationUtil get(Context context) {
        if (instance == null) {
            synchronized (GDLocationUtil.class) {
                if (instance == null) {
                    instance = new GDLocationUtil(context);
                    try {
                        mLocationClient = new AMapLocationClient(context);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }

    /**
     * @param interval            定位时间间隔，小于等于0时只定位一次
     * @param needAddress         是否返回地址信息
     * @param locationCacheEnable 是否缓存定位信息
     */
    public void setLocationOptions(int interval, boolean needAddress, boolean locationCacheEnable) {
        //初始化定位参数
        AMapLocationClientOption locationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        if (interval > 0) {
            locationOption.setInterval(interval);
        } else {
            locationOption.setOnceLocation(true);
        }
        locationOption.setLocationCacheEnable(locationCacheEnable);
        locationOption.setNeedAddress(needAddress);
        mLocationClient.setLocationOption(locationOption);
    }

    public void setLocationListener(AMapLocationListener listener) {
        mLocationListener = listener;
        mLocationClient.setLocationListener(mLocationListener);
    }

    public void startLocation() {
        if (mLocationClient != null) {
            mLocationClient.startLocation();
        }
    }

    /**
     * H5定位辅助
     * @param view
     */
    public void startAssistantLocation(WebView view) {
        if (mLocationClient != null) {
            mLocationClient.startAssistantLocation(view);
        }
    }

    public void stopAssistantLocation() {
        if (mLocationClient != null) {
            mLocationClient.stopAssistantLocation();
        }
    }

    public void stopLocation() {
        if (mLocationClient != null) {
            mLocationClient.stopLocation();
        }
    }

    public void destroy() {
        if (mLocationClient != null && mLocationListener != null) {
            mLocationClient.unRegisterLocationListener(mLocationListener);
            mLocationClient.stopLocation();
            mLocationClient.stopAssistantLocation();
            mLocationClient.onDestroy();
            mLocationClient = null;
        }
    }

    public static AMapLocationClient tempLocation(Context context,
                                                  int interval,
                                                  boolean needAddress,
                                                  boolean locationCacheEnable,
                                                  AMapLocationListener locationListener) {
        try {
            AMapLocationClient tempLocation = new AMapLocationClient(context);

            //初始化定位参数
            AMapLocationClientOption locationOption = new AMapLocationClientOption();
            //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
            locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            if (interval > 0) {
                locationOption.setInterval(interval);
            } else {
                locationOption.setOnceLocation(true);
            }
            locationOption.setLocationCacheEnable(locationCacheEnable);
            locationOption.setNeedAddress(needAddress);

            tempLocation.setLocationOption(locationOption);
            tempLocation.setLocationListener(locationListener);
            return tempLocation;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

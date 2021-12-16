package com.example.apublic.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.example.apublic.base.BaseApp;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocalLocationUtil {
    private volatile static LocalLocationUtil uniqueInstance;

    public LocalLocationUtil(Context context){
        this.mContext = context;
    }
    public static LocalLocationUtil getInstance(Context context){
        if (uniqueInstance == null) {
            synchronized (LocalLocationUtil.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new LocalLocationUtil(context);
                }
            }
        }
        return uniqueInstance;
    }
    private Context mContext;
    private LocationResult result;
    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            if (result!=null){
                double latitude = location.getLatitude();//纬度
                double longitude = location.getLongitude();//经度

                //Geocoder通过经纬度获取具体信息
                Geocoder gc = new Geocoder(mContext, Locale.getDefault());
                try {
                    List<Address> locationList = gc.getFromLocation(latitude, longitude, 1);

                    if (locationList != null) {
                        Address address = locationList.get(0);
                        String countryName = address.getCountryName();//国家
                        String countryCode = address.getCountryCode();
                        String adminArea = address.getAdminArea();//省
                        String locality = address.getLocality();//市
                        String subLocality = address.getSubLocality();//区
                        String featureName = address.getFeatureName();//街道

                        for (int i = 0; address.getAddressLine(i) != null; i++) {
                            String addressLine = address.getAddressLine(i);
                            //街道名称:广东省深圳市罗湖区蔡屋围一街深圳瑞吉酒店
                            System.out.println("addressLine=====" + addressLine);
                        }
                        if (result != null) {
                            result.getLocationSuccess(locality);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public void startLocation(Context context, LocationResult result) {
        this.result = result;
        LocationManager lm = (LocationManager) BaseApp.getInstance().getSystemService(Context.LOCATION_SERVICE);
        Location location;
        List<String> providerList = lm.getProviders(true);
        String provider;
        if (providerList.contains(LocationManager.GPS_PROVIDER)) {
            provider = LocationManager.GPS_PROVIDER;
        } else if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
            provider = LocationManager.NETWORK_PROVIDER;
        } else {
            result.getLocationFail();
            ToastUtil.get().showToast(context, "无可用定位服务");
            return;
        }
        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        //3.获取上次的位置，一般第一次运行，此值为null
        location = lm.getLastKnownLocation(provider);
        if (location != null) {
            // 显示当前设备的位置信息
            System.out.println("==显示当前设备的位置信息==");
            showLocation(context,lm,location,result);
        } else {//当GPS信号弱没获取到位置的时候可从网络获取
            System.out.println("==Google服务被墙的解决办法==");
            getLngAndLatWithNetwork(context,lm,result);//Google服务被墙的解决办法
        }
        lm.requestLocationUpdates(provider, 5000, 0, locationListener);
    }

    //获取经纬度
    private void showLocation(Context context,LocationManager lm,Location location,LocationResult result) {
        if (location == null) {
            startLocation(context,result);
        } else {
            double latitude = location.getLatitude();//纬度
            double longitude = location.getLongitude();//经度
//            for(AddressCallback addressCallback:addressCallbacks){
//                addressCallback.onGetLocation(latitude,longitude);
//            }
//            if (result != null) {
//                result.getLocationSuccess();
//            }
            getAddress(context,latitude, longitude,result);
            lm.removeUpdates(locationListener);
        }
    }

    private void getAddress(Context context,double latitude, double longitude,LocationResult result) {
        //Geocoder通过经纬度获取具体信息
        Geocoder gc = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> locationList = gc.getFromLocation(latitude, longitude, 1);

            if (locationList != null) {
                Address address = locationList.get(0);
                String countryName = address.getCountryName();//国家
                String countryCode = address.getCountryCode();
                String adminArea = address.getAdminArea();//省
                String locality = address.getLocality();//市
                String subLocality = address.getSubLocality();//区
                String featureName = address.getFeatureName();//街道

                for (int i = 0; address.getAddressLine(i) != null; i++) {
                    String addressLine = address.getAddressLine(i);
                    //街道名称:广东省深圳市罗湖区蔡屋围一街深圳瑞吉酒店
                    System.out.println("addressLine=====" + addressLine);
                }
                if (result != null) {
                    result.getLocationSuccess(locality);
                }
//                for(AddressCallback addressCallback:addressCallbacks){
//                    addressCallback.onGetAddress(address);
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //从网络获取经纬度
    private void getLngAndLatWithNetwork(Context context,LocationManager lm,LocationResult result) {
        //添加用户权限申请判断
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 0, locationListener);
//        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//        showLocation(context,lm,location,result);
    }
    public interface LocationResult {
        void getLocationSuccess(String city);

        void getLocationFail();
    }
}

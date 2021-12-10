package com.example.apublic.permissionlib;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;


/*
 * @创建者     Jrking
 * @创建时间   2016/4/15 16:18
 * @描述	      ${Activity基类 }
 * @更新描述   ${适配6.0权限问题}
 */
public class PermissionActivity extends AppCompatActivity implements
        EasyPermissions.PermissionCallbacks {

    protected static final int RC_PERM = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initStatusBar("#303F9F");//透明状态栏
    }

    public void initStatusBar(String strColor) {
        StatusBarCompat.setStatusBarColor(this, Color.parseColor(strColor));
        StatusBarCompat.translucentStatusBar(this);
    }



    /**
     * 权限回调接口
     */
    private CheckPermListener mListener;

    public interface CheckPermListener {
        //权限通过后的回调方法
        void superPermission();
    }

    public void checkPermission(CheckPermListener listener, int resString, String... mPerms) {
        mListener = listener;
        if (EasyPermissions.hasPermissions(this, mPerms)) {
            if (mListener != null)
                mListener.superPermission();
        } else {
            EasyPermissions.requestPermissions(this, getString(resString), RC_PERM, mPerms);
        }
    }

    /**
     * 用户权限处理,
     * 如果全部获取, 则直接过.
     * 如果权限缺失, 则提示Dialog.
     *
     * @param requestCode  请求码
     * @param permissions  权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EasyPermissions.SETTINGS_REQ_CODE) {
            //设置返回
        }
    }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
       //同意了某些权限可能不是全部
    }

    @Override
    public void onPermissionsAllGranted() {
        if (mListener != null)
            mListener.superPermission();//同意了全部权限的回调
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

        if (mListener != null)
            mListener.superPermission();//没有同意权限也能进入
    }


}

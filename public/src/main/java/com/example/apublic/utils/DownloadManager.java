package com.example.apublic.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

public class DownloadManager {


    private static final String TAG = "DownloadManager";
    private static DownloadManager downloadManager;

    public static DownloadManager getInstance() {
        if (downloadManager == null) {
            downloadManager = new DownloadManager();
        }
        return downloadManager;
    }


    /**
     * 设置回调接口
     */
    public interface DownloadCallBackListener {
        void onDownloadCallBackListener(boolean success,boolean exist, String message);
    }

    private DownloadCallBackListener downloadCallBackListener;

    public void setDownloadCallBackListener(DownloadCallBackListener downloadCallBackListener) {
        this.downloadCallBackListener = downloadCallBackListener;
    }


    public void downloadFile(String url,DownloadCallBackListener downloadCallBackListener) {
        this.downloadCallBackListener = downloadCallBackListener;
        //下载路径，如果路径无效了，可换成你的下载路径
        final long startTime = System.currentTimeMillis();
        Log.i(TAG, "startTime=" + startTime);

        String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getPath()+"/dwVideo/"
                + url.substring(url.lastIndexOf("/") + 1);
        File desFile = new File(filePath);
        if (desFile.exists()){
            downloadCallBackListener.onDownloadCallBackListener(false,true,filePath);
            return;
        }

        Request request = new Request.Builder().url(url).build();


        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 下载失败
                e.printStackTrace();
                Log.i(TAG, "download failed::::" + e.getMessage());
                if (downloadCallBackListener != null) {
                    downloadCallBackListener.onDownloadCallBackListener(false, false,"文件下载失败!");
                }

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Sink sink = null;
                BufferedSink bufferedSink = null;
                try {
                    File dest = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getPath(), "dwVideo");
//                    File dest = new File(Environment.getExternalStoragePublicDirectory(
//                            Environment.DIRECTORY_DOWNLOADS).getPath() + "/" + url.substring(url.lastIndexOf("/") + 1));
                    if (!dest.exists()) {
                        dest.mkdirs();
                    }
                    String filePath = dest.getPath()+"/"
                            + url.substring(url.lastIndexOf("/") + 1);
                    dest = new File(filePath);
                    sink = Okio.sink(dest);
                    bufferedSink = Okio.buffer(sink);
                    bufferedSink.writeAll(response.body().source());

                    bufferedSink.close();
                    Log.i(TAG, "download success");
                    Log.i(TAG, "totalTime=" + (System.currentTimeMillis() - startTime));
                    if (downloadCallBackListener != null) {
                        downloadCallBackListener.onDownloadCallBackListener(true,false, filePath);
                    }

                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i(TAG, "download failed");
                } finally {
                    if (bufferedSink != null) {
                        bufferedSink.close();
                    }
                }
                if (downloadCallBackListener != null) {
                        downloadCallBackListener.onDownloadCallBackListener(false,false, "文件下载失败!");
                }
            }
        });
    }
    public static String getSDPath(Context context) {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);// 判断sd卡是否存在
        if (sdCardExist) {
            if (Build.VERSION.SDK_INT>=29){
                //Android10之后
                sdDir = context.getExternalFilesDir(null);
            }else {
                sdDir = Environment.getExternalStorageDirectory();// 获取SD卡根目录
            }
        } else {
            sdDir = Environment.getRootDirectory();// 获取跟目录
        }
        return sdDir.toString();
    }
}

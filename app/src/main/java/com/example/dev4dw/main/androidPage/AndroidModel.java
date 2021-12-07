package com.example.dev4dw.main.androidPage;

import com.example.apublic.bean.MyBean;

import java.util.ArrayList;
import java.util.List;

public class AndroidModel{
    private static String[] AndroidTitles = {
            "AndroidBase", "AndroidSenior" , "Internet"
    };
    private static String[] AndroidBaseTitles = {
            "Activity", "Service", "BroadcastReceiver","ContentProvider","Fragment",
            "Andorid消息机制","View事件分发机制","View绘制原理","动画","AsyncTask","Bitmap","屏幕适配"
    };
    private static String[] AndroidSeniorTitles = {
            "Binder", "进程", "四大组件启动相关", "Window", "Apk安装过程", "Context", "Android权限处理",
            "多线程断点续传", "Retrofit2", "Glide", "Rxjava2","Okhttp3","Android Jepack","性能优化","插件化","组件化"
    };
    private static String[] InternetTitles = {
            "TCP/IP结构", "TCP", "UDP", "HTTP", "HTTPS", "Socket", "DNS", "AQS", "阻塞队列"
    };

    public List<MyBean> loadData() {
        List<MyBean> dataList = new ArrayList<>();
        for (int i = 0; i < AndroidTitles.length; i++) {
            MyBean bean = new MyBean();
            bean.setTitle(AndroidTitles[i]);
            List<MyBean.CommentBean> commentBeanList = new ArrayList<>();
            if (i == 0) {
                for (String jvmTitle : AndroidBaseTitles) {
                    MyBean.CommentBean commentBean = bean.new CommentBean();
                    commentBean.setTip(jvmTitle);
                    commentBean.setComment("");
                    commentBeanList.add(commentBean);
                }
            } else if (i == 1) {
                for (String javaBaseTitle : AndroidSeniorTitles) {
                    MyBean.CommentBean commentBean = bean.new CommentBean();
                    commentBean.setTip(javaBaseTitle);
                    commentBean.setComment("");
                    commentBeanList.add(commentBean);
                }

            } else if (i == 2) {
                for (String javaThreadTitle : InternetTitles) {
                    MyBean.CommentBean commentBean = bean.new CommentBean();
                    commentBean.setTip(javaThreadTitle);
                    commentBean.setComment("");
                    commentBeanList.add(commentBean);
                }
            }
            bean.setBeanList(commentBeanList);
            dataList.add(bean);
        }
        return dataList;
    }
}

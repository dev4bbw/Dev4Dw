package com.example.dev4dw.main.javaPage;

import com.example.apublic.bean.MyBean;

import java.util.ArrayList;
import java.util.List;

public class JavaModel   {
    private static String[] JavaTitles = {
            "JVM", "JavaBase", "JavaThread"
    };
    private static String[] JVMTitles = {
            "Java内存模型", "类加载机制", "垃圾收集"
    };
    private static String[] JavaBaseTitles = {
            "Object", "String", "继承", "注解", "序列化", "集合", "泛型", "反射机制", "IO", "深拷贝和浅拷贝", "设计模式"
    };
    private static String[] JavaThreadTitles = {
            "线程", "线程池", "锁", "Synchronized", "ReentranLock", "线程间通信", "Java内存模型", "AQS", "阻塞队列"
    };


    public List<MyBean> loadData() {
        List<MyBean> dataList = new ArrayList<>();
        for (int i = 0; i < JavaTitles.length; i++) {
            MyBean bean = new MyBean();
            bean.setTitle(JavaTitles[i]);
            List<MyBean.CommentBean> commentBeanList = new ArrayList<>();
            if (i == 0) {
                for (String jvmTitle : JVMTitles) {
                    MyBean.CommentBean commentBean = bean.new CommentBean();
                    commentBean.setTip(jvmTitle);
                    commentBean.setComment("");
                    commentBeanList.add(commentBean);
                }
            } else if (i == 1) {
                for (String javaBaseTitle : JavaBaseTitles) {
                    MyBean.CommentBean commentBean = bean.new CommentBean();
                    commentBean.setTip(javaBaseTitle);
                    commentBean.setComment("");
                    commentBeanList.add(commentBean);
                }

            } else if (i == 2) {
                for (String javaThreadTitle : JavaThreadTitles) {
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

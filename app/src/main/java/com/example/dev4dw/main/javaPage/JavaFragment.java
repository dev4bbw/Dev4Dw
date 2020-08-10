package com.example.dev4dw.main.javaPage;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.adapter.MyAdapter;
import com.example.dev4dw.base.BaseFragment;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;
import com.example.dev4dw.bean.MyBean;

import java.util.ArrayList;
import java.util.List;

public class JavaFragment extends BaseFragment<JavaContact.JView, JavaContact.JPresenter> implements JavaContact.JView {
    private RecyclerView mRv;
    String[] JavaTitles = {
            "JVM", "JavaBase", "JavaThread"
    };
    String[] JVMTitles = {
            "Java内存模型", "类加载机制", "垃圾收集"
    };
    String[] JavaBaseTitles = {
            "Object", "String", "继承", "注解", "序列化", "集合", "泛型", "反射机制", "IO", "深拷贝和浅拷贝", "设计模式"
    };
    String[] JavaThreadTitles = {
            "线程", "线程池", "锁", "Synchronized", "ReentranLock", "线程间通信", "Java内存模型", "AQS", "阻塞队列"
    };


    @Override
    public int getLayoutID() {
        return R.layout.fragment_java;
    }

    @Override
    public JavaContact.JPresenter createPresenter() {
        return new JavaPresenter();
    }

    @Override
    public JavaContact.JView createView() {
        return this;
    }

    @Override
    public void init(View view) {
        initWidgetsID(view);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        MyAdapter adapter = new MyAdapter(getContext());
        mRv.setAdapter(adapter);
        adapter.mList.addAll(initData());
        adapter.notifyDataSetChanged();

    }

    private void initWidgetsID(View view) {
        mRv = view.findViewById(R.id.rv);
    }

    private List<MyBean> initData() {
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

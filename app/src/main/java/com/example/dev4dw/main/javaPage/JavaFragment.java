package com.example.dev4dw.main.javaPage;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.adapter.MyAdapter;
import com.example.apublic.base.BaseFragment;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.BaseView;

public class JavaFragment extends BaseFragment<JavaContact.JView, JavaContact.JPresenter> implements JavaContact.JView {
    private RecyclerView mRv;

    public int getLayoutID() {
        return R.layout.fragment_java;
    }

    @Override
    public View bindingView() {
        return null;
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
        adapter.mList.addAll(getPresenter().getData());
        adapter.notifyDataSetChanged();
    }

    private void initWidgetsID(View view) {
        mRv = view.findViewById(R.id.rv);
    }
}

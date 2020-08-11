package com.example.dev4dw.main.androidPage;

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

public class AndroidFragment extends BaseFragment<AndroidContact.AView, AndroidContact.APresenter> implements AndroidContact.AView {


    @Override
    public int getLayoutID() {
        return R.layout.fragment_andorid;
    }

    @Override
    public AndroidPresenter createPresenter() {
        return new AndroidPresenter() ;
    }

    @Override
    public AndroidContact.AView createView() {
        return this;
    }

    @Override
    public void init(View view) {
        RecyclerView rv =  view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        MyAdapter adapter = new MyAdapter(getContext());
        rv.setAdapter(adapter);
        adapter.mList.addAll(getPresenter().getData());
        adapter.notifyDataSetChanged();
    }
}

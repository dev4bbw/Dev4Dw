package com.example.dev4dw.main.androidPage;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.adapter.MyAdapter;
import com.example.apublic.base.BaseFragment;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.BaseView;

public class AndroidFragment extends BaseFragment<AndroidContact.AView, AndroidContact.APresenter> implements AndroidContact.AView {


    public int getLayoutID() {
        return R.layout.fragment_andorid;
    }

    @Override
    public View bindingView() {
        return null;
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

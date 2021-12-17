package com.example.dev4dw.main.weather;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.apublic.base.BaseFragment;
import com.example.apublic.bean.ConditionBean;
import com.example.apublic.utils.DisplayUtil;
import com.example.apublic.utils.TimeUtil;
import com.example.dev4dw.R;
import com.example.dev4dw.databinding.FragmentConditionBinding;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ConditionFragment extends BaseFragment<ConditionFragment,ConditionPresenter> {
    FragmentConditionBinding mBinding;
    private List<ConditionBean.ResultBean.FutureBean> futureList = new ArrayList<>();
    private  CommonAdapter<ConditionBean.ResultBean.FutureBean> commonAdapter;
    @Override
    public ConditionPresenter createPresenter() {
        return new ConditionPresenter();
    }

    @Override
    public ConditionFragment createView() {
        return this;
    }

    @Override
    public View bindingView() {
        mBinding = FragmentConditionBinding.inflate(getLayoutInflater());
        return mBinding.getRoot();
    }


    @Override
    public void init(View view) {
        int screenH = DisplayUtil.getScreenH(getActivity());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.height = screenH/2;
        mBinding.rlTodayWeather.setLayoutParams(lp);

        initRv();
        String current = TimeUtil.formatDates3(System.currentTimeMillis());
        mBinding.date.setText(current);

    }

    private void initRv() {
        mBinding.futureRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        commonAdapter =
                new CommonAdapter<ConditionBean.ResultBean.FutureBean>(getActivity(), R.layout.item_condition_weather,futureList) {
            @Override
            protected void convert(ViewHolder holder, ConditionBean.ResultBean.FutureBean futureBean, int position) {
                holder.setText(R.id.date,futureBean.getDate());
                holder.setText(R.id.temper,futureBean.getTemperature());
                holder.setText(R.id.weather,futureBean.getWeather());
                holder.setText(R.id.day,futureBean.getWid().getDay());
                holder.setText(R.id.night,futureBean.getWid().getNight());
                holder.setText(R.id.direct,futureBean.getDirect());

            }
        };
        mBinding.futureRv.setAdapter(commonAdapter);
    }

    public void setCity(String city){
        mPresenter.getWeather(city);
    }


    public void getWeatherSuccess(ConditionBean entity) {
        mBinding.wid.setText(entity.getResult().getRealtime().getWid());
        mBinding.humidity.setText("湿度："+entity.getResult().getRealtime().getHumidity());
        mBinding.temper.setText(entity.getResult().getRealtime().getTemperature());
        mBinding.direct.setText("风向："+entity.getResult().getRealtime().getDirect());
        mBinding.power.setText("风力："+entity.getResult().getRealtime().getPower());
        mBinding.aqi.setText("空气质量指数："+entity.getResult().getRealtime().getAqi());
        mBinding.info.setText(entity.getResult().getRealtime().getInfo());
        futureList.clear();
        futureList.addAll(entity.getResult().getFuture());

        commonAdapter.notifyDataSetChanged();
    }
}

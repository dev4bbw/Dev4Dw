package com.example.apublic.customer;

import androidx.annotation.NonNull;

import com.baozi.treerecyclerview.base.ViewHolder;
import com.baozi.treerecyclerview.item.TreeItem;
import com.example.apublic.R;
import com.example.apublic.bean.CommonCityBean;



public class DistrictItem extends TreeItem<CommonCityBean.CityBean.DistrictBean> {
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder) {
        viewHolder.setText(R.id.tv_content,data.getDistrictName());
    }

    @Override
    public int getSpanSize(int maxSpan) {
        return maxSpan/6;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_three;
    }

    @Override
    public void onClick(ViewHolder viewHolder) {
        super.onClick(viewHolder);

    }
}

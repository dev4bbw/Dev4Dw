package com.example.apublic.customer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.baozi.treerecyclerview.base.ViewHolder;
import com.baozi.treerecyclerview.factory.ItemHelperFactory;
import com.baozi.treerecyclerview.item.TreeItem;
import com.baozi.treerecyclerview.item.TreeItemGroup;
import com.example.apublic.R;
import com.example.apublic.bean.CommonCityBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CityItem extends TreeItemGroup<CommonCityBean.CityBean> {
    @Nullable
    @Override
    protected List<TreeItem> initChild(CommonCityBean.CityBean data) {
        return ItemHelperFactory.createItems(data.getDistrict(),DistrictItem.class,this);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder viewHolder) {
        viewHolder.setText(R.id.tv_content,data.getCityName());
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_two;
    }
}

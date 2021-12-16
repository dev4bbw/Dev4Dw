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

public class ProvinceItem extends TreeItemGroup<CommonCityBean> {
    @Nullable
    @Override
    protected List<TreeItem> initChild(CommonCityBean data) {
        return ItemHelperFactory.createItems(data.getCity(),CityItem.class,this);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder viewHolder) {
        viewHolder.setText(R.id.tv_content,data.getProvinceName());
    }

    @Override
    public int getLayoutId() {
        return R.layout.itme_one;

    }
}

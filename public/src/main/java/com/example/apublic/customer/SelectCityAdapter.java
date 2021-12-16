package com.example.apublic.customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apublic.R;
import com.example.apublic.bean.CommonCityBean;
import com.example.apublic.bean.WeatherCity;

import java.util.ArrayList;
import java.util.List;


public class SelectCityAdapter extends RecyclerView.Adapter<SelectCityAdapter.SelectCityHolder> {
    private List<CommonCityBean> dataList = new ArrayList<>();
    private Context context;
    private OnCityClickListener listener;

    public SelectCityAdapter(Context context, List<CommonCityBean> list) {
        this.context = context;
        this.dataList = list;
    }

    @Override
    public SelectCityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false);
        return new SelectCityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectCityHolder holder, int position) {
        CommonCityBean bean = dataList.get(position);
        String province = bean.getProvinceName();
//        String city = bean.getCity();
//        String district = bean.getDistrict();

        holder.province.setText(province);
//        holder.city.setText(city);
//        holder.district.setText(district);
        holder.province.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.clickCity(province);
                }
            }
        });
        holder.city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
//                    listener.clickCity(city);
                }
            }
        });
        holder.district.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
//                    listener.clickCity(district);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setClickListener(OnCityClickListener listener) {
        this.listener = listener;
    }

    static class SelectCityHolder extends RecyclerView.ViewHolder {
        TextView province, city, district;

        public SelectCityHolder(@NonNull View itemView) {
            super(itemView);
            province = itemView.findViewById(R.id.province);
            city = itemView.findViewById(R.id.city);
            district = itemView.findViewById(R.id.district);
        }
    }

    public interface OnCityClickListener {
        void clickCity(String city);
    }
}

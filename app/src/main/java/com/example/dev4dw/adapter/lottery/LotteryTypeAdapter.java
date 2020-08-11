package com.example.dev4dw.adapter.lottery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.bean.lottery.LotteryTypeBean;

import java.util.ArrayList;
import java.util.List;

public class LotteryTypeAdapter extends RecyclerView.Adapter<LotteryTypeAdapter.LotteryTypeVH> {
    private Context mContext;
    public List<LotteryTypeBean.ResultBean> mTypeList = new ArrayList<>();

    public LotteryTypeAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public LotteryTypeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.lotterytype_item, parent, false);
        return new LotteryTypeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LotteryTypeVH holder, int position) {
        LotteryTypeBean.ResultBean bean = mTypeList.get(position);
        holder.name.setText(bean.getLottery_name());
        holder.id.setText(bean.getLottery_id());
        holder.remarks.setText(bean.getRemarks());
    }

    @Override
    public int getItemCount() {
        return mTypeList.size();
    }

    class LotteryTypeVH extends RecyclerView.ViewHolder {
        TextView name, id, remarks;

        LotteryTypeVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            id = itemView.findViewById(R.id.id);
            remarks = itemView.findViewById(R.id.remarks);
        }
    }
}

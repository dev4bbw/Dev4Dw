package com.example.dev4dw.adapter.lottery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.bean.lottery.LotteryHistoryBean;

import java.util.ArrayList;
import java.util.List;

public class LotteryHistoryAdapter extends RecyclerView.Adapter<LotteryHistoryAdapter.HistoryVH> {
    public List<LotteryHistoryBean.ResultBean.LotteryResListBean> mHistoryList = new ArrayList<>();
    private Context mContext;
    public LotteryHistoryAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public HistoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.lotteryhistory_item,parent,false);
        return new HistoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryVH holder, int position) {
        LotteryHistoryBean.ResultBean.LotteryResListBean bean = mHistoryList.get(position);
        holder.res.setText(bean.getLottery_res());
        holder.no.setText(bean.getLottery_no());
        holder.date.setText(bean.getLottery_date());
        holder.sale.setText(bean.getLottery_sale_amount());
    }

    @Override
    public int getItemCount() {
        return mHistoryList.size();
    }

    class HistoryVH extends RecyclerView.ViewHolder{
        TextView res,no,date,sale;

        public HistoryVH(@NonNull View itemView) {
            super(itemView);
            res = itemView.findViewById(R.id.res);
            no = itemView.findViewById(R.id.no);
            date = itemView.findViewById(R.id.date);
            sale = itemView.findViewById(R.id.sale);
        }
    }
}

package com.example.dev4dw.adapter.lottery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.apublic.bean.lottery.LotteryBonusBean;

import java.util.ArrayList;
import java.util.List;

public class LotteryBonusAdapter extends RecyclerView.Adapter<LotteryBonusAdapter.BonusVH> {
    public List<LotteryBonusBean.ResultBean.LotteryPrizeBean> mBonusList = new ArrayList<>();
    private Context mContext;
    public LotteryBonusAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public BonusVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.lotterybonus_item,parent,false);
        return new BonusVH(view);
    }

    @Override
    public int getItemCount() {
        return mBonusList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BonusVH holder, int position) {
        LotteryBonusBean.ResultBean.LotteryPrizeBean bean = mBonusList.get(position);
        holder.pname.setText(bean.getPrize_name());
        holder.pnum.setText(bean.getPrize_num());
        holder.per.setText(bean.getPrize_money());

    }

    class BonusVH extends RecyclerView.ViewHolder{
        TextView pname,pnum,per;
        public BonusVH(@NonNull View itemView) {
            super(itemView);
            pname=itemView.findViewById(R.id.prizename);
            pnum=itemView.findViewById(R.id.num);
            per=itemView.findViewById(R.id.perprize);

        }
    }
}

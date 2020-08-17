package com.example.dev4dw.adapter.lottery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.bean.lottery.LotteryQueryBean;

import java.util.ArrayList;
import java.util.List;

public class LotteryQueryAdapter extends RecyclerView.Adapter<LotteryQueryAdapter.LqVH> {
    public List<LotteryQueryBean.ResultBean.LotteryPrizeBean> mQueryList = new ArrayList<>();
    private Context mContext;
    public LotteryQueryAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public LqVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.lotteryquery_item,parent,false);
        return new LqVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LqVH holder, int position) {
        LotteryQueryBean.ResultBean.LotteryPrizeBean bean = mQueryList.get(position);
        holder.name.setText(bean.getPrize_name());
        holder.num.setText(bean.getPrize_num());
        holder.amount.setText(bean.getPrize_amount());
        holder.req.setText(bean.getPrize_require());
    }

    @Override
    public int getItemCount() {
        return mQueryList.size();
    }

    class LqVH extends RecyclerView.ViewHolder{
        TextView name,num,amount,req;
        public LqVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            num = itemView.findViewById(R.id.num);
            amount = itemView.findViewById(R.id.amount);
            req = itemView.findViewById(R.id.require);

        }
    }
}

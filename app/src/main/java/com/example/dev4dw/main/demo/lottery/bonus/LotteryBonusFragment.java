package com.example.dev4dw.main.demo.lottery.bonus;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.adapter.lottery.LotteryBonusAdapter;
import com.example.dev4dw.base.BaseFragment;
import com.example.dev4dw.bean.lottery.LotteryBonusBean;

public class LotteryBonusFragment extends BaseFragment<LotteryBonusContact.BView, LotteryBonusContact.BPresenter> implements LotteryBonusContact.BView {
    EditText a,b,c,d,e,f,sp,buyNo;
    Button bonus;
    TextView name,no,date,res,prize,isprize,msg,noprize;
    RecyclerView rv;
    LotteryBonusAdapter adapter;
    @Override
    public int getLayoutID() {
        return R.layout.fragment_query_bonus;
    }

    @Override
    public LotteryBonusContact.BPresenter createPresenter() {
        return new LotteryBonusPresenter();
    }

    @Override
    public LotteryBonusContact.BView createView() {
        return this;
    }

    @Override
    public void init(View view) {
        initID(view);
        bonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "ssq";
                String res=a.getText().toString()+","+b.getText().toString()+","+c.getText().toString()+","+
                d.getText().toString()+","+e.getText().toString()+","+f.getText().toString()+"@"+
                        sp.getText().toString();
                String no=buyNo.getText().toString();
                getPresenter().getBonusResult(id,res,no);
            }
        });
        adapter = new LotteryBonusAdapter(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }

    private void initID(View view) {
        a=view.findViewById(R.id.A);
        b=view.findViewById(R.id.B);
        c=view.findViewById(R.id.C);
        d=view.findViewById(R.id.D);
        e=view.findViewById(R.id.E);
        f=view.findViewById(R.id.F);
        sp=view.findViewById(R.id.SP);
        buyNo=view.findViewById(R.id.buy_no);
        bonus=view.findViewById(R.id.bonus);
        name=view.findViewById(R.id.name);
        no=view.findViewById(R.id.no);
        date=view.findViewById(R.id.date);
        res=view.findViewById(R.id.res);
        prize=view.findViewById(R.id.prize);
        isprize=view.findViewById(R.id.isprize);
        msg = view.findViewById(R.id.msg);
        noprize=view.findViewById(R.id.noprize);
        rv = view.findViewById(R.id.bonus_rv);
    }

    @Override
    public void bonusResult(LotteryBonusBean.ResultBean resultBean) {
        name.setText(resultBean.getLottery_name());
        no.setText(resultBean.getLottery_no());
        date.setText(resultBean.getLottery_date());
        res.setText(resultBean.getReal_lottery_res());
        prize.setText(resultBean.getIn_money());
        isprize.setText(resultBean.getIs_prize().equals("1")?"中奖":"未中奖");
        msg.setText(resultBean.getPrize_msg());
        if (resultBean.getLottery_prize() == null){
            rv.setVisibility(View.GONE);
            noprize.setVisibility(View.VISIBLE);
        }else {
            noprize.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
            adapter.mBonusList.clear();
            adapter.mBonusList.addAll(resultBean.getLottery_prize());
            adapter.notifyDataSetChanged();
        }

    }
}

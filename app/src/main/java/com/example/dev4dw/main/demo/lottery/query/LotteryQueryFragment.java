package com.example.dev4dw.main.demo.lottery.query;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.adapter.lottery.LotteryHistoryAdapter;
import com.example.dev4dw.adapter.lottery.LotteryQueryAdapter;
import com.example.dev4dw.base.BaseFragment;
import com.example.dev4dw.bean.lottery.LotteryHistoryBean;
import com.example.dev4dw.bean.lottery.LotteryQueryBean;

public class LotteryQueryFragment extends BaseFragment<LotteryQueryContact.QView, LotteryQueryContact.QPresenter>implements LotteryQueryContact.QView {
    EditText qid,qno,page,hid;
    Button qbtn,hbtn;
    TextView name,res,no,date,sell,totoal;
    RecyclerView qRv,hRv;
    LotteryQueryAdapter mQueryAdapter;
    LotteryHistoryAdapter mHistoryAdapter;
    @Override
    public int getLayoutID() {
        return R.layout.fragment_lottery_query;
    }

    @Override
    public LotteryQueryContact.QPresenter createPresenter() {
        return new LoterryQueryPresenter();
    }

    @Override
    public LotteryQueryContact.QView createView() {
        return this;
    }

    @Override
    public void init(View view) {
        initID(view);
        qbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!qid.getText().toString().equals("")) {
                    String id = qid.getText().toString();
                    String nb = qno.getText().toString();
                    getPresenter().queryLottery(id,nb);
                }else {
                    Toast.makeText(getContext(),"必须要有彩票ID",Toast.LENGTH_SHORT).show();
                }
            }
        });
        hbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hid.getText().toString().equals("")) {
                    String id = hid.getText().toString();
                    String pg = page.getText().toString();
                    getPresenter().historyLottery(id,pg);
                }else {
                    Toast.makeText(getContext(),"必须要有彩票ID",Toast.LENGTH_SHORT).show();
                }
            }
        });
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        qRv.setLayoutManager(lm);
        mQueryAdapter =new LotteryQueryAdapter(getContext());
        qRv.setAdapter(mQueryAdapter);

        LinearLayoutManager hlm = new LinearLayoutManager(getContext());
        hRv.setLayoutManager(hlm);
        mHistoryAdapter = new LotteryHistoryAdapter(getContext());
        hRv.setAdapter(mHistoryAdapter);

    }

    private void initID(View view) {
        qid = view.findViewById(R.id.qid);
        qno = view.findViewById(R.id.qno);
        page = view.findViewById(R.id.page);
        qbtn = view.findViewById(R.id.query_button);
        hbtn = view.findViewById(R.id.history_button);
        name = view.findViewById(R.id.name);
        res = view.findViewById(R.id.res);
        no = view.findViewById(R.id.no);
        date = view.findViewById(R.id.date);
        sell = view.findViewById(R.id.sell);
        qRv = view.findViewById(R.id.query_rv);
        hRv = view.findViewById(R.id.history_rv);
        totoal = view.findViewById(R.id.totalpage);
        hid = view.findViewById(R.id.hid);
    }


    @Override
    public void queryResult(LotteryQueryBean.ResultBean result) {
        name.setText(result.getLottery_name());
        res.setText(result.getLottery_res());
        no.setText(result.getLottery_no());
        date.setText(result.getLottery_date());
        sell.setText(result.getLottery_sale_amount());
        mQueryAdapter.mQueryList.clear();
        mQueryAdapter.mQueryList.addAll(result.getLottery_prize());
        mQueryAdapter.notifyDataSetChanged();
    }

    @Override
    public void historyResult(LotteryHistoryBean.ResultBean reult) {
        totoal.setText(reult.getPage()+"/"+reult.getTotalPage());
        mHistoryAdapter.mHistoryList.clear();
        mHistoryAdapter.mHistoryList.addAll(reult.getLotteryResList());
        mHistoryAdapter.notifyDataSetChanged();
    }
}

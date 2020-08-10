package com.example.dev4dw.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.bean.MyBean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context mContext;
    public List<MyBean> mList = new ArrayList<>();

    public MyAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        if (mList.size() == 0) return;
        holder.title.setText(mList.get(position).getTitle());
        List<MyBean.CommentBean> commentBeanList = mList.get(position).getBeanList();
        if (commentBeanList == null || commentBeanList.size() == 0) return;
        for (int i = 0; i < commentBeanList.size(); i++) {
            holder.commentPart.addView(getTipView(commentBeanList.get(i).getTip()));
            holder.commentPart.addView(getCommentView(commentBeanList.get(i).getComment()));
        }
        holder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (holder.commentPart.getVisibility() == View.VISIBLE) {
//                    holder.commentPart.setVisibility(View.GONE);
//                }
//                if (holder.commentPart.getVisibility() == View.GONE) {
//                    holder.commentPart.setVisibility(View.VISIBLE);
//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        Button show;
        LinearLayout commentPart;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            show = itemView.findViewById(R.id.showcm);
            commentPart = itemView.findViewById(R.id.commentPart);
        }
    }

    private TextView getTipView(String tip) {
        TextView tv = new TextView(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        params.addRule(RelativeLayout.ALIGN_PARENT_START);
        params.gravity = Gravity.CENTER;
        tv.setLayoutParams(params);
        tv.setText(tip);
        tv.setTextSize(12);
        return tv;
    }

    private TextView getCommentView(String comment) {
        TextView tv = new TextView(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        params.addRule(RelativeLayout.ALIGN_PARENT_START);
        tv.setLayoutParams(params);
        tv.setText(comment);
        tv.setTextSize(12);
        return tv;
    }
}

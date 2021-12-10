package com.example.dev4dw.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apublic.bean.VideoBean;
import com.example.apublic.bean.home.NewsBean;
import com.example.apublic.utils.glide.GlideUtils;
import com.example.dev4dw.R;
import com.example.dev4dw.main.video.VideoListAty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {
    public List<VideoBean.ResultBean> dataList = new ArrayList<>();
    private Context context;
    public VideoAdapter(Context context){
        this.context = context;
    }
    public void setData(List<VideoBean.ResultBean> list){
        dataList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video,parent,false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        VideoBean.ResultBean bean = dataList.get(position);
        holder.rl_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoListAty.class);
                intent.putExtra("VIDEO_BEAN", bean);
                context.startActivity(intent);
            }
        });
        GlideUtils.loadImg(bean.getAvatar(),holder.avatar);
        holder.author.setText(bean.getNickname());
        holder.follower.setText("粉丝数："+bean.getFollower_count());
        holder.effect.setText("影响力指数："+bean.getEffect_value());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class VideoHolder extends RecyclerView.ViewHolder{
        RelativeLayout rl_item;
        ImageView avatar;
        TextView author,follower,effect;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            rl_item = itemView.findViewById(R.id.rl_item);
            avatar = itemView.findViewById(R.id.avatar);
            author = itemView.findViewById(R.id.author);
            follower = itemView.findViewById(R.id.follower);
            effect = itemView.findViewById(R.id.effect);

        }
    }
}

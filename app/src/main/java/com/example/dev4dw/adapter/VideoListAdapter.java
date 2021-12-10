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
import com.example.apublic.utils.glide.GlideUtils;
import com.example.dev4dw.R;
import com.example.dev4dw.main.video.VideoListAty;
import com.example.dev4dw.main.video.VideoPlayAty;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoListHolder> {
    List<VideoBean.ResultBean.VideoListBean> vList = new ArrayList<>();
    Context context;

    public VideoListAdapter(Context context){
        this.context = context;
    }
    public void setData(List<VideoBean.ResultBean.VideoListBean> list){
        vList = list;
        notifyDataSetChanged();
    }
    @NotNull
    @Override
    public VideoListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video_list,parent,false);
        return new VideoListHolder(view);
    }

    @Override
    public int getItemCount() {
        return vList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VideoListHolder holder, int position) {
        VideoBean.ResultBean.VideoListBean bean = vList.get(position);
        holder.rl_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoPlayAty.class);
                intent.putExtra("VIDEO_URL", bean.getShare_url());
                context.startActivity(intent);
            }
        });
        GlideUtils.loadImg(bean.getItem_cover(),holder.avatar);
        holder.author.setText(bean.getTitle());
    }

    static class VideoListHolder extends RecyclerView.ViewHolder{
        RelativeLayout rl_item;
        ImageView avatar;
        TextView author;
        public VideoListHolder(@NonNull View itemView) {
            super(itemView);
            rl_item = itemView.findViewById(R.id.rl_item);
            avatar = itemView.findViewById(R.id.avatar);
            author = itemView.findViewById(R.id.author);
        }
    }
}

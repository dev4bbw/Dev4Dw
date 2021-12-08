package com.example.dev4dw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apublic.bean.VideoBean;
import com.example.apublic.bean.home.NewsBean;
import com.example.apublic.utils.glide.GlideUtils;
import com.example.dev4dw.R;

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
        GlideUtils.loadImg(dataList.get(position).getAvatar(),holder.avatar);
        holder.author.setText(dataList.get(position).getNickname());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class VideoHolder extends RecyclerView.ViewHolder{
        ImageView avatar;
        TextView author;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            author = itemView.findViewById(R.id.author);
        }
    }
}

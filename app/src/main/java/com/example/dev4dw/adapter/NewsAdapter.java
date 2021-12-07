package com.example.dev4dw.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apublic.bean.home.NewsBean;
import com.example.apublic.utils.DisplayUtil;
import com.example.apublic.utils.glide.GlideUtils;
import com.example.dev4dw.R;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    Context context;
    List<NewsBean.ResultBean.DataBean> dataList = new ArrayList<>();
    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<NewsBean.ResultBean.DataBean> list){
        dataList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.cate.setText(dataList.get(position).getCategory());
        holder.author.setText(dataList.get(position).getAuthor_name());
        holder.time.setText(dataList.get(position).getDate());
        String pic1 = dataList.get(position).getThumbnail_pic_s();
        String pic2 = dataList.get(position).getThumbnail_pic_s02();
        String pic3 = dataList.get(position).getThumbnail_pic_s03();
        holder.ll_iv.removeAllViews();
        addImg(holder.ll_iv,pic1,pic2,pic3);
    }

    private void addImg(LinearLayout con, String p1, String p2, String p3) {
        int count = 0;
        if (!TextUtils.isEmpty(p1)){
            count++;
        }
        if (!TextUtils.isEmpty(p2)){
            count++;
        }
        if (!TextUtils.isEmpty(p3)){
            count++;
        }
        ImageView img1 = null;
        ImageView img2 = null;
        ImageView img3 = null;
        switch (count){
            case 1:
                img1 = createImg(1);
                con.addView(img1);
                GlideUtils.loadImg(p1,img1);
                break;
            case 2:
                img1 = createImg(2);
                con.addView(img1);
                GlideUtils.loadImg(p1,img1);
                img2 = createImg(2);
                con.addView(img2);
                GlideUtils.loadImg(p2,img2);
                break;
            case 3:
                img1 = createImg(3);
                con.addView(img1);
                GlideUtils.loadImg(p1,img1);
                img2 = createImg(3);
                con.addView(img2);
                GlideUtils.loadImg(p2,img2);
                img3 = createImg(3);
                con.addView(img3);
                GlideUtils.loadImg(p3,img3);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private ImageView createImg(int imgSize){
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        lp.rightMargin = DisplayUtil.dp2px(context,5);
        lp.leftMargin = DisplayUtil.dp2px(context,5);
        int sw = DisplayUtil.getScreenW(context);
        int eachW = 0;
        switch (imgSize){
            case 1:
                eachW = (int) Math.ceil(sw/2d);
                break;
            case 2:
                eachW = (int) Math.ceil(sw/2.5d);
                break;
            case 3:
                eachW = (int) Math.ceil(sw/3.5);
                break;
        }
        int eachH = (int) Math.ceil(eachW * (9.0/16.0));
        lp.width = eachW;
        lp.height = eachH;

        ImageView iv = new ImageView(context);
        iv.setLayoutParams(lp);
        iv.setAdjustViewBounds(true);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        return iv;
    }

    static class NewsHolder extends RecyclerView.ViewHolder {
        TextView title, cate, author, time;
        LinearLayout ll_iv;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            cate = itemView.findViewById(R.id.cate);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            ll_iv = itemView.findViewById(R.id.ll_iv);
        }
    }
}

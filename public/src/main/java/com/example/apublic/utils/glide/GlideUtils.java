package com.example.apublic.utils.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.apublic.R;
import com.example.apublic.base.BaseApp;

import java.io.File;


public class GlideUtils {

    public static void loadImg(String url,ImageView iv){
        Glide.with(BaseApp.getInstance().getApplicationContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(iv);
    }

    /**
     * 加载圆形图片
     * */
    public static void loadCircleImg(String url, ImageView iv) {
        RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存

        Glide.with(BaseApp.getInstance().getApplicationContext()).load(url).apply(mRequestOptions).into(iv);
    }
    /**
     * 加载图片url,并转换成圆形显示
     */
    public static void loadCircleImageUrl(ImageView imageView,String imgUrl,
                                          Drawable placeholder) {
        Context context = BaseApp.getInstance().getApplicationContext();

        Glide.with(context)
                .load(imgUrl)
//                .placeholder(placeholder)
                //加载圆形图片
                .circleCrop()
                //渐变动画
                .transition(DrawableTransitionOptions.withCrossFade())
                .skipMemoryCache(true)
                //原图20%的缩略图
//                .thumbnail(0.2f)
//                .error(R.mipmap.ic_default_portrait)
//                .placeholder(R.mipmap.ic_default_portrait)
                .into(imageView);
    }

    /**
     * 加载圆角图片
     * */
    public static void loadRoundImg(String url, ImageView iv,int radius) {
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(radius);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);

        Glide.with(BaseApp.getInstance().getApplicationContext())
                .load(url)
//                .error(R.mipmap.ic_default_portrait)
//                .placeholder(R.mipmap.ic_default_portrait)
                .apply(options).into(iv);
    }

    /**
     * 加载圆角Bitmap
     * */
    public static void loadRoundBitmap(Bitmap bitmap, ImageView iv, int radius) {
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(radius);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);

        Glide.with(BaseApp.getInstance().getApplicationContext()).load(bitmap).apply(options).into(iv);
    }

    /**
     * 加载正常图片
     * */
    public static void loadNormalImg(String path, ImageView iv) {
        Glide.with(BaseApp.getInstance().getApplicationContext()).load(path).into(iv);
    }

    /**
     * 加载正常图片
     * */
    public static void loadNormalImg(String path, ImageView iv,int errorRes,int lodingRes) {
        Glide.with(BaseApp.getInstance().getApplicationContext())
                .load(path)
                .error(errorRes)
                .placeholder(lodingRes)
                .into(iv);
    }

    public static void loadDefaultImg(String path, ImageView iv,int radius) {
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(radius);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        Glide.with(BaseApp.getInstance().getApplicationContext())
                .load(path)
//                .error(R.drawable.icon_load_failed)
//                .placeholder(R.drawable.icon_loading)
                .apply(options)
                .into(iv);
    }

    public static void loadDefaultImg(String path, ImageView iv) {
        Glide.with(BaseApp.getInstance().getApplicationContext())
                .load(path)
//                .error(R.drawable.icon_load_failed)
//                .placeholder(R.drawable.icon_loading)
                .into(iv);
    }

    public static void loadNormalImg(String path, ImageView iv,int radius,int errorRes,int lodingRes) {

        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(radius);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);

        Glide.with(BaseApp.getInstance().getApplicationContext())
                .load(path)
                .error(errorRes)
                .placeholder(lodingRes)
                .apply(options).into(iv);
    }


    /**
     * 加载圆形File
     * 聊天接收方头像
     */
    public static void loadReceiveFile(File file, ImageView iv){
        Context context = BaseApp.getInstance().getApplicationContext();
        RequestOptions options = new RequestOptions();
//        options.placeholder(R.mipmap.ic_chat_driver_default)
//                .error(R.mipmap.ic_chat_driver_default)
//                .circleCrop();
        Glide.with(context).asBitmap().load(file).apply(options).into(iv);
    }

    /**
     * 加载圆形File
     * 聊天发送方头像
     */
    public static void loadSendFile(File file, ImageView iv){
        Context context = BaseApp.getInstance().getApplicationContext();
        RequestOptions options = new RequestOptions();
//        options.placeholder(R.mipmap.ic_chat_user_default)
//                .error(R.mipmap.ic_chat_user_default)
//                .circleCrop();
        Glide.with(context).asBitmap().load(file).apply(options).into(iv);
    }


    /**
     * 加载圆形File
     * 聊天发送方头像
     */
    public static void loadCarImage(String imgUrl, ImageView iv){
        Context context = BaseApp.getInstance().getApplicationContext();
        Glide.with(context)
                .load(imgUrl)
//                .placeholder(R.mipmap.iv_rentcar_bg)
//                .error(R.mipmap.iv_rentcar_bg)
                .into(iv);
    }

    /**
     * 加载活动图片
     * */
    public static void loadActivitiesImg(String url, ImageView iv) {
        Context context = BaseApp.getInstance().getApplicationContext();
        RequestOptions options = new RequestOptions();
        options.dontAnimate().transform(new GlideRoundTransform(5));
        Glide.with(context)
                .load(url)
//                .placeholder(R.mipmap.bg_ad_pre)
//                .error(R.mipmap.bg_ad_pre)
                .apply(options)
                .into(iv);

    }

    /**
     * 加载广告图片
     * */
    public static void loadAdImg(String url, ImageView iv,int id) {
        Context context = BaseApp.getInstance().getApplicationContext();
        RequestOptions options = new RequestOptions();
        options.dontAnimate().transform(new GlideRoundTransform(5));
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .apply(options)
                .placeholder(id)
                .error(id)
                .into(iv);

    }
}

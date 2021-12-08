package com.example.apublic.customer;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apublic.R;


/**
 * 头部布局

 在xml中使用时，这两个属性必须要设置，因为是以这里的这个appTopBar为准，而不是该View使用的布局为准。
 android:id="@+id/appTopBar"
 android:background="#ffffff"

 例如：
 <com.lanyoumobility.app_manage.view.HeadLayout
 android:id="@+id/appTopBar"
 android:background="#ffffff"
 app:head_title="车辆管理"
 android:layout_width="match_parent"
 android:layout_height="wrap_content"/>

 */
public class HeadLayout extends RelativeLayout {
    private Context mContext;

//    private View layout;
    private RelativeLayout rl_left;
    private RelativeLayout rl_right;
    private ImageView iv_left;//左图标
    private TextView tvTitle;//标题
    private ImageView iv_right;//右图标

    //imgBack的事件
    public interface OnBackClickListener {
        void onBackClick();
    }
    private OnBackClickListener backClickListener;

    public void setBackClickListener(OnBackClickListener backClickListener) {
        this.backClickListener = backClickListener;
    }


    //imgMenu的事件
    public interface OnMenuClickListener {
        void onMenuOpen();
    }

    private OnMenuClickListener menuClickListener;

    public void setOnMenuClickListener(OnMenuClickListener menuClickListener) {
        this.menuClickListener = menuClickListener;
    }

    //private float mLayoutHeight;
    private int mBgColor;
    private Drawable mBackImg;
    private String mTitle;
    private float mTitleSize;
    private int mTitleColor;
    private Drawable mMenuImg;
    private boolean showTitle,showLeft,showRight;


    public HeadLayout(Context context) {
        this(context, null);
    }

    public HeadLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.HeadLayout);
        try {
           // mLayoutHeight =  a.getFloat(R.styleable.HeadLayout_head_height, 0f);
            mBgColor = a.getInt(R.styleable.HeadLayout_head_bg_color, 0);
            mBackImg = a.getDrawable(R.styleable.HeadLayout_head_back_img);
            mTitle = a.getString(R.styleable.HeadLayout_head_title);
            mTitleSize = a.getFloat(R.styleable.HeadLayout_head_title_size,15f);
            mTitleColor = a.getInt(R.styleable.HeadLayout_head_title_color, 0);
            mMenuImg = a.getDrawable(R.styleable.HeadLayout_head_menu_img);
            showTitle = a.getBoolean(R.styleable.HeadLayout_head_show_title,true);
            showLeft = a.getBoolean(R.styleable.HeadLayout_head_show_left,true);
            showRight = a.getBoolean(R.styleable.HeadLayout_head_show_right,true);
        } finally {
            a.recycle();
        }

        initView();
    }


    private void initView() {
        View contentView = View.inflate(mContext, R.layout.headbar, this);
        rl_left = contentView.findViewById(R.id.rl_left);
        rl_right = contentView.findViewById(R.id.rl_right);
        iv_left =  contentView.findViewById(R.id.iv_left);
        iv_right = contentView.findViewById(R.id.iv_right);
        tvTitle = contentView.findViewById(R.id.title);

        contentView.findViewById(R.id.iv_left).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backClickListener != null) {
                    backClickListener.onBackClick();
                } else if (mContext instanceof Activity) {
                    ((Activity) mContext).finish();
                }
            }
        });

        iv_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menuClickListener != null) {
                    menuClickListener.onMenuOpen();
                }
            }
        });

       /* if( mLayoutHeight != 0f){
            ViewGroup.LayoutParams layoutParams= layout.getLayoutParams();
            layoutParams.height =(int)mLayoutHeight;
            layout.setLayoutParams(layoutParams);
        }*/
//        if (mBgColor != 0)
//            layout.setBackgroundColor(mBgColor);

        if(mBackImg != null)
            setBackImg(mBackImg);

        if( mTitle != null )
            setTitle(mTitle);

        if( mTitleSize != 0.0f)
            setTitleSize(mTitleSize);

        if ( mTitleColor != 0 )
            setTitleColor(mTitleColor);

        if( mMenuImg != null){
            setMenuImg(mMenuImg);
        }
        setBackImgVisibility(showLeft);
        setTvTitleVisibility(showTitle);
        setMenuImgVisibility(showRight);
    }


    /**
     * 左图标
     */
    public void setBackImg(Drawable img) {
        if (img != null) {
            iv_left.setImageDrawable(img);
        }
    }

    public void setBackImg(Context context, int resId) {
        setBackImg(context.getResources().getDrawable(resId));
    }

    public void setBackImgVisibility(boolean state) {
        rl_left.setVisibility(state ? View.VISIBLE : View.INVISIBLE);
    }

    public ImageView getBackImageView(){
        return iv_left;
    }



    /**
     * 标题
     */
    public void setTitle(String title) {
        if (title != null )
            tvTitle.setText(title);
    }

    public void setTitleSize(float size) {
        if (size != 0 )
            tvTitle.setTextSize(size);
    }
    public void setTvTitleVisibility(boolean state) {
        rl_right.setVisibility(state ? View.VISIBLE : View.INVISIBLE);
    }
    public void setTitleColor(int color) {
        if (color != 0 )
            tvTitle.setTextColor(color);
    }

    public TextView getTitleTextView(){
        return tvTitle;
    }




    /**
     * 右图片
     */
    public void setMenuImg(Drawable img) {
        if (img != null) {
            iv_right.setImageDrawable(img);
            iv_right.setVisibility(VISIBLE);
        }
    }

    public void setMenuImg(Context context, int resId) {
        setMenuImg(context.getResources().getDrawable(resId));
    }

    public void setMenuImgVisibility(boolean visibility) {
        iv_right.setVisibility( visibility ? View.VISIBLE : View.INVISIBLE);
    }

    public ImageView getMenuImageView(){
        return iv_right;
    }


}

package com.example.apublic.customer;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.apublic.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class TackNewTabLayout extends TabLayout {
    public TackNewTabLayout(@NonNull Context context) {
        super(context);

        init(context, null);
    }

    public TackNewTabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    public TackNewTabLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private Context context;

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
    }

    int dimen_12sp = 12;
    int dimen_13sp = 13;
    int dimen_14sp = 14;

    private TextView[] tab_texts = null;
    private TextView[] num_texts = null;

    public void setupWithMyViewPager(ViewPager viewPager, ArrayList<String> tabs) {
        dimen_12sp = getResources().getDimensionPixelSize(R.dimen.dimen_12sp);
        dimen_13sp = getResources().getDimensionPixelSize(R.dimen.dimen_13sp);
        dimen_14sp = getResources().getDimensionPixelSize(R.dimen.dimen_14sp);

        setupWithViewPager(viewPager);
        int count = getTabCount();
        tab_texts = new TextView[count];
        num_texts = new TextView[count];

        for (int x = 0; x < count; x++) {
            View view1 = View.inflate(context, R.layout.layout_customtab_new_tack_item, null);
            tab_texts[x] = view1.findViewById(R.id.tab_item_text);
            num_texts[x] = view1.findViewById(R.id.rv_num);
            tab_texts[x].setText(tabs.get(x));
            num_texts[x].setVisibility(View.GONE);
            getTabAt(x).setCustomView(view1);

            if(0==x){
                tab_texts[x].setTextSize(TypedValue.COMPLEX_UNIT_PX,dimen_14sp);
                tab_texts[x].setTextColor(Color.parseColor("#303133"));
            }else{
                tab_texts[x].setTextSize(TypedValue.COMPLEX_UNIT_PX,dimen_14sp);
                tab_texts[x].setTextColor(Color.parseColor("#909399"));
            }
        }
//        setSelectText(0);

        addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                if (tab.getCustomView() != null) {
                    TextView text = tab.getCustomView().findViewById(R.id.tab_item_text);
                    text.setTextSize(TypedValue.COMPLEX_UNIT_PX,dimen_14sp);
                    text.setTextColor(Color.parseColor("#303133"));
                }
            }
            @Override
            public void onTabUnselected(Tab tab) {
                if (tab.getCustomView() != null) {
                    TextView text = tab.getCustomView().findViewById(R.id.tab_item_text);
                    text.setTextSize(TypedValue.COMPLEX_UNIT_PX,dimen_14sp);
                    text.setTextColor(Color.parseColor("#909399"));
                }
            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
    }

    private void setSelectText(int index){
        if(tab_texts!=null&&tab_texts.length>0){
            for(int x = 0;x<tab_texts.length;x++){
                if(index==x){
                    tab_texts[x].setTextSize(TypedValue.COMPLEX_UNIT_PX,dimen_13sp);
                    tab_texts[x].setTextColor(getResources().getColor(R.color.text_color_black));
                }else{
                    tab_texts[x].setTextSize(TypedValue.COMPLEX_UNIT_PX,dimen_12sp);
                    tab_texts[x].setTextColor(getResources().getColor(R.color.text_color_grey));
                }
            }
        }
    }


    public void setNum_texts(int index,String taskNum){
        if(num_texts!=null&&num_texts.length>index){
            if(!TextUtils.isEmpty(taskNum)){
                int total = Integer.parseInt(taskNum);
                if(total>0){
                    if(total>99){
                        num_texts[index].setText("99");
                    }else{
                        num_texts[index].setText(taskNum);
                    }
                    num_texts[index].setVisibility(View.VISIBLE);
                    return;
                }
            }
            num_texts[index].setVisibility(View.GONE);
        }
    }
}

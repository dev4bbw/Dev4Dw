package com.example.apublic.base;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apublic.R;
import com.example.apublic.permissionlib.PermissionActivity;
import com.example.apublic.utils.StatusBarUtil;

import java.util.ArrayList;

public abstract class BaseMvpActivity<V, P extends BasePresenter<V>> extends PermissionActivity {
    public P mPresenter;
    private V mView;

    public P getPresenter() {
        return mPresenter;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(getLayoutId());
        initBinding();
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        if (mView == null) {
            mView = createView();
        }
        if (mPresenter != null && mView != null) {
            mPresenter.attachView(mView);
        }

        init();

        StatusBarUtil.setStatusBarColor(this,R.color.black);

    }

//    public abstract int getLayoutId();
    public abstract P createPresenter();
    public abstract V createView();
    public abstract void initBinding();
    public abstract void init();
    /**
     * 获取屏幕分辨率
     *
     * @return int[]
     * disPlays[0] = dm.widthPixels;
     * disPlays[1] = dm.heightPixels;
     */
    ArrayList<Integer> disPlays;

    public ArrayList getDisPlayWidthHeight() {
        if (disPlays == null) {
            disPlays = new ArrayList<Integer>(2);
            DisplayMetrics dm = getResources().getDisplayMetrics();
            disPlays.add(dm.widthPixels);
            disPlays.add(dm.heightPixels);
        }
        return disPlays;
    }
    public void toActivity(Class toClass) {
        toActivity(toClass, null);
    }

    protected void toActivity(Class toClass, Bundle bundle) {
        toActivity(toClass, bundle, -1);
    }

    protected void toActivity(Class toClass, int requestCode) {
        toActivity(toClass, null, requestCode);
    }

    protected void toActivity(Class toClass, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, toClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (requestCode != -1) {
            startActivityForResult(intent, requestCode);
        } else {
            startActivity(intent);
        }
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}

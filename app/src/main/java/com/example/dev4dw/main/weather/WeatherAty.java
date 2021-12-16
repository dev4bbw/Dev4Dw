package com.example.dev4dw.main.weather;

import android.Manifest;
import android.content.Intent;
import android.location.Geocoder;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.example.apublic.base.BaseApp;
import com.example.apublic.base.BaseFragment;
import com.example.apublic.base.BaseFragmentPageAdapter;
import com.example.apublic.base.BaseMvpActivity;
import com.example.apublic.bean.WeatherCity;
import com.example.apublic.customer.SelectCityAty;
import com.example.apublic.utils.GDLocationUtil;
import com.example.apublic.utils.JsonUtils;
import com.example.apublic.utils.L;
import com.example.dev4dw.R;
import com.example.dev4dw.databinding.AtyWeatherBinding;
import com.example.dev4dw.main.home.news.NewsFragment;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.apublic.base.CommonConfig.SELECT_CITY_REQUEST;
import static com.example.apublic.base.CommonConfig.SELECT_CITY_RESULT;

public class WeatherAty extends BaseMvpActivity<WeatherAty, WeatherPresenter> {
    AtyWeatherBinding mBinding;
    ActivityResultLauncher<Intent> launcher;
    List<BaseFragment> fragments = new ArrayList<>();
    List<WeatherCity.ResultBean> cityList = new ArrayList<>();

    @Override
    public WeatherPresenter createPresenter() {
        return new WeatherPresenter();
    }

    @Override
    public WeatherAty createView() {
        return this;
    }

    @Override
    public void initBinding() {
        mBinding = AtyWeatherBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        ButterKnife.bind(this);
    }

    @Override
    public void init() {
        String filePath = BaseApp.getInstance().getFilesDir() + "/city.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            mPresenter.getWeatherCity();
        } else {
            cityList = getCityList();
            if (cityList == null || cityList.size() == 0) {
                mPresenter.getWeatherCity();
            }
        }

        ArrayList<String> tabList = new ArrayList<>();
        tabList.add("天气情况");
        tabList.add("生活指数");

        fragments.add(new ConditionFragment());
        fragments.add(new LifeIndexFragment());
        BaseFragmentPageAdapter vpAdapter =
                new BaseFragmentPageAdapter(getSupportFragmentManager(),
                        tabList, fragments);
        mBinding.vp.setAdapter(vpAdapter);
        mBinding.tabLayout.setupWithMyViewPager(mBinding.vp, tabList);
        mBinding.vp.setOffscreenPageLimit(2);

        initResult();
    }

    private void initResult() {
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                        int resultCode = result.getResultCode();
                        if (resultCode == SELECT_CITY_RESULT){
                            String city = data.getStringExtra("SELECT");

                            mBinding.city.setText(city);

                            int current = mBinding.vp.getCurrentItem();
                            if (current == 0) {
                                ConditionFragment cf = (ConditionFragment) fragments.get(current);
                                cf.setCity(city);
                            } else {
                                LifeIndexFragment lf = (LifeIndexFragment) fragments.get(current);
                                lf.setCity(city);
                            }
                        }
                    }
                });
    }

    @OnClick({R.id.city, R.id.location})
    void onClick(View view) {
        int id = view.getId();
        if (id == R.id.city) {
            Intent intent = new Intent(WeatherAty.this, SelectCityAty.class);
            launcher.launch(intent);
        } else if (id == R.id.location) {
            checkPermission(() -> hasPermission(), R.string.permission_location,
                    Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION);
        }
    }

    private void hasPermission() {
        GDLocationUtil.get(this).setLocationOptions(1000, true, true);
        GDLocationUtil.get(this).setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null && getApplicationContext() != null) {
                    if (aMapLocation.getErrorCode() == 0) {
//                        SP.get().putString(Constant.SP_LON, aMapLocation.getLongitude() + "");
//                        SP.get().putString(Constant.SP_LAT, aMapLocation.getLatitude() + "");
//                        SP.get().putString(Constant.SP_CITY, aMapLocation.getCity());
//                        SP.get().putString(Constant.SP_CITY_CODE, aMapLocation.getCityCode());
//                        SP.get().putString(Constant.SP_ADDRESS, aMapLocation.getAddress());
//                        SP.get().putString(Constant.SP_ADCODE, aMapLocation.getAdCode());
//                        SP.get().putString(Constant.SP_POI_NAME, aMapLocation.getPoiName());
//                        SP.get().putString(Constant.SP_DISTRICT, aMapLocation.getDistrict());
//                        EventBus.getDefault().post(new LocationEvent(aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation.getCity()));
                        String city = aMapLocation.getCity();
                        if (!TextUtils.isEmpty(city)) {
                            for (WeatherCity.ResultBean bean : cityList){
                                if (city.contains(bean.getCity())){
                                    city = bean.getCity();
                                }
                            }
                            mBinding.city.setText(city);
                            GDLocationUtil.get(WeatherAty.this).stopLocation();
                        }
                    } else {
                        //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                        L.e("AmapError", "location Error, ErrCode:" + aMapLocation.getErrorCode() +
                                ", errInfo:" + aMapLocation.getErrorInfo());
                    }
                }
            }
        });
        GDLocationUtil.get(this).startLocation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GDLocationUtil.get(this).destroy();
    }

    public void getCitySuccess(WeatherCity entity) {
        cityList = entity.getResult();
        String filePath = BaseApp.getInstance().getBaseContext().getFilesDir() + "/city.txt";
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            String cityOut = JsonUtils.parseObjectToJson(cityList);
            fos.write(cityOut.getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    private List<WeatherCity.ResultBean> getCityList() {
        List<WeatherCity.ResultBean> list = new ArrayList<>();
        list = (ArrayList<WeatherCity.ResultBean>) JsonUtils.parseJsonToList(readCityJson("city.txt"),
                new TypeToken<List<WeatherCity.ResultBean>>() {
                }.getType());
        return list;
    }

    private String readCityJson(String name) {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            /**
             * 注意这里的fileName不要用绝对路径，只需要文件名就可以了，系统会自动到data目录下去加载这个文件
             */
            fileInputStream = BaseApp.getInstance().getBaseContext().openFileInput(name);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String result = "";
            while ((result = bufferedReader.readLine()) != null) {
                stringBuilder.append(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

}

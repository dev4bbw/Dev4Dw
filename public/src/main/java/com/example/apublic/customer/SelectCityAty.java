package com.example.apublic.customer;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.baozi.treerecyclerview.adpater.TreeRecyclerAdapter;
import com.baozi.treerecyclerview.adpater.TreeRecyclerType;
import com.baozi.treerecyclerview.base.BaseRecyclerAdapter;
import com.baozi.treerecyclerview.base.ViewHolder;
import com.baozi.treerecyclerview.factory.ItemHelperFactory;
import com.baozi.treerecyclerview.item.TreeItem;
import com.example.apublic.base.BaseApp;
import com.example.apublic.base.BaseMvpActivity;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.bean.CommonCityBean;
import com.example.apublic.bean.WeatherCity;
import com.example.apublic.databinding.AtySelectCityBinding;
import com.example.apublic.utils.DisplayUtil;
import com.example.apublic.utils.JsonUtils;
import com.example.apublic.utils.ToastUtil;
import com.example.apublic.utils.recyclerview.SpaceItemDecoration;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.example.apublic.base.CommonConfig.SELECT_CITY_RESULT;
import static com.example.apublic.base.CommonConfig.SELECT_DISTRICT_RESULT;
import static com.example.apublic.base.CommonConfig.SELECT_PROVINCE_RESULT;

public class SelectCityAty extends BaseMvpActivity {
    AtySelectCityBinding mBinding;
    List<CommonCityBean> dataList = new ArrayList<>();
    SelectCityAdapter adapter;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public Object createView() {
        return null;
    }

    @Override
    public void initBinding() {
        mBinding = AtySelectCityBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    @Override
    public void init() {
        Intent intent = getIntent();
        List<WeatherCity.ResultBean> cityList = (List<WeatherCity.ResultBean>) intent.getSerializableExtra("CITY_LIST");
        if (cityList == null) {
            String filePath = BaseApp.getInstance().getFilesDir() + "/city.txt";
            File file = new File(filePath);
            if (file.exists()) {
                cityList = getCityList();
            }
        }
//        dataList = formatWeatherList(cityList);
        dataList = formatWeatherList(cityList);

        initRv();
    }

    private void initRv() {
        List<TreeItem> items = ItemHelperFactory.createItems(dataList, ProvinceItem.class);


        mBinding.rv.setLayoutManager(new GridLayoutManager(this, 6));
        mBinding.rv.addItemDecoration(new SpaceItemDecoration(DisplayUtil.dp2px(this, 10)));
        TreeRecyclerAdapter treeRecyclerAdapter = new TreeRecyclerAdapter(TreeRecyclerType.SHOW_EXPAND);
        treeRecyclerAdapter.getItemManager().replaceAllItem(items);
        treeRecyclerAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(@NotNull ViewHolder viewHolder, int position) {
//                Intent intent = new Intent();
//                intent.putExtra("SELECT",city);
//                setResult(SELECT_CITY_RESULT,intent);
//                finish();
//                ToastUtil.showToast(SelectCityAty.this,"SELECT");
                //因为外部和内部会冲突
                TreeItem item = treeRecyclerAdapter.getData(position);
                if (item == null || item.getData() == null) {
                    return;
                }
                if (item instanceof DistrictItem) {
                    CommonCityBean.CityBean.DistrictBean bean = (CommonCityBean.CityBean.DistrictBean) item.getData();
//                    ToastUtil.get().showToast(SelectCityAty.this, bean.getDistrictName());
                    Intent intent = new Intent();
                    intent.putExtra("SELECT", bean.getDistrictName());
                    setResult(SELECT_CITY_RESULT, intent);
                    finish();
                }
                item.onClick(viewHolder);
            }
        });

//        adapter = new SelectCityAdapter(this,dataList);
        mBinding.rv.setAdapter(treeRecyclerAdapter);
//        adapter.setClickListener(new SelectCityAdapter.OnCityClickListener() {
//            @Override
//            public void clickCity(String city) {
//                Intent intent = new Intent();
//                intent.putExtra("SELECT",city);
//                setResult(SELECT_CITY_RESULT,intent);
//                finish();
//            }
//        });
    }

    private List<CommonCityBean> formatWeatherList(List<WeatherCity.ResultBean> cityList) {
        List<CommonCityBean> list = new ArrayList<>();
        for (WeatherCity.ResultBean bean : cityList) {
            boolean sameProvince = false;
            for (CommonCityBean cb : list) {
                if (cb.getProvinceName().equals(bean.getProvince())) {
                    sameProvince = true;
                    boolean sameCity = false;
                    for (CommonCityBean.CityBean ctb : cb.getCity()) {
                        if (ctb.getCityName().equals(bean.getCity())) {
                            sameCity = true;

                            CommonCityBean.CityBean.DistrictBean db = new CommonCityBean.CityBean.DistrictBean();
                            db.setDistrictName(bean.getDistrict());
                            if (ctb.getDistrict() == null) {
                                continue;
                            } else {
                                ctb.getDistrict().add(db);
                            }
                        }
                    }
                    if (sameCity) {
                        continue;
                    }
                    CommonCityBean.CityBean newCtb = new CommonCityBean.CityBean();
                    newCtb.setCityName(bean.getCity());
                    List<CommonCityBean.CityBean.DistrictBean> newDistrict = new ArrayList<>();
                    CommonCityBean.CityBean.DistrictBean districtBean = new CommonCityBean.CityBean.DistrictBean();
                    districtBean.setDistrictName(bean.getDistrict());
                    newDistrict.add(districtBean);
                    newCtb.setDistrict(newDistrict);
                    cb.getCity().add(newCtb);
                }
            }
            if (sameProvince) {
                continue;
            }
            CommonCityBean resultBean = new CommonCityBean();
            List<CommonCityBean.CityBean> cityBeanList = new ArrayList<>();
            CommonCityBean.CityBean cityBean = new CommonCityBean.CityBean();
            List<CommonCityBean.CityBean.DistrictBean> districtBeanList = new ArrayList<>();
            CommonCityBean.CityBean.DistrictBean districtBean = new CommonCityBean.CityBean.DistrictBean();
            districtBean.setDistrictName(bean.getDistrict());
            districtBeanList.add(districtBean);
            cityBean.setDistrict(districtBeanList);
            cityBean.setCityName(bean.getCity());
            cityBeanList.add(cityBean);
            resultBean.setCity(cityBeanList);
            resultBean.setProvinceName(bean.getProvince());
            list.add(resultBean);
        }
        return list;
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

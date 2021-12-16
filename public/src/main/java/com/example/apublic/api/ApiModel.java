package com.example.apublic.api;

import com.example.apublic.base.BaseModel;
import com.example.apublic.base.Config;
import com.example.apublic.bean.ConditionBean;
import com.example.apublic.bean.VideoBean;
import com.example.apublic.bean.WeatherCity;
import com.example.apublic.bean.home.NewsBean;


import okhttp3.MultipartBody;
import rx.Observable;

public class ApiModel extends BaseModel<ApiService,ApiModel> {

    volatile private static ApiModel apiModel;

    public ApiModel(String url) {
        super(url);
    }

    @Override
    protected Class<ApiService> getServiceClass() {
        return ApiService.class;
    }

    public static ApiModel getInstance() {
        if (apiModel == null) {
            synchronized (ApiModel.class) {
                if (apiModel == null) {
                    apiModel = new ApiModel(Config.BASE_V_URL);
                }
            }
        }
        return apiModel;
    }

    /**
     *获取新闻
     * @param type 支持类型top(推荐,默认)guonei(国内)guoji(国际)yule(娱乐)tiyu(体育)junshi(军事)keji(科技)
     *             caijing(财经)shishang(时尚)youxi(游戏)qiche(汽车)jiankang(健康)
     * @param page 当前页数, 默认1, 最大50
     * @return
     */
    public Observable<NewsBean> getNews(String type, String page){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("key", Config.JUHE_NEWS_KEY);
        builder.addFormDataPart("type", type);
        builder.addFormDataPart("page", page);
        builder.addFormDataPart("page_size", "30");  //每页返回条数, 默认30 , 最大30
        builder.addFormDataPart("is_filter","0"); //是否只返回有内容详情的新闻, 1:是, 默认0
        return getService().loadNews(builder.build());
    }


    /**
     *获取视频
     * @return
     */
    public Observable<VideoBean> getVideo(){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("key", Config.JUHE_VIDEO_KEY);
        builder.addFormDataPart("type", "amusement_overall");
        builder.addFormDataPart("size", "30");  //每页返回条数, 默认30 , 最大30
        builder.addFormDataPart("offset",""); //偏移量, 如:2 表示从第二条开始取size条数;
        return getService().loadVideo(builder.build());
    }

    /**
     *获取天气
     * @return
     */
    public Observable<ConditionBean> getWeather(String city){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("key", Config.JUHE_WEATHER_KEY);
        builder.addFormDataPart("city", city);
        return getService().getWeather(builder.build());
    }

    /**
     *获取支持城市
     * @return
     */
    public Observable<WeatherCity> getWeatherCity(){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("key", Config.JUHE_WEATHER_KEY);
        return getService().getWeatherCity(builder.build());
    }
}

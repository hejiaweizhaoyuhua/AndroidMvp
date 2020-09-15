package com.gut.baonews.net;

import com.gut.baonews.net.interceptor.HttpCommonInterceptor;
import com.gut.baonews.net.interceptor.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceManager {
    private static final String BASE_URL = "http://gank.io/api/data/福利/";

    private static final int DEFAULT_TIME_OUT = 10;
    private static final int DEFAULT_READ_TIME_OUT = 30;
    private Retrofit retrofit;

    private static class SingletonHolder {
        private static final RetrofitServiceManager instance = new RetrofitServiceManager();
    }

    public static RetrofitServiceManager getInstance() {
        return SingletonHolder.instance;
    }

    private RetrofitServiceManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);
        // 初始化拦截器
        HttpCommonInterceptor commonInterceptor = new HttpCommonInterceptor.Builder()
//                .addHeader("id", "123")
                .build();
        LoggerInterceptor loggerInterceptor = new LoggerInterceptor();
        // 添加拦截器
        builder.addInterceptor(commonInterceptor)
            .addInterceptor(loggerInterceptor);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }
}

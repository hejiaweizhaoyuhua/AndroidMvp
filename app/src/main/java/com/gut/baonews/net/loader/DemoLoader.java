package com.gut.baonews.net.loader;

import com.gut.baonews.net.RetrofitServiceManager;
import com.gut.baonews.net.response.DemoResp;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public class DemoLoader extends ObjectLoader {
    private DemoService demoService;

    public DemoLoader() {
        demoService = RetrofitServiceManager.getInstance().create(DemoService.class);
    }

    public Observable<List<DemoResp.GankEntity>> getGankList() {
        return observe(demoService.getGank())
                .map(DemoResp::getResults);
    }

    public interface DemoService {
        @GET("50/1")
        Observable<DemoResp> getGank();

//        @GET("top250")
//        Observable<MovieSubject> getTop250(@Query("start") int start, @Query("count")int count);

//        @FormUrlEncoded
//        @POST("/x3/weather")
//        Call<String> getWeather(@Field("cityId") String cityId, @Field("key") String key);
    }
}

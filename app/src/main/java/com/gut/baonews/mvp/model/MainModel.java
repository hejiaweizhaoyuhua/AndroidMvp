package com.gut.baonews.mvp.model;

import android.util.Log;

import com.gut.baonews.mvp.contract.MainContract;
import com.gut.baonews.net.loader.DemoLoader;
import com.gut.baonews.net.response.DemoResp;
import com.gut.baonews.util.LogUtil;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainModel implements MainContract.Model {
    private final String tag = this.getClass().getSimpleName();

    @Override
    public void getData() {
        Log.i(tag, "getData!!!");
        DemoLoader loader = new DemoLoader();
        loader.getGankList().subscribe(new Observer<List<DemoResp.GankEntity>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                LogUtil.i(tag, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull List<DemoResp.GankEntity> gankEntities) {
                LogUtil.i(tag, "onNext");
                LogUtil.i(tag, "onNext ---> gankEntities=" + gankEntities.size());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LogUtil.i(tag, "onError");
            }

            @Override
            public void onComplete() {
                LogUtil.i(tag, "onComplete");
            }
        });
    }
}

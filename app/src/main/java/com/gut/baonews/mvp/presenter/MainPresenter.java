package com.gut.baonews.mvp.presenter;

import android.util.Log;

import com.gut.baonews.mvp.contract.MainContract;
import com.gut.baonews.mvp.model.MainModel;
import com.gut.baonews.mvp.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    private final String tag = this.getClass().getSimpleName();

    private MainModel model;

    public MainPresenter() {
        model = new MainModel();
    }

    @Override
    public void handleData() {
        Log.i(tag, "handleData!!!");

        model.getData();
        mView.showData();
    }
}

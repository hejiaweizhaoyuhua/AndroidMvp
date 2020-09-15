package com.gut.baonews.mvp.view.activity;

import android.os.Bundle;
import android.util.Log;

import com.gut.baonews.R;
import com.gut.baonews.mvp.contract.MainContract;
import com.gut.baonews.mvp.presenter.MainPresenter;
import com.gut.baonews.mvp.base.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {
    private final String tag = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showData() {
        Log.i(tag, "showData!!!");
    }

    @Override
    public void attachPresenter() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void handleLogic() {
        mPresenter.handleData();
    }

    @Override
    public void initData() {

    }
}
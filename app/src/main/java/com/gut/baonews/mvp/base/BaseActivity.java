package com.gut.baonews.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle3.LifecycleTransformer;
import com.trello.rxlifecycle3.android.ActivityEvent;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

public abstract class BaseActivity extends RxAppCompatActivity implements IBaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        beforeInitView();
        initView();
        initData();
        handleLogic();
    }

    /**
     * 绑定生命周期 防止MVP、Rxjava内存泄漏
     */
    @Override
    public LifecycleTransformer<Long> rxLifeCycle() {
        return this.<Long>bindUntilEvent(ActivityEvent.DESTROY);
    }
}

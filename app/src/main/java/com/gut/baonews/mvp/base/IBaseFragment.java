package com.gut.baonews.mvp.base;

import android.view.View;

import com.trello.rxlifecycle3.LifecycleTransformer;

public interface IBaseFragment {
    void beforeInitView();
    void initView(View view);
    int getLayoutId();
    void handleLogic();
    void initData();

    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     */
    LifecycleTransformer<Long> rxLifeCycle();
}

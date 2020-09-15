package com.gut.baonews.mvp.base;


import com.trello.rxlifecycle3.LifecycleTransformer;

public interface IBaseActivity {
    void beforeInitView();
    void initView();
    int getLayoutId();
    void handleLogic();
    void initData();

    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     */
    LifecycleTransformer<Long> rxLifeCycle();
}

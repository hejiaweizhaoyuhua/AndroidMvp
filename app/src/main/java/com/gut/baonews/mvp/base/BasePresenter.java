package com.gut.baonews.mvp.base;

import com.gut.baonews.mvp.base.BaseView;

public class BasePresenter<T extends BaseView> {
    protected T mView;

    public void attachView(T view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }

    public boolean isAttachView() {
        return mView != null;
    }
}

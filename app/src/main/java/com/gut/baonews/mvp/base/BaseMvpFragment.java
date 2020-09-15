package com.gut.baonews.mvp.base;

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements IBaseMvpFragment{
    protected T mPresenter;

    @Override
    public void beforeInitView() {
        // 关联presenter
        attachPresenter();
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}

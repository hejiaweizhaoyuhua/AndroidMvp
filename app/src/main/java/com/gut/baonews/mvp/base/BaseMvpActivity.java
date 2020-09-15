package com.gut.baonews.mvp.base;

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements IBaseMvpActivity{
    protected T mPresenter;

    @Override
    public void beforeInitView() {
        // 关联presenter
        attachPresenter();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }

        super.onDestroy();
    }
}

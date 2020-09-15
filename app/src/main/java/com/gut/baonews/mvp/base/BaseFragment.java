package com.gut.baonews.mvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle3.LifecycleTransformer;
import com.trello.rxlifecycle3.android.FragmentEvent;
import com.trello.rxlifecycle3.components.support.RxFragment;

public abstract class BaseFragment extends RxFragment implements IBaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        beforeInitView();

        View view = inflater.inflate(getLayoutId(), null);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        handleLogic();
    }

    /**
     * 绑定生命周期 防止MVP、Rxjava内存泄漏
     */
    @Override
    public LifecycleTransformer<Long> rxLifeCycle() {
        return this.<Long>bindUntilEvent(FragmentEvent.DESTROY);
    }
}

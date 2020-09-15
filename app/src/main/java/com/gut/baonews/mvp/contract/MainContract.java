package com.gut.baonews.mvp.contract;

import com.gut.baonews.mvp.base.BaseView;

public interface MainContract {
    interface Model {
        void getData();
    }

    interface View extends BaseView {
        void showData();
    }

    interface Presenter {
        void handleData();
    }
}

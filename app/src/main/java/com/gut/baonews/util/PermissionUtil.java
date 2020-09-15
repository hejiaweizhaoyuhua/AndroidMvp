package com.gut.baonews.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.tbruyelle.rxpermissions3.RxPermissions;

public class PermissionUtil {
    public static void requestPermission(FragmentActivity activity, String... permissions) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        request(rxPermissions, activity, permissions);
    }

    public static void requestPermission(Fragment fragment, String... permissions) {
        RxPermissions rxPermissions = new RxPermissions(fragment);
        request(rxPermissions, fragment.getActivity(), permissions);
    }

    private static void request(RxPermissions rxPermissions, FragmentActivity activity, String... permissions) {
        rxPermissions.requestEach(permissions)
                .subscribe(permission -> { // will emit 2 Permission objects
                    if (permission.granted) {
                        // 授权成功
                    } else if (permission.shouldShowRequestPermissionRationale) {
                        // 拒绝授权，但是没有点击不再提示
                    } else {
                        // 拒绝授权，并点击了不再询问，需要跳到设置页面去打开权限
//                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
//                        intent.setData(uri);
//                        startActivityForResult(intent ,0);
                    }
                });
    }
}

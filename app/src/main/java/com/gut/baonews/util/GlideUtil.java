package com.gut.baonews.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtil {
    public static void load(Context context, ImageView imageView, String url) {
        Glide.with(context).load(url).into(imageView);
    }

    public static void load(Context context, ImageView imageView, int resId) {
        Glide.with(context).load(resId).into(imageView);
    }
}

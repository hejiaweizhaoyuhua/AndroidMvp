package com.gut.baonews.net.interceptor;

import com.gut.baonews.util.LogUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpCommonInterceptor implements Interceptor {
    private Map<String, String> mHeaderParamsMap = new HashMap<>();

    @Override
    public Response intercept(Chain chain) throws IOException {
        LogUtil.i("HttpCommonInterceptor","add common params");
        Request oldRequest = chain.request();
        Request.Builder requestBuilder = oldRequest.newBuilder();
        requestBuilder.method(oldRequest.method(), oldRequest.body());
        // 添加公共参数
        if (mHeaderParamsMap.size() > 0) {
            for (Map.Entry<String, String> params : mHeaderParamsMap.entrySet()) {
                requestBuilder.header(params.getKey(), params.getValue());
            }
        }

        Request newRequest = requestBuilder.build();
        return chain.proceed(newRequest);
    }

    public static class Builder {
        private HttpCommonInterceptor intercept;
        public Builder() {
            intercept = new HttpCommonInterceptor();
        }

        public HttpCommonInterceptor build() {
            return intercept;
        }

        public Builder addHeader(String key, String value) {
            intercept.mHeaderParamsMap.put(key, value);
            return this;
        }
    }
}

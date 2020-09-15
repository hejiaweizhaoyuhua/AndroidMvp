package com.gut.baonews.net.interceptor;

import com.gut.baonews.util.LogUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LoggerInterceptor implements Interceptor {
    private final String tag = this.getClass().getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Response response = chain.proceed(request);
        ResponseBody body = response.peekBody(1024 * 1024);
        LogUtil.i(tag, "request-->url=" + request.url());
        LogUtil.i(tag, "respone-->res=" + body.string());

        return response;
    }
}

package custom.sunday.zbautotrade.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author apple
 * @decrption
 * @data 2019-05-23
 **/
public class OKHttpHelper {

    private OkHttpClient mOkHttpClient;
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36";
    private OKHttpHelper(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .readTimeout(3000,TimeUnit.MILLISECONDS)
                .writeTimeout(3000,TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .removeHeader("User-Agent")//移除旧的
                                .addHeader("User-Agent", USER_AGENT)//添加真正的头部
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

    }

    public static OKHttpHelper getInstance(){
        return Holder.Instance;
    }

    private static final class Holder{
        private static final OKHttpHelper Instance = new OKHttpHelper();
    }


    public OkHttpClient getOkHttpClient(){
        return mOkHttpClient;
    }


}

package yanzhixiong20170108.week3.utils;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public class RetrofitManager {

    private static final String URL="http://120.27.23.105/";

   private static Retrofit mRetrofit;

    public static class Shop_Holder{
        public static final RetrofitManager instance=new RetrofitManager(URL);
    }

    public RetrofitManager(String url) {
        mRetrofit=buildRetrofit();
    }

    public static RetrofitManager getinstance() {
        return Shop_Holder.instance;
    }

    //OkHttpClient
    private OkHttpClient buildOkHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .build();
    }

    //Retrofit
    private Retrofit buildRetrofit(){
        return new Retrofit.Builder()
                .client(buildOkHttpClient())
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public <T> T create(Class<T> tClass){
        return mRetrofit.create(tClass);
    }
}

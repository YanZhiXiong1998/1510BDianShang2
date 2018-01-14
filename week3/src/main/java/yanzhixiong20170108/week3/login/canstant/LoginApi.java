package yanzhixiong20170108.week3.login.canstant;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import yanzhixiong20170108.week3.login.model.bean.Login_Bean;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public interface LoginApi {

    @GET("user/login")
    Observable<Login_Bean> login(@QueryMap Map<String,String> map );
}

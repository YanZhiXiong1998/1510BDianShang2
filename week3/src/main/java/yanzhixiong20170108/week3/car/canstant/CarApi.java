package yanzhixiong20170108.week3.car.canstant;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import yanzhixiong20170108.week3.car.bean.CarBean;

/**
 * author:Created by YanZhiXiong on 2018/1/9.
 */

public interface CarApi {

    @GET("product/getCarts")
    Observable<CarBean> seleteCar(@QueryMap Map<String, String> map);
}

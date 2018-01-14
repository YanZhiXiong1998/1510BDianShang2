package yanzhixiong20170108.week3.shop.shopxq.canstant;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import yanzhixiong20170108.week3.shop.model.bean.TJShopBean;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public interface TJApi {

    @GET("product/addCart")
    Observable<TJShopBean> tjshop(@QueryMap Map<String,String> map);
}

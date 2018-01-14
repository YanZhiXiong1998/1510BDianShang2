package yanzhixiong20170108.week3.shop.canstant;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import yanzhixiong20170108.week3.shop.model.bean.ShopBean;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public interface ShopApi {

    @GET("product/getProducts")
    Observable<ShopBean> shop(@Query("pscid") String pscid);
}

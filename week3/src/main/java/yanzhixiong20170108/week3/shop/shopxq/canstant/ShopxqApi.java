package yanzhixiong20170108.week3.shop.shopxq.canstant;

import io.reactivex.Observable;
import retrofit2.http.GET;
import yanzhixiong20170108.week3.shop.shopxq.model.bean.ShopXQBean;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public interface ShopxqApi {

        @GET ("product/getProductDetail?pid=1&source=android")
        Observable<ShopXQBean> shopxq();
}

package yanzhixiong20170108.week3.shop.shopxq.model;

import io.reactivex.Observable;
import yanzhixiong20170108.week3.shop.shopxq.canstant.ShopxqApi;
import yanzhixiong20170108.week3.shop.shopxq.model.bean.ShopXQBean;
import yanzhixiong20170108.week3.utils.RetrofitManager;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public class ShopXQModel {

    public Observable<ShopXQBean> shopxq(){
        ShopxqApi shopxqApi = RetrofitManager.getinstance().create(ShopxqApi.class);
        return shopxqApi.shopxq();
    }
}

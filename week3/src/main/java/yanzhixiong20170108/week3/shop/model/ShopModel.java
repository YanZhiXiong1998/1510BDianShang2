package yanzhixiong20170108.week3.shop.model;

import io.reactivex.Observable;
import yanzhixiong20170108.week3.shop.canstant.ShopApi;
import yanzhixiong20170108.week3.shop.model.bean.ShopBean;
import yanzhixiong20170108.week3.utils.RetrofitManager;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public class ShopModel implements SPModel{

    public Observable<ShopBean> shop(){
        ShopApi shopApi = RetrofitManager.getinstance().create(ShopApi.class);
        return shopApi.shop("40");
    }
}

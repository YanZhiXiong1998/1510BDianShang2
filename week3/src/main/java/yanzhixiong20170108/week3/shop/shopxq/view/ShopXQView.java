package yanzhixiong20170108.week3.shop.shopxq.view;

import yanzhixiong20170108.week3.shop.shopxq.model.bean.ShopXQBean;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public interface ShopXQView extends XQView{

    void ShopXQSuccess(ShopXQBean shopXQBean);
    void ShopXQFaild(Throwable throwable);
}

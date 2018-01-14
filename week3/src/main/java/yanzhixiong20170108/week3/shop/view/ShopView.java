package yanzhixiong20170108.week3.shop.view;

import yanzhixiong20170108.week3.shop.model.bean.ShopBean;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public interface ShopView extends SPView {
    void ShopSuccess(ShopBean shopBean);
    void ShopFaild(Throwable throwable);
}

package yanzhixiong20170108.week3.shop.shopxq.presenter;

import yanzhixiong20170108.week3.shop.shopxq.view.XQView;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public abstract class SPXQPrensenter <T extends XQView>{

    protected T view;

    public SPXQPrensenter(T view) {
        this.view = view;
        init();
    }

    protected abstract void init();
}

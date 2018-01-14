package yanzhixiong20170108.week3.shop.presenter;

import yanzhixiong20170108.week3.shop.view.SPView;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public abstract class SPPresenter <T extends SPView>{
    protected T view;

    public SPPresenter(T view) {
        this.view = view;
        inti();
    }

    protected abstract void inti();
}

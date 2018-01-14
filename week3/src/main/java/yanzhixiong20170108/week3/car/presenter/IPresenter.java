package yanzhixiong20170108.week3.car.presenter;


import yanzhixiong20170108.week3.login.view.IView;

/**
 * author:Created by YanZhiXiong on 2018/1/9.
 */

public abstract  class IPresenter<T extends IView> {
    protected  T view;

    public IPresenter(T view) {
        this.view = view;
        inti();
    }

    protected abstract void inti();
}

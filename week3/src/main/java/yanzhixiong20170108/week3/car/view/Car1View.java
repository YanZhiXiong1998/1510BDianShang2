package yanzhixiong20170108.week3.car.view;


import yanzhixiong20170108.week3.car.bean.CarBean;
import yanzhixiong20170108.week3.login.view.IView;

/**
 * author:Created by YanZhiXiong on 2018/1/9.
 */

public interface Car1View extends Car2View, IView {
    void CarSuccess(CarBean carBean);
    void CarFaild(Throwable throwable);
    int getuid();
}

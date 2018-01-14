package yanzhixiong20170108.week3.car.model;


import java.util.Map;

import io.reactivex.Observable;
import yanzhixiong20170108.week3.car.bean.CarBean;
import yanzhixiong20170108.week3.car.canstant.CarApi;
import yanzhixiong20170108.week3.utils.RetrofitManager;

/**
 * author:Created by YanZhiXiong on 2018/1/9.
 */

public class CarModel implements IModel{
    public Observable<CarBean> selectCar(Map<String,String> map){
        CarApi carApi = RetrofitManager.getinstance().create(CarApi.class);

        return carApi.seleteCar(map);
    }
}

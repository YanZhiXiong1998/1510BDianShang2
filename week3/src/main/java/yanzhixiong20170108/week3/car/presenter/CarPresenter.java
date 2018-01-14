package yanzhixiong20170108.week3.car.presenter;


import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import yanzhixiong20170108.week3.car.bean.CarBean;
import yanzhixiong20170108.week3.car.model.CarModel;
import yanzhixiong20170108.week3.car.view.Car1View;

/**
 * author:Created by YanZhiXiong on 2018/1/9.
 */

public class CarPresenter extends IPresenter<Car1View>{

    private CarModel carModel;

    public CarPresenter(Car1View view) {
        super(view);
    }

    @Override
    protected void inti() {
        carModel=new CarModel();
    }
    //查询购物车
    public  void selectCar(){
        Map<String,String> map=new HashMap<>();
        int getuid = view.getuid();
        map.put("uid",getuid+"");
        map.put("source","android");
        Observable<CarBean> selectcar=carModel.selectCar(map);
        selectcar.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CarBean>() {
                               @Override
                               public void accept(CarBean carBean) throws Exception {
                                   view.CarSuccess(carBean);
                               }
                           }
                        , new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                view.CarFaild(throwable);
                            }
                        }
                );
    }
}

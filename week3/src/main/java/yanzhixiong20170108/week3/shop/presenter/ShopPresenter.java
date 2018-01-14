package yanzhixiong20170108.week3.shop.presenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import yanzhixiong20170108.week3.shop.model.ShopModel;
import yanzhixiong20170108.week3.shop.model.bean.ShopBean;
import yanzhixiong20170108.week3.shop.view.ShopView;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public class ShopPresenter extends SPPresenter<ShopView>{
    private ShopModel shopModel;
    public ShopPresenter(ShopView view) {
        super(view);
    }

    @Override
    protected void inti() {
        shopModel=new ShopModel();
    }


    //商品列表

    public void shop(){
        Observable<ShopBean> shop = shopModel.shop();

        shop.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopBean>() {
                               @Override
                               public void accept(ShopBean shopBean) throws Exception {
                                   view.ShopSuccess(shopBean);
                               }
                           }
                        , new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                view.ShopFaild(throwable);
                            }
                        }
                );
    }
}

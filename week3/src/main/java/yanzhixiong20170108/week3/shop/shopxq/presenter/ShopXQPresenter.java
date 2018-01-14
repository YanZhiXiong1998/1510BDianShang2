package yanzhixiong20170108.week3.shop.shopxq.presenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import yanzhixiong20170108.week3.shop.shopxq.model.ShopXQModel;
import yanzhixiong20170108.week3.shop.shopxq.model.bean.ShopXQBean;
import yanzhixiong20170108.week3.shop.shopxq.view.ShopXQView;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public class ShopXQPresenter extends SPXQPrensenter<ShopXQView>{

    private ShopXQModel shopXQModel;

    public ShopXQPresenter(ShopXQView view) {
        super(view);
    }

    @Override
    protected void init() {
        shopXQModel=new ShopXQModel();
    }
    //商品详情
    public void  shopxq(){
        Observable<ShopXQBean> shopxq = shopXQModel.shopxq();
        shopxq.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopXQBean>() {
                               @Override
                               public void accept(ShopXQBean shopXQBean) throws Exception {
                                   view.ShopXQSuccess(shopXQBean);
                               }
                           }
                        , new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                view.ShopXQFaild(throwable);
                            }
                        }
                );
    }
}

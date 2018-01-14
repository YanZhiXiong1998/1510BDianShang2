package yanzhixiong20170108.week3.shop.shopxq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import yanzhixiong20170108.week3.R;
import yanzhixiong20170108.week3.car.Caractivity;
import yanzhixiong20170108.week3.shop.model.bean.TJShopBean;
import yanzhixiong20170108.week3.shop.shopxq.adapter.ShopXQAdapter;
import yanzhixiong20170108.week3.shop.shopxq.canstant.TJApi;
import yanzhixiong20170108.week3.shop.shopxq.model.bean.ShopXQBean;
import yanzhixiong20170108.week3.shop.shopxq.presenter.ShopXQPresenter;
import yanzhixiong20170108.week3.shop.shopxq.view.ShopXQView;
import yanzhixiong20170108.week3.utils.RetrofitManager;

public class ShopXQActivity extends AppCompatActivity implements ShopXQView  {

    @InjectView(R.id.shopxq_rlv)
    RecyclerView shopxqRlv;
    @InjectView(R.id.btn_jiaru)
    Button btnJiaru;
    @InjectView(R.id.btn_goumai)
    Button btnGoumai;
    private ShopXQPresenter shopXQPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_xq);
        ButterKnife.inject(this);
        shopxqRlv.setLayoutManager(new LinearLayoutManager(this));
        shopXQPresenter = new ShopXQPresenter(this);
        shopXQPresenter.shopxq();
    }

    @Override
    public void ShopXQSuccess(ShopXQBean shopXQBean) {
        ShopXQAdapter shopXQAdapter = new ShopXQAdapter(this, shopXQBean);
        shopxqRlv.setAdapter(shopXQAdapter);
    }

    @Override
    public void ShopXQFaild(Throwable throwable) {

    }

    @OnClick({R.id.btn_jiaru, R.id.btn_goumai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_jiaru:
                Map<String,String> map=new HashMap<>();
                map.put("uid","1600");
                map.put("pid","2");
                map.put("source","android");
                TJApi tjApi = RetrofitManager.getinstance().create(TJApi.class);
                Observable<TJShopBean> tjshop = tjApi.tjshop(map);
                tjshop.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<TJShopBean>() {
                            @Override
                            public void accept(TJShopBean tjShopBean) throws Exception {
                                Toast.makeText(ShopXQActivity.this,tjShopBean.getMsg(),Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            case R.id.btn_goumai:
                Intent intent=new Intent(ShopXQActivity.this,Caractivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }


}

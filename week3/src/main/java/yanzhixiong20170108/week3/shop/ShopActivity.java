package yanzhixiong20170108.week3.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import yanzhixiong20170108.week3.R;
import yanzhixiong20170108.week3.shop.adapter.ShopAdapter;
import yanzhixiong20170108.week3.shop.model.bean.ShopBean;
import yanzhixiong20170108.week3.shop.presenter.ShopPresenter;
import yanzhixiong20170108.week3.shop.shopxq.ShopXQActivity;
import yanzhixiong20170108.week3.shop.view.ShopView;

public class ShopActivity extends AppCompatActivity implements ShopView {

    @InjectView(R.id.rlv_shop)
    RecyclerView rlvShop;
    private ShopPresenter shopPresenter;
    private ShopAdapter shopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.inject(this);

        shopPresenter = new ShopPresenter(this);
        shopPresenter.shop();
        rlvShop.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void ShopSuccess(ShopBean shopBean) {
        List<ShopBean.DataBean> data = shopBean.getData();
        shopAdapter = new ShopAdapter(ShopActivity.this, data);

        shopAdapter.setShopAdapter(new ShopAdapter.OnShopClick() {
            @Override
            public void OnShopClick(View view, int position) {

                Intent intent=new Intent(ShopActivity.this,ShopXQActivity.class);
                startActivity(intent);
                finish();
            }
        });

        rlvShop.setAdapter(shopAdapter);
    }

    @Override
    public void ShopFaild(Throwable throwable) {

    }
}

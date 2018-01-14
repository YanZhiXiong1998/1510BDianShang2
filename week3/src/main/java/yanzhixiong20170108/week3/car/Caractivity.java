package yanzhixiong20170108.week3.car;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import yanzhixiong20170108.week3.R;
import yanzhixiong20170108.week3.car.adapter.CarAdapter;
import yanzhixiong20170108.week3.car.bean.CarBean;
import yanzhixiong20170108.week3.car.bean.GoodsBean;
import yanzhixiong20170108.week3.car.bean.GroupBean;
import yanzhixiong20170108.week3.car.presenter.CarPresenter;
import yanzhixiong20170108.week3.car.view.Car1View;

public class Caractivity extends AppCompatActivity implements Car1View{
    View inflate;
    @InjectView(R.id.tv_bianji)
    TextView tvBianji;
    @InjectView(R.id.exlist)
    ExpandableListView exlist;
    @InjectView(R.id.check_all)
    public CheckBox checkAll;
    @InjectView(R.id.tv_zjprice)
    TextView price;
    TextView tvZjprice;
    @InjectView(R.id.tv_count)
    TextView counts;
    TextView tvCount;
    @InjectView(R.id.btn_js)
    Button btnJs;
    private CarPresenter carPresenter;

    private boolean flagedit = true;
    ArrayList<GroupBean> groupBeen = new ArrayList<>();
    ArrayList<ArrayList<GoodsBean>> goods = new ArrayList<>();
    private CarAdapter carAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caractivity);
        ButterKnife.inject(this);
        carPresenter = new CarPresenter(this);
        carPresenter.selectCar();
        carAdapter = new CarAdapter(Caractivity.this, groupBeen, goods, this);
        exlist.setAdapter(carAdapter);
        for (int i = 0; i < carAdapter.getGroupCount(); i++) {
            exlist.expandGroup(i);
        }
        carAdapter.notifyDataSetChanged();
    }
    @OnClick({R.id.tv_bianji, R.id.check_all, R.id.btn_js})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_bianji:
                String trim = tvBianji.getText().toString().trim();
                if (trim.equals("编辑")) {
                    tvBianji.setText("完成");
                } else {
                    tvBianji.setText("编辑");
                }
                for (List<GoodsBean> i1 : goods) {
                    for (int r = 0; r < i1.size(); r++) {
                        i1.get(r).setBtn(flagedit);
                    }
                }
                flagedit = !flagedit;
                carAdapter.notifyDataSetChanged();
                break;
            case R.id.check_all:
                boolean checked = checkAll.isChecked();
                for (int i = 0; i < groupBeen.size(); i++) {
                    groupBeen.get(i).setGroupcheck(checked);
                }
                for (int q = 0; q < goods.size(); q++) {
                    ArrayList<GoodsBean> goodsBeen = goods.get(q);
                    for (int j = 0; j < goodsBeen.size(); j++) {
                        goodsBeen.get(j).setGoodscheck(checked);
                    }
                }
                changesum(goods);
                carAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_js:
                int index = 0;
                for (int q = 0; q < goods.size(); q++) {
                    ArrayList<GoodsBean> goodsBeen = goods.get(q);
                    for (int j = 0; j < goodsBeen.size(); j++) {
                        boolean goodscheck = goodsBeen.get(j).isGoodscheck();
                        if (goodscheck) {
                            index++;
                        }
                    }
                }
                if (index == 0) {
                    Toast.makeText(this, "请选择商品，谢谢", Toast.LENGTH_SHORT).show();
                } else {
//                    Intent intent = new Intent(this, Payd.class);
//                    startActivity(intent);

                }
                break;
        }
    }

    @Override
    public void CarSuccess(CarBean carBean) {
        List<CarBean.DataBean> data = carBean.getData();
        for (int i = 0; i < data.size(); i++) {
            groupBeen.add(new GroupBean(false, data.get(i).getSellerName(), data.get(i).getSellerid()));
            List<CarBean.DataBean.ListBean> list = data.get(i).getList();
            ArrayList<GoodsBean> goodsBeen = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                goodsBeen.add(new GoodsBean(false, list.get(j).getBargainPrice(), list.get(j).getImages(), list.get(j).getTitle(), list.get(j).getSubhead(), list.get(j).getNum(), list.get(j).getPid()));
            }
            goods.add(goodsBeen);
        }
        for (int i = 0; i < carAdapter.getGroupCount(); i++) {
            exlist.expandGroup(i);
        }
        carAdapter.notifyDataSetChanged();
    }

    @Override
    public void CarFaild(Throwable throwable) {

    }

    @Override
    public int getuid() {
        return Caractivity.this.getSharedPreferences("userInfo",Caractivity.this.MODE_PRIVATE).getInt("uid",0);
    }
    //用于格式化十进制数字。
    DecimalFormat df = new DecimalFormat("######0.00");
    //计算总价和数量的方法
    public void changesum(ArrayList<ArrayList<GoodsBean>> childBeen) {
        int count = 0;
        double sum = 0;
        for (List<GoodsBean> i1 : childBeen) {
            for (int r = 0; r < i1.size(); r++) {
                boolean childCb1 = i1.get(r).isGoodscheck();
                if (childCb1) {
                    double price = i1.get(r).getBargainPrice();
                    int num = i1.get(r).getNum();
                    sum += price * num;
                    count++;
                }
            }
        }
        price.setText("￥" + df.format(sum));
        counts.setText(count + "");
    }
    public void deleteShop(int pid) {
        Toast.makeText(this, "aadas", Toast.LENGTH_SHORT).show();
    }
}

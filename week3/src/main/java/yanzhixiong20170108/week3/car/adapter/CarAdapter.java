package yanzhixiong20170108.week3.car.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import yanzhixiong20170108.week3.R;
import yanzhixiong20170108.week3.car.Caractivity;
import yanzhixiong20170108.week3.car.bean.GoodsBean;
import yanzhixiong20170108.week3.car.bean.GroupBean;
import yanzhixiong20170108.week3.car.view.AddDeleteView;

/**
 * author:Created by YanZhiXiong on 2018/1/9.
 */

public class CarAdapter extends BaseExpandableListAdapter{
    Context context;
    List<GroupBean> grouplist;
    ArrayList<ArrayList<GoodsBean>> goodslist;
    Caractivity carActivity;

    public CarAdapter(Context context, List<GroupBean> grouplist, ArrayList<ArrayList<GoodsBean>> goodslist, Caractivity carActivity) {
        this.context = context;
        this.grouplist = grouplist;
        this.goodslist = goodslist;
        this.carActivity = carActivity;
    }

    @Override
    public int getGroupCount() {
        return grouplist.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return goodslist.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return grouplist.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return goodslist.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //父布局
    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        View group_view = View.inflate(context, R.layout.gwc_group_item, null);
        final CheckBox check_group = group_view.findViewById(R.id.check_gwc_group);
        TextView group = group_view.findViewById(R.id.tv_gwc_group);
        check_group.setChecked(grouplist.get(i).isGroupcheck());
        group.setText(grouplist.get(i).getSellerName());
        check_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GroupBean groupBean = grouplist.get(i);
                groupBean.setGroupcheck(check_group.isChecked());
                for (int j = 0; j <grouplist.size() ; j++) {
                    boolean groupcheck = grouplist.get(j).isGroupcheck();
                    if (!groupcheck){
                        carActivity.checkAll.setChecked(false);
                        break;
                    }else {
                        carActivity.checkAll.setChecked(true);
                    }
                }
                ArrayList<GoodsBean> goodsBeen = goodslist.get(i);
                for (int i = 0; i <goodsBeen.size() ; i++) {
                    goodsBeen.get(i).setGoodscheck(check_group.isChecked());
                }
                //计算价格
                carActivity.changesum(goodslist);
                notifyDataSetChanged();
            }
        });
        return group_view;
    }

    //子布局

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.gwc_goods_item, null);
        TextView tv_goods = (TextView) view.findViewById(R.id.tv_gwc_goods);
        TextView price = (TextView) view.findViewById(R.id.tv_gwc_price);
        final CheckBox check_goods = (CheckBox) view.findViewById(R.id.check_gwc_goods);
        ImageView img_goods = (ImageView) view.findViewById(R.id.img_gwc_goods);
        Button btn_delete = (Button) view.findViewById(R.id.btn_gwc_delete);
        final AddDeleteView adv = (AddDeleteView) view.findViewById(R.id.add_delete);
        tv_goods.setText(goodslist.get(groupPosition).get(childPosition).getTitle());
        price.setText(goodslist.get(groupPosition).get(childPosition).getBargainPrice() + "");
        check_goods.setChecked(goodslist.get(groupPosition).get(childPosition).isGoodscheck());
        String images = goodslist.get(groupPosition).get(childPosition).getImages();
        String[] split = images.split("\\|");
        Glide.with(img_goods.getContext()).load(split[0]).into(img_goods);
        adv.setNumber(goodslist.get(groupPosition).get(childPosition).getNum());
        adv.setNumber(goodslist.get(groupPosition).get(childPosition).getNum());
        if (goodslist.get(groupPosition).get(childPosition).isBtn()) {
            btn_delete.setVisibility(View.VISIBLE);
        } else {
            btn_delete.setVisibility(View.INVISIBLE);
        }
        adv.setOnAddDelClickListener(new AddDeleteView.OnAddDelClickListener() {
            @Override
            public void onAddClick(View v) {
                int number = adv.getNumber();
                number++;
                adv.setNumber(number);
                goodslist.get(groupPosition).get(childPosition).setNum(number);
                carActivity.changesum(goodslist);
            }

            @Override
            public void onDelClick(View v) {
                int number = adv.getNumber();
                if (number > 1) {
                    number--;
                }
                adv.setNumber(number);
                goodslist.get(groupPosition).get(childPosition).setNum(number);
                carActivity.changesum(goodslist);
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carActivity.deleteShop(goodslist.get(groupPosition).get(childPosition).getPid());
                int size = goodslist.get(groupPosition).size();
                if (goodslist.get(groupPosition).get(childPosition).isGoodscheck()) {
                    if (size == 1) {
                        goodslist.remove(groupPosition);
                        grouplist.remove(groupPosition);
                    } else {
                        goodslist.get(groupPosition).remove(childPosition);
                    }
                    carActivity.changesum(goodslist);
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "请选择商品。。。", Toast.LENGTH_SHORT).show();
                }
            }
        });
        check_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //定义一个默认flag
                boolean flag = false;
                //获得当前二级列表复选框的状态
                boolean cchecked = check_goods.isChecked();
                //把当前状态存储到二级列表List集合里面
                goodslist.get(groupPosition).get(childPosition).setGoodscheck(cchecked);

                //循环遍历二级列表List集合
                for (List<GoodsBean> i1 : goodslist) {
                    // 按照所有二级列表的item的个数进行循环遍历
                    for (int r = 0; r < i1.size(); r++) {
                        //获取当前二级列表的状态
                        boolean childCb1 = i1.get(r).isGoodscheck();
                        //取反设置 如果为true改为false 如果为false改为true
                        if (!childCb1) {
                            //如果当前二级列表中有一条复选框是false  全选为false
                            carActivity.checkAll.setChecked(false);
                            //如果当前二级列表中有一条复选框是false  一级列表为false
                            grouplist.get(groupPosition).setGroupcheck(false);
                            //flag为true跳出循环
                            flag = true;
                            break;
                        } else {
                            //如果所有的二级列表都为true  全选为true
                            carActivity.checkAll.setChecked(true);
                            //如果所有的二级列表都为true  一级列表为true
                            grouplist.get(groupPosition).setGroupcheck(true);
                        }
                    }
                    //falg为true时跳出循环
                    if (flag) {
                        break;
                    }
                }
                //当前二级列表的总长度
                int size = goodslist.get(groupPosition).size();
                //按照当前二级列表的总长度循环
                for (int x = 0; x < size; x++) {
                    //获得当前二级列表中每一个item的选中状态
                    boolean childCb1 = goodslist.get(groupPosition).get(x).isGoodscheck();
                    //判断
                    if (!childCb1) {
                        //有一个flase 一级列表就设置false  跳出循环
                        grouplist.get(groupPosition).setGroupcheck(false);
                        break;
                    } else {
                        grouplist.get(groupPosition).setGroupcheck(true);
                    }
                }
                //计算价格
                carActivity.changesum(goodslist);
                //刷新适配器
                notifyDataSetChanged();
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}

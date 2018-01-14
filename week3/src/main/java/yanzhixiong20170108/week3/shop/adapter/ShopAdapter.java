package yanzhixiong20170108.week3.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import yanzhixiong20170108.week3.R;
import yanzhixiong20170108.week3.shop.model.bean.ShopBean;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder>{

    Context context;
    List<ShopBean.DataBean> list;

     OnShopClick onShopClick;
    public   interface  OnShopClick{
        void OnShopClick(View view,final int position);
    }

    public void setShopAdapter(OnShopClick onShopClick) {
        this.onShopClick = onShopClick;
    }

    public ShopAdapter(Context context, List<ShopBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_shop, null);
        ShopViewHolder shopViewHolder = new ShopViewHolder(inflate);
        return shopViewHolder;
    }

    @Override
    public void onBindViewHolder(ShopViewHolder holder, final int position) {
        holder.shop_price.setText(list.get(position).getBargainPrice()+"");
        holder.shop_title.setText(list.get(position).getTitle());
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        holder.shop_img.setImageURI(split[0]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onShopClick.OnShopClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ShopViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView shop_img;
        TextView shop_price;
        TextView shop_title;
        public ShopViewHolder(View itemView) {
            super(itemView);
            shop_img=itemView.findViewById(R.id.shop_img);
            shop_price=itemView.findViewById(R.id.shop_price);
            shop_title=itemView.findViewById(R.id.shop_title);
        }
    }
}

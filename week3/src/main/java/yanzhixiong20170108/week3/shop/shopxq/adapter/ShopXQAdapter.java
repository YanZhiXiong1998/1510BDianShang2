package yanzhixiong20170108.week3.shop.shopxq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import yanzhixiong20170108.week3.R;
import yanzhixiong20170108.week3.shop.shopxq.model.bean.ShopXQBean;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public class ShopXQAdapter  extends RecyclerView.Adapter<ShopXQAdapter.ShopXQViewHolder>{
    Context context;
    ShopXQBean shopXQBean;

    public ShopXQAdapter(Context context, ShopXQBean shopXQBean) {
        this.context = context;
        this.shopXQBean = shopXQBean;
    }

    @Override
    public ShopXQViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.shopxq_item, null);
        ShopXQViewHolder shopXQViewHolder = new ShopXQViewHolder(inflate);
        return shopXQViewHolder;
    }

    @Override
    public void onBindViewHolder(ShopXQViewHolder holder, int position) {
        holder.shopxq_title.setText(shopXQBean.getData().getTitle());
        holder.shopxq_price.setText(shopXQBean.getData().getPrice()+"");
        holder.shopxq_name.setText(shopXQBean.getSeller().getName());
        String images = shopXQBean.getData().getImages();
        String[] split = images.split("\\|");
        holder.shopxq_img.setImageURI(split[0]);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ShopXQViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView shopxq_img;
        TextView shopxq_title;
        TextView shopxq_price;
        TextView shopxq_name;
        public ShopXQViewHolder(View itemView) {
            super(itemView);
            shopxq_img=itemView.findViewById(R.id.shpxq_img);
            shopxq_title=itemView.findViewById(R.id.shopxq_title);
            shopxq_price=itemView.findViewById(R.id.shopxq_price);
            shopxq_name=itemView.findViewById(R.id.shopxq_name);
        }
    }
}

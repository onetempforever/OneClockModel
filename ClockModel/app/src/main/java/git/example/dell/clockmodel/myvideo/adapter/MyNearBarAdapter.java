package git.example.dell.clockmodel.myvideo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.bean.NearBarBean;

/**
 * Created by dell on 2018/4/27.
 */

public class MyNearBarAdapter extends RecyclerView.Adapter<MyNearBarAdapter.MyViewHolder> {

    private Context context;
    private List<NearBarBean.DataBean> data;
    private NearItemClickListener nearItemClickListener;

    public MyNearBarAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<NearBarBean.DataBean> data) {
        this.data = data;
       // notifyDataSetChanged();
    }

    public MyNearBarAdapter(Context context, List<NearBarBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.nearbarrecycler_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String icon = data.get(position).getUser().getIcon();
        final int wid = data.get(position).getWid();
        Glide.with(context).load(icon).into(holder.getNearbar_image());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nearItemClickListener!=null){
                    nearItemClickListener.onClick(wid);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView nearbar_image;

        public MyViewHolder(View itemView) {
            super(itemView);
            nearbar_image = itemView.findViewById(R.id.nearbar_image);
        }

        public ImageView getNearbar_image() {
            return nearbar_image;
        }
    }
    public interface NearItemClickListener{
        void onClick(int wid);
    }
    public void setHotItemClickListener(NearItemClickListener nearItemClickListener){
        this.nearItemClickListener=nearItemClickListener;
    }
}

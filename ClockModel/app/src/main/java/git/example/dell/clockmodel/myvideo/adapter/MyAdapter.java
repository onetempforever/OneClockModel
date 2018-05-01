package git.example.dell.clockmodel.myvideo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.myvideo.model.VideoBean;

/**
 * Created by dell on 2018/4/26.
 */

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder>{
    private Context context;
    private List<VideoBean.DataBean> data;
    private HotItemClickListener hotItemClickListener;

    public MyAdapter(Context context, List<VideoBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate( R.layout.hotrecycler_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String cover = data.get(position).getCover();
        Log.e("===onBindViewHolder===","===========");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hotItemClickListener!=null){
                    hotItemClickListener.onClick(position);
                }
            }
        });
        if (cover!=null){
            Glide.with(context).load(cover).into(holder.image);
        }else{
            holder.image.setImageResource(R.drawable.duanzi2);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.hotrecycler_image);
        }
    }
    public interface HotItemClickListener{
        void onClick(int wid);
    }
    public void setHotItemClickListener(HotItemClickListener hotItemClickListener){
        this.hotItemClickListener=hotItemClickListener;
    }
}

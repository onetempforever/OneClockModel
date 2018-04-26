package git.example.dell.clockmodel.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.model.VideoBean;

/**
 * Created by dell on 2018/4/26.
 */

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder>{
    private Context context;
    private List<VideoBean.DataBean> data;

    public MyAdapter(Context context, List<VideoBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.hotrecycler_item, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageView hotrecycler = holder.getHotrecycler();
        String icon = data.get(position).getUser().getIcon();
        Glide.with(context).load(icon).into(hotrecycler);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView hotrecycler;

        public MyViewHolder(View itemView) {
            super(itemView);
            hotrecycler = itemView.findViewById(R.id.hotrecycler_image);
        }

        public ImageView getHotrecycler() {
            return hotrecycler;
        }
    }
}

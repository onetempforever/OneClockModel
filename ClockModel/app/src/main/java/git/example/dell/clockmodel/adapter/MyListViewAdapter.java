package git.example.dell.clockmodel.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;


import java.util.List;


import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.model.RMSPBean;

/**
 * Created by LI on 2018/4/11.
 */

public class MyListViewAdapter extends BaseAdapter implements View.OnClickListener{
    private List<RMSPBean.DataBean> list;
    private Context context;
    private ViewHodel viewHodel;
    private static final String TAG = "MyListViewAdapter";

    public MyListViewAdapter(List<RMSPBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){
            view = View.inflate(context, R.layout.rmlist_itme,null);
            viewHodel = new ViewHodel();
            viewHodel.jzVideoPlayerStandard = (JZVideoPlayerStandard) view.findViewById(R.id.jzplaye);
            viewHodel.userdata = (TextView) view.findViewById(R.id.userdata);
            viewHodel.userimg = (RoundedImageView) view.findViewById(R.id.usertouxiang);
            viewHodel.usertitle = (TextView) view.findViewById(R.id.usertitle);
            viewHodel.username = (TextView) view.findViewById(R.id.username);
            viewHodel.dzimg = (ImageView) view.findViewById(R.id.dzimg);
            viewHodel.xhimg = (ImageView) view.findViewById(R.id.xhimg);
            viewHodel.fximg = (ImageView) view.findViewById(R.id.zzimg);
            viewHodel.plimg = (ImageView) view.findViewById(R.id.plimg);
            viewHodel.dztv = (TextView) view.findViewById(R.id.dz_num);
            viewHodel.xhtv = (TextView) view.findViewById(R.id.xh_num);
            viewHodel.fxtv = (TextView) view.findViewById(R.id.zz_num);
            viewHodel.pltv = (TextView) view.findViewById(R.id.pl_num);
            view.setTag(viewHodel);

        }else {
            viewHodel = (ViewHodel) view.getTag();
        }

        RMSPBean.DataBean dataBean = list.get(i);
        RMSPBean.DataBean.UserBean user = dataBean.getUser();
        String videoUrl = dataBean.getVideoUrl();
        Log.d(TAG, "getView: -----------"+videoUrl);
        String nickname = dataBean.getUser().getNickname();
        Log.d(TAG, "getView: ------"+nickname);
        viewHodel.jzVideoPlayerStandard.setUp(videoUrl, JZVideoPlayer.FULL_SCREEN_NORMAL_DELAY, "");
        Glide.with(context).load(dataBean.getCover()).into(viewHodel.jzVideoPlayerStandard.thumbImageView);
        viewHodel.username.setText(dataBean.getCreateTime());
        Glide.with(context).load(user.getIcon()).into(viewHodel.userimg);
        viewHodel.username.setText(user.getNickname());
        viewHodel.dzimg.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dzimg:
                viewHodel.dzimg.setImageResource(R.drawable.hongxin);
                Log.d(TAG, "onClick: ------------------hongxin");
                break;
            case R.id.plimg:

                break;
            case R.id.zzimg:

                break;
            case R.id.xhimg:

                break;


        }
    }

    class ViewHodel{
        RoundedImageView userimg;
        TextView username;
        TextView userdata;
        TextView usertitle;
        JZVideoPlayerStandard jzVideoPlayerStandard;
        ImageView xhimg;
        ImageView dzimg;
        ImageView fximg;
        ImageView plimg;
        TextView xhtv;
        TextView dztv;
        TextView fxtv;
        TextView pltv;

    }
}

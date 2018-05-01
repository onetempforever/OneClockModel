package git.example.dell.clockmodel.mytuij.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.ldoublem.thumbUplib.ThumbUpView;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.mytuij.model.RMSPBean;
/**
 * Created by LI on 2018/4/11.
 */

public class MyListViewAdapter extends BaseAdapter  {
    private int a = 0;
    private View view;
    private boolean fals = true;
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
            viewHodel.tpv = view.findViewById(R.id.tpv);
            viewHodel.tpv = view.findViewById(R.id.tpv2);
            viewHodel.tpv = view.findViewById(R.id.tpv3);

          /*  viewHodel.img1 = view.findViewById(R.id.h_tuijian_img1);
            viewHodel.img2 = view.findViewById(R.id.h_tuijian_img2);
            viewHodel.img3 = view.findViewById(R.id.h_tuijian_img3);
            viewHodel.img4 = view.findViewById(R.id.h_tuijian_img4);*/
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
        viewHodel.tpv.setUnLikeType(ThumbUpView.LikeType.broken);
        viewHodel.tpv.setCracksColor(Color.rgb(22, 33, 44));
        viewHodel.tpv.setFillColor(Color.rgb(11, 200, 77));
        viewHodel.tpv.setEdgeColor(Color.rgb(33, 3, 219));
        viewHodel.tpv.setOnThumbUp(new ThumbUpView.OnThumbUp() {
            @Override
            public void like(boolean like) {
            Log.d("wwwwwwwwww","ccccccccccc");

            }
        });
        viewHodel.tpv.Like();
        viewHodel.tpv.UnLike();
        return view;
    }

    class ViewHodel{
        RoundedImageView userimg;
        TextView username;
        TextView userdata;
        TextView usertitle;
        JZVideoPlayerStandard jzVideoPlayerStandard;
        ThumbUpView tpv;
        ThumbUpView tpv2;
        ThumbUpView tpv3;
    }


}

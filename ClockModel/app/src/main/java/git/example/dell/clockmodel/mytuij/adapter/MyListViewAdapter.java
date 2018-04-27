package git.example.dell.clockmodel.mytuij.adapter;

import android.animation.ObjectAnimator;
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
import git.example.dell.clockmodel.mytuij.model.RMSPBean;

/**
 * Created by LI on 2018/4/11.
 */

public class MyListViewAdapter extends BaseAdapter implements View.OnClickListener {
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
   /* viewHodel.img1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View view){
        if (fals) {
            fals = false;
            ObjectAnimator animato = ObjectAnimator.ofFloat(viewHodel.img1, "rotation", 0f, 180f);
            animato.setDuration(1000);
            animato.start();
//                ObjectAnimator ani = ObjectAnimator.ofFloat( myViewHolder.img1, "alpha", 1f, 0f);
//                ani.setDuration(1000);//时间1s
//                ani.start();
//                ObjectAnimator ani21 = ObjectAnimator.ofFloat( myViewHolder.img1, "alpha", 0f, 1f);
//                ani21.setDuration(1000);//时间1s
//                ani21.start();
            ObjectAnimator animator = ObjectAnimator.ofFloat(viewHodel.img2, "alpha", 1f, 0f, 1f);
            animator.setDuration(1000);//时间1s
            animator.start();
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(viewHodel.img2, "rotation", 0f, 360f, 0f);
            animator2.setDuration(1000);
            animator2.start();
            ObjectAnimator animator3 = ObjectAnimator.ofFloat(viewHodel.img2, "translationX", 0f, -90f);
            animator3.setDuration(1000);
            animator3.start();
            ObjectAnimator ani1 = ObjectAnimator.ofFloat(viewHodel.img3, "alpha", 1f, 0f, 1f);
            ani1.setDuration(1000);//时间1s
            ani1.start();
            ObjectAnimator ani2 = ObjectAnimator.ofFloat(viewHodel.img3, "rotation", 0f, 360f, 0f);
            ani2.setDuration(1000);
            ani2.start();
            ObjectAnimator ani3 = ObjectAnimator.ofFloat(viewHodel.img3, "translationX", 0f, -180f);
            ani3.setDuration(1000);
            ani3.start();
            ObjectAnimator anim1 = ObjectAnimator.ofFloat(viewHodel.img4, "alpha", 1f, 0f, 1f);
            anim1.setDuration(1000);//时间1s
            anim1.start();
            ObjectAnimator anim2 = ObjectAnimator.ofFloat(viewHodel.img4, "rotation", 0f, 360f, 0f);
            anim2.setDuration(1000);
            anim2.start();
            ObjectAnimator anim3 = ObjectAnimator.ofFloat(viewHodel.img4, "translationX", 0f, -270f);
            anim3.setDuration(1000);
            anim3.start();
        } else {
            fals = true;
            ObjectAnimator anima = ObjectAnimator.ofFloat(viewHodel.img1, "rotation", 180f, 0f);
            anima.setDuration(1000);
            anima.start();
//                ObjectAnimator ani = ObjectAnimator.ofFloat(myViewHolder.img1, "alpha", 0f, 1f);
//                ani.setDuration(1000);//时间1s
//                ani.start();
//                ObjectAnimator ani21 = ObjectAnimator.ofFloat(myViewHolder.img1, "alpha", 1f, 0f);
//                ani21.setDuration(1000);//时间1s
//                ani21.start();
            ObjectAnimator animator = ObjectAnimator.ofFloat(viewHodel.img2, "alpha", 1f, 0f);
            animator.setDuration(1000);//时间1s
            animator.start();
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(viewHodel.img2, "rotation", 0f, 360f, 0f);
            animator2.setDuration(1000);
            animator2.start();
            ObjectAnimator animator3 = ObjectAnimator.ofFloat(viewHodel.img2, "translationX", -90f, 0f);
            animator3.setDuration(1000);
            animator3.start();
            ObjectAnimator ani1 = ObjectAnimator.ofFloat(viewHodel.img3, "alpha", 1f, 0f);
            ani1.setDuration(1000);//时间1s
            ani1.start();
            ObjectAnimator ani2 = ObjectAnimator.ofFloat(viewHodel.img3, "rotation", 0f, 360f, 0f);
            ani2.setDuration(1000);
            ani2.start();
            ObjectAnimator ani3 = ObjectAnimator.ofFloat(viewHodel.img3, "translationX", -180f, 0f);
            ani3.setDuration(1000);
            ani3.start();
            ObjectAnimator anim1 = ObjectAnimator.ofFloat(viewHodel.img4, "alpha", 1f, 0f);
            anim1.setDuration(1000);//时间1s
            anim1.start();
            ObjectAnimator anim2 = ObjectAnimator.ofFloat(viewHodel.img4, "rotation", 0f, 360f, 0f);
            anim2.setDuration(1000);
            anim2.start();
            ObjectAnimator anim3 = ObjectAnimator.ofFloat(viewHodel.img4, "translationX", -270f, 0f);
            anim3.setDuration(1000);
            anim3.start();
        }


    };

    }*/


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
        ImageView img1;
        ImageView img2;
        ImageView img3;
        ImageView img4;

    }
}

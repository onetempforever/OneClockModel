package git.example.dell.clockmodel.duanzi.model;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.bean.GetJokeBean;

/**
 * Created by ASUS on 2018/4/26.
 */

public class HLSAdapter extends RecyclerView.Adapter<HLSAdapter.MyViewHolder> {
    private static final String TAG = "HLSAdapter";
    private final Context context;
    private final List<GetJokeBean.DataBean> list;
    private ObjectAnimator animator;
    private ObjectAnimator fanimator;
    private ObjectAnimator animator1;
    private ObjectAnimator fanimator1;
    private ObjectAnimator animator2;
    private ObjectAnimator fanimator2;
    private ObjectAnimator animator3;
    private ObjectAnimator fanimator3;
    private int a=0;
    private ImageView anim;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;

    public HLSAdapter(List<GetJokeBean.DataBean> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = View.inflate(context, , null);
        View view = LayoutInflater.from(context).inflate(R.layout.duanzi_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ImageView icon = holder.getItem_icon();
        TextView title = holder.getItem_title();
        TextView time = holder.getItem_time();
        anim = holder.getItem_anim();
        TextView list1 = holder.getItem_list();
        img1 = holder.getImg1();
        img2 = holder.getImg1();
        img3 = holder.getImg1();


//        Glide.with(context).load(list1.getImeActionId()).into(icon);
//        Glide.with(context).load(list1.getImeActionId()).into(anim);
       // Log.d(TAG, "onBindViewHolder: "+list.get(position).getContent());
        list1.setText(list.get(position).getContent()+"");
        title.setText(list.get(position).getCreateTime()+"");

        anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                Toast.makeText(context,"点击了我",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private void initData() {
        //-----伸出时的动画
        /*animator = ObjectAnimator.ofFloat(anim, "rotation", 0f, 180f);
        animator1 = ObjectAnimator.ofFloat(img1, "translationX", 0f,-80f);
        animator2 = ObjectAnimator.ofFloat(img2, "translationX", 0f,-160f);
        animator3 = ObjectAnimator.ofFloat(img3, "translationX", 0f,-240f);
        //----缩回时的动画
        fanimator = ObjectAnimator.ofFloat(anim, "rotation", 0f, -180f);
        fanimator1 = ObjectAnimator.ofFloat(img1, "translationX", -80f,0f);
        fanimator2 = ObjectAnimator.ofFloat(img2, "translationX", -160f,0f);
        fanimator3 = ObjectAnimator.ofFloat(img3, "translationX", -240f,0f);

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
//                anim.setImageResource(R.drawable.icon_packup);//动画结束改变图片

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        //给缩回动画设置监听

        fanimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
//                iv1.setImageResource(R.drawable.icon_open);//改变图片
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        anim.setOnClickListener(new View.OnClickListener() {//图片的点击事件
            @Override
            public void onClick(View view) {
                a++;
                if(a%2==1){//第一次点击是实现伸出效果
                    AnimatorSet animSet = new AnimatorSet();//动画集合
                    animSet.play(animator).with(animator1).with(animator2).with(animator3);
                    animSet.setDuration(1000);
                    animSet.start();

                }else{//再点击一次实现缩回效果
                    AnimatorSet animSet1 = new AnimatorSet();//动画集合
                    animSet1.play(fanimator).with(fanimator1).with(fanimator2).with(fanimator3);
                    animSet1.setDuration(1000);
                    animSet1.start();
                }
            }

        });
*/
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView item_icon;
        private final TextView item_title;
        private final TextView item_time;
        private final ImageView item_anim;
        private final TextView item_list;
        private final ImageView img1;
        private final ImageView img2;
        private final ImageView img3;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_icon = itemView.findViewById(R.id.item_icon);
            item_title = itemView.findViewById(R.id.item_title);
            item_time = itemView.findViewById(R.id.item_time);
            item_anim = itemView.findViewById(R.id.item_anim);
            item_list = itemView.findViewById(R.id.item_list);
            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);
            img3 = itemView.findViewById(R.id.img3);

        }

        public ImageView getItem_icon() {
            return item_icon;
        }

        public TextView getItem_title() {
            return item_title;
        }

        public TextView getItem_time() {
            return item_time;
        }

        public ImageView getItem_anim() {
            return item_anim;
        }

        public TextView getItem_list() {
            return item_list;
        }

        public ImageView getImg1() {
            return img1;
        }

        public ImageView getImg2() {
            return img2;
        }

        public ImageView getImg3() {
            return img3;
        }
    }

}


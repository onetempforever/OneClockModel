package git.example.dell.clockmodel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import git.example.dell.clockmodel.fragment.CrosstalkFragment;
import git.example.dell.clockmodel.fragment.RecommendFragment;
import git.example.dell.clockmodel.fragment.VideoFragment;
import git.example.dell.clockmodel.mydrawer.view.activity.QuitLoginctivity;
import git.example.dell.clockmodel.mydrawer.view.activity.Triple_LoginActivity;
import git.example.dell.clockmodel.mydrawer.view.activity.UserInfoActivity;
import git.example.dell.clockmodel.utils.SharedPreferencesUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CrosstalkFragment crosstalkFragment;
    private VideoFragment videoFragment;
    private RecommendFragment recommendFragment;
    private RadioGroup rg;
    private LinearLayout user;
    private ImageView head_img;
    private DrawerLayout drawerLayout;
    private TextView user_tv;
    private LinearLayout quit_login;
    private RelativeLayout rel;

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        //获取控件
        initview();
        //设置DrawerLayout宽高
        setDrawerAdaptive();
        //Fragment Show Hide add
        AllFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Quit_Login:

                Intent intent1 = new Intent(this, QuitLoginctivity.class);
                startActivity(intent1);


                break;
            case R.id.head_img:

                Boolean isChecked = (Boolean) SharedPreferencesUtils.getParam(this, "isChecked", false);

                if (isChecked){

                    Intent intent = new Intent(this, UserInfoActivity.class);
                    startActivity(intent);

                }else{

                    Intent intent = new Intent(this, Triple_LoginActivity.class);
                    startActivity(intent);

                }


                break;
        }

    }

    private void setDrawerAdaptive() {
        final WindowManager manager = this.getWindowManager();
        //得出屏幕宽度
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int widthPixels = outMetrics.widthPixels;
        //重新计算高度
        ViewGroup.LayoutParams layoutParams = rel.getLayoutParams();
        layoutParams.width = (int) (0.778 * widthPixels);
        rel.setLayoutParams(layoutParams);

    }

    private void initview() {
        rg = findViewById(R.id.rg);
        //用户ID
        user = findViewById(R.id.user);
        head_img = findViewById(R.id.head_img);
        user_tv = findViewById(R.id.user_tv);
        quit_login = findViewById(R.id.Quit_Login);
        rel = findViewById(R.id.rel);
        drawerLayout = findViewById(R.id.drlayout);

        head_img.setOnClickListener(this);
        quit_login.setOnClickListener(this);
        user.setOnClickListener(this);
    }

    private void AllFragment() {

        //创建RecommendFragment对象
        recommendFragment = new RecommendFragment();

        //开启事务
        getSupportFragmentManager().beginTransaction().add(R.id.fl,recommendFragment).commit();
        //设置监听
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //隐藏所有Fragment
                hideFragments();

                switch (i) {
                    case R.id.rb0:
                        getSupportFragmentManager().beginTransaction().show(recommendFragment).commit();
                        Log.e("onclick","one");

                        break;
                    case R.id.rb1:

                        if (crosstalkFragment == null) {
                            crosstalkFragment = new CrosstalkFragment();

                            getSupportFragmentManager().beginTransaction().add(R.id.fl, crosstalkFragment).commit();

                        } else {
                            getSupportFragmentManager().beginTransaction().show(crosstalkFragment).commit();
                        }
                        Log.e("onclick","two");
                        break;
                    case R.id.rb2:
                        if (videoFragment == null) {
                            videoFragment = new VideoFragment();

                            getSupportFragmentManager().beginTransaction().add(R.id.fl, videoFragment).commit();
                        } else {
                            getSupportFragmentManager().beginTransaction().show(videoFragment).commit();
                        }
                        Log.e("onclick","three");
                        break;
                }
            }
        });
    }

    private void hideFragments(){

        // 这个地方只需要用一个管理就可以 比如你写一个本书 ，都写完了再保存  刚刚是写一行保存一行 可能会出错 具体的错 我也不清楚
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (recommendFragment!=null&&recommendFragment.isAdded()){
            fragmentTransaction.hide(recommendFragment);
        }
        if (crosstalkFragment!=null&&crosstalkFragment.isAdded()){
            fragmentTransaction.hide(crosstalkFragment);
        }
        if (videoFragment!=null&&videoFragment.isAdded()){
            fragmentTransaction.hide(videoFragment);
        }
        fragmentTransaction .commit();
        /* private void hideFragments(){
        if (recommendFragment!=null&&recommendFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(recommendFragment).commit();
        }
        if (crosstalkFragment!=null&&crosstalkFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(crosstalkFragment).commit();
        }
        if (videoFragment!=null&&videoFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(videoFragment).commit();
        }

    }*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean isChecked = (boolean) SharedPreferencesUtils.getParam(this, "isChecked", false);
        if (isChecked) {
            String icon = (String) SharedPreferencesUtils.getParam(this, "icon", "");
            String nickname = (String) SharedPreferencesUtils.getParam(this, "nickname", "");
            /*head_img.setImageURI(Uri.parse(icon))*/;
            Glide.with(this).load(icon).into(head_img);
            user_tv.setText(nickname);
        } else {
            head_img.setImageURI(Uri.parse("res://com.example.hp.quartertext/" + R.mipmap.touxiang));
            user_tv.setText("椰汁奶茶");
        }
    }


}

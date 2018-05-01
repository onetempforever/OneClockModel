package git.example.dell.clockmodel;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import git.example.dell.clockmodel.fragment.CrosstalkFragment;
import git.example.dell.clockmodel.fragment.RecommendFragment;
import git.example.dell.clockmodel.fragment.VideoFragment;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件
        initview();

        AllFragment();

        //设置DrawerLayout宽高
       // setDrawerAdaptive();



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user:
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
        //获取当前屏幕宽高
        WindowManager windowManager = this.getWindowManager();
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        //获取布局宽高并进行设置
        ViewGroup.LayoutParams layoutParams = drawerLayout.getLayoutParams();
        layoutParams.height=height;
        layoutParams.width=width/3*2;
        drawerLayout.setLayoutParams(layoutParams);
    }

    private void initview() {
        rg = findViewById(R.id.rg);
        //用户ID
        user = findViewById(R.id.user);
        head_img = findViewById(R.id.head_img);
        user_tv = findViewById(R.id.user_tv);
        drawerLayout = findViewById(R.id.drlayout);

        head_img.setOnClickListener(this);
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

        // 事务只能提交一次
        fragmentTransaction.commit();

    }
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

    @Override
    protected void onResume() {
        super.onResume();
        boolean isChecked = (boolean) SharedPreferencesUtils.getParam(this, "isChecked", false);
        if (isChecked) {
            String icon = (String) SharedPreferencesUtils.getParam(this, "icon", "");
            String nickname = (String) SharedPreferencesUtils.getParam(this, "nickname", "");
            head_img.setImageURI(Uri.parse(icon));
            user_tv.setText(nickname);
        } else {
            head_img.setImageURI(Uri.parse("res://com.example.hp.quartertext/" + R.mipmap.touxiang));
            user_tv.setText("椰汁奶茶");
        }
    }


}

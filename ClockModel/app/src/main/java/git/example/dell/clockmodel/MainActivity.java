package git.example.dell.clockmodel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import git.example.dell.clockmodel.fragment.CrosstalkFragment;
import git.example.dell.clockmodel.fragment.RecommendFragment;
import git.example.dell.clockmodel.fragment.VideoFragment;
import git.example.dell.clockmodel.utils.RetrofitUtils;

public class MainActivity extends AppCompatActivity {

    private CrosstalkFragment crosstalkFragment;
    private VideoFragment videoFragment;
    private RecommendFragment recommendFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AllFragment();


    }
    private void AllFragment() {
        //获取控件
        RadioGroup rg = findViewById(R.id.rg);
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

                        break;
                    case R.id.rb1:

                        if (crosstalkFragment == null) {
                            crosstalkFragment = new CrosstalkFragment();

                            getSupportFragmentManager().beginTransaction().add(R.id.fl, crosstalkFragment).commit();

                        } else {
                            getSupportFragmentManager().beginTransaction().show(crosstalkFragment).commit();
                        }
                        break;
                    case R.id.rb2:
                        if (videoFragment == null) {
                            videoFragment = new VideoFragment();

                            getSupportFragmentManager().beginTransaction().add(R.id.fl, videoFragment).commit();
                        } else {
                            getSupportFragmentManager().beginTransaction().show(videoFragment).commit();
                        }
                        break;
                }
            }
        });
    }

    private void hideFragments(){
        if (recommendFragment!=null&&recommendFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(recommendFragment).commit();
        }
        if (crosstalkFragment!=null&&crosstalkFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(crosstalkFragment).commit();
        }
        if (videoFragment!=null&&videoFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().hide(videoFragment).commit();
        }

    }
}
